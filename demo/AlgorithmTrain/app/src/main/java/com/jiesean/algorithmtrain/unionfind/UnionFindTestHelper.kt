package com.jiesean.algorithmtrain.unionfind

import android.util.Log

/**
 * @author Wangjie
 * @description:
 * @date :2021/3/2 11:17 PM
 */
object UnionFindTestHelper {
    fun testUnionFind(n:Int,unionFind: UnionFind){
        var start = System.currentTimeMillis()

        for(i in 0 until n){
            var a = (0 until n).random()
            var b = (0 until n).random()
            unionFind.union(a,b)
        }

        for (i in 0 until n){
            var a = (0 until n).random()
            var b = (0 until n).random()
            unionFind.isConnected(a,b)
        }

        var cost = System.currentTimeMillis() - start

        Log.e(javaClass.simpleName,"testUnionFind subclass = ${unionFind.javaClass.name}, cost = ${cost} ms")
    }
}