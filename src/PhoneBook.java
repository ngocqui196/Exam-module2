import java.io.Serializable;

public class PhoneBook implements Serializable {
    private String sdt;
    private String nhomDanhBa;
    private String ten;
    private String gioitinh;
    private String diaChi;
    private String ngaySinh;
    private String email;

    public PhoneBook() {
    }

    public PhoneBook(String sdt, String nhomDanhBa, String ten, String gioitinh, String diaChi, String ngaySinh, String email) {
        this.sdt = sdt;
        this.nhomDanhBa = nhomDanhBa;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNhomDanhBa() {
        return nhomDanhBa;
    }

    public void setNhomDanhBa(String nhomDanhBa) {
        this.nhomDanhBa = nhomDanhBa;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "sdt=" + sdt +
                ", nhomDanhBa='" + nhomDanhBa + '\'' +
                ", ten='" + ten + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
