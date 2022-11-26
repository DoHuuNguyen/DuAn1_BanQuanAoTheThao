package model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Acer
 */
@Entity
@Table (name = "ChucVu")
public class ChucVu {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String ten;
    
    @Column(name = "NgayThem")
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    private Date ngaySua;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @OneToMany(mappedBy = "idChucVu", fetch = FetchType.LAZY)
    private List<NguoiDung> nguoiDungs;

    public ChucVu() {
    }

    public ChucVu(Integer id, String ma, String ten, int trangThai, Date ngayThem, Date ngaySua,  List<NguoiDung> nguoiDungs) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngayThem = new java.sql.Date(new Date().getTime());
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.nguoiDungs = nguoiDungs;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<NguoiDung> getNguoiDungs() {
        return nguoiDungs;
    }

    public void setNguoiDungs(List<NguoiDung> nguoiDungs) {
        this.nguoiDungs = nguoiDungs;
    }

    @Override
    public String toString() {
        return ten;
    }

}