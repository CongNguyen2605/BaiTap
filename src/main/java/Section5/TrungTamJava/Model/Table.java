package Section5.TrungTamJava.Model;

public class Table {
    private long idBan;
    private String tenBan;
    private String ngaySanXuat;
    private Float gia;

    public Table(long idBan, String tenBan, String ngaySanXuat, Float gia) {
        this.idBan = idBan;
        this.tenBan = tenBan;
        this.ngaySanXuat = ngaySanXuat;
        this.gia = gia;
    }

    public Table() {

    }

    public long getIdBan() {
        return idBan;
    }

    public void setIdBan(long idBan) {
        this.idBan = idBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Table{" +
                "idBan=" + idBan +
                ", tenBan='" + tenBan + '\'' +
                ", ngaySanXuat='" + ngaySanXuat + '\'' +
                ", gia=" + gia +
                '}';
    }
}
