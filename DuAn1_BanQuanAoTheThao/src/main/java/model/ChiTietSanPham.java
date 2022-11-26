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
    
    @Column (name = "NgayTao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column (name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(Integer id, String ma, MonTheThao idMonTheThao, MauSac IdMauSac, Size IdSize, int trangThai, Date ngayThem, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.idMonTheThao = idMonTheThao;
        this.IdMauSac = IdMauSac;
        this.IdSize = IdSize;
        this.trangThai = trangThai;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
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
        return ngayThem;
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