package main

import "fmt"

func main0601() {
	var a bool
	fmt.Println(a)
	a = true
	fmt.Println(a)
}

func main() {
	var a float32
	var b float64
	// float32 默认小数位置保留7位
	a = 3.62626253252625362625325
	// float64 默认小数位置保留15位
	b = 3.542367785466244
	fmt.Println(a)
	fmt.Println(b)
}
