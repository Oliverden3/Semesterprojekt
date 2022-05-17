package dat.startcode.model.entities;

public class Rem {
    int længde;
    String beskrivelse;
    int pris;

    public Rem(int længde, int pris) {
        this.længde = længde;
        beskrivelse = "Remme i sider, sadles ned i stolper";
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
