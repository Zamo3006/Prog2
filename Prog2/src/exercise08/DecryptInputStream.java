package exercise08;

import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends InputStream {

	private InputStream is;
	private int key;

	public DecryptInputStream(InputStream is, int key) throws IllegalArgumentException {
		if (key < 0 && key > 255) {
			throw new IllegalArgumentException("Ungültiger Key");
		} else {
			this.is = is;
			this.key = key;
		}
	}

	@Override
	public int read() throws IOException {
		int encrypted = is.read();
		return decrypt(encrypted);
	}

	@Override
	public void close() throws IOException {
		is.close();
	}

	private int decrypt(int i) {
		int decrypt = i ^ key;
		return decrypt;
	}

}
