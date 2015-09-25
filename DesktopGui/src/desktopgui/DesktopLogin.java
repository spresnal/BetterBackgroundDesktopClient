/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopgui;

import org.springframework.util.StringUtils;
/**
 *
 * @author Chris
 */
public class DesktopLogin extends javax.swing.JFrame {

    /**
     * Creates new form DesktopLogin
     */
    public DesktopLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inUserName = new javax.swing.JTextField();
        inPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnAuthenticate = new javax.swing.JButton();
        loginStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inUserNameActionPerformed(evt);
            }
        });

        inPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inPasswordActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Username and Password:");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        BtnAuthenticate.setText("Sign In");
        BtnAuthenticate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAuthenticateActionPerformed(evt);
            }
        });

        loginStatus.setText("Press \"sign in\" once entries are filled in");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BtnAuthenticate))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(inPassword)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(loginStatus)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(loginStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addComponent(BtnAuthenticate)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inPasswordActionPerformed

    private void BtnAuthenticateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAuthenticateActionPerformed
        // TODO
        // Parse Username and Password to meteor.
        // Open new window if valid else display new text.
        char[] char_password = inPassword.getPassword();
        String str_username = inUserName.getText();
        
        if( loginValidCheck(char_password, str_username) ) {
            //Create new window
            dispose();
            new DesktopUIMain().setVisible(true);
        }
    }//GEN-LAST:event_BtnAuthenticateActionPerformed

    public boolean loginValidCheck(char[] char_array, String username) {
        String password = new String(char_array);
        
        // Check if either entry is empty
        if (password.length() <= 0 || username.length() <= 0) {
            loginStatus.setText("Can't have blank entry");
            return false;
        }
        
        // Remove all whitespaces, they are not allowed
        int original_len = username.length();
        username = username.replaceAll("\\s+", "");
        if (original_len > username.length()) {
            loginStatus.setText("White spaces are not allowed");
            return false;
        }
        
        original_len = password.length();
        password = password.replaceAll("\\s+", "");
        if (original_len > password.length()) {
            loginStatus.setText("White spaces are not allowed");
            return false;
        }
        
        // Ensure there is exactly ONE "@" and ONE "." in the username
        if(StringUtils.countOccurrencesOf(username, ".") != 1 || StringUtils.countOccurrencesOf(username, "@") != 1) {
            loginStatus.setText("Invalid Username");
            return false;
        }
        String[] unsupportedChars = {"^", "&", "*"};

        // Check for unsupported characters
        for (int i = 0; i < unsupportedChars.length; i++) {
            if(StringUtils.countOccurrencesOf(username, unsupportedChars[i]) >= 1) {
                loginStatus.setText("An unsupported Character was parsed");
                return false;
            }
        }
        
        
        
        
        return true;
    }
    
    
    
    
    private void inUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inUserNameActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DesktopLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesktopLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesktopLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesktopLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesktopLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAuthenticate;
    private javax.swing.JPasswordField inPassword;
    private javax.swing.JTextField inUserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel loginStatus;
    // End of variables declaration//GEN-END:variables
}
