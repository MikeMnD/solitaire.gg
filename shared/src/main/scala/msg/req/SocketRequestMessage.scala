package msg.req

import java.util.UUID

import models.RequestMessage
import models.settings.Settings

sealed trait SocketRequestMessage

case class Ping(ts: Long) extends SocketRequestMessage
case class SaveSettings(settings: Settings) extends SocketRequestMessage

case class OnGameStart(id: UUID, rules: String, seed: Int, occurred: Long) extends SocketRequestMessage

case class MoveHistory(msg: RequestMessage, occurred: Long)
case class OnGameComplete(
  id: UUID, rules: String, seed: Int, status: String, duration: Long,
  moves: Int, undos: Int, redos: Int, score: Int, firstMove: Long, history: Seq[MoveHistory], occurred: Long
) extends SocketRequestMessage

case class ClientError(code: String, msg: String, data: String) extends SocketRequestMessage
