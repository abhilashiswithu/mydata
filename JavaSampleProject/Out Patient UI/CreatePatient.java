

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CreatePatient extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField doctor;
	private JTextField department;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton save;
	private JFrame parent;

	/**
	 * Create the frame.
	 */
	public CreatePatient(JFrame parent) {
		this.parent = parent;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(50, 45, 100, 20);
		contentPane.add(lblName);

		name = new JTextField();
		name.setBounds(150, 45, 150, 20);
		contentPane.add(name);
		name.setColumns(10);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(50, 75, 100, 15);
		contentPane.add(lblAge);

		age = new JTextField();
		age.setBounds(150, 75, 150, 20);
		contentPane.add(age);
		age.setColumns(10);

		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(50, 105, 100, 15);
		contentPane.add(lblDoctor);

		doctor = new JTextField();
		doctor.setBounds(150, 105, 150, 20);
		contentPane.add(doctor);
		doctor.setColumns(10);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(50, 135, 100, 15);
		contentPane.add(lblDepartment);

		department = new JTextField();
		department.setBounds(150, 135, 150, 20);
		contentPane.add(department);
		department.setColumns(10);

		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(50, 165, 100, 15);
		contentPane.add(lblDob);

		textField = new JTextField();
		textField.setBounds(150, 165, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNewLabel = new JLabel("Enter Patient Details here");
		lblNewLabel.setBounds(50, 15, 200, 15);
		contentPane.add(lblNewLabel);

		save = new JButton("Save");
		save.setBounds(167, 215, 75, 25);
		contentPane.add(save);

		save.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				savePatient();
				switchToParent();
			}

		});

	}

	private void savePatient() {
		OutPatientDao dao = new OutPatientDaoImpl();
		OutPatient patient = new OutPatient();
		patient.setAge(Integer.parseInt(age.getText()));
		patient.setDateOfBirth(new Date());// TODO
		patient.setDepartment(department.getText());
		patient.setDoctor(doctor.getText());
		patient.setName(name.getText());
		patient.setRegistrationTime(new Date());
		dao.saveOutPatient(patient);
	}

	private void switchToParent() {
		this.setVisible(false);
		parent.setVisible(true);
	}
}
