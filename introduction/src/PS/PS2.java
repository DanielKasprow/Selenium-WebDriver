package PS;

public class PS2 extends PS3{
	int a;
	
	public PS2(int a) {
		super(a);
		this.a = a;
	}

	public int increment() {
		// TODO Auto-generated method stub
		a = a+1;
		return a;
	}
	
	public int decrement() {
		// TODO Auto-generated method stub
		a = a+-1;
		return a;
	}
}
