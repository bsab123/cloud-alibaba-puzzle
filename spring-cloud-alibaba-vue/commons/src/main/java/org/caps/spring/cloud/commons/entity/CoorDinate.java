package org.caps.spring.cloud.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CoorDinate{
    private Integer curIndex;
    private Integer leftIndex;
    private Integer rightIndex;
    private Integer topIndex;
    private Integer bottomIndex;
    private List puzzles;
}
