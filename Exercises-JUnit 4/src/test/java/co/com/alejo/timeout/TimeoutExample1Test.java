package co.com.alejo.timeout;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TimeoutExample1Test {

    //This test will always failed
    @Test(timeout = 1000)
    public void infinity() {
        while (true) ;
    }

    //This test can't run more than 5 seconds, else failed
    @Test(timeout = 5000)
    public void testSlowMethod() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
    }

}
