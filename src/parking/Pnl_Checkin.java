/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Owen
 */
public class Pnl_Checkin extends javax.swing.JPanel {
    private MainUser mu;
    String time;
    Object[] row = new Object[8];
    DefaultTableModel model;
    public Pnl_Checkin() {
        initComponents();
    }

    Pnl_Checkin(MainUser mu) {
        this.mu = mu;
        initComponents();
	time = new SimpleDateFormat("dd/MM/YYYY").format(Calendar.getInstance().getTime());
	tf_Date.setText(time);
	model = (DefaultTableModel)Table_checkout.getModel();
	Table_checkout.setAutoCreateRowSorter(true);
	updateTable();
    }
    
    
    public void updateTable(){
	model.setRowCount(0);
	try{
	    String sql = "SELECT * FROM `bookdata` WHERE `datein` = ? AND `check` = '0'";
	    Connection con = MyConnection.getConnection();
	    PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, tf_Date.getText());
	    ResultSet rs_checkout = pst.executeQuery();
	    while(rs_checkout.next()){
		row[0] = rs_checkout.getString("lot");
		row[1] = rs_checkout.getString("datein");
		row[2] = rs_checkout.getString("timein");
		row[3] = rs_checkout.getString("timeout");
		row[4] = rs_checkout.getString("name");
		row[5] = rs_checkout.getString("license");
		row[6] = rs_checkout.getString("phone");
		row[7] = rs_checkout.getString("other");
		model.addRow(row);
	    }   
	}catch(Exception e){
	    System.out.println(e);
	}

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_checkout = new javax.swing.JTable();
        bn_re = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_Date = new javax.swing.JTextField();
        bn_checkin = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));
        setMaximumSize(new java.awt.Dimension(710, 624));
        setMinimumSize(new java.awt.Dimension(710, 624));
        setPreferredSize(new java.awt.Dimension(710, 624));

        jPanel1.setBackground(new java.awt.Color(62, 16, 136));
        jPanel1.setForeground(new java.awt.Color(255, 255, 254));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 254));
        jLabel3.setText("Check In");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        Table_checkout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "lot", "Date In", "Time In", "Time Out", "Name", "License", "Phone", "Other"
            }
        ));
        jScrollPane2.setViewportView(Table_checkout);

        bn_re.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        bn_re.setText("Refresh");
        bn_re.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn_reActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel1.setText("Date: ");

        tf_Date.setEditable(false);

        bn_checkin.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        bn_checkin.setText("CheckIn");
        bn_checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn_checkinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(bn_re, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(bn_checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bn_re, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bn_checkin))
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bn_reActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn_reActionPerformed
        updateTable();
    }//GEN-LAST:event_bn_reActionPerformed

    private void bn_checkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn_checkinActionPerformed
	int i = Table_checkout.getSelectedRow();
	String lot = (String) Table_checkout.getValueAt(i, 0);
	String datein = (String) Table_checkout.getValueAt(i, 1);
	String timein = (String) Table_checkout.getValueAt(i, 2);
	String timeout = (String) Table_checkout.getValueAt(i, 3);
	String name = (String) Table_checkout.getValueAt(i, 4);
	String license = (String) Table_checkout.getValueAt(i, 5);
	String phone = (String) Table_checkout.getValueAt(i, 6);
	String other = (String) Table_checkout.getValueAt(i, 7);
	
	
	CheckInConfirm checkcon = new CheckInConfirm(lot, datein, timein, timeout, name, license, phone, other);
	checkcon.setVisible(true);
	
    }//GEN-LAST:event_bn_checkinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_checkout;
    private javax.swing.JButton bn_checkin;
    private javax.swing.JButton bn_re;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tf_Date;
    // End of variables declaration//GEN-END:variables
}
