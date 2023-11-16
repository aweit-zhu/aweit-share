import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		try (FileReader reader = new FileReader("123.txt");){
			int i = 0;
			while( (i = reader.read()) != -1) {
				System.out.print(i + ":" +(char)i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

//System.out.printf(
//		"十進位:%s,二進位:%s,十六進位:%s,字元:%s %n",
//		i,Integer.toBinaryString(i),Integer.toHexString(i),(char)i);

//try (FileReader reader = new FileReader("123.txt");){
//char[] two = new char[2];
//while( reader.read(two) > 0) {
//	System.out.println(two);
//}
//} catch (Exception e) {
//e.printStackTrace();
//}