package trpakov.io;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;
import java.util.regex.Pattern;

import trpakov.sorting.*;

public class IOTester {
	
	static final Random RAND = new Random();

	public static void main(String[] args) throws IOException, InterruptedException {
		try(Scanner scanner = new Scanner(System.in)){
//			var scan = scanner.next();
//			System.out.println(scan);
		}
		
//		int[] arr = new int[100];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = RAND.nextInt(1000);
//		}
//		
//		try(PrintWriter fWriter = new PrintWriter("D:\\file.txt")){
//			for (int i = 0; i < arr.length; i++) {
//				fWriter.println(String.valueOf(arr[i]));
//			}
//		}
		
		String myString = "Apollo 13";
		Pattern regex1 = Pattern.compile("\\d");
		Matcher regex1matcher1 = regex1.matcher(myString);
		System.out.println(regex1matcher1.find());
		System.out.println(regex1matcher1.group());
		
//		Path pathToTestFile = Paths.get("C:\\users\\trpakov\\Desktop\\test.txt");
//		try(BufferedWriter bf = Files.newBufferedWriter(pathToTestFile, Charset.defaultCharset())){
//			bf.write("hello");
//		}
		
		var request = HttpRequest.newBuilder(URI.create("http://meta.metacast.eu/?radio=radio1rock")).build();
		var client = HttpClient.newHttpClient();
		var response = client.send(request, BodyHandlers.ofString());
		Pattern namePattern = Pattern.compile("(?<=artist\":\").*(?=\",\"current)");
		Pattern songPattern = Pattern.compile("(?<=song\":\").*(?=\"})");
		Matcher nameMatcher = namePattern.matcher(response.body());
		Matcher songMatcher = songPattern.matcher(response.body());
		nameMatcher.find();
		songMatcher.find();
		System.out.println(nameMatcher.group() + " - " + songMatcher.group());
		
	}

}
