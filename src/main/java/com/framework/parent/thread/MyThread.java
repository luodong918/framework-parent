package com.framework.parent.thread;

import java.math.BigDecimal;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

/**
 * @author luodong
 * @date 2022/4/20
 */
public class MyThread {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
//
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.execute();
//        long nextValue =100000;
//         String code = String.format("ETS%d", nextValue);
//        System.out.println(code);
//        BigDecimal bigDecimal = new BigDecimal(0.60);
//        BigDecimal bigDecimal1 = new BigDecimal(3);
//        BigDecimal divide = bigDecimal.divide(bigDecimal1,2,BigDecimal.ROUND_HALF_UP);
//        System.out.println(divide);
//        float ceil = (float)Math.ceil(bigDecimal / bigDecimal1);
//        System.out.println(ceil);
//       new Lock();
        BigDecimal dividend = new BigDecimal(3);
        BigDecimal divisor = new BigDecimal(1.00);
        float everyDivided = divisor.divide(dividend, 2, BigDecimal.ROUND_HALF_UP).floatValue();
        System.out.println(everyDivided);
    }
}
