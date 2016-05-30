package exercise08;

import java.io.*;

// Mit Hilfe dieser Klassen sollen verschluesselte Dateien
// auf der Konsole ausgegeben werden. Dazu ist die Datei zu
// oeffnen, mit einem Decryptor-Decorator zu versehen und
// einzulesen. Jedes eingelesene und entschluesselte Zeichen
// soll unmittelbar auf der Konsole ausgegeben werden. 

public class FileDecryptor {

	// Diese Methode muss nach den Vorgaben implementiert werden.
	public static void decryptFile(String filename) {
		int key = 100;
		try {
			int readDecryptedData = 1;
			InputStream is = new FileInputStream(filename);
			DecryptInputStream dis = new DecryptInputStream(is, key);
			while (readDecryptedData > 0) {
				readDecryptedData = dis.read();
				System.out.println((char) readDecryptedData);
			}
			dis.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Diese main-Methode zeigt die Verwednung der zu
	// implementierenden Methode. An der Ausgabe koennen Sie
	// erkennen, ob Ihre Implementierung funktioniert.
	public static void main(String[] args) {
		decryptFile("C:/Users/Budig/git/Prog2/Prog2/src/exercise08/data.crypt");
	}

}
