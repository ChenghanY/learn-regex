/**
 * 1. groovy == 等价于 equals; 特别注意，如果实现了comparable则 == 会被重载为compareTo
 * 2. 如果要判断引用是否相同，要使用is()
 * 3. 注意def定义对象的场景
 */
def name1 = 'james'
def name2 = 'james'

println name1 == name2
// 两个引用都指向了 james的内存空间
println name1.is(name2)

name2 = new String('james');

println name1 == name2
// 使用new开辟了新的空间
println name1.is(name2)