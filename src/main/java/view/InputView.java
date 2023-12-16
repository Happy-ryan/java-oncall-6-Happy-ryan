package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputView {
    // case2. 단일 문자열만 입력
    public static String readMonthAndDay() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
        while (true) {
            try {
                String string = inputMonthAndDay();
                return string;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputMonthAndDay() {
        String string = Console.readLine();
        validateMonthAndDay(string);
        return string;
    }

    private static void validateMonthAndDay(String string) {
        if (!string.matches("[\\d,가-힣]+")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        int month = Integer.parseInt(string.split(",")[0]);
        String day = string.split(",")[1];
        // 특정 문자만 허용하는 정규식(U와 D만 허용)
        if (month < 1 || 12 < month) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        List<String> days = Arrays.asList("월", "화", "수", "목", "금", "토", "일");
        if (!days.contains(day)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    // case3. 구분자로 문자를 입력 받는 경우 - String
    public static List<String> readPeople(boolean isWeekyDay) {
        if (isWeekyDay) {
            System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        }
        if(!isWeekyDay){
            System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        }
        List<String> stringList = inputPeople();
        return stringList;

    }

    // 쉼표(,) + 공백 불허를 기준으로 구분 (ex) 김성한,포비,해피 / 김성한
    private static List<String> inputPeople() {
        List<String> stringList = List.of(Console.readLine().split(","));
//        validatePeople(stringList);
        return stringList;
    }

    private static void validatePeople(List<String> stringList) {
        Set<String> uniqueNames = new HashSet<>();

        if (stringList.size() < 5 || 35 < stringList.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }

        if (isValid(stringList, 2)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }

        for (String string : stringList) {
            if (string.length() > 6) {
                throw new IllegalArgumentException("[ERROR] 이름이 너무 길어요. 최대 5자 입니다.");
            }
            // (영어 대소문자 + 숫자 + 한글) 만 허용
            if (!string.matches("^[a-zA-Z0-9가-힣]+$")) {
                throw new IllegalArgumentException("[ERROR] 특수문자 및 공백은 불허합니다.");
            }
            // 이미 나타난 이름인지 확인 - 중복체크
            if (!uniqueNames.add(string)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static boolean isValid(List<String> arr, int maxDay) {
        String cur = "";
        int cnt = 0;
        for (String name : arr) {
            if (!cur.equals(name)) {
                cur = name;
                cnt = 0;
            }
            cnt++;
            if (cnt > maxDay) {
                return false;
            }
        }
        return true;
    }
}
