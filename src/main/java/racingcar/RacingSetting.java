package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingSetting {
    public List<Car> cars = new ArrayList<>();

    private void createCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");
        for (String name : carNames) {
            if (isNameValid(name)) {
                cars.add(new Car(name));
            }
        }
    }

    private boolean isNameValid(String name) {
        if (name.length() >= 6) {
            throw new IllegalArgumentException("자동차 이름은 5자까지만 가능합니다.");
        }
        return true;
    }

    private int getRacingCount() {
        int racingCount = 0;
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            racingCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 숫자가 입력되었습니다.");
        }
        if (racingCount < 1) {
            throw new IllegalArgumentException("1이상의 횟수를 입력해야합니다.");
        }
        return racingCount;
    }

    public int racingSetting() {
        createCarNames();
        return getRacingCount();
    }
}
