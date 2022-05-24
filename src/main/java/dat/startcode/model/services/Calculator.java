package dat.startcode.model.services;

public class Calculator {

    public static int calcPoles(int l, int b){

        double poles = Math.ceil(l/275)*2;
        return (int)poles;
    }
    public static int calcRafters(int l, int w){

        double rafters = Math.ceil(l/55)+2;

        return (int)rafters;
    }
}
