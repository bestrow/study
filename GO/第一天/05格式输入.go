package main

import "fmt"

func main0501() {
	//var a int
	//fmt.Scan(&a)
	//fmt.Println(a)
	// %p 占位符 表示输出一个数据对应的内存地址 &a
	//fmt.Printf("%p", &a)

	// 空格或者回车作为接收结束
	//var str string
	//fmt.Scan(&str)
	//fmt.Println(str)

	var s1, s2 string
	fmt.Scan(&s1, &s2)
	fmt.Println(s1)
	fmt.Println(s2)
}
func main0502() {
	var r float64
	//PI := 3.14159
	var PI float64
	fmt.Scan(&r, &PI)
	fmt.Printf("面积:%.2f\n", PI*r*r)
	fmt.Printf("周长:%.2f\n", 2*PI*r)
}
func main0503() {
	var a int
	var b string
	fmt.Scanf("%d%s", &a, &b)
	fmt.Println(a)
	fmt.Println(b)
}
