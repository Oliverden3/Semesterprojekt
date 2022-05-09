package dat.startcode.model.entities;

import java.util.Objects;

public class Roof {

    /*
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
    */

    private int idRoof;
    private String roofType;
    private String roofTilt;

    public Roof(int idRoof, String roofType, String roofTilt)
    {
        this.idRoof = idRoof;
        this.roofType = roofType;
        this.roofTilt = roofTilt;
    }

    @Override
    public String toString()
    {
        return "Roof{" +
                "idTag='" + idRoof + '\'' +
                ", tagType='" + roofType + '\'' +
                ", tagHældning='" + roofTilt + '\'' +
                '}';
    }

    public int getIdRoof()
    {
        return idRoof;
    }

    public void setIdRoof(int idRoof)
    {
        this.idRoof = idRoof;
    }

    public String getRoofType()
    {
        return roofType;
    }

    public void setRoofType(String roofType)
    {
        this.roofType = roofType;
    }

    public String getRoofTilt()
    {
        return roofTilt;
    }

    public void setRoofTilt(String roofTilt)
    {
        this.roofTilt = roofTilt;
    }

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Roof)) return false;
        Roof roof = (Roof) o;
        return getIdRoof().equals(roof.getIdRoof()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUsername(), getPassword(), getRole());
    }
     */

}

