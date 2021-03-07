package com.jiesean.algorithmtrain.graph

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author Wangjie
 * @description:
 * @date :2021/3/6 2:23 PM
 */
class ShortestPath(G:Graph<Int>,s:Int) {
    private lateinit var G:Graph<Int>
    private var s:Int = -1
    private lateinit var visited:BooleanArray
    private lateinit var from:IntArray
    private lateinit var ord:IntArray

    init {
        this.G = G
        this.s = s
        this.visited = BooleanArray(G.V(),init = {false})
        this.from = IntArray(G.V(),init = {-1})
        this.ord = IntArray(G.V(),init = {-1})

        var queue:LinkedList<Int> = LinkedList()

        queue.add(s)
        visited[s] = true
        ord[s] = 0

        while (!queue.isEmpty()){
            var v = queue.remove()

            var iterator: AdjIterator<Int> = this.G.iterator(v)
            var next = iterator.next()

            while (next != -1){
                Log.e(javaClass.simpleName,"queue  = ${next} , visited = ${visited[next]}")
                if(!visited[next]){
                    queue.add(next)
                    visited[next] = true
                    from[next] = v
                    ord[next] = ord[v] + 1
                }
                next = iterator.next()
            }
            System.out.println("next 结束了")
        }
        System.out.println("init 结束了")
    }


    //判断w和s直接是否存在路径
    fun hasPath(w:Int):Boolean{
        if (w < 0 || w >= G.V()) {
            throw ArrayIndexOutOfBoundsException("图中不包含这个元素")
        }
        return visited[w]
    }


    fun path(w:Int):ArrayList<Int>{
        if (w < 0 || w >= G.V()) {
            throw ArrayIndexOutOfBoundsException("图中不包含这个元素")
        }

        var stack:Stack<Int> = Stack()
        var parent = w
        while (parent != -1)
        {
            stack.push(parent)
            parent = from[parent]
        }
        var path:ArrayList<Int> = ArrayList<Int>()

        while (!stack.empty()){
            path.add(stack.pop())
        }
        return path
    }

    fun showPath(w:Int){
        if (w < 0 || w >= G.V()) {
            throw ArrayIndexOutOfBoundsException("图中不包含这个元素")
        }

        var path = path(w);
        for (i in 0 until path.size){
           Log.e(javaClass.simpleName,path.get(i).toString() + " ->")
        }

    }

    fun length(w:Int):Int{
        if (w < 0 || w >= G.V()) {
            throw ArrayIndexOutOfBoundsException("图中不包含这个元素")
        }

        return ord[w]
    }



}