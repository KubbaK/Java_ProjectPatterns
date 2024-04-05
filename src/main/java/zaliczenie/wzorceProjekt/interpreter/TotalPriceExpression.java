package zaliczenie.wzorceProjekt.interpreter;

//Tydzień 5, Początek Interpreter, który intepretuje kontekst paragonu
public class TotalPriceExpression implements IExpression {
    private String totalPriceVariable;

    public TotalPriceExpression(String totalPriceVariable) {
        this.totalPriceVariable = totalPriceVariable;
    }

    @Override
    public void interpret(ReceiptContext context) {

        System.out.println("Cena końcowa: " + context.getVariableValue(totalPriceVariable));
    }
}
//Tydzień 5, Koniec Interpretera