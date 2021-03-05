package com.jiesean.algorithmtrain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jiesean.algorithmtrain.databinding.ActivityGraphBinding
import com.jiesean.algorithmtrain.graph.DenseGraph
import com.jiesean.algorithmtrain.graph.SparseGraph
import kotlin.concurrent.thread

class GraphActivity : AppCompatActivity() {
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, GraphActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_graph)
        var mGraphBinding = ActivityGraphBinding.inflate(layoutInflater)
        setContentView(mGraphBinding.root)

        mGraphBinding.testGraphBtn.setOnClickListener {
            thread {
                var denseGraph = DenseGraph(10,false)
                denseGraph.addEdge(1,5)
                denseGraph.addEdge(3,4)

                var sparseGraph = SparseGraph(10,false)
                sparseGraph.addEdge(1,5)
                sparseGraph.addEdge(3,4)

                Log.e(javaClass.simpleName,"denseGraph 1,5 has edge = ${denseGraph.hasEdge(1,5)}, 3,4 has edge = ${denseGraph.hasEdge(3,4)}")
                Log.e(javaClass.simpleName,"sparseGraph 1,5 has edge = ${sparseGraph.hasEdge(1,5)}, 3,4 has edge = ${sparseGraph.hasEdge(3,4)}")
            }
        }

        mGraphBinding.testGraphIteratorBtn.setOnClickListener {
            thread {
                var denseGraph = DenseGraph(30,false)
                for(i in 0..9){
                    denseGraph.addEdge((0..29).random(),(0..29).random())
                }
                System.out.print("测试稠密图: ***************** \n")
                for(i in 0 until denseGraph.V()){
                    var iterator = denseGraph.iterator(i)
                    System.out.print("${i}连接的元素: ")
                    var target = iterator.next()
                    while (target != -1){
                        System.out.print(" ${target}")
                        target = iterator.next()
                    }
                    System.out.print("\n")
                }


                var sparseGraph = SparseGraph(30,false)
                for(i in 0..9){
                    sparseGraph.addEdge((0..29).random(),(0..29).random())
                }
                System.out.print("测试稀疏图: ***************** \n")
                for(i in 0 until sparseGraph.V()){
                    var iterator = sparseGraph.iterator(i)
                    System.out.print("${i}连接的元素: ")
                    var target = iterator.next()
                    while (target != -1){
                        System.out.print(" ${target}")
                        target = iterator.next()
                    }
                    System.out.print("\n")
                }

            }
        }

    }
}