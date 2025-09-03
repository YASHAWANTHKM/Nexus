package JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtilityClass {

	SimpleDateFormat sdf;

	// for random number
	public int getRandomNumber() {
		Random random = new Random();

		int randomnum = random.nextInt(10000);
		return randomnum;
	}

	
}
