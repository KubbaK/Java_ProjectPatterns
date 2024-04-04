package zaliczenie.wzorceProjekt.iterators;

//Tydzień 5, Wzorzec Iterator, Umożliwia dostęp do elementów kolekcji w sposób znormalizowany, niezależny od konkretnych implementacji kolekcji
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
//Koniec tydzien 5, Iterator