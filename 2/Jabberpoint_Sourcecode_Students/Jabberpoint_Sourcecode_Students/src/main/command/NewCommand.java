package main.command;

import main.Presentation;

public class NewCommand extends NavCommand{

    public NewCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.clear();
        this.presentation.setSlideNumber(0);
        this.presentation.getParent().repaint();
    }
}
