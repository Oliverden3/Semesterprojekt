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


    public Order(int idOrders, Date date, int userId, int width, int length, int price, Roof roof, Toolshed toolshed, String carportType) {
        this.idOrders = idOrders;
        this.date = date;
        this.userId = userId;
        this.width = width;
        this.length = length;
        this.price = price;
        this.roof = roof;
        this.toolshed = toolshed;
        this.carportType = carportType;
    }

    public Order(Date date, int userId, int width, int length, int price, Roof roof, Toolshed toolshed, String carportType) {
        this.date = date;
        this.userId = userId;
        this.width = width;
        this.length = length;
        this.price = price;
        this.roof = roof;
        this.toolshed = toolshed;
        this.carportType = carportType;
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
}
