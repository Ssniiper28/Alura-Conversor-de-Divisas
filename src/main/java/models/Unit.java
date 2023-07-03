package models;

public abstract class Unit {
    private String notation;
    private Double convertRatio;

    public Unit(String notation, Double convertRatio){
        this.notation = notation;
        this.convertRatio = convertRatio;
    }

    public String getNotation() {
        return notation;
    }

    public double getConvertRatio() {
        return convertRatio;
    }

    @Override
    public String toString() {
        return this.notation;
    }
}
