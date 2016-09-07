package kr.co.imguru.ex4;

// Mockito 을 이용해서 stub을 만드는 것도 가능합니다.

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockitoSample3 {
    @Test
    public void test() {
        IExtensionManager stub = mock(IExtensionManager.class);
        String filename = "bad.log";
        when(stub.isValid(filename)).thenReturn(true);
        Logger logger = new Logger(stub);

        boolean actual = logger.isValidFilename(filename);

        assertFalse(actual);
    }

    @Test
    public void test2() {
        IExtensionManager stub = mock(IExtensionManager.class);
        String filename = "good_name.log";
        when(stub.isValid(any())).thenReturn(true);
        Logger logger = new Logger(stub);

        boolean actual = logger.isValidFilename(filename);

        assertTrue(actual);
    }


}

// SUT
interface IExtensionManager {
    boolean isValid(String filename);
}

class Logger {
    private IExtensionManager manager;
    public Logger(IExtensionManager manager) {
        this.manager = manager;
    }

    public boolean isValidFilename(String filename) {
        String name = filename.split("\\.")[0];
        if (name.length() < 5)
            return false;

        return manager.isValid(filename);
    }
}












