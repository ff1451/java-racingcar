package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingManager game = new RacingManager();
        try {
            game.racingGame();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
