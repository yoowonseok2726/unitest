package kr.co.imguru.ex4;

import org.junit.Test;

import static kr.co.imguru.ex4.RomanNumerals.format;
import static org.junit.Assert.assertEquals;

public class Sample2 {
    @Test
    public void testIntegers() {
        assertEquals("I", format(1));
        assertEquals("II", format(2));
        assertEquals("III", format(3));
        assertEquals("IV", format(4));
        assertEquals("X", format(10));
    }
}
