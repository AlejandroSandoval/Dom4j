import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class MyParse {

	public static void main(String[] args) {
		try {
	        // Create Document object
	        SAXReader reader = new SAXReader();
	        Document document = reader.read(new FileInputStream("vehicles.xml"));
	        
	        List<Node> nodes = document.selectNodes("/vehicles/vehicle" );
	         System.out.println("----------------------------");
	         for (Node node : nodes) {
	        	 if(node.valueOf("@type").equals("car"))
	        	 {
	        		System.out.println("Last Name : " + node.selectSingleNode("model").getText());
	 	            System.out.println("First Name : " + node.selectSingleNode("price").getText());
	 	            System.out.println(""+node.selectSingleNode("colors").getStringValue());
	        	 }
	         }
	        // Count all nodes
	        System.out.println("Total Vehicles: " + document.selectNodes("//vehicles/vehicle").size());
	 
	        // Count specific nodes
	        System.out.println("No. of bikes: " + document.selectNodes("//vehicles/vehicle[@type='bike']").size());
	 
	        System.out.println("No. of cars: " + document.selectNodes("//vehicles/vehicle[@type='car']").size());
	 
	        // Get specific node (i.e. bikes manufacturerd by 'Hero Honda')
	        System.out.println("Bikes manufacturerd by 'Hero Honda': " + document.selectNodes("//vehicles/vehicle[@type='bike'][manufacturer='Hero Honda']").size());
	 
	        // Get the last element (i.e. last bike element and print it's details)
	        Node lastBike = document.selectSingleNode("//vehicles/vehicle[@type='bike'][last()]");
	        if (lastBike != null) {
	            System.out.println("n==== Last Bike Details ===");
	            // Get the node value inside the node
	            System.out.println("Manufacturer: " + lastBike.selectSingleNode("manufacturer").getText());
	            System.out.println("Model: " + lastBike.selectSingleNode("model").getText());
	        }
	 
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
}

