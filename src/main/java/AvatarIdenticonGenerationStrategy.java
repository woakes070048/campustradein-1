
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.math.BigInteger;

/**
 * @author ifeify
 */
public class AvatarIdenticonGenerationStrategy implements IdenticonGenerationStrategy {
    @Override
    public BufferedImage execute(int hash, int width, int height, Color background) {
        BufferedImage identicon = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = identicon.getRaster();

        Color foreground = generateForegroundColor(hash, background);
        boolean usedForeground = false;
        int rotationCount = 0;
        while(!usedForeground && rotationCount < 32) {
            hash = Integer.rotateLeft(hash, rotationCount);
            rotationCount++;
            for(int x = 0; x < (width + 1) / 2; x++) {
                for(int y = 0; y < height; y++) {
                    Color pixelColor = getPixelColor(hash, x, y, foreground, background);
                    if(pixelColor.equals(foreground)) {
                        usedForeground = true;
                    }
                    double[] pixels = {pixelColor.getRed(), pixelColor.getBlue(),
                                        pixelColor.getGreen(), pixelColor.getOpacity()};
                    raster.setPixel(x, y, pixels);
                    raster.setPixel(width - (x + 1), y, pixels);
                }
            }
        }
        return identicon;
    }


    private static Color getPixelColor(int hash, int x, int y, Color foreground, Color background) {
        int rotated = Integer.rotateLeft(hash, (int)(2.718281 * x + y));
        if((rotated & hash & 2) == 2) {
            return foreground;
        }
        return background;
    }

    private static double calculateBrightnessIndex(Color color) {
        return Math.sqrt(color.getRed() * color.getRed() * .241 +
                        color.getGreen() * color.getGreen() * .691 +
                        color.getBlue() * color.getBlue() * .068);
    }

    private static Color generateForegroundColor(int hash, Color background) {
        Color foreground = background;

        double foregroundIndex = calculateBrightnessIndex(foreground);
        double backgroundIndex = calculateBrightnessIndex(background);
        int rotation = 0;
        while (Math.abs(foregroundIndex - backgroundIndex) < 30 && rotation < 32) {
            int r = Integer.rotateLeft(hash, rotation) & 255;
            int g = Integer.rotateLeft(hash, 8 + rotation) & 255;
            int b = Integer.rotateLeft(hash, 16 + rotation) & 255;
            foreground = Color.rgb(r, g, b, 1);

            rotation++;
            foregroundIndex = calculateBrightnessIndex(foreground);
            backgroundIndex = calculateBrightnessIndex(background);
        }
        return foreground;
    }
}
