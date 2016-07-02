/**
 * File: ImageFileAdapter.java
 * Author: Aaron Stevens (azs@bu.edu)
 * 
 * Description: 
 * A class which provides methods to enable reading a JPG image from a file
 * on disk, and representing that image as a 2 dimensional array of pixels.
 * Each pixel is stored as an integer, which represents an RGB color code.
 * 
 */

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.util.Iterator;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

public class ImageFileAdapter
{
  public static int[][] getImageFromFile(String filename) throws Exception 
  {
    String filenameExtension = filename.substring(filename.indexOf('.')+1);
    File fileImage = new File(filename);
    Iterator imageReaders = ImageIO.getImageReadersBySuffix(filenameExtension);
    ImageReader imageReader;
    
    if (imageReaders.hasNext()) 
    {
      imageReader = (ImageReader)imageReaders.next();           
    }
    else 
    {
      throw new IIOException("Unsupported image format");
    }
    FileImageInputStream imageInputStream = new FileImageInputStream(fileImage);
    imageReader.setInput(imageInputStream);        
    int width = imageReader.getWidth(0);
    int height = imageReader.getHeight(0);        
    BufferedImage bufImage = imageReader.read(0);
    imageInputStream.close();
    
    int[] pix = new int[width*height];
    int off = 0, scansize = width;
    PixelGrabber pg = new PixelGrabber(bufImage, 0, 0 ,width, height, pix, off, scansize);
    
    pg.grabPixels();
    
    int pixels[][] = new int[height][width];
    
    for (int y = 0; y < height; y++) 
    {
      for (int x = 0; x < width; x++)
      {
        pixels[y][x] = pix[ y * width + x ];
      }
    }
    return pixels;
    
  } // public static int[][] getImageFromFile(String filename) throws Exception
  
  
  public static void writeImageToFile(int image[][], String filename) throws Exception 
  {
    String filenameExtension = filename.substring(filename.indexOf('.')+1);
    File fileImage = new File(filename);
    Iterator imageWriters = ImageIO.getImageWritersBySuffix(filenameExtension);
    ImageWriter imageWriter;
    if (imageWriters.hasNext()) imageWriter = (ImageWriter)imageWriters.next();
    else throw new IIOException("Unsupported image format");
    FileImageOutputStream imageOutputStream = new FileImageOutputStream(fileImage);
    imageWriter.setOutput(imageOutputStream);
    
    
    BufferedImage bufImage = new BufferedImage(image.length, 
                                               image[0].length, 
                                               BufferedImage.TYPE_4BYTE_ABGR);
    
    // create a tmp 1-d array for the image
    int tmp[] = new int[image.length * image[0].length]; 
    for (int row = 0; row < image.length; row++) 
    {
      for (int col = 0; col < image[row].length; col++) 
      {
        tmp[row*image[0].length + col] = image[row][col];
      }
    }
    
    bufImage.setRGB(0,0,image.length, image[0].length, tmp, 0, image[0].length);        
    
    // write the image
    imageWriter.write(bufImage);
    imageOutputStream.close();
    
  } // public static void writeImageToFile(int image[][], String filename) throws Exception
  
  
} // class ImageFileAdapter
