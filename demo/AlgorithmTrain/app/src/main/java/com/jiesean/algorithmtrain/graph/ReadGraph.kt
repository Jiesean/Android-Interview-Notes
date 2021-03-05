package com.jiesean.algorithmtrain.graph

import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.Reader

/**
 * @author Wangjie
 * @description:
 * @date :2021/3/5 7:19 PM
 */
object ReadGraph {
    public fun readGraph(context: Context,G:Graph<Int>,fileName:String){
        var am = context.assets
        var inputStream = am.open(fileName)
        var bufferedReader = BufferedReader(inputStream.bufferedReader())
        var line:String? = bufferedReader.readLine()
        line = bufferedReader.readLine()
        var index = 1
        while (line != null){
            var v = line.substringBefore(" ")
            var w = line.substringAfter(" ")
            Log.e(javaClass.simpleName,"readGraph line index = ${index}, v = ${v}, w = ${w}")

            G.addEdge(v.toInt(),w.toInt())
            line = bufferedReader.readLine()
            index ++

        }

    }
}