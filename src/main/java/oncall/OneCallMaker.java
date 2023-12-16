package oncall;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class OneCallMaker {
    private final List<String> weekDayPeople;
    private final List<String> weekendDayPeople;
    private final LinkedHashMap<Integer, Day> calender;

    public OneCallMaker(List<String> weekDayPeople, List<String> weekendDayPeople, LinkedHashMap<Integer, Day> calender) {
        this.weekDayPeople = weekDayPeople;
        this.weekendDayPeople = weekendDayPeople;
        this.calender = calender;
    }

    public List<String> makeOnCallSystem() {
        List<String> monthPeople = new ArrayList<>();
        int weekdayModular = weekDayPeople.size();
        int weekendModular = weekendDayPeople.size();
        int totalDate = calender.keySet().size();
        String lastPerson = null;
        for (int day = 1; day <= totalDate; day++) {
            int weekdayModularIndex = (day - 1) % weekdayModular;
            int weekendModularIndex = (day - 1) % weekendModular;
            String person;
            if (isDayWeekDay(day)) {
                person = weekDayPeople.get(weekdayModularIndex);
            } else {
                person = weekendDayPeople.get(weekendModularIndex);
            }
            // 오늘이 평일 > 다음 날 휴무일이거나 주말인 경우
            if (isDayWeekDay(day) && day < totalDate && isHolidayOrWeekendDay(day + 1)) {
                weekdayModularIndex = (weekdayModularIndex + 1) % weekdayModular;
                person = weekDayPeople.get(weekdayModularIndex);
                if (person.equals(lastPerson)) {
                    weekdayModularIndex = (weekdayModularIndex + 1) % weekdayModular;
                    person = weekDayPeople.get(weekdayModularIndex);
                }
            }
            // 오늘이 주말 > 다음 날 평일인 경우
            if (!isDayWeekDay(day) && day < totalDate && !isHolidayOrWeekendDay(day + 1)) {
                weekendModularIndex = (weekendModularIndex + 1) % weekendModular;
                person = weekendDayPeople.get(weekendModularIndex);
                if (person.equals(lastPerson)) {
                    weekendModularIndex = (weekendModularIndex + 1) % weekendModular;
                    person = weekendDayPeople.get(weekendModularIndex);
                }
            }
            monthPeople.add(person);
            lastPerson = person;
        }
        return monthPeople;
    }


    private boolean isHolidayOrWeekendDay(int day) {
        return calender.get(day).isHoliday() || calender.get(day).isWeekendDay();
    }


    private boolean isDayWeekDay(int day) {
        if (!calender.get(day).isWeekendDay() && !calender.get(day).isHoliday()) {
            return true;
        }
        return false;
    }

}
