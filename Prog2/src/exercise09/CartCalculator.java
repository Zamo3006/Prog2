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

			while (!end) {
				try {
					artikelNummer = readInt(in);
					anzahl = readInt(in);
					preis = readDouble(in);
					totalPrice += (anzahl * preis);
				} catch (IOException e) {
					end = true;
				}
			}
			try {
				in.close();
			} catch (IOException e) {
			}
		}
		return totalPrice;
	}

	private int readInt(InputStream in) throws IOException {
		byte[] b = new byte[4];
		if (in.read(b) != 4) {
			throw new IOException("End of File");
		}
		ByteBuffer bb = ByteBuffer.wrap(b);
		int readInt = bb.getInt();
		return readInt;
	}

	private double readDouble(InputStream in) throws IOException {
		byte[] b = new byte[8];
		if (in.read(b) != 8) {
			throw new IOException("End of File");
		}
		ByteBuffer bb = ByteBuffer.wrap(b);
		double readDouble = bb.getDouble();
		return readDouble;
	}

	public static void main(String[] args) {
		CartCalculator calc = new CartCalculator();
		calc.test();
	}
}
