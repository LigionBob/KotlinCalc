package ligionbob.kotlincalc

import javafx.geometry.Pos
import javafx.scene.control.TextField
import tornadofx.*

class MainView : View() {
    val numberView = TextField();
    var numbers : List<Int> = List<Int>()

    override val root = vbox {

        title = "Kotlin Calculator"
        alignment = Pos.TOP_CENTER
        paddingLeft = 10.0
        paddingRight = 10.0
        paddingTop = 10.0
        paddingBottom = 10.0

        val numberView = textfield {
            isEditable = false
        }
        hbox {
            button {
                text = "7"
                action {
                    appendNum(7.0)
                }
            }
        }
        hbox {

        }
        hbox {

        }
    }
    private fun appendNum(number: Double) {

    }
}
class Main : App(MainView::class)

fun main(args : Array<String>) {
    launch<Main>(args)
}