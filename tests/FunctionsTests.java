import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionsTests {

    @Test
    public void testCountSymbolNumberStringIsNull() {
        assertEquals(0, Functions.countSymbolNumber(null, 'a'));
    }

    @Test
    public void testCountSymbolNumberStringIsEmpty() {
        assertEquals(0, Functions.countSymbolNumber("", 'a'));
    }

    @Test
    public void testCountSymbolNumberStringContainsRequiredSymbol() {
        assertEquals(1, Functions.countSymbolNumber("abc", 'a'));
    }

    @Test
    public void testCountSymbolNumberStringContainsNoRequiredSymbol() {
        assertEquals(0, Functions.countSymbolNumber("xyz", 'a'));
    }

    @Test
    public void testCountSymbolNumberStringConsistsOfRequiredSymbols() {
        assertEquals(3, Functions.countSymbolNumber("aaa", 'a'));
    }

    @Test
    public void testHaveSameElementArrayIsNull() {
        assertFalse(Functions.haveSameElement(null));
    }

    @Test
    public void testHaveSameElementArrayIsEmpty() {
        assertFalse(Functions.haveSameElement(new String[]{}));
    }

    @Test
    public void testHaveSameElementArrayHasOneElement() {
        assertFalse(Functions.haveSameElement(new String[]{"abc"}));
    }

    @Test
    public void testHaveSameElementArrayHasSameElements() {
        assertTrue(Functions.haveSameElement(new String[]{"abc", "def", "abc"}));
    }

    @Test
    public void testHaveSameElementArrayHasNoSameElements() {
        assertFalse(Functions.haveSameElement(new String[]{"abc", "def", "ghi"}));
    }

    @Test
    public void testMultiplyMatrixOneOfTheMatricesIsNull() {
        assertArrayEquals(null, Functions.multiplyMatrix(null, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    public void testMultiplyMatrixOneOfTheMatricesIsEmpty() {
        assertArrayEquals(null, Functions.multiplyMatrix(new int[][]{}, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    public void testMultiplyMatrixOneOfTheArraysIsNotMatrix() {
        assertArrayEquals(null, Functions.multiplyMatrix(
                new int[][]{
                        {1},
                        {2, 2},
                        {3, 3, 3}
                }, new int[][]{
                        {0, 1},
                        {0, 1}
                }));
    }

    @Test
    public void testMultiplyMatrixMatricesCanNotBeMultiplied() {
        assertArrayEquals(null, Functions.multiplyMatrix(
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6}
                }, new int[][]{
                        {1, 0},
                        {0, 1}
                }));
    }

    @Test
    public void testMultiplyMatrixOneOfTheMatricesConsistsOfZeros() {
        assertArrayEquals(
                new int[][]{
                        {0, 0},
                        {0, 0}
                }, Functions.multiplyMatrix(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6}
                        }, new int[][]{
                                {0, 0},
                                {0, 0},
                                {0, 0}
                        }));
    }

    @Test
    public void testMultiplyMatrixMatricesAreNotEmpty() {
        assertArrayEquals(
                new int[][]{
                        {0, 0},
                        {0, 0}
                }, Functions.multiplyMatrix(
                        new int[][]{
                                {1, 1, 1},
                                {1, 1, 1}
                        }, new int[][]{
                                {2, -1},
                                {-1, 0},
                                {-1, 1}
                        }));
    }

    @Test
    public void testIntersectArraysOneOfTheArraysIsNull(){
        assertArrayEquals(null, Functions.intersectArrays(null, new double[]{2.589, 0.1563, 10.24}), 1.0e-10);
    }

    @Test
    public void testIntersectArraysOneOfTheArraysIsEmpty(){
        assertArrayEquals(null, Functions.intersectArrays(new double[]{}, new double[]{2.589, 0.1563, 10.24}), 1.0e-10);
    }

    @Test
    public void testIntersectArraysIntersectionIsEmpty(){
        assertArrayEquals(null, Functions.intersectArrays(
                new double[]{2.7182818284, 99.99, 0.1234}, new double[]{2.7182818287, 10.24}), 1.0e-10);
    }

    @Test
    public void testIntersectArraysIntersectionIsNotEmpty(){
        assertArrayEquals(new double[]{2.7182818284, 99.99},
                Functions.intersectArrays(
                        new double[]{2.7182818284, 99.99, 3.1415926535},
                        new double[]{99.99, 1.234567, 2.7182818284, 3,141592}
                ), 1.0e-10);
    }

    @Test
    public void testIntersectArraysOneOfTheArraysContainsDuplicateElements(){
        assertArrayEquals(new double[]{2.718281, 99.99},
                Functions.intersectArrays(
                        new double[]{2.718281, 99.99, 2.718281, 0.112358, 99.99},
                        new double[]{99.99, 1.234567, 2.718281, 3,141592, 0.149}
                ), 1.0e-10);
    }
}