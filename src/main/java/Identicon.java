import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ifeify
 */
public class Identicon {
    private String information;
    private int width;
    private int height;
    private Color background = Color.WHITE;
    private IdenticonGenerationStrategy identiconGenerationStrategy = new AvatarIdenticonGenerationStrategy();

    public Identicon(String information, int width, int height){
        this.information = information;
        this.width = width;
        this.height = height;
    }

    public void setBackground(Color color) {
        this.background = color;
    }

    public void setIdenticonGenerationStrategy(IdenticonGenerationStrategy strategy) {
        identiconGenerationStrategy = strategy;
    }

    public IdenticonGenerationStrategy getIdenticonGenerationStrategy() {
        return identiconGenerationStrategy;
    }

    public BufferedImage generate() {
        return identiconGenerationStrategy.execute(information.hashCode(), width, height, background);
    }
}
