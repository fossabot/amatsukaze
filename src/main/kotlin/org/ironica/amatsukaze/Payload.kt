package org.ironica.amatsukaze

import kotlinx.serialization.Serializable

@Serializable
data class SerializedPlayer(val id: Int, val x: Int, val y: Int, val dir: Direction, val role: Role)

@Serializable
data class SerializedPlayground(val grid: Grid, val layout: Layout, val layout2s: SecondLayout)

@Serializable
data class Payload(val players: Array<SerializedPlayer>, val portals: Array<Portal>, val grid: SerializedPlayground, val consoleLog: String, val special: String)


val payloadStorage = mutableListOf<Payload>()

enum class Status { OK, ERROR }

@Serializable
sealed class Message
@Serializable
data class NormalMessage(val status: Status, val payload: List<Payload>): Message()
@Serializable
data class ErrorMessage(val status: Status, val msg: String): Message()