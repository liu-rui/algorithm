package liurui.v4.structures.string;

import liurui.defines.structures.string.ContainsUsingBit;

/**
 * 判断字符串是否包含另一个字符串,使用位运算方式方式
 * 时间复杂度为O(M+N)
 * 空间复杂度为O(1)
 * M 为a串的长度
 * N为b串的长度
 * <p>
 * <p>
 * 缺点是：如果字符只是由26个字母组成，没有问题；但是，超过了整形的32个，将出现溢出
 */
public class ContainsUsingBitImpl implements ContainsUsingBit {
    @Override
    public boolean contains(String a, String b) {
        int bitmap = 0;

        for (int i = 0; i < a.length(); i++) {
            bitmap = bitmap | (2 << (a.charAt(i) - 'a'));
        }


        for (int j = 0; j < b.length(); j++) {
            if ((bitmap & (2 << (b.charAt(j) - 'a'))) == 0) {
                return false;
            }
        }
        return true;
    }
}
