package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224094385";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Archit Bhullar";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	
	@Test
	public void testFebruary28ShouldIncrementToFebruary29() {
		DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("testFebruary28ShouldIncrementToFebruary29 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testFebruary29ShouldIncrementToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("testFebruary29ShouldIncrementToMarch1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMarch1ShouldDecrementToFebruary29() {
		DateUtil date = new DateUtil(1, 3, 2024);
        System.out.println("testMarch1ShouldDecrementToFebruary29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMarch31ShouldIncrementToApril1() {
		DateUtil date = new DateUtil(31, 3, 2024);
        System.out.println("testMarch31ShouldIncrementToApril1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testApril1ShouldDecrementToMarch31() {
		DateUtil date = new DateUtil(1, 4, 2024);
        System.out.println("testApril1ShouldDecrementToMarch31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testApril30ShouldIncrementToMay1() {
		DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("testApril30ShouldIncrementToMay1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMay1ShouldDecrementToApril30() {
		DateUtil date = new DateUtil(1, 5, 2024);
        System.out.println("testMay1ShouldDecrementToApril30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMay31ShouldIncrementToJune1() {
		DateUtil date = new DateUtil(31, 5, 2024);
        System.out.println("testMay31ShouldIncrementToJune1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testJune1ShouldDecrementToMay31() {
		DateUtil date = new DateUtil(1, 6, 2024);
        System.out.println("testJune1ShouldDecrementToMay31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testJune30ShouldIncrementToJuly1() {
		DateUtil date = new DateUtil(30, 6, 2024);
        System.out.println("testJune30ShouldIncrementToJuly1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testJuly1ShouldDecrementToJune30() {
		DateUtil date = new DateUtil(1, 7, 2024);
        System.out.println("testJuly1ShouldDecrementToJune30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testJuly31ShouldIncrementToAugust1() {
		DateUtil date = new DateUtil(31, 7, 2024);
        System.out.println("testJuly31ShouldIncrementToAugust1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testAugust1ShouldDecrementToJuly31() {
		DateUtil date = new DateUtil(1, 8, 2024);
        System.out.println("testAugust1ShouldDecrementToJuly31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testAugust31ShouldIncrementToSeptember1() {
		DateUtil date = new DateUtil(31, 8, 2024);
        System.out.println("testAugust31ShouldIncrementToSeptember1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(9, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testSeptember1ShouldDecrementToAugust31() {
		DateUtil date = new DateUtil(1, 9, 2024);
        System.out.println("testSeptember1ShouldDecrementToAugust31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(8, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testSeptember30ShouldIncrementToOctober1() {
		DateUtil date = new DateUtil(30, 9, 2024);
        System.out.println("testSeptember30ShouldIncrementToOctober1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(10, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testOctober1ShouldDecrementToSeptember30() {
		DateUtil date = new DateUtil(1, 10, 2024);
        System.out.println("testOctober1ShouldDecrementToSeptember30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(9, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testOctober31ShouldIncrementToNovember1() {
		DateUtil date = new DateUtil(31, 10, 2024);
        System.out.println("testOctober31ShouldIncrementToNovember1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testNovember1ShouldDecrementToOctober31() {
		DateUtil date = new DateUtil(1, 11, 2024);
        System.out.println("testNovember1ShouldDecrementToOctober31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(10, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testNovember30ShouldIncrementToDecember1() {
		DateUtil date = new DateUtil(30, 11, 2024);
        System.out.println("testNovember30ShouldIncrementToDecember1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testDecember1ShouldDecrementToNovember30() {
		DateUtil date = new DateUtil(1, 12, 2024);
        System.out.println("testDecember1ShouldDecrementToNovember30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testDecember31ShouldIncrementToJanuary1NextYear() {
		DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("testDecember31ShouldIncrementToJanuary1NextYear > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
	}
}