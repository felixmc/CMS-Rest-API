
import java.util.Arrays;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;

import edu.neumont.csc380.cms.model.Media;
import edu.neumont.csc380.cms.service.MediaService;

public class CMSClient{
	private JSONProvider<Object> json;
	private MediaService service;
	
	public CMSClient(){
		 json = new JSONProvider<Object>();
		 json.setDropRootElement(true);
		 json.setSupportUnwrapped(true);
		 service = JAXRSClientFactory.create("http://localhost:8080/CMS-server/api", MediaService.class, Arrays.asList(json));
	}
	
	public Response getMedia(Long id) {
		return service.getMedia(id);
	}

	public Response getMediaData(Long id) {
		return service.getMediaData(id);
	}

	public Response getMediadata(Long id) {
		return service.getMediaThumb(id);
	}

	public void deleteMedia(Long id) {
		service.deleteMedia(id);
	}

	public Response getUserMedia(Long id){
		return service.getMediaByUser(id);
	}
	
	public Response getAuctionMedia(Long id){
		return service.getMediaByAuction(id);
	}
	
	public void setUserProfilePicture(Long id, String caption, byte[] data, String mimeType){
		service.setUserProfilePicture(id, caption, data, mimeType);
	}
	
	public void addAuctionMedia(Long id, String caption, byte[] data, String mimeType){
		service.addAuctionMedia(id, caption, data, mimeType);
	}

	public static void main(String[] args) {
		CMSClient c = new CMSClient();
		Media med = c.getAuctionMedia(2L).readEntity(Media.class);
		System.out.println(med.getCaption());
		System.out.println(c.getUserMedia(1L));
	}
}
