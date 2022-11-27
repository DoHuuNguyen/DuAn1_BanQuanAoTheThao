/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChucVu;
import model.NguoiDung;
import service.QuanLyNguoiDung;
import service.ServiceImpl.NguoiDungimpl;

/**
 *
 * @author thean
 */
public class NguoiDungView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private QuanLyNguoiDung qlnd = new NguoiDungimpl();

    /**
     * Creates new form NguoiDungView
     */
    public NguoiDungView() {
        initComponents();
        load();
    }

    private void load() {
        defaultTableModel = (DefaultTableModel) this.tb_nguoidung.getModel();
        defaultTableModel.setRowCount(0);
        for (NguoiDung nguoiDung : qlnd.getList()) {
            defaultTableModel.addRow(new Object[]{
                nguoiDung.getId(), nguoiDung.getMa(), nguoiDung.getHoTen(),
                nguoiDung.getGioiTinh(), nguoiDung.getNgaySinh(), nguoiDung.getEmail(),
                nguoiDung.getDiaChi(), nguoiDung.getIdChucVu(), nguoiDung.getNgayThem(),
                nguoiDung.getNgaySua(), nguoiDung.getTrangThai()
            });

        }
    }

    private int gt() {
        if (cbx_gioitinh.getSelectedItem() == "Nam") {
            return 1;
        } else {
            return 0;
        }
    }

    public void addCbxidchucvu() {

    }

    private NguoiDung getForm() {
        String ma = this.txt_ma.getText().trim();
        String ten = this.txt_hoten.getText().trim();
        int gioiTinh = gt();
        String ngaysinh = this.txt_ngaysinh.getText().trim();
        Date ngaySinh = (Date.valueOf(ngaysinh));
        String email = this.txt_email.getText().trim();
        String diachi = this.txt_diachi.getText().trim();
        ChucVu chucvu = (ChucVu) cbx_chucvu.getSelectedItem();
        String ngaythem = this.txt_ngaythem.getText().trim();
        String ngaysua = this.txt_ngaysua.getText().trim();
        Date ngayThem = (Date.valueOf(ngaythem));
        Date ngaySua = (Date.valueOf(java.time.LocalDate.now()));
        if (ma.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã");
            return null;
        }
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên");
            return null;
        }
        if (ngaysinh.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Ngày Sinh");
            return null;
        }
        if (email.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên Email");
            return null;
        }
        if (diachi.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên Địa Chỉ");
            return null;
        }

        if (ngaythem.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên Ngày Thêm");
            return null;
        }
        if (ngaysua.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên Ngày Sửa");
            return null;
        }
        return new NguoiDung(null, ma, ten, gioiTinh, ngaySinh, email, diachi, chucvu, ten, WIDTH, ngayThem, ngaySua);

    }

    private void clear() {
        this.txt_id.setText("");
        this.txt_ma.setText("");
        this.txt_hoten.setText("");
        this.cbx_gioitinh.setSelectedIndex(0);
        this.txt_ngaysinh.setText("");
        this.txt_email.setText("");
        this.txt_diachi.setText("");
        this.cbx_chucvu.setSelectedIndex(0);
        this.txt_ngaythem.setText("");
        this.txt_ngaysua.setText("");
        this.txt_trangthai.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_ma = new javax.swing.JTextField();
        txt_hoten = new javax.swing.JTextField();
        txt_ngaysinh = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        txt_ngaythem = new javax.swing.JTextField();
        txt_ngaysua = new javax.swing.JTextField();
        txt_trangthai = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nguoidung = new javax.swing.JTable();
        cbx_gioitinh = new javax.swing.JComboBox<>();
        cbx_chucvu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("NGƯỜI DÙNG");

        jLabel2.setText("ID :");

        jLabel3.setText(" ");

        jLabel4.setText("Họ Tên :");

        jLabel5.setText("Giới Tính :");

        jLabel6.setText("Ngày Sinh :");

        jLabel7.setText("Email :");

        jLabel8.setText("Địa Chỉ :");

        jLabel9.setText("ID Chức Vụ :");

        jLabel10.setText("Ngày Thêm :");

        jLabel11.setText("Ngày Sửa :");

        jLabel12.setText("Trạng Thái :");

        jLabel13.setText("Ảnh :");

        txt_trangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_trangthaiActionPerformed(evt);
            }
        });

        jLabel14.setText("Mã :");

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

        tb_nguoidung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Họ Tên", "Giới Tính", "Ngày Sinh", "Email", "Địa Chỉ", "ID Chức Vụ", "Ngày Thêm", "Ngày Sửa", "Trạng Thái"
            }
        ));
        jScrollPane1.setViewportView(tb_nguoidung);

        cbx_gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_email))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel14))
                                                .addComponent(jLabel2))
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_hoten, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                            .addComponent(txt_id)
                                            .addComponent(txt_ma)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbx_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btn_them)
                                .addGap(32, 32, 32)
                                .addComponent(btn_sua))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbx_chucvu, 0, 180, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_diachi)
                                        .addComponent(txt_ngaythem)
                                        .addComponent(txt_ngaysua)
                                        .addComponent(txt_trangthai, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                                .addGap(53, 53, 53)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_xoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextField11))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(cbx_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ngaythem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11)
                            .addComponent(txt_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12)
                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_trangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_trangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_trangthaiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        NguoiDung nd = this.getForm();
        if (nd == null) {
            return;
        }
        for (String string : this.qlnd.selectma()) {
            if (this.txt_ma.getText().equals(string)) {
                JOptionPane.showMessageDialog(this, "Trùng mã");
                return;
            }
        }
        this.qlnd.insert(nd);
        JOptionPane.showMessageDialog(this, "thêm thành công");
        load();
        clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int c = JOptionPane.showConfirmDialog(this, "bạn chăc chắn muốn sửa?");
        if (c != JOptionPane.OK_OPTION) {
            return;
        }
        NguoiDung nd = this.getForm();
        if (nd == null) {
            return;
        }
        if (txt_id.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn");
            return;
        }
        this.qlnd.update(nd, Integer.valueOf(txt_id.getText()));
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        load();
        clear();

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(this, "bạn chăc chắn muốn xóa?");
        if (c != JOptionPane.OK_OPTION) {
            return;
        }

        if (txt_id.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn");
            return;
        }
        this.qlnd.delete(Integer.valueOf(txt_id.getText()));
        JOptionPane.showMessageDialog(this, "xóa thành công");
        load();
        clear();

    }//GEN-LAST:event_btn_xoaActionPerformed

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
            java.util.logging.Logger.getLogger(NguoiDungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NguoiDungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NguoiDungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NguoiDungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NguoiDungView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbx_chucvu;
    private javax.swing.JComboBox<String> cbx_gioitinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTable tb_nguoidung;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_ngaysua;
    private javax.swing.JTextField txt_ngaythem;
    private javax.swing.JTextField txt_trangthai;
    // End of variables declaration//GEN-END:variables
}
