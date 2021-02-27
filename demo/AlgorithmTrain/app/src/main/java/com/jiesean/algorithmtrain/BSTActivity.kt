package com.jiesean.algorithmtrain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jiesean.algorithmtrain.bst.BinarySearch
import com.jiesean.algorithmtrain.databinding.ActivityBstBinding


/**
 * 测试二叉树
 */
class BSTActivity : AppCompatActivity() {
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, BSTActivity::class.java)
            context.startActivity(starter)
        }
    }

    private var testArray = intArrayOf(1,3,4,7,9,11,18,23,34,45,56)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_bst)
        var mBstBinding = ActivityBstBinding.inflate(layoutInflater)
        setContentView(mBstBinding.root)

        mBstBinding.testBinarySearchBtn.setOnClickListener {
            //测试二分查找
            Log.e(javaClass.simpleName,"测试迭代实现的二分查找9的位置 result = ${BinarySearch.testBinarySearch1(testArray,9)}")
            Log.e(javaClass.simpleName,"测试迭代实现的二分查找45的位置 result = ${BinarySearch.testBinarySearch1(testArray,45)}")
            Log.e(javaClass.simpleName,"测试递归实现的二分查找9的位置 result = ${BinarySearch.testBinarySearch2(testArray,9)}")
            Log.e(javaClass.simpleName,"测试递归实现的二分查找45的位置 result = ${BinarySearch.testBinarySearch2(testArray,45)}")



        }
    }
}