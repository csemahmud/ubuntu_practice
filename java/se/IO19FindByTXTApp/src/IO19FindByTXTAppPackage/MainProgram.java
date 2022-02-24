/**
 * 
 */
package IO19FindByTXTAppPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import IO19FindByTXTAppPackage.classes.FindByTXT;

/**
 * @author MAHMUDUL HASAN KHAN CSE
 *
 */
public class MainProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\n");
		searchText("docs", "জাভা");
		searchText("docs", "সি শার্প");
		searchText("docs", "পাইথন");
	}

	private static void searchText(String directoryStr, String textToSearch) {
		// TODO Auto-generated method stub
		
		System.out.println();
		
		Path stringDir = Paths.get(directoryStr);
		FindByTXT findByTXT = new FindByTXT(textToSearch);
		
		try {
			Files.walkFileTree(stringDir, findByTXT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(findByTXT.getFoundFiles().size() > 0) {
			
			System.out.println("\t\"" + findByTXT.getTextToSearch()
			+ "\" has been found in the Following Files : ");
			Iterator <Path> iterator = findByTXT.getFoundFiles().iterator();
			System.out.print("\t{");
			while(true) {
				System.out.print("\t" + iterator.next().getFileName());
				if(iterator.hasNext()) {
					System.out.print(",");
				} else {
					System.out.println("\t}");
					break;
				}
			}
			
		} else {
			System.out.println("\tNo File Contains The Text : \""
					+ textToSearch + "\"");
		}
	}

}
