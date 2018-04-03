//import static org.junit.Assert.*;
import junit.framework.TestCase;



public class FractionTest extends TestCase {

	private Fraction fc1, fc2;
	
	
	public static void setUpBeforeClass() throws Exception{
		System.out.println("Setup for all subsequent tests...");
		//setup
	}
	
	public void setUp() {
		System.out.println("\nsingle test setup:");

		fc1 = new Fraction(12,30);
		fc2 = new Fraction(-25,7);

		System.out.println(fc1);
		System.out.println(fc2);
	}

	public void testSimplify() {
		System.out.println("\ntestSimplify");
		fc1.Simplify();
		assertEquals(2, fc1.getNumerator());
		assertEquals(5, fc1.getDenominator());
		
		fc2.Simplify();
		assertEquals(-25, fc2.getNumerator());
		assertEquals(7, fc2.getDenominator());
	}

	public void ttestGetDenominator() {
		System.out.println("\ntestGetDenominator");
		int result = fc1.getDenominator();
		assertTrue("getDenominator() returned " + result + " instead of 30.", result == 30);
		result = fc2.getDenominator();
		assertEquals(7, result);
				
	}
	
	public void testSetDenominator() {
		
		System.out.println("\ntestSetDenominator");

		fc1.setDenominator(1);
		
		int result = fc1.getDenominator();
		assertTrue("getDenominator() returned " + result + " instead of 1.", result == 1);
		fc2.setNumerator(6);
		result = fc2.getNumerator();
		assertEquals(6, result);
	}
	
	public void testDivision() {
		
		System.out.println("\ntestDivision");
		try {
			fc1.div(fc2);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		assertEquals(-14, fc1.getNumerator());
		assertEquals(125, fc1.getDenominator());
	}
	
	public void testDivisionException(){
		
		System.out.println("\ntestDivisionException");
		fc2.setDenominator(0);
		try {
			fc1.div(fc2);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(e.getMessage().equals("Division by zero!"));
		}		
	}

	public void tearDown() {
		
		System.out.println("\nsingle test tearing down");
		fc1 = fc2 = null;
		System.out.println(fc1);
		System.out.println(fc2);
	}
	
	public static void tearDownAfterClass() throws Exception{
		System.out.println("\ntearing all down");
	}
}
