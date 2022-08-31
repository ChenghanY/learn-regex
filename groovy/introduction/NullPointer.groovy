/**
 * groovy 如何防御空指针
 */
def foo(str) {
    str?.reverse()
}

println foo('evil')
println foo(null)