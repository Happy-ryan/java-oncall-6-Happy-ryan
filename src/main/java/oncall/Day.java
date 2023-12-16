package oncall;

public class Day {
    private final String day;

    private final boolean isWeekendDay;
    private final boolean isHoliday;

    public Day(String day, boolean isHoliday,boolean isWeekendDay){
        this.day = day;
        this.isWeekendDay = isWeekendDay;
        this.isHoliday = isHoliday;
    }

    public String getDay() {
        return day;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public boolean isWeekendDay() {
        return isWeekendDay;
    }
}
