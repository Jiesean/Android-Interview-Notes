package com.jiesean.algorithmtrain.graph

import java.util.*

/**
 * @author Wangjie
 * @description: 使用邻接矩阵实现稠密图
 * @date :2021/3/3 3:21 PM
 */
class DenseGraph(n:Int,directed:Boolean) :Graph,AdjIterable<Int>{
    private var n:Int = 0
    private var m:Int = 0
    private var directed = false
    private lateinit var g:Array<BooleanArray>

    init {
        this.n = n
        m = 0
        this.directed = directed
        g = Array(size = n,init = {BooleanArray(n,init = {false})})

        //初始化为自己和自己连通
        for (i in 0 until n){
            g[i][i] = true
        }
    }

    //返回节点个数
    public override fun V():Int{
        return n
    }

    //返回边的个数
    public override fun E():Int{
        return m
    }

    //向图中的v,w两个节点添加一条边
    public override fun addEdge(v:Int, w:Int){
        if(v < 0 || v >= n || w < 0 || w >= n){
            throw IndexOutOfBoundsException("传入的参数超出图的范围")
        }

        if(directed){
            g[w][v] = true
        }
        g[v][w] = true
        m ++
    }

    public override fun hasEdge(v:Int, w:Int):Boolean{
        if(v < 0 || v >= n || w < 0 || w >= n){
            throw IndexOutOfBoundsException("传入的参数超出图的范围")
        }
        return g[v][w]
    }

    override fun iterator(v: Int): AdjIterator<Int> {
        if (v < 0||v>= n) {
            throw IndexOutOfBoundsException("图中不存在输入节点")
        }
        return DenseGraph(v)
    }

    inner class DenseGraph(v: Int):AdjIterator<Int>{
        private var index = -1
        private var v:Int

        init {
            this.v = v
        }
        override fun begin(): Int {
            if(v < 0 || v >= n){
                throw ArrayIndexOutOfBoundsException("图中没有包含该元素")
            }

            //返回第v元素的第一个元素

            for(i in 0 until n){
                if (g[v][i] == true) {
                    return i
                }
            }

            //表示没有任何元素
            return -1
        }

        override fun end(): Int {
            if(v < 0 || v >= n){
                throw ArrayIndexOutOfBoundsException("图中没有包含该元素")
            }

            //返回第v元素的第一个元素

            for(i in (n-1) downTo  0){
                if (g[v][i] == true) {
                    return i
                }
            }

            //表示没有任何元素
            return -1
        }

        override fun next(): Int {
            if(index + 1 >=n ){
                return  -1
            }
            for(i in (index + 1) until n){
                if (g[v][i] == true) {
                    index = i
                    return i
                }
            }
            return  -1

        }

    }

}