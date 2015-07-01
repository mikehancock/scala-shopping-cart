package store

/**
 * Created by mike on 01/07/15.
 */
case class Item(val price: BigDecimal, val name: String)

object Item {
  def apple(): Item = {
    Item(0.6, "Apples")
  }
}
