package store

import org.scalatest.Matchers
import org.scalatest.mock.MockitoSugar
import org.scalatest.path.FunSpecLike

import scala.collection.mutable

/**
 * Created by mike on 01/06/15.
 */
class ShoppingCartSpec
  extends FunSpecLike
  with Matchers
  with MockitoSugar {

  import scala.concurrent.ExecutionContext.Implicits.global

  describe("A Shopping Cart") {
    val cart = ShoppingCart();

    describe("containing apples") {
      cart.Add("apple")

      it("contains 2 apples") {
        cart.items should have length 2
        //cart.items should contain (mutable.MutableList(Item.apple(), Item.apple()))
      }

      it("costs 60p") {
        cart.total should be (0.60)
      }
    }

    describe("containing oranges") {
      cart.Add("orange")

      it("contains oranges") {
        cart.items should have length 1
        cart.items should contain (store.Item(0.25, "orange"))
      }

      it("costs 25p") {
        cart.total should be (0.25)
      }
    }

    describe("containing apples and oranges") {
      cart.Add("apple")
      cart.Add("apple")
      cart.Add("orange")
      cart.Add("apple")

      it("costs £2.05") {
        cart.total should be (2.05)
      }
    }

    describe("adding pears"){
      it("throws a NoSuchElementException") {
        intercept[NoSuchElementException] {
          cart.Add("pear")
        }
      }
    }
  }
}