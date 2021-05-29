package societyAperson;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.io.IOException;
/**
* PrintResult is a class that works with Election2021 class 
* in an application that will be used to give examples of some data structures
* and algorithms as well as talk about Java .
*
* The current class is used to print in the system console the input data
* after processing with a given format.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-15 
*/

public class PrintResults{
	private ZoneId zi;
	private ZonedDateTime now;
	private FormatStyle fs;
	private DateTimeFormatter formatter;
	private String sline;
	private String format;
	/**
	* The constructor which stamps the local and global date and time 
	* giving at the same time an initial format.
	*/		
	PrintResults(){
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
		System.out.printf(format,
								center("Id Number",9),
								center("Name",10),
								center("Last Name",10),
								center("Birth Date",10),
								center("Gender",10),
								center("CitizenShip",18),
								center("Party",16),
								center("Status",10),
								center("Time",10));
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
	public void printObject(Elector elector){
		System.out.printf(format,
								center(elector.getId(),9),
								center(elector.getName(),10),
								center(elector.getLastName(),10),
								center(dateFormat(elector.getBirth()),10),
								center(elector.getGender(),10),
								center(elector.getCitizenship(),18),
								center(elector.getParty(),16),
								center(elector.getVoteStatus(),10),
								center(timeFormat(elector.getTime()),10));
		System.out.println(sline);
	}
}

/*

javac -d . ElectionClass/*.java

java societyAperson.Election2021

*/
