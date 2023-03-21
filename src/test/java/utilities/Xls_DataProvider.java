package utilities;

public class Xls_DataProvider {
	
	public void DataProvider() {
		
		//Below data fetching from Excel file
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Admin\\office\\info.printSultan\\src\\main\\java\\testData\\Testdata.xlsx");
				
		String firstName = reader.getCellData("Registration", "Firstname", 2);
		System.out.println(firstName);

		String lastName = reader.getCellData("Registration", "Lastname", 2);
		System.out.println(lastName);

		String emailId = reader.getCellData("Registration", "Email", 2);
		System.out.println(emailId);

		String phone = reader.getCellData("Registration", "Phone", 2);
		System.out.println(phone);
		
		String houseNo = reader.getCellData("Registration", "HouseNo", 2);
		System.out.println(houseNo);
		
		String floor = reader.getCellData("Registration", "Floor", 2);
		System.out.println(floor);
		
		String streetAddress = reader.getCellData("Registration", "StreetAddress", 2);
		System.out.println(streetAddress);
		
		String country = reader.getCellData("Registration", "Country", 2);
		System.out.println(country);
		
		String provineState = reader.getCellData("Registration", "ProvineState", 2);
		System.out.println(provineState);
		
		String password = reader.getCellData("Registration", "Password", 2);
		System.out.println(password);

		String CoPassword = reader.getCellData("Registration", "CoPassword", 2);
		System.out.println(CoPassword);
		
		String username = reader.getCellData("Login", "Username", 2);
		System.out.println(username);
		
		String lpassword = reader.getCellData("Login", "Password", 2);
		System.out.println(lpassword);


	}

		
	}


