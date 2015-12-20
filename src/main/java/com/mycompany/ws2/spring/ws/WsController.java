/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws2.spring.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

/**
 *
 * @author user
 */
@Controller
public class WsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private int counter = 0;
    
    @SubscribeMapping("/test")
    @SendTo("/topic/msg")
    public WsMessage recieveMessage(WsMessage msg){
        logger.info("data size="+msg.getData().length()+"; counter="+(++counter));
        if(msg.getInterval()>0){
            logger.info("pause="+msg.getInterval());
            try {
                Thread.sleep(msg.getInterval());
            } catch (InterruptedException ex) {
                logger.error("", ex);
            }
        }
        return msg;
    }
    
    @SubscribeMapping("/msg")
    public WsMessage sendMessage(){
        return new WsMessage("hello from app", 1);
    }
    
}
