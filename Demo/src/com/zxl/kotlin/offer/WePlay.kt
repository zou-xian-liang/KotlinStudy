package com.zxl.kotlin.offer

object WePlay {
    @JvmStatic
    fun main(args: Array<String>) {
        /**
         * 验证回文串
         */
        val reverseStr = "A man, a plan, a canal: Panama"
        println(huiWen(reverseStr))
        println(huiWenSecond(reverseStr))

        /**
         * 最大子序和
         */
        maxSubset(intArrayOf(2, 1, -3, 4, -1, 2, 1, -5, 4))

        /**
         * 查找多数元素
         */
        maxElement(intArrayOf(2, 2, 1, 1, 1, 2, 2))
    }


    /**----------------验证回文串---------------start-------------------*/
    /**
     * 方法一：
     * 1、去除除数字及字母以外的字符串，并将该字符串全部小写
     * 2、将去除非法字符串后的字符串反转
     * 3、比较两个字符串是否相等
     * @param str 待检测的字符串
     */
    private fun huiWen(str: String): Boolean {
        val wipeStr = str.replace("[^0-9a-zA-Z]+".toRegex(), "").toLowerCase()
        return wipeStr == wipeStr.reversed()
    }

    /**
     * 方法二：
     * 1、去除除数字及字母以外的字符串，并将该字符串全部小写
     * 2、将字符串分成两部分，首位字符进行逐个对比，所有都相等，说明是回文字符串
     * @param str 待检测的字符串
     */
    private fun huiWenSecond(str: String): Boolean {
        val wipeStr = str.replace("[^0-9a-zA-Z]+".toRegex(), "").toLowerCase()
        if (wipeStr.isEmpty()) return true
        else {
            for (i in 0 until wipeStr.length / 2) {
                if (wipeStr[i] != wipeStr[wipeStr.length - 1 - i]) return false
            }
            return true
        }
    }
    /**----------------验证回文串---------------end-------------------*/


    /**----------------最大子序和---------------start-------------------*/
    /**
     * 求取最大子序和
     * 1、根据数组长度为0,1进行单独处理
     * 2、定义一个临时的最大子序和来记录最大的子序的总和
     * 3、定义一个开始索引，和结束索引，分别记录最大子序的起始索引和结束索引
     * 4、获取到开始索引和结束索引后就可以获取到最终最大子序在原数组中的位置
     * @param array 原始数组
     */
    private fun maxSubset(array: IntArray) {
        when (array.size) {
            0 -> println("数组中没有元素")
            1 -> println("数组长度为1：${array.contentToString()}；最大子序和即为${array[0]}")
            else -> {
                /**
                 * 将最大值定义为Long，增加数值范围，防止多个Int值相加超过Int取值范围，导致结果异常
                 */
                var maxCount: Long = Int.MIN_VALUE.toLong()
                var startIndex = 0
                var endIndex = 0
                for (i in array.indices) {
                    var tempCount: Long = array[i].toLong()
                    for (j in i until array.size) {
                        //当i=j时，开始元素值会被重复计算，需要判断
                        if (i != j) tempCount += array[j]
                        //最大子序可能存在多个，这里获取最后一个符合要求的
                        if (tempCount >= maxCount) {
                            maxCount = tempCount
                            startIndex = i
                            endIndex = j
                        }
                    }
                }
                println("原始数组为：${array.contentToString()}")
                println("最大子序数组为：${array.sliceArray(startIndex..endIndex).contentToString()}")
                println("最大子序和为：$maxCount")
            }
        }
    }

    /**----------------最大子序和---------------end-------------------*/


    /**----------------多数元素---------------start-------------------*/

    /**
     * 获取数组中出现次数最多的元素
     *
     * 1、定义一个map用来存放元素，及元素出现的次数
     * 2、获取map的Entry集合list
     * 3、按entry中value的值对list进行排序
     * 4、list集合的首个元素即为出现次数最多的元素，分别获取对应的key和value即可知道对应元素以及出现的次数
     */
    private fun maxElement(array: IntArray) {
        val map = mutableMapOf<Int, Int>()
        array.forEach { if (map.containsKey(it)) map[it] = map[it]!!.plus(1) else map[it] = 1 }
        val list: List<Map.Entry<Int, Int>> = map.entries.toMutableList()
        list.sortedBy { it.value }
        println("数组=${array.contentToString()}出现多的元素为=${list[0].key}；出现次数为=${list[0].value}次")
    }
    /**----------------多数元素---------------end-------------------*/

}