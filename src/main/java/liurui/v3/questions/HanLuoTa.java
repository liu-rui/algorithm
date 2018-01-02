package liurui.v3.questions;

public class HanLuoTa {

    public static void move(int sum, char a, char b, char c) {
        if (sum == 1) {
            move(a, c);
            return;
        }

        move(sum - 1, a, c, b);
        move(a, c);
        move(sum - 1, b, a, c);
    }

    public static void move(char a, char b) {
        System.out.printf("%c -> %c\n", a, b);
    }

    public static void main(String[] args) {
        move(3, 'a', 'b', 'c');
    }
}
