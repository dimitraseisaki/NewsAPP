import java.util.List;
import java.util.Scanner;

import exception.NewsAPIException;
import model.newsinfo;
import model.thenewsdb.Location;
import model.thenewsdb.LocationResult;
import services.LocationAPIService;
import services.NewsAPIService;

//η κλασή αυτή δημιουργεί την κοσνόλα που θα εμφανίζει τα αποτελέσματα
public class Application {
	
	public static void main(String[] args) throws NewsAPIException {
		// TODO Auto-generated method stub
     NewsAPIService newsAPIService=NewsAPI.getNewsAPIService();
     
     System.out.println("Welcome to NewsAPP!");
     
     //χρησιμοποιώ το while για την επανάληψη μετά από την επιλογή ενός αποτελέσματος 
     while (true) {
     //ο χρήστης κάνει επιλογή μία από τις παρακάτω εκτυπώσεις
     System.out.println("Select one of the following");
     System.out.println("1a. Show the top headlines for a country:");
     System.out.println("1b. Show the top headlines for a category:");
     System.out.println("2a. Search QueryForNews ");
     System.out.println("2b. Search NewsForLanguage ");
     System.out.println("2c. Search EverythingForSource ");
     System.out.println("2d. Search QueryForDateofPublication ");
     System.out.println("3. Search news for user Location ");
     System.out.println("4. Exit");
     System.out.println("Your input");
     

     Scanner sc = new Scanner(System.in); //το χρησιμοποιούμε για ανάγνωση από την κονσόλα
     String input= sc.nextLine();
     System.out.println("Your input:"+input);
     
     //περιπτώσεις που μπορεί να εκτελέσει ο χρήστης και τι του ζητείται να πληκτρολογήσει γιανα εμφανίσει αποτελέσματα
     switch(input) {
     case "1a":
    
    	 System.out.println("Enter the country of your choice:");
    	 String country = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.getPopularNewsForCountry(country);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
     case "1b":
    	    
    	 System.out.println("Enter the country of your choice:");
    	 String country1 = sc.nextLine();
    	 System.out.println("Enter the category of your choice:");
    	 String category = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.getPopularNewsForCategory(country1,category);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
      
     case "2a":
    	 System.out.println("Enter the query of your choice:");
    	 String q = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.searchQueryForNews(q);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
     case "2b":
   	     System.out.println("Enter the query of your choice:");
    	 String q1 = sc.nextLine();
    	 System.out.println("Enter the language of your choice:");
    	 String language = sc.nextLine();
    	 System.out.println("Enter the source of your choice:");
    	 String sources = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.searchEverythingForSource(q1,language,sources);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
    	 
     case "2c":
    	 System.out.println("Enter the query of your choice:");
    	 String q11 = sc.nextLine();
    	 System.out.println("Enter the language of your choice:");
    	 String language1 = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.getsearchNewsForLanguage(q11,language1);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
     case "2d":
   	     System.out.println("Enter the query of your choice:");
    	 String q111 = sc.nextLine();
    	 System.out.println("Enter the language of your choice:");
    	 String language11 = sc.nextLine();
    	 System.out.println("Enter the source of your choice:");
    	 String sources1 = sc.nextLine();
    	 System.out.println("Enter the start date");
    	 String from = sc.nextLine();
    	 System.out.println("Enter the end date");
    	 String to = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.getsearchQueryForDateofPublication(q111,language11,sources1,from, to);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
     case "3":
    	 //γράφω το api key που είναι γραμμένο στο NewsAPITest   
    	 System.out.println("Enter your api key:");
    	 String api_key = sc.nextLine();
    		final LocationAPIService newsSearchService1= LocationAPI.getLocationAPIService();
    		final LocationResult results2 = newsSearchService1.searchUserLocation(api_key);
    		String country3 = Location.getCountry();
    		System.out.println("Your country is: " + country3);
    		try {
    	final List<newsinfo> results= newsAPIService.getPopularNewsForCountry(country3);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
     case "4":
			//System.exit(0);
			System.out.println("End programm!");
			break;
		default:
			System.out.println("Invalid input");
     }
		}
	}

}
	

	


