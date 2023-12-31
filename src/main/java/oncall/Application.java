package oncall;

import view.InputView;
import view.OutputView;
import view.Validator;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int MONTH_INDEX = 0, DAY_INDEX = 1, WEEK_DAY = 0, WEENKEDN_DAY = 1;
        String monthAndDay = InputView.readMonthAndDay();
        int monthNumber = Integer.parseInt(monthAndDay.split(",")[MONTH_INDEX]);
        String startDay = monthAndDay.split(",")[DAY_INDEX];

        OutputView.printMonthDay(monthAndDay);

        List<List<String>> peoples = getPeople();
        List<String> weekDayPeople = peoples.get(WEEK_DAY);
        List<String> weekendDayPeople = peoples.get(WEENKEDN_DAY);

        CalenderMaker calenderMaker = new CalenderMaker(monthNumber, startDay);
        LinkedHashMap<Integer, Day> calender = calenderMaker.makeCalender();

        OneCallMaker oneCallMaker = new OneCallMaker(weekDayPeople, weekendDayPeople, calender);
        List<String> onCallSystem = oneCallMaker.makeOnCallSystem();

        OneCall oneCall = new OneCall(monthNumber, onCallSystem, calender);
        oneCall.matchOnCall();
    }

    private static boolean isInputValid(boolean allValidChcek) {
        if (allValidChcek) {
            return true;
        }
        return false;
    }

    private static List<List<String>> getPeople() {
        int MAX_DAY = 2;
        List<String> weekDayPeople;
        List<String> weekendDayPeople;
        while (true) {
            try {
                weekDayPeople = InputView.readPeople(true);
                OutputView.printPeople(weekDayPeople);
                weekendDayPeople = InputView.readPeople(false);
                OutputView.printPeople(weekendDayPeople);

                Validator validator = new Validator(weekDayPeople, weekendDayPeople);
                boolean allValidCheck = validator.allValidateCheck(true, MAX_DAY)
                        && validator.allValidateCheck(false, MAX_DAY);
                if (isInputValid(allValidCheck)) {
                    break;
                }
                OutputView.printErrorMessage();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage();
            }
        }
        return Arrays.asList(weekDayPeople, weekendDayPeople);
    }

}
