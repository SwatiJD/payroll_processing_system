package PayrollProcessing.Repo;

import java.util.ArrayList;
import java.util.List;

import PayrollProcessing.PayrollProcessing.Main;

public interface EmployeeRepo {

	
	ArrayList<String> recs=new ArrayList<>();

	
	public List<String> totalEmployees(List<String> data );
}
