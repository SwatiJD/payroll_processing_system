package PayrollProcessing.PayrollProcessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import PayrollProcessing.Exception.EventNotFoundException;
//import PayrollProcessing.Exception.EventNotFoundException;
import PayrollProcessing.controller.EmployeeController;
import PayrollProcessing.entity.Employee;
import PayrollProcessing.entity.Events;
import PayrollProcessing.service.EmployeeService;

public class Main {
	public static void main(String[] args) throws EventNotFoundException  {

		File inFile = null;
		if (args.length > 0) {
			inFile = new File(args[0]);
			Employee emp = new Employee();
			Events ev = new Events();
			try {
				BufferedReader br = new BufferedReader(new FileReader(inFile));
				String read = null;
                String[] data = new String[1];
				EmployeeController empcont = new EmployeeController();

				while ((read = br.readLine()) != null) {
                    data[0] = read;


					empcont.addEmp(data);

				}
				empcont.totalemployees();
				empcont.findAllDeatils();
				empcont.employeeWiseFinancialReport();
				empcont.findAllOnBoardings();
				empcont.monthlySalaryRecord();
				empcont.yearlyEventRecords();
				empcont.monthwiseBonusReimbursementReport();

			} catch (IOException e) {
				System.out.println("There was a problem: " + e);

			}
		}
	}
}
