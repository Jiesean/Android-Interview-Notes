package com.jiesean.algorithmtrain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jiesean.algorithmtrain.databinding.ActivityHeapBinding
import com.jiesean.algorithmtrain.heap.MaxHeap
import kotlin.concurrent.thread

class HeapActivity : AppCompatActivity() {

    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, HeapActivity::class.java)
            context.startActivity(starter)
        }
    }

    private lateinit var mHeapBinding:ActivityHeapBinding

    private var testHeapArray:IntArray = intArrayOf(2,3,5,6,7,10,4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_heap)
        mHeapBinding = ActivityHeapBinding.inflate(layoutInflater)
        setContentView(mHeapBinding.root)

        mHeapBinding.testHeapInsertBtn.setOnClickListener {
            thread {
                //to to heap
                var heap = MaxHeap(10)
                for (value in testHeapArray) {
                    Log.d(javaClass.simpleName, "插入元素 = ${value}, MaxHeap size = ${heap.size()}")
                    heap.insert(value)
                }
                while (!heap.isEmpity()) {
                    var value = heap.extractMax()
                    Log.d(javaClass.simpleName, "MaxHeap最大元素 = ${value}")
                }
            }
        }

        mHeapBinding.testHeap2InsertBtn.setOnClickListener {
            thread {var heap = MaxHeap(testHeapArray)

                while (!heap.isEmpity()) {
                    var value = heap.extractMax()
                    Log.d(javaClass.simpleName, "MaxHeap最大元素 = ${value}")
                }
            }
        }

    }
}