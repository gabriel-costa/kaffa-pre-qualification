fun main() {
    val cnpj = readLine()
    if (checkFormat(cnpj!!) and validateCNPJ(cnpj))
        println("It looks like a CNPJ")
    else
        println("It doesn't looks like a CNPJ")
}

fun validateCNPJ(cnpj: String): Boolean {
    // mask already validated on checkFormat, so we'll work only with the validator digits
    var numbersOnlyCNPJ = toNumbersOnlyCNPJ(cnpj)

    // extracting the supposed validator digits that came with the CNPJ
    val supposedFirstValidatorDigit = numbersOnlyCNPJ[numbersOnlyCNPJ.length - 2]
    val supposedSecondValidatorDigit = numbersOnlyCNPJ[numbersOnlyCNPJ.length - 1]
    numbersOnlyCNPJ = numbersOnlyCNPJ.removeRange(numbersOnlyCNPJ.length - 2, numbersOnlyCNPJ.length)

    // calculating the real validator digits
    val firstValidatorDigit = findValidatorDigit(numbersOnlyCNPJ)
    numbersOnlyCNPJ += supposedFirstValidatorDigit
    val secondValidatorDigit = findValidatorDigit(numbersOnlyCNPJ)

    // see if they match
    return firstValidatorDigit == supposedFirstValidatorDigit.toString().toInt() &&
            secondValidatorDigit == supposedSecondValidatorDigit.toString().toInt()
}

private fun findValidatorDigit(numbersOnlyCNPJ: String): Int {
    var sum = 0
    var multiplicand = 2
    // basically going through the reversed CNPJ multiplicating each number of it by a multiplicand
    // that starts at 2 and increases by 1 per iteration and if it reaches 9, it starts on 2 again
    for (currentNumber in numbersOnlyCNPJ.reversed()) {
        sum += currentNumber.toString().toInt() * multiplicand
        multiplicand++
        if (multiplicand > 9) multiplicand = 2
    }

    // functional version, but less understandable
//    var multiplicand = 1
//    val sum = numbersOnlyCNPJ.foldRight(0) { currentNumber: Char, result: Int ->
//        if (multiplicand > 8)
//            multiplicand = 1
//        multiplicand++
//        result + (currentNumber.toString().toInt() * multiplicand)
//    }

    val restOfDivision = sum % 11

    return if (restOfDivision == 0 || restOfDivision == 1) {
        0
    } else {
        11 - restOfDivision
    }
}