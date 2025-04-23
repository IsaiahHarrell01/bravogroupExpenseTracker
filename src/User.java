public class User {
    private String username;
    private String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public FinancialSummary getFinancialSummary(){
        //add code to put the correct data into these variables
        double totalIncome;
        double totalExpenses;
        double remainingBalance;
        return new FinancialSummary(totalIncome, totalExpenses, remainingBalance);
    }
    public void addIncome(){

    }
    public void editIncome(){

    }
    public void deleteIncome(){

    }
    public void addExpense(){

    }
    public void editExpense(){

    }
    public void deleteExpense(){

    }
}
