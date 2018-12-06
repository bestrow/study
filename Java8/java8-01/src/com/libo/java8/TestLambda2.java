package com.libo.java8;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * һ��Lambda ����ʽ�Ļ����﷨��Java8��������һ���µĲ�����"->"�ò�������Ϊ��ͷ��������Lambda������
 * 						��ͷ��������Lambda����ʽ��ֳ������֣�
 * ��ࣺLambda ����ʽ�Ĳ����б�
 * �ҲࣺLambda ����ʽ������ִ�еĹ��ܣ���Lambda��
 * 
 * �﷨��ʽһ���޲������޷���ֵ
 * 		() -> System.out.println("Hello Lambda!");
 * 
 * �﷨��ʽ������һ�������������޷���ֵ
 * 		(x) -> System.out.println(x);
 * 
 * �﷨��ʽ������ֻ��һ��������С���ſ���ʡ�Բ�д
 * 		x -> System.out.println(x);
 * 
 * �﷨��ʽ�ģ����������ϵĲ������з���ֵ������Lambda�����ж������
 * 			Comparator<Integer> comparator = (x,y) -> {
 *				System.out.println("����ʽ�ӿ�");
 *				return Integer.compare(x, y);
 *		    };
 *
 * �﷨��ʽ�壺��Lambda����ֻ��һ����䣬return�ʹ����Ŷ�����ʡ�Բ�д
 * 			Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
 * 
 * �﷨��ʽ����Lamdba ����ʽ�Ĳ����б����������Ϳ���ʡ�Բ�д����ΪJVM������ͨ���������ƶϳ����������ͣ����������ƶϡ�
 * 			(Integer x,Integer y) -> Integer.compare(x, y);
 * 
 * ������һ����ʡ
 * ����ƶ�����ʡ
 * 
 * ����Lambda ����ʽ��Ҫ������ʽ�ӿڡ���֧��
 * ����ʽ�ӿڣ��ӿ���ֻ��һ�����󷽷��Ľӿڣ���Ϊ����ʽ�ӿڡ�����ʹ��ע��@FunctionalInterface ����
 * 		        ���Լ���Ƿ��Ǻ���ʽ�ӿ�
 */
public class TestLambda2 {

	@Test
	public void test1() {
		int num = 0; // jdk 1.7ǰ��������final ����Ĭ�ϼ���final
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello World!"+num);
				
			}
		};
		r.run();
		
		System.out.println("--------------------------------");
		
		Runnable r1 = () -> System.out.println("Hello Lambda!");
		r1.run();
	}
	
	@Test
	public void test2() {
		Consumer<String> consumer = x -> System.out.println(x);
		consumer.accept("test");
	}
	
	@Test
	public void test3() {
		Comparator<Integer> comparator = (x,y) -> {
			System.out.println("����ʽ�ӿ�");
			return Integer.compare(x, y);
		};
	}
	
	@Test
	public void test4() {
		Comparator<Integer> comparator = (Integer x,Integer y) -> Integer.compare(x, y);
	}
}