import org.junit.Test;

public class Ts{
	@Test
	 public  void t1( ){
		 String a="abc,bee,aa";
		 String[] add=a.split(",");
		 for (String string : add) {
			System.out.println(string);
		}
	 }
}
