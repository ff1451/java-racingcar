package racingcar.game;
import camp.nextstep.edu.missionutils.Console;
public class Implement {
    int count = 0;
    public void Names(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carName = Console.readLine().split(",");
        for (String name : carName){
            if (name.length() >=6) {
                throw new IllegalArgumentException("자동차 이름은 5자까지만 가능합니다.");
            }
        }
    }
    public void Count(){
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            count = Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e){
            System.out.println("유효하지 않은 숫자가 입력되었습니다.");
        }
        if (count < 1){
            throw new IllegalArgumentException("1이상의 횟수를 입력해야합니다.");
        }
    }



}
