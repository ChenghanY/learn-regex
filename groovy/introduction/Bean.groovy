/**
 * 优化了JavaBean的操作
 */
class Car {
    final year
    def miles
    // 无实际作用，private会引起歧义
    private brand

    Car(theYear) {year = theYear}

}

class Man {
    def year
    def age
    def access(year, age) {
        println year + age
    }
}

def car = new Car(2012)

println "year: $car.year"
println "Mileds: $car.miles"

// 灵活的构造器
def Man = new Man(year: 2022, age: 25);

