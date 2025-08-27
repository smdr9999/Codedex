import javax.swing.*;
import java.awt.*;

public class CaesarCipherGUI {

    public static String encryptOrDecrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char shifted = (char) (((character - base + shift) % 26 + 26) % 26 + base);
                result.append(shifted);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Caesar Cipher GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER; // center everything

        // Components
        JLabel encryptInputLabel = new JLabel("Enter text to encrypt:");
        JTextField encryptInputField = new JTextField(20);
        encryptInputField.setMaximumSize(new Dimension(300, 25));

        JLabel decryptInputLabel = new JLabel("Enter text to decrypt:");
        JTextField decryptInputField = new JTextField(20);
        decryptInputField.setMaximumSize(new Dimension(300, 25));

        JLabel shiftKeyLabel = new JLabel("Enter shift key (0–25):");
        JTextField shiftKeyField = new JTextField(5);
        shiftKeyField.setMaximumSize(new Dimension(60, 25));

        JLabel statusLabel = new JLabel(" ");

        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");

        JLabel encryptedOutputLabel = new JLabel("Encrypted Text:");
        JTextField encryptedOutputField = new JTextField(20);
        encryptedOutputField.setEditable(false);
        encryptedOutputField.setMaximumSize(new Dimension(300, 25));

        JLabel decryptedOutputLabel = new JLabel("Decrypted Text:");
        JTextField decryptedOutputField = new JTextField(20);
        decryptedOutputField.setEditable(false);
        decryptedOutputField.setMaximumSize(new Dimension(300, 25));

        // Row 0 - Encrypt input
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(encryptInputLabel, gbc);
        gbc.gridx = 1;
        panel.add(encryptInputField, gbc);

        // Row 1 - Decrypt input
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(decryptInputLabel, gbc);
        gbc.gridx = 1;
        panel.add(decryptInputField, gbc);

        // Row 2 - Shift key + status
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(shiftKeyLabel, gbc);
        gbc.gridx = 1;
        panel.add(shiftKeyField, gbc);
        gbc.gridx = 2;
        panel.add(statusLabel, gbc);

        // Row 3 - Buttons (side by side, centered)
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 3;
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        panel.add(buttonPanel, gbc);
        gbc.gridwidth = 1;

        // Row 4 - Encrypted output
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(encryptedOutputLabel, gbc);
        gbc.gridx = 1;
        panel.add(encryptedOutputField, gbc);

        // Row 5 - Decrypted output
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(decryptedOutputLabel, gbc);
        gbc.gridx = 1;
        panel.add(decryptedOutputField, gbc);

        // Action Listeners
        encryptButton.addActionListener(e -> {
            String originalText = encryptInputField.getText();
            if (originalText.trim().isEmpty()) {
                statusLabel.setText("Text field cannot be empty!");
                return;
            }
            try {
                int shift = Integer.parseInt(shiftKeyField.getText());
                if (shift < 0 || shift > 25) {
                    statusLabel.setText("Shift must be between 0 and 25!");
                    return;
                }
                statusLabel.setText(" ");
                encryptedOutputField.setText(encryptOrDecrypt(originalText, shift));
            } catch (NumberFormatException ex) {
                statusLabel.setText("Invalid Number! Enter a valid shift key!");
            }
        });

        decryptButton.addActionListener(e -> {
            String originalText = decryptInputField.getText();
            if (originalText.trim().isEmpty()) {
                statusLabel.setText("Text field cannot be empty!");
                return;
            }
            try {
                int shift = Integer.parseInt(shiftKeyField.getText());
                if (shift < 0 || shift > 25) {
                    statusLabel.setText("Shift must be between 0 and 25!");
                    return;
                }
                statusLabel.setText(" ");
                decryptedOutputField.setText(encryptOrDecrypt(originalText, -shift));
            } catch (NumberFormatException ex) {
                statusLabel.setText("Invalid Number! Enter a valid shift key!");
            }
        });

        // Add panel to frame
        frame.add(panel);


        // Set preferred sizes
        frame.setPreferredSize(new Dimension(650, 400)); // bigger default window
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);
    }
}
