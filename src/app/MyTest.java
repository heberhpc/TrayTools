package app;
import org.jsoup.Jsoup;

public class MyTest {

	public static void main (String [] args ) {
		
		String html = "<p><font color=\"red\"><strong>* IMAGENS MERAMENTE ILUSTRATIVAS</strong></font></p>";
		
		String plain = Jsoup.parse(html).text();
		
		System.out.println(plain);
		
	}

}
