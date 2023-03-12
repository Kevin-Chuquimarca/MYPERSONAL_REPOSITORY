/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.mvcgrupo05.model;

/**
 *
 * @author santi
 */
public class PatientModel {

  private Health health;
  private Fatigue fatigue;
  private Nourishment nourishment;

  public PatientModel(Health health, Fatigue fatigue, Nourishment nourishment) {
    this.health = health;
    this.fatigue = fatigue;
    this.nourishment = nourishment;
  }

  public Health getHealth() {
    return health;
  }

  public void setHealth(Health health) {
    this.health = health;
  }

  public Fatigue getFatigue() {
    return fatigue;
  }

  public void setFatigue(Fatigue fatigue) {
    this.fatigue = fatigue;
  }

  public Nourishment getNourishment() {
    return nourishment;
  }

  public void setNourishment(Nourishment nourishment) {
    this.nourishment = nourishment;
  }

  @Override
  public String toString() {
    return String.format("Tabla con los datos del paciente \nSalud: %s \nFatiga: %s\nNutrición: %s.", health, fatigue, nourishment);
  }
}

