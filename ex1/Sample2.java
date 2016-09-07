package kr.co.imguru.ex1;

import org.junit.Assert;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class Sample2 {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    // 매직 넘버의 사용을 자제해야 한다
    // 정의: 소스 코드 중 할당문이나 메소드 호출 등에 박혀있는 숫자로 된 값

    // => 의미가 분명한 이름의 상수나 변수로 대체해서 코드를 이해하기 쉽도록 해야 한다.
    public void testPerfectGame() {
        game.roll(10, 12);

        assertThat(game.score(), is(equalTo(300)));
    }

    // 1. 상수 방식
    private static final int TEN_PINS = 10;
    private static final int TWELVE_TIMES = 12;

    public void testPerfectGame2() {
        game.roll(TEN_PINS, TWELVE_TIMES);

        assertThat(game.score(), is(equalTo(300)));
    }

    // 2. 메소드 방식
    private int pins(int n) { return n; }
    private int times(int n) { return n; }

    public void testPerfectGame3() {
        game.roll(pins(10), times(12));

        assertThat(game.score(), is(equalTo(300)));
    }
}


// SUT
class Game {
    void roll(int pins, int times) {
    }

    int score() {
        return 0;
    }
}