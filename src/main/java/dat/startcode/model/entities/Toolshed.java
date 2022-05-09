package dat.startcode.model.entities;

public class Toolshed {
    int width;
    int length;
    int id;

    public Toolshed(int id, int width, int length) {
        this.width = width;
        this.length = length;
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getId() {
        return id;
    }
}
