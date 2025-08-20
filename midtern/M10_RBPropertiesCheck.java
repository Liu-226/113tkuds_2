
import java.io.*;


if (n>0 && val[0] != -1 && col[0] != 'B') { System.out.println("RootNotBlack"); return; }
int redRedIndex = firstRedRed(val, col);
if (redRedIndex != -1) { System.out.println("RedRedViolation at index " + redRedIndex); return; }
if (blackHeight(val, col, 0) == -1) { System.out.println("BlackHeightMismatch"); return; }
System.out.println("RB Valid");
}   

static class FastScanner { BufferedInputStream in; byte[] buf=new byte[1<<16]; int p=0,l=0; FastScanner(InputStream is){in=new BufferedInputStream(is);} int read(){ if(p>=l){ try{ l=in.read(buf); p=0; }catch(IOException e){return -1;} if(l<=0) return -1;} return buf[p++]; } String next() throws IOException{ StringBuilder sb=new StringBuilder(); int c; do{ c=read(); }while(c<=32 && c!=-1); while(c>32 && c!=-1){ sb.append((char)c); c=read(); } return sb.toString(); } int nextInt() throws IOException{ return Integer.parseInt(next()); } }
}
