package Lesson4;

import org.junit.jupiter.api.*;

import static Lesson4.Functions.isNumberEven;

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
    void testGivenEvenNumberWhenCheckIsEvenThenTrue(){
        boolean result = isNumberEven(2);
        Assertions.assertTrue(result);
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
