package spring.di.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTime {
	SimpleDateFormat format = new SimpleDateFormat("HH");
	Date time = new Date();
	
	String nowTime = format.format(time);

}
