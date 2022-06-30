import BinarySearching.*

class BinarySearches extends BaseFlatSpec {
  // Return a boolean to predicate => Is there a duplicate?
  "704 - Simple binary search" should "Result in exact middle" in {
    val res = BinarySearch.search(Vector(1, 2, 3, 4, 5), 3)
    assertResult(3)(res)
  }
  it should "Result in middle somewhere & even length" in {
    val res = BinarySearch.search(Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    assertResult(3)(res)
  }
  it should "Leftmost" in {
    val res = BinarySearch.search(Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 1)
    assertResult(1)(res)
  }
  it should "Rightmost" in {
    val res = BinarySearch.search(Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10)
    assertResult(10)(res)
  }
  it should "Does not exist" in {
    val res = BinarySearch.search(Vector(1, 2, 3, 4, 5, 6, 7, 9, 10), 8)
    assertResult(-1)(res)
  }
  "74 - Search a 2D array" should "outside of initial pivot" in {
    val input =
      Vector(Vector(1, 3, 5, 7), Vector(10, 11, 16, 20), Vector(23, 30, 34, 60))
    val res = BinarySearch.search(input, 3)
    assertResult(3)(res)
  }
  it should "At the start" in {
    val input =
      Vector(Vector(1, 3, 5, 7), Vector(10, 11, 16, 20), Vector(23, 30, 34, 60))
    val res = BinarySearch.search(input, 1)
    assertResult(1)(res)
  }
  it should "At the end" in {
    val input =
      Vector(Vector(1, 3, 5, 7), Vector(10, 11, 16, 20), Vector(23, 30, 34, 60))
    val res = BinarySearch.search(input, 60)
    assertResult(60)(res)
  }
  it should "not exist" in {
    val input =
      Vector(Vector(1, 3, 5, 7), Vector(10, 11, 16, 20), Vector(23, 30, 34, 60))
    val res = BinarySearch.search(input, 12)
    assertResult(-1)(res)
  }
}
