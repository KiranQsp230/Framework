package practice;

import java.util.Arrays;
import java.util.Date;

public class ToLearnSystemDate {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d);
		String date[]= d.toString().split(" ");
		System.out.println(date.length);
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		System.out.println(Arrays.toString(date));
         String data=day+" "+month+" "+date1+" "+time+" "+year;
         System.out.println(data);
	}

}
