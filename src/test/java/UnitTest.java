import junit.framework.Assert;

public class UnitTest {

    @org.junit.Test
    public void test1() {
        Hello hello = new Hello();
        Assert.assertEquals(1, hello.i);
    }

    @org.junit.Test
    public void test2() {
        Hello hello = new Hello();
        Assert.assertEquals(2, hello.i);
    }
}
