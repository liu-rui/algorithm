package liurui.standard.questions;

import liurui.defines.questions.HanLuoTa;

import java.util.ArrayList;

public class HanLuoTaImpl implements HanLuoTa {

    @Override
    public String[] move(int sum, char a, char b, char c) {
        ArrayList<String> messages = new ArrayList<>();

        move(messages, sum, a, b, c);
        return messages.toArray(new String[0]);
    }

    private void move(ArrayList<String> messages, int sum, char a, char b, char c) {
        if (sum == 1) {
            messages.add(move(a, c));
            return;
        }
        move(messages, sum - 1, a, c, b);
        messages.add(move(a, c));
        move(messages, sum - 1, b, a, c);
    }

    private String move(char a, char c) {
        return String.format("%c -> %c", a, c);
    }
}
