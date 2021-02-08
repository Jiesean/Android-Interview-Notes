package com.jiesean.algorithmtrain.helper

import kotlin.random.Random

/**
 * @author Wangjie
 * @description:
 * @date :2021/2/8 5:38 PM
 */
object SortTestHelper {
    //生成n个随机数组成的数组，范围为[rangeL,rangeR)
    fun generateRandomArray(length:Int = 100, rangeL:Int = 0, rangeR:Int = 100):IntArray{
        var arr = IntArray(length){(rangeL until rangeR).random()}
        return arr
    }
}