package com.jiesean.algorithmtrain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jiesean.algorithmtrain.databinding.ActivityGraphBinding
import com.jiesean.algorithmtrain.graph.*
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

        mGraphBinding.testGraphReaderBtn.setOnClickListener {
            thread {
                var graph1 = DenseGraph(30,false)
                ReadGraph.readGraph(this,graph1,"graph1.txt")
            }
        }

        mGraphBinding.testGraphDfsBtn.setOnClickListener {
            thread {
                var graph1 = DenseGraph(13,false)
                ReadGraph.readGraph(this,graph1,"graph1.txt")

                Log.e(javaClass.simpleName,"图1中包含的连通分量 = ${Component(graph1).count()}")

                var graph2 = SparseGraph(6,false)
                ReadGraph.readGraph(this,graph2,"graph2.txt")

                for(i in 0 until graph2.V()){
                    var iterator = graph2.iterator(i)
                    System.out.print("${i}连接的元素: ")
                    var target = iterator.next()
                    while (target != -1){
                        System.out.print(" ${target}")
                        target = iterator.next()
                    }
                    System.out.print("\n")
                }

                Log.e(javaClass.simpleName,"图2中包含的连通分量 = ${Component(graph2).count()}")

                var graph3 = DenseGraph(6,false)
                ReadGraph.readGraph(this,graph3,"graph2.txt")

                Log.e(javaClass.simpleName,"图2中包含的连通分量 = ${Component(graph3).count()}")
            }
        }

        mGraphBinding.testGraphIsconnectedBtn.setOnClickListener {
            thread {
                var graph2 = SparseGraph(6,false)
                ReadGraph.readGraph(this,graph2,"graph2.txt")

                Log.e(javaClass.simpleName,"图2中3,5 是否连接 = ${Component(graph2).isConnected(3,5)}")
                Log.e(javaClass.simpleName,"图2中1,4 是否连接 = ${Component(graph2).isConnected(1,4)}")
            }
        }

        mGraphBinding.testGraphPathBtn.setOnClickListener {
            thread {
                var graph2 = SparseGraph(6,false)
                ReadGraph.readGraph(this,graph2,"graph2.txt")

                Log.e(javaClass.simpleName,"图2中3,5 之间的路径 = ${Path(graph2,3).hasPath(5)}, path =  ${Path(graph2,3).showPath(5)}")
                Log.e(javaClass.simpleName,"图2中0,4 之间的路径 = ${Path(graph2,0).hasPath(4)}, path =  = ${Path(graph2,0).showPath(4)}")
            }
        }
    }
}