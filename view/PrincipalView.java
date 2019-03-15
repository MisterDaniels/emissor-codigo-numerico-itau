
package view;

import control.OperacoesBancaria;
import javax.swing.ImageIcon;

public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
        
        initComponents();
        
        // Mostrar Logo
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/logo.png")));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_title = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        lb_bankCode = new javax.swing.JLabel();
        tf_bankCode = new javax.swing.JTextField();
        lb_codeCoin = new javax.swing.JLabel();
        cb_codeCoin = new javax.swing.JComboBox<>();
        lb_codeWallet = new javax.swing.JLabel();
        lb_ourNumber = new javax.swing.JLabel();
        lb_agency = new javax.swing.JLabel();
        lb_account = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_data = new javax.swing.JFormattedTextField();
        tf_conta = new javax.swing.JFormattedTextField();
        tf_codCarteira = new javax.swing.JFormattedTextField();
        tf_agencia = new javax.swing.JFormattedTextField();
        tf_nossoNumero = new javax.swing.JFormattedTextField();
        lb_value = new javax.swing.JLabel();
        tf_valor = new javax.swing.JFormattedTextField();
        bt_complete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_title.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_title.setText("Emissor de Boleto Itaú");

        lb_bankCode.setText("Código do Banco:");

        tf_bankCode.setEditable(false);
        tf_bankCode.setText("341");
        tf_bankCode.setToolTipText("");

        lb_codeCoin.setText("Código da Moeda:");

        cb_codeCoin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BRL" }));

        lb_codeWallet.setText("Código da Carteira de Cobrança:");

        lb_ourNumber.setText("Nosso Número:");

        lb_agency.setText("Agência:");

        lb_account.setText("Conta Corrente:");

        jLabel2.setText("Data de Vencimento:");

        tf_data.setColumns(8);
        try {
            tf_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tf_conta.setColumns(6);
        try {
            tf_conta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tf_codCarteira.setColumns(3);
        try {
            tf_codCarteira.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tf_agencia.setColumns(4);
        try {
            tf_agencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tf_nossoNumero.setColumns(8);
        try {
            tf_nossoNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lb_value.setText("Valor:");

        tf_valor.setColumns(12);
        tf_valor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        bt_complete.setText("Emitir");
        bt_complete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_completeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_ourNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nossoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_account)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_conta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lb_value)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 32, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_codeWallet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_codCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_agency)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_agencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_bankCode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_bankCode, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_codeCoin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_codeCoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_complete, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lb_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_bankCode)
                            .addComponent(tf_bankCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_codeCoin)
                            .addComponent(cb_codeCoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_codeWallet)
                            .addComponent(tf_codCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_agency)
                            .addComponent(tf_agencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_ourNumber)
                            .addComponent(tf_nossoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_account)
                            .addComponent(tf_conta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_value)
                            .addComponent(tf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(bt_complete)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_completeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_completeActionPerformed
 
        // Chama a classe do .Controller para o cálculo
        OperacoesBancaria banco = new OperacoesBancaria(tf_agencia.getText(), tf_codCarteira.getText(), tf_nossoNumero.getText(),
                tf_conta.getText(), tf_data.getText(), tf_valor.getText());
        
    }//GEN-LAST:event_bt_completeActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_complete;
    private javax.swing.JComboBox<String> cb_codeCoin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_account;
    private javax.swing.JLabel lb_agency;
    private javax.swing.JLabel lb_bankCode;
    private javax.swing.JLabel lb_codeCoin;
    private javax.swing.JLabel lb_codeWallet;
    private javax.swing.JLabel lb_ourNumber;
    private javax.swing.JLabel lb_title;
    private javax.swing.JLabel lb_value;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JFormattedTextField tf_agencia;
    private javax.swing.JTextField tf_bankCode;
    private javax.swing.JFormattedTextField tf_codCarteira;
    private javax.swing.JFormattedTextField tf_conta;
    private javax.swing.JFormattedTextField tf_data;
    private javax.swing.JFormattedTextField tf_nossoNumero;
    private javax.swing.JFormattedTextField tf_valor;
    // End of variables declaration//GEN-END:variables
}
