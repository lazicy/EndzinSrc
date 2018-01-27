package base;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Scrapper {
	
	public static String naziv;
	public static String opis;
	public static long id;
	public static String url;

	public static String daj_html(String source) {
		
		String html_temp=null;
		
		try {
			Document doc = Jsoup.connect(source).get();
			Elements cont_temp = doc.select("div.mw-content-ltr");
			Elements head_temp = doc.select("h1.firstHeading");
			
			for(Element  pom:head_temp )
			{
				//System.out.println(pom.getElementsByTag("h1").text());
				//System.out.println("\n");
				naziv = pom.text();
				utils.SaveTest.upisi("\nNAZIV: "+naziv);
				
			}
		
			System.out.println("\n\n:");
			

			for(Element  paragraf:cont_temp )
			{
				opis = paragraf.getElementsByTag("p").get(0).text();
				//System.out.println(opis);
				utils.SaveTest.upisi("\nOPIS: "+opis);
				
				
				html_temp = paragraf.getElementsByTag("p").html();

			}
			
			//System.out.println(html_temp);
			utils.SaveTest.upisi("\n\nLINKOVI: ");
			Document temp = Jsoup.parse(html_temp);
			Elements links = temp.select("a");
			for(Element a:links)
			{
				if(a.text().startsWith("[") || !a.attr("href").startsWith("/wiki")) continue;
				//a.attr("href")
				//System.out.println(id+" "+a.text());
				url = "https://sr.wikipedia.org" + a.attr("href");
				utils.SaveTest.upisi("\n"+id+" "+url);
				//System.out.println(url);
				id++;
				
			}
		
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return html_temp;
		
	}

}
