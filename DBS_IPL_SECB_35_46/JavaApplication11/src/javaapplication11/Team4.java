/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

/**
 *
 * @author MAHE
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import static javaapplication11.Team2.table;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class Team4 extends javax.swing.JFrame {

    /**
     * Creates new form Team4
     */
    JPanel panel;
static JTable table;
JFrame frame, frame1;
String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/dbs";
String userName = "root";
String password = "";
String[] columnNames = {"p_id","p_name","age","matches","runs","wickets","country","overseas","baseprice","role"};
    public Team4() {
       // frame = new JFrame("Database Search Result");
       //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(false);
       //frame.setVisible(true);
//frame.setSize(500, 400); 
  //      frame.setLayout(new BorderLayout());
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showtable();
        setSize(0,0);
    }
    public void showtable(){
    frame1 = new JFrame("Database Search Result NEW");
frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame1.setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
//String textvalue = textbox.getText();
String p_id="";
String p_name= "";
String age="" ;
String matches="";
String runs="";
String  wickets="";
String country="";
String overseas="";
String role="";
String soldprice="";
Vector data_rows = new Vector();
 Vector Column_Name = new Vector();
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection(url, userName, password);
String sql = "select players.player_id,name,age,matches,runs,wickets,overseas,soldprice,role,country from players,sold "+"where players.player_id=sold.player_id and sold.team_id='GL'";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
ResultSetMetaData metaData = (ResultSetMetaData)rs.getMetaData();
int columns = metaData.getColumnCount();
int i =0;
while(rs.next())
{
p_id = (String.valueOf(rs.getInt("player_id")));
p_name = rs.getString("name");
age = String.valueOf(rs.getInt("age"));
matches = String.valueOf(rs.getInt("matches"));
runs = String.valueOf(rs.getInt("runs"));
wickets = String.valueOf(rs.getInt("wickets"));
country = rs.getString("country");
overseas =rs.getString("overseas");
soldprice=String.valueOf(rs.getInt("soldprice"));
role=rs.getString("role");
data_rows = new Vector();

        for (int j = 1; j < columns; j++) {
            data_rows.addElement(rs.getString(j));
        }
model.addRow(new Object[]{p_id,p_name,age,matches,runs,wickets,country,overseas,soldprice,role});
i++; 
}
/*if(i <1)

JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
*/
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
frame1.add(scroll);
frame1.setVisible(true);
frame1.setSize(400,300);
}
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Team4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Team4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Team4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Team4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Team4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
