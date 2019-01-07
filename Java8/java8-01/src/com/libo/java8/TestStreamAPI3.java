package com.libo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.libo.exer.Employee;
import com.libo.exer.Employee.Status;

/**
 * 	终止操作
 * @author bestrow
 * @date 2018年12月30日
 */
public class TestStreamAPI3 {

	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999, Status.FREE),
			new Employee(102, "李四", 59, 6666, Status.BUSY), 
			new Employee(103, "王五", 28, 3333, Status.VOCATION),
			new Employee(104, "赵六", 8, 7777, Status.FREE),
			new Employee(105, "田七", 38, 5555, Status.BUSY)
			);

	/**
	 * 	规约
	 * 	reduce(T identity,BinaryOperator) / reduce(BinaryOperator) - 可以将流中元素反复结合起来，得到一个值
	 */
	@Test
	public void test2(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer sum = list.stream()
			.reduce(0, (x,y) -> x+y);
		System.out.println(sum);
		
		System.out.println("-----------------");
		Optional<Double> op = emps.stream()
			.map((e) -> e.getSalary())
			.reduce(Double::sum);
		System.out.println(op.get());
	}
	
	/**
	 *	 查找与匹配
	 * allMatch - 检查是否匹配所有元素
	 * anyMatch - 检查是否至少匹配一个元素
	 * noneMatch - 检查是否没有匹配所有元素
	 * findFirst - 返回第一个元素
	 * findAny - 返回当前流中的任意元素
	 * count - 返回流中元素的总个数
	 * max - 返回流中最大值
	 * min - 返回流中最小值
	 */
	@Test
	public void test1() {
		boolean b1 = emps.stream()
				.allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);

		System.out.println("-------------------------------");
		boolean b2 = emps.stream()
				.anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b2);

		System.out.println("-------------------------------");
		boolean b3 = emps.stream()
				.noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b3);

		System.out.println("-------------------------------");
		Optional<Employee> op = emps.stream()
				.sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
				.findFirst();
		System.out.println(op.get());

		System.out.println("-------------------------------");
		Optional<Employee> op2 = emps.parallelStream()
				.filter((e) -> e.getStatus().equals(Status.FREE))
				.findAny();
		System.out.println(op2.get());

		System.out.println("-------------------------------");
		long count = emps.stream()
				.count();
		System.out.println(count);

		System.out.println("-------------------------------");
		Optional<Employee> op3 = emps.stream()
				.max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(op3.get());

		System.out.println("-------------------------------");
		Optional<Double> min = emps.stream()
				.map(Employee::getSalary)
				.min(Double::compare);
		System.out.println(min.get());
	}
	
}
