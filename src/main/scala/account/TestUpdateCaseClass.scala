package account

import account.model.Account

case class MyAddress(no: Int, city: String, zip: String)

case class MyAccount
(number: String,
 name: String,
 balance: BigDecimal,
 address: MyAddress
) extends Account

case class Lens[Obj, Value]
(
  get: Obj => Value,
  set: (Obj, Value) => Obj
)

object TestUpdateCaseClass {

  val srcAccount: MyAccount = MyAccount("111", "wong", 100, MyAddress(1, "深圳", "518000"))

  /**
   * 声明修改邮编的"透镜"
   */
  val accountAddressZipLens: Lens[MyAccount, String] = Lens[MyAccount, String](
    get = _.address.zip,
    set = (obj, value) => obj.copy(address = obj.address.copy(zip = value))
  )

  def updateAccountAddressZipByLens(srcAccount: MyAccount, newAddressZip: String): MyAccount = {
    return accountAddressZipLens.set(srcAccount, newAddressZip)
  }

  def updateAccountAddressZipByCopy(srcAccount: MyAccount, newAddressZip: String): MyAccount = {
    return srcAccount.copy(
      address = srcAccount.address.copy(zip = newAddressZip)
    )
  }

  def main(args: Array[String]): Unit = {
    println(s"srcAccount: $srcAccount")

    // 使用 copy 函数来更新
    val account1: MyAccount = updateAccountAddressZipByCopy(srcAccount, "518001")
    println(s"update address zip by copy: $account1")

    // 使用透镜来更新
    val account2: MyAccount = updateAccountAddressZipByLens(srcAccount, "518002")
    println(s"update address zip by lens: $account2")
  }

}
