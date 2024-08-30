package main.command;

import main.Presentation;

public class ExitCommand extends NavCommand {
    public ExitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.exit(0);
    }
}
