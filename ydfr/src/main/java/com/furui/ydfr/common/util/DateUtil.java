package com.furui.ydfr.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 时间工具类
 */
public class DateUtil {
	
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat monthformat = new SimpleDateFormat("yyyy-MM");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat dateFormatLongfor = new SimpleDateFormat("yyyy年MM月");
    private static final SimpleDateFormat datetimeFormatLong = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat datetimeFormatMin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * 获得当前月 
     * @return
     */
    public static String currentMonth(){
        return monthformat.format(now());
    }
    /**
     * 获得当前月 
     * @param timestamp Long类型
     * @return
     */
    public static String formatMonth(Long timestamp){
        return monthformat.format(timestamp);
    }
	 /**
	 * 获取当前时间戳
	 * @return
	 */
	public static int getTimestamp() {
		return Integer.parseInt(String.valueOf(System.currentTimeMillis() / 1000));
	}
    /**
     * 获得当前日期时间
     * <p>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String currentDatetime() {
        return datetimeFormat.format(now());
    }
    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     * @param date
     * @return
     */
    public static String formatDatetimeMi(Date date){
    	return datetimeFormatMin.format(date);
    }
    /**
     * 格式化日期时间
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDatetime(Date date) {
        return datetimeFormat.format(date);
    }
    /**
     * 日期类型yyyyMMddHHmmss
     * @return
     */
    public static String formatDatetimeYYYYMMDDHHMMSS() {
        return datetimeFormatLong.format(now());
    }
    /**
     * 格式化日期时间
     * @param date
     * @param pattern 格式化模式，详见{@link java.text.SimpleDateFormat}构造器 <code>SimpleDateFormat(String pattern)</code>
     * @return
     */
    public static String formatDatetime(Date date, String pattern) {
        SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat.clone();
        customFormat.applyPattern(pattern);
        return customFormat.format(date);
    }
    /**
     * 获得当前日期
     * <p>
     * 日期格式yyyy-MM-dd
     * 
     * @return
     */
    public static String currentDate() {
        return dateFormat.format(now());
    }
    /**
     * 格式化日期
     * <p>
     * 日期格式yyyy-MM-dd
     * 
     * @return
     */
    public static String formatDate(Date date) {
        return dateFormat.format(date);
    }
    /**
     * 获得当前时间
     * 时间格式HH:mm:ss
     * @return
     */
    public static String currentTime() {
        return timeFormat.format(now());
    }

    /**
     * 格式化时间
     * 时间格式HH:mm:ss
     * @return
     */
    public static String formatTime(Date date) {
        return timeFormat.format(date);
    }

    /**
     * 获得当前时间的<code>java.util.Date</code>对象
     * @return
     */
    public static Date now() {
        return new Date();
    }

    public static Calendar calendar() {
        Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        return cal;
    }
    /**
     * 获得当前时间的毫秒数
     * 详见{@link System#currentTimeMillis()}
     * @return
     */
    public static long millis() {
        return System.currentTimeMillis();
    }
    /**
     * 
     * 获得当前Chinese月份
     * @return
     */
    public static int month() {
        return calendar().get(Calendar.MONTH) + 1;
    }
    /**
     * 获得月份中的第几天
     * @return
     */
    public static int dayOfMonth() {
        return calendar().get(Calendar.DAY_OF_MONTH);
    }
    /**
     * 今天是星期的第几天
     * @return
     */
    public static int dayOfWeek() {
        return calendar().get(Calendar.DAY_OF_WEEK);
    }
    /**
     * 今天是年中的第几天
     * @return
     */
    public static int dayOfYear() {
        return calendar().get(Calendar.DAY_OF_YEAR);
    }
    /**
     * 判断原日期是否在目标日期之前
     * @param src
     * @param dst
     * @return
     */
    public static boolean isBefore(Date src, Date dst) {
        return src.before(dst);
    }
    /**
     * 判断原日期是否在目标日期之后
     * @param src
     * @param dst
     * @return
     */
    public static boolean isAfter(Date src, Date dst) {
        return src.after(dst);
    }
    /**
     * 判断两日期是否相同
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEqual(Date date1, Date date2) {
        return date1.compareTo(date2) == 0;
    }
    /**
     * 判断某个日期是否在某个日期范围
     * @param beginDate 日期范围开始
     * @param endDate 日期范围结束
     * @param src 需要判断的日期
     * @return
     */
    public static boolean between(Date beginDate, Date endDate, Date src) {
        return beginDate.before(src) && endDate.after(src);
    }

    /**
     * 获得当前月的最后一天
     * HH:mm:ss为0，毫秒为999
     * @return
     */
    public static Date lastDayOfMonth() {
        Calendar cal = calendar();
        cal.set(Calendar.DAY_OF_MONTH, 0); // M月置零
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
        cal.set(Calendar.MINUTE, 0);// m置零
        cal.set(Calendar.SECOND, 0);// s置零
        cal.set(Calendar.MILLISECOND, 0);// S置零
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1
        cal.set(Calendar.MILLISECOND, -1);// 毫秒-1
        return cal.getTime();
    }

    /**
     * 获得当前月的第一天
     * HH:mm:ss SS为零
     * @return
     */
    public static Date firstDayOfMonth() {
        Calendar cal = calendar();
        cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
        cal.set(Calendar.MINUTE, 0);// m置零
        cal.set(Calendar.SECOND, 0);// s置零
        cal.set(Calendar.MILLISECOND, 0);// S置零
        return cal.getTime();
    }
    /**
     * 获得周五日期
     * <p>
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
     * @return
     */
    public static Date friday() {
        return weekDay(Calendar.FRIDAY);
    }
    private static Date weekDay(int week) {
    	Calendar cal = calendar();
    	cal.set(Calendar.DAY_OF_WEEK, week);
    	return cal.getTime();
    }
    /**
     * 获得周六日期
     * <p>
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
     * 
     * @return
     */
    public static Date saturday() {
        return weekDay(Calendar.SATURDAY);
    }
    /**
     * 获得周日日期
     * <p>
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
     * 
     * @return
     */
    public static Date sunday() {
        return weekDay(Calendar.SUNDAY);
    }

    /**
     * 将字符串日期时间转换成java.util.Date类型
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * @param datetime
     * @return
     */
    public static Date parseDatetime(String datetime) throws ParseException {
        return datetimeFormat.parse(datetime);
    }
    /**
     * 将字符串日期转换成java.util.Date类型
     * 日期时间格式yyyy-MM-dd
     * @param date
     * @return
     * @throws java.text.ParseException
     */
    public static Date parseDate(String date) {
        try {
            return dateFormat.parse(date);
        } catch (Exception e) {
            try{
                return dateFormatLongfor.parse(date);
            }catch (Exception e1){
                e.printStackTrace();
                e1.printStackTrace();
            }
            return null;
        }
    }

    public static Date parseMonthDate(String date){
        try {
            return monthformat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字符串日期转换成java.util.Date类型
     * 时间格式 HH:mm:ss
     * @param time
     * @return
     * @throws java.text.ParseException
     */
    public static Date parseTime(String time) throws ParseException {
        return timeFormat.parse(time);
    }
    /**
     * 根据自定义pattern将字符串日期转换成java.util.Date类型
     * @param datetime
     * @param pattern
     * @return
     * @throws java.text.ParseException
     */
    public static Date parseDatetime(String datetime, String pattern) throws ParseException {
        SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();
        format.applyPattern(pattern);
        return format.parse(datetime);
    }

    /**
     * 获取当前系统时间
     * <p>
     * 自定义格式
     * 
     * @param pattern
     * @return
     * @throws java.text.ParseException
     */
    public static String currDate(String pattern) throws ParseException {
        return formatDatetime(new Date(), pattern);
    }

    /**
     * 获取当前系统时间
     * <p>
     * 简单格式 yyyy-MM-dd
     * 
     * @return
     * @throws java.text.ParseException
     */
    public static String currDate() throws ParseException {
        return formatDatetime(new Date(), "yyyy-MM-dd");
    }

    public static Long convertString2Long(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertLong2String(Long date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.format(new Date(date));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String addOneDay(String dt) throws Exception {
        return addOneDay(dt, "yyyy-MM-dd");
    }

    public static String addOneDay(String dt, String ptn) throws Exception {
        return addOneDay(dt, ptn, 1);
    }

    public static String addOneDay(String dt, String ptn, int num) throws Exception {
        Date date = (new SimpleDateFormat(ptn)).parse(dt);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, num);
        return (new SimpleDateFormat(ptn)).format(cal.getTime());
    }
    
    public static String addOneWeek(String dt, String ptn) throws Exception {
        Date date = (new SimpleDateFormat(ptn)).parse(dt);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 7);
        return (new SimpleDateFormat(ptn)).format(cal.getTime());
    }

    public static String subOneDay(String dt) throws Exception {
        return subOneDay(dt, "yyyy-MM-dd");
    }

    public static String subOneDay(String dt, String ptn) throws Exception {
        Date date = (new SimpleDateFormat(ptn)).parse(dt);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        return (new SimpleDateFormat(ptn)).format(cal.getTime());
    }

    /**
     * 日期加减操作
     * 
     * @param currentDate 当前日期
     * @param days
     * @return
     */
    public static String getSpecifiedDayBefore(String currentDate, int days) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + days);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }
    
    /**
     * 求时间差
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getDiffBetweenTwoDay(long startTime,long endTime){
    	
    	int result = 0;
    	double day = (double)(endTime-startTime)/150/1000; 
    	result = (int)day;
    	return result;
    }
    /**
     * 两个时间差几天
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getBetweenTwoDay(long startTime,long endTime){
    	
    	int result = 0;
    	double day = (double)(endTime-startTime)/3600/1000/24; 
    	result = (int)day;
    	return result;
    }
    /**
     * 时间戳转字符串
     * @param time
     * @return
     */
    public static String dateLong2Str(long time){
        if(time == 0){
            return "";
        }
    	return datetimeFormat.format(new Date(time));  
    }

    /**
     * 获得本周一0点时间
     * @return
     */
    public static Date getThisMonday() {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }
    public static Date dateLong2Date(long time){
    	return new Date(time);  
    }
    /**
     *  获取两个小时后的时间戳
     * @return
     */
    public static Long getTwoHoursLater(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR)+2);
        System.out.println(calendar.getTime());
        return calendar.getTimeInMillis();
    }
    /**
     * date2比date1多的天数
     * @param date1    
     * @param date2
     * @return    
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
    
    
    /**
     * 将毫秒数更改为当天零点的毫秒数
     * @param date1    
     * @return    
     */
    public static Long setZeroTime(Long millis){
    	
		Calendar cal = Calendar.getInstance();
		
		cal.setTimeInMillis(millis);
		
		cal.set(Calendar.HOUR, 0);  
		cal.set(Calendar.MINUTE, 0);  
		cal.set(Calendar.SECOND, 0);  
		cal.set(Calendar.MILLISECOND, 0);
    	
		return cal.getTimeInMillis();
    }
    
    /**
     * 得到本周周一
     * 
     * @return yyyy-MM-dd
     */
    public static String getMondayOfThisWeek() {
     Calendar c = Calendar.getInstance();
     
     int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
     
     if (day_of_week == 0)
    	 day_of_week = 7;
     
     c.add(Calendar.DATE, -day_of_week + 1);
     return dateFormat.format(c.getTime());
    }
    
    /**
     * 得到本周周日
     * 
     * @return yyyy-MM-dd
     */
    public static String getSundayOfThisWeek() {
     Calendar c = Calendar.getInstance();
     int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
     if (day_of_week == 0)
      day_of_week = 7;
     c.add(Calendar.DATE, -day_of_week + 7);
     return dateFormat.format(c.getTime());
    }
    
}
