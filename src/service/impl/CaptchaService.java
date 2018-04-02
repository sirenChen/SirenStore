package service.impl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

/**
 * Created by Siren Chen.
 *
 * service for CaptchaServlet
 */
public class CaptchaService {

    /**
     * According to the input list, get a random text
     * @param Texts
     * @return
     */
    public String getText (List<String> Texts) {
        Random random = new Random();
        return Texts.get(random.nextInt(Texts.size()));
    }

    /**
     * get the captcha code
     * @param text
     * @param width
     * @param height
     * @return
     */
    public BufferedImage doCaptcha(String text, int width, int height) {
        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics graphics = bufferedImage.getGraphics();

        graphics.setColor(getRandColor(200, 250));
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.WHITE);
        graphics.drawRect(0, 0, width - 1, height - 1);

        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setFont(new Font("宋体", Font.BOLD, 18));

        Random random = new Random();

        // draw text
        int x = 10;
        for (int i = 0; i < text.length(); i++) {
            // random color
            graphics2d.setColor(new Color(20 + random.nextInt(110), 20 + random
                    .nextInt(110), 20 + random.nextInt(110)));
            int angle = random.nextInt(60) - 30;
            double theta = angle * Math.PI / 180;

            char c = text.charAt(i);

            graphics2d.rotate(theta, x, 20);
            graphics2d.drawString(String.valueOf(c), x, 20);
            graphics2d.rotate(-theta, x, 20);
            x += 30;
        }

        // draw lines
        graphics.setColor(getRandColor(160, 200));
        int x1, x2, y1, y2;
        for (int i = 0; i < 30; i++) {
            x1 = random.nextInt(width);
            x2 = random.nextInt(12);
            y1 = random.nextInt(height);
            y2 = random.nextInt(12);
            graphics.drawLine(x1, y1, x1 + x2, x2 + y2);
        }

        graphics.dispose();

        return bufferedImage;
    }

    /**
     * according to the fc and bc, generate a random color
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

}
