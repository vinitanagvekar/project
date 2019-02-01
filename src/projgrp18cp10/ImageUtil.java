/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projgrp18cp10;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Vinita
 */
public class ImageUtil {
    
    public static void ImageRead(ProjDataBase pdb, String FileName)
    {
        BufferedImage image;
        File f;
        int ImgRow=0;
        int ImgColumn=0;
        int[][] ImgRed={};
        int[][] ImgGreen={};
        int[][] ImgBlue={};

        //Reading a file
        try {
            f=new File(FileName);
            image=ImageIO.read(f);

            ImgRow = image.getWidth();
            ImgColumn = image.getHeight();
            ImgRed = new int[ImgRow][ImgColumn];
            ImgGreen = new int[ImgRow][ImgColumn];
            ImgBlue = new int[ImgRow][ImgColumn];

            for (int i = 0; i < ImgRow; i++)
            {
                for (int j = 0; j < ImgColumn; j++)
                {
                    int p = image.getRGB(i,j); 
                    //int a = (p>>24)&0xff; // Alpha
                    ImgRed[i][j] = (p>>16)&0xff; 
                    ImgGreen[i][j] = (p>>8)&0xff; 
                    ImgBlue[i][j] = p&0xff; 
                }
            }
            
            System.out.println("File : "+FileName);
            System.out.println("Reading completed\n");
        }
        
        catch(IOException e)
        {
            System.out.println("Error:" +e);
        }
        
        pdb.OrigImgRow = ImgRow;
        pdb.OrigImgColumn = ImgColumn;
        
        pdb.OrigImgRed = ImgRed;
        pdb.OrigImgGreen = ImgGreen;
        pdb.OrigImgBlue = ImgBlue;
    }
    
    public static void ImageWrite(int Row, int Column, int[][] Red, int[][] Green, int[][] Blue, String FileType, String FileName)
    {
        BufferedImage image;
        File f;

        //Writinging a file
        try {
            f=new File(FileName);
            image=new BufferedImage(Row, Column, BufferedImage.TYPE_INT_ARGB);

            for (int i = 0; i < Row; i++)
            {
                for (int j = 0; j < Column; j++)
                {
                    int p = (255<<24) | (Red[i][j]<<16) | (Green[i][j]<<8) | (Blue[i][j]);
                    image.setRGB(i, j, p);
                }
            }
            
            ImageIO.write(image, FileType, f);
            System.out.println("File : "+FileName);
            System.out.println("Writing completed\n");
        }
        
        catch(IOException e)
        {
            System.out.println("Error:" +e);
        }
    }
    
    public static void printMatrixRGB(int Row, int Column, int[][] Red, int[][] Green, int[][] Blue)
    {
        //System.out.println(" Red: \t\t\t\t\t\t\t Green: \t\t\t\t\t\t Blue:");
        
        // Print matrix for All Color
        for(int i=0; i < Row; i++)
        {
            for(int j=0; j < Column; j++)
            {
                System.out.print(" "+String.format("%3d", Red[i][j])+",");
            }
            System.out.print("\t");
            for(int j=0; j < Column; j++)
            {
                System.out.print(" "+String.format("%3d", Green[i][j])+",");
            }
            System.out.print("\t");
            for(int j=0; j < Column; j++)
            {
                System.out.print(" "+String.format("%3d", Blue[i][j])+",");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    
    public static void printMatrixGray(int Row, int Column, int[][] Gray)
    {
        //System.out.println(" Gray Scale:");
        
        // Print Gray Scale matrix
        for(int i=0; i < Row; i++)
        {
            for(int j=0; j < Column; j++)
            {
                System.out.print(" "+String.format("%3d", Gray[i][j])+",");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    
}
