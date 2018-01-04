package liurui.defines.structures.tree;

/**
 * B树（B-树）
 *
 * B 树可以看作是对2-3查找树的一种扩展，即他允许每个节点有M-1个子节点。
 *
 * 特点：
 * 1. 根节点至少有两个子节点
 * 2.每个节点有M-1个key，并且以升序排列
 * 3.位于M-1和M key的子节点的值位于M-1 和M key对应的Value之间
 * 4.其它节点至少有M/2个子节点
 *
 *
 *
 * 参考：https://www.cnblogs.com/vincently/p/4526560.html
 */
public interface BTree {
}
