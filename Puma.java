package oop.pillars.ia_lab;

public class Puma implements PumaFactory {

    @Override
   public void palermo(){
        System.out.println("Puma Palermo lang malakas");
    };

    @Override
    public void suede(){
        System.out.println("Kim bok Joo Suede");
    };

    @Override
    public void clyde(){
        System.out.println("Clyde");
    };

    @Override
    public void armyTrainers(){
        System.out.println("None of the above");
    };
}
