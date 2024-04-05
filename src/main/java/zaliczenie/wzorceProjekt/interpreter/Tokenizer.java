package zaliczenie.wzorceProjekt.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tokenizer {
    public Map<String, Object> tokenize(String input) {
        Map<String, Object> tokens = new HashMap<>();

        String[] parts = input.split(";");

        for (String part : parts) {
            String[] keyValue = part.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                if (key.equalsIgnoreCase("transaction")) {
                    tokens.put("transaction", value);
                } else if (key.equalsIgnoreCase("totalprice")) {
                    tokens.put("totalPrice", Double.parseDouble(value));
                } else if (key.equalsIgnoreCase("rentDetails")) {
                    String[] rents = value.split(",");
                    tokens.put("rentDetails", parseRentDetails(rents));
                }
            }
        }

        return tokens;
    }
    private List<Map<String, Object>> parseRentDetails(String[] rents) {
        List<Map<String, Object>> rentDetails = new ArrayList<>();

        for (String rent : rents) {
            String[] productInfo = rent.split("-");
            if (productInfo.length == 3) {
                Map<String, Object> rentMap = new HashMap<>();
                rentMap.put("name", productInfo[0].trim());
                rentMap.put("amount", Integer.parseInt(productInfo[1].trim()));
                rentMap.put("price", Double.parseDouble(productInfo[2].trim()));
                rentDetails.add(rentMap);
            }
        }

        return rentDetails;
    }

    public String mapToOutput(ReceiptContext context) {
        StringBuilder inputBuilder = new StringBuilder();

        Object transaction = context.getVariableValue("transaction");
        if (transaction != null) {
            inputBuilder.append("transaction:").append(transaction).append(";");
        }

        Object totalPrice = context.getVariableValue("totalPrice");
        if (totalPrice != null) {
            inputBuilder.append("totalPrice:").append(totalPrice).append(";");
        }

        List<Map<String, Object>> productDetails = (List<Map<String, Object>>) context.getVariableValue("rentDetails");
        if (productDetails != null) {
            inputBuilder.append("rentDetails:");
            for (Map<String, Object> product : productDetails) {
                inputBuilder.append(product.get("name")).append("-")
                        .append(product.get("amount")).append("-")
                        .append(product.get("price")).append(",");
            }

            inputBuilder.deleteCharAt(inputBuilder.length() - 1);
            inputBuilder.append(";");
        }

        return inputBuilder.toString();
    }
}