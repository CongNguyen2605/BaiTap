package QuanLyKhachSan.Model;

public class Room {
    private long idRoom;
    private String typeRoom;
    private boolean isBooked;
    private float price;

    public Room() {
    }

    public Room(long idRoom, String typeRoom, boolean isBooked, float price) {
        this.idRoom = idRoom;
        this.typeRoom = typeRoom;
        this.isBooked = isBooked;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + idRoom +
                ", typeRoom='" + typeRoom + '\'' +
                ", isBooked=" + isBooked +
                ", price=" + price +
                '}';
    }

 
}
