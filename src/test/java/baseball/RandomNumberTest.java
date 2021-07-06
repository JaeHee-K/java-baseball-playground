package baseball;

import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RandomNumberTest {
    private RandomNumber randomNumber = new RandomNumber();
    private int[] value = new int[3];
    @BeforeEach
    @DisplayName("난수 생성")
    void 난수생성(){
        value = randomNumber.randomSet();
    }

    @Test
    @Order(1)
    @DisplayName("중복 숫자 확인")
    void 중복_숫자_확인(){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<value.length;i++)
            set.add(value[i]);
        assertEquals(value.length, set.size());
    }

    @Test
    @Order(2)
    @DisplayName("0포함 확인")
    void _0포함_확인(){
        for(int i=0;i<value.length;i++)
            assertTrue(zeroCheck(value[i]));
    }

    @Test
    @Order(3)
    @DisplayName("1~9 범위 확인")
    void _1부터9까지_숫자범위_확인(){
        for(int i=0;i<value.length;i++)
            assertTrue(rangeCheck(value[i]));
    }

    private boolean zeroCheck(int value) {
        if(value != 0)
            return true;
        return false;
    }

    private boolean rangeCheck(int value) {
        if(1 <= value && 9 >= value)
            return true;
        return false;
    }

}