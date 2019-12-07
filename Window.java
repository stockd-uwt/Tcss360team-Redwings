//Checked Out By: n/a

/* Team RedWings (David, Daniel, and Ben)
 * 
 * Tcss 360
 * 
 * Project 1
 */
package frontEnd;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Sizable scalable display window. 
 * 
 * @author David Melanson
 * 
 * @version Alpha 0.0.09
 */

public class Window extends JPanel {

	private BufferedImage myDoc;
	private String file;
	private Dimension d;
	boolean flag = true;
	/*
	 * Needs setup for generic display.
	 */
	public Window(String pathName, Dimension theSize) throws IOException {
		file = pathName;
		myDoc = ImageIO.read(new File(pathName));
		d = theSize;
		setPreferredSize(theSize);
		setVisible(true);

		if (pathName.contains(".txt")) {
			flag = false;
			JTextArea myWindow = new JTextArea();
			myWindow.setOpaque(false);
			StringBuilder sb = null;
			try {
				sb = textBuilder(new File(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			myWindow.setText(sb.toString());
			myWindow.setVisible(true);
			myWindow.setBounds(0, 0, d.width, d.height);

			myWindow.setEditable(false);
			
			add(myWindow);
		}

	}

	public void paintComponent(final Graphics theG) {
		if (flag) {
			super.paintComponent(theG);
			theG.drawImage(myDoc, 0,0, d.height,d.width, this);
		}
	}

	private StringBuilder textBuilder(File theFile) throws FileNotFoundException {
		Scanner s = new Scanner(theFile);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (s.hasNextLine()) {
			sb.append(s.nextLine() + "\n");
			i++;
		}
		System.out.println(i);
		return sb;
	}

	//	private void setUp() {
	//		//Put new Listener here where "null" is. --anonymous inner class.
	//		addMouseListener(null);
	//	}
}
