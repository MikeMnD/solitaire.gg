package models.game.generated

import models.game._
import models.game.rules._

// scalastyle:off
object UpAndUp extends GameRules(
  id = "upandup",
  title = "Up and Up",
  description = "A variation of ^trustytwelve^ where you can build kings on aces.",
  victoryCondition = VictoryCondition.NoneInStock,
  cardRemovalMethod = CardRemovalMethod.BuildSequencesOnFoundation,
  deckOptions = DeckOptions(
    numDecks = 1,
    suits = Seq(Suit.Hearts, Suit.Spades, Suit.Diamonds, Suit.Clubs),
    ranks = Seq(Rank.Two, Rank.Three, Rank.Four, Rank.Five, Rank.Six, Rank.Seven, Rank.Eight, Rank.Nine, Rank.Ten, Rank.Jack, Rank.Queen, Rank.King, Rank.Ace),
    lowRank = Some(Rank.Ace)
  ),
  stock = Some(
    Stock(
      name = "Stock",
      dealTo = StockDealTo.Manually,
      maximumDeals = Some(1),
      cardsDealt = StockCardsDealt.Count(1),
      stopAfterPartialDeal = true,
      createPocketWhenEmpty = false,
      galleryMode = false
    )
  ),
  waste = None,
  foundations = Nil,
  tableaus = Nil,
  cells = None,
  reserves = None,
  pyramids = Nil
)
// scalastyle:on
