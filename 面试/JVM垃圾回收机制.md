#堆内存（heap）
所有通过new创建的对象的内存都在堆中分配，其大小可以通过-Xmx和-Xms来控制。
* 使用的是二级缓存
* 生命周期由虚拟机的垃圾回收决定
* 可以看成是树结构
* 

#栈内存
* 存放函数的参数值、局部变量的值
* 使用的是一级缓存
* 调用完立即释放
* 先进后出的数据结构




### 标记

目标：找出所有引用不为0(live)的实例
方法：找到所有的GC的根结点(GC Root), 将他们放到队列里，然后依次递归地遍历所有的根结点以及引用的所有子节点和子子节点，将所有被遍历到的结点标记成live。弱引用不会被考虑在内

### 计划和清理
1、计划
目标：判断是否需要压缩
方法：遍历当前所有的generation上所有的标记(Live),根据特定算法作出决策
2、清理
目标：回收所有的free空间
方法：遍历当前所有的generation上所有的标记(Live or Dead),把所有处在Live实例中间的内存块加入到可用内存链表中去

### 引用更新和压缩
1、引用更新
目标： 将所有引用的地址进行更新
方法：计算出压缩后每个实例对应的新地址，找到所有的GC的根结点(GC Root), 将他们放到队列里，然后依次递归地遍历所有的根结点以及引用的所有子节点和子子节点，将所有被遍历到的结点中引用的地址进行更新，包括弱引用。
2、压缩
目标：减少内存碎片
方法：根据计算出来的新地址，把实例移动到相应的位置。