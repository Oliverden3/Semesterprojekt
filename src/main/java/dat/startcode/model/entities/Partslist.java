package dat.startcode.model.entities;

public class Partslist {
    private int idPartslist;
    private String partslistMaterials;

    public Partslist (int idPartslist, String partslistMaterials) {
        this.idPartslist = idPartslist;
        this.partslistMaterials = partslistMaterials;
    }

    @Override
    public String toString()
    {
        return "Partlist{" +
                "idPartslist='" + idPartslist + '\'' +
                ", styklist='" + partslistMaterials + '\'' +
                '}';
    }

    public int getIdPartslist()
    {
        return idPartslist;
    }

    public void setIdPartslist(int idPartslist)
    {
        this.idPartslist = idPartslist;
    }

    public String getPartslistMaterials()
    {
        return partslistMaterials;
    }

    public void setPartslistMaterials(String partslistMaterials)
    {
        this.partslistMaterials = partslistMaterials;
    }
}
