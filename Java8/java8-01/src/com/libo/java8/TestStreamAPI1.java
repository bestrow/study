package com.libo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.libo.exer.Employee;

/**
 * һ��Stream��������������
 * 
 * 1.����Stream
 * 
 * 2.�м����
 * 
 * 3.��ֹ�������ն˲�����
 * 
 * @author bestrow
 * @date 2018��12��30��
 */
public class TestStreamAPI1 {

	// ����Stream
	@Test
	public void test1() {
		// 1.����ͨ��Collection ϵ�м����ṩ��stream()[������]  ��parallelStreamI()[������]
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();

		// 2.ͨ��Arrays �еľ�̬����Stream() ��ȡ������
		Employee[] emps = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(emps);

		// 3.ͨ��Stream���еľ�̬���� of()
		Stream<String> stream3 = Stream.of("aa", "bb", "cc");

		// 4.����������
		// 4.1����
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
//		stream4.forEach(System.out::println);
		stream4.limit(10).forEach(System.out::println);
		
		// 4.2����
		Stream.generate(() -> Math.random());
	}
}
