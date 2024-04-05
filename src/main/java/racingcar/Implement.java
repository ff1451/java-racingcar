package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Implement {
    static int racingCount;
    List<Car> cars = new ArrayList<>();

    //자동차 이름 입력
    public void createCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");
        for (String name : carNames) {
            if (isNameValid(name)) {
                cars.add(new Car(name));
            }
        }
    }

    //자동차 이름 길이 판정
    private boolean isNameValid(String name) {
        if (name.length() >= 6) {
            throw new IllegalArgumentException("자동차 이름은 5자까지만 가능합니다.");
        }
        return true;
    }

    //횟수 입력
    public int getRacingCount() {
        racingCount = 0;
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

    //전진, 정지 동작
    private void runStop() {
        for (Car car : cars) {
            car.move();
        }
    }

    //이동 상태 출력
    private void printStatus() {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    //경주 결과 출력
    public void racingResult() {
        for (int i = 0; i < racingCount; i++) {
            runStop();
            printStatus();
            System.out.println();
        }
    }

    //우승자 결정
    public void decisionWinner() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            int resultPosition = car.getPosition();

            if (resultPosition > maxPosition) {
                maxPosition = resultPosition;
                winners.clear();
                winners.add(car.getCarName());
            } else if (resultPosition == maxPosition ){
                winners.add(car.getCarName());
            }
        }

        // 우승자 출력
        String result = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s", result);

    }
    
    //최종 함수
    public void racingGame() {
        createCarNames();
        getRacingCount();
        racingResult();
        decisionWinner();
    }
}