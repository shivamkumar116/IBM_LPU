package in.ibm.jackson_databind_json_pojo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonbExample {

	public static void main(String[] args) {
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(new Customer(1, "John", "Doe", true, new Address(), new String[3]));
		System.out.println(result);

	}

}
