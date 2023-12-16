package oncall;
import view.OutputView;

import java.util.*;
public class OneCall {
    private final int monthNumber;
    private final List<String> onCallSystem;
    private final LinkedHashMap<Integer, Day> calender;

    public OneCall(int monthNumber, List<String> onCallSystem, LinkedHashMap<Integer, Day> calender){
        this.monthNumber = monthNumber;
        this.onCallSystem = onCallSystem;
        this.calender = calender;
    }

    public void matchOnCall(){
        for(int dayNumber = 1; dayNumber < calender.keySet().size() ; dayNumber++){
            String day = calender.get(dayNumber).getDay();
            boolean isHoliday = calender.get(dayNumber).isHoliday();
            OutputView.printCalender(monthNumber,
                    dayNumber, day,onCallSystem.get(dayNumber - 1),isHoliday);
        }
    }
}
