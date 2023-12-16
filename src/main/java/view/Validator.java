package view;

import java.util.*;

public class Validator {
    private List<String> weekDayPeople;
    private List<String> weekendDayPeople;

    public Validator(List<String> weekDayPeople, List<String> weekendDayPeople) {
        this.weekDayPeople = weekDayPeople;
        this.weekendDayPeople = weekendDayPeople;
    }

    public boolean allValidateCheck(boolean isWeekDay, int maxDay){
        if(isvalidatePeople(isWeekDay) && isSameAllPeople() && isValidContinueDay(isWeekDay, maxDay)){
            return true;
        }
        return false;
    }

    public boolean isvalidatePeople(boolean isWeekDay) {
        if(isWeekDay){
            List<String> stringList = weekDayPeople;
        }
        List<String> stringList = weekendDayPeople;

        Set<String> uniqueNames = new HashSet<>();

        if (stringList.size() < 5 || 35 < stringList.size()) {
            return false;
        }
        for (String string : stringList) {
            if (string.length() > 6) {
                return false;
            }
            // (한글) 만 허용
            if (!string.matches("^[가-힣]+$")) {
                return false;
            }
            // 이미 나타난 이름인지 확인 - 중복체크
            if (!uniqueNames.add(string)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidContinueDay(boolean isWeekDay, int maxDay) {
        if(isWeekDay){
            List<String> arr = weekDayPeople;
        }
        List<String> arr = weekendDayPeople;

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


    public boolean isSameAllPeople() {
        for (String name : weekendDayPeople) {
            if (!weekDayPeople.contains(name)) {
                return false;
            }
        }
        return true;
    }
}
