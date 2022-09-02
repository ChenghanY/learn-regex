/**
 * 能够使用java5 的枚举方法
 */
enum Methodologies{
    Evo(5),
    XP(21),
    Scrum(30);

    final int daysIteration
    Methodologies(days){daysIteration = days}

    def iterationDetails() {
        println "${this} recommends $daysIteration days for iteration"
    }
}

for(methodology in Methodologies.values()){
    methodology.iterationDetails();
}