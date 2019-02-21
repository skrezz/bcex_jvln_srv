package app

import io.javalin.Javalin
import io.javalin.websocket.WsSession
import j2html.TagCreator.*
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ConcurrentHashMap

private val userUsernameMap = ConcurrentHashMap<WsSession, String>()
private var nextUserNumber = 1 // Assign to username for next connecting user
fun main(args: Array<String>) {
    val dbc = DbConnect()
    dbc.InitDb()
    Javalin.create().apply {
        port(7070)
        ws("/chat"){ws->
            ws.onConnect { session ->
                val username = "User" + nextUserNumber++
                userUsernameMap[session] = username
                println("$username joined the chat")
                session.send("hello")
            }
            ws.onMessage { session, message ->
                println("Received: $message")
             //   session.remote.sendString("Echo: $message")
                if (message=="Start insert"){

                }
            }
        }
    }.start()





}