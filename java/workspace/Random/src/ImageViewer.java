/**
 * File: ImageViewer.java
 * Author: Aaron Stevens (azs@bu.edu)
 * 
 * Description: 
 * A class which provides provides a client to use the Image and 
 * ImageFileAdapter classes. 
 */

//TO DO: CREATE A FILE CALLED ImageViewer.java in your project.
//and COPY AND PASTE THE CODE BELOW INTO THAT FILE:

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageViewer extends javax.swing.JFrame
{
    private static final long serialVersionUID = 1L;
    
    public ImageViewer()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1024,768);
        setTitle("Image Viewer");        
    }
    
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ImageViewer().setVisible(true);
            }
        });              
    }

    /**
     *  Drars the 2-dimensional array given in pixels on the Graphics object g.
     * @param g
     * @param pixels
     */
    private void drawPixelArray(Graphics g, int pixels[][])
    {
        final int TITLE_BAR_HEIGHT = 30;
        setSize(pixels[0].length, pixels.length + TITLE_BAR_HEIGHT);        
        BufferedImage bufImage =  new BufferedImage(pixels[0].length, // width
                   pixels.length,    // height                                   
                                                    BufferedImage.TYPE_4BYTE_ABGR);
        
        for (int y = 0; y < pixels.length; y++) 
        {
            for (int x = 0; x < pixels[y].length; x++) 
            {
             bufImage.setRGB(x, y, pixels[y][x]);
            }
        }

        g.drawImage(bufImage, 1, TITLE_BAR_HEIGHT + 1, null);                
    }
    
    public void paint(Graphics g) 
    {                
        try
        {
          // WE WILL DO ALL OF OUR WORK HERE    
          // NOTE: change the filenames to be valid file names on your computer.
          // Once you get the images to open, try drawing each one.
          // Test each other method below ONE AT A TIME.
          
//      Image back = new Image(ImageFileAdapter.getImageFromFile("c:\\bc_stadium.jpg"));
//      Image front = new Image(ImageFileAdapter.getImageFromFile("c:\\azs_party.jpg"));
//
//      // draw the image
//      drawPixelArray(g, back.getPixelArray());                            
//      drawPixelArray(g, front.getPixelArray());                            
//         
//      // test the overlay
//      back.overlayImage(front);
//      drawPixelArray(g, back.getPixelArray());                            
//
//      // test flip horizontal:
//      back.flipX();
//      drawPixelArray(g, back.getPixelArray());                            
//         
//      // test flip vertical:
//      back.flipY();
//      drawPixelArray(g, back.getPixelArray());                            
//         
//      System.exit(0);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    } // public void paint(Graphics g)      
    
} // end class Drawing
