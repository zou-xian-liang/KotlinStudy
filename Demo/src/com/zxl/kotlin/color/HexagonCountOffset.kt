package com.zxl.kotlin.color

import kotlin.math.pow

/**
 * 由于多次计算精确度影响 使用相对于中心点的坐标系
 */
class HexagonCountOffset(var index: Int, var xOffset: Int, var yOffset: Int, var depth: Int) {
    var add = (xOffset * Test.cos60).pow(2) + (yOffset * Test.sin60).pow(2)
    fun group() = when {
        (xOffset == 0 && yOffset == 0) -> 0
        (yOffset <= 0 && xOffset <= 0) || (yOffset < 0 && xOffset / -yOffset < 1) -> 0
        xOffset > 0 && (yOffset / xOffset > -1 && yOffset / xOffset <= 1) -> 1
        yOffset > 0 && (xOffset < 0 || xOffset / yOffset < 1) -> 2
        else -> 0
    }

    override fun toString(): String {
        return "HexagonCountOffset(index=$index, xOffset=$xOffset, yOffset=$yOffset, depth=$depth, add=$add)"
    }


}


class ColorWithHexInfo(
    val hexInfo: HexagonCountOffset,
    val index: Int
)