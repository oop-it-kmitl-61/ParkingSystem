/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Owen
 */
public class Pnl_Register extends javax.swing.JPanel {
    private MainUser mu;
    
    public Pnl_Register() {
        initComponents();
    }

   Pnl_Register(MainUser mu) {
        this.mu = mu;
        initComponents();
    }
   
    public boolean checkUser(String user1){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean check = false;
        String sql = "select * from adminandstaffdata where user=?";
        
        try{
            ps = MyConnection.getConnection().prepareStatement(sql);
            ps.setString(1, user1);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                check = true;         
            }
        }catch(SQLException ex){
            
        }
        
        return check;
    }
   
    public void clearTF(){
	tf_fname.setText("Firstname");
	tf_lastname.setText("Lastname");
	tf_license.setText("License plate");
	tf_phonenumber.setText("Phone number");
	tf_conpass.setText("Password");
	tf_user.setText("Username");
	tf_pass.setText("Password");

   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_fname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_phonenumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_license = new javax.swing.JTextField();
        button1 = new java.awt.Button();
        jLabel5 = new javax.swing.JLabel();
        tf_lastname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_user = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bn_isadmin = new javax.swing.JCheckBox();
        bn_isstaff = new javax.swing.JCheckBox();
        bn_ismember = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        tf_pass = new javax.swing.JPasswordField();
        tf_conpass = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(153, 153, 255));
        setMinimumSize(new java.awt.Dimension(710, 624));
        setPreferredSize(new java.awt.Dimension(710, 624));

        jPanel1.setBackground(new java.awt.Color(62, 16, 136));
        jPanel1.setForeground(new java.awt.Color(255, 255, 254));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 254));
        jLabel3.setText("Register");

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
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        button1.setActionCommand("Sign up");
        button1.setBackground(new java.awt.Color(64, 64, 64));
        button1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Sign up");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(35, 43, 43));
        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 43, 43));
        jLabel5.setText("Lastname");

        tf_lastname.setBackground(new java.awt.Color(35, 43, 43));
        tf_lastname.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_lastname.setForeground(new java.awt.Color(255, 255, 254));
        tf_lastname.setText("Lastname");
        tf_lastname.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_lastname.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_lastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_lastnameFocusGained(evt);
            }
        });
        tf_lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_lastnameActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(35, 43, 43));
        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(35, 43, 43));
        jLabel4.setText("Username");

        tf_user.setBackground(new java.awt.Color(35, 43, 43));
        tf_user.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_user.setForeground(new java.awt.Color(254, 255, 255));
        tf_user.setText("Username");
        tf_user.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_user.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_user.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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

        jLabel9.setBackground(new java.awt.Color(35, 43, 43));
        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(35, 43, 43));
        jLabel9.setText("Password");

        bn_isadmin.setBackground(new java.awt.Color(153, 153, 255));
        bn_isadmin.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        bn_isadmin.setForeground(new java.awt.Color(35, 43, 43));
        bn_isadmin.setText("Admin");
        bn_isadmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_isadminMouseClicked(evt);
            }
        });

        bn_isstaff.setBackground(new java.awt.Color(153, 153, 255));
        bn_isstaff.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        bn_isstaff.setForeground(new java.awt.Color(35, 43, 43));
        bn_isstaff.setText("Staff");
        bn_isstaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_isstaffMouseClicked(evt);
            }
        });

        bn_ismember.setBackground(new java.awt.Color(153, 153, 255));
        bn_ismember.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        bn_ismember.setForeground(new java.awt.Color(35, 43, 43));
        bn_ismember.setText("Member");
        bn_ismember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_ismemberMouseClicked(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(35, 43, 43));
        jLabel10.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(35, 43, 43));
        jLabel10.setText("Confirm Password");

        tf_pass.setBackground(new java.awt.Color(35, 43, 43));
        tf_pass.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_pass.setForeground(new java.awt.Color(255, 255, 254));
        tf_pass.setText("Password");
        tf_pass.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_pass.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_passFocusGained(evt);
            }
        });

        tf_conpass.setBackground(new java.awt.Color(35, 43, 43));
        tf_conpass.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_conpass.setForeground(new java.awt.Color(255, 255, 254));
        tf_conpass.setText("Password");
        tf_conpass.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tf_conpass.setCaretColor(new java.awt.Color(255, 255, 254));
        tf_conpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_conpassFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(tf_fname)
                            .addComponent(tf_user)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bn_isadmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(19, 19, 19)
                                .addComponent(bn_isstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bn_ismember, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addComponent(tf_conpass, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(tf_lastname)
                            .addComponent(jLabel8)
                            .addComponent(tf_phonenumber, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(tf_pass))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(tf_license, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 276, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bn_isadmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bn_isstaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bn_ismember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_pass)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_conpass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_license, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tf_fnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_fnameFocusGained
        if(tf_fname.getText().equals("Firstname")){
            tf_fname.setText("");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_license.getText().equals("")){
            tf_license.setText("License plate");
        }
        if(tf_lastname.getText().equals("")){
            tf_lastname.setText("Lastname");
        }
        if(tf_user.getText().equals("")){
            tf_user.setText("Username");
        }
        if(tf_pass.getText().equals("")){
            tf_pass.setText("Password");
        }
        if(tf_conpass.getText().equals("")){
            tf_conpass.setText("Password");
        }
    }//GEN-LAST:event_tf_fnameFocusGained

    private void tf_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_fnameActionPerformed

    private void tf_phonenumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_phonenumberFocusGained
        if(tf_phonenumber.getText().equals("Phone number")){
            tf_phonenumber.setText("");
        }
        if(tf_license.getText().equals("")){
            tf_license.setText("License plate");
        }
        if(tf_lastname.getText().equals("")){
            tf_lastname.setText("Lastname");
        }
        if(tf_user.getText().equals("")){
            tf_user.setText("Username");
        }
        if(tf_pass.getText().equals("")){
            tf_pass.setText("Password");
        }
        if(tf_conpass.getText().equals("")){
            tf_conpass.setText("Password");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
    }//GEN-LAST:event_tf_phonenumberFocusGained

    private void tf_phonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_phonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_phonenumberActionPerformed

    private void tf_licenseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_licenseFocusGained
        if(tf_license.getText().equals("License plate")){
            tf_license.setText("");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_lastname.getText().equals("")){
            tf_lastname.setText("Lastname");
        }
        if(tf_user.getText().equals("")){
            tf_user.setText("Username");
        }
        if(tf_pass.getText().equals("")){
            tf_pass.setText("Password");
        }
        if(tf_conpass.getText().equals("")){
            tf_conpass.setText("Password");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
    }//GEN-LAST:event_tf_licenseFocusGained

    private void tf_licenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_licenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_licenseActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        String fname1 = tf_fname.getText();
	String lname1 = tf_lastname.getText();
        String license1 = tf_license.getText();
        String phonenumber1 = tf_phonenumber.getText();
	String user1 = tf_user.getText();
	String pass1 = tf_pass.getText();
	String conpass1 = tf_conpass.getText();

        if(fname1.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter firstname");
        }
	else if(lname1.equals("")){
	    JOptionPane.showMessageDialog(null, "Please enter lastname");
	}
        else if(license1.equals("") && bn_ismember.isSelected()){
            JOptionPane.showMessageDialog(null, "Please enter car license");
        }
        else if(phonenumber1.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter phonenumber");
        }
	else if(!conpass1.equals(pass1)){
	    JOptionPane.showMessageDialog(null, "Password not match");
	}
	else if(checkUser(user1) == true && (bn_ismember.isSelected()||bn_isadmin.isSelected())){
	    JOptionPane.showMessageDialog(null, "This username is already exists");
	}
        else{
	    if(bn_ismember.isSelected()){
		PreparedStatement ps= null;
		String sql = "INSERT INTO `memberdata`(`firstname`, `lastname`, `phone`, `license`) VALUES (?,?,?,?)";
		try {
		    ps = MyConnection.getConnection().prepareStatement(sql);
		    ps.setString(1, fname1);
		    ps.setString(2, lname1);
		    ps.setString(3, phonenumber1);
		    ps.setString(4, license1);
		    if(ps.executeUpdate() > 0){
			JOptionPane.showMessageDialog(null, "Add Member Success");
			clearTF();
		    }
		} catch (SQLException ex) {
		    JOptionPane.showMessageDialog(null,ex);
		}
	    }
	    else if(bn_isadmin.isSelected()){
		PreparedStatement ps= null;
		String sql = "INSERT INTO `adminandstaffdata`(`firstname`, `lastname`, `phone`, `user`, `pass`, `rank`) VALUES (?,?,?,?,?,'admin')";
		try {
		    ps = MyConnection.getConnection().prepareStatement(sql);
		    ps.setString(1, fname1);
		    ps.setString(2, lname1);
		    ps.setString(3, phonenumber1);
		    ps.setString(4, user1);
		    ps.setString(5, pass1);
		    if(ps.executeUpdate() > 0){
			JOptionPane.showMessageDialog(null, "Add Admin Success");
			clearTF();
		    }
		} catch (SQLException ex) {
		    JOptionPane.showMessageDialog(null,ex);
		}
	    }
	    else if(bn_isstaff.isSelected()){
		PreparedStatement ps= null;
		String sql = "INSERT INTO `adminandstaffdata`(`firstname`, `lastname`, `phone`, `user`, `pass`, `rank`) VALUES (?,?,?,?,?,'staff')";
		try {
		    ps = MyConnection.getConnection().prepareStatement(sql);
		    ps.setString(1, fname1);
		    ps.setString(2, lname1);
		    ps.setString(3, phonenumber1);
		    ps.setString(4, user1);
		    ps.setString(5, pass1);
		    if(ps.executeUpdate() > 0){
			JOptionPane.showMessageDialog(null, "Add Staff Success");
			clearTF();
		    }
		} catch (SQLException ex) {
		    JOptionPane.showMessageDialog(null,ex);
		}
	    }
	    else{
		JOptionPane.showMessageDialog(null, "Please Select Rank");
	    }
	}
    }//GEN-LAST:event_button1ActionPerformed

    private void tf_lastnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_lastnameFocusGained
        if(tf_lastname.getText().equals("Lastname")){
            tf_lastname.setText("");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_license.getText().equals("")){
            tf_license.setText("License plate");
        }
        if(tf_user.getText().equals("")){
            tf_user.setText("Username");
        }
        if(tf_pass.getText().equals("")){
            tf_pass.setText("Password");
        }
        if(tf_conpass.getText().equals("")){
            tf_conpass.setText("Password");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
    }//GEN-LAST:event_tf_lastnameFocusGained

    private void tf_lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_lastnameActionPerformed

    private void tf_userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_userFocusGained
        if(tf_user.getText().equals("Username")){
            tf_user.setText("");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_license.getText().equals("")){
            tf_license.setText("License plate");
        }
        if(tf_lastname.getText().equals("")){
            tf_lastname.setText("Lastname");
        }
        if(tf_pass.getText().equals("")){
            tf_pass.setText("Password");
        }
        if(tf_conpass.getText().equals("")){
            tf_conpass.setText("Password");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
    }//GEN-LAST:event_tf_userFocusGained

    private void tf_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_userActionPerformed

    private void bn_isadminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_isadminMouseClicked
        bn_isstaff.setSelected(false);
	bn_ismember.setSelected(false);
	tf_user.setEditable(true);
	tf_user.setBackground(new Color(35,43,43));
	tf_pass.setEditable(true);
	tf_pass.setBackground(new Color(35,43,43));
	tf_conpass.setEditable(true);
	tf_conpass.setBackground(new Color(35,43,43));
	tf_license.setEditable(false);
	tf_license.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_bn_isadminMouseClicked

    private void bn_isstaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_isstaffMouseClicked
        bn_isadmin.setSelected(false);
	bn_ismember.setSelected(false);
	tf_user.setEditable(true);
	tf_conpass.setEditable(true);
	tf_conpass.setBackground(new Color(35,43,43));
	tf_user.setBackground(new Color(35,43,43));
	tf_pass.setEditable(true);
	tf_pass.setBackground(new Color(35,43,43));
	tf_license.setEditable(false);
	tf_license.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_bn_isstaffMouseClicked

    private void bn_ismemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_ismemberMouseClicked
        bn_isadmin.setSelected(false);
	bn_isstaff.setSelected(false);
	tf_user.setEditable(false);
	tf_user.setBackground(new Color(102,102,102));
	tf_pass.setEditable(false);
	tf_pass.setBackground(new Color(102,102,102));
	tf_license.setEditable(true);
	tf_license.setBackground(new Color(35,43,43));
	tf_conpass.setEditable(false);
	tf_conpass.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_bn_ismemberMouseClicked

    private void tf_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_passFocusGained
        if(tf_pass.getText().equals("Password")){
            tf_pass.setText("");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_license.getText().equals("")){
            tf_license.setText("License plate");
        }
        if(tf_lastname.getText().equals("")){
            tf_lastname.setText("Lastname");
        }
        if(tf_user.getText().equals("")){
            tf_user.setText("Username");
        }
        if(tf_conpass.getText().equals("")){
            tf_conpass.setText("Password");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
    }//GEN-LAST:event_tf_passFocusGained

    private void tf_conpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_conpassFocusGained
        if(tf_conpass.getText().equals("Password")){
            tf_conpass.setText("");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("Phone number");
        }
        if(tf_license.getText().equals("")){
            tf_license.setText("License plate");
        }
        if(tf_lastname.getText().equals("")){
            tf_lastname.setText("Lastname");
        }
        if(tf_user.getText().equals("")){
            tf_user.setText("Username");
        }
        if(tf_pass.getText().equals("")){
            tf_pass.setText("Password");
        }
        if(tf_fname.getText().equals("")){
            tf_fname.setText("Firstname");
        }
    }//GEN-LAST:event_tf_conpassFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox bn_isadmin;
    private javax.swing.JCheckBox bn_ismember;
    private javax.swing.JCheckBox bn_isstaff;
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField tf_conpass;
    private javax.swing.JTextField tf_fname;
    private javax.swing.JTextField tf_lastname;
    private javax.swing.JTextField tf_license;
    private javax.swing.JPasswordField tf_pass;
    private javax.swing.JTextField tf_phonenumber;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables
}
