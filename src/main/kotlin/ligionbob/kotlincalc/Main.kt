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
    private var wasOperatorLastPressed : Boolean = false;

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
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = "8"
                action {
                    appendNum("8")
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = "9"
                action {
                    appendNum("9")
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = "+"
                action {
                    operatorPressed(OPERATOR.ADD)
                    wasOperatorLastPressed = true
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
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = "5"
                action {
                    appendNum("5")
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = "6"
                action {
                    appendNum("6")
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = "-"
                action {
                    operatorPressed(OPERATOR.SUBTRACT)
                    wasOperatorLastPressed = true
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
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = "2"
                action {
                    appendNum("2")
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = "3"
                action {
                    appendNum("3")
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = "*"
                action {
                    operatorPressed(OPERATOR.MULTIPLY)
                    wasOperatorLastPressed = true
                }
            }
        }
        hbox {
            alignment = Pos.CENTER
            spacing = 5.0

            button {
                text = " "
            }
            button {
                text = "0"
                action {
                    appendNum("0")
                    wasOperatorLastPressed = false
                }
            }
            button {
                text = " "
            }
            button {
                text = "/"
                action {
                    operatorPressed(OPERATOR.DIVIDE)
                    wasOperatorLastPressed = true
                }
            }
        }
    }
    private fun appendNum(number: String) {
        if(wasOperatorLastPressed) currentNumberString = 0
        if(currentNumberString == 0) {
            numberString1 += number
            numberView.text = numberString1
            println("$numberString1 = num1")
        }
        if(currentNumberString == 1) {
            numberString2 += number
            numberView.text = numberString2
            println("$numberString2 = num2")
        }
    }
    private fun operatorPressed(operator : OPERATOR) {
        if(this.operator == OPERATOR.UNDEFINED) this.operator = operator
        if(currentNumberString == 1) {
            try {
                numberDouble1 = numberString1.toDouble()
                numberDouble2 = numberString2.toDouble()
                println("$numberDouble1 num1; $numberDouble2 num2;" )
            } catch (nfe : NumberFormatException) {
                nfe.printStackTrace()
            }
            when (operator) {
                OPERATOR.ADD -> {
                    numberOut = numberDouble1 + numberDouble2
                    numberView.text = numberOut.toString()
                    numberString1 = numberOut.toString()
                    numberString2 = ""
                }
                OPERATOR.SUBTRACT -> {
                    numberOut = numberDouble1 - numberDouble2
                    numberView.text = numberOut.toString()
                    numberString1 = numberOut.toString()
                    numberString2 = ""
                }
                OPERATOR.DIVIDE -> {
                    numberOut = numberDouble1 / numberDouble2
                    numberView.text = numberOut.toString()
                    numberString1 = numberOut.toString()
                    numberString2 = ""
                }
                OPERATOR.MULTIPLY -> {
                    numberOut = numberDouble1 * numberDouble2
                    numberView.text = numberOut.toString()
                    numberString1 = numberOut.toString()
                    numberString2 = ""
                }
                else -> println("Undefined Number Operator")
            }
            println(numberOut)
        } else {
            currentNumberString = 1
        }
        this.operator = operator
    }
}
class Main : App(MainView::class)

fun main(args : Array<String>) {
    launch<Main>(args)
}