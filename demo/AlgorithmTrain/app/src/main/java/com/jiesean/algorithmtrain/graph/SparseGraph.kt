package com.jiesean.algorithmtrain.graph

import android.icu.text.Edits

/**
 * @author Wangjie
 * @description:
 * @date :2021/3/3 11:55 PM
 */
class SparseGraph(n:Int,directed:Boolean): Graph<Int>{
    //表示图中点的个数
    private var n:Int = 0
    //表示图中边的个数
    private var m:Int = 0
    //表示图是否是有向图
    private var directed:Boolean = false
    //使用二维数组表示邻接表，index位的数组标识index元素的所有连接的点
    private lateinit var g:Array<ArrayList<Int>>

    init {
        this.n = n
        this.m = 0
        this.directed = directed

        g = Array(size = n,init = { ArrayList<Int>(n) })
    }

    override fun V(): Int {
        return n
    }

    override fun E(): Int {
        return m
    }

    override fun addEdge(v: Int, w: Int) {
        if(v<0 || v >= n ||w < 0 ||w >= n){
            throw ArrayIndexOutOfBoundsException("图中不存在输入节点")
        }

        //无论有方向或者无方向都需要进行的操作
        g[v].add(w)

        //通过使用v != w来排除自环边
        if(v != w && !directed){
            g[w].add(v)
        }
    }

    override fun hasEdge(v: Int, w: Int): Boolean {
        if(v<0 || v > n ||w <= 0 ||w >= n){
            throw ArrayIndexOutOfBoundsException("图中不存在输入节点")
        }
        return g[v].contains(w)
    }

    override fun iterator(v:Int): AdjIterator<Int> {
        if (v < 0||v>= n) {
            throw IndexOutOfBoundsException("图中不存在输入节点")
        }
        return SparseAdjInterator(v)
    }

    inner class SparseAdjInterator(v:Int):AdjIterator<Int> {
        private var v = 0
        private var index = -1
        init {
            this.v = v
        }

        override fun begin():Int{
            if(v < 0 || v >= n || g[v].size <= 0){
                throw ArrayIndexOutOfBoundsException("图中没有包含该元素")
            }

            //返回第v元素的第一个元素
            return g[v].get(0)

        }
        override fun end():Int{
            if(v < 0 || v >= n || g[v].size <= 0){
                throw ArrayIndexOutOfBoundsException("图中没有包含该元素")
            }

            //返回第v元素的第一个元素
            var endIndex = g[v].size - 1
            return g[v].get(endIndex)
        }
        override fun next():Int{
            index ++
            if(g[v].size <= 0 || index >= g[v].size){
                //因为所有元素均为非负整数，所以此处使用 -1 作为已经已经无法遍历的结果
                return -1
            }
            return g[v].get(index)
        }

    }
}