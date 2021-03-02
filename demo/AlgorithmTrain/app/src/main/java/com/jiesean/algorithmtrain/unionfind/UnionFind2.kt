package com.jiesean.algorithmtrain.unionfind

import android.support.v4.app.INotificationSideChannel

/**
 * @author Wangjie
 * @description: 使用parent数组标识每个节点的父节点，是一种quick union的实现方式，是一种常见实现方式
 * @date :2021/3/2 11:26 PM
 */
class UnionFind2(n:Int):UnionFind{
    private lateinit var parent:IntArray
    private var count = 0

    init {
        count = n
        parent = IntArray(n)

        //使得每个节点指向他自己
        for(i in 0 until n){
            parent[i] = i
        }
    }

    //找到其根节点
    override fun find(p: Int): Int {
        if(p>=count) return -1

        var index = p
        while (parent[index] != index) {
            index = parent[index]
        }

        return index
    }

    override fun isConnected(p: Int, q: Int): Boolean {
        var pParent = find(p)
        var qParent = find(q)
        if(p == -1 || q == -1)
            throw ArrayIndexOutOfBoundsException("没有找到对应的元素")
        return pParent == qParent
    }

    override fun union(p: Int, q: Int) {
        if(p >= count || q >= count)
            throw ArrayIndexOutOfBoundsException("没有找到对应的元素")

        parent[find(p)] = parent[find(q)]

    }
}