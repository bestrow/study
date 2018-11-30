package com.libo.exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestLambda {

	List<Employee> emps = Arrays.asList(new Employee(101, "张三", 18, 9999), new Employee(102, "李四", 59, 6666),
			new Employee(103, "王五", 28, 3333), new Employee(104, "赵六", 8, 7777), new Employee(105, "田七", 38, 5555));

	@Test
	public void test1() {
		Collections.sort(emps, (e1, e2) -> {
			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			} else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}

	@Test
	public void test2() {
		String trimStr = strHandler("\t\t\t fasfadsf  ", (str) -> str.trim());
		System.out.println(trimStr);

		String upper = strHandler("fasfa", (str) -> str.toUpperCase());
		System.out.println(upper);
	}

	// 用于字符串处理
	public String strHandler(String str, MyFunction mf) {
		return mf.getValue(str);
	}

	@Test
	public void test3() {
		op(100L, 200L, (x, y) -> x + y);

		op(100L, 200L, (x, y) -> x * y);
	}

	// 对于两个Long型数据进行处理
	public void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
		System.out.println(mf.getValue(l1, l2));
	}
}
