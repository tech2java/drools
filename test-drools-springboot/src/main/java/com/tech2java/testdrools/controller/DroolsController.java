package com.tech2java.testdrools.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroolsController {

    @Autowired
    private KieSession kieSession;

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order){
        System.out.println("Inside createOrder");
        kieSession.insert(order);
        kieSession.fireAllRules();
        return order;
    }

}
