package account.model

/**
 * 定义账户接口
 */
trait Account {
  def number: String

  def name: String

  def balance: BigDecimal
}
