package Lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Lesson4.Functions.areaTriangle;
import static Lesson4.Functions.isNumberEven;

public class TriangleTest {
    @Test
    @DisplayName("Ошибка при значение одной из сторон 0")
    void testOneOfSidesIsZero(){
        Assertions.assertEquals("Треугольник со значением стороны 0 или отрицательным не существует", areaTriangle(0, 5, 10));
    }

    @Test
    @DisplayName("Ошибка при значение одной из сторон отрицательная")
    void testOneOfSidesIsNegative(){
        Assertions.assertEquals("Треугольник со значением стороны 0 или отрицательным не существует", areaTriangle(-1, 5, 10));
    }

    @Test
    @DisplayName("Позитивный сценарий")
    void testPositiveAreaTriangle(){
        Assertions.assertEquals(6.0, areaTriangle(3, 4, 5));
    }
}
