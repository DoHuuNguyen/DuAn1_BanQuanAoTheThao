/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.io.File;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Account;
import model.ChucVu;
import model.NguoiDung;
import service.QuanLyAccountServices;
import service.QuanLyChucVuServices;
import service.QuanLyNguoiDung;
import service.ServiceImpl.AccountSevicesImpl;
import service.ServiceImpl.ChucVuServicesImpl;
import service.ServiceImpl.NguoiDungimpl;

/**
 *
 * @author thean
 */
public class NguoiDungView extends javax.swing.JFrame {

    private NguoiDung ng;
    private String imgPath = "";
    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private QuanLyNguoiDung qlnd = new NguoiDungimpl();
    private QuanLyChucVuServices qlcv = new ChucVuServicesImpl();
    private QuanLyAccountServices qlAc = new AccountSevicesImpl();

    /**
     * Creates new form NguoiDungView
     */
    public NguoiDungView() {
        initComponents();
        load();
        addCbxidchucvu();
        setLocationRelativeTo(null);
    }

    public NguoiDungView(NguoiDung ng) {
        this.ng = ng;
        initComponents();
        load();
        addCbxidchucvu();
        setLocationRelativeTo(null);
    }

    private void load() {
        defaultTableModel = (DefaultTableModel) this.tb_nguoidung.getModel();
        defaultTableModel.setRowCount(0);
        for (NguoiDung nguoiDung : qlnd.getList()) {
            defaultTableModel.addRow(new Object[]{
                nguoiDung.getId(),
                nguoiDung.getMa(),
                nguoiDung.getHoTen(),
                nguoiDung.getGioiTinh() == 1 ? "Nam" : "Nữ",
                nguoiDung.getNgaySinh(),
                nguoiDung.getEmail(),
                nguoiDung.getDiaChi(),
                nguoiDung.getIdChucVu().getTen(),
                nguoiDung.getAnh() == null ? "Chưa Có Ảnh" : nguoiDung.getAnh(),
                nguoiDung.getTrangThai()
            });

        }
    }

    private void loadData(int row) {
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbx_chucvu.getModel();
        txt_id.setText(tb_nguoidung.getValueAt(row, 0).toString());
        txt_ma.setText(tb_nguoidung.getValueAt(row, 1).toString());
        txt_hoten.setText(tb_nguoidung.getValueAt(row, 2).toString());
        txt_ngaysinh.setText(tb_nguoidung.getValueAt(row, 4).toString());
        txt_email.setText(tb_nguoidung.getValueAt(row, 5).toString());
        txt_diachi.setText(tb_nguoidung.getValueAt(row, 6).toString());
        cbx_gioitinh.setSelectedItem(tb_nguoidung.getValueAt(row, 3).toString());
        defaultComboBoxModel.setSelectedItem(tb_nguoidung.getValueAt(row, 7));
        lblImg.setIcon(resizeImage(tb_nguoidung.getValueAt(row, 8).toString()));
        imgPath = tb_nguoidung.getValueAt(row, 8).toString();
    }

    private int gt() {
        if (cbx_gioitinh.getSelectedItem() == "Nam") {
            return 1;
        } else {
            return 0;
        }
    }

    public void addCbxidchucvu() {
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbx_chucvu.getModel();
        defaultComboBoxModel.addAll(qlcv.getList());
        cbx_chucvu.setSelectedIndex(0);
    }

    private NguoiDung getForm() {
        String ma = this.txt_ma.getText().trim();
        String ten = this.txt_hoten.getText().trim();
        int gioiTinh = gt();
        String ngaysinh = this.txt_ngaysinh.getText().trim();
        Date ngaySinh;
        String email = this.txt_email.getText().trim();
        String diachi = this.txt_diachi.getText().trim();
        ChucVu chucvu = (ChucVu) cbx_chucvu.getSelectedItem();
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
        try {
            ngaySinh = (Date.valueOf(ngaysinh));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngay sinh sai dinh dang");
            return null;
        }
        return new NguoiDung(null, ma, ten, gioiTinh, ngaySinh, email, diachi, chucvu, imgPath, 1, null, null);

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
        this.lblImg.setIcon(null);
    }

    public Account createAccount(NguoiDung ng) {
        return new Account(null, txt_email.getText().trim(),
                "1", ng, 1);
    }

    public ImageIcon resizeImage(String imgPath) {
        ImageIcon imageIcon = new ImageIcon(imgPath);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
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
        jLabel13 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_ma = new javax.swing.JTextField();
        txt_hoten = new javax.swing.JTextField();
        txt_ngaysinh = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nguoidung = new javax.swing.JTable();
        cbx_gioitinh = new javax.swing.JComboBox<>();
        cbx_chucvu = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();

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

        jLabel13.setText("Ảnh");

        txt_id.setEditable(false);

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
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Họ Tên", "Giới Tính", "Ngày Sinh", "Email", "Địa Chỉ", "Chức Vụ", "Link Ảnh", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_nguoidung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nguoidungMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_nguoidung);

        cbx_gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        lblImg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblImg.setName(""); // NOI18N
        lblImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel14))
                                .addComponent(jLabel2))
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addComponent(btn_them)
                        .addGap(26, 26, 26)
                        .addComponent(btn_sua)
                        .addGap(28, 28, 28)
                        .addComponent(btn_xoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(cbx_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbx_chucvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_diachi)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ngaysinh)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel13)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa)
                            .addComponent(jLabel13)
                            .addComponent(btn_clear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel7)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbx_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbx_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

//        if(txt_email.getText().trim().equals(this.qlnd.email(txt_email.getText().trim()))){
//            JOptionPane.showMessageDialog(this, "email đã tồn tại");
//            return;
//        }
        this.qlnd.insert(nd);

        this.qlAc.insert(createAccount(nd));
        JOptionPane.showMessageDialog(this, "thêm thành công");
        load();
        clear();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        if (txt_id.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn");
            return;
        }
        int c = JOptionPane.showConfirmDialog(this, "bạn chăc chắn muốn sửa?");
        if (c != JOptionPane.OK_OPTION) {
            return;
        }
        NguoiDung nd = this.getForm();
        if (nd == null) {
            return;
        }

        this.qlnd.update(nd, Integer.valueOf(txt_id.getText()));
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        load();
        clear();

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        if (txt_id.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn");
            return;
        }
        int c = JOptionPane.showConfirmDialog(this, "bạn chăc chắn muốn xóa?");
        if (c != JOptionPane.OK_OPTION) {
            return;
        }

        this.qlnd.delete(Integer.valueOf(txt_id.getText()));
        JOptionPane.showMessageDialog(this, "xóa thành công");
        load();
        clear();

    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tb_nguoidungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nguoidungMouseClicked
        int row = tb_nguoidung.getSelectedRow();
        loadData(row);
    }//GEN-LAST:event_tb_nguoidungMouseClicked

    private void lblImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImgMouseClicked
        try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "jpg", "png");
            fileChooser.setFileFilter(filter);
            fileChooser.setMultiSelectionEnabled(false);
            int x = fileChooser.showDialog(this, "Select file");
            if (x == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                imgPath = file.getAbsolutePath();
                lblImg.setIcon(resizeImage(file.getAbsolutePath()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn ảnh !");
        }
    }//GEN-LAST:event_lblImgMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        this.clear();
    }//GEN-LAST:event_btn_clearActionPerformed

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
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbx_chucvu;
    private javax.swing.JComboBox<String> cbx_gioitinh;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JTable tb_nguoidung;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ngaysinh;
    // End of variables declaration//GEN-END:variables
}
