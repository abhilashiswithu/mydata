

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow {

	private JFrame mainFrame;
	private CreatePatient createFrame;
	private ListFrame listFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"Welcome to Out Patient management system");
		lblNewLabel.setBounds(58, 12, 363, 15);
		mainFrame.getContentPane().add(lblNewLabel);

		JButton registerBtn = new JButton("Register");
		registerBtn.setBounds(123, 54, 148, 25);
		registerBtn.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				mainFrame.setVisible(false);
				createFrame = new CreatePatient(mainFrame);
				createFrame.setVisible(true);
			}
		});
		mainFrame.getContentPane().add(registerBtn);

		JButton listPatients = new JButton("List Patients");
		listPatients.setBounds(123, 117, 148, 25);
		listPatients.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				mainFrame.setVisible(false);
				listFrame = new ListFrame(mainFrame);
				listFrame.setVisible(true);
			}
		});
		mainFrame.getContentPane().add(listPatients);
	}
}
