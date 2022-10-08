package com.example.containersampleapp.presentation.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiOperation;

@RequestMapping("api/v1/logs")
@RestController
@Slf4j
public class LogOutputController {

    @ApiOperation(value = "traceログを出力します。")
    @GetMapping("/trace")
    @ResponseStatus(HttpStatus.OK)
    public void trace(){
        log.trace("トレースログです");
    }

    @ApiOperation(value = "debugログを出力します。")
    @GetMapping("/debug")
    @ResponseStatus(HttpStatus.OK)
    public void debug(){
        log.debug("デバッグログです");
    }

    @ApiOperation(value = "infoログを出力します。")
    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public void info(){
        log.info("インフォログです");
    }

    @ApiOperation(value = "warnログを出力します。")
    @GetMapping("/warn")
    @ResponseStatus(HttpStatus.OK)
    public void warn(){
        log.warn("わーんログです");
    }

    @ApiOperation(value = "errorログを出力します。")
    @GetMapping("/error")
    @ResponseStatus(HttpStatus.OK)
    public void error(){
        log.error("エラーログです");
    }

    @ApiOperation(value = "Exceptionを発生させます")
    @GetMapping("/exception")
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public void exception() {
        log.error("エラー発生です");
        throw new IllegalArgumentException("例外発生です");
    }
}
