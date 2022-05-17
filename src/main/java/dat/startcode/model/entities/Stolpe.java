package dat.startcode.model.entities;

public class Stolpe {

    int længde;
    String beskrivelse;
    int pris;

    public Stolpe(int længde, int pris) {
        this.længde = længde;
        this.beskrivelse = "Fix dette";
        this.pris = pris;
    }

    public int getLængde() {
        return længde;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getPris() {
        return pris;
    }
}
