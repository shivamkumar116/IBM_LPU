package in.ibm.demo.bean;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component(value = "image")
public class Image {
	
	private String imageID;
	@Value(value = "demoImageUrl")
	private String imageUrl;

}
