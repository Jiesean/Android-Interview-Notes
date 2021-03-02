package com.jiesean.algorithmtrain.bst

import android.util.Log
import java.util.*

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

    fun levelOrder(){
        var queue:LinkedList<Node?> = LinkedList()
        queue.add(root)

        while (!queue.isEmpty()){
            var node = queue.poll()
            if (node == null) continue
            Log.e(javaClass.simpleName,"levelOrder ${node.key}")
            if(node.lightNode != null){
                queue.addLast(node.lightNode)
            }
            if(node.rightNode != null){
                queue.addLast(node.rightNode)
            }
        }

    }

    //递归实现查找二叉树的最小值
    fun minimum():Int{
        if (count == 0) {
            throw IndexOutOfBoundsException("二叉树中未包含任何元素")
        }

        var min = miniNode(root!!)
        return min.key
    }

    private fun miniNode(root: Node):Node{
        if (root.lightNode == null) return root
        return miniNode(root.lightNode!!)
    }

    //递归实现查找二叉树的最大值
    fun maximum():Int{
        if (count == 0) {
            throw IndexOutOfBoundsException("二叉树中未包含任何元素")
        }

        var maxNode= maxNode(root!!)
        return maxNode.key
    }

    private fun maxNode(root: Node):Node{
        if (root.rightNode == null) return root
        return maxNode(root.rightNode!!)
    }

    //删除最小节点
    fun rmMin(){
        if(root != null){
            root = rmMin(root!!)
        }
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private fun rmMin(node:Node):Node?{
        if(node.lightNode == null){
            count --
//            if(node.rightNode != null){
//                return node.rightNode!!
//            }else{
//                return null
//            }
            //上述注释代码可以优化，因为在左孩子不存在的情况下，可以不用判断右孩子直接返回
            return node.rightNode
        }
        node.lightNode =  rmMin(node.lightNode!!)
        return node
    }

    //删除最大节点
    fun rmMax(){
        if(root != null){
            root = rmMax(root!!)
        }
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private fun rmMax(node:Node): Node?{
        if(node.rightNode == null){
            count--
            if(node.lightNode != null){
                return node.lightNode
            }else{
                return null
            }
        }
        node.rightNode = rmMax(node.rightNode!!)
        return node
    }

    fun remove(key: Int){
        root = removeNode(root,key)
    }

    //删除以node为节点的二叉树中key的节点，返回新的node节点
    private fun removeNode(node:Node?,key:Int):Node?{
        if(node == null){
            return null
        }
        if(node.key > key) {
            node.lightNode = removeNode(node.lightNode,key)
            return  node
        }else if(node.key < key){
            node.rightNode = removeNode(node.rightNode,key)
            return node
        }else {
            count --
            if(node.lightNode == null ){
                return node.rightNode
            }else if( node.rightNode == null){
                return node.lightNode
            }
            var nodeReplace = Node(minimum(),3)
            count++
            nodeReplace.rightNode = rmMin(node.rightNode!!)
            nodeReplace.lightNode = node.lightNode
            return nodeReplace

        }
    }


}