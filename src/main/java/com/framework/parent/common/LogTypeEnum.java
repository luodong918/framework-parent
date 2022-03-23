package com.framework.parent.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author luodong
 * @date 2022/3/23
 */
@Getter
@AllArgsConstructor
public enum LogTypeEnum {
    USER_LOGIN("10", "登录");

    private String key;
    private String value;
}
