
package tudien;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
public class frmTuDien extends javax.swing.JFrame {

    TuDien td = null;
    int timerun = 0;
    List<TuDien> listdsnv = new ArrayList<>();
    ArrayList<String> dsnv = new ArrayList<>();
    DefaultTableModel model;
    FileInputStream fis;
    int currentIndex = 0;
    public frmTuDien() {
        initComponents();
        setLocationRelativeTo(null);
    }
 
    private void showItem(int index) {
        try {

            td = listdsnv.get(index);
            txttienganh.setText(td.tiengViet);
            txttienganh.setText(td.tiengAnh);
            txttiengviet.setText(td.tiengViet);
            txtloaitu.setText(td.loaiTu);
            txtphatam.setText(td.phatAM);

        } catch (Exception e) {
        }
    }

    private void first() {
        try {
            showItem(0);
            btnfirst.setEnabled(false);
            btnprevious.setEnabled(false);
        } catch (Exception e) {
        }
    }

    private void previous() {
        try {

            currentIndex--;
            if (currentIndex < 0) {
                currentIndex = 0;
            }
            showItem(currentIndex);
        } catch (Exception e) {
        }
    }

    private void next() {
        try {

            currentIndex++;
            if (currentIndex > listdsnv.size() - 1) {
                currentIndex = listdsnv.size() - 1;
            }
            showItem(currentIndex);

        } catch (Exception e) {
        }
    }

    private void last() {
        try {

            showItem(listdsnv.size() - 1);
        } catch (Exception e) {
        }
    }
    public boolean kiemtratrung(String ma) {
        boolean trave = false;
        for (int i = 0; i < listdsnv.size(); i++) {
            if (listdsnv.get(i).maNhanVien.equalsIgnoreCase(ma) == true) {
                trave = true;
            }
        }
        return trave;
    }

    public void add() {
        td = new TuDien();
        try {

            td.tiengAnh = txttienganh.getText();
            if (kiemtratrung(txttienganh.getText()) == true) {
                JOptionPane.showMessageDialog(this, "trùng tên, nhập tên khác");
                return;
            }
            if (td.tiengAnh.length() == 0) {
                txttienganh.setBackground(Color.RED);
                JOptionPane.showMessageDialog(this, "mời nhập lại mã");
                return;
            }

        } catch (Exception e) {
        }
        try {
            boolean a = true;
            td.tiengViet = txttiengviet.getText();

            if (td.tiengViet.length() == 0) {
                txttiengviet.setBackground(Color.RED);
                JOptionPane.showConfirmDialog(this, "bạn mời bạn nhập họ và tên");
                return;
            }

        } catch (Exception e) {
        }

        try {
            boolean a = true;
            td.loaiTu = txtloaitu.getText();

            if (td.loaiTu.length() == 0) {
                txtloaitu.setBackground(Color.RED);
                JOptionPane.showConfirmDialog(this, "bạn mời bạn nhập lai");
                return;
            }

        } catch (Exception e) {
        }
        try {
            td.phatAm = txtphatam.getText();
        } catch (Exception e) {
        }        
    }
    public void newmoi() {
        try {
            txttienganh.setText("");
            txttiengviet.setText("");
            txtphatam.setText("");
            txtloaitu.setText("");
        } catch (Exception e) {
        }
    }

    public void save() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\java2\\data.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listdsnv);
            oos.close();
            fos.close();
        } catch (Exception e) {

        }
    }

    public void open() {
        try {
            fis = new FileInputStream("D:\\java2\\data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            listdsnv = (List<TuDien>) data;
            fis.close();
            ois.close();
            JOptionPane.showMessageDialog(this, "đọc file thành công");
        } catch (Exception e) {

        }

    }

    public void delete() {
        try {

            int xoa = table.getSelectedRow();
            listdsnv.remove(xoa);
        } catch (Exception e) {
        }
    }

    public void exit() {
        try {

            btnexit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
            });
        } catch (Exception e) {
        }
    }

    public void hienthi() {
        try {

            model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (TuDien td : listdsnv) {
                Object[] row = new Object[]{
                    td.tiengAnh, td.tiengViet,td.loaiTu, td.phatAm
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private void txtegmailActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void phongbanActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void txthovatenActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {
        this.exit();
    }
    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {                                        
        open();
        hienthi();
    }                                       

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {                                         
        first();
    }                                        
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        delete();
        hienthi();
    }                                         
    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {                                       
        newmoi();
    }                                      

    private void txtgmailActionPerformed(java.awt.event.ActionEvent evt) {                                                
    }                                        

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {                                        

        add();
        hienthi();
        save();
    }                                       
    private void btnpreviousActionPerformed(java.awt.event.ActionEvent evt) {                                            
        previous();
    }                                           
    private void timkiemKeyReleased(java.awt.event.KeyEvent evt) {                                    
    }                                   
    private void timkiemActionPerformed(java.awt.event.ActionEvent evt) {                                        
    }                                       
    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {                                        
        next();
    }                                       
    private void btnlastActionPerformed(java.awt.event.ActionEvent evt) {                                        
        last();
    }                                       
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                   
        try {

            model = (DefaultTableModel) table.getModel();
            txttienganh.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
            txttiengviet.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
            txtloaitu.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
            txtphatam.setText(model.getValueAt(table.getSelectedRow(), 3).toString());
        } catch (Exception e) {
        }
    }                                  

    private void txtgmailMouseClicked(java.awt.event.MouseEvent evt) {                                      
        txtphatam.setBackground(Color.WHITE);
    }                                     

    private void txtmanvActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void txtmanvMouseClicked(java.awt.event.MouseEvent evt) {                                     
        txttienganh.setBackground(Color.WHITE);
    }                                    

    private void txthovatenMouseClicked(java.awt.event.MouseEvent evt) {                                        
        txttiengviet.setBackground(Color.WHITE);
    }                                       

    private void txttuoiMouseClicked(java.awt.event.MouseEvent evt) {                                     
        txtloaitu.setBackground(Color.WHITE);
    }                                                                    

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {                                        
      
        model.setRowCount(0);
        ArrayList<TuDien> ds = new ArrayList<>();
        try {

            if (timkiem.getText().length() != 0) {
                for (TuDien v : listdsnv) {
                    if (v.getMaNhanVien().toLowerCase().matches(".*" + timkiem.getText() + ".*")) {
                        ds.add(v);
                    }
                }
                if (ds.isEmpty()) {
                    JOptionPane.showConfirmDialog(rootPane, "không tìm thấy");
                } else {
                    for (TuDien v : ds) {
                        Object[] row = new Object[]{
                            v.maNhanVien, v.hoVaTen, v.pb, v.tuoi, v.gmail, v.luong
                        };
                        model.addRow(row);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "nhập thông tin để tìm kiếm");
            }
    }                                       
 catch (Exception e) {
        }
       
    } 
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
            java.util.logging.Logger.getLogger(frmTuDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTuDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTuDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTuDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTuDien().setVisible(true);
            }
        });
    }
    private javax.swing.JTable Table;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnfirst;
    private javax.swing.JButton btnlast;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprevious;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTable table;
    private javax.swing.JLabel timelabt;
    private javax.swing.JTextField timkiem;
    private javax.swing.JTextField txtphatam;
    private javax.swing.JTextField txttiengviet;
    private javax.swing.JTextField txttienganh;
    private javax.swing.JTextField txtloaitu;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
