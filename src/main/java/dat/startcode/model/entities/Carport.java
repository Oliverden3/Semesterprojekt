package dat.startcode.model.entities;

public class Carport {
    int id;
    int width;
    int length;
    int height;
    int price;
    Roof roof;
    Toolshed toolshed;
    String carportType;

    public Carport(int id, int width, int length, int price, int height, Roof roof, Toolshed toolshed, String carportType) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.height = height;
        this.price = price;
        this.roof = roof;
        this.toolshed = toolshed;
        this.carportType = carportType;
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

    public int getId() {
        return id;
    }
}

