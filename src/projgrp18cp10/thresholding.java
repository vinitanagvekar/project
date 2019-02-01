/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projgrp18cp10;
import java.util.Random;
import static java.lang.Math.round;
/**
 *
 * @author Vinita
 */
public class thresholding {


       
public static void thresholding1(ProjDataBase pdb)
{
     double sum1,sum2,count1,count2, mean1,mean2;
     int i,j;
double avg1,avg2;
      
       
      int[][] GrayScaleImg = pdb.GrayScaleImg;
        
      double T;
      
        T = new Random().nextInt(GrayScaleImg.length);
        while(T<100 || T>255)
        {
             T = new Random().nextInt(GrayScaleImg.length);
        }
      
        System.out.println(T);
         System.out.println();
       // double T=0;
         double T1;
          T1=T;
          
          int[][] SegmentedImg1 = new int[pdb.OrigImgRow][pdb.OrigImgColumn];
          int[][] SegmentedImg2 = new int[pdb.OrigImgRow][pdb.OrigImgColumn];
        sum1=sum2=count1=count2=0;
          while(T>1)
        {
           T=T1;
        for(i=0;i<pdb.OrigImgRow;i++)
        {
            for(j=0;j<pdb.OrigImgColumn;j++)
            {
                if(T<GrayScaleImg[i][j])
                {
                    sum1=sum1+GrayScaleImg[i][j];
                    SegmentedImg1[i][j] = (int) round(GrayScaleImg[i][j]);
                 pdb.SegmentedImg1 = SegmentedImg1;
                    count1++;
                }
                else
                {
                    sum2=sum2+GrayScaleImg[i][j];
                    SegmentedImg2[i][j] = (int) round(GrayScaleImg[i][j]);
             pdb.SegmentedImg2 = SegmentedImg2;
                    count2++;
                }
                  
            } 
           
            
           
        }
        
    
        avg1=sum1/count1;
        
            System.out.printf("%.2f", avg1);
        
      
        
        avg2=sum2/count2;
       
        System.out.println("\n");
        System.out.printf("%.2f", avg2);
         T1=Math.round((avg1+avg2)/2);
         System.out.println("\n");
          System.out.println(T1);
         
        T=T-T1;
        System.out.println("\nT = "+T+"\n");
    
        }
          System.out.println("STOP");
         
              

        }
        
}


