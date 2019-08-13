package numbers;

import java.util.Arrays;
import java.util.List;

public class NumbersStringToInt {

    public Integer stringToInt(String string) {
        Integer result = 0;
        List<Character> list = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');
        for (int i = 0; i <= string.length() - 1; i++) {
            if (!(string.charAt(i) == list.get(0)
                    || string.charAt(i) == list.get(1)
                    || string.charAt(i) == list.get(2)
                    || string.charAt(i) == list.get(3)
                    || string.charAt(i) == list.get(4)
                    || string.charAt(i) == list.get(5)
                    || string.charAt(i) == list.get(6)))
                result = null;
        }
        if (result != null) {
            for (int i = 0; i <= string.length() - 1; i++) {
                if (string.charAt(i) == 'I')
                    result += 1;
                if (string.charAt(i) == 'V')
                    result += 5;
                if (string.charAt(i) == 'X')
                    result += 10;
                if (string.charAt(i) == 'L')
                    result += 50;
                if (string.charAt(i) == 'C')
                    result += 100;
                if (string.charAt(i) == 'D')
                    result += 500;
                if (string.charAt(i) == 'M')
                    result += 1000;
            }
            for (int i = 0; i <= string.length() - 2; i++) {
                if (string.charAt(i) == 'I' && (string.charAt(i + 1) == 'V' || string.charAt(i + 1) == 'X'))
                    result -= 2;
                if (string.charAt(i) == 'X' && (string.charAt(i + 1) == 'L' || string.charAt(i + 1) == 'C'))
                    result -= 20;
                if (string.charAt(i) == 'C' && (string.charAt(i + 1) == 'D' || string.charAt(i + 1) == 'M'))
                    result -= 200;
            }
        }
        return result;
    }
}