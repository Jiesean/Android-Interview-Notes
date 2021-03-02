package com.jiesean.algorithmtrain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jiesean.algorithmtrain.databinding.ActivityUnionFindBinding
import kotlin.concurrent.thread

class UnionFindActivity : AppCompatActivity() {
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, UnionFindActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_union_find)
        var mUnionFindBinding = ActivityUnionFindBinding.inflate(layoutInflater)
        setContentView(mUnionFindBinding.root)

        mUnionFindBinding.testUnionFindBtn.setOnClickListener {
            thread {

            }
        }
    }
}