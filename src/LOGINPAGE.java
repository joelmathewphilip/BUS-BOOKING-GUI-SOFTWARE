/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
public class LOGINPAGE extends javax.swing.JFrame {

    /**
     * Creates new form LOGINPAGE
     */
    String mydriver="com.mysql.jdbc.Driver";  
   String myconn="jdbc:mysql://localhost:3306/bus?zeroDateTimeBehavior=convertToNull";
   String UID ="root";
   String pwd = "";
   String namep;
    public LOGINPAGE() {
        initComponents();
    }
    public void close()
    {
        WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        register = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        text2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text2ActionPerformed(evt);
            }
        });

        jLabel1.setText("PASSWORD");

        jLabel2.setText("USERNAME");

        login.setText("LOGIN");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginMouseReleased(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        register.setText("REGISTER");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                registerMouseReleased(evt);
            }
        });
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        jLabel3.setText("LOGIN PAGE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(login)
                .addGap(18, 18, 18)
                .addComponent(register)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(register)
                    .addComponent(login))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        String t1=text1.getText();
        String t2=text2.getText().toString();   //CANNOT USE GETPASSWORD AS PRINTING IT GIVES AN ENCRYPTED TEXT AND CANNOT BE COMPARED
        String dname,dpassword,duser=null;
        int y=0,r=0;
        int z=0;
        try
         {
            Connection con=DriverManager.getConnection(myconn, UID, pwd);  
            Class.forName(mydriver);
            Statement s=con.createStatement();     
            ResultSet rs=s.executeQuery("Select * from LoginDetails");
        while(rs.next())
        {
            dname=rs.getString("Username");
            dpassword=rs.getString("Password");
            
            if(dname.equals(t1))
                z=1; //INDICATES THE USER NAME IS PRESENT IN THE DATABASE.
            if(t1.equals("admin")&& (t2.equals("12345")))  //ENTERED INPUT IS OF ADMIN USERNAME
            {
               r=1;
                
            }
            if ((dname.equals(t1)) && (dpassword.equals(t2)))
               { 
                y=1;
                duser=rs.getString("Name");
                break;
                }
            }
         if(y==1 && r!=1)
         {
             JOptionPane.showMessageDialog(null,"Login Successful");
             try
             {
                  s=con.createStatement();
                  s.executeUpdate("Delete from LogDetails");
                  s.executeUpdate("Insert into LogDetails (ACTIVE) VALUES ('"+duser+"')");
                  close();
                  new USER().setVisible(true);   //LOGGING IN AS USER
             }
             catch(Exception e)
             {
                 JOptionPane.showMessageDialog(null,"THE LOG DETAILS TABLE COULD NOT BE UPDATED");
             }
             
          }
             else
             if(y==0 && z==1 && r!=1)
             {
               JOptionPane.showMessageDialog(null,"INCORRECT USERNAME OR PASSWORD");
             }
         else
              if(z==0 && r!=1)
                  JOptionPane.showMessageDialog(null,"USER NOT REGISTERED. PLEASE REGISTER");
         else
               if(r==1)
                  {
             try
             {
                  JOptionPane.showMessageDialog(null,"Login Successful");
                  s=con.createStatement();
                  s.executeUpdate("Delete from LogDetails");
                  s.executeUpdate("Insert into LogDetails (ACTIVE) VALUES ('admin')");
                  close();
                  new ADMIN().setVisible(true); //LOGGING IN AS ADMINISTRATOR
             }
             catch(Exception e)
             {
                 JOptionPane.showMessageDialog(null,"THE LOG DETAILS TABLE COULD NOT BE UPDATED");
             }
                  }
         }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_loginActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_registerActionPerformed

    private void text2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text2ActionPerformed

    private void registerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseReleased
        // TODO add your handling code here:
        close();
        new REGISTER().setVisible(true);
       //WORK IN PROGRESS
    }//GEN-LAST:event_registerMouseReleased

    private void loginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_loginMouseReleased

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
            java.util.logging.Logger.getLogger(LOGINPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGINPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGINPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGINPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGINPAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login;
    private javax.swing.JButton register;
    private javax.swing.JTextField text1;
    private javax.swing.JPasswordField text2;
    // End of variables declaration//GEN-END:variables
}
