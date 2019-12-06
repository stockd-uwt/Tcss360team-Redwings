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

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Sizable scalable display window. 
 * 
 * @author David Melanson
 * 
 * @version Alpha 0.0.05
 */

public class Window extends JPanel {
	
	private BufferedImage myDoc;
	private Dimension d;
	/*
	 * Needs setup for generic display.
	 */
	public Window(BufferedImage theDoc, Dimension theSize) {
		myDoc = theDoc;
		d = theSize;
		setPreferredSize(theSize);
		setVisible(true);
	}
	
	public void paintComponent(final Graphics theG) {
		super.paintComponent(theG);
		theG.drawImage(myDoc, 0,0, d.height,d.width, this);
	}
	
//	private void setUp() {
//		//Put new Listener here where "null" is. --anonymous inner class.
//		addMouseListener(null);
//	}
}
