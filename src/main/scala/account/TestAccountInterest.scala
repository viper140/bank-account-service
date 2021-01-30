package account

import account.model.{Account, CheckingAccount, InterestBearingAccount, SavingAccount}
import account.repository.AccountRepository
import account.service.InterestBearingService

/**
 * 账户利息测试
 */
object TestAccountInterest {

  val interestBearingService: InterestBearingService = new InterestBearingService()
  val accountRepository: AccountRepository = new AccountRepository()


  def main(args: Array[String]): Unit = {
    // 获取所有有息账户
    val interestAccounts: List[InterestBearingAccount] = accountRepository.getAllInterestBearingAccountAccounts

    // 计算利息
    this.printInterest(interestAccounts)

    // 计算税后利息
    this.printInterestDeductTax(interestAccounts)
  }

  def printInterest(accounts: List[InterestBearingAccount]): Unit = {
    println("Enter 计算利息")

    accounts
      .map(item => interestBearingService.calculateInterest(item, 5))
      .foreach(println(_))

    println("Exit 计算利息")
    println
  }

  def printInterestDeductTax(accounts: List[InterestBearingAccount]): Unit = {
    println("Enter 计算税后利息")

    // 1. map 分次运算：账户 -> 利息 -> 净利息
    val results = accounts
      .map(item => interestBearingService.calculateInterestPerYear(item))
      .map(item => interestBearingService.deductTax(item))
    println(s"税后利息（方式1）：$results")

    // 2. 一次 map：账户 -> (两次运算进行组合) -> 净利息
    val results2 = accounts
      .map(interestBearingService.calculateInterestPerYear andThen interestBearingService.deductTax)
    println(s"税后利息（方式2）：$results")

    println("Exit 计算税后利息")
    println
  }

}
