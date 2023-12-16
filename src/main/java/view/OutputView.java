package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Parser;

import java.util.*;

public class OutputView {
    private static final String a = "";
    private static final String b = "";
    private static final String c = "";

    private static final int d = 0;

    public static void printPeople(List<String> stringList) {
        System.out.println(Parser.joinWithoutBlank(stringList));
    }

    public static void printErrorMessage() {
        System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }
}
