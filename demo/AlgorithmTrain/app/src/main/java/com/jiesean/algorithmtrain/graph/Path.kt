package com.jiesean.algorithmtrain.graph

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author Wangjie
 * @description: 创建类来求解从节点s到任意节点的w的路径
 * @date :2021/3/6 12:20 AM
 */
class Path(G:Graph<Int>,s:Int){
    private lateinit var G: Graph<Int>
    //存储被遍历过的节点
    private lateinit var visited:BooleanArray
    //存储连通分量的数量
    private var ccount = 0
    //存储遍历过程的经过的节点
    private lateinit var from:IntArray

    init {
        this.G = G
        this.visited = BooleanArray(G.V(),init = {false})
        this.from = IntArray(G.V(),init = {-1})
//
//        for (i in 0 until G.V()) {
//            if (!visited[i]) {
//                dfs(i)
//                ccount++
//            }
//        }

        dfs(s)

    }

    //深度优先遍历
    private fun dfs(v:Int) {
        visited[v] = true
        var iterator = G.iterator(v)
        var node  = iterator.next()

        while (node != -1){
            if (!visited[node]) {
                from[node] = v
                dfs(node)
            }
            node = iterator.next()
        }
    }

    //w和s直接是不是连通的
    fun hasPath(w:Int):Boolean{
        if (w < 0 || w >= G.V()) {
            throw IndexOutOfBoundsException("图中不存在相应元素")
        }
        return visited[w]
    }

    //w和s直接的连通的路径
    fun path(w:Int):ArrayList<Int>{
        if (w < 0 || w >= G.V()) {
            throw IndexOutOfBoundsException("图中不存在相应元素")
        }
        var path:ArrayList<Int> = ArrayList()
        var p = w
        var stack = Stack<Int>()
        while (p != -1){
            stack.push(p)
            p = from[p]
        }

        while (!stack.empty()){
            path.add(stack.pop())
        }
        return path
    }

    fun showPath(w:Int){
        var path = path(w)
        System.out.print("从s到w节点的路径是")
        for (i in 0 until path.size){
            System.out.print("${path.get(i)},")
        }
        System.out.print("\n ")
    }

}