package societyAperson;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ListIterator;
import java.util.Random;
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
	public ArrayList<Elector> elecList;
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
	private void printVoters() throws ClassNotFoundException,NoSuchFieldException,
									IllegalArgumentException, IllegalAccessException{
		Random random = new Random();
		int size = elecList.size();
		int index = random.nextInt(size-1);
		boolean empty = elecList.isEmpty();
		if(elecList.get(index).getClass().getName() == "societyAperson.Elector"){
			Elector elecObj = elecList.get(index);
			Elector2021Data electObjData = new Elector2021Data(elecObj);
			PrintResultsThree pr = new PrintResultsThree(electObjData);
			ListIterator<Elector> iterator = elecList.listIterator();
			while (iterator.hasNext()) {
				elecObj = iterator.next();
				electObjData = new Elector2021Data(elecObj);
				pr.printObject(electObjData);
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
		Election2021 elec2021 = new Election2021();
		elec2021.getElectors();
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");//clear screen 
		pb.inheritIO().start().waitFor(); 
		elec2021.printVoters();
	}
}