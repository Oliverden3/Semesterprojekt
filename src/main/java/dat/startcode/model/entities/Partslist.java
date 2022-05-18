package dat.startcode.model.entities;

public class Partslist {

    Spær spær;
    Rem rem;
    Stolpe stolpe;

    public Partslist(Spær spær, Rem rem, Stolpe stolpe) {
        this.spær = spær;
        this.rem = rem;
        this.stolpe = stolpe;
    }

    public int calculateSpær(Carport carport){

        int spærAmount = (carport.getLength()*100/55)+2;
        return spærAmount;

    }
}
