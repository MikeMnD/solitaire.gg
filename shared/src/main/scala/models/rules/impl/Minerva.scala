package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Reserve initial cards (R0d): 11
 *   Reserve cards face down (R0df): 0
 *   Number of reserve piles (R0n): 1
 *   Tableau initial cards (T0d): 4 (4 cards)
 *   Tableau cards face down (T0df): 102
 *   Empty tableau is filled with (T0f): 1 (Kings only)
 *   Tableau piles (T0n): 7
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Tableau suit match rule for moving stacks (T0ts): 4 (In alternating colors)
 *   Deal cards from stock (dealchunk): 1 (One by one)
 *   Similar to (like): athena
 *   Maximum deals from stock (maxdeals): 2 (2)
 *   Related games (related): doubleminerva, tripleminerva, munger, mystique
 */
object Minerva extends GameRules(
  id = "minerva",
  completed = false,
  title = "Minerva",
  like = Some("athena"),
  related = Seq("doubleminerva", "tripleminerva", "munger", "mystique"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/minerva.htm")),
  layout = "swf|r|t",
  stock = Some(StockRules(maximumDeals = Some(2))),
  waste = Some(WasteRules()),
  foundations = Seq(FoundationRules(numPiles = 4, autoMoveCards = true)),
  tableaus = Seq(
    TableauRules(
      initialCards = InitialCards.Count(4),
      cardsFaceDown = TableauFaceDownCards.OddNumbered,
      emptyFilledWith = FillEmptyWith.HighRank
    )
  ),
  reserves = Some(ReserveRules(initialCards = 11))
)
