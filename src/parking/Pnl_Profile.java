/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author Owen
 */
public class Pnl_Profile extends javax.swing.JPanel {
    private MainUser mu;
    Object selected_car;
    public Pnl_Profile() {
        initComponents();
    }

    Pnl_Profile(MainUser mu) {
        this.mu = mu;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tf_fname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tf_user = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_license = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_phonenumber = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchUser = new javax.swing.JButton();
        searchPhone = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tf_lname = new javax.swing.JTextField();
        bn_isaddminorstaff = new javax.swing.JCheckBox();
        bn_ismember = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        tf_rank = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 255));
        setForeground(new java.awt.Color(35, 43, 43));
        setMinimumSize(new java.awt.Dimension(710, 624));
        setPreferredSize(new java.awt.Dimension(710, 624));
        setRequestFocusEnabled(false);

        jLabel2.setBackground(new java.awt.Color(35, 43, 43));
        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 43, 43));
        jLabel2.setText("Firstname");

        tf_fname.setBackground(new java.awt.Color(35, 43, 43));
        tf_fname.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_fname.setForeground(new java.awt.Color(255, 255, 254));
        tf_fname.setText("Firstname");
        tf_fname.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_fname.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_fname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_fnameFocusGained(evt);
            }
        });
        tf_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fnameActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(35, 43, 43));
        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 43, 43));
        jLabel1.setText("Username");

        tf_user.setBackground(new java.awt.Color(35, 43, 43));
        tf_user.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_user.setForeground(new java.awt.Color(255, 255, 254));
        tf_user.setText("Username");
        tf_user.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_user.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_userFocusGained(evt);
            }
        });
        tf_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_userActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(35, 43, 43));
        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(35, 43, 43));
        jLabel7.setText("License plate");

        tf_license.setBackground(new java.awt.Color(35, 43, 43));
        tf_license.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_license.setForeground(new java.awt.Color(255, 255, 254));
        tf_license.setText("License plate");
        tf_license.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_license.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_license.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_licenseFocusGained(evt);
            }
        });
        tf_license.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_licenseActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(35, 43, 43));
        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(35, 43, 43));
        jLabel8.setText("Phone number");

        tf_phonenumber.setBackground(new java.awt.Color(35, 43, 43));
        tf_phonenumber.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_phonenumber.setForeground(new java.awt.Color(255, 255, 254));
        tf_phonenumber.setText("Phone number");
        tf_phonenumber.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_phonenumber.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_phonenumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_phonenumberFocusGained(evt);
            }
        });
        tf_phonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_phonenumberActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(64, 64, 65));
        update.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 254));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(62, 16, 136));
        jPanel1.setForeground(new java.awt.Color(255, 255, 254));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 254));
        jLabel3.setText("PROFILE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(270, 270, 270))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchUser.setBackground(new java.awt.Color(64, 64, 65));
        searchUser.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        searchUser.setForeground(new java.awt.Color(255, 255, 254));
        searchUser.setText("search");
        searchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserActionPerformed(evt);
            }
        });

        searchPhone.setBackground(new java.awt.Color(64, 64, 65));
        searchPhone.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        searchPhone.setForeground(new java.awt.Color(255, 255, 254));
        searchPhone.setText("search");
        searchPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPhoneActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(35, 43, 43));
        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 43, 43));
        jLabel5.setText("Lastname");

        tf_lname.setBackground(new java.awt.Color(35, 43, 43));
        tf_lname.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_lname.setForeground(new java.awt.Color(255, 255, 254));
        tf_lname.setText("Lastname");
        tf_lname.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_lname.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_lname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_lnameFocusGained(evt);
            }
        });

        bn_isaddminorstaff.setBackground(new java.awt.Color(204, 204, 255));
        bn_isaddminorstaff.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bn_isaddminorstaff.setForeground(new java.awt.Color(35, 43, 43));
        bn_isaddminorstaff.setText("Admin Or Staff");
        bn_isaddminorstaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_isaddminorstaffMouseClicked(evt);
            }
        });

        bn_ismember.setBackground(new java.awt.Color(204, 204, 255));
        bn_ismember.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bn_ismember.setForeground(new java.awt.Color(35, 43, 43));
        bn_ismember.setText("Member");
        bn_ismember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_ismemberMouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(35, 43, 43));
        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(35, 43, 43));
        jLabel4.setText("Rank");

        tf_rank.setBackground(new java.awt.Color(35, 43, 43));
        tf_rank.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_rank.setForeground(new java.awt.Color(255, 255, 254));
        tf_rank.setText("Rank");
        tf_rank.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_rank.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_rank.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_rankFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bn_ismember)
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(searchPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tf_lname, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_fname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_license, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(tf_rank, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(bn_isaddminorstaff)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bn_isaddminorstaff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bn_ismember))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_license, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_rank, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tf_fnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_fnameFocusGained
        if(bn_isaddminorstaff.isSelected()){
            tf_license.setText("License plate");
        }
        if(bn_ismember.isSelected()){
            tf_user.setText("Username");
            tf_rank.setText("Rank");
        }
        if(tf_fname.getText().equals("Firstname")){
            tf_fname.setText("");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_license.getText().equals("") && !(bn_isaddminorstaff.isSelected())){
            tf_license.setText("License plate");
        }
        if(tf_lname.getText().equals("")){
            tf_lname.setText("Lastname");
        }
        if(tf_user.getText().equals("") && !(bn_ismember.isSelected())){
            tf_user.setText("Username");
        }
        if(tf_rank.getText().equals("") && !(bn_ismember.isSelected())){
            tf_rank.setText("Rank");
        }
    }//GEN-LAST:event_tf_fnameFocusGained

    private void tf_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_fnameActionPerformed

    private void tf_userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_userFocusGained
        if(bn_isaddminorstaff.isSelected()){
            tf_license.setText("License plate");
        }
        if(bn_ismember.isSelected()){
            tf_user.setText("Username");
            tf_rank.setText("Rank");
        }
        if(tf_user.getText().equals("Username") && !(bn_ismember.isSelected())){
            tf_user.setText("");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_license.getText().equals("") && !(bn_isaddminorstaff.isSelected())){
            tf_license.setText("License plate");
        }
        if(tf_lname.getText().equals("")){
            tf_lname.setText("Lastname");
        }
        if(tf_rank.getText().equals("") && !(bn_ismember.isSelected())){
            tf_rank.setText("Rank");
        }
    }//GEN-LAST:event_tf_userFocusGained

    private void tf_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_userActionPerformed

    private void tf_licenseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_licenseFocusGained
        if(bn_isaddminorstaff.isSelected()){
            tf_license.setText("License plate");
        }
        if(bn_ismember.isSelected()){
            tf_user.setText("Username");
            tf_rank.setText("Rank");
        }
        if(tf_license.getText().equals("License plate") && !(bn_isaddminorstaff.isSelected())){
            tf_license.setText("");
        }
        if(tf_user.getText().equals("") && !(bn_ismember.isSelected())){
            tf_user.setText("Username");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_lname.getText().equals("")){
            tf_lname.setText("Lastname");
        }
        if(tf_rank.getText().equals("") && !(bn_ismember.isSelected())){
            tf_rank.setText("Rank");
        }
    }//GEN-LAST:event_tf_licenseFocusGained

    private void tf_licenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_licenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_licenseActionPerformed

    private void tf_phonenumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_phonenumberFocusGained
        if(bn_isaddminorstaff.isSelected()){
            tf_license.setText("License plate");
        }
        if(bn_ismember.isSelected()){
            tf_user.setText("Username");
            tf_rank.setText("Rank");
        }
        if(tf_phonenumber.getText().equals("Phone number")){
            tf_phonenumber.setText("");
        }
        if(tf_user.getText().equals("") && !(bn_ismember.isSelected())){
            tf_user.setText("Username");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
        if(tf_license.getText().equals("") && !(bn_isaddminorstaff.isSelected())){
            tf_license.setText("License plate");
        }
        if(tf_lname.getText().equals("")){
            tf_lname.setText("Lastname");
        }
        if(tf_rank.getText().equals("") && !(bn_ismember.isSelected())){
            tf_rank.setText("Rank");
        }
    }//GEN-LAST:event_tf_phonenumberFocusGained

    private void tf_phonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_phonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_phonenumberActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
	if(bn_isaddminorstaff.isSelected()){
	    try{
	    String sql = "UPDATE `adminandstaffdata` SET `firstname` = ?, `lastname` = ?, `phone` = ?, `rank` = ? WHERE `user` = ?";
	    Connection con = MyConnection.getConnection();
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, tf_fname.getText());
	    ps.setString(2, tf_lname.getText());
	    ps.setString(3, tf_phonenumber.getText());
	    ps.setString(4, tf_rank.getText());
	    ps.setString(5, tf_user.getText()); 
	    if(ps.executeUpdate() > 0){
		JOptionPane.showMessageDialog(null, "Update data success");	
	    }
	    }catch(Exception ex){
		System.out.println(ex);
	    }
	}else if(bn_ismember.isSelected()){
	    try{
	    String sql = "UPDATE `memberdata` SET  firstname = ?, lastname = ?, license = ? WHERE phone = ?";
	    Connection con = MyConnection.getConnection();
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, tf_fname.getText());
	    ps.setString(2, tf_lname.getText());
	    ps.setString(3, tf_license.getText());
	    ps.setString(4, tf_phonenumber.getText()); 
	    if(ps.executeUpdate() > 0){
		JOptionPane.showMessageDialog(null, "Update data success");	
	    }
	    }catch(Exception ex){
		System.out.println(ex);
	    }
	}else{
	    JOptionPane.showMessageDialog(null, "Please select rank");
	}
    }//GEN-LAST:event_updateActionPerformed

    private void searchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserActionPerformed
	if(bn_isaddminorstaff.isSelected()){
	    try{
	    String sql = "SELECT * FROM `adminandstaffdata` WHERE user = ?";
	    Connection con = MyConnection.getConnection();
	    PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, tf_user.getText());
	    ResultSet rs_data = pst.executeQuery();
	    if(rs_data.next()){
		JOptionPane.showMessageDialog(null, "Found data from this username");
		tf_phonenumber.setText(rs_data.getString("phone"));
		tf_fname.setText(rs_data.getString("firstname"));
		tf_lname.setText(rs_data.getString("lastname"));
		tf_rank.setText(rs_data.getString("rank"));
	    }else{
		JOptionPane.showMessageDialog(null, "Not found data from this username");
	    }
	}catch(Exception e){
	    System.out.println(e);
	}
	}else{
	    JOptionPane.showMessageDialog(null, "Please select rank");
	}
    }//GEN-LAST:event_searchUserActionPerformed

    private void searchPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPhoneActionPerformed
        if(bn_isaddminorstaff.isSelected()){
	    try{
	    String sql = "SELECT * FROM `adminandstaffdata` WHERE phone = ?";
	    Connection con = MyConnection.getConnection();
	    PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, tf_phonenumber.getText());
	    ResultSet rs_data = pst.executeQuery();
		if(rs_data.next()){
		    JOptionPane.showMessageDialog(null, "Found data from this username");
		    tf_user.setText(rs_data.getString("user"));
		    tf_fname.setText(rs_data.getString("firstname"));
		    tf_lname.setText(rs_data.getString("lastname"));
		    tf_rank.setText(rs_data.getString("rank"));
		}else{
		    JOptionPane.showMessageDialog(null, "Not found data from this username");
		}
	    }catch(Exception e){
		System.out.println(e);
	    }
	}else if(bn_ismember.isSelected()){
	    try{
	    String sql = "SELECT * FROM `memberdata` WHERE phone = ?";
	    Connection con = MyConnection.getConnection();
	    PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, tf_phonenumber.getText());
	    ResultSet rs_data = pst.executeQuery();
	    if(rs_data.next()){
		JOptionPane.showMessageDialog(null, "Found data from this number");
		tf_fname.setText(rs_data.getString("firstname"));
		tf_lname.setText(rs_data.getString("lastname"));
		tf_license.setText(rs_data.getString("license"));
	    }else{
		JOptionPane.showMessageDialog(null, "Not found data from this phonenumber");
	    }
	    }catch(Exception e){
		System.out.println(e);
	    }
	}
	else{
	    JOptionPane.showMessageDialog(null, "Please select rank");
	}
    }//GEN-LAST:event_searchPhoneActionPerformed

    private void tf_lnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_lnameFocusGained
        if(bn_isaddminorstaff.isSelected()){
            tf_license.setText("License plate");
        }
        if(bn_ismember.isSelected()){
            tf_user.setText("Username");
            tf_rank.setText("Rank");
        }
        if(tf_lname.getText().equals("Lastname")){
            tf_lname.setText("");
        }
        if(tf_user.getText().equals("") && !(bn_ismember.isSelected())){
            tf_user.setText("Username");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_license.getText().equals("") && !(bn_isaddminorstaff.isSelected())){
            tf_license.setText("License plate");
        }
        if(tf_rank.getText().equals("") && !(bn_ismember.isSelected())){
            tf_rank.setText("Rank");
        }
    }//GEN-LAST:event_tf_lnameFocusGained

    private void bn_isaddminorstaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_isaddminorstaffMouseClicked
        bn_isaddminorstaff.setSelected(true);
	bn_ismember.setSelected(false);
	searchUser.setEnabled(true);
	tf_user.setEditable(true);
	tf_user.setBackground(new Color(35,43,43));
	tf_license.setEditable(false);
	tf_license.setBackground(new Color(102,102,102));
	tf_user.setText("Username");
	tf_license.setText("License plate");
	tf_rank.setEditable(true);
	tf_rank.setBackground(new Color(35,43,43));
    }//GEN-LAST:event_bn_isaddminorstaffMouseClicked

    private void bn_ismemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_ismemberMouseClicked
        bn_isaddminorstaff.setSelected(false);
	searchUser.setEnabled(false);
	bn_ismember.setSelected(true);
	tf_user.setEditable(false);
	tf_user.setBackground(new Color(102,102,102));
	tf_license.setEditable(true);
	tf_license.setBackground(new Color(35,43,43));
	tf_license.setText("License plate");
	tf_user.setText("Username");
	tf_rank.setText("Rank");
	tf_rank.setEditable(false);
	tf_rank.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_bn_ismemberMouseClicked

    private void tf_rankFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_rankFocusGained
        if(bn_isaddminorstaff.isSelected()){
            tf_license.setText("License plate");
        }
        if(bn_ismember.isSelected()){
            tf_user.setText("Username");
            tf_rank.setText("Rank");
        }
        if(tf_rank.getText().equals("Rank") && !(bn_ismember.isSelected())){
            tf_rank.setText("");
        }
        if(tf_lname.getText().equals("")){
            tf_lname.setText("Lastname");
        }
        if(tf_user.getText().equals("") && !(bn_ismember.isSelected())){
            tf_user.setText("Username");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_license.getText().equals("") && !(bn_isaddminorstaff.isSelected())){
            tf_license.setText("License plate");
        }
        
    }//GEN-LAST:event_tf_rankFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox bn_isaddminorstaff;
    private javax.swing.JCheckBox bn_ismember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton searchPhone;
    private javax.swing.JButton searchUser;
    private javax.swing.JTextField tf_fname;
    private javax.swing.JTextField tf_license;
    private javax.swing.JTextField tf_lname;
    private javax.swing.JTextField tf_phonenumber;
    private javax.swing.JTextField tf_rank;
    private javax.swing.JTextField tf_user;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
