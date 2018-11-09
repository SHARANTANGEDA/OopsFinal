/*
 * Created by JFormDesigner on Wed Nov 07 07:49:29 IST 2018
 */

package com.sharan.ui.hotelView.paymentPage;

import com.sharan.DataBaseController;
import com.sharan.encryptionAlgorithms.AES128Encyrption;
import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author SAI SHARAN
 */
public class PaymentPage {

    private String userName;
    private DataBaseController dataBaseController;
    private String totalPricePaid;
    private ArrayList<String> list;


    public PaymentPage(String userName, DataBaseController dataBaseController, int noOfStandardRooms, int noOfDeluxeRooms, int noOfSuiteRooms, String uniqueId) {


        this.userName=userName;
        this.dataBaseController=dataBaseController;
        int totalPrice=0;

        dataBaseController.initialiseDatabase();
        list=dataBaseController.getRoomPriceFromHotel(uniqueId);


        if(noOfStandardRooms!=0) {
            totalPrice+=noOfStandardRooms*(Integer.parseInt(list.get(0)));
        }

        if(noOfDeluxeRooms!=0) {
            totalPrice+=noOfDeluxeRooms*(Integer.parseInt(list.get(1)));
        }

        if(noOfSuiteRooms!=0) {
            totalPrice+=noOfSuiteRooms*(Integer.parseInt(list.get(2)));
        }
        totalPricePaid=String.valueOf(totalPrice);


        initComponents();
        totalPriceLabel.setText("Total Price To be Paid is Rs."+totalPricePaid);
        paymentPage.setVisible(true);
    }

    private void homePageActionPerformed(ActionEvent e) {
        paymentPage.dispose();
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(userName,dataBaseController);
    }

    private void confirmPaymenaadharActionPerformed(ActionEvent e) {
        if(!aadharField.getText().isEmpty()) {
            String encryptId= AES128Encyrption.encrypt(aadharField.getText());
            dataBaseController.initialiseDatabase();
            String check=dataBaseController.checkIdForPayment(userName,encryptId);
            dataBaseController.closeDatabaseConnection();
            if(check.equalsIgnoreCase("AadharSuccess")) {
                paymentPage.dispose();
                JOptionPane.showMessageDialog(null,"Transaction Successful, Rs."+totalPricePaid+" Paid");
            }else {
                JOptionPane.showMessageDialog(null,"Enter valid Aadhar to complete Payment");
            }
        }else {
            JOptionPane.showMessageDialog(null,"Enter valid Aadhar to complete Payment");

        }

    }

    private void cancelPaymentActionPerformed(ActionEvent e) {
        paymentPage.dispose();
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(userName,dataBaseController);
    }

    private void confirmPaymentPanActionPerformed(ActionEvent e) {
        if(!panField.getText().isEmpty()) {
            String encryptId= AES128Encyrption.encrypt(panField.getText());
            dataBaseController.initialiseDatabase();
            String check=dataBaseController.checkIdForPayment(userName,encryptId);
            dataBaseController.closeDatabaseConnection();
            if(check.equalsIgnoreCase("PanSuccess")) {
                paymentPage.dispose();
                JOptionPane.showMessageDialog(null,"Transaction Successful, Rs."+totalPricePaid+" Paid");
            } else {
                JOptionPane.showMessageDialog(null,"Enter valid Pan to complete Payment");
            }
        }else {
            JOptionPane.showMessageDialog(null,"Enter valid Pan to complete Payment");

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        paymentPage = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        tabbedPane2 = new JTabbedPane();
        panel2 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        aadharField = new JTextField();
        confirmPaymenaadhar = new JButton();
        label6 = new JLabel();
        cancelPaymentaadhar = new JButton();
        panel1 = new JPanel();
        label7 = new JLabel();
        label8 = new JLabel();
        panField = new JTextField();
        confirmPaymentPan = new JButton();
        label9 = new JLabel();
        cancelPaymentPan = new JButton();
        homePage = new JButton();
        totalPriceLabel = new JLabel();

        //======== paymentPage ========
        {
            paymentPage.setBackground(Color.white);
            Container paymentPageContentPane = paymentPage.getContentPane();

            //---- label1 ----
            label1.setText("Payment ");
            label1.setBackground(new Color(255, 204, 0));
            label1.setOpaque(true);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Dialog", Font.BOLD, 38));

            //---- label2 ----
            label2.setText("Safe & Secure");
            label2.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/payment/secure-payment64.png")));
            label2.setFont(new Font("Arial", Font.BOLD, 16));
            label2.setBorder(LineBorder.createBlackLineBorder());
            label2.setBackground(Color.white);
            label2.setOpaque(true);

            //---- label3 ----
            label3.setText("AES 128bit Encrypted");
            label3.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/payment/AES50.png")));
            label3.setFont(new Font("Arial", Font.BOLD, 16));
            label3.setBorder(LineBorder.createBlackLineBorder());
            label3.setBackground(Color.white);
            label3.setOpaque(true);

            //======== tabbedPane2 ========
            {

                //======== panel2 ========
                {
                    panel2.setBackground(Color.white);

                    // JFormDesigner evaluation mark
                    panel2.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                            Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                    //---- label4 ----
                    label4.setText("Please Enter Your Aadhar Card or Pan Card details below to make Payment");
                    label4.setFont(new Font("Arial Black", Font.BOLD, 16));
                    label4.setForeground(new Color(0, 0, 197));

                    //---- label5 ----
                    label5.setText("Aadhar-Card:");
                    label5.setFont(new Font("Arial", Font.BOLD, 16));

                    //---- aadharField ----
                    aadharField.setBackground(Color.white);
                    aadharField.setToolTipText("Enter-Aadhar Number");

                    //---- confirmPaymenaadhar ----
                    confirmPaymenaadhar.setText("Confirm Payment");
                    confirmPaymenaadhar.setBackground(new Color(204, 0, 0));
                    confirmPaymenaadhar.setForeground(new Color(238, 238, 238));
                    confirmPaymenaadhar.setFont(new Font("Arial Black", Font.BOLD, 20));
                    confirmPaymenaadhar.addActionListener(e -> confirmPaymenaadharActionPerformed(e));

                    //---- label6 ----
                    label6.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/payment/lock-icon.png")));

                    //---- cancelPaymentaadhar ----
                    cancelPaymentaadhar.setText("Cancel Payment");
                    cancelPaymentaadhar.setBackground(new Color(204, 0, 0));
                    cancelPaymentaadhar.setForeground(Color.white);
                    cancelPaymentaadhar.setFont(new Font("Arial Black", Font.BOLD, 20));
                    cancelPaymentaadhar.addActionListener(e -> cancelPaymentActionPerformed(e));

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addContainerGap(332, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 770, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(aadharField, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(label6))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(224, 224, 224)
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cancelPaymentaadhar, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                            .addComponent(confirmPaymenaadhar, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))))
                                .addGap(323, 323, 323))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(aadharField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91)
                                .addComponent(confirmPaymenaadhar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelPaymentaadhar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(38, 38, 38))
                    );
                }
                tabbedPane2.addTab("Aadhar-Card", panel2);

                //======== panel1 ========
                {
                    panel1.setBackground(Color.white);

                    //---- label7 ----
                    label7.setText("Please Enter Your Aadhar Card or Pan Card details below to make Payment");
                    label7.setFont(new Font("Arial Black", Font.BOLD, 16));
                    label7.setForeground(new Color(0, 0, 197));

                    //---- label8 ----
                    label8.setText("Pan-Card:");
                    label8.setFont(new Font("Arial", Font.BOLD, 16));

                    //---- panField ----
                    panField.setBackground(Color.white);
                    panField.setToolTipText("Enter Pan-Number");

                    //---- confirmPaymentPan ----
                    confirmPaymentPan.setText("Confirm Payment");
                    confirmPaymentPan.setBackground(new Color(204, 0, 0));
                    confirmPaymentPan.setForeground(new Color(238, 238, 238));
                    confirmPaymentPan.setFont(new Font("Arial Black", Font.BOLD, 20));
                    confirmPaymentPan.addActionListener(e -> confirmPaymentPanActionPerformed(e));

                    //---- label9 ----
                    label9.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/payment/lock-icon.png")));

                    //---- cancelPaymentPan ----
                    cancelPaymentPan.setText("Cancel Payment");
                    cancelPaymentPan.setBackground(new Color(204, 0, 0));
                    cancelPaymentPan.setForeground(Color.white);
                    cancelPaymentPan.setFont(new Font("Arial Black", Font.BOLD, 20));
                    cancelPaymentPan.addActionListener(e -> cancelPaymentActionPerformed(e));

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(340, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 770, GroupLayout.PREFERRED_SIZE)
                                        .addGap(315, 315, 315))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panField, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(label9)
                                        .addGap(434, 434, 434))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(cancelPaymentPan, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(confirmPaymentPan, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
                                        .addGap(564, 564, 564))))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(panField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label9, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addComponent(confirmPaymentPan, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelPaymentPan, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
                    );
                }
                tabbedPane2.addTab("Pan-Card", panel1);
            }

            //---- homePage ----
            homePage.setText("Go to HomePage");
            homePage.setBackground(new Color(204, 0, 0));
            homePage.setForeground(Color.white);
            homePage.setFont(new Font("Arial", Font.BOLD, 16));
            homePage.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/Home24.gif")));
            homePage.addActionListener(e -> homePageActionPerformed(e));

            //---- totalPriceLabel ----
            totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 22));
            totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            totalPriceLabel.setOpaque(true);
            totalPriceLabel.setBackground(Color.white);

            GroupLayout paymentPageContentPaneLayout = new GroupLayout(paymentPageContentPane);
            paymentPageContentPane.setLayout(paymentPageContentPaneLayout);
            paymentPageContentPaneLayout.setHorizontalGroup(
                paymentPageContentPaneLayout.createParallelGroup()
                    .addGroup(paymentPageContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paymentPageContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(GroupLayout.Alignment.TRAILING, paymentPageContentPaneLayout.createSequentialGroup()
                                .addComponent(homePage)
                                .addGap(213, 213, 213)
                                .addComponent(totalPriceLabel, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 1430, GroupLayout.PREFERRED_SIZE)
                            .addComponent(tabbedPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            paymentPageContentPaneLayout.setVerticalGroup(
                paymentPageContentPaneLayout.createParallelGroup()
                    .addGroup(paymentPageContentPaneLayout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paymentPageContentPaneLayout.createParallelGroup()
                            .addGroup(paymentPageContentPaneLayout.createSequentialGroup()
                                .addGroup(paymentPageContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalPriceLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(homePage, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabbedPane2, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
            );
            paymentPage.pack();
            paymentPage.setLocationRelativeTo(paymentPage.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame paymentPage;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTabbedPane tabbedPane2;
    private JPanel panel2;
    private JLabel label4;
    private JLabel label5;
    private JTextField aadharField;
    private JButton confirmPaymenaadhar;
    private JLabel label6;
    private JButton cancelPaymentaadhar;
    private JPanel panel1;
    private JLabel label7;
    private JLabel label8;
    private JTextField panField;
    private JButton confirmPaymentPan;
    private JLabel label9;
    private JButton cancelPaymentPan;
    private JButton homePage;
    private JLabel totalPriceLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
