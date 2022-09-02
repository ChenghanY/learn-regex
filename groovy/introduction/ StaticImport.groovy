/**
 * 把其他方法作为静态引入, 能让代码简洁
 */
import groovy.lang.ExpandoMetaClass as EMC

def metaClass = new EMC(Integer)
assert metaClass.getClass().name == 'groovy.lang.ExpandoMetaClass'
