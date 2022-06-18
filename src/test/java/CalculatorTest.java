import org.example.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void empty_string_should_return_zero() {
        assertThat(calculator.Add(""))
                .isEqualTo(0);
    }

    @Test
    void one_number_should_return_number() {
        assertThat(calculator.Add("1"))
                .isEqualTo(1);
    }

    @Test
    void two_numbers_should_return_sum() {
        assertThat(calculator.Add("1,2"))
                .isEqualTo(3);
    }

    @Test
    void unknown_amount_of_numbers_returns_sum() {
        assertThat(calculator.Add("1,2,3,4,5"))
                .isEqualTo(15);
    }

    @Test
    void numbers_split_by_newline_or_comma_returns_sum() {
        assertThat(calculator.Add("1\n2,3"))
                .isEqualTo(6);
    }

    @Test
    void numbers_split_by_custom_delimiter() {
        assertThat(calculator.Add("//;\n1;2;2"))
                .isEqualTo(5);
    }

    @Test
    void throw_exception_when_negative_number() throws IllegalArgumentException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.Add("//;\n1;2;-1;-3;2;-4"));
        assertThat(exception)
                .hasMessageContaining("negatives not allowed: [-1, -3, -4]");
    }

    @Test
    void ignore_numbers_greater_than_1000() {
        assertThat(calculator.Add("1,3,1001,6"))
                .isEqualTo(10);
    }
}
