package utils;

import java.text.DecimalFormat;
import java.util.*;

public class Parser {
    // 김성한,김성한,김성한 -> OutputView에 도움
    public static String joinWithoutBlank(List<String> stringList) {
        return String.join(",", stringList);
    }

    // 김성한, 김성한, 김성한 -> OutputView에 도움
    public static String joinWithBlank(List<String> stringList) {
        return String.join(", ", stringList);
    }

    // number = 100000 -> 100,000원
    public static String formatNumberWithThousandsSeparator(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number) + "원";
    }

    // List<String> -> List<Integer> 로 변경 -> inputView에 도움
    public static List<Integer> parseInteger(List<String> stringList) {
        List<Integer> IntegerList = new ArrayList<>();
        for (String string : stringList) {
            IntegerList.add(Integer.parseInt(string));
        }
        return IntegerList;
    }

    public static LinkedHashMap<String, Integer> makeStringIntegerMap(List<Object> objects) {
        LinkedHashMap<String, Integer> stringIntegerMap = new LinkedHashMap<>();
        for (Object object : objects) {
            stringIntegerMap.put("", 0);
        }
        return stringIntegerMap;
    }
}
