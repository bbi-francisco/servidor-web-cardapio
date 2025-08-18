package web_cardapio.br.com.bitbyte.utils;

import java.math.BigDecimal;

public class NumberUtils {

    public static Number getZeroIfNull(Number number){
        return number != null ? number : 0;
    }
    
    public static Double getZeroIfNull(Double number){
        return number != null ? number : 0;
    }

    public static boolean equals(Number number1, Number number2){
        if(number1 == null && number2 == null){
            return true;
        }

        if(number1 == null || number2 == null){
            return false;
        }

        BigDecimal value1 = new BigDecimal(number1.toString());
        BigDecimal value2 = new BigDecimal(number2.toString());

        return value1.compareTo(value2) == 0;

    }

    public static boolean lowerThan(Number number1, Number number2){
        if(number1 == null || number2 == null){
            return false;
        }

        BigDecimal value1 = new BigDecimal(number1.toString());
        BigDecimal value2 = new BigDecimal(number2.toString());
        return value1.compareTo(value2) < 0;
    }

    public static boolean biggerThan(Number number1, Number number2){
        if(number1 == null || number2 == null){
            return false;
        }

        BigDecimal value1 = new BigDecimal(number1.toString());
        BigDecimal value2 = new BigDecimal(number2.toString());
        return value1.compareTo(value2) > 0;
    }

    public static boolean lowerOrEquals(Number number1, Number number2){
        return lowerThan(number1, number2) || equals(number1, number2);
    }

    public static boolean biggerOrEquals(Number number1, Number number2){
        return biggerThan(number1, number2) || equals(number1, number2);
    }
}
