package exercise09;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class CartCalculator extends AbstractCartCalculator {

	@Override
	public double totalPrice(InputStream in) {
		boolean end = false;
		double totalPrice = 0.0;
		if (in != null) {
			try {
				do {
					int artikelNummer = readInt(in);
					int anzahl = readInt(in);
					double preis = readDouble(in);
					if (artikelNummer > 0 && anzahl > 0 && preis > 0) {
						totalPrice += (anzahl * preis);
					} else {
						end = true;
					}
				} while (!end);
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return totalPrice;
	}

	private double readDouble(InputStream in) throws IOException {
		double returnDouble = 0;
		byte[] readBytes = new byte[8];
		for (int i = 0; i < 8; i++) {
			readBytes[i] = readByte(in);
			if (readBytes[i] == -1) {
				return -1;
			}
		}
		ByteBuffer bb = ByteBuffer.wrap(readBytes);
		returnDouble = bb.getDouble();
		return returnDouble;
	}

	private int readInt(InputStream in) throws IOException {
		int returnInt = 0;
		byte[] readBytes = new byte[4];
		for (int i = 0; i < 4; i++) {
			readBytes[i] = readByte(in);
			if (readBytes[i] == -1) {
				return -1;
			}
		}
		ByteBuffer bb = ByteBuffer.wrap(readBytes);
		returnInt = bb.getInt();
		return returnInt;
	}

	private byte readByte(InputStream in) throws IOException {
		byte returnByte = 0;
		returnByte = (byte) in.read();
		return returnByte;
	}

	public static void main(String[] args) {
		CartCalculator calc = new CartCalculator();
		calc.test();
	}
}
