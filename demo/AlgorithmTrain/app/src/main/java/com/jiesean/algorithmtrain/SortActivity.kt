package com.jiesean.algorithmtrain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.graphics.translationMatrix
import com.jiesean.algorithmtrain.databinding.ActivitySortBinding
import com.jiesean.algorithmtrain.helper.Sort
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
                    { Sort.testSelectSort(SortTestHelper.generateRandomArray(100000,0,10000)) })
            }
        }

        mSortBinding.testGenericsSelectSortBtn.setOnClickListener {
            //To do
            Toast.makeText(this,"暂未做实现",Toast.LENGTH_SHORT).show()
        }

        mSortBinding.testInsertionSortBtn.setOnClickListener {
            thread {
                SortTestHelper.sortAnalysis("插入排序",
                    { Sort.testInsertionSort(SortTestHelper.generateNearlySortedRandomArray(100000,0,10000,10)) })
            }
        }
        mSortBinding.testBubbleSortBtn.setOnClickListener {
            thread {
                SortTestHelper.sortAnalysis("冒泡排序",
                    {
                        Sort.testBubbleSort(SortTestHelper.generateRandomArray(10000,0,10000))
                    })
            }
        }
        mSortBinding.testShellSortBtn.setOnClickListener {
            thread {
                SortTestHelper.sortAnalysis("希尔排序",
                    {
                        Sort.testShellSort(SortTestHelper.generateRandomArray(10000,0,10000))
                    }
                )
            }
        }
        mSortBinding.testMergeSortBtn.setOnClickListener {
            thread {
                SortTestHelper.sortAnalysis("归并排序",
                    {
                        Sort.testInterationMergeSort(SortTestHelper.generateRandomArray(10000,0,10000))

                    })
            }
        }
        mSortBinding.testQuickSortBtn.setOnClickListener {
            thread {
                SortTestHelper.sortAnalysis("快速排序",
                    {
                        Sort.testQuickSort(SortTestHelper.generateRandomArray(10000,0,10000))
                    })
            }
        }
        mSortBinding.testQuick3SortBtn.setOnClickListener {
            thread {
                SortTestHelper.sortAnalysis("3路快速排序",
                    {
                        Sort.testQuickSort3(SortTestHelper.generateRandomArray(10000,0,10000))
                    })
            }
        }
    }



}