package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationBaseballTest {
    @Test
    void 입력값검증() {
        boolean input = ValidationBaseball.inputValue(9);
        assertThat(input).isTrue();
    }
}
