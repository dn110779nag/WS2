/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws2.spring.ws;

/**
 *
 * @author user
 */
public class WsMessage {
    private String data;
    private long interval;

    public WsMessage(String data, long interval) {
        this.data = data;
        this.interval = interval;
    }

    public String getData() {
        return data;
    }

    public long getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return "WsMessage{" + "data=" + data + ", interval=" + interval + '}';
    }
    
    
}
