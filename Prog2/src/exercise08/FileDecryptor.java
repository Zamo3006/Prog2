package exercise08;

import java.io.*;

// Mit Hilfe dieser Klassen sollen verschluesselte Dateien
// auf der Konsole ausgegeben werden. Dazu ist die Datei zu
// oeffnen, mit einem Decryptor-Decorator zu versehen und
// einzulesen. Jedes eingelesene und entschluesselte Zeichen
// soll unmittelbar auf der Konsole ausgegeben werden. 

public class FileDecryptor {

	public static void decryptFile(String filename) {
		try {
			int readDecryptedData = 0;
			InputStream is = new FileInputStream(filename);
			DecryptInputStream dis = new DecryptInputStream(is, 100);
			while (readDecryptedData >= 0) {
				readDecryptedData = dis.read();
				if (readDecryptedData >= 0)
					System.out.print((char) readDecryptedData);
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
		decryptFile("./src/exercise08/data.crypt");
	}

}
