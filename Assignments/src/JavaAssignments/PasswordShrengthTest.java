package JavaAssignments;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordShrengthTest {

	@Test
	public void test() {
	String s="Bharu@2349";
	PasswordShrength  pc=new PasswordShrength ();
	assertEquals(23, pc.checker(s));
			
	}
	
	@Test
	public void testlower() {
		String s="fhlrrll";
		PasswordShrength  pc=new PasswordShrength ();
		assertEquals(true, pc.lowerC(s));
		
	}
	
	
	@Test
	public void testupper() {
		String s="GHJUG";
		PasswordShrength  pc=new PasswordShrength ();
		assertEquals(true, pc.upperC(s));
		
	}
	
	@Test
	public void testnumber() {
		char ch='1';
		PasswordShrength  pc=new PasswordShrength ();
		assertEquals(true, pc.isNumber(ch));
		
	}
	

}
