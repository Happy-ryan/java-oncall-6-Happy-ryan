package view;

import utils.Parser;

import java.util.*;

public class OutputView {

    public static void printMonthDay(String monthAndDay){
        System.out.println(monthAndDay);
    }
    public static void printPeople(List<String> stringList) {
        System.out.println(Parser.joinWithoutBlank(stringList));
    }

    public static void printErrorMessage() {
        System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }
    public static void printCalender(int monthNumber, int dayNumber, String day, String name, boolean isHoliday){
        if(isHoliday){
            System.out.println(String.format("%d월 %d일 %s(휴일) %s", monthNumber,dayNumber, day, name));
            return;
        }
        System.out.println(String.format("%d월 %d일 %s %s", monthNumber,dayNumber, day, name));
    }
}
