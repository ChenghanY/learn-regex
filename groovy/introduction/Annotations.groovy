import groovy.transform.Canonical

/**
 * toString 声明及特性,
 * 排除掉字段
 */
@Canonical(excludes='lastName, age')
class Person {
    String firstname
    String lastName
    int age
}

def sara = new Person(firstname: 'Sara', lastName: 'Walker', age: 49)
println sara