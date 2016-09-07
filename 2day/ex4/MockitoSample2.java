package kr.co.imguru.ex4;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.*;


// 1. interface type을 spy를 사용하는 것은 mock의 동작과 완벽하게 동일하다.
// 2. @Spy 어노테이션을 이용해서 스파이 객체를 생성하기 위해서는 interface type이 아니어야 한다
//      => class, abstract class
public class MockitoSample2 {
    @Spy private DLogTarget spy1;
    @Spy private DLogTarget spy2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDLogTarget() {
        // Arrange
//        DLogTarget spy1 = spy(DLogTarget.class);
//        DLogTarget spy2 = spy(DLogTarget.class);
        DLog logger = new DLog(spy1, spy2);

        logger.write(Level.INFO, "test_message");

        verify(spy1).write(Level.INFO, "test_message");
        verify(spy2).write(Level.INFO, "test_message");
    }
}

// SUT
// Java 8 : defender method
enum Level {
    INFO, WARN
}

interface DLogTarget {
    default void write(Level level, String message) {
        System.out.println("Write Log");
    }
}

class DLog {
    private DLogTarget[] targets;

    public DLog(DLogTarget... targets) {
        this.targets = targets;
    }

    void write(Level level, String message) {
        for (DLogTarget e : targets)
            e.write(level, message);
    }
}











