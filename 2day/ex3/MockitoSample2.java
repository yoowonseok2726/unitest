package kr.co.imguru.ex3;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoSample2 {

    // 암묵적 픽스쳐 설치로 Mock을 구성하는 방법
    @Mock
    private List<String> mockedList;

    @Before
    public void setUp() {
        // @Mock으로 되어 있는 객체 초기화
        MockitoAnnotations.initMocks(this);
    }

    // 1. mock - 호출 여부 검증
    @Test
    public void test1() {
        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");
        verify(mockedList).add("two");
    }


    // 2. 호출 횟수 검증
    @Test
    public void test2() {
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
}
















