package Singleton;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		Optional<Employee> youngEmployeeWrapper=employeeList.stream().min(Comparator.comparingInt(Employee::getAge));
		Employee oldestEmployee = oldestEmployeeWrapper.get();
		Employee youngEmployee =youngEmployeeWrapper.get();
		System.out.println("oldestEmployee");
		System.out.println("Name : "+oldestEmployee.getName());

		System.out.println("Age : "+oldestEmployee.getAge());

		System.out.println("Department : "+oldestEmployee.getDepartment());
		System.out.println("youngEmployee");
		
		System.out.println("Name : "+youngEmployee.getName());

		System.out.println("Age : "+youngEmployee.getAge());

		System.out.println("Department : "+youngEmployee.getDepartment());
		
		/*
		 * 
		 Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.

		For this query, we will be using Collectors.partitioningBy() method which separates input elements based on supplied Predicate. 
		 * 
		 *
		 */
		Map<Boolean ,List<Employee>> partitionEmployeesByAge=employeeList.stream().collect(Collectors.partitioningBy(e->e.getAge()>25));
		Set<Entry<Boolean ,List<Employee>>> entrySet=partitionEmployeesByAge.entrySet();
		for (Entry<Boolean, List<Employee>> entry : entrySet) {
			
			if (entry.getKey()) 
			{
			System.out.println("Employees older than 25 years :");
			}
			else
			{
			System.out.println("Employees younger than or equal to 25 years :");
			}

			System.out.println("----------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) 
			{
			System.out.println(e.getName());
			}
		}
		/*
		Query 3.12 : List down the names of all employees in each department?

		For this query, we will be using Collectors.groupingBy() method by passing 
		Employee::getDepartment as an argument.
		*/
		Map<String,List<Employee>> employeeListByDepartment=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> entrySet1= employeeListByDepartment.entrySet();

		for (Entry<String, List<Employee>> entry : entrySet1)
		{
		System.out.println("--------------------------------------");

		System.out.println("Employees In "+entry.getKey() + " : ");

		System.out.println("--------------------------------------");

		List<Employee> list = entry.getValue();

		for (Employee e : list) 
		{
		System.out.println(e.getName());
		}
		}
		Map<String,Double> avragesal=employeeList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avragesal);
		/*
		 * Query 3.10 : How many male and female employees are there in the sales and
		 * marketing team?
		 * 
		 * This query is same as query 3.1, but here use filter() method to filter sales
		 * and marketing employees.
		 */
				Map<String, Long> countMaleFemaleEmployeesInSalesMarketing=
				employeeList.stream()
				.filter(e -> e.getDepartment()=="Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

				System.out.println(countMaleFemaleEmployeesInSalesMarketing);
	}
}
