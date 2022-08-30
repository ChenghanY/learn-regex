import java.util.regex.Pattern

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

def SubDomain="(?i:[a-z0-9]●[a-z0-9][-a-z0-9]*[a-z0-9])";
def TopDomains="(?x-i:com\\b \n"+
        "          |edu\\b                                \n"+
        "          |biz\\b                                \n"+
        "          |net\\b                                \n"+
        "          |org\\b                                \n"+
        "          |[a-z][a-z]\\b                         \n"+//countrycodes
        ")                                                \n";
def Hostname="(?:"+ SubDomain+"\\.)+"+TopDomains;
def NOT_IN=";\"'<>()\\[\\]{}\\s\\x7F-\\xFF";
def NOT_END="!.,?";
def ANYWHERE="[^"+NOT_IN+NOT_END+"]";
def EMBEDDED="["+NOT_END+"]";
def UrlPath="/"+ANYWHERE+"*("+EMBEDDED+"+"+ANYWHERE+"+)*";
def Url = "(?x:                                                                                                 \n"+
            " \\b                                                                                                  \n"+
            " ##匹配hostname                                                                                        \n"+
            "  (                                                                                                   \n"+
            "    (?: ftp|http s? ): // [-\\w]+ (\\.\\w[-\\w]*)+                                                     \n"+
            "    |                                                                                                 \n"+
            "    " + Hostname + "                                                                                  \n"+
            "   )                                                                                                  \n"+
            "  (?: :\\d+) ?                                                                                        \n"+
            "  (?:" + UrlPath + ")?                                                                                \n"+
            " )"



//现在把正则表达式编译为正则对象
Pattern UrlRegex  = Pattern.compile(Url)
exec(UrlRegex)