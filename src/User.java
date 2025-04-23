import java.util.*;
public class User {
    private String username;
    private String password;
    private List<Income> incomes;
    private List<Expense> expenses;
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
    public void addIncome(Income i){
        incomes.add(i);
    }
    public void editIncome(){
        //someone needs to code this
    }
    public void deleteIncome(int index){
        incomes.remove(index);
    }
    public void addExpense(Expense e){
        expenses.add(e);
    }
    public void editExpense(){
        //someone needs to code this
    }
    public void deleteExpense(int index){
        expenses.remove(index);
    }
}
