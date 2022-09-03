@Singleton(lazy = true)
class TheUnique {
    def hello() {println "hello"}
}
TheUnique.instance.hello()
TheUnique.instance.hello()