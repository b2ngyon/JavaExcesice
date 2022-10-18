public class StudentDeserialiser { 
	public  Student parse(String linefeed){
		 Student record = new Student();
		record.firstName=linefeed.substring(0,20).trim();
		record.lastName=linefeed.substring(20,40).trim();
		record.level=linefeed.substring(40,50).trim();
		record.studentClass=linefeed.substring(50,60).trim();

		return record;
	}
}