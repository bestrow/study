package main

import (
	"fmt"
)

func main0201() {
	// var 变量名 数据类型
	var a int // 声明
	a = 10    // 赋值
	a = a + 25
	//var a int = 10 // 定义

	fmt.Println(a)
}

func main0202() {
	// 计算圆的面积和周长
	//var PI float64 = 3.14159
	PI := 3.14159
	//var r float64 = 2.5
	r := 2.5
	//var s float64
	//var l float64

	//s = PI * r * r
	//l = 2 * PI * r

	s := PI * r * r
	l := 2 * PI * r
	fmt.Println("面积:", s)
	fmt.Println("周长:", l)
}

func main0203() {
	// 去市场买2斤黄瓜 价格为5元
	w := 2.0 // float64
	//p := 5 // int
	var p float64 = 5
	// 在go语言中不同的数据类型不能进行计算 可以通过类型转换解决
	fmt.Println(w * p)
}
func main0204() {
	a := false   // bool
	b := 10      // int
	c := 3.14    // float64
	d := 'a'     // byte
	e := "hello" // string
	fmt.Println(a, b, c, d, e)
}
