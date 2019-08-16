package org.caps.spring.cloud.alibaba.service;

import org.caps.spring.cloud.alibaba.service.fallback.ResetServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @author Caps
 * @date 2019/8/15
 */
@FeignClient(value = "puzzle-provider",fallback = ResetServiceFallback.class)
public interface ResetService {
    @GetMapping(value = "init")
    List initPuzzle();
}
