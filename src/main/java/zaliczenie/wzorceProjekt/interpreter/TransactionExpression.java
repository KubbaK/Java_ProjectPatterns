package zaliczenie.wzorceProjekt.interpreter;

import java.util.Map;

public class TransactionExpression implements IExpression {
    private String transactionVariable;

    public TransactionExpression(String transactionVariable) {
        this.transactionVariable = transactionVariable;
    }

    @Override
    public void interpret(ReceiptContext context) {

        System.out.println("Transakcja: " + context.getVariableValue(transactionVariable));
    }
}
