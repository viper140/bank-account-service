package account.service

import account.model.InterestBearingAccount

import scala.util.{Failure, Success, Try}

/**
 * 定义有息账户服务
 */
class InterestBearingService {

  /**
   * 计算账期内的利息
   */
  def calculateInterest[T <: InterestBearingAccount](account: T, period: Int): Try[BigDecimal] = {
    if (period < 0) {
      return Failure(new IllegalArgumentException("参数异常"))
    }

    val interestPerYear = calculateInterestPerYear(account)
    return Success(period * interestPerYear)
  }

  /**
   * 计算每年产生利息
   */
  def calculateInterestPerYear: InterestBearingAccount => BigDecimal = {
    account => account.balance * account.rateOfInterest
  }

  /**
   * 扣税
   */
  def deductTax: BigDecimal => BigDecimal = {
    interest => {
      if (interest < 1000) {
        interest
      } else {
        // 写死 10% 税收
        0.9 * interest
      }
    }
  }

}
