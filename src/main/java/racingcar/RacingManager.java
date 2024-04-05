package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class RacingManager {
    RacingSetting setting = new RacingSetting();

    private void runStop() {
        for (Car car : setting.cars) {
            car.move();
        }
    }

    private void printStatus() {
        for (Car car : setting.cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    private void racingResult(int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            runStop();
            printStatus();
            System.out.println();
        }
    }

    private List<String> decisionWinner() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        Iterator<Car> iterator = setting.cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            int resultPosition = car.getPosition();

            if (resultPosition > maxPosition) {
                maxPosition = resultPosition;
                winners.add(car.getCarName());
            } else if (resultPosition == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s", result);
    }

    public void racingGame() {
        int racingCount = setting.racingSetting();
        racingResult(racingCount);
        printWinners(decisionWinner());
    }
}