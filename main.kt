fun checkParenthesis(input: String): Boolean {
    var openersStack = mutableListOf<Char>()
    val openersAndClosers = input.filter { char: Char -> isOpenerOrCloser(char) }
    for (char in openersAndClosers) {
        if (isOpener(char)) {
            pushToStack(openersStack, char)
        } else {
            if(openersStack.size == 0)
                return false
            val lastOpener = popFromStack(openersStack)
            if(!isCorresponding(lastOpener, char))
                return false
        }
    }
    return openersStack.size == 0
}

// add a comment to see if pushing works
fun isCorresponding(opener: Char, char: Char): Boolean {
    when (opener) {
        '(' -> return char.equals(')')
        '[' -> return char.equals(']')
        '{' -> return char.equals('}')
    }
    return false
}

fun popFromStack(openersStack: MutableList<Char>): Char {
    val lastOpener = openersStack.last()
    openersStack.removeAt(openersStack.lastIndex)
    return lastOpener
}

fun pushToStack(openersStack: MutableList<Char>, char: Char) {
    openersStack.add(char)
}

fun isOpenerOrCloser(char: Char): Boolean {
    if (isOpener(char))
        return true
    if (isCloser(char))
        return true
    return false
}

fun isCloser(char: Char): Boolean {
    when (char) {
        ')' -> return true
        ']' -> return true
        '}' -> return true
    }
    return false
}

fun isOpener(char: Char): Boolean {
    when (char) {
        '(' -> return true
        '[' -> return true
        '{' -> return true
    }
    return false
}
