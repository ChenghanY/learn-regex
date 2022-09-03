/**
 * 闭包的用法及坑
 */
def iterate(n, closure) {
    // upto 也支持闭包，这里相当于嵌套了一层闭包
    1.upto(n) {
        println "In iterate with value ${it}"
        // upto 的内部变量可以暴露给外部读取
        closure(it)
    }
}

println "Calling iterate"
// 闭包使用了共享变量
total = 0
iterate(4, {
    total += it
    println "In closure total so far is ${total}"
})
println "Done"