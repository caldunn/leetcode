package Stack

object ValidParens {
  def validateParens(input: String): Boolean =
    val mutableStack = scala.collection.mutable.Stack[Char]()
    val openBraces   = Set('(', '{', '[')
    for c <- input do
      if openBraces.contains(c) then mutableStack.push(c)
      else {
        // This is very obtuse. I wonder if the there is a better way.
        mutableStack.top match
          case '(' => if c != ')' then return false
          case '[' => if c != ']' then return false
          case '{' => if c != '}' then return false
          case _   => return false
        mutableStack.pop
      }
    mutableStack.isEmpty
}
