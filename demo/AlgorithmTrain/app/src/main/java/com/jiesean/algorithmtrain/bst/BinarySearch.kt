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


    //使用递归的方式实现二分查找
    //二分查找的前提是给定的数组为有序的
    fun testBinarySearch2(array: IntArray,target: Int):Int{
        var index = search(array,0, array.size -1,target )
        return index
    }

    //在[l,r]中查找target元素
    private fun search(array: IntArray,l:Int,r:Int,target: Int):Int {
        var mid = l + ((r - l) shr 1)

        if(l>r){
            return -1
        }

        if (array[mid] == target) {
            return mid
        }
        if (array[mid] > target) {
            return search(array, l, mid - 1, target)
        } else {
            return search(array, mid + 1, r, target)
        }

    }

    //求有序序列中最前面的target
    fun floor(array: IntArray,target: Int):Int{
        var index = testBinarySearch1(array,target)
        if(index == -1 ){
            return index
        }else{
            var floor = index
            while (floor >= 0){
                if( floor == 0 || array[floor] > array[floor -1]){
                    return  floor
                }else if(array[floor] == array[floor -1]){
                    floor --
                }
            }
            return floor
        }
    }

    //求有序序列中最后面的target
    fun ceil(array:IntArray,target: Int):Int{
        var index = testBinarySearch1(array,target)
        if(index == -1 ){
            return index
        }else{
            var ceil = index
            while (ceil <= array.size -1){
                if( ceil == array.size -1 || array[ceil] < array[ceil + 1]){
                    return  ceil
                }else if(array[ceil] == array[ceil +1]){
                    ceil ++
                }
            }
            return ceil
        }
    }
}