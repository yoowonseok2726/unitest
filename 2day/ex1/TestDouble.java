package kr.co.imguru.ex1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Test Spy
// : 목격한 일을 기록해두었다가 나중에 테스트가 확인할 수 있도록 만들어진 테스트 대역
class SpyTarget implements DLogTarget {
    private List<String> history = new ArrayList<>();

    private String concat(Level level, String message) {
        return level.name() +":" + message;
    }

    // 테스트를 위한 메소드
    boolean received(Level level, String message) {
        return history.contains(concat(level, message));
    }

    @Override
    public void write(Level level, String message) {
        history.add(concat(level, message));
    }
}


public class TestDouble {
    @Test
    public void testWritesEachMessagesToAllTarget() {
        // Arrange
        SpyTarget spy1 = new SpyTarget();
        SpyTarget spy2 = new SpyTarget();
        DLog logger = new DLog(spy1, spy2);

        // Act
        logger.write(Level.INFO, "test_message1");
        logger.write(Level.WARNING, "test_message2");

        // Assertion
        Assert.assertTrue(spy1.received(Level.INFO, "test_message1"));
        Assert.assertTrue(spy1.received(Level.WARNING, "test_message2"));
        Assert.assertTrue(spy2.received(Level.INFO, "test_message1"));
        Assert.assertTrue(spy2.received(Level.WARNING, "test_message2"));
    }
}


// SUT
enum Level {
    INFO, DEBUG, WARNING
}

interface DLogTarget {
    void write(Level level, String message);
}

class DLog {
    private List<DLogTarget> targets = new ArrayList<>();

    public DLog(DLogTarget... targets) {
        this.targets.addAll(Arrays.asList(targets));
    }

    void write(Level level, String message) {
        for (DLogTarget e: targets)
            e.write(level, message);
    }
}












