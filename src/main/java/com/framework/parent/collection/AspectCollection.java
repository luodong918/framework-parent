package com.framework.parent.collection;

import com.framework.parent.aspect.Log;
import com.framework.parent.common.LogTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author luodong
 * @date 2022/3/23
 */
@Component
public class AspectCollection {

    @Log(type = LogTypeEnum.USER_LOGIN)
    public  void toTestAspect(){
        String str = null;
        str.toString();
        System.out.println("ssss");
    }

}
