package store

import scala.collection.mutable

/**
 * Created by mike on 01/07/15.
 */
object ShoppingCart {
  def apply(): ShoppingCart = {
    new ShoppingCart(Map("apple" -> Item.apple(), "orange" -> Item(0.25, "orange")), Map("apple" -> Offer(Item.apple())));
  }
}

class ShoppingCart(val products: Map[String, Item], val offers: Map[String, Offer]) {
  var total = BigDecimal("0.0")
  val items = mutable.MutableList[Item]()
  def Add(item: String) = {
    products(item) match {
      case i: Item =>
        total += i.price
        items += i
    }
    offers.get(item) match {
      case o: Some[Offer] => items += o.get.freeItem
      case None =>
    }
  }
}
