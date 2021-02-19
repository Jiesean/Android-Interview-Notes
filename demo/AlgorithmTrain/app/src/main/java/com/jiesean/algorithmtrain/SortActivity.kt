package com.jiesean.algorithmtrain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jiesean.algorithmtrain.databinding.ActivitySortBinding
import com.jiesean.algorithmtrain.helper.SortTestHelper
import java.util.*
import kotlin.concurrent.thread

class SortActivity : AppCompatActivity() {
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, SortActivity::class.java)
            context.startActivity(starter)
        }
    }

    private lateinit var mSortBinding: ActivitySortBinding

    private var needSortArray: IntArray = intArrayOf(12,3,4,34,1,56,7,3,54,17,78,33,21)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sort)
        mSortBinding = ActivitySortBinding.inflate(layoutInflater)
        setContentView(mSortBinding.root)

        mSortBinding.testSelectSortBtn.setOnClickListener {
            thread {
                SortTestHelper.sortAnalysis("选择排序",
                    { testSelectSort(SortTestHelper.generateRandomArray(100000,0,10000)) })
            }
        }

        mSortBinding.testGenericsSelectSortBtn.setOnClickListener {
            //To do
        }

        mSortBinding.testInsertionSortBtn.setOnClickListener {
            thread {
                SortTestHelper.sortAnalysis("插入排序",
                    { testInsertionSort(SortTestHelper.generateRandomArray(100000,0,10000)) })
            }
        }
    }

    // 选择排序
    private fun testSelectSort(num:IntArray):IntArray{
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
    private fun <T> testGenericsSelectSort(array:Array<T>):Array<T>{
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
    private fun testInsertionSort(num:IntArray):IntArray{
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
        return preprareArray
    }


}