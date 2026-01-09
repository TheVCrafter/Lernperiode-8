class Calculator constructor(firstValue: Int, secondValue: Int, operator:Char){
    private val _firstValue = firstValue
    private val _secondValue = secondValue
    private var _operator = operator

    fun Calculate(): String {
        while (true) {
            val result = when (_operator) {
                '*' -> _firstValue * _secondValue
                '/' -> if (_secondValue != 0) _firstValue / _secondValue else null
                '+' -> _firstValue + _secondValue
                '-' -> _firstValue - _secondValue
                else -> null
            }
            if (result == null) {
                print("Please enter a valid Operator [*],[/],[+],[-]: ")
                _operator = readln()[0]
            } else return "The Result is $result"
        }
    }
}