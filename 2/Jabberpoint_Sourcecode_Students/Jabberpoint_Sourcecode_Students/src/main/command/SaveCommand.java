package main.command;

import main.accessor.Accessor;
import main.Presentation;
import main.accessor.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SaveCommand extends NavCommand{
    private final Frame parent;
    protected static final String SAVEFILE = "savedPresentation.xml";

    protected static final String IOEX = "IO Exception: ";
   protected static final String SAVEERR = "Save Error";


    public SaveCommand(Presentation presentation, Frame parent) {
        super(presentation);
        this.parent = parent;
    }

    @Override
    public void execute() {
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.saveFile(presentation, SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc,
                    SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}

