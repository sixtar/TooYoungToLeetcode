package org.dingding._023_合并k个升序链表;

/**
 * 只提供思路，因为不能这么偷懒。。
 * 用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表，
 * 然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空。
 */
public class Solution2 {
}
