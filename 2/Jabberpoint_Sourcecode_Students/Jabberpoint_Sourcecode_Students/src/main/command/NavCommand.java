package main.command;


import main.Presentation;

public abstract class NavCommand {
    protected Presentation presentation;

    public NavCommand(Presentation presentation) {
        this.presentation = presentation;
    }

    public abstract void execute();
}
