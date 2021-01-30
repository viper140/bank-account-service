package account.model

/**
 * 支票账户类（无息）
 */
case class CheckingAccount
(number: String,
 name: String,
 balance: BigDecimal
) extends Account

/**
 * 储蓄账户类（有息）
 */
case class SavingAccount
(number: String,
 name: String,
 balance: BigDecimal,
 rateOfInterest: BigDecimal
) extends InterestBearingAccount

/**
 * 货币市场账户（有息）
 */
case class MoneyMarketAccount
(number: String,
 name: String, balance: BigDecimal,
 rateOfInterest: BigDecimal
) extends InterestBearingAccount