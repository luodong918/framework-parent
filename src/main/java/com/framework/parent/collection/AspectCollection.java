package com.framework.parent.collection;

import com.framework.parent.aspect.Log;
import com.framework.parent.common.LogTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luodong
 * @date 2022/3/23
 */
@Slf4j
@RestController
@RequestMapping(value = "/ecp/authorize")
@Api(value = "plumelog日志测试")
public class AspectCollection {

    @Log(type = LogTypeEnum.USER_LOGIN)
    public  void toTestAspect(){
        String str = null;
        str.toString();
        System.out.println("ssss");
    }

    @Log(type = LogTypeEnum.USER_LOGIN)
    @PostMapping("/code")
    @ApiOperation(value = "网页授权获取code：获取平台页面链接")
    public void plumelogInsert(){
        log.info("plumelog请求成功");
    }
}
