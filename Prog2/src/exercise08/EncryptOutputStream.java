package exercise08;

import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends OutputStream {

	private OutputStream os;
	private int key;

	public EncryptOutputStream(OutputStream os, int key) throws IllegalArgumentException {
		if (key < 0 && key > 255) {
			throw new IllegalArgumentException("Ungültiger Key");
		} else {
			this.os = os;
			this.key = key;
		}
	}

	@Override
	public void write(int arg0) throws IOException {
		os.write(encrypt(arg0));
	}

	@Override
	public void close() throws IOException {
		os.close();
	}

	private int encrypt(int i) {
		int encrypted = i ^ key;
		return encrypted;
	}

}
