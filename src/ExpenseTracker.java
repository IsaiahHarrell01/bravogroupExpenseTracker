import javax.swing.*;
import java.util.*;
public class ExpenseTracker {
    private String applicationName;
    private List<User> users =  new ArrayList<>();
    public ExpenseTracker() {
        HomeWindow homeWindow = new HomeWindow();
        homeWindow.display();
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void removeUser(User user) {
        users.remove(user);
    }
    public void generateCombinedReport(){
        //not sure what this function is supposed to do
    }
}
