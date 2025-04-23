import javax.swing.*;
import java.awt.*;

public class HomeWindow {
    JFrame frame = new JFrame("Expense Tracker");
    public HomeWindow() {
        //Header
        JLabel title = new JLabel("Expense Tracker");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(10, 10, 300, 30);
        frame.add(title);

        //Menu Bar
        JMenuBar menuBar = new JMenuBar();

        //Menu
        JMenu fileMenu = new JMenu("Menu");
        menuBar.add(fileMenu);

        //Menu Item
        JMenuItem about = new JMenuItem("About");
        fileMenu.add(about);

        JMenuItem home = new JMenuItem("Home");
        fileMenu.add(home);

        menuBar.setBounds(0, 0, 300, 30);
        frame.setJMenuBar(menuBar);

        //Login button
        JButton login = new JButton("Login");
        login.setBounds(100, 100, 200, 50);
        frame.add(login);

        //Create account button
        JButton newUser = new JButton("Create Account");
        newUser.setBounds(350, 100, 200, 50);
        frame.add(newUser);

        frame.setLayout(null);
        frame.setSize(800, 600);
    }
    public void display() {
        frame.setVisible(true);
    }
}
