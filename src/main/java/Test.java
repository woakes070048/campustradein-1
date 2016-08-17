import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @author ifeify
 */
public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        Identicon identicon = new Identicon("ifeify", 50, 50);
        BufferedImage image = identicon.generate();
        ImageIO.write(image, "jpg", new File("identicon.jpg"));
    }
}
