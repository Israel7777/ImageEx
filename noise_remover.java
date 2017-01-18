import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * Created by ISRAEL on 1/17/2017.
 */
public class noise_remover {
    public static void main(String[] args) {
        BufferedImage  bufferedImage = null;
        File file = null;

        String FilePath = "C:\\Users\\ISRAEL\\Desktop\\image.png";
        String newFilePath ="C:\\Users\\ISRAEL\\Desktop\\bw.png";

        //test
        bufferedImage = getImageFromFile(FilePath);
        bufferedImage = makeBlack(bufferedImage);
        bufferedImage = removeBgNoise(bufferedImage);
        SaveImage(newFilePath,bufferedImage);


    }

    private static BufferedImage getImageFromFile(String path){
        BufferedImage  bufferedImage = null;
        File file = null;

        try {
            file = new File(path);
            bufferedImage = ImageIO.read(file);
            System.out.println("get the image successfully ");
        }catch (IOException e){
            System.out.println("Error :" + e);
        }

        return bufferedImage;
    }

    private static void SaveImage(String path,BufferedImage bufferedImage){
        File file = null;

        try {
            file = new File(path);
            ImageIO.write(bufferedImage,"png",file);

            System.out.println("Finished writing");
        }catch (IOException e){
            System.out.println("Error "+ e);
        }
    }

    private static BufferedImage makeBlack(BufferedImage bufferedImage){
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        for (int y = 0 ; y < height ;y++){
            for (int x = 0 ;x < width ; x++){
                int p = bufferedImage.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                int average = ( r+g+b) /3;
                p = (a<<24 ) | (average<<16) | (average<<8) | average;
                bufferedImage.setRGB(x,y,p);
            }
        }
        System.out.println("Made the Image Black");
        return  bufferedImage;
    }

    private static BufferedImage removeBgNoise(BufferedImage bufferedImage){
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        for (int y = 0 ; y < height ;y++){
            for (int x = 0 ;x < width ; x++){
                int p = bufferedImage.getRGB(x,y);

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                if(r==255 & g==255 & b==255 & a==255){
                    p = (a<<24 ) | (r<<16) | (g<<8) | b;
                    bufferedImage.setRGB(x,y,p);
                }else if(r==0 & g==0 & b==0 & a==255){
                    p = (a<<24 ) | (r<<16) | (g<<8) | b;
                    bufferedImage.setRGB(x,y,p);
                }else{
                    a=255;r=255;g=255;b=255;

                    p = (a<<24 ) | (r<<16) | (g<<8) | b;
                    bufferedImage.setRGB(x,y,p);
                }

            }
        }
        System.out.println("Removed Bg Noise" );
        return bufferedImage;
    }



}
