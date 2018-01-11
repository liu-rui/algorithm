package liurui.defines.questions;

import liurui.v4.questions.ExchangeImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExchangeTest {
    @Test
    public void test() {
        Exchange item = new ExchangeImpl();
        assertArrayEquals(new int[]{56, 78}, item.exec(new int[]{78, 56}));
    }
}
