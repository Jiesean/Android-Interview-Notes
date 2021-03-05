package com.jiesean.algorithmtrain.graph

/**
 * @author Wangjie
 * @description:
 * @date :2021/3/3 11:30 PM
 */
interface Graph<T>{
    public fun V():Int

    public fun E():Int

    public fun addEdge(v:Int,w:Int)

    public fun hasEdge(v:Int,w:Int):Boolean

    fun iterator(v:Int): AdjIterator<T>
}