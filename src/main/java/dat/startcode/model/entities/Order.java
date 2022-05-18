package dat.startcode.model.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Order {
    int idOrders;
    String date;
    int userId;
    int width;
    int length;

    public Order(int idOrders, String date, int userId, int width, int length) {
        this.idOrders = idOrders;
        this.date = date;
        this.userId = userId;
        this.width = width;
        this.length = length;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public String getDate() {
        return date;
    }

    public int getUserId() {
        return userId;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
