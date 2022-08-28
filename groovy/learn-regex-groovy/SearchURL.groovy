/*
    匹配url的正则表达式
    1. =~ 查询操作符，使用在字符串之后, 要求接一个正则表达式, 返回的是一个java.util.regex.Matcher 对象
    2. ==~是匹配操作符，使用在字符串之后, 要求接一个正则表达式, 返回的类型为Boolean 类型.
        这个操作符要求前面给定的字符串与后面的正则表达式完全匹配才可返回true
 */
def exec(regex) {
    def list = [
        "http://www.baidu.com:",
        "http://www.baidu.com:80",
    ]
    list.each {
        if (! (it ==~ regex)) {
            println('match failed ! case: ' + it + ' regex:' + regex)
        }
    }
}

// 惰性匹配s
def reg = ~"https?://.*"
exec(reg)

/*
 [] 是结果集
 1.在结果集中，表示可以匹配右边数组中任意的值 [- 数字英语下划线 .] ;
 2.加号表示匹配1个或>1个
 */
reg =~ "https?://[-\\w.]+"
exec(reg)

/*
 () 表示作为一个整体，且为一个分组
 1. 冒号开头紧跟着1个或>1个数字
 2. 问号表示匹配0个或1个
 目的：匹配可选的端口号
 */
reg =~ "https?://[-\\w.]+(:\\d+)?"
exec(reg)

/*
 /[\w/_.]*
 1. 星号表示0个或>0个
 目的：匹配多级路径
 */
reg =~ "https?://[-\\w.]+(:\\d+)?/[\\w/_.]*"
exec(reg)