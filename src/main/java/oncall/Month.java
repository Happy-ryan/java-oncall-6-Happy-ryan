package oncall;

import java.util.ArrayList;
import java.util.List;

public enum Month {
    JANUARY(1, 1, 31, List.of(1)),
    FEBRUARY(2, 1, 28, List.of()),
    MARCH(3, 1, 31, List.of(1)),
    APRIL(4, 1, 30, List.of()),
    MAY(5, 1, 31, List.of(5)),
    JUNE(6, 1, 30, List.of(6)),
    JULY(7, 1, 31, List.of()),
    AUGUST(8, 1, 31, List.of(15)),
    SEPTEMBER(9, 1, 30, List.of()),
    OCTOBER(10, 1, 31, List.of(3, 9)),
    NOVEMBER(11, 1, 30, List.of()),
    DECEMBER(12, 1, 31, List.of(25));

    private final int monthNumber;
    private final int startDay;
    private final int endDay;
    private final List<Integer> holidays;
    private final int totalDays;

    Month(int monthNumber, int startDay, int endDay, List<Integer> holidays) {
        this.monthNumber = monthNumber;
        this.startDay = startDay;
        this.endDay = endDay;
        this.holidays = new ArrayList<>(holidays);
        this.totalDays = endDay - startDay + 1;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public List<Integer> getHolidays() {
        return holidays;
    }

    public static Month findMonth(int monthNumber) {
        for (Month month : Month.values()) {
            if (month.getMonthNumber() == monthNumber) {
                return month;
            }
        }
        throw new IllegalArgumentException("Invalid month number: " + monthNumber);
    }
}

