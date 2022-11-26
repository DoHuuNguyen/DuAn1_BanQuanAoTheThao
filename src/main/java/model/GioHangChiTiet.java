/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdGioHang")
    private GioHang idGioHang;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSanPham")
    private ChiTietSanPham idSanPham;
    
    @Column(name = "SoLuong")
    private int soLuong;
    
    @Column(name = "DonGia")
    private int donGia;
    
    @Column(name = "ThanhTien")
    private int thanhTien;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(Integer id, GioHang idGioHang, ChiTietSanPham idSanPham, int soLuong, int donGia, int thanhTien) {
        this.id = id;
        this.idGioHang = idGioHang;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GioHang getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(GioHang idGioHang) {
        this.idGioHang = idGioHang;
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

    @Override
    public String toString() {
        return idGioHang.toString();
    }

}