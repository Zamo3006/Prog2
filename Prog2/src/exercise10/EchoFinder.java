package exercise10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author Patrick Budig 5115455
 */
public class EchoFinder implements EchoFinderInterface {

	@Override
	public String getPair(BufferedReader bufRead) {
		String returnString = null;
		boolean end = false;
		String echoString = null;
		try {
			while (!end) {
				String readString = bufRead.readLine();
				if (readString == null || readString.equals(echoString)) {
					returnString = readString;
					end = true;
				}
				echoString = readString;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnString;
	}

	@Override
	public BufferedReader getSystemInAsBufferedReader() {
		Reader reader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		return bufferedReader;
	}

	public static void main(String[] args) {
		EchoFinder echoFinder = new EchoFinder();
		BufferedReader bufferedReader = echoFinder.getSystemInAsBufferedReader();
		String echo = echoFinder.getPair(bufferedReader);
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(echo == null ? "No Echo found, End of Stream reached." : "Echo found: " + echo);
	}

}
