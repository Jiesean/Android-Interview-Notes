package com.jiesean.algorithmtrain.bst

/**
 * @author Wangjie
 * @description:
 * @date :2021/2/27 11:11 AM
 */
object BinarySearch {

    //使用迭代的方法实现二分查找
    //二分查找的前提是给定的数组为有序的
    fun testBinarySearch1(array: IntArray,target:Int):Int{
        //在[l,r]区间中查找目标元素target

        var l = 0
        var r = array.size - 1
        while (r >= l){
            var mid = (l + r) /2

            if(array[mid] == target){
                return mid
            }

            if(array[mid] > target){
                r = mid - 1
            }
            else {
                l = mid + 1
            }
        }

        return -1
    }

}