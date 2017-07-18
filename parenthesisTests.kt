import org.testng.annotations.Test
import kotlin.test.assertEquals

@Test
fun testEmptyStringOk() {
    var isOk = checkParenthesis("")
    assertEquals(true, actual = isOk)
}

@Test
fun testSingleParenthesisPairOk(){
    var isOk = checkParenthesis("()")
    assertEquals(true, isOk)
}

@Test
fun testNestedParenthesisPairOk(){
    var isOk = checkParenthesis("(())")
    assertEquals(true, isOk)
}

@Test
fun testNestedMultipleTypesPairOk(){
    var isOk = checkParenthesis("{([])}")
    assertEquals(true, isOk)
}

@Test
fun testNestedMultipleTypesCustomOk(){
    var isOk = checkParenthesis("{([][][]()[()()])}")
    assertEquals(true, isOk)
}

@Test
fun testMissingCloserFail(){
    var isOk = checkParenthesis("{")
    assertEquals(false, isOk)
}

@Test
fun testWrongOrderFail(){
    var isOk = checkParenthesis("}{")
    assertEquals(false, isOk)
}

@Test
fun testRandomThingsFail(){
    var isOk = checkParenthesis("()())(({{{}{]][]}{")
    assertEquals(false, isOk)
}

@Test
fun testCodeInsideParenthesisOk(){
    var isOk = checkParenthesis("( this is code )[this is more code]")
    assertEquals(true, isOk)
}

@Test
fun testPushToStack() {
    var testStack = mutableListOf<Char>()
    pushToStack(testStack, 'a')
    assertEquals(1, testStack.size)
}

@Test
fun testPopFromStack() {
    var testStack = mutableListOf<Char>('a', 'b', 'c')
    val result = popFromStack(testStack)
    assertEquals('c', result)
    assertEquals(2, testStack.size)
}