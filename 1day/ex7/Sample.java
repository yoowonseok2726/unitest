package kr.co.imguru.ex7;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

// Map<Key, Value> 을 테스트 하는 코드
public class Sample {

    // 사용자 정의 단언문
    //  - 테스트 메소드 안에 복잡한 조건문이나 반복문이 존재한다면, 이 부분을
    //    별도의 단정문으로 캡슐화 하자!

    private void assertContains(Iterator i, String key, Object value) {
        while (i.hasNext()) {
            Map.Entry entry = (Map.Entry) i.next();
            if (key.equals(entry.getKey())) {
                assertEquals(value, entry.getValue());
                return;
            }
        }

        fail("Iterator did not contains " + key + " => " + value);
    }

    @Test
    public void mapTest2() throws Exception {
        // Arrange
        Map<String, Object> dict = new HashMap<>();

        // Act
        dict.put("A", 3L);
        dict.put("B", "21");

        // Assert
        Set<Map.Entry<String, Object>> list = dict.entrySet();
        assertContains(list.iterator(), "A", 3L);
        assertContains(list.iterator(), "B", 21);
    }





    @Test
    public void mapTest() throws Exception {
        // Arrange
        Map<String, Object> dict = new HashMap<>();

        // Act
        dict.put("A", 3L);
        dict.put("B", "21");

        // Assert
        Set<Map.Entry<String, Object>> list = dict.entrySet();
        for (Map.Entry<String, Object> entry : list) {
            if ("A".equals(entry.getKey())) {
                assertEquals(3L, entry.getValue());
            } else if ("B".equals(entry.getKey())) {
                assertEquals("21", entry.getValue());
            }
        }
    }
}
















