package model;


import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "NguoiDung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "HoTen")
    private String hoTen;
    
    @Column(name = "GioiTinh")
    private int gioiTinh;
    
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChucVu")
    private ChucVu idChucVu;
    
    @Column(name = "Anh")
    private String anh;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "NgayThem")
    private Date ngayThem;
    
    @Column(name = "NgaySua")
    private Date ngaySua;
    
//    @OneToMany(mappedBy = "idNguoiDung", fetch = FetchType.LAZY)
//    List<HoaDon> hoaDons;
//    
//    @OneToOne(mappedBy = "idNguoiDung", fetch = FetchType.LAZY)
//    GioHang gioHangs;
//    
//    @OneToOne(mappedBy = "idNguoiDung")
//    private Account idAccount;

    public NguoiDung() {
    }

    public NguoiDung(Integer id, String ma, String hoTen, int gioiTinh, Date ngaySinh, String email, String diaChi, ChucVu idChucVu, String anh, int trangThai, Date ngayThem, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diaChi = diaChi;
        this.idChucVu = idChucVu;
        this.anh = anh;
        this.trangThai = trangThai;
        this.ngayThem = ngayThem;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ChucVu getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(ChucVu idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
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
   