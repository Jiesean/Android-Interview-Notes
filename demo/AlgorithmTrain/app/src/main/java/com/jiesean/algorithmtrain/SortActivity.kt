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
                    { testSelectSort(SortTestHelper.generateRandomArray(100,0,10000)) })
            }
        }

        mSortBinding.testGenericsSelectSortBtn.setOnClickListener {
            //To do
        }
    }

    // 选择排序
    private fun testSelectSort(num:IntArray):IntArray{
        var preprareArray: IntArray = num.clone()
        Log.d(localClassName,"数组排序前 ${Arrays.toString(preprareArray)}")

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
        Log.d(localClassName,"数组排序前 ${Arrays.toString(preprareArray)}")

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


}