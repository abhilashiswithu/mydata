

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OutPatientDaoImpl implements OutPatientDao {

	public void saveOutPatient(OutPatient op) {
		Connection connection = MysqlConnector.getInstance().getConnection();
		Statement s;
		String dob = new SimpleDateFormat("yyyy-MM-dd").format(op
				.getDateOfBirth());
		String regTime = new SimpleDateFormat("yyyy-MM-dd").format(op
				.getRegistrationTime());
		String sql = "insert into out_patient(name, dept, doctor, age, dob, registration_time) values ('"
				+ op.getName()
				+ "','"
				+ op.getDepartment()
				+ "','"
				+ op.getDoctor()
				+ "',"
				+ op.getAge()
				+ ",'"
				+ dob
				+ "','"
				+ regTime + "')";

		try {
			s = connection.createStatement();
			int result = s.executeUpdate(sql);
			System.out.println("Insert result " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<OutPatient> listAll() {
		Connection connection = MysqlConnector.getInstance().getConnection();
		Statement s;
		List<OutPatient> patients = new ArrayList<OutPatient>();
		try {
			s = connection.createStatement();
			s.executeQuery("select * from out_patient");
			ResultSet rs = s.getResultSet();
			if (null != rs) {
				while (rs.next()) {
					OutPatient patient = new OutPatient();
					patient.setId(rs.getInt("id"));
					patient.setAge(rs.getInt("age"));
					patient.setDateOfBirth(rs.getDate("dob"));
					patient.setDepartment(rs.getString("dept"));
					patient.setDoctor(rs.getString("doctor"));
					patient.setName(rs.getString("name"));
					patient.setRegistrationTime(rs.getDate("registration_time"));
					patients.add(patient);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return patients;
	}

	public void deleteOutPatient(OutPatient op) {
		Connection connection = MysqlConnector.getInstance().getConnection();
		Statement s;
		String sql = "DELETE FROM out_patient where id='" + op.getId() + "'";

		try {
			s = connection.createStatement();
			int result = s.executeUpdate(sql);
			System.out.println("Deletion result " + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
