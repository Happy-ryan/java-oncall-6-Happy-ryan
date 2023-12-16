package oncall;

import java.util.*;

public class CalenderMaker {
    private final int monthNumber;
    private final String startDay;

    public CalenderMaker(int monthNumber, String startDay) {
        this.monthNumber = monthNumber;
        this.startDay = startDay;
    }

    public LinkedHashMap<Integer, Day> makeCalender() {
        List<String> dayOfWeek = decideStartDayOfWeek(startDay);
        Month month = Month.findMonth(monthNumber);
        return createCalender(dayOfWeek, month);
    }

    private LinkedHashMap<Integer, Day> createCalender(List<String> dayOfWeek, Month month) {
        LinkedHashMap<Integer, Day> calender = new LinkedHashMap<>();
        for (int dayNumber = month.getStartDay(); dayNumber <= month.getEndDay(); dayNumber++) {
            Day day = createDay(dayOfWeek, month, dayNumber);
            calender.put(dayNumber, day);
        }
        return calender;
    }

    private Day createDay(List<String> dayOfWeek, Month month, int dayNumber) {
        int mod = (dayNumber - 1) % 7;
        boolean isHoliday = isHoliday(month, dayNumber);
        return new Day(dayOfWeek.get(mod), isHoliday);
    }

    private List<String> decideStartDayOfWeek(String day) {
        if (day.equals("월")) {
            return Arrays.asList("월", "화", "수", "목", "금", "토", "일");
        }
        if (day.equals("화")) {
            return Arrays.asList("화", "수", "목", "금", "토", "일", "월");
        }
        if (day.equals("수")) {
            return Arrays.asList("수", "목", "금", "토", "일", "월", "화");
        }
        if (day.equals("목")) {
            return Arrays.asList("목", "금", "토", "일", "월", "화", "수");
        }
        if (day.equals("금")) {
            return Arrays.asList("금", "토", "일", "월", "화", "수", "목");
        }
        if (day.equals("토")) {
            return Arrays.asList("토", "일", "월", "화", "수", "목", "금");
        }
        if (day.equals("일")) {
            return Arrays.asList("일", "월", "화", "수", "목", "금", "토");
        }
        throw new IllegalArgumentException("Invalid day of week: " + day);
    }

    private boolean isHoliday(Month month, int dayNumber) {
        if (month.getHolidays().contains(dayNumber)) {
            return true;
        }
        return false;
    }
}
