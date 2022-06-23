import ArraysAndHashing.*

class ArraysAndHashingT extends BaseFlatSpec {
  // Return a boolean to predicate => Is there a duplicate?
  "217 - Contains Duplicates" should "Report false on the empty array" in {
    assertResult(false)(ContainsDuplicates.containsADuplicate(Seq()))
  }
  it should "Be False on the array containing 0 - 100 inclusive" in {
    assertResult(false)(ContainsDuplicates.containsADuplicate {
      // Range(1, 101).toList
      Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    })
  }
  it should "Be True for an array containing a single duplicate" in {
    assertResult(true)(ContainsDuplicates.containsADuplicate {
      Seq(1, 2, 3, 4, 5, 6, 6, 7, 8, 9)
    })
  }
  it should "Be true for multiple duplicates" in {
    assertResult(true)(ContainsDuplicates.containsADuplicate {
      Seq(1, 1, 2, 3, 4, 4, 5, 6)
    })
  }
  it should "be true for seperated duplications" in {
    assertResult(true)(ContainsDuplicates.containsADuplicate {
      Seq(1, 2, 4, 1, 5)
    })
  }

  "242 - Valid Anagram" should "true for toyot" in {
    assertResult(true)(ValidAnagram.isValidAnagram("toyot"))
  }
  it should "false for car" in {
    assertResult(false)(ValidAnagram.isValidAnagram("car"))
  }

  "1 - Two Sum" should "pairs togethor" in {
    assertResult((1, 2))(TwoSum.find(Seq(1, 3, 4), 7))
  }
  it should "pairs apart" in {
    assertResult((1, 4))(TwoSum.find(Seq(1, 5, 6, 12, 10), 15))
  }
  it should "default (0,0) if there is no match" in {
    assertResult((0, 0))(TwoSum.find(Seq(), 100))
  }

  "49 - Group Anagrams" should "sort like anagrams" in {
    val input          = Seq("eat", "tea", "tan", "ate", "nat", "bat")
    val expectedOutput = Seq(Seq("bat"), Seq("nat", "tan"), Seq("ate", "eat", "tea")).map(_.sorted).sorted
    val actualOutput   = ValidAnagram.groupAnagrams(input).map(_.sorted).sorted

    assertResult(expectedOutput)(actualOutput)
  }
  it should "respect an empty array" in {
    val input  = Seq("")
    val output = Seq(Seq(""))

    assertResult(output)(ValidAnagram.groupAnagrams(input))
  }

  "T347 - Top K Elements" should "determine top 2" in {
    val input       = Seq(1, 1, 1, 1, 2, 2, 3)
    val expectedOut = Seq(1, 2)

    assertResult(expectedOut)(TopKElements.topK(input, 2))
  }
  it should "support 1 element" in {
    val input = Seq(1)
    val eOut  = Seq(1)

    assertResult(eOut)(TopKElements.topK(input, 1))
  }

  "238 - Prodct of Array Except Self" should "work with division" in {
    val input = Seq(1, 2, 3, 4)
    val eOut  = Seq(24, 12, 8, 6)

    assertResult(eOut)(ProductExceptSelf.invalid(input))
  }
  it should "work with 0s" in {
    val input = Seq(-1, 1, 0, -3, 3)
    val eOut  = Seq(0, 0, 9, 0, 0)
    assertResult(eOut)(ProductExceptSelf.invalid(input))
  }

  "659 - Encode and Decode Strings" should "encode -> decode a string with only alpha-numerics" in {
    val input   = Seq("lint", "code", "love", "you") // "4!lint4!code4!love3!you"
    val rResult = EncodeAndDecodeStrings.decode(EncodeAndDecodeStrings.encode(input))

    assertResult(input)(rResult)
  }

  it should "encode -> decode a string that contains more than 10 letters in a single word" in {
    val input   = Seq("lint", "codingwiththebois", "love", "you")
    val rResult = EncodeAndDecodeStrings.decode(EncodeAndDecodeStrings.encode(input))

    assertResult(input)(rResult)
  }
  it should "encode -> decode a string that contains a double digit length first word." in {
    val input   = Seq("codingwiththebois", "codingwiththebois2", "love", "you") // "4!lint4!code4!love3!you"
    val rResult = EncodeAndDecodeStrings.decode(EncodeAndDecodeStrings.encode(input))
    assertResult(input)(rResult)
  }

  "36 - Partially valid sudoku validation" should "encode -> decode a string with only alpha-numerics" in {
    val input   = Seq("lint", "code", "love", "you") // "4!lint4!code4!love3!you"
    val rResult = EncodeAndDecodeStrings.decode(EncodeAndDecodeStrings.encode(input))

    assertResult(input)(rResult)
  }
}
