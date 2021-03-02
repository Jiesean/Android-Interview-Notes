package com.jiesean.algorithmtrain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jiesean.algorithmtrain.databinding.ActivityUnionFindBinding
import com.jiesean.algorithmtrain.helper.SortTestHelper
import com.jiesean.algorithmtrain.unionfind.*
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
                var n = 1000000
//                var unionFind1 = UnionFind1(n)
//                UnionFindTestHelper.testUnionFind(n,unionFind1)
//
//                var unionFind2 = UnionFind2(n)
//                UnionFindTestHelper.testUnionFind(n,unionFind2)

                var unionFind3 = UnionFind3(n)
                UnionFindTestHelper.testUnionFind(n,unionFind3)

                var unionFind4 = UnionFind4(n)
                UnionFindTestHelper.testUnionFind(n,unionFind4)

                var unionFind5 = UnionFind5(n)
                UnionFindTestHelper.testUnionFind(n,unionFind5)

                var unionFind6 = UnionFind6(n)
                UnionFindTestHelper.testUnionFind(n,unionFind6)
            }
        }
    }
}