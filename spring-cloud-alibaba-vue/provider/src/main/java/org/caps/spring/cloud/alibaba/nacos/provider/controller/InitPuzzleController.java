package org.caps.spring.cloud.alibaba.nacos.provider.controller;

import org.caps.spring.cloud.alibaba.nacos.provider.service.InitPuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Caps
 * @date 2019/8/15
 */
@RestController
public class InitPuzzleController {

    @Autowired
    private InitPuzzleService initPuzzleService;

    @GetMapping(value = "init")
    public List initPuzzle() {
        return initPuzzleService.initPuzzle();
    }
}
