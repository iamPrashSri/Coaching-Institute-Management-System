/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package liveproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
import oracle.jdbc.driver.OracleDriver;

/**
 *
 * @author Hp
 */
public class Select_Subject3 extends javax.swing.JPanel {

    /**
     * Creates new form Select_Subject3
     */
    public Select_Subject3() {
        try {
            initComponents();
            OracleDriver od=new OracleDriver();
            DriverManager.registerDriver(od);
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
            
            PreparedStatement stmt=conn.prepareStatement("select name from subjects order by subject_id");
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                Object subject=rs.getString(1);
                jComboBox1.addItem(subject);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Select_Subject3.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("Select Subject");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String subject=jComboBox1.getSelectedItem().toString();
        try
      {  
         OracleDriver od=new OracleDriver();
         DriverManager.registerDriver(od);
         Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
      
         PreparedStatement stmt=conn.prepareStatement("select teacher_all_info.teacher_id,fname,lname,email_id,batch_id,start_time,end_time "
         + "from teacher_all_info,teachers_batches where teacher_all_info.teacher_id=teachers_batches.teacher_id and teacher_all_info.subject=?");
         stmt.setString(1, subject);
         ResultSet rs=stmt.executeQuery();
         Batch_Details2.returnInstance2().returnTableInstance().setModel(DbUtils.resultSetToTableModel(rs));
         stmt.close();
         rs.close();
      }
      catch(Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
