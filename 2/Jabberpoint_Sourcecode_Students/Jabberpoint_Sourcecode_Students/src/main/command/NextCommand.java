package main.command;

import main.Presentation;

public class NextCommand extends NavCommand{
    public NextCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.nextSlide();
    }
}

