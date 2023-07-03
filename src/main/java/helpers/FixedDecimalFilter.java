package helpers;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class FixedDecimalFilter implements UnaryOperator<TextFormatter.Change> {

    @Override
    public TextFormatter.Change apply(TextFormatter.Change change) {
        if (change.getControlNewText().matches("-?([0-9]*)?(\\.[0-9]*)?")){
            return change;
        }
        return null;
    }
}