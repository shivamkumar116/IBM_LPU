package in.ibm.demo.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Image {

	private String imageID;
	private String imageUrl;
	private boolean isAvailable;

	public Image(String imageUrl,boolean isAvailable) {
		this.imageID =UUID.randomUUID().toString();
		this.imageUrl=imageUrl;
		this.isAvailable=isAvailable;
	}
	
	
	@Override
	public String toString() {
		return "Image [imageID=" + imageID + ", imageUrl=" + imageUrl + ", isAvailable=" + isAvailable + "]";
	}

}
