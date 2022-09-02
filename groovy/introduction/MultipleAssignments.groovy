def splitName(fullName) {fullName.split(' ')}

/**
 * 接收返回值列表，并申明元素
 */
def (firstName, lastName) = splitName('James Bond')
println "$lastName, $firstName $lastName"
