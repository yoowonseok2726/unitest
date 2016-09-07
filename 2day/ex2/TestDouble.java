package kr.co.imguru.ex2;

// 단위 테스트 작성 방법 2가지
// 1) 상태 기반 테스트(State Verification)
//  - 객체가 특정 시점에 자신만의 상태를 가진다.

// 2) 행위 기반 테스트(Behavior Verification)
//  - 올바른 로직 수행의 근거로 특정한 동작의 수행 여부를 이용한다.
//  - mock object

// 행위 기반 테스트를 수행하기 위해서는 복잡한 테스트 대역에 대한 부담이 있습니다.
// 효과적으로 테스트 대역을 이용해서 테스트를 수행하기 위해서는 격리 프레임워크를 이용하는 것이
// 중요합니다.
// 격리 프레임워크 - mock framework
//  Java - jMock, easyMock, Mockito(*)
//  C++  - google Mock(*), mockitopp


// Test Double Pattern 정리
// 목적
// 1) 테스트 시간 단축
// 2) 난수나 현재 시간등의 비결정적 요소 제어
// 3) 특수한 상황을 시뮬레이션
// 4) 숨겨진 정보 확인
// 5) 행위 기반 검증
//  => 테스트 대상 코드 격리

// 종류
// 1) Stub: 결과를 제어하는 용도의 테스트 대역
//          (불필요한 협력 객체를 쳐낼 때 사용)
// 2) Fake: 진짜 객체를 사용하기 어렵거나, 아직 존재하지 않을 때 사용
// 3) Spy:  접근 불가능한 내부 정보 확인
// 4) Mock: 기대한 상호 작용이 정말로 일어났는지 확인하는 행위 기반 테스트 이용




import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestDouble {
    @Test
    public void testPlayMusic() {
        // Arrange
        Person person = new Person();
        MP3 mp3 = mock(MP3.class);

        // Act
        person.playMusic(mp3);

        // Assertion
        // mp3에 대해서 play()가 수행되었는가를 검증한다.
        verify(mp3).stop();
    }
}

// SUT
interface MP3 {
    void play();
    void stop();
}

class iPod implements MP3 {
    @Override
    public void play() {
        System.out.println("Play mp3 with iPod");
    }

    @Override
    public void stop() {
        System.out.println("Stop Playing mp3");
    }
}

class Person {
    public void playMusic(MP3 mp3) {
        //....
        mp3.play();
    }
}












