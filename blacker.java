/**
 * Created by ISRAEL on 1/17/2017.
 *
    => the logic
 1- find the pixel
 2- find the avarage of rgb
 3- replace rgb with average
 */

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class blacker {
    public static void main(String[] args) {
        BufferedImage bufferedImage = null;
        File file = null;
        int whiteCount=0;
        int BlackCount=0;

        //read the image first
        try {
            file = new File("C:\\Users\\ISRAEL\\Desktop\\rgb.png");
            bufferedImage = ImageIO.read(file);

        }catch (IOException e){
            System.out.println("Error :" + e);
        }

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        //convert to gray scale
        for (int y = 0 ; y < height ;y++){
            for (int x = 0 ;x < width ; x++){

                int p = bufferedImage.getRGB(x,y);

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;


              /*
                if(r==255 & g==255 & b==255){

                    whiteCount++;
                    //p =255;
                }else{
                    BlackCount++;
                    p =0&0xff;
                }

             */
                //calculate the average

                int average = ( r+g+b) /3;

                p = (a<<24 ) | (average<<16) | (average<<8) | average;

                bufferedImage.setRGB(x,y,p);

            }
        }

        //write image
        try {
            file = new File("C:\\Users\\ISRAEL\\Desktop\\bw.png");
            ImageIO.write(bufferedImage,"png",file);

            System.out.println("Finished writing and Found "+whiteCount+" whites and "+ BlackCount + " Blacks");
        }catch (IOException e){
            System.out.println("Error "+ e);
        }
    }
}
