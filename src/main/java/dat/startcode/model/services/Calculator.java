package dat.startcode.model.services;

public class Calculator {

    public static int calcPoles(int b, int l){

        double poles = Math.ceil(l/2.75)*2;
        return (int)poles;
    }
}
