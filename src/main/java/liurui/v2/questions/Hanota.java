package liurui.v2.questions;

/***
 *  汉诺塔问题
 */
public class Hanota {

    public static void main(String[] args) {
        han(3, 'a', 'b', 'c');
    }

    private static void han(int i, char a, char b, char c) {
        if (i == 1) {
            move(a, c);
            return;
        }

        han(i - 1, a, c, b);
        move(a, c);
        han(i - 1, b, a, c);
    }

    private static void move(char a, char c) {
        System.out.println(String.format("%s -> %s", a, c));
    }
}
