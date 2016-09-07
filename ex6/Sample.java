package kr.co.imguru.ex6;

import org.junit.Before;

import java.io.File;

public class Sample {
    private Logger logger;

    // 아래 코드는 문제가 있습니다.
    // 1. 윈도우즈 운영체제 종속적인 경로를 사용
    //   => 유닉스 기반의 환경에서 테스트하는 개발자는 결국 테스트를 수행할 수 없다.
    //   => 테스트의 신뢰성

    // 2. 절대 경로 사용하면 안된다.
    //   => 테스트를 수행하고자 하는 모든 개발자가 workspace 라는 디렉토리를 만들어야 한다.


    @Before
    public void setUp() {
        File logFile = new File("C:\\workspace\\file.log");
        logger = new Logger(logFile);

        // 자바의 파일 API 가 제공하는 플랫폼 독립적인 형태를 사용해야 한다.
        logFile = new File("/workspace/file.log");
        //  Windows => C:\workspace\file.log
        //  Unix    =>  /workspace/file.log

    }

}

// SUT
class Logger {
    private File file;
    Logger(File file) {
        this.file = file;
    }

    //....
}