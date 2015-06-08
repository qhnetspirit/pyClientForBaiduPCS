import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 
 */

/**
 * @author 007
 * 
 */
/**
 * @author 007
 *
 */
public class CommandRunner {
	
	public static LinkedList<String> run(String cmd,boolean verbose) {
		LinkedList<String> outputStringList=new LinkedList<String>();
		try {
			if(verbose) System.out.println("start excute cmd");
			Process pr = Runtime.getRuntime().exec(cmd);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				if(verbose) System.out.println("    "+line);
				outputStringList.add(line);
			}
			in.close();
			pr.waitFor();
			if(verbose) System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	  return outputStringList;
	}

}
