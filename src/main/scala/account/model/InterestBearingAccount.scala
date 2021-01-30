package account.model

/**
 * 定义有息账户接口
 */
trait InterestBearingAccount extends Account {
  // 利率
  def rateOfInterest: BigDecimal

}
