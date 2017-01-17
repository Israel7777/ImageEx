/**
 * Created by ISRAEL on 1/17/2017.
 */
import  java.io.File;
import java.io.IOException;
//create image object to hols the image
import java.awt.image.BufferedImage;
//read and write on image
import javax.imageio.ImageIO;

public class imageEx {
    public static void main(String[] args)throws IOException {
        int width = 504;
        int height = 360;
        BufferedImage bufferedImage = null;
        File file = null;

        try {
            file = new File("C:\\image.jpg");
            bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
            bufferedImage = ImageIO.read(file);
            System.out.println("reading completed");

        }catch (IOException e){
            System.out.println("Error " + e);
        }


        try {
            file = new File("C:\\image2.jpg" );
            ImageIO.write(bufferedImage,"jpg",file);
            System.out.println("writing Complete");

        }catch (IOException e){
            System.out.println("Error : "+ e);
        }
    }

}
