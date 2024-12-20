package Section5.TrungTamJava.Model;

public class LapTop {
    private long idLapTop;
    private String tenLapTop;
    private String ngaySanXuat;
    private Float gia;

    public LapTop(long idLapTop, String tenLapTop, String ngaySanXuat, Float gia) {
        this.idLapTop = idLapTop;
        this.tenLapTop = tenLapTop;
        this.ngaySanXuat = ngaySanXuat;
        this.gia = gia;
    }

    public long getIdLapTop() {
        return idLapTop;
    }

    public void setIdLapTop(long idLapTop) {
        this.idLapTop = idLapTop;
    }

    public String getTenLapTop() {
        return tenLapTop;
    }

    public void setTenLapTop(String tenLapTop) {
        this.tenLapTop = tenLapTop;
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
        return "LapTop{" +
                "idLapTop=" + idLapTop +
                ", tenLapTop='" + tenLapTop + '\'' +
                ", ngaySanXuat='" + ngaySanXuat + '\'' +
                ", gia=" + gia +
                '}';
    }
}
