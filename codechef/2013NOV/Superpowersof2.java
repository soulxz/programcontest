package Nov;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Superpowersof2 {
	public static Reader in = new Reader();
	public static PrintWriter out = new PrintWriter(System.out, false);
 
	private static int MOD = 1000000007;
	private static BigInteger LONGMAX = new BigInteger(String.valueOf(Long.MAX_VALUE));
	private static long[] cache = new long[64];
	
	public static void main(String[] args) throws NumberFormatException,
	IOException {
		int test = in.nextInt();
		init();
		for(int i=0;i<test;i++){
			
			int N = in.nextInt();
			
			try{
				long len = Long.valueOf(Integer.toBinaryString(N));
				out.println(solve(1,len));
			}catch(Exception e){
				BigInteger len = new BigInteger(Integer.toBinaryString(N));
				long remaining = len.subtract(LONGMAX).longValue()-1;
				long ans = cache[63];				
				out.println(solve(ans,remaining));

			}
			
		}

		out.flush();
	}
	
	private static void init(){
		cache[0]=2;
		cache[1]=4;
		for(int i=2;i<cache.length;i++){
			cache[i] = (cache[i-1] * cache[i-1])%MOD;
		}
	}

	private static int solve(long prevAns,long len){
		long ans = prevAns;
		long tmpLen = 1;
		int i=0;
		while(len>0){
			tmpLen += tmpLen;
			if(tmpLen>len){
				len -= tmpLen/2;
				tmpLen = 1;
				ans = (ans * cache[i])%MOD;
				i=0;
				continue;
			}
			
			if(len>1){
				i++;
			}
		}
		
		ans = (ans * ans)%MOD;
		
		return (int)ans;
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
	
}
