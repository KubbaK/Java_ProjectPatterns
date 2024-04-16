package zaliczenie.wzorceProjekt.iterators;

//Tydzień 8, Odwrócenie zależności
//Tydzień 5, Wzorzec Iterator, Umożliwia dostęp do elementów kolekcji w sposób znormalizowany, niezależny od konkretnych implementacji kolekcji
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
//Koniec tydzien 5, Iterator
//Koniec tydzień 8, Odwrócenie zależności