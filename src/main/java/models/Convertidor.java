package models;

import java.util.ArrayList;

public class Convertidor {
    private ArrayList<Currency> currencies;
    private ArrayList<Length> lengths;

    private ArrayList<Area> areas;

    private ArrayList<Mass> masses;

    public Convertidor(){
        currencies = new ArrayList<>();
        lengths = new ArrayList<>();
        areas = new ArrayList<>();
        masses = new ArrayList<>();
        fillCurrencies();
        fillLength();
        fillArea();
        fillMass();
    }



    public ArrayList<Currency> getCurrencies(){
        return currencies;
    }

    public ArrayList<Length> getLengths(){
        return lengths;
    }

    public ArrayList<Area> getAreas(){ return areas; }

    public ArrayList<Mass> getMasses(){ return masses; }

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

    private void fillArea(){
        areas.add(new Area("m²", 1.0));
        areas.add(new Area("dm²", 0.001));
        areas.add(new Area("cm²", 0.00001));
        areas.add(new Area("mm²", 0.0000001));
        areas.add(new Area("km²", 1000000.0));
        areas.add(new Area("yr²", 0.833333));
        areas.add(new Area("ft²", 0.09293));
        areas.add(new Area("in²", 0.000645));
    }

    private void fillMass() {
        masses.add(new Mass("Kilogramo(kg)", 1.0));
        masses.add(new Mass("Miligramo(mg)", 0.000001));
        masses.add(new Mass("Gramo(g)", 0.001));
        masses.add(new Mass("Decagramo(dg)", 0.01));
        masses.add(new Mass("Hectogramo(hg)", 0.1));
        masses.add(new Mass("Kilonewton(kN)", 101.97));
        masses.add(new Mass("Tonelada(t)", 1000.0));
        masses.add(new Mass("Libra(lb)", 0.45));
        masses.add(new Mass("Onza(oz)", 0.03));
    }

    public double convertir(double amount, Unit from, Unit to){
        // Convert to mxn then to the desired currency
        return (amount * (from.getConvertRatio() / to.getConvertRatio()));
    }
}
