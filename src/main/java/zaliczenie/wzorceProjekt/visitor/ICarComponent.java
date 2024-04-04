package zaliczenie.wzorceProjekt.visitor;

public interface ICarComponent {
    void Accept(ICarVisitor visitor);
}
