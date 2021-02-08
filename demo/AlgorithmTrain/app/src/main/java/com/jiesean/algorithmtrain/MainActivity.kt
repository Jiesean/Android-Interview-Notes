package com.jiesean.algorithmtrain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jiesean.algorithmtrain.databinding.ActivityMainBinding
import kotlin.concurrent.thread

/**
 * 此工程用来进行算法的基础验证
 */
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.test100millionCostBtn.setOnClickListener {
            test100millionCost()
        }

        mBinding.testSortBtn.setOnClickListener {
            SortActivity.start(this)
        }

    }


    private fun test100millionCost(){
        thread {
            Log.e(this.localClassName,"start")
            var index = 0
            var startTime = System.currentTimeMillis()
            while (index < 100000000){
//                Log.e(localClassName,"print ${index}")
                index ++
            }
            var endTime = System.currentTimeMillis()
            Log.e(localClassName,"end ,cost time = ${endTime - startTime}")
        }
    }
}