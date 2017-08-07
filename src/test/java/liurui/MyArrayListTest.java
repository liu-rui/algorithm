package liurui;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MyArrayListTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MyArrayListTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MyArrayListTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        MyArrayList ary = new MyArrayList(2);

        ary.add(12);
        assertEquals(1,ary.getLen());
        assertEquals(2,ary.getSize());
        assertEquals(12, ary.get(0));

        ary.add(23);
        assertEquals(2,ary.getLen());
        assertEquals(4,ary.getSize());
        assertEquals(12, ary.get(0));
        assertEquals(23, ary.get(1));

        ary.remove();
        ary.add(40);
        assertEquals(2,ary.getLen());
        assertEquals(4,ary.getSize());
        assertEquals(12, ary.get(0));
        assertEquals(40, ary.get(1));
    }
}
