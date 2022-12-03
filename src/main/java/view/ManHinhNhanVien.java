package view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.NguoiDung;

public class ManHinhNhanVien extends javax.swing.JFrame {
    private NguoiDung ng;
    public ManHinhNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(this, "nó vào đây");
    }
    public ManHinhNhanVien(NguoiDung ng) {
        this.ng = ng;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Màn Hinh Nhân Viên");
        fillData(ng);
    }
    public ImageIcon resizeImage(String imgPath) {
        ImageIcon imageIcon = new ImageIcon(imgPath);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
    public void fillData(NguoiDung nguoiDung){
        lblCHucVu.setText(nguoiDung.getIdChucVu().toString());
        lblMa.setText(nguoiDung.getMa());
        lblTenNV.setText(nguoiDung.getHoTen());
        lblNgaySinh.setText(nguoiDung.getNgaySinh().toString());
        lblEmai.setText(nguoiDung.getEmail());
        lblDiaChi.setText(nguoiDung.getDiaChi());
        lblAnh.setIcon(resizeImage(nguoiDung.getAnh()));
        lblGT.setText(nguoiDung.getGioiTinh()==1?"Nam":"Nữ");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnDoiMK = new javax.swing.JButton();
        lblMa = new javax.swing.JLabel();
        lblCHucVu = new javax.swing.JLabel();
        lblGT = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblEmai = new javax.swing.JLabel();
        btnDoiMK1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuMauSac = new javax.swing.JMenuItem();
        menuSize = new javax.swing.JMenuItem();
        menuMonTT = new javax.swing.JMenuItem();
        menuHTTR = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuDoanhThu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTenNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Mã :");

        jLabel3.setText("Chức Vụ :");

        jLabel4.setText("Ngày Sinh :");

        jLabel5.setText("Địa Chỉ :");

        jLabel6.setText("Email :");

        jLabel7.setText("Giới Tính :");

        btnDoiMK.setText("Đổi Mật Khẩu");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        btnDoiMK1.setText("Đăng Xuất");
        btnDoiMK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMK1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(lblTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCHucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGT, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmai, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDoiMK1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel2)
                                                            .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel3))
                                                    .addComponent(lblCHucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7))
                                            .addComponent(lblGT, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4))
                                    .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(lblEmai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoiMK)
                    .addComponent(btnDoiMK1))
                .addGap(19, 19, 19))
        );

        jMenu1.setText("Sản Phẩm");

        menuMauSac.setText("Màu Sắc");
        menuMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMauSacMouseClicked(evt);
            }
        });
        menuMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMauSacActionPerformed(evt);
            }
        });
        jMenu1.add(menuMauSac);

        menuSize.setText("Size");
        menuSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSizeMouseClicked(evt);
            }
        });
        menuSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSizeActionPerformed(evt);
            }
        });
        jMenu1.add(menuSize);

        menuMonTT.setText("Môn Thể Thao");
        menuMonTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMonTTMouseClicked(evt);
            }
        });
        menuMonTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMonTTActionPerformed(evt);
            }
        });
        jMenu1.add(menuMonTT);

        menuHTTR.setText("Hình Thức Thanh Toán");
        menuHTTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHTTRActionPerformed(evt);
            }
        });
        jMenu1.add(menuHTTR);

        jMenuItem1.setText("Chi Tiết Sản Phẩm");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Bán Hàng");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        menuDoanhThu.setText("Thống Kê");
        menuDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDoanhThuMouseClicked(evt);
            }
        });
        menuDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDoanhThuActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Doanh Thu Hàng Tháng");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuDoanhThu.add(jMenuItem2);

        jMenuItem3.setText("Thống Kê");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuDoanhThu.add(jMenuItem3);

        jMenuBar1.add(menuDoanhThu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMauSacMouseClicked
        new MauSacView().setVisible(true);
    }//GEN-LAST:event_menuMauSacMouseClicked

    private void menuMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMauSacActionPerformed
        // TODO add your handling code here:

        new MauSacView().setVisible(true);
    }//GEN-LAST:event_menuMauSacActionPerformed

    private void menuSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSizeMouseClicked

        new SizeView().setVisible(true);
    }//GEN-LAST:event_menuSizeMouseClicked

    private void menuSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSizeActionPerformed
        // TODO add your handling code here:

        new SizeView().setVisible(true);
    }//GEN-LAST:event_menuSizeActionPerformed

    private void menuMonTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMonTTMouseClicked

        new MonTheThaoView().setVisible(true);
    }//GEN-LAST:event_menuMonTTMouseClicked

    private void menuMonTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMonTTActionPerformed

        new MonTheThaoView().setVisible(true);
    }//GEN-LAST:event_menuMonTTActionPerformed

    private void menuHTTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHTTRActionPerformed

        new HinhThucThanhToanView().setVisible(true);
    }//GEN-LAST:event_menuHTTRActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        new ChiTietSanPhamView().setVisible(true);
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ChiTietSanPhamView().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked

        new BanHangView(ng).setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void menuDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDoanhThuMouseClicked

    }//GEN-LAST:event_menuDoanhThuMouseClicked

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        dispose();
        new ChangePass().setVisible(true);
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void btnDoiMK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMK1ActionPerformed
        dispose();
        new DangNhapView().setVisible(true);
    }//GEN-LAST:event_btnDoiMK1ActionPerformed

    private void menuDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDoanhThuActionPerformed
       new  DoanhThu().setVisible(true);
    }//GEN-LAST:event_menuDoanhThuActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         DoanhThu dt = new DoanhThu();
        dt.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new ThongKeGanChiTiet().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(ManHinhNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinhNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinhNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinhNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinhNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnDoiMK1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblCHucVu;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmai;
    private javax.swing.JLabel lblGT;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JMenu menuDoanhThu;
    private javax.swing.JMenuItem menuHTTR;
    private javax.swing.JMenuItem menuMauSac;
    private javax.swing.JMenuItem menuMonTT;
    private javax.swing.JMenuItem menuSize;
    // End of variables declaration//GEN-END:variables
}
