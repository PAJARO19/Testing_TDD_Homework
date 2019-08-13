package numbers;

public class NumbersIntToString {

    public static String intToString(int number) {
        String result = "";
        if (number > 999) {
            int numberTmp = Math.floorDiv(number, 1000);
            for (int i = 1; i <= numberTmp; i++) {
                result = result + "M";
            }
            number = number - numberTmp * 1000;
        }
        if (number > 99) {
            int numberTmp = Math.floorDiv(number, 100);
            if (numberTmp == 4) result = result + "CD";
            if (numberTmp > 4 && numberTmp < 9) result = result + "D";
            if (numberTmp == 9) result = result + "CM";
            if (numberTmp > 0 && numberTmp < 4)
                for (int i = 1; i <= numberTmp; i++) {
                    result = result + "C";
                }
            if (numberTmp > 5 && numberTmp < 9)
                for (int i = 6; i <= numberTmp; i++) {
                    result = result + "C";
                }
            number = number - numberTmp * 100;
        }
        if (number > 9) {
            int numberTmp = Math.floorDiv(number, 10);
            if (numberTmp == 4) result = result + "XL";
            if (numberTmp > 4 && numberTmp < 9) result = result + "L";
            if (numberTmp == 9) result = result + "XC";
            if (numberTmp > 0 && numberTmp < 4)
                for (int i = 1; i <= numberTmp; i++) {
                    result = result + "X";
                }
            if (numberTmp > 5 && numberTmp < 9)
                for (int i = 6; i <= numberTmp; i++) {
                    result = result + "X";
                }
            number = number - numberTmp * 10;
        }
        if (number > 0) {
            if (number == 4) result = result + "IV";
            if (number > 4 && number < 9) result = result + "V";
            if (number == 9) result = result + "IX";
            if (number > 0 && number < 4)
                for (int i = 1; i <= number; i++) {
                    result = result + "I";
                }
            if (number > 5 && number < 9)
                for (int i = 6; i <= number; i++) {
                    result = result + "I";
                }
        }
        return result;
    }
}