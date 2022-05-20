package dat.startcode.model.entities;

public class PartslistItem {
    int idPartslist;
    String partDescription;
    int amount;
    int length;
    int idOrders;
    int idMaterial;
    String materialDescription;
    int unit;

    public PartslistItem(int idPartslist, String partDescription, int amount, int length, int idOrders, int idMaterial, String materialDescription, int unit) {
        this.idPartslist = idPartslist;
        this.partDescription = partDescription;
        this.amount = amount;
        this.length = length;
        this.idOrders = idOrders;
        this.idMaterial = idMaterial;
        this.materialDescription = materialDescription;
        this.unit = unit;
    }

    public PartslistItem(String partDescription, int amount, int length, int idOrders, int idMaterial) {
        this.partDescription = partDescription;
        this.amount = amount;
        this.length = length;
        this.idOrders = idOrders;
        this.idMaterial = idMaterial;
        this.materialDescription = materialDescription;
        this.unit = unit;
    }

    public int getIdPartslist() {
        return idPartslist;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getAmount() {
        return amount;
    }

    public int getLength() {
        return length;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public int getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "PartslistItem{" +
                "idPartslist=" + idPartslist +
                ", partDescription='" + partDescription + '\'' +
                ", amount=" + amount +
                ", length=" + length +
                ", idOrders=" + idOrders +
                ", idMaterial=" + idMaterial +
                ", materialDescription='" + materialDescription + '\'' +
                ", unit=" + unit +
                '}';
    }

    public void setIdPartslist(int idPartslist) {
        this.idPartslist = idPartslist;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}


