/**
 * groovy 不强制捕获受检异常
 */
def openFile(fileName) {
    // java 代码会抛出FileNotFoundException
    new FileInputStream(fileName)
}

try {
    openFile("xxx")
} catch(FileNotFoundException ex) {
    // 这里想做啥做啥，不用强制在openFile里面去捕获异常
}

try {
    openFile("xxx")
} catch(ex) {
    // 只写ex参数，只捕获Exception, 不包括Error 和 Throwable
    println ex
}