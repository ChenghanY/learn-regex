import java.util.regex.Matcher

/*
    匹配url的正则表达式
    1. =~ 查询操作符，使用在字符串之后, 要求接一个正则表达式, 返回的是一个java.util.regex.Matcher 对象
    2. ==~是匹配操作符，使用在字符串之后, 要求接一个正则表达式, 返回的类型为Boolean 类型.
        这个操作符要求前面给定的字符串与后面的正则表达式完全匹配才可返回true
 */
def exec(inputRegex) {
    // 最终答案
    def answerRegex = ~ "https?://[-\\w.]+(:\\d+)?(/([\\w/_.]*(\\?\\S+)?)?)?"

    def caseList = [
        "http://www.baidu.com",
        "https://www.baidu.com:80/",
        "https://www.baidu.com/",
        "https://www.baidu.com?a=b",
        "https://www.baidu.com/abc",
        "https://www.baidu.com/abc.html",
        "https://www.baidu.com/abc?a=1&b=2",
        "https://www.baidu.com/ab_c/efg?a=1&b=2"
    ]
    def caseAnswerMap = [ : ];
    caseList.each {
        // 先进行查找
        def mather = answerRegex.matcher((String)it);
        if (mather.find()) {
            caseAnswerMap.put(it, mather.group())
        }
    }
    // 对答案
    caseAnswerMap.forEach((itCase, answer) -> {
        def mather = inputRegex.matcher((String)itCase);
        if (mather.find()) {
            String yourAnswer = mather.group()
            if (yourAnswer != answer) {
                println("match failed ！ case: "
                        + itCase + ' |  answer: ' + answer
                        + ' | your answer: ' + mather.group())
            }
            // 匹配的值跟答案不同
        } else {
            // 未匹配任何值
            println("could not match ！itCase : " + itCase + ' | answer:' + answer)
        }
    })
}

/*
 惰性匹配s
 def reg = ~"https?://.*"
 exec(reg)
*/

/*
 [] 是结果集
 1.在结果集中，表示可以匹配右边数组中任意的值 [- 数字英语下划线 .] ;
 2.加号表示匹配1个或>1个
 reg =~ "https?://[-\\w.]+"
 exec(reg)
*/

/*
 () 表示作为一个整体，且为一个分组
 1. 冒号开头紧跟着1个或>1个数字
 2. 问号表示匹配0个或1个
 目的：匹配可选的端口号

 reg =~ "https?://[-\\w.]+(:\\d+)?"
 exec(reg)
*/

/*
 /[\w/_.]*
 1. 星号表示0个或>0个
 目的：匹配多级路径

 reg =~ "https?://[-\\w.]+(:\\d+)?/[\\w/_.]*"
 exec(reg)
*/

/*
 /[\w/_.]*
 1. 星号表示0个或>0个
 目的：匹配多级路径
 def reg = ~"https?://[-\\w.]+(:\\d+)?(/[\\w/_.]*)?"
 exec(reg)
*/

/*
    1. 匹配参数列表 \\?\\S+ 匹配 ?开始且后续跟着至少1个分空字符
    2. 步骤1匹配的字符串，可以有也可以没有， (\\?\\S+)?

 */
def reg = ~"https?://[-\\w.]+(:\\d+)?((/[\\w/_.]*(\\?\\S+)?)?)?"
exec(reg)