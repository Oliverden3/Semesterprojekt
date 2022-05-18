package dat.startcode.model.entities;

public class Spær {
    int længde;
    String beskrivelse;
    int pris;

    public Spær(int længde, String beskrivelse, int pris) {
        this.længde = længde;
        this.beskrivelse = beskrivelse;
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
