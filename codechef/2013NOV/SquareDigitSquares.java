package Nov;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class SquareDigitSquares {
	
	public static Reader in = new Reader();
	public static PrintWriter out = new PrintWriter(System.out, false);

	
	public static void main(String[] args) throws NumberFormatException,
	IOException {

		int test = in.nextInt();

		for(int i=0;i<test;i++){

			long a = in.nextLong();
			long b = in.nextLong();
			
			int ans = 0;
			
			for(int j=0;j<cache.length;j++){
				if(cache[j]>=a&&cache[j]<=b)ans++;
			}
			out.println(ans);
			
		}
		out.flush();
	}
	
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
 
		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public String readLine() throws IOException {
			byte[] buf = new byte[1024];
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
 
		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (c == '.')
				while ((c = read()) >= '0' && c <= '9')
					ret += (c - '0') / (div *= 10);
			if (neg)
				return -ret;
			return ret;
		}
 
		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
 
		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
 
		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
	
	private static long[] cache = {
		1
		,4
		,9
		,49
		,100
		,144
		,400
		,441
		,900
		,1444
		,4900
		,9409
		,10000
		,10404
		,11449
		,14400
		,19044
		,40000
		,40401
		,44100
		,44944
		,90000
		,144400
		,419904
		,490000
		,491401
		,904401
		,940900
		,994009
		,1000000
		,1004004
		,1014049
		,1040400
		,1100401
		,1144900
		,1440000
		,1904400
		,1940449
		,4000000
		,4004001
		,4040100
		,4410000
		,4494400
		,9000000
		,9909904
		,9941409
		,11909401
		,14010049
		,14040009
		,14440000
		,19909444
		,40411449
		,41990400
		,49000000
		,49014001
		,49140100
		,49999041
		,90440100
		,94090000
		,94109401
		,99400900
		,99940009
		,100000000
		,100040004
		,100140049
		,100400400
		,101404900
		,101949409
		,104040000
		,104919049
		,110040100
		,111049444
		,114041041
		,114490000
		,144000000
		,190440000
		,194044900
		,400000000
		,400040001
		,400400100
		,404010000
		,404090404
		,409941009
		,414000409
		,414041104
		,441000000
		,449440000
		,490091044
		,900000000
		,990990400
		,991494144
		,994140900
		,1190940100
		,1401004900
		,1404000900
		,1409101444
		,1444000000
		,1449401041
		,1490114404
		,1990944400
		,4014109449L
		,4019940409L
		,4041144900L
		,4199040000L
		,4900000000L
		,4900140001L
		,4901400100L
		,4914010000L
		,4914991449L
		,4941949401L
		,4999904100L
		,9044010000L
		,9409000000L
		,9409194001L
		,9410940100L
		,9900449001L
		,9940090000L
		,9994000900L
		,9999400009L
		,10000000000L
	};
	

}
