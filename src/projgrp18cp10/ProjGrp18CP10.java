/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projgrp18cp10;

/**
 *
 * @author Vinita
 */
public class ProjGrp18CP10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProjDataBase pdb = new ProjDataBase();
        
        ImageUtil.ImageRead(pdb, "C:\\Users\\Lenovo\\Pictures\\IMG-20190106-WA0001.jpg");
        
        System.out.println(" Original Image:");
       // ImageUtil.printMatrixRGB(pdb.OrigImgRow, pdb.OrigImgColumn, pdb.OrigImgRed, pdb.OrigImgGreen, pdb.OrigImgBlue);
        //ImageUtil.ImageWrite(pdb.OrigImgRow, pdb.OrigImgColumn, pdb.OrigImgRed, pdb.OrigImgGreen, pdb.OrigImgBlue, "png", "C:\\Users\\Chinmay\\Pictures\\OutPut\\TestImageOrig.png");
        
        HistogramEqualization.HistEqzCalc(pdb);
        
        System.out.println(" After Histogram Equalization:");
       // ImageUtil.printMatrixRGB(pdb.OrigImgRow, pdb.OrigImgColumn, pdb.HistEqzImgRed, pdb.HistEqzImgGreen, pdb.HistEqzImgBlue);
       // ImageUtil.ImageWrite(pdb.OrigImgRow, pdb.OrigImgColumn, pdb.HistEqzImgRed, pdb.HistEqzImgGreen, pdb.HistEqzImgBlue, "png", "C:\\Users\\Chinmay\\Pictures\\OutPut\\TestImageHistEqz.png");
        
        GrayScale.GrayScaleCalc(pdb);
        
        System.out.println(" After Gray Scale Conversion:");
       // ImageUtil.printMatrixGray(pdb.OrigImgRow, pdb.OrigImgColumn, pdb.GrayScaleImg);
       // ImageUtil.ImageWrite(pdb.OrigImgRow, pdb.OrigImgColumn, pdb.GrayScaleImg, pdb.GrayScaleImg, pdb.GrayScaleImg, "png", "C:\\Users\\Chinmay\\Pictures\\OutPut\\TestImageGray.png");
        
        thresholding.thresholding1(pdb);
        //ImageUtil.ImageWrite(pdb.OrigImgRow, pdb.OrigImgColumn, pdb.GrayScaleImg, pdb.GrayScaleImg, pdb.GrayScaleImg, "png", "C:\\Users\\Lenovo\\Downloads\\output\\.jpg");
        ImageUtil.ImageWrite(pdb.OrigImgRow, pdb.OrigImgColumn, pdb.SegmentedImg1, pdb.SegmentedImg1, pdb.SegmentedImg1, "png", "C:\\Users\\Lenovo\\Downloads\\output\\SegmentedImg9.jpg");
        ImageUtil.ImageWrite(pdb.OrigImgRow, pdb.OrigImgColumn, pdb.SegmentedImg2, pdb.SegmentedImg2, pdb.SegmentedImg2, "png", "C:\\Users\\Lenovo\\Downloads\\output\\SegmentedImg10.jpg");
    }
    
}
