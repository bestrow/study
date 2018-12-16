package main

import "fmt"

func main0401() {
	// 输出格式
	fmt.Println("自带换行")
	fmt.Print("无换行")
	fmt.Print("无换行\n")
	a := 10
	b := 3.14159
	// %d 占位符 表示输出一个整型数据
	fmt.Printf("==%05d==\n", a)
	fmt.Printf("==%.2f==", b)

}

func main0402() {
	// bool string byte
	var a bool
	fmt.Println(a)
	a = true
	fmt.Printf("%t\n", a)
	var b string
	b = "hello"
	fmt.Printf("%s\n", b)
	var c byte
	c = 'a'
	fmt.Printf("%c", c)
}
