import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecyclingMachine extends JFrame {

    private JTextField canField, bottleField, crateField;
    private JTextArea receiptArea;
    private JButton submitButton;

    private DepositItemReceiver itemReceiver;
    private ReceiptPrinter receiptPrinter;

    public RecyclingMachine() {
        setTitle("Recycling Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        itemReceiver = new DepositItemReceiver();
        receiptPrinter = new ReceiptPrinter();

        // Create UI Components
        canField = new JTextField(5);
        bottleField = new JTextField(5);
        crateField = new JTextField(5);
        receiptArea = new JTextArea(10, 30);
        receiptArea.setEditable(false);

        submitButton = new JButton("Submit");

        // Create Panel and Add Components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Enter the number of cans:"));
        panel.add(canField);
        panel.add(new JLabel("Enter the number of bottles:"));
        panel.add(bottleField);
        panel.add(new JLabel("Enter the number of crates:"));
        panel.add(crateField);
        panel.add(submitButton);

        // Add scroll pane for receipt
        JScrollPane scrollPane = new JScrollPane(receiptArea);

        // Add Action Listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processDeposit();
            }
        });

        // Add everything to the frame
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Process deposit and display receipt
    private void processDeposit() {
        try {
            int cans = Integer.parseInt(canField.getText());
            int bottles = Integer.parseInt(bottleField.getText());
            int crates = Integer.parseInt(crateField.getText());

            // Clear the previous data
            itemReceiver = new DepositItemReceiver();

            // Receive items based on user input
            itemReceiver.receiveItems(cans, bottles, crates);

            // Generate and display the receipt
            receiptArea.setText("");
            ReceiptBasis receiptBasis = itemReceiver.getReceiptBasis();
            for (DepositItem item : receiptBasis.getItems()) {
                receiptArea.append(item.getType() + ": $" + item.getValue() + "\n");
            }
            receiptArea.append("Total Refund: $" + receiptBasis.getTotalValue());

        } catch (NumberFormatException ex) {
            receiptArea.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RecyclingMachine().setVisible(true);
            }
        });
    }
}