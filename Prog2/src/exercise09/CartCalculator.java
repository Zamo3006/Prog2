package exercise09;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class CartCalculator extends AbstractCartCalculator {

	@Override
	public double totalPrice(InputStream in) {
		double totalPrice = 0.0;
		if (in != null) {
			
			boolean end = false;
			int artikelNummer = -1;
			int anzahl = -1;
			double preis = -1;

			try {
				do {
					if ((artikelNummer = readInt(in)) != -1 && (anzahl = readInt(in)) != -1
							&& (preis = readDouble(in)) != -1) {
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

	private int readInt(InputStream in) throws IOException {
		byte[] b = new byte[4];
		int readLength = in.read(b);
		int readInt = -1;
		if (readLength == 4) {
			ByteBuffer bb = ByteBuffer.wrap(b);
			readInt = bb.getInt();
		}
		return readInt;
	}

	private double readDouble(InputStream in) throws IOException {
		byte[] b = new byte[8];
		int readLength = in.read(b);
		double readDouble = -1;
		if (readLength == 8) {
			ByteBuffer bb = ByteBuffer.wrap(b);
			readDouble = bb.getDouble();
		}
		return readDouble;
	}

	public static void main(String[] args) {
		CartCalculator calc = new CartCalculator();
		calc.test();
	}
}
