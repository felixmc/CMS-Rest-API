import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;

import edu.neumont.csc380.cms.model.Media;
import edu.neumont.csc380.cms.service.MediaService;

public class CMSClient {
	private MediaService service = JAXRSClientFactory.create(
			"http://localhost:8080/CMS-server/api", MediaService.class,
			Arrays.asList(new JSONProvider<Object>()));

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

	public Response getUserMedia(Long id) {
		return service.getMediaByUser(id);
	}

	public Response getAuctionMedia(Long id) {
		return service.getMediaByAuction(id);
	}

	public void setUserProfilePicture(Long id, String caption, byte[] data,
			String mimeType) {
		service.setUserProfilePicture(id, caption, data, mimeType);
	}

	public void addAuctionMedia(Long id, String caption, byte[] data,
			String mimeType) {
		service.addAuctionMedia(id, caption, data, mimeType);
	}

	public static void main(String[] args) {
		CMSClient c = new CMSClient();
		Media med = c.getAuctionMedia(2L).readEntity(Media.class);
		System.out.println(med.getCaption());
		System.out.println(c.getUserMedia(1L));

		testAuctionImageUpload(c);
		testUserImageUpload(c);
	}

	public static void testAuctionImageUpload(CMSClient c) {
		File imgPath = new File("image.jpg");
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(imgPath);
			WritableRaster raster = bufferedImage.getRaster();
			DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
			c.addAuctionMedia(2L, "lorem ipsum dolor sit amet", data.getData(),
					"image/jpeg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testUserImageUpload(CMSClient c) {
		File imgPath = new File("image.jpg");
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(imgPath);
			WritableRaster raster = bufferedImage.getRaster();
			DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
			c.addAuctionMedia(1L, "lorem ipsum dolor sit amet", data.getData(),
					"image/jpeg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
