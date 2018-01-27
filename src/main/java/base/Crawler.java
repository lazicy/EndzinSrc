package base;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
	
	public static Queue<String> kju = new LinkedList<>();
	public static Set<String> marked = new HashSet<>();
	public static String regex = "/wiki/(.+?)\"";
	
	public static void main(String[] args) 
	{
			utils.SaveTest.kreiraj();
			
			
			MongoConnect mongo = new MongoConnect();
			
			
			//String html = base.Scrapper.daj_html("https://sr.wikipedia.org/wiki/%D0%9C%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0");
			algoritam("https://sr.wikipedia.org/wiki/%D0%9C%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0");
			//System.out.println(html);
			
		
			
		
	}
	
	
	
public static void algoritam(String root) 
{

	kju.add(root);
	while(!kju.isEmpty())
	{
		
		String crawledURL = kju.poll();
		System.out.println("* * * Iskrolovana stranica : " + crawledURL);
		if(marked.size()>1000)
		{
			System.out.println("Gasi majstore, count memorisanih > 1000, cackaj na liniji 47.");
			return;
		}
		
		String html = null;
		boolean kraj = false; //kraj trazenja prvog valjanog u kju u u uu 
		
		while(!kraj)
		{
			if(( html = base.Scrapper.daj_html(crawledURL))==null)
			{
				System.out.println("! Ne valjda link : " + crawledURL);
				crawledURL = kju.poll();
				kraj = false;
			}
			else
			{
				kraj = true; // :)
			}
		}

		
		//System.out.println(html);
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(html);
		while(matcher.find())
		{
			
			String w = matcher.group();
			String adresa = "https://sr.wikipedia.org" + w.substring(0, w.length()-1); //secenje " title dela

			marked.add(adresa);
			System.out.println("Dodat je sajt: "+ adresa);
			kju.add(adresa);
		}
		
	}

	
}
	
	
/*	public static void algoritam(String root) throws IOException
	{
		kju.add(root);
		BufferedReader br = null;
		
		while(!kju.isEmpty())
		{
			String crawledURL = kju.poll();
			System.out.println("Iskrolovana stranica : " + crawledURL + "----------");
			
			if(marked.size()>250) return;
			
			boolean ok = false ;
			URL url = null;
			
			
			while(!ok)
			{
				try 
				{
					url = new URL(crawledURL);
					br = new BufferedReader(new InputStreamReader(url.openStream()));
					ok = true;
				}
				catch (MalformedURLException e)
				{
					System.out.println("Lose formiran url."+ crawledURL);
					crawledURL = kju.poll();
					ok = false;
				}
				catch (IOException ioe)
				{
					System.out.println("IOException url url." + crawledURL);
					crawledURL = kju.poll();
					ok = false;
					
				}
			}
			String tmp = null;
			StringBuilder sb = new StringBuilder();
			while(( tmp = br.readLine())!=null)
				sb.append(tmp);
			
			tmp = sb.toString();
			
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(tmp);
			
			while(matcher.find())
			{
				String w = matcher.group();
				if(!marked.contains(w))
				{
					marked.add(w);
					System.out.println("Dodat je sajt: "+"https://sr.wikipedia.org/"+w);
					kju.add("https://sr.wikipedia.org/"+w);
				}
			}
			
		if(br!=null)
		{br.close();}
		}
	
	}

	public static void Show()
	{
		
		System.out.println("Rezultati: ");
		System.out.println("Krolovani sajtovi: "+marked.size()+"\n");
		
		for(String s : marked)
		{
			System.out.println("--- " + s + "\n");
		}
		
	}
*/
}
