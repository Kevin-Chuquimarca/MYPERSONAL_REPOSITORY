/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.mvcgrupo05.controller;

import ec.edu.monster.mvcgrupo05.model.Fatigue;
import ec.edu.monster.mvcgrupo05.model.PatientModel;
import ec.edu.monster.mvcgrupo05.model.Health;
import ec.edu.monster.mvcgrupo05.model.Nourishment;
import ec.edu.monster.mvcgrupo05.view.PatientView;

/**
 *
 * @author santi
 */ 
public class PatientController {

  private final PatientModel giant;
  private final PatientView view;

  public PatientController(PatientModel giant, PatientView view) {
    this.giant = giant;
    this.view = view;
  }

  @SuppressWarnings("UnusedReturnValue")
  public Health getHealth() {
    return giant.getHealth();
  }

  public void setHealth(Health health) {
    this.giant.setHealth(health);
  }

  @SuppressWarnings("UnusedReturnValue")
  public Fatigue getFatigue() {
    return giant.getFatigue();
  }

  public void setFatigue(Fatigue fatigue) {
    this.giant.setFatigue(fatigue);
  }

  @SuppressWarnings("UnusedReturnValue")
  public Nourishment getNourishment() {
    return giant.getNourishment();
  }

  public void setNourishment(Nourishment nourishment) {
    this.giant.setNourishment(nourishment);
  }

  public void updateView() {
    this.view.displayGiant(giant);
  }
}