package kr.co.imguru.ex3;

import org.junit.Test;

import static org.junit.Assert.*;

// 테스트 냄새 - 중복(Duplication)
//  개념: 필요 없는 반복
//  1) 개념과 논리를 분리 해서 코드가 이해하기 어렵게 된다. => 가독성
//  2) 코드를 수정하기 위해서는 중복된 곳을 찾아서 모두 수정해야 한다.
//    => 유지 보수성

public class Sample {

    // 1. 아래의 코드에는 [상수 중복]이 있다.
    //  => 상수 중복은 지역 변수를 만들어서 제거 가능하다.
    @Test
    public void emptyIdUserInfo() throws Exception {
        String emptyId = "";
        assertEquals(emptyId, new User(emptyId).displayName());
    }

    @Test
    public void normalIdUserInfo() throws Exception {
        String normalId = "testId";
        assertEquals(normalId, new User(normalId).displayName());
    }

    // 2. 구조 중복
    //  : 데이터만 다를 뿐 처리 로직이 동일한 경우

    //  Custom Assertion Pattern - 맞춤 단언문 패턴
    private void assertUserInfoShowsIdAsDisplayName(String id) {
        assertEquals(id, new User(id).displayName());
    }

    @Test
    public void emptyIdUserInfo2() throws Exception {
        String emptyId = "";

        assertUserInfoShowsIdAsDisplayName(emptyId);
    }

    @Test
    public void normalIdUserInfo2() throws Exception {
        String normalId = "testId";

        assertUserInfoShowsIdAsDisplayName(normalId);
    }
}


// SUT
class User {
    private String id;

    public User(String id) {
        this.id = id;
    }

    String displayName() {
        return this.id;
    }
}