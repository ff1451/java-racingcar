package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Implement {
    List<Car> cars = new ArrayList<>();

    //자동차 이름 입력
    public void createCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");
        for (String name : carNames) {
            if (name.length() >= 6) {
                throw new IllegalArgumentException("자동차 이름은 5자까지만 가능합니다.");
            }
            cars.add(new Car(name));
        }
    }

    //횟수 입력
    public int getRacingCount() {
        int count = 0;
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            count = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 숫자가 입력되었습니다.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("1이상의 횟수를 입력해야합니다.");
        }
        return count;
    }

    //전진, 정지 동작
    public int[] runStop(String[] prepares) {
        int[] positions = new int[prepares.length];
        for (int i = 0; i < prepares.length; i++) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                positions[i] += 1;
            }
        }
        return positions;
    }

    //출력 형태 맞추기
    public void prepare(String[] carNames) {
        prepares = new String[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            prepares[i] = carNames[i] + " : ";
        }
    }

    //이동 상황 업데이트
    private void updatePrepare(String[] prepares, int[] position, int index) {
        for (int j = 0; j < 1; j++) {
            if (position[index] > 0) {
                prepares[index] += "-";
            }
            System.out.println(prepares[index]);
        }
    }

    //이동 상태 출력
    public void printStatus(String[] prepares, int[] position) {
        for (int i = 0; i < prepares.length; i++) {
            updatePrepare(prepares, position, i);
        }
    }

    //경주 결과 출력
    public void racingresult(int count) {
        for (int i = 0; i < count; i++) {
            printStatus(prepares, runStop(prepares));
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
        racingresult(getRacingCount());
        decisionWinner();
    }
}