package PS;

import org.testng.annotations.Test;

public class PS1 extends PS{
	
	
	@Test
	public void testRun() {
		// TODO Auto-generated method stub
		PS2 ps2 = new PS2(3);
		int a = 3;
		doThis();
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());
		System.out.println(ps2.multiplyThree());
	}
}
