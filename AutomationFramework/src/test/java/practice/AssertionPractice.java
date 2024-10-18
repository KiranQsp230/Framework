package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void sample() {

		// Hard Assert
//		System.out.println("Test1");
//		System.out.println("Test2");
//		Assert.assertEquals(false, true);
//		System.out.println("Test3");
//		System.out.println("Test4");

		// Soft Assert
		System.out.println("Test1");
		System.out.println("Test2");
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(false, true);
	    System.out.println("Test3");
		System.out.println("Test4");
		softassert.assertAll();
	}

}
