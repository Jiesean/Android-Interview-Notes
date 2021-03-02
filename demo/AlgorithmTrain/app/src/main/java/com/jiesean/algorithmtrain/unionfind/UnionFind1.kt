package com.jiesean.algorithmtrain.unionfind

/**
 * @author Wangjie
 * @description: 并查集，使用数组标识组别，是一种quick find 实现方式
 * @date :2021/3/2 10:59 PM
 */
class UnionFind1 (n:Int):UnionFind{
    private lateinit var id:IntArray
    private var count = 0

    init {
        count = n
        id = IntArray(n)
        for (i in 0 until n){
            id[i] = i
        }
    }

    //找到p元素的id
    public override fun find(p:Int):Int{
        if(p >= count){
            return -1
        }

        return id[p]
    }

    //判断两个点p、q是否是联通的
    public override fun isConnected(p:Int, q:Int):Boolean {
        return (find(p) != -1)&&(find(p) == find(q))
    }

    public override fun union(p:Int, q:Int){
        var pId = find(p)
        var qId = find(q)

        if(pId == qId){
            return
        }

        for(i in 0 until count){
            if (id[i] == pId) {
                id[i] = qId
            }
        }
    }
}