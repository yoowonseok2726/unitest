package kr.co.imguru.ex4;


// Parameterized Test Pattern - 파라미터화 테스트 패턴
//  - xUnit Test Framework 에서 지원하는 기능을 이용해야 한다.
//  - junit4

// 개념: 데이터를 바꿔가며 수차례 반복 검사하는 데이터 중심 테스트가 있을 때
//     중복을 제거할 수 있는 기법이다.

// 문제점:
// 1. 논리가 분산되고 테스트를 실패하게 만든 데이터가 무엇인지 찾기 어렵다.
// 2. 테스트 코드가 복잡하다.

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static kr.co.imguru.ex4.RomanNumerals.format;
import static org.junit.Assert.assertEquals;

// junit 4에서 파라미터화 테스트를 수행하는 방법
// 1. 테스트 러너를 파라미터화 테스트 러너로 변경해야 한다.
@RunWith(Parameterized.class)
public class Sample {

    private int value;
    private String result;

    // 3. Sample 생성자를 정의한다.
    public Sample(int value, String result) {
        this.value = value;
        this.result = result;
    }

    // 2. Data를 정의한다.
    @Parameterized.Parameters(name="{index} : value({0}), result({1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "XV"},
                {10, "X"}
        });
    }

    //-------------------------------------
    // 이제 다양한 테스트 메소드를 정의하면 됩니다.
    @Test
    public void formatIntegers() {
        assertEquals(result, format(value));
    }
}


// SUT
class RomanNumerals {
    private final static Mapping[] ROMAN_VALUE_TABLE =
            {
                    new Mapping(1000, "M"),
                    new Mapping(900, "CM"),
                    new Mapping(500, "D"),
                    new Mapping(400, "CD"),
                    new Mapping(100, "C"),
                    new Mapping(90, "XC"),
                    new Mapping(50, "L"),
                    new Mapping(40, "XL"),
                    new Mapping(10, "X"),
                    new Mapping(9, "IX"),
                    new Mapping(5, "V"),
                    new Mapping(4, "IV"),
                    new Mapping(1, "I")
            };

    static String format(int number) {
        if (number >= 4000 || number < 1) {
            throw new NumberFormatException("Numbers must be in range 1-3999");
        }

        StringBuilder result = new StringBuilder(10);
        for (Mapping equiv : ROMAN_VALUE_TABLE) {
            while (number >= equiv.integer) {
                number -= equiv.integer;
                result.append(equiv.roman);
            }
        }
        return result.toString();
    }

    private static class Mapping {
        final int integer;
        final String roman;

        Mapping(int dec, String rom) {
            this.integer = dec;
            this.roman = rom;
        }
    }
}