/**
 * 1. 契约式设计
 * 2. 能力式设计
 *
 * groovy 鼓励’鸭子式‘的编程思想：如果它走路像鸭子，叫声像鸭子，那么它就是一只鸭子
 */

// Java 习惯使用接口拓展
// 人类会搬东西
abstract class Human {
    abstract void helpMoveThings()
}

// 需求：定义一个会搬东西的大象, 但是大象不是人类，只能再寻找大象和人类的抽象 Helper (愿意帮忙的动物)
interface Helper {
    def helpMoveThings()
}

class Man implements Helper {
    def helpMoveThings() {
        println 'man helpMoveThings'
    }
}

class Women implements Helper  {
    def helpMoveThings() {
        println 'Women helpMoveThings'
    }
}

class Elephant implements Helper {
    def helpMoveThings() {
        println 'Elephant helpMoveThings'
    }
}

def takeHelp(Helper helper) {
    helper.helpMoveThings()
}

takeHelp(new Man())
takeHelp(new Women())
takeHelp(new Elephant())

// 基于能力的设计
class DuckMan {
    def helpMoveThings() {
        println 'DuckMan helpMoveThings'
    }
}

class DuckWomen {
    def helpMoveThings() {
        println 'DuckWomen helpMoveThings'
    }
}

class DuckElephant {
    def helpMoveThings() {
        println 'DuckElephant helpMoveThings'
    }
}

def DuckTakeHelp(helper) {
    helper.helpMoveThings();
}
DuckTakeHelp(new DuckMan())
DuckTakeHelp(new DuckWomen())
DuckTakeHelp(new DuckElephant())
