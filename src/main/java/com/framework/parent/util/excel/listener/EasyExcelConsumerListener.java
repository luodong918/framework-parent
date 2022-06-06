package com.framework.parent.util.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.util.ConverterUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class EasyExcelConsumerListener<T> extends AnalysisEventListener<T> {
    private int batchSize;
    private List<T> list;
    private Map<Integer, CellData> headMap;
    private Consumer<List<T>> consumer;

    public EasyExcelConsumerListener(int batchSize, Consumer<List<T>> consumer) {
        this.batchSize = batchSize;
        this.consumer = consumer;
        list = new ArrayList<>(batchSize);
    }

    @Override
    public void invoke(T data, AnalysisContext analysisContext) {
        list.add(data);
        if (list.size() >= batchSize) {
            consumer.accept(list);
            list.clear();
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        consumer.accept(list);
        log.info("success");
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) {
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException) exception;
                    excelDataConvertException.getColumnIndex();
        }
    }

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        log.info("表头数据:{}",JSON.toJSONString(headMap));
    }
}
