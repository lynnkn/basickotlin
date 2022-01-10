package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(value: Any): String {
    when(value) {
        "Hello" -> return "world"
        is String -> return "Say what?"
        0 -> return "zero"
        1 -> return "one"
        in 2..10 -> return "low number"
        is Int -> return "a number"
        else -> return "I don't understand"
    }
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(num1: Int, num2: Int): Int {
    return num1 + num2
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(num1: Int, num2: Int): Int {
    return num1 - num2
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(num1: Int, num2: Int, callback: (a: Int, b: Int) -> Int): Int {
    return callback(num1, num2)
}

// write a class "Person" with first name, last name and age
class Person(var firstName: String, val lastName: String, var age: Int) {
    val debugString: String = "[Person firstName:$firstName lastName:$lastName age:$age]"
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(var amount: Int, val currency: String) {
    // properties
    val validCurrencies = arrayOf("USD", "EUR", "CAN", "GBP")
    // checking exceptions
    init {
        if (amount <= 0) {
            throw IllegalArgumentException("Amount should not be negative")
        }
        if (currency !in validCurrencies) {
            throw IllegalArgumentException("Currency should be USD, EUR, CAN, or GBP")
        }
    }

    // converts the current Money instance to a different currency type and
    // returns a new Money instance with the amount converted
    fun convert(newCurrency: String): Money {
        var newAmount = amount * 1.0;
        if (newCurrency !==  currency) {
            if (currency === "USD") {
                if (newCurrency === "EUR") {
                    newAmount = amount * (3.0 / 2.0)
                } else if (newCurrency === "CAN") {
                    newAmount = amount * (5.0 / 4.0)
                } else {
                    newAmount = amount * (1.0 / 2.0)
                }
            } else if (currency === "EUR") {
                if (newCurrency === "USD") {
                    newAmount = amount * (2.0 / 3.0)
                } else if (newCurrency === "CAN") {
                    newAmount = amount * (5.0 / 6.0)
                } else {
                    newAmount = amount * (1.0 / 3.0)
                }
            } else if (currency === "CAN") {
                if (newCurrency === "USD") {
                    newAmount = amount * (4.0 / 5.0)
                } else if (newCurrency === "EUR") {
                    newAmount = amount * (6.0 / 5.0)
                } else {
                    newAmount = amount * (2.0 / 5.0)
                }
            } else {
                if (newCurrency === "USD") {
                    newAmount = amount * 2.0
                } else if (newCurrency === "EUR") {
                    newAmount = amount * 3.0
                } else {
                    newAmount = amount * (5.0 / 2.0)
                }
            }
        }
        
        return Money(newAmount.toInt(), newCurrency)
    }

    // overriding + operator
    operator fun plus(other: Money): Money {
        // convert the ammount passed  in before adding
        val converted = other.convert(this.currency)

        return Money(this.amount + converted.amount, this.currency)
    }
}
