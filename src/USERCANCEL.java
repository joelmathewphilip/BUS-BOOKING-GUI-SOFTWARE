
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class USERCANCEL extends javax.swing.JFrame {

    /**
     * Creates new form USERCANCEL
     */
    String mydriver="com.mysql.jdbc.Driver";  
        String myconn="jdbc:mysql://localhost:3306/bus?zeroDateTimeBehavior=convertToNull";
  	String UID ="root";
  	String pwd = "";
        String dname;
        String usename;
        String busid;
        String duser;
        USERDISPLAY obj2;
        
    public USERCANCEL() {
        initComponents();
        try
         {
            
            Connection con=DriverManager.getConnection(myconn, UID, pwd);  
            Class.forName(mydriver);
            Statement s=con.createStatement();     
            ResultSet rs1=s.executeQuery("Select * from LogDetails");
        while(rs1.next())
        {
            dname=rs1.getString("ACTIVE");
            }
         text.setText(dname);
         }
        catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,e);
      }
    }
    public USERCANCEL(USERDISPLAY obj){
        initComponents();
        obj2 = obj;
         try
         {
            
            Connection con=DriverManager.getConnection(myconn, UID, pwd);  
            Class.forName(mydriver);
            Statement s=con.createStatement();     
            ResultSet rs1=s.executeQuery("Select * from LogDetails");
        while(rs1.next())
        {
            dname=rs1.getString("ACTIVE");
            }
         text.setText(dname);
         }
        catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,e);
      }
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

        jLabel1 = new javax.swing.JLabel();
        text = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        text2 = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("cancelFrame"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("WELCOME:");

        text.setText("jLabel2");

        btnLogout.setText("LOGOUT");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnLogoutMouseReleased(evt);
            }
        });

        jLabel3.setText("PNR NUMBER TO BE CANCELLED:");

        btnSubmit.setText("SUBMIT");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSubmitMouseReleased(evt);
            }
        });

        btnMenu.setText("MENU");
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMenuMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSubmit)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text)
                    .addComponent(btnLogout))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnMenu))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseReleased
        // TODO add your handling code here:
       
          new LOGINPAGE().setVisible(true);
          obj2.setVisible(false);
          this.setVisible(false);
          
    }//GEN-LAST:event_btnLogoutMouseReleased

    private void btnSubmitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseReleased
        // TODO add your handling code here:
        String t2=text2.getText();
        String x=null;
        int y=0;
        
        try
        {
         Connection con=DriverManager.getConnection(myconn, UID, pwd);  
         Class.forName(mydriver); 
         Statement ps3=con.createStatement();
         ResultSet rs3=ps3.executeQuery("Select * from logindetails where Name='"+dname+"'");
         while(rs3.next())
         {
             x=rs3.getString("Username");
         }
         Statement ps=con.createStatement();
         ResultSet rs=ps.executeQuery("Select * from bus1 where NAME='"+x+"'");
         while(rs.next())
         {
             if(t2.equals(rs.getString("PNR")))
             {
                 y=1;
             }
         }
        if(y==0)
        {
            JOptionPane.showMessageDialog(null,"THE BOOKING DOES NOT EXIST");
        }
        else
            if(y==1)
            {
                Statement ps2=con.createStatement();
                ps2.executeUpdate("DELETE FROM bus1 WHERE PNR='"+t2+"'");
                JOptionPane.showMessageDialog(null,"SUCCESSFULLY DELETED");
                new USER().setVisible(true);
                obj2.setVisible(false);
                close();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btnSubmitMouseReleased

    private void btnMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseReleased
        // TODO add your handling code here:
        new USER().setVisible(true);
        obj2.setVisible(false);
        close();
    }//GEN-LAST:event_btnMenuMouseReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(USERCANCEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(USERCANCEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(USERCANCEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(USERCANCEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new USERCANCEL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel text;
    private javax.swing.JTextField text2;
    // End of variables declaration//GEN-END:variables
}
