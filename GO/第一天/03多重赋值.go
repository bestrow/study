package main

import "fmt"

func main0301() {
	// 格式 变量1,变量2 := 变量1值,变量2值
	//a, b, c, d := 10, 20, 30, 40
	a, b, c, d := 10, 3.14, true, 'a'
	fmt.Println(a, b, c, d)
}

func main0302() {
	a, b := 10, 20

	// 交换a b的值

	// 第一种
	/*temp := a
	a = b
	b = temp*/

	// 第二种 加减运算
	/*a = a + b
	b = a - b
	a = a - b*/

	// 第三种
	a, b = b, a

	fmt.Println(a, b)
}
// 匿名变量
func main0303() {
	a, b, _, d := 1, 2, 3, 4

	fmt.Println(a, b, d)
}
