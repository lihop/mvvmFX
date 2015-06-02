package de.saxsys.mvvmfx.utils.validation;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableStringValue;

import java.util.regex.Pattern;

public class Rules {


    public static ObservableBooleanValue matches(ObservableStringValue source, Pattern pattern) {
        return Bindings.createBooleanBinding(() -> {
            final String s = source.get();
            if(s == null) {
                return true;
            } else {
                return !pattern.matcher(s).matches();
            }
        }, source);
    }

}