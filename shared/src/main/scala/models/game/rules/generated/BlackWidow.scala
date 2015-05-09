// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

/**
 * Original Settings:
 *   Auto-move cards to foundation (F0a): 0 (Never)
 *   Foundation add complete sequences only (F0cs): true
 *   Tableau initial cards (T0d): -2 (custom)
 *   Custom initial cards (T0ds): DDDDDU DDDDDU DDDDDU DDDDDU DDDDU DDDDU DDDDU DDDDU DDDDU DDDDU
 *   Tableau piles (T0n): 10
 *   Tableau suit match rule for building (T0s): 5 (Regardless of suit)
 *   Tableau suit match rule for moving stacks (T0ts): 5 (Regardless of suit)
 *   Number of waste piles (W0n): 0
 *   Deal cards from stock (dealto): 3 (To all tableau piles if none empty)
 *   Left mouse interface function (leftfunc): 0x2|0x20
 *   Similar to (like): spider
 *   Number of decks (ndecks): 2 (2 decks)
 *   Related games (related): fredsspider, chinesespider, astrocyte, mondospider, tarantula, trillium, spidero...
 *   Right mouse interface function (rightfunc): 0x0
 *   Victory condition (victory): 3 (All cards on tableau sorted)
 */
object BlackWidow extends GameRules(
  id = "blackwidow",
  title = "Black Widow",
  like = Some("spider"),
  related = Seq(
    "fredsspider", "chinesespider", "astrocyte", "mondospider", "tarantula", "trillium", "spideronesuit", "spidertwosuits",
    "spiderette", "blackwidow", "hugespider", "beetle", "bigspider"
  ),
  links = Seq(
    Link("Solitaire Central", "www.solitairecentral.com/rules/BlackWidow.html"),
    Link("BVS Solitaire Collection", "www.bvssolitaire.com/rules/black-widow.htm"),
    Link("Rapture Technologies KingSol", "www.rapturetech.com/KingSol/Rules/BlackWidow.htm"),
    Link("Solavant Solitaire", "www.solavant.com/solitaire/black_widow.php"),
    Link("Bryan Cohen on eHow", "www.ehow.com/list_6702718_black-widow-card-game-rules.html")
  ),
  description = "An easier variation of ^spider^ where you are allowed to move sequences even if they aren't all of one suit.",
  victoryCondition = VictoryCondition.AllOnTableauSorted,
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      dealTo = StockDealTo.TableauIfNoneEmpty,
      maximumDeals = Some(1)
    )
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      wrapFromKingToAce = true,
      moveCompleteSequencesOnly = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 10,
      initialCards = InitialCards.Custom,
      customInitialCards = Seq(
        "DDDDDU",
        "DDDDDU",
        "DDDDDU",
        "DDDDDU",
        "DDDDU",
        "DDDDU",
        "DDDDU",
        "DDDDU",
        "DDDDU",
        "DDDDU"
      ),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.Any,
      suitMatchRuleForMovingStacks = SuitMatchRule.Any,
      emptyFilledWith = FillEmptyWith.Aces
    )
  ),
  complete = false
)
