package store

import scala.collection.mutable

/**
 * Created by mike on 01/07/15.
 */
object ShoppingCart {
  def apply(): ShoppingCart = {
    new ShoppingCart(Map("apple" -> Item(0.60, "apple"), "orange" -> Item(0.25, "orange")));
  }
}

class ShoppingCart(val products: Map[String, Item]) {
  var total = BigDecimal("0.0")
  val items = mutable.MutableList[Item]()
  def Add(item: String) = {
    products(item) match {
      case i: Item =>
        total += i.price
        items += i
    }
  }
}
