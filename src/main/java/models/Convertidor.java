package models;

import java.util.ArrayList;

public class Convertidor {
    private ArrayList<Currency> currencies;
    private ArrayList<Length> lengths;

    public Convertidor(){
        currencies = new ArrayList<>();
        lengths = new ArrayList<>();
        fillCurrencies();
        fillLength();
    }

    public ArrayList<Currency> getCurrencies(){
        return currencies;
    }

    public ArrayList<Length> getLengths(){
        return lengths;
    }

    private void fillCurrencies() {
        currencies.add(new Currency("MXN", 1.0));
        currencies.add(new Currency("USD", 17.05));
        currencies.add(new Currency("EUR", 18.61));
        currencies.add(new Currency("GBP", 21.64));
        currencies.add(new Currency("JPY", 0.12));
        currencies.add(new Currency("KRW", 0.013));
    }

    private void fillLength() {
        lengths.add(new Length("Milimetro(mm)", 0.001));
        lengths.add(new Length("Centimetro(cm)", 0.01));
        lengths.add(new Length("Decimentro(dm)", 0.1));
        lengths.add(new Length("Metro(m)", 1.0));
        lengths.add(new Length("Kilometro(km)", 1000.0));
        lengths.add(new Length("Pulgada(in)", 0.0254));
        lengths.add(new Length("Milla(mi)", 1609.34));
        lengths.add(new Length("Yarda(yd)", 0.91));
        lengths.add(new Length("Pie(ft)", 0.3));
    }

    public double convertir(double amount, Unit from, Unit to){
        // Convert to mxn then to the desired currency
        return (amount * (from.getConvertRatio() / to.getConvertRatio()));
    }
}
