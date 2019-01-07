package com.libo.java8;
/**
 * 一、Stream的三个操作步骤
 * 
 * 1.创建Stream
 * 
 * 2.中间操作
 * 
 * 3.终止操作（终端操作）
 * 
 * @author bestrow
 * @date 2018年12月30日
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.libo.exer.Employee;

public class TestStreamAPI2 {

	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999), 
			new Employee(102, "李四", 59, 6666),
			new Employee(103, "王五", 28, 3333), 
			new Employee(104, "赵六", 8, 7777),
			new Employee(105, "田七", 38, 5555),
			new Employee(105, "赵七", 38, 5555),
			new Employee(105, "田七", 38, 5555)
			);

	// 中间操作
	/**
	 * 排序
	 * sorted() - 自然排序
	 * sorted(Comparator com) - 定制排序
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
	 * 	映射
	 * map - 接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用 到每个元素上，并将其映射成一个新的元素
	 * flatMap - 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
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
	 * 	筛选与切片
	 * filter - 接收Lambda，从流中排除某些元素
	 * limit - 截断流，使其元素不超过给定数量
	 * skip(n) - 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补 
	 * distinct - 筛选，通过流所生成元素的hashCode()和equals()去除重复元素
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
	
	// 内部迭代：迭代操作由Stream API 完成
	@Test
	public void test1() {
		
		// 中间操作：不会执行任何操作
		Stream<Employee> stream = emps.stream()
				.filter((e) -> e.getAge() > 35);
		// 终止操作：一次性执行全部内容，即“堕性求值”
		stream.forEach(System.out::println);
	}
}
