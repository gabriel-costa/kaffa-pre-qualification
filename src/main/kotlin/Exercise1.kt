package main

fun main() {
    val cnpj = readLine()

    if(checkNumbersOnly(cnpj!!) or checkFormat(cnpj))
        println("It looks like a CNPJ")
    else
        println("It doesn't looks like a CNPJ")
}

fun checkNumbersOnly(cnpj: String): Boolean {
    if(cnpj.length != 14) {
        return false
    }
    return cnpj.none { c -> !c.isDigit() }
}

fun checkFormat(cnpj: String): Boolean {
    if(cnpj.length != 18) {
        return false
    }
    val cnpjNumbersOnly = toNumbersOnlyCNPJ(cnpj)
    return cnpj[2] == '.' && cnpj[6] == '.' && cnpj[10] == '/' && cnpj[15] == '-' && checkNumbersOnly(cnpjNumbersOnly)
}

fun toNumbersOnlyCNPJ(cnpj: String) = cnpj.replace(".", "").replace("/", "").replace("-", "")