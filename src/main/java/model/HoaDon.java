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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Ma")
    private String ma;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNguoiDung")
    private NguoiDung idNguoiDung;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHinhThucThanhToan")
    private HinhThucThanhToan idHinhThucThanhToan;
    
    @Column(name = "NgayMua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayMua;
    
    @Column(name = "Sdt")
    private String sdt;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "TongTien")
    private long tongTien;
    
    @Column(name = "TinhTrang")
    private int tinhTrang;
    
    @OneToMany(mappedBy = "idHoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTiets;

    public HoaDon() {
    }

    public HoaDon(Integer id,String ma ,NguoiDung idNguoiDung, HinhThucThanhToan idHinhThucThanhToan, List<HoaDonChiTiet> hoaDonChiTiets,Date ngayMua) {
        this.ma = ma;
        this.id = id;
        this.idNguoiDung = idNguoiDung;
        this.idHinhThucThanhToan = idHinhThucThanhToan;
        this.hoaDonChiTiets = hoaDonChiTiets;
        this.ngayMua = new java.sql.Date(new Date().getTime());
    }

    
    
    public HoaDon(Integer id, String ma, NguoiDung idNguoiDung, HinhThucThanhToan idHinhThucThanhToan, Date ngayMua, String sdt, String diaChi, long tongTien, int tinhTrang, List<HoaDonChiTiet> hoaDonChiTiets) {
        this.id = id;
        this.ma = ma;
        this.idNguoiDung = idNguoiDung;
        this.idHinhThucThanhToan = idHinhThucThanhToan;
        this.ngayMua = ngayMua;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
        this.hoaDonChiTiets = hoaDonChiTiets;
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

    public HinhThucThanhToan getIdHinhThucThanhToan() {
        return idHinhThucThanhToan;
    }

    public void setIdHinhThucThanhToan(HinhThucThanhToan idHinhThucThanhToan) {
        this.idHinhThucThanhToan = idHinhThucThanhToan;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public List<HoaDonChiTiet> getHoaDonChiTiets() {
        return hoaDonChiTiets;
    }

    public void setHoaDonChiTiets(List<HoaDonChiTiet> hoaDonChiTiets) {
        this.hoaDonChiTiets = hoaDonChiTiets;
    }
    
    
}
