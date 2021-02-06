package tax.model

import scala.collection.immutable.HashMap

trait TaxType

case object Tax extends TaxType

case object Fee extends TaxType

case object Commission extends TaxType

// 交易类型
sealed trait TransactionType

case object InterestComputation extends TransactionType

case object Dividend extends TransactionType

case class Balance(amount: BigDecimal = 0)

/**
 * 计算税费：基于交易类型 TransactionType
 */
trait TaxCalculationTable {
  type T <: TransactionType
  val tranType: T

  def getTaxRates: Map[TaxType, BigDecimal] = {
    return new HashMap[TaxType, BigDecimal]
  }
}

/**
 * 计算税费：基于税费计算表 TaxCalculationTable
 */
trait TaxCalculation {
  type S <: TaxCalculationTable
  val table: S

  def calculate(taxOn: BigDecimal): BigDecimal = {
    return table.getTaxRates.map {
      case (k, v) => doCompute(taxOn, v)
    }.sum
  }

  def doCompute(taxOn: BigDecimal, rate: BigDecimal): BigDecimal = {
    return taxOn * rate
  }
}

/**
 * 计算税费：基于特定区域的额外税收
 */
trait SingaporeTaxCalculation extends TaxCalculation {
  def calculateGST(tax: BigDecimal, gstRate: BigDecimal): BigDecimal = {
    return tax * gstRate
  }
}

/**
 * 计算利息
 */
trait InterestCalculation {
  type C <: TaxCalculation
  val taxCalculation: C

  def interest(balance: Balance): Option[BigDecimal] = {
    return Some(balance.amount * 0.05)
  }

  def calculate(balance: Balance): Option[BigDecimal] = {
    return interest(balance)
      .map(item => item - taxCalculation.calculate(item))
  }
}