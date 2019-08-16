package org.caps.spring.cloud.alibaba.controller;

import org.caps.spring.cloud.alibaba.service.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Caps
 * @date 2019/8/15
 */
@RestController
public class ClickController {

    @Autowired
    private ClickService clickService;

    @PostMapping("/move")
    public List resetPuzzle(@RequestParam String index, @RequestParam List puzzles){
        List list = clickService.play(puzzles,index);
        return list;
    }
}
