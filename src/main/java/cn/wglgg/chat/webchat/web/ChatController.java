/*
* Copyright 2017 Zhongan.io All right reserved. This software is the
* confidential and proprietary information of Zhongan.io ("Confidential
* Information"). You shall not disclose such Confidential Information and shall
* use it only in accordance with the terms of the license agreement you entered
* into with Zhongan.io.
*/
package cn.wglgg.chat.webchat.web;

import cn.wglgg.chat.webchat.service.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类ChatController的实现描述：TODO 类实现描述
 *
 * @author za-wanggang 2017/5/19 17:38
 */
@Controller
public class ChatController {

    @Autowired
    private MsgProducer msgProducer;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping(value = "/sendMsg",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String sendMsg(String msg){
        msgProducer.send(msg);
        return "{\"code\":0,\"msg\":\"send success\"}";
    }
}
