package zaliczenie.wzorceProjekt.models;

import zaliczenie.wzorceProjekt.observers.Observer;

public class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }
    
    //Tydzień 6, Wzorzec Obserwator, tworzy system informowania użytkownika o zmianie na stanie dostępnych samochodów w menedzerze
    //daje możliwość dołączenia lub odłączenia się od systemu za pomocą subskrybcji do systemu
    @Override
    public void update() {
        System.out.println(" "+ name + " zmienił się stan dostępnych samochodów");
    }
    //Koniec Tydzień 6, Wzorzec Obserwator
}
