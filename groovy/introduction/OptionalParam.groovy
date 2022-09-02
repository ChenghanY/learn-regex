/**
 * 给参数设置默认值
 */
def log(x, base=10) {
    Math.log(x) / Math.log(base)
}

println log(10)

def task(name, String[] details) {
    println "$name - $details"
}

println task('hi', 'james', 'ali', 'baidu')