package in.ibm.jackson_databind_json_pojo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			// Creating the object from the jackson project
			ObjectMapper objMapper = new ObjectMapper();

			Customer customer = objMapper.readValue(new File("Data/data.json"), Customer.class);

			// also print individual items
			System.out.println("First name = " + customer.getFirstName());
			System.out.println("Last name = " + customer.getLastName());

			// get nested object: array
			Address tempAddress = customer.getAddress();
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// converting to json
		Customer theCustomer = new Customer();
		theCustomer.setId(2);
		theCustomer.setFirstName("Anil");
		theCustomer.setLastName("Kuar");
		String[] lang = { "Hindi", "English" };
		theCustomer.setLanguages(lang);
		Address theAddress = new Address();
		theAddress.setStreet("01");
		theAddress.setCountry("IN");
		theAddress.setCity("PLP");
		theAddress.setState("HP");
		theAddress.setZip("176059");
		theCustomer.setAddress(theAddress);
		ObjectMapper mapper= new ObjectMapper();
		try {
			mapper.writeValue(new File("Data/Customer.json"), theCustomer);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
