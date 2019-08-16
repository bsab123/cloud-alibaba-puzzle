package org.caps.spring.cloud.alibaba.service.impl

import org.caps.spring.cloud.alibaba.service.ClickService
import org.caps.spring.cloud.commons.entity.CoorDinate
import org.springframework.stereotype.Service

/**
 * @author Caps
 * @date 2019/8/16
 */
@Service
class ClickServiceImpl implements ClickService {
    
    List play(List puzzles, String index) {
        int i = Integer.parseInt(index)
        int curIndex = Integer.parseInt(puzzles.get(i).toString())
        //获取坐标
        CoorDinate coorDinate = getCoorDinate(i, new CoorDinate(curIndex, -1, -1, -1, -1, puzzles))
        //移动
        CoorDinate finallyCoorDinate = move(i, coorDinate)
        return finallyCoorDinate.getPuzzles()
    }

    /**
     * 获取坐标
     * @param i
     * @param coorDinate
     */
    private static CoorDinate getCoorDinate(int i, CoorDinate coorDinate) {
        if(i>0){
            coorDinate.setLeftIndex(Integer.parseInt(coorDinate.getPuzzles().get(i-1).toString()))
        }
        if(i<8){
            coorDinate.setRightIndex(Integer.parseInt(coorDinate.getPuzzles().get(i+1).toString()))
        }
        if(i>2){
            coorDinate.setTopIndex(Integer.parseInt(coorDinate.getPuzzles().get(i-3).toString()))
        }
        if(i<6){
            coorDinate.setBottomIndex(Integer.parseInt(coorDinate.getPuzzles().get(i+3).toString()))
        }
        return coorDinate
    }

    /**
     * 移动
     * @param i
     * @param coorDinate
     * @return
     */
    private static CoorDinate move(int i, CoorDinate coorDinate){
        if (coorDinate.getLeftIndex() == 0 && 0!=i % 3 ) {
            coorDinate.getPuzzles().set(i-1,coorDinate.getCurIndex())
            coorDinate.getPuzzles().set(i,0)
        } else if (coorDinate.getRightIndex() == 0 && 2 != i % 3 ) {
            coorDinate.getPuzzles().set(i+1,coorDinate.getCurIndex())
            coorDinate.getPuzzles().set(i,0)
        } else if (coorDinate.getTopIndex() == 0 ) {
            coorDinate.getPuzzles().set(i-3,coorDinate.getCurIndex())
            coorDinate.getPuzzles().set(i,0)
        } else if (coorDinate.getBottomIndex() == 0 ) {
            coorDinate.getPuzzles().set(i+3,coorDinate.getCurIndex())
            coorDinate.getPuzzles().set(i,0)
        }
        return coorDinate
    }
}
