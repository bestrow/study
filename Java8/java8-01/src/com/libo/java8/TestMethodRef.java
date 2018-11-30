package com.libo.java8;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.libo.exer.Employee;

/*
 * һ���������ã���Lambda���е������з����Ѿ�ʵ���ˣ����ǿ���ʹ��"��������"
 * 			���������Ϊ����������Lambda ���ʽ������һ�ֱ�����ʽ��
 * 
 * ��Ҫ�������﷨��ʽ:
 * 
 * ����::ʵ��������
 * 
 * ��::��̬������
 * 
 * ��::ʵ��������
 * 
 * ע�⣺
 * 	��Lambda���е��÷����Ĳ����б��뷵��ֵ���ͣ�Ҫ�뺯��ʽ�ӿ��г��󷽷��ĺ����б�ͷ���ֵ���ͱ���һ�£�
 * 	����Lambda�����б��еĵ�һ��������ʵ�������ĵ����ߣ����ڶ���������ʵ�������Ĳ���ʱ������ʹ��ClassName::method
 * 
 * ��������������:
 * 
 * ��ʽ:
 * 
 * ClassName::new
 * 
 *ע��:��Ҫ���õĹ������Ĳ����б�Ҫ�뺯��ʽ�ӿ��г��󷽷��Ĳ����б���һ�£�
 *
 * ������������
 * 
 * Type::new;
 * 
 */
public class TestMethodRef {

	// ����::ʵ��������
	@Test
	public void test1() {
		Consumer<String> con = (x) -> System.out.println(x);

		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;

		Consumer<String> con2 = System.out::println;
		con2.accept("abdfdaf");
	}

	@Test
	public void test2() {
		Employee emp = new Employee();
		Supplier<String> sup = () -> emp.getName();

		Supplier<Integer> sup2 = emp::getAge;
	}

	// ��::��̬������
	@Test
	public void test3() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

		Comparator<Integer> com1 = Integer::compare;
	}

	// ��::ʵ��������
	@Test
	public void test4() {
		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		BiPredicate<String, String> bp2 = String::equals;
	}

	// ����������
	@Test
	public void test5() {
		Supplier<Employee> sup = () -> new Employee();

		// ���������÷�ʽ
		Supplier<Employee> sup2 = Employee::new;
	}
	
	// ��������
	public void test6() {

		Function<Integer, String[]> fun = (x) -> new String[x];
		
		Function<Integer, String[]> fun2 = String[]::new;
	}
}
