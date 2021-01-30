package account

import account.model.{Account, CheckingAccount, InterestBearingAccount}
import account.repository.AccountRepository
import account.service.InterestBearingService

/**
 * 账户利息测试
 */
object TestAccountMatch {

  val interestBearingService: InterestBearingService = new InterestBearingService()
  val accountRepository: AccountRepository = new AccountRepository()


  def main(args: Array[String]): Unit = {
    // 获取所有账户
    val accounts: List[Account] = accountRepository.getAll

    accounts.foreach(item =>  {
      val rate = getRate(item)
      println(s"${item.getClass} ${item.name} rate: $rate")
    })
  }

  /**
   * 获取利率
   * 按照类型进行模式匹配
   * 模式匹配还可以匹配：值、参数
   */
  def getRate(account: Account): BigDecimal = account match {
    case _: CheckingAccount => 0
    case item: InterestBearingAccount => item.rateOfInterest
    case _ => throw new IllegalArgumentException(s"we don't know about u $account")
  }

}
