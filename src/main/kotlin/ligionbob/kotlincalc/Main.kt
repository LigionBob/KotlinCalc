package ligionbob.kotlincalc

import javafx.geometry.Pos
import javafx.scene.control.TextField
import tornadofx.*
import java.lang.NumberFormatException

class MainView : View() {
    private var numberView = TextField()
    private var numberString1 : String = ""
    private var numberDouble1 : Double = 0.0
    private var numberString2 : String = ""
    private var numberDouble2 : Double = 0.0
    private var numberOut : Double = 0.0
    private var operator : OPERATOR = OPERATOR.UNDEFINED
    private var currentNumberString : Int = 0

    override val root = vbox {

        title = "Kotlin Calculator"
        alignment = Pos.TOP_CENTER
        paddingLeft = 10.0
        paddingRight = 10.0
        paddingTop = 10.0
        paddingBottom = 10.0
        spacing = 5.0

        numberView = textfield {
            isEditable = false
            alignment = Pos.CENTER_RIGHT

        }
        hbox {
            alignment = Pos.CENTER
            spacing = 5.0
            button {
                text = "7"
                action {
                    appendNum("7")
                }
            }
            button {
                text = "8"
                action {
                    appendNum("8")
                }
            }
            button {
                text = "9"
                action {
                    appendNum("9")
                }
            }
            button {
                text = "+"
                action {
                    operatorPressed(OPERATOR.ADD)
                }
            }
        }
        hbox {
            alignment = Pos.CENTER
            spacing = 5.0
            button {
                text = "4"
                action {
                    appendNum("4")
                }
            }
            button {
                text = "5"
                action {
                    appendNum("5")
                }
            }
            button {
                text = "6"
                action {
                    appendNum("6")
                }
            }
        }
        hbox {
            alignment = Pos.CENTER
            spacing = 5.0
            button {
                text = "1"
                action {
                    appendNum("1")
                }
            }
            button {
                text = "2"
                action {
                    appendNum("2")
                }
            }
            button {
                text = "3"
                action {
                    appendNum("3")
                }
            }
        }
        button {
            text = "0"
            action {
                appendNum("0")
            }
        }
    }
    private fun appendNum(number: String) {
        println(number)
        if(currentNumberString == 0) {
            numberString1 += number
            numberView.text = numberString1
            println(numberString1)
        }
        if(currentNumberString == 1) {
            numberString2 += number
            numberView.text = numberString2
            println(numberString2)
        }
    }
    private fun operatorPressed(operator : OPERATOR) {
        this.operator = operator
        if(currentNumberString == 1) {
            try {
                numberDouble1 = numberString1.toDouble()
                numberDouble2 = numberString1.toDouble()
            } catch (nfe : NumberFormatException) {
                nfe.printStackTrace()
            }
            when (operator) {
                OPERATOR.ADD -> numberDouble1 + numberDouble2
                OPERATOR.SUBTRACT -> numberDouble1 - numberDouble2
                OPERATOR.DIVIDE -> numberDouble1 / numberDouble2
                OPERATOR.MULTIPLY -> numberDouble1 * numberDouble2
                else -> println("Undefined Number Operator")
            }
        } else {
            currentNumberString = 1
        }
    }
}
class Main : App(MainView::class)

fun main(args : Array<String>) {
    launch<Main>(args)
}