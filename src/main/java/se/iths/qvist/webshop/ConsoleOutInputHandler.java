package se.iths.qvist.webshop;

public class ConsoleOutInputHandler implements OutInputHandler {

    public String prompt(String message) {
        boolean isValid = false;
        String userInput = null;

        while (!isValid) {
            userInput = IO.readln(message);
            isValid = !userInput.isBlank();

            if (!isValid) {
                info("The input can not be empty, Try again!");
            }
        }

        return userInput;
    }

    public void info(String message) {
        IO.println(message);
    }

    public int menu() {
        boolean isValid = false;
        int userChoiceIntValue = 0;

        while (!isValid) {
            String userChoice = prompt("1. Add Product\n" +
                    "2. List all products\n" +
                    "3. Search for product\n" +
                    "4. Exit application\n");

            if (isValidNumber(userChoice)) {
                userChoiceIntValue = Integer.parseInt(userChoice);
                isValid = true;
            }
        }

        return userChoiceIntValue;
    }

    private boolean isValidNumber(String userInput) {
        int maxValue = 4;
        int minValue = 1;

        try {
            int finalValue = Integer.parseInt(userInput);

            if (!(finalValue <= maxValue && finalValue >= minValue)) {
                info("Please select on of the valid options\n");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            info("Not a valid number, try again!\n");
            return false;
        }
    }
}
