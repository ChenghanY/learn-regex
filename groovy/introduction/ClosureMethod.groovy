/**
 * 嵌套的闭包如何获得上下文信息
 *
 */


def examiningClosure(closure) {
    closure()
}

examiningClosure() {
    println 'In First Closure'
    println 'class is' + getClass().name
    println 'this is' + this + ', super: ' + this.getClass().superclass.name
    println 'owner is' + owner + ', super: ' + owner.getClass().superclass.name
    println 'delegate is' + delegate + ', super: ' + delegate.getClass().superclass.name

    examiningClosure() {
        println '>> In Closure within the first Closure'
        println '>> class is' + getClass().name
        println '>> this is' + this + ', super: ' + this.getClass().superclass.name
        println '>> owner is' + owner + ', super: ' + owner.getClass().superclass.name
        println '>> delegate is' + delegate + ', super: ' + delegate.getClass().superclass.name
    }
}