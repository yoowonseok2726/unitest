package kr.co.imguru.ex4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class Sample3 {

    private String id;

    public Sample3(String id) {
        this.id = id;
    }

    @Parameterized.Parameters(name = "id({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Tom"},
                {"Kent"},
                {"Bruce"},
        });
    }

    @Test
    public void testIsValidIdString() {
        assertTrue(User.isValid(id));
    }
}


// SUT
class User {
    static boolean isValid(String id) {
        return id.length() >= 3;
    }
}