package com.jiesean.algorithmtrain.graph

/**
 * @author Wangjie
 * @description:
 * @date :2021/3/5 3:18 PM
 */
interface AdjIterable<T> {
    fun iterator(v:Int): AdjIterator<T>
}