package societyAperson;
import java.io.Console;
import java.io.Reader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
/**
* The GetFromConsole is a class that works with Election2021 class 
* in an application that will be used to give examples of some data structures
* and algorithms as well as talk about Java .
*
* The current class takes the input data inserted by users in the console.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-15 
*/
class GetFromConsole{
	private Console console;
	private Reader reader;
	private BufferedReader br;
	int counter; 
	/**
	* This method is used to get a StringTokenizer instance.
	* @exception IOException, required by br.readLine() method
	* @return a StringTokenizer instance.
	*/	
	public StringTokenizer readForDim()throws IOException{
		console = System.console();
		reader = console.reader();
		br = new BufferedReader(reader);
		StringTokenizer tzer = new StringTokenizer(br.readLine());
		return tzer;
	}
	/**
	* This method is used to log an Elector class fields.
	* @exception IOException, required by readForDim() method
	* @return an Elector instance.
	*/		
	public Elector buffRead()throws IOException{
		int count = 0;
		StringTokenizer tzer = readForDim();
		BirthCertificate bicert = null;
		String placeOBirth = null;
		String birth = null;
		CitizenId citizenId = null;
		Elector elector = null;
		while (tzer.hasMoreTokens()) {
			switch(count){
				case 0:
				placeOBirth = tzer.nextToken();
				break;
				case 1:
				birth = tzer.nextToken();
				break;
				case 2:
				bicert = new BirthCertificate(placeOBirth,
									birth,
									tzer.nextToken().charAt(0));
				break;
				case 3:
				citizenId = new CitizenId(bicert,
													tzer.nextToken());
				break;
				case 4:
				citizenId.setName(tzer.nextToken());
				break;
				case 5:
				citizenId.setLastName(tzer.nextToken());
				elector = new Elector(citizenId);
				break;
				case 6:
				elector.setParty(tzer.nextToken());
				break;
				case 7:
				elector.setVoteStatus(tzer.nextToken().charAt(0));
				break;
				case 8:
				elector.setTime(tzer.nextToken());
			}
			count++;
		}
		return elector;
	}
}