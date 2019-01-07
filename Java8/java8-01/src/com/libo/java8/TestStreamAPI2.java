package com.libo.java8;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.libo.exer.Employee;

public class TestStreamAPI2 {

	List<Employee> emps = Arrays.asList(
			new Employee(101, "����", 18, 9999), 
			new Employee(102, "����", 59, 6666),
			new Employee(103, "����", 28, 3333), 
			new Employee(104, "����", 8, 7777),
			new Employee(105, "����", 38, 5555),
			new Employee(105, "����", 38, 5555),
			new Employee(105, "����", 38, 5555)
			);

	// �м����
	/**
	 * ����
	 * sorted() - ��Ȼ����
	 * sorted(Comparator com) - ��������
	 */
	@Test
	public void test6() {
		List<String> list = Arrays.asList("ccc","aaa","bbb","ddd","eee");
		list.stream()
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		emps.stream()
			.sorted((e1,e2) -> {
				if (e1.getAge() == e2.getAge()) {
					return e1.getName().compareTo(e2.getName());
				}else {
					return e1.getAge()-e2.getAge();
				}
			})
			.forEach(System.out::println);

	}
	
	
	/**
	 * 	ӳ��
	 * map - ����Lambda����Ԫ��ת����������ʽ����ȡ��Ϣ������һ��������Ϊ�������ú����ᱻӦ�� ��ÿ��Ԫ���ϣ�������ӳ���һ���µ�Ԫ��
	 * flatMap - ����һ��������Ϊ�����������е�ÿ��ֵ��������һ������Ȼ������������ӳ�һ����
	 */
	@Test
	public void test5() {
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		list.stream()
			.map((str) -> str.toUpperCase())
			.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		emps.stream()
			.map(Employee::getName)
			.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		/*Stream<Stream<Character>> stream = list.stream()
			.map(TestStreamAPI2::filterCharacter);
		stream.forEach((sm) -> {
			sm.forEach(System.out::println);
		});*/
		Stream<Character> stream = list.stream()
									   .flatMap(TestStreamAPI2::filterCharacter);
		stream.forEach(System.out::println);
	}
	
	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		return list.stream();
	}
	
	/**
	 * 	ɸѡ����Ƭ
	 * filter - ����Lambda���������ų�ĳЩԪ��
	 * limit - �ض�����ʹ��Ԫ�ز�������������
	 * skip(n) - ����Ԫ�أ�����һ���ӵ���ǰn��Ԫ�ص�����������Ԫ�ز���n�����򷵻�һ����������limit(n)���� 
	 * distinct - ɸѡ��ͨ����������Ԫ�ص�hashCode()��equals()ȥ���ظ�Ԫ��
	 */
	
	@Test
	public void test4() {
		emps.stream()
		.filter((e) -> e.getSalary() >5000)
		.distinct()
		.forEach(System.out::println);
	}
	
	@Test
	public void test3() {
		emps.stream()
		.filter((e) -> e.getSalary() >5000)
		.skip(2)
		.forEach(System.out::println);
	}
	
	@Test
	public void test2() {
		emps.stream()
			.filter((e) -> e.getSalary() >5000)
			.limit(2)
			.forEach(System.out::println);
	}
	
	// �ڲ�����������������Stream API ���
	@Test
	public void test1() {
		
		// �м����������ִ���κβ���
		Stream<Employee> stream = emps.stream()
				.filter((e) -> e.getAge() > 35);
		// ��ֹ������һ����ִ��ȫ�����ݣ�����������ֵ��
		stream.forEach(System.out::println);
	}
}
