package com.libo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.libo.exer.Employee;
import com.libo.exer.Employee.Status;

/**
 * 	��ֹ����
 * @author bestrow
 * @date 2018��12��30��
 */
public class TestStreamAPI3 {

	List<Employee> emps = Arrays.asList(
			new Employee(101, "����", 18, 9999, Status.FREE),
			new Employee(102, "����", 59, 6666, Status.BUSY), 
			new Employee(103, "����", 28, 3333, Status.VOCATION),
			new Employee(104, "����", 8, 7777, Status.FREE),
			new Employee(105, "����", 38, 5555, Status.BUSY)
			);

	/**
	 * 	��Լ
	 * 	reduce(T identity,BinaryOperator) / reduce(BinaryOperator) - ���Խ�����Ԫ�ط�������������õ�һ��ֵ
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
	 *	 ������ƥ��
	 * allMatch - ����Ƿ�ƥ������Ԫ��
	 * anyMatch - ����Ƿ�����ƥ��һ��Ԫ��
	 * noneMatch - ����Ƿ�û��ƥ������Ԫ��
	 * findFirst - ���ص�һ��Ԫ��
	 * findAny - ���ص�ǰ���е�����Ԫ��
	 * count - ��������Ԫ�ص��ܸ���
	 * max - �����������ֵ
	 * min - ����������Сֵ
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
