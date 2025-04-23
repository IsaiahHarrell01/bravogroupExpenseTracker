package com.expensetracker.gui;

import com.expensetracker.database.DatabaseManager;
import com.expensetracker.models.Transaction;
import com.expensetracker.models.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class ExpenseOverviewPanel extends JPanel {
    private final User user;
    private JTable transactionsTable;

    public ExpenseOverviewPanel(User user) {
        this.user = user;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Table setup
        String[] columns = {"ID", "Type", "Category", "Amount", "Date", "Description"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table non-editable
            }
        };

        transactionsTable = new JTable(model);
        refreshTable();

        // Chart panel
        JPanel chartPanel = createChartPanel();

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshData());

        buttonPanel.add(refreshButton);

        // Add components
        add(new JScrollPane(transactionsTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(chartPanel, BorderLayout.EAST);
    }

    private JPanel createChartPanel() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        Map<String, Double> expensesByCategory = DatabaseManager.getExpensesByCategory(user.getId());
        expensesByCategory.forEach(dataset::setValue);

        JFreeChart chart = ChartFactory.createPieChart(
                "Expense Breakdown",
                dataset,
                true, // legend
                true, // tooltips
                false // urls
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) transactionsTable.getModel();
        model.setRowCount(0);

        List<Transaction> transactions = DatabaseManager.getUserTransactions(user.getId());
        for (Transaction t : transactions) {
            model.addRow(new Object[]{
                    t.getId(),
                    t.getType(),
                    t.getCategory(),
                    String.format("$%.2f", t.getAmount()),
                    t.getDate(),
                    t.getDescription()
            });
        }
    }

    private void refreshData() {
        refreshTable();
        ((BorderLayout) getLayout()).getLayoutComponent(BorderLayout.EAST).repaint();
    }
}