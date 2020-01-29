package main

import org.json.simple.JSONObject
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// i used these two jars(javax.servlet-3.0.jar and javax.servlet-api-3.0.1) to implement the servlet
// and run a tomcat v8.5.50 as a server, the configurations at src/main/resources/tomcatConfigs.png
// i used the Smart Tomcat plugin to run it with Intellij Community
class Exercise7 : HttpServlet() {
    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.contentType = "text/html"
        val out = res.writer
        val json = JSONObject()
        // getting the datetime and then returning it
        val dateTime = getDateTime()
        json["currentDateTime"] = dateTime.first
        json["timeZone"] = dateTime.second
        out.print(json.toString())
    }
}