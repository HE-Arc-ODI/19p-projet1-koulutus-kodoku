package ch.hearc.odi.koulutus.business;

public enum Status {

  OPEN("open"),
  CONFIRMED("confirmed"),
  CANCELLED("cancelled");

  private String libelle;

  Status(String libelle) {
    this.libelle = libelle;
  }

  public String getLibelle() {
    return libelle.toUpperCase();
  }
}
