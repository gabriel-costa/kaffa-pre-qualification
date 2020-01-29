package main

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.net.URL

// for this one you will need the org.json library which I downloaded here: http://www.java2s.com/Code/Jar/j/Downloadjsonsimple111jar.htm
fun main() {
    val (dateTime, timeZone) = getDateTime()
    val splitDateTime = dateTime.split(" ")
    val splitTime = splitDateTime[1].split(":")

    // UTC is three hours ahead of BRT
    val brtTime = splitDateTime[1].split(":")[0].toInt() - 3

//    while (true) {
    println("$dateTime $timeZone")
    println("${splitDateTime[0]} $brtTime:${splitTime[1]} BRT")
//    }
}

fun getDateTime(): Pair<String, String> {
    // getting the content of http://worldclockapi.com/api/json/utc/now and parsing it
    val content: Any? = URL("http://worldclockapi.com/api/json/utc/now").readText()
    val json = JSONParser().parse(content.toString()) as JSONObject

    // parsing the return
    val dateTime = json["currentDateTime"].toString().replace("T", " ").replace("Z", "")

    return Pair(dateTime, json["timeZoneName"].toString())
}