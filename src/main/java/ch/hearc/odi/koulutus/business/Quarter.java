package ch.hearc.odi.koulutus.business;

public enum Quarter {
  Q1(1),
  Q2(2),
  Q3(3),
  Q4(4);

  private int numberOfQuarter;

  Quarter(int numberOfQuarter) {
    this.numberOfQuarter = numberOfQuarter;
  }

  public int getNumberOfQuarter() {
    return numberOfQuarter;
  }
}
