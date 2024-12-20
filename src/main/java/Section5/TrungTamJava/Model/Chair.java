package Section5.TrungTamJava.Model;

public class Chair {
    private long idGhe;
    private String tenGhe;
    private String ngaySanXuat;
    private Float gia;

    public Chair(long idGhe, String tenGhe, String ngaySanXuat, Float gia) {
        this.idGhe = idGhe;
        this.tenGhe = tenGhe;
        this.ngaySanXuat = ngaySanXuat;
        this.gia = gia;
    }

    public long getIdGhe() {
        return idGhe;
    }

    public void setIdGhe(long idGhe) {
        this.idGhe = idGhe;
    }

    public String getTenGhe() {
        return tenGhe;
    }

    public void setTenGhe(String tenGhe) {
        this.tenGhe = tenGhe;
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
        return "Chair{" +
                "idGhe=" + idGhe +
                ", tenGhe='" + tenGhe + '\'' +
                ", ngaySanXuat='" + ngaySanXuat + '\'' +
                ", gia=" + gia +
                '}';
    }
}
