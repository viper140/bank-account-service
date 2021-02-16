package functors

/**
 * 为什么一定要是 abstract
 */
abstract class MyFunctor {

  var value: AnyVal

  def this(value: AnyVal) {
    this()
    this.value = value
  }

  def of = new MyFunctor(value: AnyVal) {
    override var value: AnyVal = _
  }
}
