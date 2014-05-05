import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GUI {
	private JFrame frame;
	private JPanel contentPane;
	private JPanel playerPane;
	private JPanel opponentPane;
	private JPanel[][] playerTiles;
	private JPanel[][] opponentTiles;
	private final int ROWS = 8;
	private final int BOXSIZE = 50;

	public GUI() {
		frame = new JFrame("S�nka skepp");
		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		playerPane = new JPanel();
		opponentPane = new JPanel();
		playerPane.setLayout(new GridLayout(ROWS, ROWS));
		opponentPane.setLayout(new GridLayout(ROWS, ROWS));

		playerTiles = new JPanel[ROWS][ROWS];
		opponentTiles = new JPanel[ROWS][ROWS];

		Rectangle rect;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1.0;
		constraints.weightx = 1.0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		for (int y = 0; y < ROWS; y++) {// 2D array is represented on the form
										// [ROW][COL]
			for (int x = 0; x < ROWS; x++) {
				playerTiles[y][x] = new JPanel();
				opponentTiles[y][x] = new JPanel();
				playerTiles[y][x].setLayout(new GridBagLayout());
				opponentTiles[y][x].setLayout(new GridBagLayout());
				playerTiles[y][x].setPreferredSize(new Dimension(BOXSIZE,
						BOXSIZE));
				opponentTiles[y][x].setPreferredSize(new Dimension(BOXSIZE,
						BOXSIZE));

				playerTiles[y][x].setBorder(BorderFactory
						.createLineBorder(Color.GRAY));
				opponentTiles[y][x].setBorder(BorderFactory
						.createLineBorder(Color.GRAY));

				playerPane.add(playerTiles[y][x], constraints);
				opponentPane.add(opponentTiles[y][x], constraints);
				// rect = new Rectangle();
				// rect.setBounds(0, 0, BOXSIZE, BOXSIZE);
				//
				// playerPane.add(rect);

				// Kan inte l�gga listner p� JPanel.
				// Vad ska jag l�gga i JPanel som jag kan l�gga en lyssnare p�?
				
				JButton button = new JButton(x + " " + y);
				playerTiles[y][x].add(button);
				button = new JButton(x + " " + y);
				opponentTiles[y][x].add(button);
//				 playerPane.addActionListner(new ActionListner() {
//				 public void actionPerformed(ActionEvent e) {playerClicked(y,
//				 x)}
//				 });
//				 opponentPane.addActionListner(new ActionListner() {
//				 public void actionPerformed(ActionEvent e)
//				 {opponentClicked(y, x)}
//				 });
			}
		}

		
		makeMenuBar(frame);
		
		
		
		constraints.weightx = 0.5;
		
		contentPane.add(playerPane, constraints);
		constraints.gridx = 1;
		contentPane.add(opponentPane, constraints);

		playerPane.setBorder(BorderFactory.createTitledBorder("player"));// player.getName()
		opponentPane.setBorder(BorderFactory.createTitledBorder("opponent"));// player.getOpponentName()


		

		frame.pack();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		String s = "PlayerPane height: " + playerPane.getHeight()
				+ ". PlayerPane width: " + playerPane.getWidth();
		JOptionPane.showMessageDialog(null, s);

	}

	/**
	 * Create a menubar for the frame
	 * 
	 * @param frame
	 *            The frame that the menubar will belong to.
	 */
	private void makeMenuBar(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);

		JMenuItem item = new JMenuItem(
				"Restart game as�ldfkjas�ldfkjasd�lkfj�aslkdjf");
		final int SHORTCUT_MASK = Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask();
		item.setAccelerator(KeyStroke
				.getKeyStroke(KeyEvent.VK_R, SHORTCUT_MASK));
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
			}
		});
		menu.add(item);
	}

	/**
	 * Called when a square in the playerPane is clicked.
	 * 
	 * @param y
	 *            The row index
	 * @param x
	 *            The column index
	 */
	private void playerClicked(int y, int x) {

	}

	/**
	 * Called when a square in the opponentPane is clicked.
	 * 
	 * @param y
	 *            The row index
	 * @param x
	 *            The column index
	 */
	private void opponentClicked(int y, int x) {

	}

	/**
	 * 
	 */
	public void restart() {
		JOptionPane.showMessageDialog(null, "Game is restarting...");
	}

	public static void main(String[] args) {
		GUI sankaSkepp = new GUI();
	}

}
