package main;

import main.command.ExitCommand;
import main.command.NavCommand;
import main.command.NextCommand;
import main.command.PrevCommand;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.HashMap;
import java.util.Map;

/** <p>This is the main.KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter {
	private final Presentation presentation;
	private final NavCommand nextCommand;
	private final NavCommand prevCommand;
	private final NavCommand exitCommand;
	private final Map<Integer, NavCommand> commands;

	public KeyController(Presentation presentation) {
		this.presentation = presentation;
		this.nextCommand = new NextCommand(presentation);
		this.prevCommand = new PrevCommand(presentation);
		this.exitCommand = new ExitCommand(presentation);
		this.commands = new HashMap<>();
		initializecommands();
	}

	private void initializecommands() {
		goNextPage();
		goPrevPage();
		goExitPage();
	}

	private void goNextPage() {
		commands.put(KeyEvent.VK_PAGE_DOWN, nextCommand);
		commands.put(KeyEvent.VK_DOWN, nextCommand);
		commands.put(KeyEvent.VK_ENTER, nextCommand);
		commands.put((int) '+', nextCommand);
	}

	private void goPrevPage() {
		commands.put(KeyEvent.VK_PAGE_UP, prevCommand);
		commands.put(KeyEvent.VK_UP, prevCommand);
		commands.put((int) '-', prevCommand);
	}

	private void goExitPage() {
		commands.put((int) 'q', exitCommand);
		commands.put((int) 'Q', exitCommand);
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		NavCommand command = commands.get(keyEvent.getKeyCode());
		if (command != null) {
			command.execute();
		}
	}
}
