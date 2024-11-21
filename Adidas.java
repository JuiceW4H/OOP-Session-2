package oop.pillars.ia_lab;

class Adidas extends AdidasFactory{

    @Override
    public void samba() {
        System.out.println("Adidas Samba lang malakas");
    }

    @Override
    public void superstar() {
        System.out.println("Kim bok Joo Superstar");
    }

    @Override
    public void stanSmith() {
        System.out.println("Stan Smith");
    }

    @Override
    public void gazelle() {
        System.out.println("None of the above");
    }
}
