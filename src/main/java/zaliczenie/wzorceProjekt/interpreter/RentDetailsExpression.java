package zaliczenie.wzorceProjekt.interpreter;

import java.util.List;
import java.util.Map;
//Tydzień 5, Początek Interpreter, który intepretuje paragon
public class RentDetailsExpression implements IExpression {
    private String rentDetailsVariable;

    public RentDetailsExpression(String rentDetailsVariable) {
        this.rentDetailsVariable = rentDetailsVariable;
    }

    @Override
    public void interpret(ReceiptContext context) {

        List<Map<String, Object>> rentDetailsList = (List<Map<String, Object>>) context.getVariableValue(rentDetailsVariable);
        for (Map<String, Object> rentDetail : rentDetailsList) {
            System.out.println("Wypozyczenie: " + rentDetail.get("name") +
                    ", Ilość: " + rentDetail.get("amount") +
                    ", Cena: " + rentDetail.get("price"));
        }
    }
}
//Tydzień 5, koniec Interpretera