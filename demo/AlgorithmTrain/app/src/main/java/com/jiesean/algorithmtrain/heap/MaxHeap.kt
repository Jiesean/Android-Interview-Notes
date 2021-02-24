package com.jiesean.algorithmtrain.heap

import android.util.Log
import java.util.*

/**
 * @author Wangjie
 * @description: 实现一个最大堆
 * @date :2021/2/23 6:12 PM
 */
class MaxHeap(var capacity:Int){
    private lateinit var heapArray: IntArray
    private var count = 0
    init {
        heapArray = IntArray(capacity + 1)
    }

    fun isEmpity():Boolean{
        return count == 0
    }

    fun size():Int{
        return count
    }

    override fun toString():String{
        var str:String = ""
        return str
    }

    fun insert(num:Int){
        heapArray[count + 1] = num
        count++
        ShiftUp(count)
    }

    fun extractMax():Int{
        if (count <= 0)
            throw ArrayIndexOutOfBoundsException("最大堆中没有任何元素")

        var ret = heapArray[1]
        swapValue(1,count)
        count--

        shiftDown(1)

        return ret

    }

    private fun ShiftUp(index:Int){
        var temp = index
        while (temp >1){
            if(heapArray[temp] > heapArray[temp/2]){
                swapValue(temp,temp/2)
                temp = temp/2
            }else break
        }

        Log.e(javaClass.simpleName,"ShiftUp = ${Arrays.toString(heapArray)}")

    }

    private fun shiftDown(index:Int){
        //记录需要交换的子节点的index
        var j = 0
        var i = index

        while (i <= count/2){
            if(i <= (count -1)/2){
                if (heapArray[2*i] >= heapArray[2*i+1]){
                    j = 2 * i
                }else{
                    j = 2*i + 1
                }
            }else{
                j = 2*i
            }
            if(heapArray[j]>heapArray[i]){
                swapValue(i,j)
                i = j
            }else{
                break
            }
        }
        Log.e(javaClass.simpleName,"MaxHeap size = ${this.size()}, ShiftDown = ${Arrays.toString(heapArray)}")

    }

    private fun swapValue(index1:Int,index2:Int){
        var temp = heapArray[index1]
        heapArray[index1] = heapArray[index2]
        heapArray[index2] = temp
    }
}