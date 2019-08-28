package numbers;

import java.util.HashMap;
import java.util.Map;

public class NumbersStringToInt {

    public Integer stringToInt(String string) {
        Integer result = 0;
        char[] stringToCharTable = string.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        map1.put('I', 1);
        map1.put('V', 5);
        map1.put('X', 10);
        map1.put('L', 50);
        map1.put('C', 100);
        map1.put('D', 500);
        map1.put('M', 1000);
        for (char a : stringToCharTable) {
            if (!map1.containsKey(a))
                return null;
        }
        for (char a : stringToCharTable) {
            if (map1.containsKey(a))
                result += map1.get(a);
        }
        for (int i = 0; i <= stringToCharTable.length - 2; i++) {
            if (stringToCharTable[i] == 'I' && (stringToCharTable[i + 1] == 'V' || stringToCharTable[i + 1] == 'X'))
                result -= 2;
            if (stringToCharTable[i] == 'X' && (stringToCharTable[i + 1] == 'L' || stringToCharTable[i + 1] == 'C'))
                result -= 20;
            if (stringToCharTable[i] == 'C' && (stringToCharTable[i + 1] == 'D' || stringToCharTable[i + 1] == 'M'))
                result -= 200;
        }
        return result;
    }
}