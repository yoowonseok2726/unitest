package kr.co.imguru.ex1;

// 유닛 테스트 작성시 고려되어야 하는 3가지 중점 사항
// 1) 가독성
// 2) 유지보수성
// 3) 신뢰성

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sample {
    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    // 테스트 케이스 안에서 객체에 대한 null 체크는 불필요한 경우가 많다
    //  => assertNotNull
    //  => 과잉 보호 테스트
    //  => 테스트의 결과를 결정하는 단언문에 도달하기 전에
    //     불필요한 중간 단계 단언문이 등장하는 것을 의미한다.
    @Test
    public void testGetData() {
        Data data = user.getData();

//        assertNotNull(data);
        // 위의 코드를 작성하지 않더라도, data.count()는 예외를 발생시킬 것이다.
        assertEquals(4, data.count());
    }
}

// SUT
class Data {
    public int count() {
        return 0;
    }
}

class User {
    public Data getData() {
        return null;
    }
}









