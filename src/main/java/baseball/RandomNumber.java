package baseball;

import java.util.Random;

public class RandomNumber {
    private Random rand = new Random();
    private int[] answer = new int[3];
    public int test = 5;

    public int[] randomSet(){
        for(int i=0;i<3;i++){
            answer[i] = rand.nextInt(9) + 1;
            i = validAnswer(i);
        }
        return answer;
    }

    private int validAnswer(int validNumber){
        for(int j=0;j<validNumber;j++){
            validNumber = validNumberCheck(j, validNumber);
        }
        return validNumber;
    }

    private int validNumberCheck(int j, int validNumber) {
        if(answer[j] == answer[validNumber]){
            validNumber--;
        }
        return validNumber;
    }
}
