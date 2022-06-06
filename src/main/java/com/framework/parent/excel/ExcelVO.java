package com.framework.parent.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author luodong
 * @date 2022/6/2
 */
@Data
public class ExcelVO {
    /**
     * 强制读取第三个 这里不建议 index 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配
     */
    @ExcelProperty("字符串")
    private String str;
    /**
     * 用名字去匹配，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
     */
    @ExcelProperty("数量")
    private int num;

    @ExcelProperty("日期")
    private Date date;
}
