package com.jiesean.algorithmtrain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jiesean.algorithmtrain.bst.BST
import com.jiesean.algorithmtrain.bst.BinarySearch
import com.jiesean.algorithmtrain.databinding.ActivityBstBinding
import kotlin.concurrent.thread


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
    private var testBstArray = intArrayOf(4,1,45,7,9,18,2,23,12,45,56)
    private var testFloorAndCeilArray = intArrayOf(1,3,4,7,9,9,9,9,9,9,9,9,11,18,23,34,45,56)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_bst)
        var mBstBinding = ActivityBstBinding.inflate(layoutInflater)
        setContentView(mBstBinding.root)

        mBstBinding.testBinarySearchBtn.setOnClickListener {
            thread {
                //测试二分查找
                Log.e(
                    javaClass.simpleName,
                    "测试迭代实现的二分查找9的位置 result = ${BinarySearch.testBinarySearch1(testArray, 9)}"
                )
                Log.e(
                    javaClass.simpleName,
                    "测试迭代实现的二分查找45的位置 result = ${BinarySearch.testBinarySearch1(testArray, 45)}"
                )
                Log.e(
                    javaClass.simpleName,
                    "测试递归实现的二分查找9的位置 result = ${BinarySearch.testBinarySearch2(testArray, 9)}"
                )
                Log.e(
                    javaClass.simpleName,
                    "测试递归实现的二分查找45的位置 result = ${BinarySearch.testBinarySearch2(testArray, 45)}"
                )
                Log.e(
                    javaClass.simpleName,
                    "测试Floor 9的位置 result = ${BinarySearch.floor(testFloorAndCeilArray, 9)}"
                )
                Log.e(
                    javaClass.simpleName,
                    "测试Ceil 9的位置 result = ${BinarySearch.ceil(testFloorAndCeilArray, 9)}"
                )
            }
        }

        mBstBinding.testBinarySearchTreeBtn.setOnClickListener {
            thread {
                var mBST = BST()
                for (v in testBstArray){
                    mBST.insert(v,3)
                }

                Log.e(javaClass.simpleName,"测试二叉搜索树的插入和搜索功能，size = ${mBST.size()} ,搜索已经插入元素 45 = ${mBST.contains(45)}")

                var mBST2 = BST()
                for (v in testBstArray){
                    mBST2.insert2(v,3)
                }

                Log.e(javaClass.simpleName,"测试二叉搜索树的插入和搜索功能，size = ${mBST2.size()} ,搜索已经插入元素 45 = ${mBST2.contains(45)}")
            }
        }

        mBstBinding.testBinarySearchTreeOrderBtn.setOnClickListener {
            thread {
                var mBST = BST()
                for (v in testBstArray){
                    mBST.insert(v,3)
                }

                mBST.preOrder()
                mBST.inOrder()
                mBST.postOrder()

            }
        }

        mBstBinding.testBinarySearchTreeLevelOrderBtn.setOnClickListener {
            thread {
                var mBST = BST()
                for (v in testBstArray){
                    mBST.insert(v,3)
                }

                mBST.levelOrder()
            }
        }
    }
}