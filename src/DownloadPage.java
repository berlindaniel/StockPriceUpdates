import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

public class DownloadPage {
	public static void main(String[] args) throws IOException {
		
        URL url = new URL("https://markets.wsj.com/us");
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        HashMap<String, Double> prices = new HashMap<>();

        // locate lines that contain desired indices, find and add (index, price) to a HashMap
        int h = 1;
        while ((line = br.readLine()) != null) {
        	//System.out.println(line);

        	if (line.contains("USD/JPY") && !prices.keySet().contains("USD/JPY")) {
        		h = 4;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("USD/JPY", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("USD/CNY") && !prices.keySet().contains("USD/CNY")) {
        		h = 5;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("USD/CNY", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("EUR/USD") && !prices.keySet().contains("EUR/USD")) {
        		h = 4;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("EUR/USD", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("GBP/USD") && !prices.keySet().contains("GBP/USD")) {
        		h = 4;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("GBP/USD", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("FTSE 100") && !prices.keySet().contains("FTSE100")) {
        		h = 4;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("FTSE100", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("Brent crude") && !prices.keySet().contains("Brent")) {
        		h = 6;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("Brent", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("SP 500 futures") && !prices.keySet().contains("SP500")) {
        		h = 6;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("SP500", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("Dow Jones Industrial futures") && !prices.keySet().contains("DJIA")) {
        		h = 6;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("DJIA", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("Japan: Nikkei 225") && !prices.keySet().contains("Nikk225")) {
        		h = 4;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("Nikk225", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("Germany: DAX") && !prices.keySet().contains("DAX")) {
        		h = 4;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("DAX", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains("futures/Gold") && !prices.keySet().contains("Gold")) {
        		h = 4;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("Gold", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains(">Japan 10 Year<") && !prices.keySet().contains("Japan10Yr")) {
        		h = 5;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("Japan10Yr", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains(">Germany 10 Year<") && !prices.keySet().contains("Germany10Yr")) {
        		h = 7;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("Germany10Yr", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains(">U.S. 10 Year<") && !prices.keySet().contains("US10Yr")) {
        		h = 5;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("US10Yr", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        	if (line.contains(">U.K. 10 Year<") && !prices.keySet().contains("UK10Yr")) {
        		h = 7;
	        	for (int i = h; i > 1; i--) line = br.readLine();
	        	prices.put("UK10Yr", Double.parseDouble(line.substring(line.indexOf(">")+1, line.substring(line.indexOf(">")).indexOf("<") + line.indexOf(">")))); 
        	}
        }
		System.out.println(prices);
	}
}
