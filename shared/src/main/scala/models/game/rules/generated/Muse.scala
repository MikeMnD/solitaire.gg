// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

/**
 * Original Settings:
 *   Card initially dealt into cells (C0d): 7 (7 cards)
 *   Number of cells (C0n): 7
 *   Enable stock (Sn): 0 (No stock)
 *   Tableau initial cards (T0d): -1 (1 to n cards)
 *   Tableau piles (T0n): 9
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Tableau suit match rule for moving stacks (T0ts): 4 (In alternating colors)
 *   Waste name (W0Nm): Reserve
 *   Playable waste cards (W0a): true
 *   Number of waste piles (W0n): 0
 *   *W0s (W0s): true
 *   Similar to (like): kingalbert
 *   Related games (related): queenvictoria, muse, raglan
 *   Enable super moves, whatever those are (supermoves): 1
 */
object Muse extends GameRules(
  id = "muse",
  title = "Muse",
  like = Some("kingalbert"),
  related = Seq("queenvictoria", "muse", "raglan"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/muse.htm")),
  description = "This variation of ^kingalbert^ has cells instead of a reserve.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 9,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      emptyFilledWith = FillEmptyWith.Aces
    )
  ),
  cells = Some(
    CellRules(
      numPiles = 7,
      initialCards = 7
    )
  ),
  complete = false
)
