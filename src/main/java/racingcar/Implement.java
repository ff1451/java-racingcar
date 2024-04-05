package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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
        int maxLength = 0;
        ArrayList<String> winners = new ArrayList<>();

        // 가장 긴 길이 찾기
        for (String prepared : prepares) {
            int length = prepared.length();
            if (length > maxLength) {
                maxLength = length;
            }
        }

        // 가장 긴 길이를 가진 인덱스의 값을 우승자로 선택
        for (int i = 0; i < prepares.length; i++) {
            if (prepares[i].length() == maxLength) {
                winners.add(prepares[i].replace(" : ", "").replace("-", ""));
            }
        }

        // 우승자 출력
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    //최종 함수
    public void racingGame() {
        prepare(createCarNames());
        racingResult(getRacingCount());
        decisionWinner();
    }
}