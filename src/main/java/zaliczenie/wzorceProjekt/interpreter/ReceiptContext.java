package zaliczenie.wzorceProjekt.interpreter;

import zaliczenie.wzorceProjekt.models.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Klasa kontekstu, przechowująca zmienne i ich wartości
public class ReceiptContext {
    private Map<String, Object> variables;

    public ReceiptContext() {
        this.variables = new HashMap<>();
    }

    public void setVariable(String variableName, Object value) {
        variables.put(variableName, value);
    }

    public Object getVariableValue(String variableName) {
        return variables.get(variableName);
    }
    public Map<String, Object> getVariables()
    {
        return this.variables;
    }

    public void AddCar(Car car, int amount, double price)
    {
        Map<String, Object> rent = new HashMap<>();
        rent.put("name", car.getBrand());
        rent.put("amount", amount);
        rent.put("price", price*amount);
        List<Map<String, Object>> rentDetails = (List<Map<String, Object>>) variables.get("rentDetails");
        if(rentDetails == null) {
            rentDetails = new ArrayList<Map<String, Object>>();
        }
        rentDetails.add(rent);
        setVariable("rentDetails", rentDetails);
    }
    public void mapFromInput(String input)
    {
        var tokenizer = new Tokenizer();
        Map<String, Object> tokens = tokenizer.tokenize(input);
        setVariable("transaction", tokens.get("transaction"));
        setVariable("totalPrice", tokens.get("totalPrice"));
        setVariable("rentDetails", tokens.get("rentDetails"));
    }

    public String mapToOutput()
    {
        Tokenizer tokenizer = new Tokenizer();
        return tokenizer.mapToOutput(this);
    }
}
