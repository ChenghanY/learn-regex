import groovy.transform.Immutable

/**
 * 创建一个bean, 内部的熟悉都是不可变的对象（初始化后不可修改）
 */
@Immutable
class CreditCard {
    String cardNumber
    int creditLimit
}

println new CreditCard('4000-111-222', 1000)