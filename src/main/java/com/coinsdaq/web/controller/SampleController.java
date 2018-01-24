package com.coinsdaq.web.controller;

import com.coinsdaq.web.service.MailSendService;
import com.coinsdaq.web.service.UserService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@Controller
public class SampleController {

    @Autowired
    private MailSendService service;

    @GetMapping("/")
    @ResponseBody
    public Publisher<String> handler() {
        service.sendMail("kimgoon2@nate.com");

        return Mono.just("Hello world!");
    }

    @GetMapping("/ftl")
    public String index() {
        return "index";
    }
}

