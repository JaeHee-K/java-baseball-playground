package study;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    static BaseballGame baseballGame = new BaseballGame();
    Scanner scanner = new Scanner(System.in);
    static int[] answer;

    public int[] randNumber(){
        Random rand = new Random();
        int[] answer = new int[3];

        for(int i=0;i<3;i++){
            answer[i] = rand.nextInt(9) + 1;
            for(int j=0;j<i;j++){
                if(answer[i]==answer[j]){
                    i--;
                }
            }
        }
        return answer;
    }

    public void gameStart(int[] answer){
        while(true) {
            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해 주세요 : ");
            int value = scanner.nextInt();
            int[] values = new int[3];
            int[] reverse_values = new int[3];
            for(int i=0;i<3;i++){
                values[i] = (value % (int)(Math.pow(10, (i + 1)))) / (int)(Math.pow(10, i));
            }
            for(int i=2,j=0;i>-1;i--,j++){
                reverse_values[j] = values[i];
            }

            for(int i=0;i<3;i++){
                if(answer[i] == reverse_values[i]){
                    strike++;
                    continue;
                }
                for(int j=0;j<3;j++){
                    if(answer[i] == reverse_values[j]){
                        ball++;
                        continue;
                    }
                }
            }

            System.out.println("answer : " + Arrays.toString(answer));
            System.out.println("input : " + Arrays.toString(reverse_values));
            System.out.println("strike : " + strike);
            System.out.println("ball : " + ball);

            if(strike == 3){
                gameFinish();
            }
        }
    }

    public void gameFinish(){
        System.out.println("3개의 숫자를 모두맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while(true) {
            int game_select = scanner.nextInt();
            if (game_select == 1) {
                answer = baseballGame.randNumber();
                baseballGame.gameStart(answer);
            } else if (game_select == 2) {
                System.out.println("게임이 종료되었습니다.");
                System.exit(0);
            } else {
                System.out.println("1 또는 2를 입력하세요.");
            }
        }
    }

    public static void main(String[] args) {
        answer = baseballGame.randNumber();
        baseballGame.gameStart(answer);
    }
}
