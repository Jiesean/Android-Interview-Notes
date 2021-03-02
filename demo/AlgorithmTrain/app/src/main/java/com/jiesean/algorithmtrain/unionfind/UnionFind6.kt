package com.jiesean.algorithmtrain.unionfind

import android.support.v4.app.INotificationSideChannel

/**
 * @author Wangjie
 * @description: 使用parent数组标识每个节点的父节点，是一种quick union的实现方式，是一种常见实现方式
 *               对UnionFind2进行使用路径压缩进行优化，使每次find完，每个元素直接指向其根节点
 * @date :2021/3/2 11:26 PM
 */
class UnionFind6(n:Int):UnionFind{
    private lateinit var parent:IntArray
    private lateinit var rank:IntArray //sz[i]表示以i为根的集合中的元素个数
    private var count = 0

    init {
        count = n
        parent = IntArray(n)
        rank = IntArray(n)

        //使得每个节点指向他自己
        for(i in 0 until n){
            parent[i] = i
            rank[i] = 1
        }
    }

    //找到其根节点
    override fun find(p: Int): Int {
        if(parent[p] != p)
            parent[p] = find(parent[p])
        return parent[p]
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
        var pRoot = find(p)
        var qRoot = find(q)

        if(pRoot == qRoot){
            return
        }

        if (rank[pRoot] == rank[qRoot]) {
            parent[pRoot] = qRoot
            rank[qRoot] ++
        }
        else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot
        }else{
            parent[pRoot] = qRoot
        }

    }
}