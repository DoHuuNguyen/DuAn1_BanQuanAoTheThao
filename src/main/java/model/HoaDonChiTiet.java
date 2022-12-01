package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon idHoaDon;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSanPham")
    private ChiTietSanPham idSanPham;
    
    @Column(name = "Soluong")
    private int soLuong;
    
    @Column(name = "DonGia")
    private int donGia;
    
    @Column(name = "ThanhTien")
    private int thanhTien;
    
    @Column(name = "TrangThai")
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(Integer id, HoaDon idHoaDon, ChiTietSanPham idSanPham, int soLuong, int donGia, int thanhTien, int trangThai) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public HoaDonChiTiet(ChiTietSanPham idSanPham, int soLuong, int thanhTien) {
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }
     

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public ChiTietSanPham getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(ChiTietSanPham idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return idHoaDon.toString();
    }

}
