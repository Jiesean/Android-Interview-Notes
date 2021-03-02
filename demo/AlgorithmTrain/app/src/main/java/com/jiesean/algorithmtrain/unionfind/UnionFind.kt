package com.jiesean.algorithmtrain.unionfind

/**
 * @author Wangjie
 * @description:
 * @date :2021/3/2 11:15 PM
 */
interface UnionFind {
    public fun find(p:Int):Int
    public fun isConnected(p:Int,q:Int):Boolean
    public fun union(p:Int,q:Int)
}