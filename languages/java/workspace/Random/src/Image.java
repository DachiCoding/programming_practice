/**
 * File: Image.java
 * Author: Aaron Stevens (azs@bu.edu), YOUR NAME HERE
 * 
 * Description: 
 * 
 * 
 * 
 */
//TO DO: CREATE A FILE CALLED ImageViewer.java in your project.
//and COPY AND PASTE THE CODE BELOW INTO THAT FILE:


public class Image
{
    // the "FILTER" constant values are used for some bit-manipulation arithmetic
    // -- basically, so that we can isolate the bits used for a given color
    // and the manipulate just those bits (e.g. increase, decrease, print out).
    public static final int RED_FILTER      = 0x00ff0000;
    public static final int GREEN_FILTER    = 0x0000ff00;
    public static final int BLUE_FILTER     = 0x000000ff;

 

//////////////////////////////////////////////////////////////////////////////
    public int getWidth(int[][] pixels) throws Exception
    {
    pixels = ImageFileAdapter.getImageFromFile("~/desktop/1.jpg");
    int width = pixels.length;
    return width;
    }
//////////////////////////////////////////////////////////////////////////////

 
    /** 
     * Check if the pixel provided is "mostly" white 
     * @param pixel -- the pixel to check for white
     * @return true if white, false if non-white.
     */
    private static boolean isBackground(int pixel)
    {
        int rdiff = 256 - ((RED_FILTER & pixel) >> 16);
        int gdiff = 256 - ((GREEN_FILTER & pixel) >> 8);
        int bdiff = 256 - (BLUE_FILTER & pixel);                               
        
        if (rdiff < 16 && gdiff < 16 && bdiff < 16)
        {
            return true;                        
        }
        return false;
    }

} // class Image


