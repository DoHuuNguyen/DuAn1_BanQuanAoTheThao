package reopsitory;
public class Top {
    private String ma;
    private String ten;
    private int soLuong;
    private int tien;

    public Top() {
    }

    public Top(String ma, String ten, int soLuong, int tien) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.tien = tien;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }
    
    
}
