package societyAperson;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ListIterator;
import java.util.Random;

import tailoredArrays.*;
/**
* The Election2021 runs an application that will be used to give examples
*  of some data structures and algorithms as well as talk about Java .
* @package societyAperson 
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-15 
*/
public class Election2021Generic{
	int n = 0;
	Elector elector; 
	GetFromConsole gfc;
	StringTokenizer tzer;
	public ArrayExpand<Elector> elecList;
	/**
    * This method is used to get the arguments that users insert through console and 
	* store it in the generic array (elecList).
	* @exception IOException, required by tzer = gfc.readForDim() 
	* and by elector = gfc.buffRead() to be thrown. Also NoSuchFieldException,
	* IllegalArgumentException, IllegalAccessException required by gfc.buffRead().
    * @see IOException.
    */
	void getElectors()throws IOException,NoSuchFieldException,
												IllegalArgumentException, IllegalAccessException{
		gfc = new GetFromConsole();
		tzer = gfc.readForDim();
		n = Integer.parseInt(tzer.nextToken());
		elecList = new ArrayExpand<>(); //stack of all Elector objects
		for (int i = 0; i < n; ++i) {
			ArrayExpand<?> arrE = gfc.buffRead(); //stack of every String in the row
			elector = new Elector(arrE); //an Elector object to be piled
			elecList.add(elector); 
		}
	}
	/**
    * This method is used to print the arguments that users insert through console.
    */
	private void printVoters() throws ClassNotFoundException,NoSuchFieldException,
									IllegalArgumentException, IllegalAccessException{
		Random random = new Random();
		int size = elecList.getSize();
		int index = random.nextInt(size-1);
		//boolean empty = elecList.isEmpty();
		if(elecList.getValue(index).getClass().getName() == "societyAperson.Elector"){
			Elector elecObj = elecList.getValue(index);
			PrintResults<Elector> pr = new PrintResults<>(elecObj);
			for(int i =0 ;i < size;i++){
				elecObj = elecList.getValue(i);
				pr.printObject(elecObj);
			}
		}else{
			System.out.println("The Income object doesn't belong to societyAperson.Elector");
		}		
	}
	
	/**
   * The main method that starts the program.
   * @param args, the command line arguments which not in use.
   * @exception IOException, required by elec2021.getElectors() and start() methods
   * to be thrown as well as InterruptedException, also required by waitFor() method to be thrown.
   * ClassNotFoundException is required by reflectionHeader method.
   * @see IOException,InterruptedException, NoSuchFieldException belonging to printVoters().
   */
	public static void main(String[] arg)throws IOException,InterruptedException,NoSuchFieldException,IllegalArgumentException, IllegalAccessException,ClassNotFoundException{
		Election2021Generic elec2021 = new Election2021Generic();
		elec2021.getElectors();
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");//clear screen 
		pb.inheritIO().start().waitFor(); 
		elec2021.printVoters();
	}
}

/*
javac -d . *.java

java societyAperson.Election2021Generic

*/