// 执行外部程序，获取结果。这里使用cmd的命令行获取groovy版本
println 'cmd /c groovy -v'.execute().text