package liurui.questions;

/***
 *  汉诺塔问题
 */
public class HanLuoTa {

    private void move(int sum, char a, char b, char c) {
        if(sum == 1){
            move(a,c);
            return;
        }

        move(sum-1 , a,c,b);
        move(a,c);
        move(sum-1 , b,a,c);
    }

    private void move(char a, char c) {
        System.out.println(String.format("%c -> %c" , a , c));
    }


    public static void main(String[] args) {
        HanLuoTa hanLuoTa = new HanLuoTa();

        hanLuoTa.move(3,'a','b','c');
    }
}
