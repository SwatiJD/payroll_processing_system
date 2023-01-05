package PayrollProcessing.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import PayrollProcessing.Exception.EventNotFoundException;
//import PayrollProcessing.Exception.EventNotFoundException;
import PayrollProcessing.entity.Employee;
import PayrollProcessing.entity.Events;
import PayrollProcessing.service.EmployeeService;

public class EmployeeController {

	private EmployeeService employeeService = new EmployeeService();

	public void addEmp(String[] empinfo) throws EventNotFoundException  {
		Employee emp = new Employee();
		
		Events ev = new Events();
		for (String query : empinfo) {
			String[] singleQuery = query.split(",");

			if (query.contains("ONBOARD")) {

				String date = singleQuery[6];

				try {
					Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
					emp.setEventDate(date1);

				} catch (ParseException e) {
					e.printStackTrace();
				}

				emp.setSequenceNo(Integer.valueOf(singleQuery[0]));
				emp.setEmployeeId((singleQuery[1]));
				emp.setEmpFName(singleQuery[2]);
				emp.setEmpLName(singleQuery[3]);
				emp.setDesignation(singleQuery[4]);
				emp.setEventRecordDate(singleQuery[7]);
				emp.setEventRecordValue(singleQuery[6]);
				emp.setEvent(singleQuery[5]);

				ev.setEvent(singleQuery[5]);
				ev.setEventValue(singleQuery[6]);
				ev.setNotes((singleQuery[8]));
				ev.setEventEmpId(singleQuery[1]);
				List<Events> eventlist = List.of(ev);
				emp.setEvents(eventlist);
				employeeService.addEmployee(emp.getEmployeeId(), emp);
			} else if (query.contains("SALARY")) {
				Employee e = employeeService.findByEmpId(singleQuery[1]);
				e.setSalary(Integer.parseInt(singleQuery[3].trim()));
				e.setEventRecordDate(singleQuery[4]);
				e.setEventRecordValue(singleQuery[3]);
				e.setEvent(singleQuery[2]);
				employeeService.salaryUpdateofEmployee(e.getEmployeeId(), e);
			}

			else if (query.contains("BONUS")) {
				Employee e = employeeService.findByEmpId(singleQuery[1]);
				e.setBonus(Integer.parseInt(singleQuery[3].trim()));
				e.setEventRecordDate(singleQuery[4]);
				e.setEventRecordValue(singleQuery[3]);
				e.setEvent(singleQuery[2]);
				employeeService.bonusUpdateOfEmployee(e.getEmployeeId(), e);

			}

			else if (query.contains("REIMBURSEMENT")) {
				Employee e = employeeService.findByEmpId(singleQuery[1]);
				e.setReimbursement(Integer.parseInt(singleQuery[3].trim()));
				e.setEventRecordDate(singleQuery[4]);
				e.setEventRecordValue(singleQuery[3]);
				e.setEvent(singleQuery[2]);
				employeeService.updateReimbursementOfEmployee(e.getEmployeeId(), e);

			} 
            else if(query.contains("EXIT")) {
                Employee e = employeeService.findByEmpId(singleQuery[1]);
                String empId = singleQuery[1].trim();
                e.setEventRecordDate(singleQuery[4]);
				e.setEventRecordValue(singleQuery[3]);
				e.setEvent(singleQuery[2]);
                employeeService.deleteEmployee(empId);

            }
            else {
				 throw new EventNotFoundException();
			}

		}

	}
	public void setEmployeeService(EmployeeService employeeService) {
	    this.employeeService = employeeService;
	}
	public void employeeWiseFinancialReport() {
		employeeService.employeeFinancialReport();
	}

	public int totalemployees() {
		return employeeService.TotalEmployees();

	}

	public List<Employee> findAllDeatils() {
		return employeeService.findAll();
	}

	public void findAllOnBoardings() {
		employeeService.findAllOnboarded();
	}

	public void monthlySalaryRecord() {

		int totalEmployees = totalemployees();
		employeeService.monthlySalaryData();

	}

//	public void monthlyAmountRelease() {
//		employeeService.monthlyAmountRelease();
//	}

	public void yearlyEventRecords() {
		employeeService.yearlyEventRecords();
	}
	
	public void monthwiseBonusReimbursementReport() {
		employeeService.monthwiseBonusReimbursementReport();
	}
}
