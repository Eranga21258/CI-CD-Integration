package com.example.demo.contoller;

import com.example.demo.bean.ResponseBean;
import com.example.demo.util.MessageVarList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/ci-cd")
public class CICDTestController {

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBean cicdTest() {
        log.debug("Start to CI/CD test");
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResponse(MessageVarList.RSP_SUCCESS);
        responseBean.setContent("helloabc---------...");
        log.debug("CI/CD test success");
        return responseBean;
    }
}
