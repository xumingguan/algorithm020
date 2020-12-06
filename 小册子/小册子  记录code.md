# 小册子  记录code



算法题:

#### [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

```java

     // 折中 计算方法   两边向中间计算
     // 高度  看那边比较低 * 长度的差的值
     // 时间复杂度 O(n)

    /**
     * 获取最大容器水量
     * @param height 高 
     * @return 结果
     */
    public int maxAreas(int[] height) {
        int i = 0,
                j = height.length - 1,
                res = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i) * height[i++]);
            } else {
                res = Math.max(res, (j - i) * height[j--]);
            }
        }
        return res;
    }
```



数组和链表的遍历

```java
// 数组的遍历：
for(int i = 0; i < arr.size();i++) {
    print(arr[i])
}
// 链表的遍历：
for (ListNode cur = head; cur != null; cur = cur.next) {
    print(cur.val)
}

// 总结  链表的价值就在于其不必要求物理内存的连续性，以及对插入和删除的友好  数组是需要开辟连续的空间
```













遇到的坑:

​	i++ 的问题:

```js
int i = 1;
int j1 = i++; // 先将i的原始值（1）赋值给变量j1（1），然后i变量的值加1
int j1 = ++i; // 先将i变量的值加1，然后将i的当前值（2）赋值给变量j1（2）
```



code 的感悟

- 一定要注意审题 不然 写出来的 漏洞百出   需要多个测试案例



