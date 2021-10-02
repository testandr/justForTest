package Lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static Lesson4.Functions.isNumberEven;
import static Lesson4.Functions.isNumberPrime;

public class FunctionsTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Метод выполнился перед тестами");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Метод выполнился перед каждым тестом");
    }

    @Test
    @DisplayName("Передаем четное число в метод из...")
    @Disabled
    void testGivenEvenNumberWhenCheckIsEvenThenTrue(){
        boolean result = isNumberEven(2);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("dfd")
    void isNumberPriveTest(int number){
        Assertions.assertTrue(isNumberPrime(number));
    }

    @ParameterizedTest
    @CsvSource({"1, true", "3, true", "4, false"})
    @DisplayName("dfd")
    void isNumberPriveTest2(int number, boolean result){
        Assertions.assertEquals(result, isNumberPrime(number));
    }

    @ParameterizedTest
    @MethodSource("testDataSource")
    void objectAsParamExampleTest(Cat cat, boolean result){}

    private static Stream<Arguments> testDataSource(){
        return Stream.of(
                Arguments.arguments(new Cat(10, "Moris"), true),
                Arguments.arguments(new Cat(10, "Moris2"), false)
        );
    }


    @AfterEach
    void afterEach(){
        System.out.println("Метод выполнился после каждого тестов");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Метод выполнился после тестов");
    }
}
