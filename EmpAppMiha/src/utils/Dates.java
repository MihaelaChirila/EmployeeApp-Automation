package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dates {
   public static String GetCurrentTime() {
	   Date date = Calendar.getInstance().getTime();
	   DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
	   return formatter.format(date);
   }
}
