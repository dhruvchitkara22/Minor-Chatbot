package com.example.minorchatbot;

public class ChatbotResponse {
    String str = null;
    ChatbotResponse(String val)
    {
        this.str = val;
    }
    String returnAnswer()
    {
        String answer;
        switch (this.str){
            case "Hello": answer = "Welcome To minor chat bot. How may i help you";
                        break;
            case "Account balance": answer = checkAccountBalance();
                        break;
            case "Transfer" : Boolean val = moneyTransfer();
                        if(val)
                            answer = "Transaction completed successfully";
                        else
                            answer = "Something Went Wrong";
                        break;
            case "Open Account" : answer = "Enter Details";
                                    openAccount();
                        break;
            default: answer = "Please Try again";
        }
        return answer;
    }

    private void openAccount() {
    }

    private Boolean moneyTransfer() {
        //implement later
        return true;
    }

    private String checkAccountBalance() {
        //implement later
        return str;
    }
}


