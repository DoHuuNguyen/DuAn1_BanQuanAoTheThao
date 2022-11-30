package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column (name = "Ma")
    private String ma;
    
    @Column (name = "Ten")
    private String Ten;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMonTheThao")
    private MonTheThao idMonTheThao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac")
    private MauSac IdMauSac;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSize")
    private Size IdSize;
    
    @Column (name = "TrangThai")
    private int trangThai;
    @Column (name = "Gia")
    private int gia;
    @Column (name = "soLuong")
    private int soLuong;
    @Column (name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column (name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(Integer id, String ma, String Ten, MonTheThao idMonTheThao, MauSac IdMauSac, Size IdSize, int trangThai, int gia, int soLuong, Date ngayThem, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.Ten = Ten;
        this.idMonTheThao = idMonTheThao;
        this.IdMauSac = IdMauSac;
        this.IdSize = IdSize;
        this.trangThai = trangThai;
        this.gia = gia;
        this.soLuong = soLuong;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
    }

    

    public ChiTietSanPham(MonTheThao idMonTheThao, MauSac IdMauSac, Size IdSize) {
        this.idMonTheThao = idMonTheThao;
        this.IdMauSac = IdMauSac;
        this.IdSize = IdSize;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    
    

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
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

    public MonTheThao getIdMonTheThao() {
        return idMonTheThao;
    }

    public void setIdMonTheThao(MonTheThao idMonTheThao) {
        this.idMonTheThao = idMonTheThao;
    }

    public MauSac getIdMauSac() {
        return IdMauSac;
    }

    public void setIdMauSac(MauSac IdMauSac) {
        this.IdMauSac = IdMauSac;
    }

    public Size getIdSize() {
        return IdSize;
    }

    public void setIdSize(Size IdSize) {
        this.IdSize = IdSize;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayThem() {
        return new java.sql.Date(new Date().getTime());
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    
}
