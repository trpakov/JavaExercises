import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester{
	
	public static void main(String[] args)throws IOException{
		
		InetAddress host = InetAddress.getByName("amazon.com");
		String hostName = host.getHostName();
		System.out.println("Host name: " + hostName);
		System.out.println("IP address: " + host.getHostAddress());
		System.out.println();
		
		// creates a URL with string representation.
		URL url1 =new URL("https://ff.tu-sofia.bg"+"/sites/default/files/documents_ff/FICHE_INSCRIPION-IC_002.pdf");
		
		// creates a URL with a protocol,hostname,andpath
		URL url2 = new URL("https", "ff.tu-sofia.bg","/futurs-etudiants/");
		
		//create a URL with another URL and path
		URL url3 = new URL("https://ff.tu-sofia.bg");
		URL url4 = new URL(url3, "/futurs-etudiants/");
		
		// print the String representation of the URL.
		System.out.println(url1.toString());
		System.out.println(url2.toString());
		System.out.println();System.out.println("Different components of the URL");
		
		// Retrieve the protocol for the URL 
		System.out.println("Protocol url1: " + url1.getProtocol());
		
		// Retrieve the host name of the URL
		System.out.println("Hostname url1:" + url1.getHost());
		
		// Retrieve the default port
		System.out.println("Default port url1: " + url1.getDefaultPort());
		
		// Retrieve the path of URL
		System.out.println("Path url4: " + url4.getPath());
		
		// Retrieve the file name
		System.out.println("File url1: " + url1.getFile());
		System.out.println();
		
		int abyte;
		try{
				URL url = new URL("https://upload.wikimedia.org/wikipedia/en/thumb/8/80/Wikipedia-logo-v2.svg/1024px-Wikipedia-logo-v2.svg.png");
				InputStream fi = url.openStream();
				FileOutputStream fo = new FileOutputStream("picture.jpg");
				System.out.println("srarting ...");
				while((abyte= fi.read())!=-1)fo.write(abyte);
				fi.close();
				fo.close();
				System.out.println("created");
				
				URL url5 = new URL("https://nbu.bg");
				BufferedReader bReader = new BufferedReader(new InputStreamReader(url5.openStream(),Charset.forName("UTF-8")));
				String lineString;
				while((lineString=bReader.readLine()) != null) {
					//System.out.println(lineString);
				}
				bReader.close();
			}
		catch(MalformedURLException me) {
				System.out.println("MalformedURLException: "+ me);
			}
		catch (IOException ioe){
				System.out.println("IOException: "+ ioe);
			}
		
		
		System.out.println();
			
		// Radio Current Song
		URL myUrl = new URL("https://meta.metacast.eu/?radio=radio1rock");
		HttpURLConnection conn = (HttpURLConnection)myUrl.openConnection();
		String result = new BufferedReader(new InputStreamReader(conn.getInputStream())).readLine();
		Pattern p1 = Pattern.compile("(?<=\"current_artist\":\").+(?=\",\")");
		Pattern p2 = Pattern.compile("(?<=\"current_song\":\").+(?=\"})");
		//System.out.println(result);
		Matcher matcher1 = p1.matcher(result);
		Matcher matcher2 = p2.matcher(result);
		matcher1.find();
		matcher2.find();
		System.out.println(matcher1.group() + " - " + matcher2.group());
		

	}
}
