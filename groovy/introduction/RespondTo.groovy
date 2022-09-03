/**
 * 防御性编程，查看方法调用的对象有没有该方法
 */
def takeHelpAndReward(helper){
    helper.helpMoveThinds()
    // 有这个方法才调用
    if (helper.metaClass.respondsTo(helper, 'eatSugarcane')) {
        helper.eatSugarcane()
    }
}