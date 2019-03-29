package com.demo.ssjo.util;

import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lec
 * @Title: StringUtils
 * @Description: 时间日期工具类
 * @date 2019/1/15 17:01
 */
public class StrUtils {

	/**
	 * 校验手机号正则
	 */
	public static final Pattern PATTERN = Pattern.compile("^((17[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

	/**
	 * 确定指定的字符（Unicode代码点）是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * 生成uuid
	 * 
	 * @return
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	/**
	 * 判断字符是否为空，和是否在对应长度内
	 * 
	 * @param str
	 *            字符
	 * @param minLen
	 *            最小长度
	 * @param maxLen
	 *            最大长度
	 * @return true表示合法，false表示不合
	 */
	public static boolean checkLen(String str, int minLen, int maxLen) {
		boolean isOk = true;
		if (str == null || str.length() < minLen || str.length() > maxLen) {
			isOk = false;
		}
		return isOk;
	}

	/**
	 * 
	 * 生成加密
	 * 
	 * @param str
	 *            原始字符
	 * @return 加密字符
	 */
	public static String getEncodeStr(String str) {
		String encodeStr = str;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			encodeStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeStr;
	}

	/**
	 * 两次Md5加密
	 * @param userPass 密码
	 * @param pwdkey 密钥
	 * @return
	 */
	public static String twiceMd5Encode(String userPass, String pwdkey) {
		String str = ""+pwdkey+userPass;
		try {
			str = DigestUtils.md5DigestAsHex(DigestUtils.md5DigestAsHex(str.getBytes("utf-8")).getBytes("utf-8"));
			str = "###" + str;
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 字符串转换为Ascii(例A -> 65)
	 *
	 * @param value
	 * @return
	 */
	public static String stringToAscii(String value) {
		StringBuffer sbu = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i != chars.length - 1) {
				sbu.append((int) chars[i]).append(",");
			} else {
				sbu.append((int) chars[i]);
			}
		}
		return sbu.toString();

	}

	/**
	 * Ascii转换为字符串(例65 -> A)
	 *
	 * @param value
	 * @return
	 */
	public static String asciiToString(String value) {
		StringBuffer sbu = new StringBuffer();
		String[] chars = value.split(",");
		for (int i = 0; i < chars.length; i++) {
			sbu.append((char) Integer.parseInt(chars[i]));
		}
		return sbu.toString();
	}

	/**
	 * 验证是否为小写字母数字组合，并且由字母开头
	 *
	 * @param str
	 *            字符串参
	 * @return true验证通过，false验证失败
	 */
	public static boolean isCharOrNum(String str) {
		boolean flag = true;
		if (!isEmpty(str)) {
			int len = str.length();
			if (Character.isLowerCase(str.charAt(0)) && len > 1) {
				for (int i = 1; i < len; i++) {
					char ch = str.charAt(i);
					if (!Character.isDigit(ch) || !Character.isLowerCase(ch)) {
						flag = false;
						break;
					}
				}
			}
		}
		return flag;
	}

	/**
	 * 判断字符串是否为null或长度是否为0
	 *
	 * @param str
	 *            待验证字符串
	 * @return true表示字符串为空，false不为
	 */
	public static boolean isEmpty(String str) {
		boolean flag = false;
		if (str==null||"".equals(str.trim())){
			flag=true;
		}
		return flag;
	}

	/**
	 * 判断字符串是否为汉字
	 *
	 * @param str
	 *            字符
	 * @return true 是汉字，false非汉
	 */
	public static boolean isChinese(String str) {
		String regEx = "[\u4e00-\u9fa5]";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find()) {
			flg = true;
		}
		return flg;
	}

	/**
	 * 判断字符串是否满足范
	 *
	 * @param str
	 *            待验证字符串
	 * @param minLen
	 *            小长
	 * @param maxLen
	 *            大长
	 * @return true表示满足条件，false不满�?
	 */
	public static boolean isGoodLen(String str, int minLen, int maxLen) {
		boolean isOk = true;
		if (!isEmpty(str)) {
			int len = str.length();
			if (len < minLen || len > maxLen) {
				isOk = false;
			}
		} else {
			isOk = false;
		}
		return isOk;
	}

	/**
	 * 判断是否是手机号
	 *
	 * @param phone
	 * @return
	 */
	public static boolean isPhoneNO(String phone) {
		Matcher m = PATTERN.matcher(phone);
		return m.matches();
	}

	public static Integer stringInteger(String value) {
		Integer strInt = 0;
		if (value != null && !value.equals("") && !value.equals("0")) {
			if (value.indexOf(".") != -1) {
				strInt = Integer.parseInt(value.replace(".", ""));
			} else {
				strInt = Integer.parseInt(value + "00");
			}

		}
		return strInt;
	}

	public static String intergerSting(Integer value) {
		DecimalFormat df = new DecimalFormat("0.00");
		String str = df.format((float) value / 100);
		return str;
	}
}
