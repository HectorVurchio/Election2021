package societyAperson;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.io.IOException;
import java.lang.reflect.Field;
/**
* PrintResultTwo is a class that works with Election2021 class 
* in an application that will be used to give examples of some data structures
* and algorithms as well as talk about Java .
*
* The current class is used to print in the system console the input data
* after processing with a given format using an Elector2021Data object.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-30 
*/
class PrintResultsTwo {
	private ZoneId zi;
	private ZonedDateTime now;
	private FormatStyle fs;
	private DateTimeFormatter formatter;
	private String sline;
	private String format;
	private int[] s = new int[]{9,10,16,18};
	/**
	* The constructor which stamps the local and global date and time 
	* giving at the same time an initial format.
	*/		
	PrintResultsTwo(){
		System.out.println("");
		System.out.println("          Voters In the Elector ArrayList");
		System.out.printf("%1$113s%n",todayDate("America/Caracas"));
		System.out.printf("%1$113s%n",todayDate("UTC"));
		headFormat();
	}
	/**
	* This method is used to get the current date and time.
	* @param zone, representing the zone id.
	* @return the formatted current date and time as an String Object.
	*/			
	private String todayDate(String zone){
		Locale lo = new Locale("en","VE");
		zi = ZoneId.of(zone);
		now = ZonedDateTime.now(zi);
		fs = FormatStyle.FULL;
		formatter = DateTimeFormatter.ofLocalizedDateTime(fs);
		return formatter.withLocale(lo).format(now);
	}
	/**
	* This method gives the the table head format.
	*/		
	private void headFormat(){
		sline = new String(new char[113]).replace('\0', '-');
		System.out.println(sline);
		format = "|%1$-9s|%2$-10s|%3$-10s|%4$-10s|%5$-10s|%6$-18s|%7$-16s|%8$-10s|%9$-10s|%n";
		Object[] args = new Object[]{center("Id Number",s[0]),
								center("Name",s[1]),
								center("Last Name",s[1]),
								center("Birth Date",s[1]),
								center("Gender",s[1]),
								center("CitizenShip",s[3]),
								center("Party",s[2]),
								center("Status",s[1]),
								center("Time",s[1])};
		System.out.printf(format,args);
		System.out.println(sline);
	}
	/**
	* This method gives the format of a given date.
	* @param date, the given date as an istance of LocalDate.
	* @return the formatted date as an String Object.
	*/	
	private String dateFormat(LocalDate date){
		String datePattern = "dd/MM/yyyy";
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern);
		return date.format(dateFormatter);
	}
	/**
	* This method gives the format of a given time.
	* @param time, the given time as an istance of LocalTime.
	* @return the formatted time as an String Object.
	*/		
	private String timeFormat(LocalTime time){
		if(time == null){ //if -> avoiding null pointer exception
			return "null";
		}else{
			String timePattern = "HH:mm:ss";
			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timePattern);
			return time.format(timeFormatter);
		}
	}
	/**
	* This method justify the text aligning at the center.
	* @param str, the given String text to be aligned.
	* @param availSp, number of characters available for the cell.
	* @return the center aligned String Object.
	*/		
	private String center(String str,int availSp){
		int strLen = str.length();
		int pad = (availSp - strLen)/2;
		String centered = "";
		for(int i = 0;i<pad;i++){centered += " ";}
		return centered + str;
	}
	/**
	* This method print all the required data.
	* @param elector, an object containing all the required information.
	*/		
	public void printObject(Elector2021Data e){
		Object[] args = new Object[]{center(e.Id_Number,s[0]),
								center(e.Name,s[1]),
								center(e.Last_Name,s[1]),
								center(dateFormat(e.Birth_Date),s[1]),
								center(e.Gender,s[1]),
								center(e.Citizenship,s[3]),
								center(e.Party,s[2]),
								center(e.Status,s[1]),
								center(timeFormat(e.Time),s[1])};
		System.out.printf(format,args);
		System.out.println(sline);
	}
	
	/**
	* This method uses the reflection of Elector2021Data object to release its information.
	* @param elector, from Elector2021Data class which contain all elector data.
	* @return Nothing.
	* @exception NoSuchFieldException,IllegalArgumentException,IllegalAccessException.
    * required by getDeclaredField() method of Class class and get() method from Field class.
    * @see Class class and Field class documentation.
	*/	
	public static void reflectionMethod(Elector2021Data elector)throws NoSuchFieldException,
												IllegalArgumentException, IllegalAccessException{
		System.out.println(" ");
		Class cl = elector.getClass();
		System.out.println("Class Name: "+cl.getName());
		Field[] fi = cl.getDeclaredFields();
		System.out.println(java.util.Arrays.toString(fi));
		for(int i=0;i<fi.length;i++){
			System.out.println("Field "+i+" "+fi[i].getName()+" = "+
											cl.getDeclaredField(fi[i].getName()).get(elector));
		}
	}
}