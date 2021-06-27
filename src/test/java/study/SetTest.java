package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> number;

    @BeforeEach
    void setUp(){
        number = new HashSet<>();
        number.add(1);
        number.add(1);
        number.add(2);
        number.add(3);
    }

    /**
     * 요구사항 1
     */
    @Test
    void contains() {
        assertThat(number.size()).isEqualTo(3);
    }

    /**
     * 요구사항 2
     */
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void testNumber(int numbers){
        assertThat(number.contains(numbers)).isTrue();
    }

    /**
     * 요구사항 3
     */
    @ParameterizedTest
    @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
    void testNumber2(String input, String expected){
        if(expected.equals("True")){
            assertThat(number.contains(parseInt(input))).isTrue();
        }
        else{
            assertThat(number.contains(parseInt(input))).isFalse();
        }
    }
}
