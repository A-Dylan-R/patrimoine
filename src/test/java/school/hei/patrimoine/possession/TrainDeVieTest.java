package school.hei.patrimoine.possession;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainDeVieTest {
  @Test
  void train_de_vie_est_finance_par_compte_courant() {
    var au13mai24 = Instant.parse("2024-05-13T00:00:00.00Z");
    var compteCourant = new Argent("Compte courant", au13mai24, 600_000);

    var aLOuvertureDeHEI = Instant.parse("2021-10-26T00:00:00.00Z");
    var aLaDiplomation = Instant.parse("2024-12-26T00:00:00.00Z");
    var vieEstudiantine = new TrainDeVie(
        "Ma super(?) vie d'etudiant",
        500_000,
        aLOuvertureDeHEI,
        aLaDiplomation,
        compteCourant,
        1);
    assertEquals(compteCourant, vieEstudiantine.getFinancePar());
    assertEquals(100_000, compteCourant.getValeurComptable() - vieEstudiantine.getDepensesMensuelle());
  }

  @Test
  void un_train_de_vie_financé_par_argent() {
    var au13mai24 = Instant.parse("2024-05-13T00:00:00.00Z");
    var financeur = new Argent("Espèces", au13mai24, 400_000);

    var Debut = Instant.parse("2024-07-13T00:00:00.00Z");
    var Fin = Instant.parse("2024-10-13T00:00:00.00Z");

    var trainDeVie = new TrainDeVie(
            "Voyage",
            200_000,
            Debut,
            Fin,
            financeur,
            7);
      assertEquals(trainDeVie.getFinancePar().getValeurComptable(), financeur.getValeurComptable());
      assertEquals(financeur, trainDeVie.getFinancePar());
  }
}