# 算法

## 排序算法

### 选择排序

#### 实现思路

1. 第一次遍历所有元素，从中选择最小的元素，放置在第一个位置
2. 第二次遍历第一个元素后的所有元素，从中选择最小元素，放置在第二个位置
3. 重复上述动作，直到前n-1的最小元素都选出来

#### 复杂度分析

O(n) = n + (n -1) + (n -2) +........ +1

​         =  (n + 1)* n/2

最大n^2 ,所以选择排序是O(n^2)级别的排序算法

#### 代码实现

[算法示例 testSelectSort](https://github.com/Jiesean/Android-Interview-Notes/tree/master/demo/AlgorithmTrain)

### 插入排序

#### 实现思路

插入排序的实现思想就是跟扑克牌插排是一样的，依次遍历所有的数，然后将他们插入到前面合适的位置

#### 复杂度分析

O(n) = 1 + 2 + ...... + n -1

​         = n * n/2

最大n^2,所以插入排序也是一个O(n^2)级别的排序算法

#### 代码实现

[插入排序 testInsertionSort](https://github.com/Jiesean/Android-Interview-Notes/tree/master/demo/AlgorithmTrain)

