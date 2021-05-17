package societyAperson;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ListIterator;
/**
* The Election2021 runs an application that will be used to give examples
*  of some data structures and algorithms as well as talk about Java .
*
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-15 
*/
public class Election2021{
	int n = 0;
	Elector elector; 
	GetFromConsole gfc;
	StringTokenizer tzer;
	ArrayList<Elector> elecList;
	/**
    * This method is used to get the arguments that users insert through console.
	* @exception IOException, required by tzer = gfc.readForDim() 
	* and by elector = gfc.buffRead() to be thrown.
    * @see IOException.
    */
	void getElectors()throws IOException{
		gfc = new GetFromConsole();
		tzer = gfc.readForDim();
		n = Integer.parseInt(tzer.nextToken());
		elecList = new ArrayList<Elector>(n);
		for (int i = 0; i < n; ++i) {
			elector = gfc.buffRead();
			elecList.add(elector);
		}
	}
	public static void main(String[] arg){
		
	}
}