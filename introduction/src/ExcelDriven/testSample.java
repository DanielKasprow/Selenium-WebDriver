package ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dataDriven d = new dataDriven();
		ArrayList data = d.getData("Add Profile");
		
		System.out.println(data.get(2));
	}

}
