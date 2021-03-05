package com.jiesean.algorithmtrain.graph

import android.util.Log

/**
 * @author Wangjie
 * @description: 深度优先遍历方法求解图的连通分量
 * @date :2021/3/5 7:55 PM
 */
class Component(G: Graph<Int>) {
    private lateinit var G: Graph<Int>
    //存储被遍历过的节点
    private lateinit var visited:BooleanArray
    //存储连通分量的数量
    private var ccount = 0
    //使用数组保存每个元素的组别，组别按照连通分量来区分
    private lateinit var id:IntArray
    init {
        this.G = G
        this.visited = BooleanArray(G.V(),init = {false})
        //并查集标识为 -1,而不像第一种UnionFind的实现一样赋值为i,是因为i有可能等于ccount,导致误判
        this.id = IntArray(G.V(),init = {-1})

        for (i in 0 until G.V()) {
            if (!visited[i]) {
                dfs(i)
                ccount++
            }
        }

    }

    private fun dfs(v:Int) {
        Log.e(javaClass.simpleName,"遍历到的连通分量 node = ${v}, visited = ${visited[v]}")
        visited[v] = true
        id[v] = ccount
        var iterator = G.iterator(v)
        var node  = iterator.next()

        while (node != -1){
            Log.e(javaClass.simpleName,"遍历到的连通分量 node = ${node}, visited = ${visited[node]}")
            if (!visited[node]) {
                dfs(node)
            }
            node = iterator.next()
        }
    }

    //返回图中连通分量的数目
    public fun count():Int{
        return ccount
    }

    //返回v,w是否是连接的
    public fun isConnected(v:Int,w:Int):Boolean{
        if (v < 0||v>=G.V() ||w<0||w>=G.V()) {
            throw ArrayIndexOutOfBoundsException("元素不存在")
        }
        return id[v] == id[w]
    }



}