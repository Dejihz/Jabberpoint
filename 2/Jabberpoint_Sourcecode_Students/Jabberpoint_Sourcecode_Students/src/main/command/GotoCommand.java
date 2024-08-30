package main.command;

import main.Presentation;

import javax.swing.*;

public class GotoCommand extends NavCommand {

    public GotoCommand(Presentation presentation) {
        super(presentation);
    }

    protected String getUserInputDialog() {
        return JOptionPane.showInputDialog("Page number:");
    }

    protected int getUserInput() throws NumberFormatException {
        String pageNumberStr = getUserInputDialog();
        return Integer.parseInt(pageNumberStr);
    }

    protected void showMessageDialog(JFrame frame, String message, String title, int messageType) {
        JOptionPane.showMessageDialog(frame, message, title, messageType);
    }

    @Override
    public void execute() {
        try {
            int pageNumber = getUserInput();
            if (pageNumber > presentation.getSize()) {
                showMessageDialog(
                        null, "Page number doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                presentation.setSlideNumber(pageNumber - 1);
            }
        }
        catch (NumberFormatException e) {
            showMessageDialog(null, "Page doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
