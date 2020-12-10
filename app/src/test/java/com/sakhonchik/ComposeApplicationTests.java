package com.sakhonchik;

import com.sakhonchik.entities.NginxStatus;
import com.sakhonchik.services.NginxStatusService;
import com.sakhonchik.services.ResponseService;
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
    ResponseService responseService;
    NginxStatusService nginxStatusService;

    @Before
    public void initService() {
        nginxStatusService = new NginxStatusService();
        responseService = new ResponseService();
    }

    @Test
    public void statusShouldBeNotNull() {
        NginxStatus nginxStatus = nginxStatusService.getStatus("1 2 3 4 5 6 7 8 9 10");
        Assume.assumeNotNull(nginxStatus);
    }

    @Test
    public void responseShouldBeNotNull() {
        String response = responseService.getResponseBodyFromNginx();
        Assert.assertNotNull(response);

    }

    @Test
    public void responseShouldByEmpty() {
        String expected = "";
        String actual = responseService.getResponseBodyFromNginx();
        Assert.assertEquals(expected, actual);
    }


}
