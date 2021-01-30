package account.repository

import account.model.{Account, CheckingAccount, InterestBearingAccount, SavingAccount}


/**
 * 账户 repo
 */
class AccountRepository {

  private val savingAccount1: SavingAccount = SavingAccount("111", "wong", 100, 0.02)
  private val savingAccount2: SavingAccount = SavingAccount("222", "feng", 200, 0.04)
  private val savingAccount3: SavingAccount = SavingAccount("333", "victor", 300, 0.06)

  private val checkingAccount1: CheckingAccount = CheckingAccount("444", "vic", 400)

  /**
   * 账户数据表
   */
  private val accounts = List(savingAccount1, savingAccount2, savingAccount3, checkingAccount1)


  def getByAccountNo(accountNo: String): Option[Account] = {
    val account = this.accounts.find(item => item.number == accountNo)
    return account
  }

  def getAllInterestBearingAccountAccounts: List[InterestBearingAccount] = {
    return this.accounts
      .filter(item => item.isInstanceOf[InterestBearingAccount])
      .map(item => item.asInstanceOf[InterestBearingAccount])
  }

  def getAll: List[Account] = {
    return this.accounts
  }

  def getAllNoInterestAccountAccounts: List[Account] = {
    return this.accounts
      .filter(item => !item.isInstanceOf[InterestBearingAccount])
  }
}
