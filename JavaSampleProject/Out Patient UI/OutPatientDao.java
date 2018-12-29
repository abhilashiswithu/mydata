

import java.util.List;

public interface OutPatientDao {
	void saveOutPatient(OutPatient op);

	List<OutPatient> listAll();

	void deleteOutPatient(OutPatient op);

}
