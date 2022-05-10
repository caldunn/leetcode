import org.scalatest.*
import flatspec.*
import matchers.*

abstract class BaseFlatSpec extends AnyFlatSpec with should.Matchers with OptionValues with Inside with Inspectors;
