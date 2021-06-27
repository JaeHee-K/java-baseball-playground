package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseballGame_Test {
    static BaseballGame_Test baseballGame = new BaseballGame_Test();
    static BaseballGame_Test.InputView inputView = baseballGame.new InputView();
    static BaseballGame_Test.ResultView resultView = baseballGame.new ResultView();
    Scanner scanner = new Scanner(System.in);
    static int[] answer = baseballGame.randNumber();
    static int strike, ball;

    class InputView{
        @Test
        public int[] numberInput(){
            System.out.print("숫자를 입력해 주세요 : ");
            int value = scanner.nextInt();
            assertTrue(value > 0 && value < 1000);
            int[] values = inputConversion(value);
            int[] reverse_value = reverseNumber(values);
            System.out.println(reverse_value.length);
            return reverse_value;
        }
        @Test
        public int[] inputConversion(int value){
            int[] values = new int[3];
            for(int i=0;i<3;i++){
                values[i] = (value % (int)(Math.pow(10, (i + 1)))) / (int)(Math.pow(10, i));
                assertTrue(values[i] != 0);
            }
            return values;
        }
        @Test
        public int[] reverseNumber(int[] values){
            int[] reverse_values = new int[3];
            for(int i=2,j=0;i>-1;i--,j++){
                reverse_values[j] = values[i];
                assertTrue(reverse_values[j] != 0);
            }
            return reverse_values;
        }
    }

    class ResultView{
        @Test
        public void gameResult(){
            assertNotNull(strike);
            assertNotNull(ball);
            // 테스트 코드(삭제예정)
            System.out.println("answer : " + Arrays.toString(answer));
            //
            System.out.println("strike : " + strike);
            System.out.println("ball : " + ball);
            if(strike == 3){
                resultView.gameFinish();
            }
        }
        public void gameFinish(){
            System.out.println("3개의 숫자를 모두맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            while(true) {
                finishCheck();
            }
        }
        @Test
        public void finishCheck(){
            int game_select = scanner.nextInt();
            assertNotNull(game_select);
            if (game_select == 1) {
                answer = baseballGame.randNumber();
                baseballGame.gameStart();
            } else if (game_select == 2) {
                System.out.println("게임이 종료되었습니다.");
                System.exit(0);
            } else {
                System.out.println("1 또는 2를 입력하세요.");
            }
        }
    }
    @Test
    public int[] randNumber(){
        Random rand = new Random();
        answer = new int[3];

        for(int i=0;i<3;i++){
            answer[i] = rand.nextInt(9) + 1;
            for(int j=0;j<i;j++){
                if(answer[i]==answer[j]){
                    i--;
                }
            }
            assertTrue(answer[i] > 0 && answer[i] < 10);
        }
        return answer;
    }
    @Test
    public void gameStart(){
        while(true) {
            int[] inputValue = inputView.numberInput();
            assertNotNull(inputValue);
            strikeCheck(inputValue);
            resultView.gameResult();
        }
    }
    @Test
    public void strikeCheck(int[] inputValue){
        assertNotNull(inputValue);
        strike = 0;
        ball = 0;

        for(int i=0;i<3;i++){
            if(answer[i] == inputValue[i]){
                strike++;
                continue;
            }
            for(int j=0;j<3;j++){
                if(answer[i] == inputValue[j]){
                    ball++;
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        baseballGame.gameStart();
    }
}
