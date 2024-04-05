package zaliczenie.wzorceProjekt.interpreter;

import java.util.Map;

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