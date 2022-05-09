package dat.startcode.model.entities;

public class Roof {
    String roofType;
    int roofTilt;

    public Roof(String roofType, int roofTilt) {
        this.roofType = roofType;
        this.roofTilt = roofTilt;
    }

    public String getRoofType() {
        return roofType;
    }

    public int getRoofTilt() {
        return roofTilt;
    }
}

