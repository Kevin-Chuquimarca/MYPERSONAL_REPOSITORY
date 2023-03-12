/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.capasgrupo05.presentation;

import ec.edu.monster.capasgrupo05.service.CakeBakingService;

/**
 *
 * @author santi
 */
public class CakeViewImpl implements View {

  private final CakeBakingService cakeBakingService;

  public CakeViewImpl(CakeBakingService cakeBakingService) {
    this.cakeBakingService = cakeBakingService;
  }

  public void render() {
    cakeBakingService.getAllCakes().forEach(cake -> System.out.println(cake.toString()));
  }
}