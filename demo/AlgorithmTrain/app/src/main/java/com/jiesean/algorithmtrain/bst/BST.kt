package com.jiesean.algorithmtrain.bst

import android.util.Log

/**
 * @author Wangjie
 * @description: 二叉树
 * @date :2021/2/27 11:09 AM
 */
class BST {

    inner class Node(key: Int, value: Int) {
        var key: Int = 0
        var value: Int = 0
        var rightNode: Node? = null
        var lightNode: Node? = null

        init {
            this.key = key
            this.value = value
        }
    }

    private var count: Int = 0
    private var root: Node? = null

    fun size(): Int {
        return count
    }

    fun root(): Node? {
        return root
    }

    fun isEmpty(): Boolean {
        return count == 0
    }

    //使用递归的方式实现搜索二叉树的插入操作
    fun insert(key: Int, value: Int) {
        root = insert(root, key, value)
    }

    //插入递归函数
    private fun insert(root: Node?, key: Int, value: Int): Node {
        if (root == null) {
            count++
            return Node(key, value)
        }
        if (root.key == key) {
            root.value = value
        } else if (root.key > key) {
            root.lightNode = insert(root.lightNode, key, value)
        } else {
            root.rightNode = insert(root.rightNode, key, value)
        }
        return root
    }

    //使用迭代的方式实现搜索二叉树的插入操作
    fun insert2(key: Int, value: Int) {

        if (root == null) {
            count++
            root = Node(key,value)
            return
        }
        var targetNode = root

        while (targetNode != null) {

            if (targetNode.key == key) {
                Log.e(javaClass.simpleName,"insert2  Modify Node {${key},${value}}")
                targetNode.value = value
                break
            } else if (targetNode.key > key) {
                if(targetNode.lightNode == null){
                    count++
                    targetNode.lightNode = Node(key,value)
                    break
                }else {
                    targetNode = targetNode.lightNode
                }
            } else {
                if (targetNode.rightNode == null) {
                    count++
                    targetNode.rightNode = Node(key, value)
                    break
                } else {
                    targetNode = targetNode.rightNode
                }
            }
        }
    }

    //查找是否包含key的节点
    fun contains(key: Int): Boolean {
        return find(root, key)
    }

    private fun find(root: Node?, target: Int): Boolean {
        if (root == null) {
            return false
        } else if (root.key == target) {
            return true
        } else if (root.key > target) {
            return find(root.lightNode, target)
        } else {
            return find(root.rightNode, target)
        }
    }

    //前序遍历
    fun preOrder(){
        preOrder(root)
    }

    private fun preOrder(root:Node?){
        if (root == null) {
            return
        }

        preOrder(root.lightNode)
        Log.e(javaClass.simpleName,"preOrder current = ${root.key}")
        preOrder(root.rightNode)
    }

    //中序遍历
    fun inOrder(){
        inOrder(root)
    }

    private fun inOrder(root:Node?){
        if (root == null) {
            return
        }

        Log.e(javaClass.simpleName,"inOrder current = ${root.key}")
        inOrder(root.lightNode)
        inOrder(root.rightNode)
    }

    //后续遍历
    fun postOrder(){
        postOrder(root)
    }

    private fun postOrder(root:Node?){
        if (root == null) {
            return
        }

        postOrder(root.lightNode)
        postOrder(root.rightNode)
        Log.e(javaClass.simpleName,"postOrder current = ${root.key}")
    }

}