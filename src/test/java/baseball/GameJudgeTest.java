package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameJudgeTest {
    GameJudge gameJudge = new GameJudge();

    @Test
    void 결과예측(){
        int[] answer = new int[3];
        int[] input = new int[3];
        int[] result = new int[2];
        answer[0] = 1;
        answer[1] = 2;
        answer[2] = 3;
        input[0] = 1;
        input[1] = 2;
        input[2] = 3;
        result[0] = 3;
        result[1] = 0;
        assertEquals(Arrays.toString(returnResult(answer, input)), Arrays.toString(result));
    }

    int[] returnResult(int[] answer, int[] input){
        int[] pred = new int[2];
        pred[0] = gameJudge.strikeJudgment(input, answer);
        pred[1] = gameJudge.ballJudgment(input, answer);
        return pred;
    }

}