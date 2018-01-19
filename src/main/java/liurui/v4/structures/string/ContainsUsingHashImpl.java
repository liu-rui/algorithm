package liurui.v4.structures.string;

import liurui.defines.structures.string.ContainsUsingHash;

import java.util.HashSet;

/**
 * 判断字符串是否包含另一个字符串,使用散列表方式
 * 时间复杂度为O(M+N)
 * 空间复杂度为O(M)
 * M 为a串的长度
 * N为b串的长度
 */
public class ContainsUsingHashImpl implements ContainsUsingHash {
    @Override
    public boolean contains(String a, String b) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < a.length(); i++) {
            set.add(a.charAt(i));
        }

        for (int j = 0; j < b.length(); j++) {
            if (!set.contains(b.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
