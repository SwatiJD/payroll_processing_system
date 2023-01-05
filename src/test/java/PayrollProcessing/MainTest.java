package PayrollProcessing;

import PayrollProcessing.controller.EmployeeController;
import PayrollProcessing.entity.Employee;
import PayrollProcessing.service.EmployeeService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * A simple unit test
 */
public class MainTest 
{
    /**
     * Rigorous Test :-)
     */
	
	private final PrintStream standardOut =System.out;
	private final ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
    @Test
    public void Test2() {
    	String inputfile="sample_input"+ File.separator+"Records.txt";
    	Date eventDate=new Date(01-11-2023);
    	List<String> inputs=new ArrayList<>();
    	inputs.add(inputfile);


    	EmployeeService es=new EmployeeService();
    	Employee e=new Employee();
    	e.setEmployeeId("emp101");
    	e.setEmpFName("Bill");
    	e.setEvent("ONBOARD");
    	e.setEventDate(eventDate);
    	e.setEmpLName("Gates");
    	es.addEmployee(e.getEmployeeId(),e);
    	EmployeeController emp=new EmployeeController();

    	emp.setEmployeeService(es);

    	emp.totalemployees();


    	String expectedoutput="Total number of employees is:1";

    	Assertions.assertEquals(expectedoutput, outputStreamCaptor.toString().trim());
       
    }
    
    

    @Test
    public void Test1() {
    	String inputfile="sample_input"+ File.separator+"Records.txt";
    	Date eventDate=new Date(01-11-2023);
    	List<String> inputs=new ArrayList<>();
    	inputs.add(inputfile);


    	EmployeeService es=new EmployeeService();
    	Employee e=new Employee();
    	e.setEmployeeId("emp101");
    	e.setEmpFName("Ujjwal");
    	e.setEvent("ONBOARD");
    	e.setEventDate(eventDate);
    	e.setEmpLName("Gupta");
    	es.addEmployee(e.getEmployeeId(),e);
    	EmployeeController emp=new EmployeeController();

    	emp.setEmployeeService(es);

    	emp.employeeWiseFinancialReport();


    	String expectedoutput="-----------------------\n"
    			+ "Employee Id,  Name,  Surname,  Total amount paid\n"
    			+ "emp101      Ujjwal    Gupta   0";

    	Assertions.assertEquals(expectedoutput, outputStreamCaptor.toString().trim());
       
    }
}
