package kr.co.imguru.ex2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Sample {
    private PeopleFinder finder;
    @Before
    public void setUp() {
        finder = new PeopleFinder();
    }

    // 테스트 냄새 - Conditional Test Logic
    //  문제점: 테스트 내의 조건문의 로직이 있으면 테스트 코드에서 무엇을 하는지
    //        분석하기 어려워진다.

    //   => 실행 경로가 하나 - 항상 같은 경로로 실행된다.
    //      실행 경로가 여러개 - 분석하기 어렵고 결과를 예측하기도 어렵다.
    //        : 가독성, 유지보수성
    @Test
    public void testWithConditional() {
        String name = "Tom";

        // Act
        List<Person> found = finder.find(name);

        // Assertion
        if (found.size() >= 1) {
            Person person = found.get(0);
            assertEquals(name, person.getName());
        } else {
            fail("list는 반드시 한개 이상의 데이터를 포함하고 있어야 함.");
        }
    }

    // 보호 단언문 패턴(Guard Assertion Pattern)
    //  : 테스트의 조건문을 단언문으로 교체해 if 조건을 만족하지 않으면 테스트를 실패시킨다.

    // 활용
    // 1) 조건문 제거
    // 2) 공유 픽스쳐 전략 문제를 예방

    @Test
    public void testWithConditional2() {
        String name = "Tom";

        // Act
        List<Person> found = finder.find(name);

        assertTrue("found people precondition", found.size() >= 1);
        Person person = found.get(0);
        assertEquals(name, person.getName());
    }
}

// SUT
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class PeopleFinder {
    private List<Person> people = new ArrayList<>();

    List<Person> find(String name) {
        List<Person> result = new ArrayList<>();

        for (Person e : people) {
            if (e.getName().equals(name))
                result.add(e);
        }

        return result;
    }

}











