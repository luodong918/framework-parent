package com.framework.parent.rabbit.autoAck;


import com.alibaba.fastjson.JSON;
import com.framework.parent.util.RabbitMqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 消费者
 * @author luodong
 * @date 2022/5/13
 */
public class AutoConsumer {

    public static  final String QUEUE_NAME= "hello";

    public static void main(String[] args) throws IOException {
        ArrayList<Traces> traces = new ArrayList<>();
        Traces t1 = new Traces();
        t1.setAction("1");
        t1.setAcceptStation("1111");

        Traces t2 = new Traces();
        t2.setAction("1");
        t2.setAcceptStation("1111");

        traces.add(t1);
        traces.add(t2);
        traces.stream().filter(v -> v.getAction().equals("301")).forEach(v->v.setAcceptStation("本人已签收"));

        for (Traces trace : traces) {
            System.out.println(JSON.toJSONString(trace));
        }


        Channel channel = RabbitMqUtils.getChannel();


        /**
         * String queue, boolean autoAck, String consumerTag, boolean noLocal, boolean exclusive, Map<String, Object> arguments, Consumer callback
         *
         * queue 消费的那个队列
         * autoAck 是否自动确认消息,true自动确认,false 不自动要手动调用,建立设置为false
         * consumerTag 消费者标签，用来区分多个消费者
         * noLocal 设置为true，表示 不能将同一个Conenction中生产者发送的消息传递给这个Connection中 的消费者
         * exclusive 是否排他
         * arguments 消费者的参数
         * callback 消费者 DefaultConsumer建立使用，重写其中的方法
         *     handleConsumeOk(String var1);
         *     handleCancelOk(String var1); 方法会在其它方法之前调用，返回消费者标签
         *     handleCancel(String var1) throws IOException;
         *     handleShutdownSignal(String var1, ShutdownSignalException var2);   当Channel与Conenction关闭的时候会调用
         *     handleRecoverOk(String var1);
         *     handleDelivery(String var1, Envelope var2, BasicProperties var3, byte[] var4) throws IOException;
         */
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收消息 :   " + new String(body));
            }
        };

        channel.basicConsume(QUEUE_NAME,false,defaultConsumer);
    }

    static class Traces  {
        private static final long serialVersionUID = 1L;
        @ApiModelProperty("轨迹发生时间")
        private String acceptTime;
        @ApiModelProperty("轨迹描述")
        private String acceptStation;
        @ApiModelProperty("当前城市")
        private String location;
        @ApiModelProperty("增值物流状态")
        private String action;
        @ApiModelProperty("备注")
        private String remark;

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        public String getAcceptTime() {
            return acceptTime;
        }

        public void setAcceptTime(String acceptTime) {
            this.acceptTime = acceptTime;
        }

        public String getAcceptStation() {
            return acceptStation;
        }

        public void setAcceptStation(String acceptStation) {
            this.acceptStation = acceptStation;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
