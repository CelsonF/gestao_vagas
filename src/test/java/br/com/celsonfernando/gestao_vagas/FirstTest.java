package br.com.celsonfernando.gestao_vagas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class FirstTest {
    
    @Test
    public void testing_calculate_two_numbers() {
        var result = calculate(2,3);

        assertEquals(result,5);
    }

    @Test
    public void testing_calculate_two_numbers_is_wrong() {
        var result = calculate(2, 4);

        assertNotEquals(result,5);
    }

    public static double calculate(double num1, double num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        var result = calculate(2, 4);
        System.out.println(result);
    }
}
