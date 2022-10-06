package JavaAssignments;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class BestMobileNumberTest {

	BestMobileNumber p= new BestMobileNumber();
	List<Long> nums = new ArrayList<>();
	
	@Test
	public void test() {
		
		
		
		nums.add(11111111111L);
		nums.add(7300422656L);
		int size=nums.size();
		assertEquals(0,BestMobileNumber.checkPhoneNumber(size, nums));
		
	
		
		nums.add(1212121212L);
		nums.add(9999999999L);
		nums.add(7300422656L);
		size=nums.size();
		
		
		assertEquals(0,BestMobileNumber.checkPhoneNumber(size, nums));
		
	
		nums.add(1000000000L);
		nums.add(7300422656L);
		size=nums.size();
		
		
		assertEquals(0,BestMobileNumber.checkPhoneNumber(size, nums));
		
	}
	
	
	

}
