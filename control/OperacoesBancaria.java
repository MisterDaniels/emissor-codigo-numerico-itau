
package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class OperacoesBancaria {
    
    // Data
    DateTimeFormatter dataFormato = DateTimeFormat.forPattern("ddMMyyyy"); // Formato de Data
    String dataBase = "07101997"; // Data Base 07/10/1997 - FIXO
    
    // Constantes
    int codBanco = 341; // Banco Itaú
    int codMoeda = 9; // Real
    
    // Dados Recebidos
    String codAgencia;
    String codCarteira;
    String codNossoNumero;
    String codConta;
    String dataVencimento;
    long valor;
    
    // Dados Calculados
    int dacCampo, dacCodigoBarras;
    int [] dacs;   
    int vencimentoCalculado;
    String valorCalculado;
    
    // Para construção do código
    StringBuilder numerosCodBarras = new StringBuilder();
    
    // Para printar no arquivo
    File file = new File("código.txt");
    FileOutputStream output;
    
    // Construtor que recebe dados do formulário
    public OperacoesBancaria(String codAgencia, String codCarteira, String codNossoNumero, String codConta,
            String dataVencimento, String valor) {
                
        this.codAgencia = codAgencia;
        this.codCarteira = codCarteira;
        this.codNossoNumero = codNossoNumero;
        this.codConta = codConta;
        
        this.dataVencimento = dataVencimento.replace("/", ""); // Remove as '/' da máscara do form da data
        this.valor = Long.parseLong(valor.replaceAll("\\.*\\,*", "")); // Remove todos os caracters especiais da máscara do form do valor
        
        construirCodBarras();
                
    }
    
    public void construirCodBarras() {
        
        // _________ CÁLCULOS
        
        this.vencimentoCalculado = calcularVencimento();
        
        // Coloca 0's para compensar a falta do valor das 10 casas
        StringBuilder construtorValor = new StringBuilder();
        for(int i = 0; i < 10-String.valueOf(this.valor).length(); i++) {
            construtorValor.insert(0, 0);
        }
        
        this.valorCalculado = construtorValor.toString() + this.valor;
        
        this.dacCampo = calcularDACCampo();
        
        this.dacs = calcularDAC();
        
        this.dacCodigoBarras = calcularCodBarras();
        
        // _________ CRIAÇÃO DO CÓDIGO
        
        // Campo 1
        numerosCodBarras.append(this.codBanco); // ### Código do Banco
        numerosCodBarras.append(this.codMoeda); // # Código da Moeda
        numerosCodBarras.append(this.codCarteira.substring(0, 1)); // # Primeiro Código da Carteira de Cobrança
        numerosCodBarras.append(".");
        
        numerosCodBarras.append(this.codCarteira.substring(1, 3)); // ## Segundo e Terceiro Código da Carteira de Cobrança    
        numerosCodBarras.append(this.codNossoNumero.substring(0, 2)); // ## 2 Primeiros Digitos do Nosso Número
        numerosCodBarras.append(this.dacs[0]); // # DAC do Campo 1
        numerosCodBarras.append("\t");
        
        // Campo 2
        numerosCodBarras.append(this.codNossoNumero.substring(2, 7)); // ##### Restante do Nosso Número
        numerosCodBarras.append(".");
        
        numerosCodBarras.append(this.codNossoNumero.substring(7, 8)); // # Último número do Nosso Número
        numerosCodBarras.append(this.dacCampo); // # DAC do Campo [Agência/Conta/Carteira/Nosso Número]
        numerosCodBarras.append(this.codAgencia.substring(0, 3)); // ### 3 primeiros números da agência
        numerosCodBarras.append(this.dacs[1]); // # DAC do Campo 2
        numerosCodBarras.append("\t");
        
        // Campo 3
        numerosCodBarras.append(this.codAgencia.substring(3, 4)); // # Último digito da agência
        numerosCodBarras.append(this.codConta.substring(0, 4)); // #### 4 Primeiros Número da Conta Corrente + DAC
        numerosCodBarras.append(".");
        
        numerosCodBarras.append(this.codConta.substring(4, 5) + this.codConta.substring(6, 7)); // ## 2 Últimos Número da Conta Corrente + DAC
        numerosCodBarras.append("000"); // ### 0's não utilizados
        numerosCodBarras.append(this.dacs[2]); // # DAC do Campo 3
        numerosCodBarras.append("\t");
        
        // Campo 4
        numerosCodBarras.append(this.dacCodigoBarras); // # DAC do Código de Barras
        numerosCodBarras.append("\t"); // TAB Divide os Campos
        
        // Campo 5
        numerosCodBarras.append(this.vencimentoCalculado); // #### Fator de Vencimento
        numerosCodBarras.append(this.valorCalculado); // ########## Os valores
        
        // Escreve no TXT o código já formatado
        try {
            
            this.output = new FileOutputStream(this.file);
            this.output.write(numerosCodBarras.toString().getBytes());
            this.output.close();
            
        } catch (IOException ex) {
            
            Logger.getLogger(OperacoesBancaria.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    // Calcula o fator de vencimento
    private int calcularVencimento() {
                        
        DateTime tempoBase = dataFormato.parseDateTime(this.dataBase);
        DateTime tempoVencimento = dataFormato.parseDateTime(String.valueOf(this.dataVencimento));
        
        return Days.daysBetween(tempoBase, tempoVencimento).getDays();
                
    }
    
    // Calcula o DAC do campo agência / conta / carteira / nosso número
    private int calcularDACCampo() {
        
        StringBuilder baraCalcular;
        int valor = 0;
        
        // Caso específico citado na documentação
        if (this.codCarteira.equals("126") || this.codCarteira.equals("131") || this.codCarteira.equals("146") || this.codCarteira.equals("150") ||
                this.codCarteira.equals("168")) {
            
            baraCalcular = new StringBuilder(this.codCarteira + this.codNossoNumero);
            
        } else { // Para o resto
        
            baraCalcular = new StringBuilder(this.codAgencia + this.codConta.substring(0, 5) +
                this.codCarteira + this.codNossoNumero);
        
        }
        
        // Multiplica pelo módulo 10
        for (int i = 0; i <= baraCalcular.length()-1; i++) {
                
            valor += (Character.getNumericValue(baraCalcular.charAt(i)) * 1);
                
            // Para a última posição
            if (i+1 == baraCalcular.length()) {
                
                break;
                
            }
                
            valor += (Character.getNumericValue(baraCalcular.charAt(i+1)) * 2);
                
            i++;
                
        }
            
        valor = valor % 10;
        valor = 10 - valor;
            
        return valor;
        
        
    }
    
    // Calcula os DAC'S do campo
    private int[] calcularDAC() {
        
        int [] dacs = new int[3];
        
        // Para calcular os números da barra
        StringBuilder barraRecebida = new StringBuilder(this.codBanco + this.codMoeda + this.codCarteira +
                this.codNossoNumero + this.dacCampo + this.codAgencia + this.codConta + "000");
        
        StringBuilder barraCalculada = new StringBuilder();
        // Multiplica com os valores do módulo
        for(int i = 0; i <= barraRecebida.length()-1; i++) {
                                    
            barraCalculada.append(Character.getNumericValue(barraRecebida.charAt(i)) * 2);
                        
            // Para a última posição
            if (i+1 == barraRecebida.length()) {
                
                break;
                
            }
            
            barraCalculada.append(Character.getNumericValue(barraRecebida.charAt(i+1)) * 1);
                        
            i++;
            
        }
        
        dacs[0] = (int) Character.getNumericValue(barraCalculada.charAt(0)) + Character.getNumericValue(barraCalculada.charAt(1)) 
                + Character.getNumericValue(barraCalculada.charAt(2)) + Character.getNumericValue(barraCalculada.charAt(3)) 
                + Character.getNumericValue(barraCalculada.charAt(4)) + Character.getNumericValue(barraCalculada.charAt(5)) 
                + Character.getNumericValue(barraCalculada.charAt(6)) + Character.getNumericValue(barraCalculada.charAt(7)) 
                + Character.getNumericValue(barraCalculada.charAt(8));
                
        dacs[1] = (int) Character.getNumericValue(barraCalculada.charAt(9)) + Character.getNumericValue(barraCalculada.charAt(10))
                + Character.getNumericValue(barraCalculada.charAt(11)) + Character.getNumericValue(barraCalculada.charAt(12)) 
                + Character.getNumericValue(barraCalculada.charAt(13)) + Character.getNumericValue(barraCalculada.charAt(14)) 
                + Character.getNumericValue(barraCalculada.charAt(15)) + Character.getNumericValue(barraCalculada.charAt(16)) 
                + Character.getNumericValue(barraCalculada.charAt(17)) + Character.getNumericValue(barraCalculada.charAt(18));
                
        dacs[2] = (int) Character.getNumericValue(barraCalculada.charAt(19)) + Character.getNumericValue(barraCalculada.charAt(20))
                + Character.getNumericValue(barraCalculada.charAt(21)) + Character.getNumericValue(barraCalculada.charAt(22))
                + Character.getNumericValue(barraCalculada.charAt(23)) + Character.getNumericValue(barraCalculada.charAt(24)) 
                + Character.getNumericValue(barraCalculada.charAt(25)) + Character.getNumericValue(barraCalculada.charAt(26))
                + Character.getNumericValue(barraCalculada.charAt(27)) + Character.getNumericValue(barraCalculada.charAt(28));
                
        dacs[0] = dacs[0] % 10;
        dacs[0] = 10 - dacs[0];
        
        dacs[1] = dacs[1] % 10;
        dacs[1] = 10 - dacs[1];
        
        dacs[2] = dacs[2] % 10;
        dacs[2] = 10 - dacs[2];
             
        return dacs;
        
    }
    
    // Calcula o DAC do código de barras
    private int calcularCodBarras() {
        
        StringBuilder calcularBarra = new StringBuilder(this.codBanco + this.codMoeda + this.calcularVencimento() +
                this.valorCalculado + this.codCarteira + this.codNossoNumero + this.dacCampo + this.codAgencia +
                this.codConta + "000");
        
        int valor = 0;
        int [] modulo11 = {4,3,2,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2}; // FIXO
        // Multiplica pelo Módulo 11
        for(int i = 0; i <= calcularBarra.length()-1; i++) {
            
            valor += Character.getNumericValue(calcularBarra.charAt(i)) * modulo11[i];
            
        }
        
        valor = valor % 11;
        valor = 11 - valor;
        
        return valor;
        
    }
    
}
