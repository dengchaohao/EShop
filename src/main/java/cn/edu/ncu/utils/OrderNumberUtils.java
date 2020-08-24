package cn.edu.ncu.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.UUID;

/**
 * 订单号的工具类
*/
public class OrderNumberUtils {
	
	/**
	 * 使用随机数生成18位唯一订单号
	*/
	public static String generate18BitOrderNumber() {
		//String orderNumber = RandomStringUtils.random(18, "abcdefghijklmnopqrstuvwxyz1234567890");
		String orderNumber = RandomStringUtils.random(18, "1234567890");
		return orderNumber;
	}
	
	/**
	 * 使用UUID生成16位唯一订单号
	*/
	public static String generate16BitOrderNumber() {
        int first = new Random(10).nextInt(8) + 1;
        int hashCode = UUID.randomUUID().toString().hashCode();
        if (hashCode < 0) { //有可能是负数
        	hashCode = - hashCode;
        }
        //0代表前面补充0
        //4代表长度为4
        //d代表参数为正数型
        return first + String.format("%015d", hashCode);
    }
	
	/**
	 * 使用随机数生成12位唯一订单号
	*/
	public static String generate12BitOrderNumber() {
		//String orderNumber = RandomStringUtils.random(12, "abcdefghijklmnopqrstuvwxyz1234567890");
		String orderNumber = RandomStringUtils.random(12, "1234567890");
		return orderNumber;
	}
	
	/**
	 * 使用随机数生成10位唯一订单号
	*/
	public static String generate10BitOrderNumber() {
		//String orderNumber = RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz1234567890");
		String orderNumber = RandomStringUtils.random(10, "1234567890");
		return orderNumber;
	}
	
	/**
	 * 使用随机数生成8位唯一订单号
	*/
	public static String generate8BitOrderNumber() {
		String orderNumber = RandomStringUtils.random(8, "abcdefghijklmnopqrstuvwxyz1234567890");
		return orderNumber;
	}
	
	/**
	 * 使用随机数生成6位唯一订单号
	*/
	public static String generate6BitOrderNumber() {
		String orderNumber = RandomStringUtils.random(6, "abcdefghijklmnopqrstuvwxyz1234567890");
		return orderNumber;
	}

}
