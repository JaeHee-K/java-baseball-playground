package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Scanner;

public class Calculator {
    @Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        int cal_result = Integer.parseInt(values[0]);

        for(int i=1;i< values.length;i++){
            if(values[i].equals("+")){
                cal_result += Integer.parseInt(values[i+1]);
            }
            else if(values[i].equals("-")){
                cal_result -= Integer.parseInt(values[i+1]);
            }
            else if(values[i].equals("*")){
                cal_result *= Integer.parseInt(values[i+1]);
            }
            else if(values[i].equals("/")){
                cal_result /= Integer.parseInt(values[i+1]);
            }
        }

        assertThat(cal_result).isEqualTo(10);
    }
}
