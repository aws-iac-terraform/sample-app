package com.example.containersampleapp.presentation.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {

    @Value("${sample.env}")
    private String sampleEnv;

    @GetMapping("/")
    public ModelAndView get(ModelAndView mav) {
    log.info("ログ Access to IndexController / !!");
    log.info(sampleEnv);
    mav.addObject("sampleEnv", sampleEnv);
    mav.setViewName("index");
    return mav;
    }
}
