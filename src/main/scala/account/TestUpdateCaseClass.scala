package account

import account.model.{InterestBearingAccount, SavingAccount}

case class Address(no: Int, city: String, zip: String)
// TODO case class 不能这么继承
//case class TestUpdateAccount
//(override val number: String,
// override val name: String,
// override val balance: BigDecimal,
// override val rateOfInterest: BigDecimal,
// address: Address
//) extends SavingAccount(number, name, balance, rateOfInterest)
//
//object TestUpdateCaseClass {
//
//  def main(args: Array[String]): Unit = {
//    val srcAccount: TestUpdateAccount = TestUpdateAccount("111", "wong", 100, 0.02, Address(1, "深圳", "518000"))
//    println(s"srcAccount: $srcAccount")
//
//    // 嵌套更新
//    val complexUpdateAccount = srcAccount.copy(name = "wong", address = srcAccount.address.copy(zip = "518001"))
//    println(s"complexUpdateAccount: $complexUpdateAccount")
//  }
//}
