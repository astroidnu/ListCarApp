package com.scoproject.carmudi.helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class AppHelper {

    public static String CurrencyHelper(long a){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("Rp #,###.00", symbols);
        decimalFormat.setMaximumFractionDigits(0);
        return decimalFormat.format(a);
    }

    public static String CurrencyHelperFromDouble(double a){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("Rp #,###.00", symbols);
        decimalFormat.setMaximumFractionDigits(0);
        return decimalFormat.format(a);
    }

    public static String CurrencyHelperWhitOutRP(long a){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00", symbols);
        decimalFormat.setMaximumFractionDigits(0);
        return decimalFormat.format(a);
    }
}
