package kr.co.imguru.ex4;

import org.junit.Test;

import static org.mockito.Mockito.*;

// Mockito 라이브러리가 1.8 이전에는 spy와 mock은 차이가 없었습니다.
// 1.8 이후에는 아래처럼 변경되었습니다.
//  mock: 행위 검증 - 실제 객체의 동작을 수행하지 않는다.
//  spy: 행위가 발생된 사실을 기록 - 실제 객체의 동작을 수행한다.

public class MockitoSample {
    @Test
    public void test() {
        Engine engine = spy(Engine.class);
        Car car = new Car(engine);

        car.start();

        verify(engine).start();
    }
}

// SUT
class Engine {
    void start() {
        System.out.println("Engine start");
    }
}

class Car {
    private Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }

    void start() {
        engine.start();
    }
}




