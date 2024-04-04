package zaliczenie.wzorceProjekt.visitor;
//Tydzień 6, Wzorzec Odwiedzający, pozwala na odwiedzanie konkretnych obiektów i wykonywania na nim operacji bez naruszania kodu wewnętrznego klasy
public interface ICarComponent {
    void Accept(ICarVisitor visitor);
}
//Koniec tydzień 6, Wzorzec Odwiedzający