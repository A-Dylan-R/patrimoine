package school.hei.patrimoine.possession;

import school.hei.patrimoine.NotImplemented;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public final class Materiel extends Possession {
  private final double tauxDAppreciationAnnuelle;

  public Materiel(String nom, Instant t, int valeurComptable, double tauxDAppreciationAnnuelle) {
    super(nom, t, valeurComptable);
    this.tauxDAppreciationAnnuelle = tauxDAppreciationAnnuelle;
  }

  @Override
  public Possession projectionFuture(Instant tFutur) {

    double NbAnnée = ChronoUnit.DAYS.between(t, tFutur) / 365.0;
    double valeurFuture = getValeurComptable() * Math.pow(1 + tauxDAppreciationAnnuelle, NbAnnée);

    return new Materiel(
            getNom(),
            tFutur,
            (int) valeurFuture,
            tauxDAppreciationAnnuelle
    );
  }
}
