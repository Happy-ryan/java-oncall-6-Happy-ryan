package oncall;

public class Day {
    private final String day;
    private final boolean isHoliday;

    public Day(String day, boolean isHoliday){
        this.day = day;
        this.isHoliday = isHoliday;
    }

    public String getDay() {
        return day;
    }

    public boolean isHoliday() {
        return isHoliday;
    }
}
