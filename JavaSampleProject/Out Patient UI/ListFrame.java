

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ListFrame extends JFrame {

	private JPanel contentPane;
	private JFrame parent;

	public ListFrame(JFrame parent) {
		this.parent = parent;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listAll();
		createHeader();

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchToParent();
			}
		});
		btnClose.setBounds(238, 226, 73, 25);
		contentPane.add(btnClose);

	}

	private void createHeader() {
		JPanel panel = new JPanel();
		panel.setBounds(20, 5, 480, 25);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(5, 5, 15, 20);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(30, 5, 60, 20);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Department");
		lblNewLabel_2.setBounds(85, 5, 90, 20);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Doctor");
		lblNewLabel_3.setBounds(185, 5, 65, 20);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("DateOfBirth");
		lblNewLabel_4.setBounds(250, 5, 90, 20);
		panel.add(lblNewLabel_4);

		JLabel lblRegistratedOn = new JLabel("Registrated On");
		lblRegistratedOn.setBounds(350, 5, 120, 20);
		panel.add(lblRegistratedOn);
	}

	private void switchToParent() {
		this.setVisible(false);
		parent.setVisible(true);
	}

	private void listAll() {

		List<OutPatient> patients = new OutPatientDaoImpl().listAll();
		int startHeight = 15;
		if (null != patients && patients.size() > 0) {
			for (OutPatient patient : patients) {
				startHeight = startHeight + 25;
				addRow(patient, startHeight);
			}
		} else {
			JLabel noContent = new JLabel("No patients to display");
			noContent.setBounds(100, 100, 100, 30);
			contentPane.add(noContent);
		}

	}

	public void addRow(OutPatient patient, int y) {
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(20, y, 480, 25);
		contentPane.add(panel_1);

		JLabel label = new JLabel(String.valueOf(patient.getId()));
		label.setBounds(5, 5, 15, 20);
		panel_1.add(label);

		JLabel label_1 = new JLabel(patient.getName());
		label_1.setBounds(30, 5, 60, 20);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel(patient.getDepartment());
		label_2.setBounds(85, 5, 90, 20);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel(patient.getDoctor());
		label_3.setBounds(185, 5, 65, 20);
		panel_1.add(label_3);

		String displayDOB = new SimpleDateFormat("yyyy-MM-dd").format(patient
				.getDateOfBirth());
		JLabel label_4 = new JLabel(displayDOB);
		label_4.setBounds(250, 5, 90, 20);
		panel_1.add(label_4);

		String displayReg = new SimpleDateFormat("yyyy-MM-dd").format(patient
				.getRegistrationTime());
		JLabel label_5 = new JLabel(displayReg);
		label_5.setBounds(350, 5, 120, 20);
		panel_1.add(label_5);
	}
}
