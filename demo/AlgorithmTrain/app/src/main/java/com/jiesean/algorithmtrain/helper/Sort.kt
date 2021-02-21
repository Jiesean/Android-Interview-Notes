package com.jiesean.algorithmtrain.helper

/**
 * @author Wangjie
 * @description:
 * @date :2021/2/20 6:28 PM
 */
object Sort {

    // 选择排序
    fun testSelectSort(num:IntArray):IntArray{
        var preprareArray: IntArray = num.clone()
//        Log.d(localClassName,"数组排序前 ${Arrays.toString(preprareArray)}")

        for (i in 0 until preprareArray.size){

            for(j in i until preprareArray.size){
                if(preprareArray[i] > preprareArray[j]){
                    var temp = preprareArray[i]
                    preprareArray[i] = preprareArray[j]
                    preprareArray[j] = temp
                }

            }
//            Log.d(localClassName,"数组第${i+1}次 ${Arrays.toString(preprareArray)}")
        }
        return preprareArray
    }

    // 泛型 选择排序
    fun <T> testGenericsSelectSort(array:Array<T>):Array<T>{
        var preprareArray: Array<T> = array.clone()
//        Log.d(localClassName,"数组排序前 ${Arrays.toString(preprareArray)}")

        for (i in 0 until preprareArray.size){

            for(j in i until preprareArray.size){
//                if(preprareArray[i] > preprareArray[j]){
//                    var temp = preprareArray[i]
//                    preprareArray[i] = preprareArray[j]
//                    preprareArray[j] = temp
//                }

            }
//            Log.d(localClassName,"数组第${i+1}次 ${Arrays.toString(preprareArray)}")
        }
        return preprareArray
    }

    // 插入排序
    fun testInsertionSort(num:IntArray):IntArray{
        var preprareArray: IntArray = num.clone()
//        Log.d(localClassName,"数组排序前 ${Arrays.toString(preprareArray)}")

        //实现1：找到应该插入的位置，将该位置到i位置的元素往后移动一位，然后将i放在应该插入的位置
        /*
        var temp: Int = 0
        for (i in 1 until preprareArray.size){
            //遍历每个元素，将每个元素插入到前面排好序的位置
            for (j in 0..i-1 ){
                if(preprareArray[j] > preprareArray[i]){
                    temp = preprareArray[i]
                    for(z in (i-1)..j){
                        preprareArray[z+1] = preprareArray[z]
                    }

                }
            }

        }
         */

        //实现2：
        //i位置元素和前一个对比，比前一个大则不移动，否则交换，直到交换到合适的位置
        /*
        for(i in 1 until preprareArray.size){
            for(j in i downTo 1){
                if(preprareArray[j] < preprareArray[j - 1]) {
                    //交换
                    var temp = preprareArray[j]
                    preprareArray[j] = preprareArray[j - 1]
                    preprareArray[j - 1] = temp
                }else break
            }
        }
         */

        //实现3:
        //每次swap操作需要三次copy, 优化为每次只需要一次copy
        for(i in 1 until preprareArray.size){
            var temp = preprareArray[i]
            for(j in i downTo 1){
                if(preprareArray[j - 1] > temp) {
                    preprareArray[j] = preprareArray[j -1]
                }else {
                    preprareArray[j] = temp
                    break
                }
            }
        }
        return preprareArray
    }

    // 冒泡排序
    fun testBubbleSort(num:IntArray):IntArray{
        var preprareArray: IntArray = num.clone()
//        Log.d(localClassName,"数组排序前 ${Arrays.toString(preprareArray)}")

        var isNoSwap = true
        for (i in (preprareArray.size-2) downTo 1){
            for(j in 0..i){
                if (preprareArray[j] > preprareArray[j + 1]){
                    var temp = preprareArray[j]
                    preprareArray[j] = preprareArray[j + 1]
                    preprareArray[j + 1] = temp
                    isNoSwap = false
                }
            }
            //如果某次冒泡没有进行任何的数据交换，说明其后元素已经有序，则可以直接跳出不需要继续进行冒泡
            if(isNoSwap){
                break
            }
//            Log.d(localClassName,"数组第${i+1}次 ${Arrays.toString(preprareArray)}")
        }
        return preprareArray
    }

    //希尔排序
    fun testShellSort(num:IntArray):IntArray{
        var preprareArray: IntArray = num.clone()
//        Log.d(localClassName,"数组排序前 ${Arrays.toString(preprareArray)}")

        var gap = preprareArray.size/2
        while(gap >= 1){
            for(i in gap..(preprareArray.size-1)){
                var temp = preprareArray[i]
                var j = i - gap
                while(j>= 0 && preprareArray[j] > temp){
                    preprareArray[j + gap] = preprareArray[j]
                    j= j - gap
                }
                preprareArray[j + gap] = temp
            }

            gap = gap /2
//            Log.e(localClassName,"testShellSort gap = ${gap}")
        }

        return preprareArray

    }

    //测试归并排序
    fun testMergeSort(num:IntArray):IntArray{
        var prepareArray:IntArray = num.clone()

        mergeSort(prepareArray,0,prepareArray.size-1)

        return prepareArray
    }

    //对[l,r]集合进行排序
    private fun mergeSort(num: IntArray,l:Int,r:Int){
        if(l>=r) return

        var mid = (l + r)/2
        mergeSort(num,l,mid)
        mergeSort(num,mid + 1, r)
        //此处在当num[mid]<= num[mid + 1]的情况下，并不需要进行merge
        //这样的优化可以在近乎有序的序列进行排序时节省很多merge操作
        if(num[mid] > num[mid+1]){
            merge(num,l,mid,r)
        }
    }


    //归并[l,mid]和[mid+1,r]两段
    private fun merge(num:IntArray,l:Int,mid:Int,r:Int){
        var mergeSum: IntArray = IntArray(r-l+1)

        //将[l,mid]和[mid+1,r]两段两段元素放置在一个临时数组中
        for(i in l..r){
            mergeSum[i-l] = num[i]
        }

        var i = l
        var j = mid + 1
        for (k in l..r) {
            if(i>mid){
                num[k] = mergeSum[j-l]
                j++
            }else if(j>r){
                num[k] = mergeSum[i-l]
                i++
            }else if (mergeSum[i-l] <= mergeSum[j-l]) {
                num[k] = mergeSum[i-l]
                i++
            } else {
                num[k] = mergeSum[j-l]
                j++
            }
        }

    }
}