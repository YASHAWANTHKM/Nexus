package JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilityClass {

	SimpleDateFormat sdf;

	// for random number
	public int getRandomNumber(int num) {
		Random random = new Random();

		int randomnum = random.nextInt(num);
		return randomnum;
	}

	// for system date
	public String getSystemDateYYYYDDMM() {
		Date dateobj = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		return date;
	}

	public String getRequiredDateYYYYDDMM(int days) {
		Calendar cal = sdf.getCalendar();

		cal.add(Calendar.DAY_OF_MONTH, days);

		String reqDate = sdf.format(cal.getTime());

		return reqDate;

	}

}
