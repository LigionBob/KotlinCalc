package ligionbob.kotlincalc

import javafx.geometry.Pos
import javafx.scene.control.TextField
import tornadofx.*
import java.lang.NumberFormatException

class MainView : View() {
    private var numberView = TextField()
    private var numbers1 : String = ""
    private var numbers2 : String = String()
    private var isNumbers1Full : Boolean = false
    private var isNumbers2Full : Boolean = false

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
        numbers1 += number
        numberView.text = numbers1
        println(numbers1)
    }
}
class Main : App(MainView::class)

fun main(args : Array<String>) {
    launch<Main>(args)
}