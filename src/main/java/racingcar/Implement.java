package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Implement {
    String[] prepares;
    public String[] createNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");
        for (String name : carNames){
            if (name.length() >=6) {
                throw new IllegalArgumentException("자동차 이름은 5자까지만 가능합니다.");
            }
        }
        return carNames;
    }
    public int getCount(){
        int count = 0 ;
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            count = Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e){
            System.out.println("유효하지 않은 숫자가 입력되었습니다.");
        }
        if (count < 1){
            throw new IllegalArgumentException("1이상의 횟수를 입력해야합니다.");
        }
        return count;
    }

    public String[] prepare(String[] carNames) {
        prepares = new String[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            prepares[i] = carNames[i] + " : ";
        }
        return prepares;
    }

    public int[] runStop(String[] prepares){
        int[] positions = new int[prepares.length];
        for (int i = 0; i< prepares.length; i++){
           int random = Randoms.pickNumberInRange(0,9);
           if(random >=4){
               positions[i] += 1;
           }
        }
        return positions;
    }

    //public void status(String[] prepares, int[] position){
        //if()
    //}
    public void printStatus(String[] prepares, int[] position) {
        for (int i = 0; i < prepares.length; i++) {
            updatePrepare(prepares, position, i);
        }
    }

    private void updatePrepare(String[] prepares, int[] position, int index) {
        for (int j = 0; j < 1; j++) {
            if (position[index] > 0) {
                prepares[index] += "-";
            }
            System.out.println(prepares[index]);
        }
    }


    public void racing(String[] prepares, int count){
        for(int i = 0; i < count; i++){
            printStatus(prepares, runStop(prepares));
            System.out.println();
        }
    }



}
