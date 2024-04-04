package zaliczenie.wzorceProjekt.iterators;

//Tydzień 5, Wzorzec Iterator, Umożliwia dostęp do elementów kolekcji w sposób znormalizowany, niezależny od konkretnych implementacji kolekcji
public interface Collection<T> {
    void addCar(T element);
    void removeCar(T element);
    Iterator<T> iterator();
}
//Koniec tydzien 5, Iterator