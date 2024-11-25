package oop.pillars.ia_lab;

public class Main {
    public static void main(String[] args) {
        Puma newShoes1 = new Puma();
        Adidas newShoes2 = new Adidas();

        System.out.println('\n' + "Interface Outputs" + '\n');

        newShoes1.armyTrainers();
        newShoes1.palermo();
        newShoes1.suede();
        newShoes1.clyde();

        System.out.println('\n' +"Abstract Outputs" + '\n');
        newShoes2.gazelle();
        newShoes2.samba();
        newShoes2.superstar();
        newShoes2.stanSmith();


    }
}
