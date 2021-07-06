package baseball;

import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    Scanner scan = new Scanner(System.in);

    public int[] inputNumber(){
        int value = inputValue();
        int[] array_value = transValue(value);
        return array_value;
    }

    private int inputValue(){
        System.out.print("숫자를 입력해 주세요 : ");
        int value = scan.nextInt();
        if(value >= 123 && value <= 987) {
            return value;
        }
        System.out.println("123 ~ 987 사이의 값을 입력하세요");
        return inputValue();
    }

    private int[] transValue(int value) {
        int[] array_value = Stream.of(String.valueOf(value).split("")).mapToInt(Integer::parseInt).toArray();
        return array_value;
    }
}
