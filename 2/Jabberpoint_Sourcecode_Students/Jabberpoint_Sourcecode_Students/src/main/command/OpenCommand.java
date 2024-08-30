package main.command;

import main.accessor.Accessor;
import main.Presentation;
import main.accessor.XMLAccessor;

import javax.swing.*;
import java.io.IOException;

public class OpenCommand extends NavCommand{
    private final JFrame parent;

    public OpenCommand(Presentation presentation, JFrame parent) {
        super(presentation);
        this.parent = parent;
    }

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String TESTFILE = "testPresentation.xml";

    @Override
    public void execute() {
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.loadFile(presentation, TESTFILE);
            presentation.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog( parent, IOEX + exc,
                    LOADERR, JOptionPane.ERROR_MESSAGE);
        }
        this.presentation.getParent().repaint();
    }
}

