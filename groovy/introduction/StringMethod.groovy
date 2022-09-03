/**
 * String 语法上面的知识
 */

// ' 嵌套 “
println 'hi "tome"'

// 使用 $value , 请使用 ".."
def value1 = 20
println 'value is $value1'
println "value is $value1"

// 可以使用 / 创建一个表达式
def reg = /value1 is $value1/
println reg

// 单引号和双引号是不同的东西

// 1. 惰性求值，去修改StringBuilder的引用
what = new StringBuilder('fence')
text = "the cow jumped over the $what"
println text
what.replace(0, 5, "moon")
println text

// 2. 修改单引号的值, 无法重复覆盖
price = 684.71
company = 'Google'
quote = "Today $company stock closed at $price"
stocks = [Apple:663.01, Microsoft:30.95]
stocks.each {key, value ->
    company = key
    price = value
    println quote
}

// 3. 解决问题, 使用groovy 的特性: “” 括起来的语句，收到一个普通变量会交给 StringWriter打印，以下的it就是StringWriter打印
// 如果接收一个闭包，则该闭包就会被调用
println '=====solution1====='
companyClosure = {it.write(company)}
priceClosure = {it.write("$price")}
quote = "Today ${companyClosure} stock closed at ${priceClosure}"

stocks.each {key, value ->
    company = key
    price = value
    println quote
}

// 4. 优化 3. 的写法
println '=====solution2====='
companyClosure = {-> company}
priceClosure = {-> price}
quote = "Today ${companyClosure} stock closed at ${priceClosure}"

stocks.each {key, value ->
    company = key
    price = value
    println quote
}

// 5. 优化 4. 的写法
println '=====solution3====='
quote = "Today ${-> company} stock closed at ${-> price}"

stocks.each {key, value ->
    company = key
    price = value
    println quote
}