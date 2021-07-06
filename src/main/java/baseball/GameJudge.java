package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameJudge {
    private RandomNumber rand = new RandomNumber();
    private int[] answer = rand.randomSet();

    public int[] judge(int[] input){
        //테스트용 코드
        System.out.println("answer : "+Arrays.toString(answer));
        //
        int[] result = {strikeJudgment(input, answer), ballJudgment(input, answer)};
        return result;
    }

    public int strikeJudgment(int[] input, int[] answer){
        int strike = 0;
        for(int i=0;i<3;i++){
            strike += strikeCheck(input, answer, i);
        }
        return strike;
    }

    private int strikeCheck(int[] input, int[] answer, int index) {
        if(input[index] == answer[index])
            return 1;
        return 0;
    }

    public int ballJudgment(int[] input, int[] answer) {
        int ball = 0;
        for(int i=0;i<3;i++){
            ball += ballCheck(input, answer, i);
        }
        return ball;
    }

    private int ballCheck(int[] input, int[] answer, int index) {
        List<Integer> answerList = arrayToList(answer);
        if(input[index] != answer[index] && answerList.contains(input[index]))
            return 1;
        return 0;
    }

    private List<Integer> arrayToList(int[] value){
        List<Integer> tempList = new ArrayList<Integer>(value.length);
        for(int i=0;i<3;i++){
            tempList.add(value[i]);
        }
        return tempList;
    }
}
