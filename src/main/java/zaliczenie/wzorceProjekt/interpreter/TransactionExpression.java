package zaliczenie.wzorceProjekt.interpreter;

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
