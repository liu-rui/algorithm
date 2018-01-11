package liurui.defines.questions;

import liurui.v4.questions.MaxNumberImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxNumberTest {
    @Test
    public void test() {
        MaxNumber item = new MaxNumberImpl();

        assertEquals(45, item.find(new int[]{23, 45}));
        assertEquals(45, item.find(new int[]{45, 12}));
    }
}
