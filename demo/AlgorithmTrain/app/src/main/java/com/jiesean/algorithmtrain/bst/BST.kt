package com.jiesean.algorithmtrain.bst

/**
 * @author Wangjie
 * @description: 二叉树
 * @date :2021/2/27 11:09 AM
 */
class BST {

    inner class Node(key: Int,value: Int){
        var key:Int = 0
        var value:Int = 0
        var rightNode: Node? = null
        var lightNode: Node? = null
    }

    private var count: Int = 0
    private var root: Node? = null

    fun size():Int{
        return count
    }

    fun root():Node?{
        return root
    }

    fun isEmpty():Boolean{
        return count == 0
    }

    //使用递归的方式实现搜索二叉树的插入操作
    fun insert(key:Int,value:Int){
        insert(root,key,value)
    }

    //插入递归函数
    private fun insert(root:Node?,key: Int,value: Int):Node{
        if(root == null){
            count++
            return Node(key,value)
        }
        if(root.key == key){
            root.value = value
        }else if(root.key > key){
            root.lightNode =  insert(root.lightNode,key,value)
        }else{
            root.rightNode =  insert(root.rightNode,key,value)
        }
        return root
    }

    //使用迭代的方式实现搜索二叉树的插入操作
    fun insert2(key:Int,value: Int){
        var targetNode = root

        while (true){
            if(targetNode == null){
                count++
                targetNode =  Node(key,value)
                break
            }else if(targetNode.key == key){
                targetNode.value = value
                break
            }else if(targetNode.key > key){
                targetNode = targetNode.lightNode
            }else{
                targetNode = targetNode.rightNode
            }
        }

    }
}