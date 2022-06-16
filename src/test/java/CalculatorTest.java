
import org.example.StringCalculator;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CalculatorTest {

    @Test
    void empty_string_should_return_zero() {
        var calculator = new StringCalculator();
        var result = calculator.Add("");

        Assert.assertEquals(result, 0);
    }

    @Test
    void one_number_should_return_number() {
        var calculator = new StringCalculator();
        var result = calculator.Add("1");

        Assert.assertEquals(result, 1);
    }

    @Test
    void two_numbers_should_return_sum() {
        var calculator = new StringCalculator();
        var result = calculator.Add("1,2");

        Assert.assertEquals(result, 3);
    }

    @Test
    void unknown_amount_of_numbers_returns_sum() {
        var calculator = new StringCalculator();
        var result = calculator.Add("1,2,3,4,5");

        Assert.assertEquals(result, 15);
    }

    @Test
    void numbers_split_by_newline_or_comma_returns_sum() {
        var calculator = new StringCalculator();
        var result = calculator.Add("1\n2,3");

        Assert.assertEquals(result, 6);
    }

    @Test
    void numbers_split_by_custom_delimiter() {
        var calculator = new StringCalculator();
        var result = calculator.Add("//;\n1;2;2");

        Assert.assertEquals(result, 5);
    }
}
