package utils.parser.politaire

import models.game.rules.CellSet
import utils.parser.politaire.lookup.PolitaireLookup

trait ParserCellHelper { this: GameRulesParser =>
  protected[this] def getCells = {
    getInt("C0n") match {
      case 0 => None
      case numPiles =>
        Some(CellSet(
          name = getString("C0Ns"),
          pluralName = getString("C0Nm"),
          numPiles = numPiles,
          canMoveFrom = PolitaireLookup.parseBitmask("C0o", getInt("C0o")),
          initialCards = getInt("C0d"),
          numEphemeral = getInt("C0e")
        ))
    }
  }
}
