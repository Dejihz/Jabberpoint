package main;

import main.command.*;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	
	private Frame parent; //The frame, only used as parent for the Dialogs
	private Presentation presentation; //Commands are given to the presentation

	private static final long serialVersionUID = 227L;

	public MenuController(Frame frame, Presentation pres) {
		parent = frame;
		presentation = pres;

		ExitCommand exitCommand = new ExitCommand(this.presentation);
		GotoCommand gotoCommand = new GotoCommand(this.presentation);
		PrevCommand prevCommand = new PrevCommand(this.presentation);
		NextCommand nextCommand = new NextCommand(this.presentation);
		OpenCommand openCommand = new OpenCommand(this.presentation, (JFrame) parent);
		SaveCommand saveCommand = new SaveCommand(this.presentation, parent);
		NewCommand newCommand = new NewCommand(this.presentation);
		AboutCommand aboutCommand = new AboutCommand(this.presentation, parent);

		Menu fileMenu = new Menu("File");
		fileMenu.add(this.mkMenuItem("Open", e -> openCommand.execute(), 'O'));
		fileMenu.add(this.mkMenuItem("New", e -> newCommand.execute(), 'N'));
		fileMenu.add(this.mkMenuItem("Save", e -> saveCommand.execute(), 'S'));
		fileMenu.addSeparator();
		fileMenu.add(this.mkMenuItem("Exit", e -> exitCommand.execute()));
		this.add(fileMenu);

		Menu viewMenu = new Menu("View");
		viewMenu.add(this.mkMenuItem("Next", e -> nextCommand.execute()));
		viewMenu.add(this.mkMenuItem("Prev", e -> prevCommand.execute()));
		viewMenu.add(this.mkMenuItem("Go to", e -> gotoCommand.execute(), 'G'));
		this.add(viewMenu);

		Menu helpMenu = new Menu("Help");
		helpMenu.add(this.mkMenuItem("About", e -> aboutCommand.execute(), 'A'));
		this.setHelpMenu(helpMenu);
	}

	//Creating a menu-item
	public MenuItem mkMenuItem(String name, ActionListener action) {
		MenuItem menuItem;
		menuItem = new MenuItem(name);
		menuItem.addActionListener(action);
		return menuItem;
	}

	public MenuItem mkMenuItem(String name, ActionListener action, char shortcutKey) {
		MenuItem menuItem;
		menuItem = new MenuItem(name, new MenuShortcut(shortcutKey));
		menuItem.addActionListener(action);
		return menuItem;
	}

}