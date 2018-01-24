package com.coinsdaq.web.controller;

import com.coinsdaq.web.service.ExchangeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("exchangeController")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @RequestMapping("/exchangeView")
    public String getExchangeView() {
        return "exchange";
    }

    @RequestMapping("/getTradingInfoData")
    public @ResponseBody  String getTradingInfoData() {
        Gson gson = new Gson();
        return gson.toJson(exchangeService.getTradingInfo());
    }



    @RequestMapping("/gridView")
    public String getGrid() {
        System.out.println("get grid");
        return "grid";
    }

    @RequestMapping("/testView")
    public String gettest() {
        System.out.println("get test");
        return "test";
    }
}
