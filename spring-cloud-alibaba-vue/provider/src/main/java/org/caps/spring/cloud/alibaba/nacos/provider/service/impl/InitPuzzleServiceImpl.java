package org.caps.spring.cloud.alibaba.nacos.provider.service.impl;

import org.caps.spring.cloud.alibaba.nacos.provider.service.InitPuzzleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


/**
 * @author Caps
 * @date 2019/8/15
 */
@Service
public class InitPuzzleServiceImpl implements InitPuzzleService {
    @Override
    public List initPuzzle() {
        List list= Arrays.asList("1", "2", "3","4","5","6","7","8","0");
        return list;
    }
}
