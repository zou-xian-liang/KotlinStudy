package com.zxl.kotlin.color

import java.util.*
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

class Test {

    val TAG = "TEST"

    companion object {
        val TAG = "TEST"
        val sin60 = sin(60.0 / 180 * Math.PI)
        val cos60 = cos(60.0 / 180 * Math.PI)

        @JvmStatic
        fun main(args: Array<String>) {
            val hexData = Test().initHexagon()
//            print(hexData)
            val hData = hexData.values.sortedBy {
//                    Log.e1(TAG, "${(it.xOffset * cos60).pow(2) + (it.yOffset * sin60).pow(2)}")
                //按该点到原点的距离进行排序
                (it.xOffset * cos60).pow(2) + (it.yOffset * sin60).pow(2)
            }
                .groupBy { it.group() }//group()返回值相等的分为一组


            hData.forEach {
                Log.eOneLine1(TAG, "${it.key}=")
                it.value.forEach {
                    Log.eOneLine1(TAG, "[x=${it.xOffset} y=${it.yOffset} deep=${it.depth}] ")
                }
                println()
            }

        }
    }


    private fun initHexagon(): SortedMap<Int, HexagonCountOffset> {
        val hexOffsetMap = sortedMapOf<Int, HexagonCountOffset>()
        hexOffsetMap[0] = HexagonCountOffset(0, 0, 0, 0)
        var count = 0
        for ((currentDepth, i) in (0 until 2).withIndex()) {
            hexOffsetMap.filter { currentDepth == it.value.depth }
                .forEach {
                    Log.e(TAG, "initHexagon: 第" + i + "次循环---currentDepth=" + currentDepth + "---it.value.depth=" + it.value.depth)
                    val centerData: HexagonCountOffset = it.value
                    Log.e(TAG, "第${i}层中心点信息=[x=${it.value.xOffset} y=${it.value.yOffset} deep=${it.value.depth}]")
                    val d1x = (centerData.xOffset - 3)
                    val d2x = (centerData.xOffset)
                    val d3x = (centerData.xOffset + 3)
                    val d4x = (centerData.xOffset + 3)
                    val d5x = (centerData.xOffset)
                    val d6x = (centerData.xOffset - 3)


                    val d1y = (centerData.yOffset - 1)
                    val d2y = (centerData.yOffset - 2)
                    val d3y = (centerData.yOffset - 1)
                    val d4y = (centerData.yOffset + 1)
                    val d5y = (centerData.yOffset + 2)
                    val d6y = (centerData.yOffset + 1)

                    Log.e(TAG, "x=${it.value.xOffset}---d1x=$d1x---d2x=$d2x---d3x=$d3x---d4x=$d4x---d5x=$d5x---d6x=$d6x")
                    Log.e(TAG, "y=${it.value.yOffset}---d1y=$d1y---d2y=$d2y---d3y=$d3y---d4y=$d4y---d5y=$d5y---d6y=$d6y")
                    //none：如果集合中没有符合要求的给定元素，则返回true，进入{}
                    if (hexOffsetMap.none { i -> i.value.xOffset == d1x && i.value.yOffset == d1y }) {
                        count++
                        Log.eOneLine(TAG, "d1=[x=$d1x y=$d1y]     ")
                        hexOffsetMap[count] = HexagonCountOffset(count, d1x, d1y, depth = currentDepth + 1)
                    }

//                Log.eOneLine(TAG,"第一次之后${hexOffsetMap.size}     ")
                    if (hexOffsetMap.none { i -> i.value.xOffset == d2x && i.value.yOffset == d2y }) {
                        count++
                        Log.eOneLine(TAG, "d2=[x=$d2x y=$d2y]   ")
                        hexOffsetMap[count] = HexagonCountOffset(count, d2x, d2y, depth = currentDepth + 1)
                    }

                    if (hexOffsetMap.none { i -> i.value.xOffset == d3x && i.value.yOffset == d3y }) {
                        count++
                        Log.eOneLine(TAG, "d3=[x=$d3x y=$d3y]     ")
                        hexOffsetMap[count] = HexagonCountOffset(count, d3x, d3y, depth = currentDepth + 1)
                    }

                    if (hexOffsetMap.none { i -> i.value.xOffset == d4x && i.value.yOffset == d4y }) {
                        count++
                        Log.eOneLine(TAG, "d4=[x=$d4x y=$d4y]     ")
                        hexOffsetMap[count] = HexagonCountOffset(count, d4x, d4y, depth = currentDepth + 1)
                    }

                    if (hexOffsetMap.none { i -> i.value.xOffset == d5x && i.value.yOffset == d5y }) {
                        count++
                        Log.eOneLine(TAG, "d5=[x=$d5x y=$d5y]     ")
                        hexOffsetMap[count] = HexagonCountOffset(count, d5x, d5y, depth = currentDepth + 1)
                    }

                    if (hexOffsetMap.none { i -> i.value.xOffset == d6x && i.value.yOffset == d6y }) {
                        count++
                        Log.eOneLine(TAG, "d6=[x=$d6x y=$d6y]     ")
                        hexOffsetMap[count] = HexagonCountOffset(count, d6x, d6y, depth = currentDepth + 1)
                    }
//                    println()
//                    println("此轮结束大小${hexOffsetMap.size}")
                    for (index in hexOffsetMap.keys) {
                        Log.eOneLine(TAG, "$index-[x=${hexOffsetMap[index]!!.xOffset} y=${hexOffsetMap[index]!!.yOffset} deep=${hexOffsetMap[index]!!.depth}]     ")
                    }
                    hexOffsetMap.forEach {
//                    Log.eOneLine(TAG, "${it.key}-[x=${it.value.xOffset} y=${it.value.yOffset} deep=${it.value.depth}]     " )
                    }

//                    println()
//                    println()
//                Log.e(TAG, "initHexagon: 第$i 次-----集合元素个数${hexOffsetMap.size}" )
                }
        }
//        Log.e(TAG, "initHexagon: ${hexOffsetMap.size}" )

        return hexOffsetMap
    }
}