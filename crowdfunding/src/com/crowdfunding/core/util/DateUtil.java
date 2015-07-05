package com.crowdfunding.core.util;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * @author wxliu
 */
public class DateUtil {
	private static Map<String, DateFormat> FormatterPool = new HashMap<String, DateFormat>();
	private static String STANDARD_FORMAT = "yyyy-MM-dd";
	private static String STANDARD_FORMAT_CN = "yyyy年MM月dd日";
	private static String YMDHMS_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static String YMDHMS_FORMAT_CN = "yyyy年MM月dd日 HH时mm分ss秒";

	private static SimpleDateFormat standard_format = new SimpleDateFormat(
			STANDARD_FORMAT);
	private static SimpleDateFormat standard_format_cn = new SimpleDateFormat(
			STANDARD_FORMAT_CN);
	private static SimpleDateFormat ymdhms_format = new SimpleDateFormat(
			YMDHMS_FORMAT);
	private static SimpleDateFormat ymdhms_format_cn = new SimpleDateFormat(
			YMDHMS_FORMAT_CN);

	/**
	 * 字符串格式化日期
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parse(String dateStr, SimpleDateFormat format) {
		if (dateStr == null) {
			return null;
		}
		try {
			SimpleDateFormat _format = format == null ? standard_format
					: format;
			return _format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 日期格式化字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, SimpleDateFormat format) {
		if (date == null) {
			return null;
		}
		try {
			SimpleDateFormat _format = format == null ? standard_format
					: format;
			return _format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 字符串格式化日期
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parse(String dateStr, String format) {
		if (dateStr == null) {
			return null;
		}
		try {
			SimpleDateFormat _format = StringUtils.isBlank(format) ? standard_format
					: new SimpleDateFormat(format);
			return _format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 日期格式化字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, String format) {
		if (date == null) {
			return null;
		}
		try {
			SimpleDateFormat _format = StringUtils.isBlank(format) ? standard_format
					: new SimpleDateFormat(format);
			return _format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 获取n天之后的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		return date == null ? null : DateUtils.addDays(date, days);
	}

	/**
	 * 时间格式化
	 * 
	 * @param pattern
	 * @param time
	 * @return
	 */
	public static String formatTime(String pattern, Date time) {
		return getFormatter(pattern).format(time);
	}

	/**
	 * 获取格式化formatter
	 * 
	 * @param pattern
	 * @return
	 */
	private static DateFormat getFormatter(String pattern) {
		DateFormat df = FormatterPool.get(pattern);
		if (df == null) {
			df = new SimpleDateFormat(pattern);
			FormatterPool.put(pattern, df);
		}
		return df;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date getCurrentTime() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 获取当前时间
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentTime(String pattern) {
		return formatTime(pattern, DateUtil.getCurrentTime());
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(addDays(new Date(), 2));
		System.out.println(DateUtils.add(new Date(), Calendar.DAY_OF_MONTH, 1));
	}
}
