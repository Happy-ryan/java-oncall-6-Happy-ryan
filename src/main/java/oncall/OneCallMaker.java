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
        int weekdayModularIndex = 0;
        int weekendModularIndex = 0;
        String lastPerson = null;
        for (int day = 1; day <= totalDate; day++) {
            String person;
            if (isDayWeekDay(day)) {
                person = weekDayPeople.get(weekdayModularIndex % weekdayModular);
                weekdayModularIndex++;
                if (day < totalDate && isHolidayOrWeekendDay(day + 1) && person.equals(weekendDayPeople.get(weekendModularIndex % weekendModular))) {
                    weekendModularIndex++;
                }
            } else {
                person = weekendDayPeople.get(weekendModularIndex % weekendModular);
                weekendModularIndex++;
                if (day < totalDate && !isHolidayOrWeekendDay(day + 1) && person.equals(weekDayPeople.get(weekdayModularIndex % weekdayModular))) {
                    weekdayModularIndex++;
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
