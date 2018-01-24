package com.coinsdaq.web.controller;

import com.coinsdaq.web.service.dto.MarketSummaryDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebSocketController {

    @MessageMapping("/marketSummry")
    @SendTo("/topic/marketSummry")
    public List<MarketSummaryDTO> marketSummry(List<MarketSummaryDTO> message) throws Exception {
        System.out.println("marketSummry data sender start!");

        List<MarketSummaryDTO> result = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++ ){
            MarketSummaryDTO ms = new MarketSummaryDTO();
            ms.setMarketName("BTC-KRW");
            ms.setHigh(new BigDecimal(15198000));
            ms.setLow(new BigDecimal(1435200));
            ms.setVolume(new BigDecimal(32706500));
            ms.setLast(new BigDecimal(14790000));
            ms.setBaseVolume(new BigDecimal(482222979));
            ms.setTimeStamp(null);
            ms.setBid(new BigDecimal(1435500));
            ms.setAsk(new BigDecimal(1435300));
            ms.setOpenBuyOrders(15);
            ms.setOpenSellOrders(15);
            ms.setPrevDay(new BigDecimal(15790000));
            ms.setCreated(null);
            ms.setDisplayMarketName("비트코인");
            result.add(ms);
//            {
//                "success" : true,
//                    "message" : "",
//                    "result" : [{
//                "MarketName" : "BTC-888",
//                        "High" : 0.00000919,
//                        "Low" : 0.00000820,
//                        "Volume" : 74339.61396015,
//                        "Last" : 0.00000820,
//                        "BaseVolume" : 0.64966963,
//                        "TimeStamp" : "2014-07-09T07:19:30.15",
//                        "Bid" : 0.00000820,
//                        "Ask" : 0.00000831,
//                        "OpenBuyOrders" : 15,
//                        "OpenSellOrders" : 15,
//                        "PrevDay" : 0.00000821,
//                        "Created" : "2014-03-20T06:00:00",
//                        "DisplayMarketName" : null
//            }, {
//                "MarketName" : "BTC-A3C",
//                        "High" : 0.00000072,
//                        "Low" : 0.00000001,
//                        "Volume" : 166340678.42280999,
//                        "Last" : 0.00000005,
//                        "BaseVolume" : 17.59720424,
//                        "TimeStamp" : "2014-07-09T07:21:40.51",
//                        "Bid" : 0.00000004,
//                        "Ask" : 0.00000005,
//                        "OpenBuyOrders" : 18,
//                        "OpenSellOrders" : 18,
//                        "PrevDay" : 0.00000002,
//                        "Created" : "2014-05-30T07:57:49.637",
//                        "DisplayMarketName" : null
//            }
//    ]

        }
        return result;
//        return message;
    }

    @MessageMapping("/test")
    @SendTo("/topic/test")
    public String test(String message) throws Exception {
        System.out.println("test data sender start!");
        return message;
    }
}
