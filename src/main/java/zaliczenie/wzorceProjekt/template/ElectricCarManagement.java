/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zaliczenie.wzorceProjekt.template;

public class ElectricCarManagement extends CarManagementProcess {
    @Override
    protected void reserveVehicle() {
         System.out.println("Rezerwowanie samochodu elektrycznego");
    }

    @Override
    protected void performMaintenance() {
         System.out.println("Przęglądanie samochodu elektrycznego");
    }

    @Override
    protected void releaseVehicle() {
        System.out.println("Oddawanie samochodu elektrycznego");
    }
}