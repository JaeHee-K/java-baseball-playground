package baseball;

import java.util.Scanner;

public class ResultView {
    Game game = new Game();

    public void gameResult(int strike, int ball){
        if(strike != 0 || ball != 0)
            System.out.println(ball+"볼 "+strike+"스트라이크");
        if(strike == 0 && ball == 0)
            System.out.println("nothing");
        if(strike == 3)
            gameFinish();
    }

    private void gameFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while(true){
            finishCheck();
        }
    }

    private void finishCheck() {
        Scanner scan = new Scanner(System.in);
        int select = scan.nextInt();
        if(select == 1)
            game.gameStart();
        if(select == 2){
            System.out.println("게임이 종료되었습니다.");
            System.exit(0);
        }
    }

}
