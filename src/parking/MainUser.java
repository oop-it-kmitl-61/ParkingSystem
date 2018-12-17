/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author itisowen_
 */
public class MainUser extends javax.swing.JFrame {
    Pnl_lot f1;
    Pnl_Profile profile;
    Pnl_Checkout checkout;
    Pnl_Register addcar;
    Pnl_Checkin checkin;
    private String user, isAdmin;
    private String bn_homec = "1", bn_profilec = "0", bn_checkoutc = "0", bn_addcarc = "0", bn_checkinc = "0";
    private Connection con = null;
    private PreparedStatement pst, ps = null;
    private ResultSet rs_form, rs_license, rs_slot, rs_name, rs_checkout = null;
    
    public MainUser(String user, String isAdmin) {
        initComponents();
	this.user = user;
	this.isAdmin = isAdmin;
	System.out.println(this.isAdmin);
	System.out.println(this.user);
        GridBagLayout layout = new GridBagLayout();
        profile = new Pnl_Profile(this);
        checkout = new Pnl_Checkout(this);
        addcar = new Pnl_Register(this);
//	f1 = new Pnl_Floor1(this.user);
	f1 = new Pnl_lot();
	checkin = new Pnl_Checkin(this);
        multiPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        multiPanel.add(profile, c);
        multiPanel.add(checkout, c);
        multiPanel.add(addcar, c);
	multiPanel.add(f1, c);
	multiPanel.add(checkin, c);
	if(this.isAdmin == "admin"){
	    f1.setVisible(true);
	    profile.setVisible(false);
	    checkout.setVisible(false);
	    addcar.setVisible(false);
	    checkin.setVisible(false);
	    bn_Home.setBackground(new Color(104,26,228));
	}
	else{
	    f1.setVisible(false);
	    profile.setVisible(false);
	    checkout.setVisible(false);
	    addcar.setVisible(false);
	    checkin.setVisible(true);
	    bn_Profile.setVisible(false);
            bn_regis.setVisible(false);
	    bn_Home.setVisible(false);
	    bn_Checkin.setBackground(new Color(104,26,228));
	}
	Thread time = new Thread(new Runnable() {
	    @Override
	    public void run() {

		while (true) {
		    String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		    tf_time.setText("Time: "+time);
		    try {
			Thread.sleep(1000);
		    } catch (InterruptedException ex) {
			
		    }
		}
	    }
	});
	Thread checklate = new Thread(new Runnable() {
	    @Override
	    public void run() {

		while (true) {
		    String date = new SimpleDateFormat("dd/MM/YYYY").format(Calendar.getInstance().getTime());
		    String day = new SimpleDateFormat("d").format(Calendar.getInstance().getTime());
		    String month = new SimpleDateFormat("M").format(Calendar.getInstance().getTime());
		    String hour = new SimpleDateFormat("H").format(Calendar.getInstance().getTime());
		    String min = new SimpleDateFormat("m").format(Calendar.getInstance().getTime());
		    try {
			String sql = "SELECT * FROM `bookdata` WHERE `datein` = ? AND `check` = '0'";
			Connection con = MyConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, date);
			ResultSet rs_checklate = pst.executeQuery();
			while(rs_checklate.next()){
			    String[] time = rs_checklate.getString("timein").split(":");
			    String[] datein1 = rs_checklate.getString("datein").split("/");
			    System.out.println(datein1[0]);
			    System.out.println("Check Late " + time[0] +time[1]);
			    String lot = rs_checklate.getString("lot");
			    if(((Integer.parseInt(time[0])==Integer.parseInt(hour)) && ((Integer.parseInt(time[1])+15) <= Integer.parseInt(min)))||(Integer.parseInt(time[0])< Integer.parseInt(hour))){
				String sql2 = "DELETE FROM `bookdata` WHERE `datein` = ? AND `timein` = ? AND `lot` = ?";
				Connection con2 = MyConnection.getConnection();
				PreparedStatement ps = con2.prepareStatement(sql2);
				ps.setString(1, date);
				ps.setString(2, rs_checklate.getString("timein"));
				ps.setString(3, lot);
			    if(ps.executeUpdate() > 0){
				System.out.println("Late");
			    }
			    }
			}
			Thread.sleep(1000);
		    } catch (Exception ex) {
			
		    }
		}
	    }
	});
	time.start();
	checklate.start();
	

    }

    private MainUser() {
    }   

    
    public String getUser() {
	return user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        multiPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bn_exit = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bn_Profile = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_time = new javax.swing.JTextField();
        bn_Home = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        bn_regis = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bn_checkout = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bn_Checkin = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(890, 580));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        multiPanel.setBackground(new java.awt.Color(153, 153, 255));
        multiPanel.setMinimumSize(new java.awt.Dimension(710, 580));

        javax.swing.GroupLayout multiPanelLayout = new javax.swing.GroupLayout(multiPanel);
        multiPanel.setLayout(multiPanelLayout);
        multiPanelLayout.setHorizontalGroup(
            multiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        multiPanelLayout.setVerticalGroup(
            multiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        getContentPane().add(multiPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 710, 580));

        jPanel2.setBackground(new java.awt.Color(62, 16, 136));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bn_exit.setBackground(new java.awt.Color(54, 33, 150));
        bn_exit.setForeground(new java.awt.Color(255, 255, 254));
        bn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_exitMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 254));
        jLabel1.setText("Logout");

        javax.swing.GroupLayout bn_exitLayout = new javax.swing.GroupLayout(bn_exit);
        bn_exit.setLayout(bn_exitLayout);
        bn_exitLayout.setHorizontalGroup(
            bn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bn_exitLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        bn_exitLayout.setVerticalGroup(
            bn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bn_exitLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );

        jPanel2.add(bn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 180, -1));

        bn_Profile.setBackground(new java.awt.Color(62, 16, 136));
        bn_Profile.setForeground(new java.awt.Color(104, 26, 228));
        bn_Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_ProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_ProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_ProfileMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 254));
        jLabel3.setText("Profile");

        javax.swing.GroupLayout bn_ProfileLayout = new javax.swing.GroupLayout(bn_Profile);
        bn_Profile.setLayout(bn_ProfileLayout);
        bn_ProfileLayout.setHorizontalGroup(
            bn_ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bn_ProfileLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        bn_ProfileLayout.setVerticalGroup(
            bn_ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bn_ProfileLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.add(bn_Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 180, 70));

        tf_time.setEditable(false);
        tf_time.setBackground(new java.awt.Color(62, 16, 136));
        tf_time.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        tf_time.setForeground(new java.awt.Color(255, 255, 254));
        tf_time.setBorder(null);
        jPanel2.add(tf_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 30));

        bn_Home.setBackground(new java.awt.Color(62, 16, 136));
        bn_Home.setForeground(new java.awt.Color(104, 26, 228));
        bn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_HomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_HomeMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 254));
        jLabel4.setText("Booking");

        javax.swing.GroupLayout bn_HomeLayout = new javax.swing.GroupLayout(bn_Home);
        bn_Home.setLayout(bn_HomeLayout);
        bn_HomeLayout.setHorizontalGroup(
            bn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bn_HomeLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        bn_HomeLayout.setVerticalGroup(
            bn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bn_HomeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.add(bn_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 70));

        bn_regis.setBackground(new java.awt.Color(62, 16, 136));
        bn_regis.setForeground(new java.awt.Color(104, 26, 228));
        bn_regis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_regisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_regisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_regisMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 254));
        jLabel6.setText("Register");

        javax.swing.GroupLayout bn_regisLayout = new javax.swing.GroupLayout(bn_regis);
        bn_regis.setLayout(bn_regisLayout);
        bn_regisLayout.setHorizontalGroup(
            bn_regisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bn_regisLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(30, 30, 30))
        );
        bn_regisLayout.setVerticalGroup(
            bn_regisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bn_regisLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.add(bn_regis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, -1));

        bn_checkout.setBackground(new java.awt.Color(62, 16, 136));
        bn_checkout.setForeground(new java.awt.Color(104, 26, 228));
        bn_checkout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_checkoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_checkoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_checkoutMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 254));
        jLabel5.setText("Check Out");

        javax.swing.GroupLayout bn_checkoutLayout = new javax.swing.GroupLayout(bn_checkout);
        bn_checkout.setLayout(bn_checkoutLayout);
        bn_checkoutLayout.setHorizontalGroup(
            bn_checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bn_checkoutLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(25, 25, 25))
        );
        bn_checkoutLayout.setVerticalGroup(
            bn_checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bn_checkoutLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.add(bn_checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 180, -1));

        bn_Checkin.setBackground(new java.awt.Color(62, 16, 136));
        bn_Checkin.setForeground(new java.awt.Color(104, 26, 228));
        bn_Checkin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bn_CheckinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_CheckinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_CheckinMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 254));
        jLabel7.setText("Check In");

        javax.swing.GroupLayout bn_CheckinLayout = new javax.swing.GroupLayout(bn_Checkin);
        bn_Checkin.setLayout(bn_CheckinLayout);
        bn_CheckinLayout.setHorizontalGroup(
            bn_CheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bn_CheckinLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        bn_CheckinLayout.setVerticalGroup(
            bn_CheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bn_CheckinLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.add(bn_Checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 180, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_exitMouseClicked
        UiLogin ul = new UiLogin();
	ul.setVisible(true);
        ul.pack();
        ul.setLocationRelativeTo(null);
        ul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.dispose();
    }//GEN-LAST:event_bn_exitMouseClicked

    private void bn_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_HomeMouseClicked
	f1.setVisible(true);
        profile.setVisible(false);
        checkout.setVisible(false);
        addcar.setVisible(false);
	checkin.setVisible(false);
	bn_Home.setBackground(new Color(104,26,228));
	bn_Profile.setBackground(new Color(62,16,136));
	bn_checkout.setBackground(new Color(62,16,136));
	bn_regis.setBackground(new Color(62,16,136));
	bn_Checkin.setBackground(new Color(62,16,136));
	bn_homec = "1";
	bn_profilec = "0";
	bn_addcarc = "0";
	bn_checkoutc = "0";
	bn_checkinc = "0";

    }//GEN-LAST:event_bn_HomeMouseClicked

    private void bn_ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_ProfileMouseClicked
        f1.setVisible(false);
        profile.setVisible(true);
        checkout.setVisible(false);
        addcar.setVisible(false);
	checkin.setVisible(false);
	bn_homec = "0";
	bn_profilec = "1";
	bn_addcarc = "0";
	bn_checkoutc = "0";
	bn_checkinc = "0";
	bn_Home.setBackground(new Color(62,16,136));
	bn_Profile.setBackground(new Color(104,26,228));
	bn_checkout.setBackground(new Color(62,16,136));
	bn_regis.setBackground(new Color(62,16,136));
	bn_Checkin.setBackground(new Color(62,16,136));

    }//GEN-LAST:event_bn_ProfileMouseClicked

    private void bn_ProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_ProfileMouseEntered
	bn_Profile.setBackground(new Color(104,26,228));
    }//GEN-LAST:event_bn_ProfileMouseEntered

    private void bn_HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_HomeMouseEntered
        bn_Home.setBackground(new Color(104,26,228));
    }//GEN-LAST:event_bn_HomeMouseEntered

    private void bn_HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_HomeMouseExited
        if(bn_homec == "0"){
	    bn_Home.setBackground(new Color(62,16,136));
	}
	else{
	    
	}
    }//GEN-LAST:event_bn_HomeMouseExited

    private void bn_ProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_ProfileMouseExited
        if(bn_profilec == "0"){
	    bn_Profile.setBackground(new Color(62,16,136));
	}
	else{
	    
	}
    }//GEN-LAST:event_bn_ProfileMouseExited

    private void bn_checkoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_checkoutMouseClicked
        f1.setVisible(false);
        profile.setVisible(false);
        checkout.setVisible(true);
        addcar.setVisible(false);
	checkin.setVisible(false);
        bn_homec = "0";
	bn_profilec = "0";
	bn_addcarc = "0";
	bn_checkoutc = "1";
	bn_checkinc = "0";
	bn_Home.setBackground(new Color(62,16,136));
	bn_Profile.setBackground(new Color(62,16,136));
	bn_checkout.setBackground(new Color(104,26,228));
	bn_regis.setBackground(new Color(62,16,136));
	bn_Checkin.setBackground(new Color(62,16,136));
    }//GEN-LAST:event_bn_checkoutMouseClicked

    private void bn_checkoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_checkoutMouseEntered
	bn_checkout.setBackground(new Color(104,26,228));
    }//GEN-LAST:event_bn_checkoutMouseEntered

    private void bn_checkoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_checkoutMouseExited
        if(bn_checkoutc == "0"){
	    bn_checkout.setBackground(new Color(62,16,136));
	}else{
	    
	}
    }//GEN-LAST:event_bn_checkoutMouseExited

    private void bn_regisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_regisMouseClicked
        f1.setVisible(false);
        profile.setVisible(false);
        checkout.setVisible(false);
        addcar.setVisible(true);
	checkin.setVisible(false);
        bn_homec = "0";
	bn_profilec = "0";
	bn_addcarc = "1";
	bn_checkoutc = "0";
	bn_checkinc = "0";
	bn_Home.setBackground(new Color(62,16,136));
	bn_Profile.setBackground(new Color(62,16,136));
	bn_checkout.setBackground(new Color(62,16,136));
	bn_regis.setBackground(new Color(104,26,228));
	bn_Checkin.setBackground(new Color(62,16,136));
    }//GEN-LAST:event_bn_regisMouseClicked

    private void bn_regisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_regisMouseEntered
        bn_regis.setBackground(new Color(104,26,228));
    }//GEN-LAST:event_bn_regisMouseEntered

    private void bn_regisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_regisMouseExited
        if(bn_addcarc == "0"){
	    bn_regis.setBackground(new Color(62,16,136));
	}else{
	    
	}
    }//GEN-LAST:event_bn_regisMouseExited

    private void bn_CheckinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_CheckinMouseClicked
        f1.setVisible(false);
        profile.setVisible(false);
        checkout.setVisible(false);
        addcar.setVisible(false);
	checkin.setVisible(true);
	bn_homec = "0";
	bn_profilec = "0";
	bn_addcarc = "0";
	bn_checkoutc = "0";
	bn_checkinc = "1";
	bn_Home.setBackground(new Color(62,16,136));
	bn_Profile.setBackground(new Color(62,16,136));
	bn_checkout.setBackground(new Color(62,16,136));
	bn_regis.setBackground(new Color(62,16,136));
	bn_Checkin.setBackground(new Color(104,26,228));
    }//GEN-LAST:event_bn_CheckinMouseClicked

    private void bn_CheckinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_CheckinMouseEntered
	bn_Checkin.setBackground(new Color(104,26,228));
    }//GEN-LAST:event_bn_CheckinMouseEntered

    private void bn_CheckinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_CheckinMouseExited
        if(bn_checkinc == "0"){
	    bn_Checkin.setBackground(new Color(62,16,136));
	}
    }//GEN-LAST:event_bn_CheckinMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bn_Checkin;
    private javax.swing.JPanel bn_Home;
    private javax.swing.JPanel bn_Profile;
    private javax.swing.JPanel bn_checkout;
    private javax.swing.JPanel bn_exit;
    private javax.swing.JPanel bn_regis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel multiPanel;
    private javax.swing.JTextField tf_time;
    // End of variables declaration//GEN-END:variables

}