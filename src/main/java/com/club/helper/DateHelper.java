package com.club.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateHelper {

	/**
	 * 字符串转时间
	 * @return
	 */
	public static Date StringToDate(String parse,String dataStr){
		SimpleDateFormat formatter = new SimpleDateFormat(parse);
		Date date = null;
	    try {
	        date = (Date) formatter.parse(dataStr);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return date;
	}
	/**
	 * 时间转字符窜
	 * @return
	 */
	public static String DataToString (String parse,Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(parse);
        String format = sdf.format(date);
        return format;
	}
	
	public static int caculateTotalTime(Date startTime,Date endTime) {
        Long l = 0L;
        try {
            long sTime = startTime.getTime();
            long  eTime= endTime.getTime();

            l = (eTime - sTime) / (1000 * 60 * 60 * 24);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return l.intValue();
	}
}
