/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.HinhThucThanhToan;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.NguoiDung;
import service.QuanLyChiTietHoaDon;
import service.QuanLyChiTietSanPham;
import service.QuanLyHinhThucThanhToan;
import service.QuanLyHoaDon;
import service.QuanLyMauSac;
import service.QuanLyMonTheThao;
import service.QuanLySize;
import service.ServiceImpl.ChiTietSanPhamServiceImpl;
import service.ServiceImpl.HinhThucThanhToanSeviceimpl;
import service.ServiceImpl.HoaDonChiTietServiceImpl;
import service.ServiceImpl.HoaDonServiceImpl;
import service.ServiceImpl.MauSacServiceImpl;
import service.ServiceImpl.MonTheThaoServiceImpl;
import service.ServiceImpl.SizeServiceImlp;

/**
 *
 * @author Acer
 */
public class BanHangView extends javax.swing.JFrame {

    private NguoiDung ng;
    DefaultTableModel dtm;
    DefaultComboBoxModel dtcb;
    private QuanLyChiTietSanPham qlSP = new ChiTietSanPhamServiceImpl();
    private QuanLyHoaDon qlHD = new HoaDonServiceImpl();
    private QuanLyChiTietHoaDon qlCTHD = new HoaDonChiTietServiceImpl();
    private QuanLyHinhThucThanhToan qlHTTT = new HinhThucThanhToanSeviceimpl();
    private QuanLySize qlsize = new SizeServiceImlp();
    private QuanLyMonTheThao qlMtt = new MonTheThaoServiceImpl();
    private QuanLyMauSac qlMs = new MauSacServiceImpl();
    DefaultComboBoxModel dcbb;
    private ArrayList<ChiTietSanPham> listSP = new ArrayList<>();
    private ArrayList<HoaDon> listHD = new ArrayList<>();
    private int firtRecordHD = 0, soTrangHD, countHD, tempHD = 1;
    private int firtRecordSP = 0, soTrangSP, countSP, tempSP = 1;

    public BanHangView() {
        initComponents();
        setLocationRelativeTo(null);

    }

    public BanHangView(NguoiDung nguoi) {
        this.ng = nguoi;
        initComponents();
        setTitle("Màn Hình Bán Hàng");
        addRowGioHang();
        addRowHoaDon(firtRecordHD, qlHD.select(ng));
        listHD = qlHD.select(ng);
        setPageHD(qlHD.select(ng).size());
        setAnimationHD(tempHD, soTrangHD);
        getHinhTT();
        setLocationRelativeTo(null);
        txtTienThua.disable();
        txtTongTien.disable();
        b.setEditable(false);
        loadSanPham(firtRecordSP, this.qlSP.getList());
        listSP = qlSP.getList();
        setPageSP(qlSP.getList().size());
        setAnimationSP(tempSP, soTrangSP);
    }

    public void setPageSP(int size) {
        countSP = size;
        if (countSP % 13 == 0) {
            soTrangSP = countSP / 13;
        } else {
            soTrangSP = countSP / 13 + 1;
        }
    }

    public void inBill() {
        b.setText("                            Cửa Hàng Quần Áo \n");
        b.setText(b.getText() + "---------------------------------------------------------------------\n");
        b.setText(b.getText() + "  Sản Phẩm \tSố Lượng \tGiá" + "\n");
        b.setText(b.getText() + "---------------------------------------------------------------------\n");

        DefaultTableModel df = (DefaultTableModel) tb_giohang.getModel();

        // get table Product details
        for (int i = 0; i < tb_giohang.getRowCount(); i++) {
            String Name = df.getValueAt(i, 2).toString();
            String Qty = df.getValueAt(i, 3).toString();
            String Price = df.getValueAt(i, 5).toString();

            b.setText(b.getText() + "  " + Name + "\t" + Qty + "\t" + Price + "\n");
        }

        b.setText(b.getText() + "---------------------------------------------------------------------\n");
        b.setText(b.getText() + "Tổng Tiền : \t\t" + txtTongTien.getText() + "\n");
        b.setText(b.getText() + "Tiền Trả      : \t\t" + txtTienKhachDua.getText() + "\n");
        b.setText(b.getText() + "Tiền Thừa   : \t\t" + txtTienThua.getText() + "\n");
        b.setText(b.getText() + "---------------------------------------------------------------------\n");
        b.setText(b.getText() + "                     Cảm Ơn Vì Đã Mua Hàng...!" + "\n");
        b.setText(b.getText() + "---------------------------------------------------------------------\n");
        b.setText(b.getText() + "                    Cao Đẳng FPT POLYTECHNIC \n");
    }

    public void setPageHD(int size) {
        countHD = size;
        if (countHD % 8 == 0) {
            soTrangHD = countHD / 8;
        } else {
            soTrangHD = countHD / 8 + 1;
        }
    }

    public void setAnimationHD(int tempHD, int soTrangHD) {
        lblTrangHD.setText(tempHD + " / " + soTrangHD);
    }

    public void setAnimationSP(int tempSP, int soTrangSP) {
        lblTrangSP.setText(tempSP + " / " + soTrangSP);
    }

    public int getLuaChon() {
        if (rdoDaTT.isSelected()) {
            return 1;
        } else if (rdoChuaTT.isSelected()) {
            return 0;
        } else {
            return 2;
        }
    }

    private void loadSanPham(int page, ArrayList<ChiTietSanPham> list) {
        dtm = (DefaultTableModel) this.tb_sanpham.getModel();
        dtm.setRowCount(0);
        for (int i = page; i < page + 13; i++) {
            try {
                Object[] row = {
                    list.get(i).getId(),
                    list.get(i).getMa(),
                    list.get(i).getTen(),
                    list.get(i).getIdMauSac().getTen(),
                    list.get(i).getIdSize().getSize(),
                    list.get(i).getIdMonTheThao().getTen(),
                    list.get(i).getGia(),
                    list.get(i).getSoLuong()
                };
                dtm.addRow(row);
            } catch (Exception e) {
                break;
            }
        }
    }

    public HoaDonChiTiet getHoaDonChiTiet() {
        int row = tb_giohang.getSelectedRow();
        if (row >= 0) {
            Integer id = (Integer) tb_giohang.getValueAt(row, 0);
            return qlCTHD.search(id);
        }
        return null;
    }

    public void addRowHoaDon(int page, ArrayList<HoaDon> list) {
        int stt = 1;
        dtm = (DefaultTableModel) tblHoaDon.getModel();
        dtm.setRowCount(0);
        for (int i = page; i < page + 8; i++) {
            try {
                dtm.addRow(new Object[]{
                    stt,
                    list.get(i).getMa(),
                    list.get(i).getIdNguoiDung().getHoTen(),
                    list.get(i).getNgayMua(),
                    list.get(i).getTinhTrang() == 1 ? "Đã thanh toán" : "Chưa"
                });
                stt++;
            } catch (Exception e) {
                break;
            }
        }
    }

    public void loadHoaDon(HoaDon hd) {
        int stt = 1;
        dtm = (DefaultTableModel) tblHoaDon.getModel();
        dtm.setRowCount(0);
        dtm.addRow(new Object[]{
            stt,
            hd.getMa(),
            hd.getIdNguoiDung(),
            hd.getNgayMua()
        });
    }

    public HoaDon getHoaDon() {
        int row = tblHoaDon.getSelectedRow();
        if (row >= 0) {
            String ma = tblHoaDon.getValueAt(row, 1).toString();
            return qlHD.searchByMa(ma);
        }
        return null;
    }

    public ChiTietSanPham getSanPham() {
        int row = tb_sanpham.getSelectedRow();
        if (row >= 0) {
            Integer id = (Integer) tb_sanpham.getValueAt(row, 0);
            return qlSP.searchID(id);
        }
        return null;
    }

    public void addRowGioHang() {
        dtm = (DefaultTableModel) tb_giohang.getModel();
        dtm.setRowCount(0);
        for (HoaDonChiTiet hoaDonChiTiet : qlCTHD.select(getHoaDon())) {
            dtm.addRow(new Object[]{
                hoaDonChiTiet.getId(),
                //                hoaDonChiTiet.getIdHoaDon().getMa(),
                //                hoaDonChiTiet.getIdSanPham().getId(),
                hoaDonChiTiet.getIdHoaDon().getMa(),
                hoaDonChiTiet.getIdSanPham().getMa(),
                hoaDonChiTiet.getSoLuong(),
                hoaDonChiTiet.getDonGia(),
                hoaDonChiTiet.getDonGia() * hoaDonChiTiet.getSoLuong()
            });
        }
    }

    public void fillData(HoaDon hd) {
        txtma.setText(hd.getMa());
        txNguoiTao.setText(hd.getIdNguoiDung().getHoTen());
        txtNgayTao.setText(hd.getNgayMua().toString());
        txtTongTien.setText(hd.getTongTien() + "");
    }

    private HoaDonChiTiet createHdct() {
        return new HoaDonChiTiet(null, getHoaDon(), getSanPham(), Integer.parseInt(txtSoLuong.getText()), getSanPham().getGia(), Integer.parseInt(txtSoLuong.getText()) * getSanPham().getGia(), 1);
    }

    public void tinhTien() {
        long tien = qlCTHD.getThanhTien(getHoaDon());
        qlHD.updateTongTien(getHoaDon().getId(), tien);
    }

    public void getHinhTT() {
        dtcb = (DefaultComboBoxModel) this.cbbHTTT.getModel();
        dtcb.addAll(qlHTTT.getlist());
        cbbHTTT.setSelectedIndex(0);
    }

    public HoaDon create() {
        int ma = (int) Math.floor(((Math.random() * 899999) + 100000));
        return new HoaDon(null, String.valueOf(ma), ng, (HinhThucThanhToan) cbbHTTT.getSelectedItem(), null, null);
    }

    public void clear() {
        dtm = (DefaultTableModel) tb_giohang.getModel();
        dtm.setRowCount(0);
        txtma.setText("");
        txtTienKhachDua.setText("0");
        txtTongTien.setText("0");
        txtTienThua.setText("0");
        txtNgayTao.setText("");
        txNguoiTao.setText("");
        txtTongTien.setText("");
        txtSoLuong.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_giohang = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_sanpham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtma = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txNguoiTao = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbbHTTT = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        rdoDaTT = new javax.swing.JRadioButton();
        rdoChuaTT = new javax.swing.JRadioButton();
        rdoALL = new javax.swing.JRadioButton();
        btntaoHD = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        btnLui = new javax.swing.JButton();
        btnTien = new javax.swing.JButton();
        lblTrangHD = new javax.swing.JLabel();
        lblTrangSP = new javax.swing.JLabel();
        btnTienSP = new javax.swing.JButton();
        btnLuiSP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        b = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Người Tạo", "Ngày Tạo", "Trang Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        tb_giohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Hóa đơn", "Sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tb_giohang);

        tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã", "Tên", "Màu Sắc", "Size", "Môn Thể Thao", "Giá", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanphamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_sanpham);

        jLabel1.setText("Mã Hóa đơn :");

        jLabel2.setText("Người Tạo :");

        jLabel3.setText("Ngày Tạo :");

        txtTongTien.setEditable(false);
        txtTongTien.setText("0");
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel4.setText("Tổng tiền :");

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel11.setText("Hình Thức TT:");

        jLabel6.setText("Tiền Thừa :");

        txtTienThua.setEditable(false);
        txtTienThua.setText("0");
        txtTienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThuaActionPerformed(evt);
            }
        });

        jLabel7.setText("Tiền Khách Trả :");

        txtTienKhachDua.setText("0");
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThanhToan)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addComponent(jLabel7))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addContainerGap())
        );

        buttonGroup1.add(rdoDaTT);
        rdoDaTT.setText("Đã Thanh Toán");
        rdoDaTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaTTMouseClicked(evt);
            }
        });
        rdoDaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChuaTT);
        rdoChuaTT.setText("Chưa Thanh Toán");
        rdoChuaTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChuaTTMouseClicked(evt);
            }
        });
        rdoChuaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChuaTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoALL);
        rdoALL.setText("Tất Cả");
        rdoALL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoALLMouseClicked(evt);
            }
        });

        btntaoHD.setText("Tạo Hóa Đơn");
        btntaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaoHDActionPerformed(evt);
            }
        });

        jLabel9.setText("Sản Phẩm");

        jLabel10.setText("Giỏ Hàng");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        btnLui.setText("<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        btnTien.setText(">");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });

        lblTrangHD.setText("0/0");

        lblTrangSP.setText("0/0");

        btnTienSP.setText(">");
        btnTienSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienSPActionPerformed(evt);
            }
        });

        btnLuiSP.setText("<");
        btnLuiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiSPActionPerformed(evt);
            }
        });

        b.setColumns(20);
        b.setRows(5);
        jScrollPane1.setViewportView(b);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Hóa Đơn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoa))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLuiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTrangSP)
                                .addGap(18, 18, 18)
                                .addComponent(btnTienSP, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTrangHD)
                        .addGap(18, 18, 18)
                        .addComponent(btnTien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoDaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(rdoChuaTT)
                        .addGap(18, 18, 18)
                        .addComponent(rdoALL))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntaoHD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(109, 109, 109)))))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btntaoHD))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLui)
                                .addComponent(btnTien)
                                .addComponent(lblTrangHD))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoDaTT)
                                .addComponent(rdoChuaTT)
                                .addComponent(rdoALL))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(btnXoa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLuiSP)
                                        .addComponent(btnTienSP)
                                        .addComponent(lblTrangSP)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        // TODO add your handling code here:
        if (getHoaDon() == null) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn hóa đơn cụ thể !");
        } else {
            if (getHoaDon().getTinhTrang() == 1) {
                JOptionPane.showMessageDialog(this, "Hóa đơn này đã được thanh toán");
            } else {
                int row = tb_sanpham.getSelectedRow();
                if (Integer.parseInt(tb_sanpham.getValueAt(row, 7).toString()) < 0) {
                    JOptionPane.showMessageDialog(this, "Sản phẩm đã hết");
                    return;
                }
                int choose = JOptionPane.showConfirmDialog(rootPane, "Thêm vào hóa đơn ?");
                if (choose != JOptionPane.OK_OPTION) {
                    return;
                }
                String soluong = JOptionPane.showInputDialog("Nhập số lượng :");
                int soLuongTong = Integer.parseInt(tb_sanpham.getValueAt(row, 7).toString());
                if (soLuongTong - Integer.parseInt(soluong) < 0) {
                    JOptionPane.showMessageDialog(this, "Không đủ sản phẩm trong kho");
                    return;
                }
                int sl = soLuongTong - Integer.parseInt(soluong);
                this.qlSP.updateSL(Integer.valueOf(this.tb_sanpham.getValueAt(row, 0).toString()), sl);
                this.txtSoLuong.setText(soluong);
                if (choose == JOptionPane.YES_OPTION) {
                    qlCTHD.insert(createHdct());
//                qlSP.delete((Integer) tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 0));
                    tinhTien();
                    fillData(getHoaDon());
                    addRowGioHang();
                    loadSanPham(firtRecordSP, this.qlSP.getList());
                }
            }
        }
    }//GEN-LAST:event_tb_sanphamMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        Double tienThua = Double.valueOf(txtTienThua.getText());
        int row = tblHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn");
            return;
        }
        if (getHoaDon().getTinhTrang() == 1) {
            JOptionPane.showMessageDialog(this, "Hóa đơn này đã được thanh toán");
        } else if (tb_giohang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Giỏ Hàng Không Có Sản Phẩm");
        } else if (txtTienKhachDua.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số Tiền Khách Thanh Toán");
        } else if (tienThua < 0) {
            JOptionPane.showMessageDialog(this, "Khách hàng chưa đưa đủ tiền");
        } else if (tienThua >= 0) {
            inBill();
            JOptionPane.showMessageDialog(this, "Trả lại tiền thừa cho khách " + tienThua + " VND");
            qlHD.update(txtma.getText().trim());
            addRowHoaDon(firtRecordHD, qlHD.select(ng));
            clear();
            int traLoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không", "In Hóa Đơn", JOptionPane.YES_NO_OPTION);
            if (traLoi == JOptionPane.YES_OPTION) {
                try {
                    b.print();
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void btntaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaoHDActionPerformed
        qlHD.insert(create());
        dtm = (DefaultTableModel) tb_giohang.getModel();
        dtm.setRowCount(0);
        addRowHoaDon(firtRecordHD, qlHD.select(0, ng));
        setPageHD(qlHD.select(0, ng).size());
        setAnimationHD(tempHD, soTrangHD);
        rdoChuaTT.setSelected(true);
        clear();
    }//GEN-LAST:event_btntaoHDActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        fillData(getHoaDon());
        addRowGioHang();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void rdoDaTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaTTMouseClicked
        addRowHoaDon(firtRecordHD, this.qlHD.select(1, ng));
        setPageHD(qlHD.select(1, ng).size());
        setAnimationHD(tempHD, soTrangHD);
    }//GEN-LAST:event_rdoDaTTMouseClicked

    private void rdoChuaTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChuaTTMouseClicked
        addRowHoaDon(firtRecordHD, this.qlHD.select(0, ng));
        setPageHD(qlHD.select(0, ng).size());
        setAnimationHD(tempHD, soTrangHD);
    }//GEN-LAST:event_rdoChuaTTMouseClicked

    private void rdoALLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoALLMouseClicked
        setPageHD(qlHD.select(ng).size());
        addRowHoaDon(firtRecordHD, this.qlHD.select(ng));
        setAnimationHD(tempHD, soTrangHD);
    }//GEN-LAST:event_rdoALLMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tb_giohang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "Hệ thống chưa hiểu yêu cầu !");
        } else {
            if (getHoaDon().getTinhTrang() == 1) {
                JOptionPane.showMessageDialog(rootPane, "Không thể xóaIdSp sản phẩm khi hóa đơn đã thanh toán !");
            } else {
                DefaultTableModel tbmode = (DefaultTableModel) tb_giohang.getModel();
                String IdSp = tb_giohang.getValueAt(row, 2).toString();
                int SLThayDoi = Integer.valueOf(tb_giohang.getValueAt(row, 3).toString()) + qlSP.selectSoLuongTon(IdSp);
                this.qlSP.updateNe(IdSp, SLThayDoi);
                this.qlCTHD.delete(Integer.valueOf(tb_giohang.getValueAt(row, 0).toString()));
                int tongTien = Integer.parseInt(txtTongTien.getText()) - Integer.parseInt(tb_giohang.getValueAt(row, 5).toString());
                txtTongTien.setText(String.valueOf(tongTien));
                loadSanPham(firtRecordSP, this.qlSP.getList());
                tbmode.removeRow(row);
                JOptionPane.showMessageDialog(rootPane, "Xóa Sản Phẩm Thành Công!");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void rdoDaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDaTTActionPerformed

    private void txtTienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuaActionPerformed

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed

    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void txtTienKhachDuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaKeyTyped

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienActionPerformed
        firtRecordHD += 8;
        tempHD++;
        if (firtRecordHD <= countHD) {
            addRowHoaDon(firtRecordHD, listHD);
            setAnimationHD(tempHD, soTrangHD);
        } else {
            if (countHD % 8 == 0) {
                firtRecordHD = countHD - 8;
            } else {
                firtRecordHD = countHD - (countHD % 8);
            }
            tempHD = soTrangHD;
        }
        int luachon = getLuaChon();
        switch (luachon) {
            case 1 -> {
                addRowHoaDon(firtRecordHD, this.qlHD.select(1, ng));
                setPageHD(qlHD.select(1, ng).size());
            }
            case 0 -> {
                addRowHoaDon(firtRecordHD, this.qlHD.select(0, ng));
                setPageHD(qlHD.select(0, ng).size());
            }
            default ->
                addRowHoaDon(firtRecordHD, this.qlHD.select(ng));
        }

    }//GEN-LAST:event_btnTienActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        firtRecordHD -= 8;
        tempHD--;
        if (firtRecordHD >= 0) {
            addRowHoaDon(firtRecordHD, listHD);
            setAnimationHD(tempHD, soTrangHD);
        } else {
            firtRecordHD = 0;
            tempHD = 1;
        }
        int luachon = getLuaChon();
        switch (luachon) {
            case 1 -> {
                addRowHoaDon(firtRecordHD, this.qlHD.select(1, ng));
                setPageHD(qlHD.select(1, ng).size());
            }
            case 0 -> {
                addRowHoaDon(firtRecordHD, this.qlHD.select(0, ng));
                setPageHD(qlHD.select(0, ng).size());
            }
            default ->
                addRowHoaDon(firtRecordHD, this.qlHD.select(ng));
        }
    }//GEN-LAST:event_btnLuiActionPerformed

    private void btnTienSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienSPActionPerformed
        firtRecordSP += 13;
        tempSP++;
        if (firtRecordSP <= countSP) {
            loadSanPham(firtRecordSP, listSP);
            setAnimationSP(tempSP, soTrangSP);
        } else {
            if (countSP % 13 == 0) {
                firtRecordSP = countSP - 13;
            } else {
                firtRecordSP = countSP - (countSP % 13);
            }
            tempSP = soTrangSP;
        }

    }//GEN-LAST:event_btnTienSPActionPerformed

    private void btnLuiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiSPActionPerformed
        firtRecordSP -= 13;
        tempSP--;
        if (firtRecordSP >= 0) {
            loadSanPham(firtRecordSP, listSP);
            setAnimationSP(tempSP, soTrangSP);
        } else {
            firtRecordSP = 0;
            tempSP = 1;
        }
    }//GEN-LAST:event_btnLuiSPActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        Double tienKhachDua = Double.valueOf(txtTienKhachDua.getText());
        Double thanhTien = Double.valueOf(txtTongTien.getText());
        Double tienThua = tienKhachDua - thanhTien;
        String tienThuaaa = Double.toString(tienThua);
        txtTienThua.setText(tienThuaaa);
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void rdoChuaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuaTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChuaTTActionPerformed

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
            java.util.logging.Logger.getLogger(BanHangView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea b;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnLuiSP;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTien;
    private javax.swing.JButton btnTienSP;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btntaoHD;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbHTTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblTrangHD;
    private javax.swing.JLabel lblTrangSP;
    private javax.swing.JRadioButton rdoALL;
    private javax.swing.JRadioButton rdoChuaTT;
    private javax.swing.JRadioButton rdoDaTT;
    private javax.swing.JTable tb_giohang;
    private javax.swing.JTable tb_sanpham;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txNguoiTao;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtma;
    // End of variables declaration//GEN-END:variables
}
