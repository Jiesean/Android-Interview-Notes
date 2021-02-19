package com.jiesean.algorithmtrain.helper

import android.util.Log
import java.util.*
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

    //生成n个接近有序的随机数组，随机times次
    fun generateNearlySortedRandomArray(length:Int = 100, rangeL:Int = 0, rangeR:Int = 100, times:Int = 10):IntArray{
        var arr = IntArray(length)
        for(i in 0 until length){
            arr[i] = i
        }

        for(j in 0..times){
            var moveX = (0..length).random()
            var moveY = (0..length).random()
            var temp = arr[moveX]
            arr[moveX] = arr[moveY]
            arr[moveY] = temp

        }

        Log.e(javaClass.simpleName,"生成的接近有序的数组，是有序的吗 = ${isSorted(arr)}")

        return arr
    }

    //测试各种排序函数的性能
    fun sortAnalysis(sortName:String,sort:() -> IntArray){
        Log.d(javaClass.simpleName,"${sortName} start")
        var startTime = System.currentTimeMillis()
        var resultArrags= sort()
        var costTime = System.currentTimeMillis() - startTime

        Log.d(javaClass.simpleName,"${sortName} end , isSorted = ${isSorted(resultArrags)},cost = ${costTime} ms")
//        Log.d(javaClass.simpleName,"${sortName} end , result = ${Arrays.toString(resultArrags)}")
    }

    //判断数组是否是从小到大有序的
    fun isSorted(sortResult:IntArray):Boolean{
        // i+1 <= sortResult.size - 1
        // i <= sortResult.size - 2
        for (i in 0..(sortResult.size-2)){
            if (sortResult[i] > sortResult[i+1]){
                return false
            }
        }
        return true
    }
}