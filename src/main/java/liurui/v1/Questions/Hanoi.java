package liurui.v1.Questions;

/***
 *  汉诺塔问题
 */
public class Hanoi {

    public static void hanno(int n, char a, char b, char c) {
        if(  n  == 1 ){
            move(a, c );
            return;
        }

        hanno(n-1 ,  a,  c ,b );
        move(a , c );
        hanno(n-1 , b ,a ,c );
    }

    public static void move(char a, char c) {
        System.out.println(String.format("%s -> %s", a, c));
    }


    public static void main(String[] args) {
        hanno(3, 'a' , 'b' , 'c');
    }
}
