package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.Implement;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Implement game = new Implement();
        try{
            game.Names();
            game.Count();
        }catch (Exception e){
            System.out.println("예외발생 " +e.getMessage());
        }
    }
}
