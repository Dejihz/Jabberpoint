package main.command;

import main.Presentation;

public class PrevCommand extends NavCommand{
    public PrevCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.prevSlide();
    }
}

