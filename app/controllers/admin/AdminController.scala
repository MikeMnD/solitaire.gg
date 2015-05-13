package controllers.admin

import java.util.UUID

import akka.pattern.ask
import akka.util.Timeout
import controllers.BaseController
import models._
import models.database.queries.auth.UserQueries
import models.user.{WithRole, Role}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import services.ActorSupervisor
import services.database.Database

import scala.concurrent.Future
import scala.concurrent.duration._
import scala.util.Random

object AdminController extends BaseController {
  implicit val timeout = Timeout(10.seconds)

  def enable = SecuredAction.async { implicit request =>
    Database.execute(UserQueries.AddRole(request.identity.id, Role.Admin)).map { x =>
      Ok("OK")
    }
  }

  def status = SecuredAction(WithRole(Role.Admin)).async { implicit request =>
    (ActorSupervisor.instance ask GetSystemStatus).map {
      case x: SystemStatus => Ok(views.html.admin.status(x))
    }
  }

  def observeRandomGame() = SecuredAction(WithRole(Role.Admin)).async { implicit request =>
    (ActorSupervisor.instance ask GetSystemStatus).map {
      case ss: SystemStatus => if (ss.games.isEmpty) {
        Ok("No games available.")
      } else {
        val gameId = ss.games(new Random().nextInt(ss.games.length))._1
        Ok(views.html.game.gameplay(Some(request.identity), "", Seq("observe", gameId.toString)))
      }
      case se: ServerError => Ok(se.reason + ": " + se.content)
    }
  }

  def observeGameAsAdmin(gameId: UUID) = SecuredAction(WithRole(Role.Admin)).async { implicit request =>
    Future.successful(Ok(views.html.game.gameplay(Some(request.identity), "", Seq("observe", gameId.toString))))
  }

  def observeGameAs(gameId: UUID, as: UUID) = SecuredAction(WithRole(Role.Admin)).async { implicit request =>
    Future.successful(Ok(views.html.game.gameplay(Some(request.identity), "", Seq("observe", gameId.toString, as.toString))))
  }
}
