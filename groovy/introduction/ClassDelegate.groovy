/**
 * 使用委派的方式改变继承的现状
 */

// 普通工人
class Worker {
    def work() {println 'get work done'}
    def analyze() {println 'analyze...'}
    def writeReport() {println 'get report written'}
}

// 专家
class Expert {
    def analyze() {println 'expert analysis...'}
}

// 管理层会管理专家和普通员工的工作，普通工人自己能完成所有工作，而专家更擅长分析。团队协作时，需要用Manager类
// Manager 会让专家完成分析工作，普通工人负责执行
class Manager {
    @Delegate Expert expert = new Expert()
    @Delegate Worker worker = new Worker()
}

def manager = new Manager()
manager.analyze()
manager.work()
manager.writeReport()