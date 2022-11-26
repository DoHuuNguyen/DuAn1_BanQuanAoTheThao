/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "GioHang")
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Ma")
    private String ma;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNguoiDung")
    private NguoiDung idNguoiDung;
    
    @Column(name = "NgayTao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayTao;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @OneToMany(mappedBy = "idGioHang", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> gioHangChiTiets;

    public GioHang() {
    }

    public GioHang(Integer id, String ma, NguoiDung idNguoiDung, Date ngayTao, int trangThai, List<GioHangChiTiet> gioHangChiTiets) {
        this.id = id;
        this.ma = ma;
        this.idNguoiDung = idNguoiDung;
        this.ngayTao = new java.sql.Date(new Date().getTime());
        this.trangThai = trangThai;
        this.gioHangChiTiets = gioHangChiTiets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public NguoiDung getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(NguoiDung idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<GioHangChiTiet> getGioHangChiTiets() {
        return gioHangChiTiets;
    }

    public void setGioHangChiTiets(List<GioHangChiTiet> gioHangChiTiets) {
        this.gioHangChiTiets = gioHangChiTiets;
    }

    @Override
    public String toString() {
        return ma;
    }
  
}
