package rail;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TripListTests {

	@Test
	public void test() {
		Triplist test= new Triplist();
		boolean output = test.timeCheck("11:30", "12:25");
		assertEquals(true, output);
	}
	@Test
	public void test1() {
		Triplist test= new Triplist();
		boolean output = test.timeCheck("12:27", "12:25");
		assertEquals(false, output);
	}
	
}
