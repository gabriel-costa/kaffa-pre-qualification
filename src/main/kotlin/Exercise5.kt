package main

import java.io.File
import java.io.FileWriter

private val filePath = "src/main/kotlin/TodoList.txt"

fun main() {
    var input = ""
    while (input != "3") {
        // reading the list from a file and printing it
        val toDoList = File(filePath).readLines()
        println("------------ TO DO LIST ------------")
        toDoList.forEachIndexed { index, item ->
            println("${index + 1}- $item")
        }
        // menu
        println("--------- Choose an option ---------")
        println("1 - Add item to list")
        println("2 - Remove item of list")
        println("3 - Quit")
        input = readLine()!!

        val fwAppend = FileWriter(filePath, true)
        // inserting an item
        if (input == "1") {
            println("Write what you want to add:")
            val newItem = readLine()!!
            // checking if the list is empty, so it doesn't insert an empty line item
            if (toDoList.isNotEmpty()) {
                fwAppend.write(System.getProperty("line.separator") + newItem)
            } else {
                fwAppend.write(newItem)
            }
            // deleting an item
        } else if (input == "2") {
            println("Choose the item to remove(number):")
            val indexToBeRemoved = readLine()!!
            // removing the item from the conversion to mutable list
            val mutableToDoList = toDoList.toMutableList()
            println("You removed: ${mutableToDoList.removeAt(indexToBeRemoved.toInt() - 1)}")
            // deleting the content of the file
            val fwOverWriter = FileWriter(filePath)
            if (mutableToDoList.isNotEmpty()) {
                fwOverWriter.write(mutableToDoList[0])
            }
            fwOverWriter.close()
            // then, rewriting it without the removed element
            mutableToDoList.forEachIndexed { index, it ->
                if (index != 0)
                    fwAppend.write(System.getProperty("line.separator") + it)
            }
        }
        fwAppend.close()
    }
}