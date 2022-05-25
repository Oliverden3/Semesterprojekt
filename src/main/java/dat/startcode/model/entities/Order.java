package dat.startcode.model.entities;

import java.sql.Date;


public class Order {
    int idOrders;
    Date date;
    int userId;
    int width;
    int length;
    int height;
    int price;
    Roof roof;
    Toolshed toolshed;
    String carportType;
    String status;


    public Order(int idOrders, Date date, int userId, int width, int length, int price, Roof roof, Toolshed toolshed, String carportType, String status) {
        this.idOrders = idOrders;
        this.date = date;
        this.userId = userId;
        this.width = width;
        this.length = length;
        this.price = price;
        this.roof = roof;
        this.toolshed = toolshed;
        this.carportType = carportType;
        this.status = status;
    }

    public Order(Date date, int userId, int width, int length, int price, Roof roof, Toolshed toolshed, String carportType, String status) {
        this.date = date;
        this.userId = userId;
        this.width = width;
        this.length = length;
        this.price = price;
        this.roof = roof;
        this.toolshed = toolshed;
        this.carportType = carportType;
        this.status = status;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public Date getDate() {
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

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public Roof getRoof() {
        return roof;
    }

    public Toolshed getToolshed() {
        return toolshed;
    }

    public String getCarportType() {
        return carportType;
    }

    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }

    public String getStatus() {return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}
