package com.framework.parent.excel;

import com.framework.parent.util.excel.ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * @author luodong
 * @date 2022/6/2
 */
public class ExcelWriteDemo {
    private static final String EXCEL_PATH = "/Users/luodong/Desktop/excelInput.xlsx";

    public static void main(String[] args) throws  Exception{
        ArrayList<ExcelVO> excelVOList = new ArrayList<>();

        ExcelUtil.read(new FileInputStream(new File(EXCEL_PATH)), ExcelVO.class,
            excelVo -> excelVOList.addAll(excelVo)).sheet().headRowNumber(2).doRead();

        for (ExcelVO excelVO : excelVOList) {
            System.out.println(excelVO.toString());
        }
    }
}
