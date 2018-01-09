package liurui.defines.structures.string;

/**
 * 旋转字符串
 * <p>
 * 如: abcdefg ,旋转的下标为3
 * 结果为: efgabcd
 * <p>
 * 就是将下标后面的数放在最前面
 */
public interface Rotate {
    String rotate(String str, int index);
}
