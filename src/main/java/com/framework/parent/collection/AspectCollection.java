package com.framework.parent.collection;

import com.framework.parent.aspect.Log;
import com.framework.parent.common.LogTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luodong
 * @date 2022/3/23
 */
@Slf4j
@RestController
@RequestMapping(value = "/plume_log")
@Api(tags = "plumelog日志测试", value = "plumelog日志测试")
public class AspectCollection {


//    @Log(type = LogTypeEnum.USER_LOGIN)
    @PostMapping("/success")
    @ApiOperation(value = "plume_log:success")
    public void plumeLogSuccess() {
        log.info("plumelog请求成功");
    }


//    @Log(type = LogTypeEnum.USER_LOGIN)
    @PostMapping("/exception")
    @ApiOperation(value = "plume_log:exception")
    public void plumeLogException() {
        String str = null;
        try {
            str.toString();

        } catch (Exception e) {
            log.error(e.toString());
        }
    }

}
