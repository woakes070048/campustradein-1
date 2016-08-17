import javafx.scene.paint.Color;
import java.awt.image.BufferedImage;

/**
 * @author ifeify
 */
public interface IdenticonGenerationStrategy {
    public BufferedImage execute(int hash, int width, int height, Color background);
}
