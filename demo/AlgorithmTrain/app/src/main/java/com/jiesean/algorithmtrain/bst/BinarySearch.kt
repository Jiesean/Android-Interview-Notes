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
            // 在求解mid的过程中，使用l + r 可能会造成整形溢出问题，需要改为减法
            // var mid = (l + r) /2
            //此处注意使用移位操作符的时候，需要使用括号，因为其优先级最低
            var mid = l + ((r - l) shr 1)

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