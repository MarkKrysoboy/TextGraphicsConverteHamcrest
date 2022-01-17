package ru.netology.graphics.image;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.*;

public class BadImageSizeExceptionTest {
    @BeforeAll
    public static void startAll() {
        System.out.println("All tests started");
    }

    @BeforeEach
    public void startTest() {
        System.out.println("Test started");
    }

    @AfterEach
    public void stopTest() {
        System.out.println("Test finished");
    }

    @AfterAll
    public static void stop() {
        System.out.println("All tests finished");
    }

    @Test
    public void testContainsRatioInMessage() {
        double ratio = 4, maxRatio = 3;
        BadImageSizeException exception = new BadImageSizeException(ratio, maxRatio);
        assertThat(exception.getMessage(), Matchers.containsString(String.valueOf(ratio)));
    }

    @Test
    public void testEqualsMessage() {
        double ratio = 4.2, maxRatio = 3.1;
        String str = "Максимальное соотношение сторон изображения 3.1, а у этого 4.2";
        BadImageSizeException exception = new BadImageSizeException(ratio, maxRatio);
        assertThat(exception.getMessage(), Matchers.is(str));
    }
}
