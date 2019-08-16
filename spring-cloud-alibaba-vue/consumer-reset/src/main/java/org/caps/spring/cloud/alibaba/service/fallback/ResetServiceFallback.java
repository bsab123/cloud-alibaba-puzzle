package org.caps.spring.cloud.alibaba.service.fallback;

import org.caps.spring.cloud.alibaba.service.ResetService;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Caps
 * @date 2019/8/15
 */
@Component
public class ResetServiceFallback implements ResetService {
    @Override
    public List initPuzzle() {
        return Arrays.asList("500");
    }
}
