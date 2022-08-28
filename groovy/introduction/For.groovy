// 连续打印hi 3次， NOTE：索引i没用到
for (i in 0..2) {print 'hi '}
print("\n" + "===" + "\n")

// 连续打印hi 3次, 使用groovy的增加Integer类方法1
0.upto(2) {print 'hi '}
print("\n" + "===" + "\n")

// 连续打印hi 3次, 使用groovy的增加Integer类方法2
3. times {print 'hi '}
print("\n" + "===" + "\n")

// 可以使用索引，用it作为变量。btw, 脚本的参数需要放在双引号中
3. times {print "$it "}
print("\n" + "===" + "\n")
