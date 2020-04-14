package in.ibm.demo.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Getter
@Setter
public class Image {

	private String imageID;
	private String imageURL;
}
