package com.neo;

import com.neo.entities.NginxStatus;
import com.neo.services.NginxStatusService;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComposeApplicationTests {
    NginxStatusService nginxStatusService;
    private NginxStatus nginxStatus;

    @Before
    public void initService() {
        nginxStatusService = new NginxStatusService();
    }

    @Test
    public void statusShouldBeNotNull() {
        nginxStatus = nginxStatusService.getStatus("1 2 3 4 5 6 7 8 9 10");
        Assume.assumeNotNull(nginxStatus);
    }

    @Test
    public void statusShouldBeThrowException() {
        nginxStatus = nginxStatusService.getStatus("a b c d e f g h i j");

    }


}
