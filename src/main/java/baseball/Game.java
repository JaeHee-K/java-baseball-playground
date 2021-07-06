package baseball;

import java.util.Arrays;

public class Game {
    static Game game = new Game();

    public void gameStart(){
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        GameJudge gameJudge = new GameJudge();
        while(true){
            int[] result = gameJudge.judge(inputView.inputNumber());
            resultView.gameResult(result[0], result[1]);
        }
    }

    public static void main(String[] args) {
        game.gameStart();
    }
}
