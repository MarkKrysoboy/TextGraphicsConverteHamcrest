package ru.netology.graphics.image;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextColorSchemaImplTest {
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

    @ParameterizedTest
    @MethodSource("argumentsStreamTwo")
    public void testConvert(int color, char expected) {
        TextColorSchema schema = new TextColorSchemaImpl();
        assertThat(expected, Matchers.equalTo(schema.convert(color)));
    }

    private static Stream<Arguments> argumentsStreamTwo() {
        return Stream.of(Arguments.of(18, '#'), Arguments.of(55, '$'), Arguments.of(92, '@'), Arguments.of(129, '%'),
                Arguments.of(166, '*'), Arguments.of(203, '+'), Arguments.of(240, '-'));
    }
}
