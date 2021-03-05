package com.jiesean.algorithmtrain.graph

/**
 * @author Wangjie
 * @description:
 * @date :2021/3/5 3:21 PM
 */
interface AdjIterator<T>{
    fun begin():T
    fun end():T
    fun next():T
}