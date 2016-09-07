package kr.co.imguru.ex3;


// 하나의 테스트 메소드 안에는 [하나의 단정 구문]을 넣는 것이 좋다.
//  => 죽은 단정문
//  => gtest: ASSERT_, EXPECT_


// 행위 기반 검증
//  1) 호출 여부 검증
//  2) 호출 횟수 검증
//  3) 호출 순서 검증

import org.junit.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoSample {
    // SUT
    public static void foo(List<String> mockedList) {
        // 이 부분은 내부적으로 호출된다.
        mockedList.add("one");
        mockedList.add("two");
    }

    @SuppressWarnings("unchecked")
    private List<String> initMock() {
        return mock(List.class);
    }


    // 1. mock - 호출 여부 검증
    @Test
    public void test1() {
        List<String> mockedList = initMock();

        // Act
        // foo(mockedList);

        verify(mockedList).add("one");
        verify(mockedList).add("two");
    }


    // 2. 호출 횟수 검증
    @Test
    public void test2() {
        List<String> mockedList = initMock();

        mockedList.add("once");
        mockedList.add("once");

        //   verify(mockedList).add("once");             // 1번
        // = verify(mockedList, times(1)).add("once");
        verify(mockedList, times(2)).add("once");

        // 호출되지 않은 경우도 검증이 가능하다.
        verify(mockedList, never()).add("foo");

        mockedList.add("foo");
        mockedList.add("foo");

        // 적어도 한번 이상 호출
        verify(mockedList, atLeastOnce()).add("foo");

        // 적어도 두번 이상 호출
        verify(mockedList, atLeast(2)).add("foo");

        // 최대 3번
        verify(mockedList, atMost(3)).add("foo");
    }


    private static void goo(List<String> s) {
        s.add("2");
        s.add("1");
        s.add("3");
    }

    // 3. 호출 순서 검증
    @Test
    public void test3() {
        List<String> first = initMock();

        goo(first);

        // 순서 검증이 필요하다면 아래처럼 한 줄만 추가하면 됩니다.
        InOrder order = inOrder(first);

        order.verify(first).add("2");
        order.verify(first).add("1");
        order.verify(first).add("3");
    }
}
















