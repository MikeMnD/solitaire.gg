package models.pile.set

import models.pile.Pile
import models.pile.options.CellPileOptions
import models.rules.CellRules

object CellSet {
  def apply(cellRules: CellRules): CellSet = {
    val prefix = "cell-"
    val options = CellPileOptions(cellRules)
    val piles = (1 to cellRules.numPiles).map { i =>
      Pile(prefix + i, options)
    }
    new CellSet(piles)
  }
}

class CellSet(piles: IndexedSeq[Pile]) extends PileSet(PileSet.Behavior.Cell, piles, visible = true)
