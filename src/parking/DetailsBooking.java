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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fluke
 */
public class DetailsBooking extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    ArrayList<Integer> timebook;
    ArrayList<Integer> licensetimebook;
    private String lot;
    
    public void setLot(String lot){
	this.lot = lot;
	J_Header.setText("Booking Details (" + this.lot + ")");
    }
    
    public DetailsBooking() {
	initComponents();
	setLocationRelativeTo(null);
    }
    public void setdecolor(){
	time_8.setBackground(new Color(0,153,51));
	time_9.setBackground(new Color(0,153,51));
	time_10.setBackground(new Color(0,153,51));
	time_11.setBackground(new Color(0,153,51));
	time_12.setBackground(new Color(0,153,51));
	time_13.setBackground(new Color(0,153,51));
	time_14.setBackground(new Color(0,153,51));
	time_15.setBackground(new Color(0,153,51));
	time_16.setBackground(new Color(0,153,51));
	time_17.setBackground(new Color(0,153,51));
	time_18.setBackground(new Color(0,153,51));
	time_19.setBackground(new Color(0,153,51));
	j8.setText("Availble");
	j9.setText("Availble");
	j10.setText("Availble");
	j11.setText("Availble");
	j12.setText("Availble");
	j13.setText("Availble");
	j14.setText("Availble");
	j15.setText("Availble");
	j16.setText("Availble");
	j17.setText("Availble");
	j18.setText("Availble");
	j19.setText("Availble");
    }
    public void setcolor(int num){
	if(num == 8){
	    time_8.setBackground(Color.red);
	    j8.setText("Unavailble");
	}
	if(num == 9){
	    time_9.setBackground(Color.red);
	    j9.setText("Unavailble");
	}
	if(num == 10){
	    time_10.setBackground(Color.red);
	    j10.setText("Unavailble");
	}
	if(num == 11){
	    time_11.setBackground(Color.red);
	    j11.setText("Unavailble");
	}
	if(num == 12){
	    time_12.setBackground(Color.red);
	    j12.setText("Unavailble");
	}
	if(num == 13){
	    time_13.setBackground(Color.red);
	    j13.setText("Unavailble");
	}
	if(num == 14){
	    time_14.setBackground(Color.red);
	    j14.setText("Unavailble");
	}
	if(num == 15){
	    time_15.setBackground(Color.red);
	    j15.setText("Unavailble");
	}
	if(num == 16){
	    time_16.setBackground(Color.red);
	    j16.setText("Unavailble");
	}
	if(num == 17){
	    time_17.setBackground(Color.red);
	    j17.setText("Unavailble");
	}
	if(num == 18){
	    time_18.setBackground(Color.red);
	    j18.setText("Unavailble");
	}
	if(num == 19){
	    time_19.setBackground(Color.red);
	    j19.setText("Unavailble");
	}
	
	
    }
    
    public void checkavailbleformdate(String date){
	try{
	    String sql = "SELECT * FROM `bookdata` WHERE datein = ? AND lot = ?";
	    Connection con = MyConnection.getConnection();
	    PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, date);
	    pst.setString(2, this.lot);
	    ResultSet rs_date = pst.executeQuery();
	    while(rs_date.next()){
		String timein = rs_date.getString("timein");
		String[] numtimein = timein.split(":");
		String timeout = rs_date.getString("timeout");
		String[] numtimeout = timeout.split(":");
		for(int i = Integer.parseInt(numtimein[0]); i < Integer.parseInt(numtimeout[0]); i++){
		    setcolor(i);
		    timebook.add(i);
		}
	    }
	}catch(Exception e){
	
	}
    }
    
    public String checktime() throws Exception{
	String timein = tf_start.getText();
	int timeout = (Integer) tf_hour.getValue();
	String[] l_timein = timein.split(":");
	for(int i = Integer.parseInt(l_timein[0]); i < Integer.parseInt(l_timein[0])+timeout; i++){
	    if(checkAvailble(i) == true){
		JOptionPane.showMessageDialog(null, "Booking time that you selected is not available");
		throw new Exception();
	    }
	}
	return (Integer.parseInt(l_timein[0])+timeout)+":00";
    }
    
    public boolean checkAvailble(int check){
	if(timebook.contains(check)){
	    return true;
	}else{
	    return false;
	}
    }
    
    public boolean checkLicenseAvailble(int check){
	if(licensetimebook.contains(check)){
	    return true;
	}else{
	    return false;
	}
    }
    
    public int checklicense(){
	int count = 0;
	String timein_insert = tf_start.getText();
	int timeout_insert = (Integer) tf_hour.getValue();
	String[] l_timein = timein_insert.split(":"); 
	try{
	    String sql = "SELECT * FROM `bookdata` WHERE license = ? AND datein = ?";
	    Connection con = MyConnection.getConnection();
	    PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, tf_license.getText());
	    pst.setString(2, tf_date.getText());
	    ResultSet rs_licensecheck = pst.executeQuery();
	    while(rs_licensecheck.next()){
		String timein = rs_licensecheck.getString("timein");
		String[] numtimein = timein.split(":");
		String timeout = rs_licensecheck.getString("timeout");
		String[] numtimeout = timeout.split(":");
		for(int i = Integer.parseInt(numtimein[0]); i < Integer.parseInt(numtimeout[0]); i++){
		    licensetimebook.add(i);
		}
//		for(int j = Integer.parseInt(l_timein[0]); j < Integer.parseInt(l_timein[0])+timeout_insert; j++){
//		    if(licensetimebook.contains(j)){
//			count = 1;
//			licensetimebook.add(j);
//		    }else{
//			licensetimebook.add(j);
//		    }
//		}
	    }
	}catch(Exception e){
	    
	}
	return count;
    }
    
    public void booking(){
	try{
	    String sql = "INSERT INTO `bookdata`(`datein`, `timein`, `timeout`, `name`, `license`, `phone`, `other`, `lot`, `check`) VALUES (?,?,?,?,?,?,?,?,'0')";
	    PreparedStatement ps = MyConnection.getConnection().prepareStatement(sql);
	    ps.setString(1, tf_date.getText());
	    ps.setString(2, tf_start.getText());
	    ps.setString(3, checktime());
	    ps.setString(4, tf_name1.getText());
	    ps.setString(5, tf_license.getText());
	    ps.setString(6, tf_phonenumber.getText());
	    ps.setString(7, tf_other.getText());
	    ps.setString(8, this.lot);
            if(ps.executeUpdate() > 0){
		JOptionPane.showMessageDialog(null, "Booked");
		tf_name1.setText("");
		tf_license.setText("");
		tf_phonenumber.setText("");
		tf_other.setText("");
		tf_start.setText("");
		tf_hour.setValue(0);
		checkavailbleformdate(tf_date.getText());
	    }
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, "Please click check from date");
	}
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        bar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        J_Header = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_license = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_name1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_other = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_phonenumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_date = new javax.swing.JTextField();
        bn_checkdate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tf_start = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_hour = new javax.swing.JSpinner();
        bn_book = new javax.swing.JButton();
        time_9 = new javax.swing.JPanel();
        j9 = new javax.swing.JLabel();
        time_8 = new javax.swing.JPanel();
        j8 = new javax.swing.JLabel();
        time_13 = new javax.swing.JPanel();
        j13 = new javax.swing.JLabel();
        time_10 = new javax.swing.JPanel();
        j10 = new javax.swing.JLabel();
        time_11 = new javax.swing.JPanel();
        j11 = new javax.swing.JLabel();
        time_12 = new javax.swing.JPanel();
        j12 = new javax.swing.JLabel();
        time_14 = new javax.swing.JPanel();
        j14 = new javax.swing.JLabel();
        time_15 = new javax.swing.JPanel();
        j15 = new javax.swing.JLabel();
        time_16 = new javax.swing.JPanel();
        j16 = new javax.swing.JLabel();
        time_17 = new javax.swing.JPanel();
        j17 = new javax.swing.JLabel();
        time_19 = new javax.swing.JPanel();
        j19 = new javax.swing.JLabel();
        time_18 = new javax.swing.JPanel();
        j18 = new javax.swing.JLabel();
        bn_SearchFromPhone = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainpanel.setBackground(new java.awt.Color(153, 153, 255));

        bar.setBackground(new java.awt.Color(104, 26, 228));
        bar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barMouseDragged(evt);
            }
        });
        bar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barMousePressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 254));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 254));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout barLayout = new javax.swing.GroupLayout(bar);
        bar.setLayout(barLayout);
        barLayout.setHorizontalGroup(
            barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        barLayout.setVerticalGroup(
            barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        J_Header.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        J_Header.setForeground(new java.awt.Color(255, 255, 254));
        J_Header.setText("Booking Details");

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel3.setText("Name :");

        tf_license.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_license.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_licenseFocusGained(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel4.setText("License Plate:");

        tf_name1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_name1.setText("-");
        tf_name1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tf_name1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_name1FocusGained(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel5.setText("Phone Number:");

        tf_other.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_other.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_otherFocusGained(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel6.setText("Other Detail:");

        tf_phonenumber.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_phonenumber.setText("-");
        tf_phonenumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_phonenumberFocusGained(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel7.setText("Date In:");

        tf_date.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_date.setText("Ex. 31/12/2018");
        tf_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_dateFocusGained(evt);
            }
        });

        bn_checkdate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bn_checkdate.setText("Check");
        bn_checkdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn_checkdateActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel8.setText("9:00 - 10:00");

        jLabel9.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel9.setText("8:00 - 9:00");

        jLabel10.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel10.setText("10:00 - 11:00");

        jLabel11.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel11.setText("11:00 - 12:00");

        jLabel12.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel12.setText("12:00 - 13:00");

        jLabel13.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel13.setText("13:00 - 14:00");

        jLabel14.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel14.setText("14:00 - 15:00");

        jLabel15.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel15.setText("15:00 - 16:00");

        jLabel16.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel16.setText("16:00 - 17:00");

        jLabel17.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel17.setText("17:00 - 18:00");

        jLabel18.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel18.setText("18:00 - 19:00");

        jLabel19.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel19.setText("19:00 - 20:00");

        jLabel20.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel20.setText("Start Time:");

        tf_start.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tf_start.setText("Ex. 12:00");
        tf_start.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_startFocusGained(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel21.setText("Select Hour:");

        tf_hour.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N

        bn_book.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        bn_book.setText("Book");
        bn_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn_bookActionPerformed(evt);
            }
        });

        time_9.setBackground(new java.awt.Color(0, 153, 51));

        j9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j9.setText("Availble");

        javax.swing.GroupLayout time_9Layout = new javax.swing.GroupLayout(time_9);
        time_9.setLayout(time_9Layout);
        time_9Layout.setHorizontalGroup(
            time_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_9Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j9)
                .addGap(24, 24, 24))
        );
        time_9Layout.setVerticalGroup(
            time_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        time_8.setBackground(new java.awt.Color(0, 153, 51));

        j8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j8.setText("Availble");

        javax.swing.GroupLayout time_8Layout = new javax.swing.GroupLayout(time_8);
        time_8.setLayout(time_8Layout);
        time_8Layout.setHorizontalGroup(
            time_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(time_8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(j8)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        time_8Layout.setVerticalGroup(
            time_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        time_13.setBackground(new java.awt.Color(0, 153, 51));

        j13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j13.setText("Availble");

        javax.swing.GroupLayout time_13Layout = new javax.swing.GroupLayout(time_13);
        time_13.setLayout(time_13Layout);
        time_13Layout.setHorizontalGroup(
            time_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_13Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(j13)
                .addGap(23, 23, 23))
        );
        time_13Layout.setVerticalGroup(
            time_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        time_10.setBackground(new java.awt.Color(0, 153, 51));

        j10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j10.setText("Availble");

        javax.swing.GroupLayout time_10Layout = new javax.swing.GroupLayout(time_10);
        time_10.setLayout(time_10Layout);
        time_10Layout.setHorizontalGroup(
            time_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_10Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j10)
                .addGap(24, 24, 24))
        );
        time_10Layout.setVerticalGroup(
            time_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        time_11.setBackground(new java.awt.Color(0, 153, 51));

        j11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j11.setText("Availble");

        javax.swing.GroupLayout time_11Layout = new javax.swing.GroupLayout(time_11);
        time_11.setLayout(time_11Layout);
        time_11Layout.setHorizontalGroup(
            time_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_11Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j11)
                .addGap(24, 24, 24))
        );
        time_11Layout.setVerticalGroup(
            time_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        time_12.setBackground(new java.awt.Color(0, 153, 51));

        j12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j12.setText("Availble");

        javax.swing.GroupLayout time_12Layout = new javax.swing.GroupLayout(time_12);
        time_12.setLayout(time_12Layout);
        time_12Layout.setHorizontalGroup(
            time_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_12Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j12)
                .addGap(24, 24, 24))
        );
        time_12Layout.setVerticalGroup(
            time_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        time_14.setBackground(new java.awt.Color(0, 153, 51));

        j14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j14.setText("Availble");

        javax.swing.GroupLayout time_14Layout = new javax.swing.GroupLayout(time_14);
        time_14.setLayout(time_14Layout);
        time_14Layout.setHorizontalGroup(
            time_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_14Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j14)
                .addGap(24, 24, 24))
        );
        time_14Layout.setVerticalGroup(
            time_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        time_15.setBackground(new java.awt.Color(0, 153, 51));

        j15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j15.setText("Availble");

        javax.swing.GroupLayout time_15Layout = new javax.swing.GroupLayout(time_15);
        time_15.setLayout(time_15Layout);
        time_15Layout.setHorizontalGroup(
            time_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_15Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j15)
                .addGap(24, 24, 24))
        );
        time_15Layout.setVerticalGroup(
            time_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        time_16.setBackground(new java.awt.Color(0, 153, 51));

        j16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j16.setText("Availble");

        javax.swing.GroupLayout time_16Layout = new javax.swing.GroupLayout(time_16);
        time_16.setLayout(time_16Layout);
        time_16Layout.setHorizontalGroup(
            time_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_16Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j16)
                .addGap(24, 24, 24))
        );
        time_16Layout.setVerticalGroup(
            time_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        time_17.setBackground(new java.awt.Color(0, 153, 51));

        j17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j17.setText("Availble");

        javax.swing.GroupLayout time_17Layout = new javax.swing.GroupLayout(time_17);
        time_17.setLayout(time_17Layout);
        time_17Layout.setHorizontalGroup(
            time_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_17Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j17)
                .addGap(24, 24, 24))
        );
        time_17Layout.setVerticalGroup(
            time_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        time_19.setBackground(new java.awt.Color(0, 153, 51));

        j19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j19.setText("Availble");

        javax.swing.GroupLayout time_19Layout = new javax.swing.GroupLayout(time_19);
        time_19.setLayout(time_19Layout);
        time_19Layout.setHorizontalGroup(
            time_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_19Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j19)
                .addGap(24, 24, 24))
        );
        time_19Layout.setVerticalGroup(
            time_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        time_18.setBackground(new java.awt.Color(0, 153, 51));

        j18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        j18.setText("Availble");

        javax.swing.GroupLayout time_18Layout = new javax.swing.GroupLayout(time_18);
        time_18.setLayout(time_18Layout);
        time_18Layout.setHorizontalGroup(
            time_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, time_18Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(j18)
                .addGap(24, 24, 24))
        );
        time_18Layout.setVerticalGroup(
            time_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        bn_SearchFromPhone.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bn_SearchFromPhone.setText("Search");
        bn_SearchFromPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn_SearchFromPhoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(J_Header)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bn_checkdate))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(tf_start, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainpanelLayout.createSequentialGroup()
                                        .addComponent(tf_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(bn_SearchFromPhone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(14, 14, 14)
                                        .addComponent(tf_other, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainpanelLayout.createSequentialGroup()
                                        .addComponent(tf_name1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addGap(14, 14, 14)
                                        .addComponent(tf_license, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addComponent(bn_book, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))))
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(time_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(time_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(time_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(J_Header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(tf_license, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bn_SearchFromPhone))
                    .addComponent(jLabel6)
                    .addComponent(tf_other, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(bn_checkdate)))
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel20))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(tf_start, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(tf_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(bn_book, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(time_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(time_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(time_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(time_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(time_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(time_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(time_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(time_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(time_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(time_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(time_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(time_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bn_SearchFromPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn_SearchFromPhoneActionPerformed
        try{
	    String sql = "SELECT * FROM `memberdata` WHERE phone = ?";
	    Connection con = MyConnection.getConnection();
	    PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, tf_phonenumber.getText());
	    ResultSet rs_data = pst.executeQuery();
	    if(rs_data.next()){
		JOptionPane.showMessageDialog(null, "Found data from this number");
		tf_name1.setText(rs_data.getString("firstname")+ " " + rs_data.getString("lastname"));
		tf_license.setText(rs_data.getString("license"));
	    }else{
		JOptionPane.showMessageDialog(null, "Not found data from this phonenumber");
	    }
	}catch(Exception e){
	    System.out.println(e);
	}
    }//GEN-LAST:event_bn_SearchFromPhoneActionPerformed

    private void bn_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn_bookActionPerformed
        if(tf_license.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Check license textfiled");
        }else if((Integer) tf_hour.getValue() == 0){
            JOptionPane.showMessageDialog(null, "Check select hour");
        }else if(tf_name1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Check name textfiled");
        }else if(tf_phonenumber.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Check phone textfiled");
        }else if(((Integer) tf_hour.getValue() != 0) && (tf_name1.getText() != "") && (tf_phonenumber.getText() != "") && (tf_license.getText() != "")){
            licensetimebook = new ArrayList<Integer>();
	    int count = 0;
	    checklicense();
	    String timein = tf_start.getText();
	    int timeout = (Integer) tf_hour.getValue();
	    String[] l_timein = timein.split(":");
	    for(int i = Integer.parseInt(l_timein[0]); i < Integer.parseInt(l_timein[0])+timeout; i++){
		if(checkLicenseAvailble(i) == true){
		    count = 1;
		}
	    }
	    if(count == 0){
		booking();
	    }
	    else if(count == 1){
		JOptionPane.showMessageDialog(null, "This license is already book in this time in other parking lot");
	    }
   
        }
    }//GEN-LAST:event_bn_bookActionPerformed

    private void bn_checkdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn_checkdateActionPerformed
        timebook = new ArrayList<Integer>();
        setdecolor();
        checkavailbleformdate(tf_date.getText());
    }//GEN-LAST:event_bn_checkdateActionPerformed
    private void barMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_barMousePressed
    private void barMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y);
    }//GEN-LAST:event_barMouseDragged
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked
    private void tf_name1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_name1FocusGained
        if(tf_name1.getText().equals("-")){
            tf_name1.setText("");
        }
        if(tf_date.getText().equals("")){
            tf_date.setText("Ex. 31/12/2018");
        }
        if(tf_start.getText().equals("")){
            tf_start.setText("Ex. 12:00");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("-");
        }
    }//GEN-LAST:event_tf_name1FocusGained

    private void tf_phonenumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_phonenumberFocusGained
        if(tf_name1.getText().equals("")){
            tf_name1.setText("-");
        }
        if(tf_date.getText().equals("")){
            tf_date.setText("Ex. 31/12/2018");
        }
        if(tf_start.getText().equals("")){
            tf_start.setText("Ex. 12:00");
        }
        if(tf_phonenumber.getText().equals("-")){
            tf_phonenumber.setText("");
        }
    }//GEN-LAST:event_tf_phonenumberFocusGained

    private void tf_dateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_dateFocusGained
        if(tf_name1.getText().equals("")){
            tf_name1.setText("-");
        }
        if(tf_date.getText().equals("Ex. 31/12/2018")){
            tf_date.setText("");
        }
        if(tf_start.getText().equals("")){
            tf_start.setText("Ex. 12:00");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("-");
        }
    }//GEN-LAST:event_tf_dateFocusGained

    private void tf_startFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_startFocusGained
        if(tf_name1.getText().equals("")){
            tf_name1.setText("-");
        }
        if(tf_date.getText().equals("")){
            tf_date.setText("Ex. 31/12/2018");
        }
        if(tf_start.getText().equals("Ex. 12:00")){
            tf_start.setText("");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("-");
        }
    }//GEN-LAST:event_tf_startFocusGained

    private void tf_licenseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_licenseFocusGained
        if(tf_name1.getText().equals("")){
            tf_name1.setText("-");
        }
        if(tf_date.getText().equals("")){
            tf_date.setText("Ex. 31/12/2018");
        }
        if(tf_start.getText().equals("")){
            tf_start.setText("Ex. 12:00");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("-");
        }
    }//GEN-LAST:event_tf_licenseFocusGained

    private void tf_otherFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_otherFocusGained
        if(tf_name1.getText().equals("")){
            tf_name1.setText("-");
        }
        if(tf_date.getText().equals("")){
            tf_date.setText("Ex. 31/12/2018");
        }
        if(tf_start.getText().equals("")){
            tf_start.setText("Ex. 12:00");
        }
        if(tf_phonenumber.getText().equals("")){
            tf_phonenumber.setText("-");
        }
    }//GEN-LAST:event_tf_otherFocusGained
    public static void main(String args[]) {
	DetailsBooking dt = new DetailsBooking();
	dt.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel J_Header;
    private javax.swing.JPanel bar;
    private javax.swing.JButton bn_SearchFromPhone;
    private javax.swing.JButton bn_book;
    private javax.swing.JButton bn_checkdate;
    private javax.swing.JLabel j10;
    private javax.swing.JLabel j11;
    private javax.swing.JLabel j12;
    private javax.swing.JLabel j13;
    private javax.swing.JLabel j14;
    private javax.swing.JLabel j15;
    private javax.swing.JLabel j16;
    private javax.swing.JLabel j17;
    private javax.swing.JLabel j18;
    private javax.swing.JLabel j19;
    private javax.swing.JLabel j8;
    private javax.swing.JLabel j9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField tf_date;
    private javax.swing.JSpinner tf_hour;
    private javax.swing.JTextField tf_license;
    private javax.swing.JTextField tf_name1;
    private javax.swing.JTextField tf_other;
    private javax.swing.JTextField tf_phonenumber;
    private javax.swing.JTextField tf_start;
    private javax.swing.JPanel time_10;
    private javax.swing.JPanel time_11;
    private javax.swing.JPanel time_12;
    private javax.swing.JPanel time_13;
    private javax.swing.JPanel time_14;
    private javax.swing.JPanel time_15;
    private javax.swing.JPanel time_16;
    private javax.swing.JPanel time_17;
    private javax.swing.JPanel time_18;
    private javax.swing.JPanel time_19;
    private javax.swing.JPanel time_8;
    private javax.swing.JPanel time_9;
    // End of variables declaration//GEN-END:variables
}
