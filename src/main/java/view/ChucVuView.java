/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChucVu;
import service.QuanLyChucVuServices;
import service.ServiceImpl.ChucVuServicesImpl;

/**
 *
 * @author vuong
 */
public class ChucVuView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private QuanLyChucVuServices qlcvs = new ChucVuServicesImpl();

    public ChucVuView() {
        initComponents();
        txt_id.disable();
        Loadtable();
        setLocationRelativeTo(null);

    }

    void Loadtable() {
        defaultTableModel = (DefaultTableModel) tb_chucVu.getModel();
        defaultTableModel.setRowCount(0);
        for (ChucVu chucVu : qlcvs.getList()) {
            defaultTableModel.addRow(new Object[]{
                chucVu.getId(), chucVu.getMa(), chucVu.getTen()
            });
        }
    }

    private ChucVu getForm() {
        String ma = this.txt_ma.getText().trim();
        String ten = this.txt_ten.getText().trim();

        if (ma.length() == 0) {
//            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã");
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã");
            return null;
        }
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên");
            return null;
        }
        return new ChucVu(null, ma, ten, 1, null, null, null);
    }

    private void clear() {
        this.txt_id.setText("");
        this.txt_ma.setText("");
        this.txt_ten.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_chucVu = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id");

        jLabel2.setText("Mã");

        jLabel3.setText("Tên");

        tb_chucVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Mã", "Tên"
            }
        ));
        tb_chucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chucVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_chucVu);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Quản lý chức vụ");

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(58, 58, 58)
                                .addComponent(txt_ma))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(65, 65, 65)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        ChucVu s = this.getForm();
        if (s == null) {
            return;
        }
        for (String string : this.qlcvs.selectMa()) {
            if (this.txt_ma.getText().equals(string)) {
                JOptionPane.showMessageDialog(this, "Trùng mã");
                return;
            }
        }
        this.qlcvs.insert(s);
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        Loadtable();
        clear();

    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
        if (c != JOptionPane.OK_OPTION) {
            return;
        }
        ChucVu s = this.getForm();
        if (s == null) {
            return;
        }
        if (this.txt_id.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng");
            return;
        }
        this.qlcvs.update(s, Integer.parseInt(this.txt_id.getText()));
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        Loadtable();
        clear();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
        if (c != JOptionPane.OK_OPTION) {
            return;
        }
        if (this.txt_id.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng");
            return;
        }
        this.qlcvs.delete(Integer.parseInt(this.txt_id.getText()));
        JOptionPane.showMessageDialog(this, "Xóa thành công");
        Loadtable();
        clear();

    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tb_chucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chucVuMouseClicked
        // TODO add your handling code here:
         int row = this.tb_chucVu.getSelectedRow();
        if(row==-1){
            return;
        }
        this.txt_id.setText(this.tb_chucVu.getValueAt(row,0).toString());
        this.txt_ma.setText(this.tb_chucVu.getValueAt(row, 1).toString());
        this.txt_ten.setText(this.tb_chucVu.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tb_chucVuMouseClicked

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
            java.util.logging.Logger.getLogger(ChucVuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChucVuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChucVuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChucVuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChucVuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_chucVu;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}