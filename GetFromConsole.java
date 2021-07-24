package societyAperson;
import java.io.Console;
import java.io.Reader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

import tailoredArrays.*;
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
	* This class is used to collect a generic array and so 
	* build with it the Elector Object
	*/
	class ConsoleParam implements ArrayElement<ConsoleParam>{
		public String param;
		ConsoleParam(String param){
			this.param = param;
		}
		public ConsoleParam error(){
			return new ConsoleParam("Error Param");
		}
	}
	/**
	* This method construct a generic array that stores ConsoleParam objects
	* which will be used by the Elector constructor to build an object necessary
	* to be put together in the generic array.
	* @returns a generic array of ConsoleParam type.
	*/
	public ArrayExpand<ConsoleParam> buffRead()throws IOException,NoSuchFieldException,
												IllegalArgumentException, IllegalAccessException{
		StringTokenizer tzer = readForDim();
		ArrayExpand<ConsoleParam> arrExp = new ArrayExpand<>();
		while (tzer.hasMoreTokens()) {
			String param = tzer.nextToken();
			arrExp.add(new ConsoleParam(param));
		} 
		return arrExp;
	}
}