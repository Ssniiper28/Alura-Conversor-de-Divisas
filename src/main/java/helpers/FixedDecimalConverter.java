package helpers;

import javafx.util.converter.DoubleStringConverter;

import java.util.Locale;

public class FixedDecimalConverter extends DoubleStringConverter {
    private final int decimalPlaces;

    public FixedDecimalConverter(int decimalPlaces){
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public String toString(Double value){
        return String.format(Locale.of("es_MX"),"%." + decimalPlaces + "f", value);
    }

    @Override
    public Double fromString(String s) {
        if (s.isEmpty()){
            return 0d;
        }
        return super.fromString(s);
    }
}
