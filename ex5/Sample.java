package kr.co.imguru.ex5;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


// 가독성
//  1) 테스트를 읽는 프로그래머가 코드가 해야 할일이 무엇인지 이해할 수 있어야 한다.
//  2) 테스트를 수행한 후에 코드가 실제로 한일이 무엇인지 말할 수 있어야 한다.

public class Sample {

    // input.txt
    // 1st match on #1
    // and
    // 2nd match on #3

    // [expected]
    // input.txt:1 1st match on #1
    // input.txt:3 2nd match on #3

    @Test
    public void testOutputHasLineNumbers() {
        String content = "1st match on #1\nand\n2nd match on #3";

        String out = Grep.grep("match", "input.txt", content);


        // 원시적인 단언문 (Primitive Assertion)
        //  : 확인하려는 것이 무엇인지 불분명하다.
        //  => 검사해야 할 동작보다 더 기초적인 요소에 집착하는 것

        // 1) !=, == 등의 비교문을 사용하는 단언문을 발견하면 추상화 수준이 적절한지 확인이 필요하다.
        // 2) 비교 대상이 -1, 0 등의 매직 넘버라면 개선이 필요하다.
        // => 단언문의 의도를 이해할 수 없다면 반드시 개선해야 한다.

        // assertTrue(out.indexOf("input.txt:1 1st match") != -1);
        // assertTrue(out.indexOf("input.txt:3 2nd match") != -1);

        assertTrue(out.contains("input.txt:1 1st match"));
        assertTrue(out.contains("input.txt:3 2nd match"));

        assertThat(out, containsString("input.txt:1 1st match"));
        assertThat(out, containsString("input.txt:3 2nd match"));
    }
}


// SUT
class Grep {
    static String grep(String pattern, String filename, String content) {
        return "";
    }
}