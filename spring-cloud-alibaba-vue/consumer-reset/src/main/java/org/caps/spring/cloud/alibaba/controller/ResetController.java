package org.caps.spring.cloud.alibaba.controller;

import org.caps.spring.cloud.alibaba.service.ResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Caps
 * @date 2019/8/15
 */
@RestController
public class ResetController {

    @Autowired
    private ResetService resetService;

    @GetMapping("/reset")
    public List resetPuzzle(){
        List list = resetService.initPuzzle();
        Collections.shuffle(list);
        return list;
    }
}
