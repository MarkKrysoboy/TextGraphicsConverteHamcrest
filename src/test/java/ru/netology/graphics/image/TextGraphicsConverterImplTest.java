package ru.netology.graphics.image;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

public class TextGraphicsConverterImplTest {
    TextGraphicsConverterImpl converterTest;

    @BeforeAll
    public static void startAll() {
        System.out.println("All tests started");
    }

    @BeforeEach
    public void startTest() {
        System.out.println("Test started");
        converterTest = new TextGraphicsConverterImpl();
    }

    @AfterEach
    public void stopTest() {
        System.out.println("Test finished");
        converterTest = null;
    }

    @AfterAll
    public static void stop() {
        System.out.println("All tests finished");
    }

    @Test
    public void testNewSizesMaxWidth() {
        int width = 1000, height = 1500;
        converterTest.setMaxWidth(500);
        assertThat(new int[]{500, 750}, Matchers.equalTo(converterTest.newSizes(width, height)));
    }

    @Test
    public void testNewSizesMaxHeight() {
        int width = 1000, height = 1500;
        converterTest.setMaxHeight(500);
        assertThat(new int[]{333, 500}, Matchers.equalTo(converterTest.newSizes(width, height)));
    }

    @Test
    public void testNewSizesLessMaxWidth() {
        int width = 1000, height = 1000;
        converterTest.setMaxWidth(1500);
        assertThat(new int[]{1000, 1000}, Matchers.equalTo(converterTest.newSizes(width, height)));
    }

    @Test
    public void testNewSizesLessMaxHeight() {
        int width = 1000, height = 1500;
        converterTest.setMaxHeight(1500);
        assertThat(new int[]{1000, 1500}, Matchers.equalTo(converterTest.newSizes(width, height)));
    }

    @Test
    public void testNewSizesBothSizeHeight() {
        int width = 1000, height = 1500;
        converterTest.setMaxHeight(500);
        converterTest.setMaxWidth(500);
        assertThat(new int[]{333, 500}, Matchers.equalTo(converterTest.newSizes(width, height)));
    }

    @Test
    public void testNewSizesBothSizeWidth() { //arrange
        int width = 1000, height = 1500;
        converterTest.setMaxHeight(500);
        converterTest.setMaxWidth(250);
        assertThat(new int[]{250, 375}, Matchers.equalTo(converterTest.newSizes(width, height)));
    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    public void testNewSizesMaxWidthParam(int width, int height, int[] expected) {
        converterTest.setMaxWidth(500);
        assertThat(expected, Matchers.equalTo(converterTest.newSizes(width, height)));
    }

    private static Stream<Arguments> argumentsStream() {
        return Stream.of(Arguments.of(1000, 1500, new int[]{500, 750}), Arguments.of(400, 500, new int[]{400, 500}));
    }

    @Test
    public void testCheckRatioException() {
        //arrange
        int width = 1000, height = 4500;
        converterTest.setMaxRatio(3);
        //assert
        assertThrows(BadImageSizeException.class,
                //act
                () -> converterTest.checkRatio(width, height));
    }

//    @Test
//    public void testCheckRatioNotException() {
//        //arrange
//        int width = 1000, height = 2500;
//        converterTest.setMaxRatio(3);
//        //assert
//        assertDoesNotThrow(
//                //act
//                () -> converterTest.checkRatio(width, height));
//    }

    @ParameterizedTest
    @MethodSource("argumentsStreamTwo")
    public void testCheckRatioDoesNotException(int width, int height) {
        //arrange
        converterTest.setMaxRatio(3);
        //assert
        assertDoesNotThrow(
                //act
                () -> converterTest.checkRatio(width, height));
    }

    private static Stream<Arguments> argumentsStreamTwo() {
        return Stream.of(Arguments.of(1000, 2500), Arguments.of(2500, 1000));
    }



}
