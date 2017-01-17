/**
 * Created by ISRAEL on 1/17/2017.
 */
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RnadonPixeler {
    public static void main(String[] args) {
        int width = 640;
        int height = 320;

        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);

        File file = null;

        for (int y = 0; y<height ;y++){
            for(int x =0 ; x<width ;x++){
                int a = (int) (Math.random()*256);
                int r = (int) (Math.random()*256);
                int g = (int) (Math.random()*256);
                int b = (int) (Math.random()*256);

                int p = (a<<24) | (r<<16) | (g<<8) | b;

                bufferedImage.setRGB(x,y,p);


            }
        }

        try {
            file = new File("C:\\Users\\ISRAEL\\Desktop\\image3.jpg");
            ImageIO.write(bufferedImage,"png",file);
            System.out.println("Finished Writing");
        }catch (IOException e){
            System.out.println("Error");
        }
    }
}
