package exercise09;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CartCalculator extends AbstractCartCalculator {

	@Override
	public double totalPrice(InputStream in) {
		double totalPrice = 0.0;
		if (in != null) {

			AtomicInteger artikelNummer = new AtomicInteger(0);
			AtomicInteger anzahl = new AtomicInteger(0);
			AtomicReference<Double> preis = new AtomicReference<Double>(0.0);

			try {
				while (readInt(in, artikelNummer)  && readInt(in, anzahl)	&&  readDouble(in, preis) ) {
					totalPrice += (anzahl.get() * preis.get());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return totalPrice;
	}

	private boolean readInt(InputStream in, AtomicInteger i) throws IOException {
		byte[] b = new byte[4];
		boolean readInt = false;
		if (in.read(b) == 4) {
			ByteBuffer bb = ByteBuffer.wrap(b);
			i.set(bb.getInt());
			readInt = true;
		}
		return readInt;
	}

	private boolean readDouble(InputStream in, AtomicReference<Double> d) throws IOException {
		byte[] b = new byte[8];
		boolean readDouble = false;
		if (in.read(b) == 8) {
			ByteBuffer bb = ByteBuffer.wrap(b);
			d.set(bb.getDouble());
			readDouble = true;
		}
		return readDouble;
	}

	public static void main(String[] args) {
		CartCalculator calc = new CartCalculator();
		calc.test();
	}
}
