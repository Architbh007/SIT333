package activelearning;

import org.junit.Assert;
import org.junit.Test;

public class TestClass1 {

    // TESTS FOR add()

    @Test
    public void testAddZeroZero() {
        // Row 2: a=0, b=0 → zero, zero
        FirstTest obj = new FirstTest();
        int result = obj.add(0, 0);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testAddZeroNonzero() {
        // Row 3: a=0, b=2 → zero, non zero
        FirstTest obj = new FirstTest();
        int result = obj.add(0, 2);
        Assert.assertEquals(2, result);
    }

    @Test
    public void testAddNonzeroZero() {
        // Row 4: a=2, b=0 → non-zero, zero
        FirstTest obj = new FirstTest();
        int result = obj.add(2, 0);
        Assert.assertEquals(2, result);
    }

    @Test
    public void testAddNegativeZero() {
        // Row 5: a=-2, b=0 → negative, zero
        FirstTest obj = new FirstTest();
        int result = obj.add(-2, 0);
        Assert.assertEquals(-2, result);
    }

    @Test
    public void testAddZeroNegative() {
        // Row 6: a=0, b=-2 → zero, negative
        FirstTest obj = new FirstTest();
        int result = obj.add(0, -2);
        Assert.assertEquals(-2, result);
    }

    @Test
    public void testAddBigggNormal() {
        // Row 7: a=1.00E+50, b=2 → biggg, normal
        // BREAKING POINT
        // So we use Integer.MAX_VALUE to simulate
        FirstTest obj = new FirstTest();
        int result = obj.add(Integer.MAX_VALUE, 2);
        // BREAKS - overflows to negative!
        Assert.assertEquals(Integer.MIN_VALUE + 1, result);
    }

    @Test
    public void testAddNormalBiggg() {
        // Row 8: a=2, b=1.00E+50 → normal, biggg
        // BREAKING POINT
        // Same overflow issue
        FirstTest obj = new FirstTest();
        int result = obj.add(2, Integer.MAX_VALUE);
        // BREAKS - overflows to negative!
        Assert.assertEquals(Integer.MIN_VALUE + 1, result);
    }

    @Test
    public void testAddDecimalInt() {
        // Row 9: a=2.1, b=2 → decimal, int
        // BREAKING POINT
        // int cannot hold decimals
        // Java automatically cuts off decimal
        // 2.1 becomes 2 when cast to int
        FirstTest obj = new FirstTest();
        int result = obj.add((int) 2.1, 2);
        // 2.1 gets truncated to 2
        // so 2 + 2 = 4
        Assert.assertEquals(4, result);
    }

    @Test
    public void testAddIntDecimal() {
        // Row 10: a=2, b=2.1 → int, decimal
        // BREAKING POINT
        // 2.1 gets truncated to 2
        // so 2 + 2 = 4
        FirstTest obj = new FirstTest();
        int result = obj.add(2, (int) 2.1);
        Assert.assertEquals(4, result);
    }

    @Test
    public void testAddDecimalDecimal() {
        // Row 11: a=2.1, b=2.1 → decimal, decimal
        // BREAKING POINT
        // both decimals get truncated to 2
        // so 2 + 2 = 4  NOT 4.2!
        FirstTest obj = new FirstTest();
        int result = obj.add((int) 2.1, (int) 2.1);
        Assert.assertEquals(4, result);
    }

    @Test
    public void testAddBothNegative() {
        // a=-2, b=-2 → both negative
        FirstTest obj = new FirstTest();
        int result = obj.add(-2, -2);
        Assert.assertEquals(-4, result);
    }

    @Test
    public void testAddValidIntegersAboveZero() {
        // a=2, b=2 → normal, normal
        FirstTest obj = new FirstTest();
        int result = obj.add(2, 2);
        Assert.assertEquals(4, result);
    }

    // TESTS FOR concat()

    @Test
    public void testConcatSingleCharBoth() {
        // Row 2: a="0", b="0" → single char both
        FirstTest obj = new FirstTest();
        String result = obj.concat("0", "0");
        Assert.assertEquals("00", result);
    }

    @Test
    public void testConcatSingleCharEmptyChar() {
        // Row 3: a="0", b="" → single char, empty
        FirstTest obj = new FirstTest();
        String result = obj.concat("0", "");
        Assert.assertEquals("0", result);
    }

    @Test
    public void testConcatNullSingleChar() {
        // Row 4: a=null, b="0" → null, single char
        // BREAKING POINT
        // Java converts null to word "null"
        // null + "0" = "null0"
        FirstTest obj = new FirstTest();
        String result = obj.concat(null, "0");
        Assert.assertEquals("null0", result);
    }

    @Test
    public void testConcatSingleCharNull() {
        // Row 5: a="0", b=null → single char, null
        // BREAKING POINT!
        // "0" + null = "0null"
        FirstTest obj = new FirstTest();
        String result = obj.concat("0", null);
        Assert.assertEquals("0null", result);
    }

    @Test
    public void testConcatNullBoth() {
        // Row 6: a=null, b=null → null both
        // BREAKING POINT
        // null + null = "nullnull"
        FirstTest obj = new FirstTest();
        String result = obj.concat(null, null);
        Assert.assertEquals("nullnull", result);
    }

    @Test
    public void testConcatNormalStrings() {
        // normal strings
        FirstTest obj = new FirstTest();
        String result = obj.concat("Hello", "World");
        Assert.assertEquals("HelloWorld", result);
    }

    @Test
    public void testConcatEmptyBoth() {
        // both empty strings
        FirstTest obj = new FirstTest();
        String result = obj.concat("", "");
        Assert.assertEquals("", result);
    }
}