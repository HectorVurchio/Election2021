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
	/**
    * This method is used to print the arguments that users insert through console.
    */
	private void printVoters(){
		PrintResultsTwo pr = new PrintResultsTwo();
		ListIterator<Elector> iterator = elecList.listIterator();
        while (iterator.hasNext()) {
			Elector elecObj = iterator.next();
			Elector2021Data electObjData = new Elector2021Data(elecObj);
			pr.printObject(electObjData);
        }	
	}
	/**
    * This is a temporary method to prove a reflection. Must be eliminated in the future
    */	
	private void printReflection()throws NoSuchFieldException,IllegalArgumentException, IllegalAccessException{
		ListIterator<Elector> iterator = elecList.listIterator();
        while (iterator.hasNext()) {
			Elector elecObj = iterator.next();
			Elector2021Data electObjData = new Elector2021Data(elecObj);
			PrintResultsTwo.reflectionMethod(electObjData);
        }	
	}	
	
	/**
   * The main method that starts the program.
   * @param args, the command line arguments which not in use.
   * @exception IOException, required by elec2021.getElectors() and start() methods
   * to be thrown as well as InterruptedException, also required by waitFor() method to be thrown.
   * @see IOException,InterruptedException, NoSuchFieldException belonging to printReflection().
   */
	public static void main(String[] arg)throws IOException,InterruptedException,NoSuchFieldException,IllegalArgumentException, IllegalAccessException{
		Election2021 elec2021 = new Election2021();
		elec2021.getElectors();
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");//clear screen 
		pb.inheritIO().start().waitFor(); 
		elec2021.printVoters();
		//calling a printReflection method. must be eliminated followed by printReflection()
		elec2021.printReflection();
	}
}