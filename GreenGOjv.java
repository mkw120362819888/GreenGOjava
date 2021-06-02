import javax.swing.*;  //引用套件
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.plaf.metal.MetalLookAndFeel;
//import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.UIManager.*;
import javax.swing.JFrame;
import javax.swing.border.*;
import javax.swing.event.*;
import java.io.*; 
import java.io.FileWriter;
import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.*; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.*;
import java.net.*;
import java.net.Socket;
import java.util.*;  
import java.util.Timer;  
import java.util.Date;  
import java.util.Random;
import java.util.Vector;
import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.tree.*; //包含協助JTree類別建立樹狀結構之類別的套件
import javax.swing.table.*;

//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
//==============================================================================================
public class GreenGOjv extends JFrame 
{
	//==============================================================================================
	private static int[] POSX={0,30,81,132,183,234,285,336,387,438,489,540,591,642,693,744,795,846,897,948,0};
	private static int[] POSY={0,30,81,132,183,234,285,336,387,438,489,540,591,642,693,744,795,846,897,948,0};
	//==============================================================================================
    public int SPXO=30;
    public int SPYO=30;
    public static int GOW=51,GOH=51;
    //-------------------------------------------------------------------------------------------------
    public static int[] SPNO =
    { 
    //0	1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19 20 
    3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,3,//0
    3, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,3,//1
    3, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61,3,//2
    3, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82,3,//3
    3, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99,100,101,102,103,3,//4
    3,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,3,//5
    3,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,3,//6
    3,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,3,//7
    3,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,3,//8
    3,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,3,//9
    3,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,3,//10
    3,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,3,//11
    3,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,3,//12
    3,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,3,//13
    3,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,3,//14
    3,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,3,//15
    3,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,3,//16
    3,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,3,//17
    3,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,3,//18
    3,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,3,//19
    3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,3 //0
    };
    //-------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------
			public static int[][] SPTYPE =
			{
			//01  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20	
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //0
			{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 0}, //1
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //2
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //3
			{0, 8, 9, 9,10, 9, 9, 9, 9, 9,10, 9, 9, 9, 9, 9,10, 9, 9, 4, 0}, //4
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //5
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //6
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //7
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //8
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //9
			{0, 8, 9, 9,10, 9, 9, 9, 9, 9,10, 9, 9, 9, 9, 9,10, 9, 9, 4, 0}, //10
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //11
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //12
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //13
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //14
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //15
			{0, 8, 9, 9,10, 9, 9, 9, 9, 9,10, 9, 9, 9, 9, 9,10, 9, 9, 4, 0}, //16
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //17
			{0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 0}, //18
			{0, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 0}, //19 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} //0
			};
			//-------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------
	public static int[][] MFBI =
	{// 1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9 ,10,11,12,13,14,15,16,17,18,19,0 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //0
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
	{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //3
	{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, //4
	{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //5
	{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //6
	{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //7
	{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //8
	{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //9
	{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, //10
	{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //11
	{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, //12
	{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, //13
	{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //14
	{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, //15
	{0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, //16
	{0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, //16
	{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, //16
	{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, //17
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //19 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} //0
	};
//-------------------------------------------------------------------------------------------------
	public int[][] BDBW =	//棋盤格點螢幕座標 格點型式
	{ 
   //0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,0
	{3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,3},//0
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//1
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//2
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//3
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//4
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//5
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//6
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//7
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//8
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//9
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//10
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//11
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//12
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//13
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//14
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//15
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//16
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//17
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//18
	{3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,3},//19
	{3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,3} //0
	};
	//-------------------------------------------------------------------------------------------------
	public int[][] BDGN =
	{ 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //0
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //2
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //3
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //5
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //6
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //7
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //8
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //9
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //10
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //11
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //12
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //13
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //14
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //15
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //16
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //17
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //18
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //19 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} //0
	};
	//-------------------------------------------------------------------------------------------------
	public int[][] BDSN =	//棋盤串子資料
	{ 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //0
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //2
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //3
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //5
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //6
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //7
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //8
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //9
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //10
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //11
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //12
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //13
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //14
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //15
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //16
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //17
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //18
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //19 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} //0
	};
	//-------------------------------------------------------------------------------------------------
	public int[][] BDCD =	//棋盤資料運算陣列
	{ 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //0
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //2
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //3
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //5
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //6
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //7
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //8
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //9
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //10
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //11
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //12
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //13
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //14
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //15
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //16
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //17
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //18
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //19 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} //0
	};
	//-------------------------------------------------------------------------------------------------
	public int[][] BDSLC =	//棋盤串子資料
	{ 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //0
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //2
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //3
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //5
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //6
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //7
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //8
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //9
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //10
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //11
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //12
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //13
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //14
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //15
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //16
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //17
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //18
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //19 
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} //0
	};
	//==============================================================================================
	public Boolean FMnewonoff=false;
	//==============================================================================================
	private int[] GOBW=new int[363];//private
	private int[] GOX=new int[363];
	private int[] GOY=new int[363];
	private int[] GOOUT=new int[363];
	private int[] SRBW=new int[363];//串子顏色
	private int[][] SRDT=new int[10][363];//串子資料
	private int[] SRNUM=new int[363];//串子數量
	//-----------------------------------------------
	public int WhiteStringNo = 2; //白子串子序號
	public int BlackStringNo = 1; //黑子串子序號
	public int STRINGNO = 1; //目前串子序號
	public int StringNumonoff=0;
	public int LifeNumonoff=0;
	public int GoLife_onoff=0;
	public int LifeDataOnOff=0;
	public int StringDataOnOff=0;
	public int PotentialTableOnOff=0;
	public int GoDataOnOff=0;
	public int XXX=1,YYY=1,KKK=0;
	public int XXX1=1,YYY1=1;
	private int GODNO=1;  //下子順序
	public int GPN=0; //棋點代號
	public int GBW=1; //棋種代號
	public int PLAYTYPE=-1;//0=人_人,1=人_電腦,2=電腦_電腦,3=電腦連線電腦
	public int BDtype=1;
	public int NUMONOFF=1;
	public int XYONOFF=0;
	public int GOYESNO=1;  //是否允許落子  0=不允許  1=允許
	public int displayed0=-1;
	public String btcmd = "";
	public int GODOWNj,GODOWNi;
	public int IsGoDown=0;
	public int GoDowned=0;
	public int GoSelected=0;
	//-----------------------------------------------
	public static int TEXTROWX; //文字顯示區 X起始座標
	public static int TEXTROWW;
	public int FrameW,FrameH;
	private String[] textTX={"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S",""};
	private String[] textTY={"","19","18","17","16","15","14","13","12","11","10","9","8","7","6","5","4","3","2","1",""};
	private String[] textXY={"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s",""};
	private String[] textBW={"","B","W",""};
    private String[] StringDim ={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",
            "","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",
            "","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    private String[] MSGStringDim ={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",
            "","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",
            "","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    JLabel MSGBOX;
    JLabel TEXTBOX;
	public String newText = "";
    public String MSGnewText = "";
	//----------------------------------------------- occupied 佔領  capture 捕獲
	public String BNAME="Computer";//"黑子";
	public String BPOWER="00.00";//"  段  級";
	public String BPOS="000.000.000.000";
	public int BWIN=0;//public String BWIN="提子數: 000";
	public int BWINTOTAL=0;//public String BWINTOTAL="佔地數: 000";
	public String WNAME="Player";//"白子";
	public String WPOWER="00.00";//"  段  級";
	public String WPOS="000.000.000.000";
	public int WWIN=0;//public String WWIN="提子數: 000";
	public int WWINTOTAL=0;//public String WWINTOTAL="佔地數: 000";
	public String BasicName="GreenGO v1.0";
	public String GOMSGDATA="";//GPDbmp
	public int TEXTLINENUM=0;//public String WWIN="提子數: 000";
	public String GPDtxtName="";
	public int BSS,BMM,WSS,WMM;
	public int GoDisplay=0;
	public int BTime1=0;
	public int BTime2=0;
	public int BTime3=0;
	public int WTime1=0;
	public int WTime2=0;
	public int WTime3=0;
	public String StartTime="";
	public String GoStartTime="";
	public int GOPLAYFILENO=0;
	//==============================================================================================
	private static int Bplayer = 1;
	private static int Wplayer = 0;
	private int BWplayer=1;
	private int GODNOcheck=0;
	private int GODOWNcheck = 0;
	private int MDXcheck=0;
	private int MDYcheck=0;
	public String GOTEXT="";
	public int GODX,GODY,GOTYPE;
	public String newTextTemp = "";
	public String JFtitle = "";
	//==============================================================================================
	private int MDX,MDY;
	private int NEWX,NEWY;
	private int TimeCount = 0;
	//==============================================================================================
	public static String JFrameString = "GreenGO v1.0";
    public JButton open,save,gonumber,cordxy,option,help,exit,netconnection,orderdown,peoplecomputer;
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
			private JLabel GBlabel;
		    public int GX; 
		    public int GY;
			private Image GBI;
			private Image GWI;
			private Image GBRI;
			private Image GWRI;
			private ImageIcon GBIcon;
			private ImageIcon GWIcon;
			private ImageIcon GBRIcon;
			private ImageIcon GWRIcon;
			private ImageIcon GBimg;
			private ImageIcon GOBOARDimage;
			private BufferedImage GOBOARD = new BufferedImage(1030,1030,BufferedImage.TYPE_INT_RGB);
			private BufferedImage JLimage = new BufferedImage(1030,1030,BufferedImage.TYPE_INT_RGB);
			public ImageIcon pBOARD;
			public ImageIcon pDATA;
			//==============================================================================================
		    JLabel[] TEXTDATA = new JLabel[65];
		    private int TXTnum=65;
		    JLabel[] GODOWNDATA = new JLabel[50];
		    private int GDDnum=50;
		    private int GDNDATA = 0;
			JLabel srRead = new JLabel();
			JLabel srWrite = new JLabel();
			JLabel srIn = new JLabel();
			JLabel srOut = new JLabel();
			JLabel BTIME = new JLabel();
			JLabel WTIME = new JLabel();
		    JLabel SBTIME = new JLabel();
		    JLabel SWTIME = new JLabel();
			JLabel BGO = new JLabel();
			JLabel WGO = new JLabel();
			JLabel BlackDATA = new JLabel();
			JLabel WhiteDATA = new JLabel();
			JLabel Bcapture = new JLabel();
			JLabel Boccupied = new JLabel();
			JLabel Wcapture = new JLabel();
			JLabel Woccupied = new JLabel();
			public Date SnowDate = new Date();;
			public String STstring = "";
			JDialog jdialog = new JDialog((Frame) null,  "", true);
			JTextField jtfIP;
			JTextField jtfPort;
			JDialog OPENGOjdialog = new JDialog((Frame) null,  "", true);
			JTextField OPENGOjtfIP;
			JTextField OPENGOjtfPort;
//==============================================================================================
			int NetConnectCheck = 0;
			int OPENGOcheck = 10;
		    public String ConnectIP="";
		    public String ConnectPort="";
		    public String OPENGOConnectIP="";
		    public String OPENGOConnectPort="";
		    public String BlackIP = "";
		    public String WhiteIP = "";
		    private	String strContent="";
		    private	String strContentOld="";
		    private	String strWrite="";
		    private	String strWriteOld="";
		    private	String strRead="";
		    private	String strReadOld="";
		    private int isDataProcess=0;
		    private int isAutoDownOrder=0;
		    private int DataProcessOK=0;
		    public Socket ClientSocket;
		    public DataOutputStream  outstream;
		    public DataInputStream  instream;
		    String FromServer;
		    String ToServer;
		    BufferedReader inFromUser;
		    PrintWriter outToServer;
		    BufferedReader inFromServer;
//==============================================================================================
	private final static String DEFAULT_FILE_PATH = "D:\\";
		JLabel lbResult = new JLabel("選取檔案 : ");
		class JavaFilter 
			extends javax.swing.filechooser.FileFilter {
			String extension, description;
			JavaFilter(String ext, String des){
				extension = ext.toLowerCase();
				description = des;
			}
			public boolean accept(File f){
				if (f.isDirectory())
					return true;
				String ext = null;
				String s = f.getName();
				int i = s.lastIndexOf('.');
				if (i > 0 &&  i < s.length() - 1){
					ext = s.substring(i+1).toLowerCase();
					if(extension.equals(ext))
						return true;
				}
				return false;
			}
			public String getDescription(){ return description; }
		}
//==============================================================================================
// 建構函式
//==============================================================================================
public class SystemTimerTask extends TimerTask
{
		      	public void run()
		      	{
		      	    Date nDate = new Date();  
		      	    String TS = String.format("%tH",nDate)+":"+String.format("%tM",nDate)
		      	      	+":"+String.format("%tS",nDate);  
		      	  	SBTIME.setText(TS);
		      	  	SWTIME.setText(TS);
		      	}
}
//==============================================================================================
public class GONetConnectDownTimerTask extends TimerTask
{
	public void run()
	{
		          		GONetConnectDownTimerTick();
	}
}
//==============================================================================================
public class GOORDERDOWNTimerTask extends TimerTask
{
		        	public void run()
		        	{
		        		GOORDERDOWNtimerTick();
		        	}
}
//==============================================================================================
public class pBOARD extends javax.swing.JPanel
{
	   public pBOARD () 
	   {super();} 
	   public void paintComponent(Graphics g) 
	   {
		    super.paintComponent(g);
		    g.drawImage(pBOARD.getImage(), 0, 0, null); 
		    repaint(); 
		}		   
}
//--------------------------------------------------------------------------------
public class pDATA extends javax.swing.JPanel
{
	   public pDATA () 
	   {super();} 
	   public void paintComponent(Graphics g) 
	   {
		    super.paintComponent(g);
		    g.drawImage(pDATA.getImage(), 0, 0, null); 
		    repaint(); 
		}		   
}
//--------------------------------------------------------------------------------
		class SystemTimeThread implements Runnable
		{
		    String name;
		    Thread stt;
		    SystemTimeThread(String name)
		    {
		            this.name = name;
		            stt = new Thread(this, name);
		            stt.start();
		    }
		    public void run()
		    {
		      	Timer SystemTimer = new Timer();
		    	////設定計時器
		    	////第一個參數為"欲執行的工作",會呼叫對應的run() method
		    	////第二個參數為程式啟動後,"延遲"指定的毫秒數後"第一次"執行該工作
		    	////第三個參數為每間隔多少毫秒執行該工作
		      	SystemTimer.schedule(new SystemTimerTask(),1000,1000);
		    	TEXTDIS("AutoDownTimer Start !");
		    }
		}
		//--------------------------------------------------------------------------------
		class NetConnectDownThread implements Runnable
		{
		  String ncdtname;
		  Thread ncdt;
		  NetConnectDownThread(String name)
		  {
		          this.ncdtname = name;
		          ncdt = new Thread(this, name);
		          ncdt.start();
		  }
		  public void run()
		  {
		     	Timer GONetConnectDownTimer = new Timer();
		     	GONetConnectDownTimer.schedule(new GONetConnectDownTimerTask(),1000,1000);
		    	TEXTDIS("GONetConnectDownTimer Start !");
		  }
		}
//--------------------------------------------------------------------------------
		class OrderDownThread implements Runnable
		{
		    String name;
		    Thread odt;
		    OrderDownThread(String name)
		    {
		            this.name = name;
		            odt = new Thread(this, name);
		            odt.start();
		    }
		    public void run()
		    {
		       	Timer GOORDERDOWNTimer = new Timer();
		      	GOORDERDOWNTimer.schedule(new GOORDERDOWNTimerTask(),1000,1000);
		      	TEXTDIS("OrderDownTimer Start !");
		    }
		}
		//==============================================================================================
			void TBThelpMouseListener()
			{
		        TEXTDIS("Undefined !");
			}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void ThisTextChange()
{
	this.setTitle(BasicName +"  -  "
		+GoStartTime+"  No."+Integer.toString(GOPLAYFILENO)+"  "
		+"[ BLACK _ "+BNAME+" _ "+BPOWER+" ]  "
		+ "[ WHITE _ "+WNAME+" _ "+WPOWER+" ]");
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
String getTimeByCalendar()
{ 
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	String sdate= dateFormat.format(date);
	return sdate;
} 
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void GODATA()
{
	WTime1=0;WTime2=0;WTime3=0;BTime1=0;BTime2=0;BTime3=0;
	BGO.setText("0");WGO.setText("0");
	BWIN=0;BWINTOTAL=0;WWIN=0;WWINTOTAL=0;
	TimeCount=0;

	Date AutoSnowDate = new Date();  
    String AutoSTstring = String.format("%tH",AutoSnowDate)+":"+String.format("%tM",AutoSnowDate)
	+":"+String.format("%tS",AutoSnowDate);  
	StartTime = AutoSTstring;
	BTIME.setText(AutoSTstring);WTIME.setText(AutoSTstring);

	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	String sdate = dateFormat.format(date);
	GPDtxtName  = "JV" + dateFormat.format(date);
	
	Bcapture.setText("");Wcapture.setText("");
	Boccupied.setText("");Woccupied.setText("");
	Bcapture.setText(String.format("%03d",BWIN));Boccupied.setText(String.format("%03d",BWINTOTAL));
	Wcapture.setText(String.format("%03d",WWIN));Woccupied.setText(String.format("%03d",WWINTOTAL));
				if(GODNO%2 > 0)
				{
//					BTIMELB.Text=
//						DateTime.Now.ToString("HH:mm:ss.ffffff")+" >> "+GODNO.ToString()
//						+" [ "+textTX[MDX]+" "+MDY.ToString()+" ]";
//					//BDOWNTIMELB.Text = DateTime.Now.ToString("HH : mm : ss");
				} //黑子 BDOWNTIMELB
				if(GODNO%2 == 0)
				{
//					WTIMELB.Text=
//						DateTime.Now.ToString("HH:mm:ss.ffffff")+" >> "+GODNO.ToString()
//						+" [ "+textTX[MDX]+" "+MDY.ToString()+" ]";
					//WDOWNTIMELB.Text = DateTime.Now.ToString("HH : mm : ss");
				} //白子
	this.setTitle(BasicName +"  -  "
			+ GPDtxtName + "  No." + Integer.toString(GOPLAYFILENO)+"  "
			+"[ BLACK _ "+BNAME+" _ "+BPOWER+" ]  "
			+ "[ WHITE _ "+WNAME+" _ "+WPOWER+" ]");
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void TBTexitMouseListener()
{
     System.out.println("TBTexit clicked the button, using a MouseListenr");
     System.exit(0);
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void MSGDIS(String TBD)
{
    int y;
    for (y = 40; y > 0; y--)
    {
        MSGStringDim[y] = MSGStringDim[y - 1];
    }
    MSGStringDim[0] = TBD;
    MSGBOX.setText("");
    MSGnewText = "";

    for (y = 0; y <= 40; y++)
    {
        MSGnewText = MSGnewText + "\n" + MSGStringDim[y];
    }
    MSGBOX.setText(MSGnewText);
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GODOWNDATADIS(String GDDstring) 
{
			int y=0;
			for(y=GDDnum-1;y>0;y--)
			{
				GODOWNDATA[y].setText(GODOWNDATA[y-1].getText());
			}
			GODOWNDATA[0].setText(GDDstring);
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void TEXTDIS(String TXTstring) 
{
			int y=0;
			for(y=TXTnum-1;y>0;y--)
			{
				TEXTDATA[y].setText(TEXTDATA[y-1].getText());
			}
			TEXTDATA[0].setText(TXTstring);
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void TEXTDIS0(String TBD)
{
  int y;
  for (y = 52; y > 0; y--)
  {
      StringDim[y] = StringDim[y - 1];
  }
  StringDim[0] = TBD;
  TEXTBOX.setText(TBD);
  newText = "";
  for (y = 0; y <= 52; y++)
  {
      newText = newText + "\n";
      newText = newText + StringDim[y];
  }
  TEXTBOX.setText(newText);
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GODIS(int dx,int dy,int DISNO)
{
			int a=0;
			int stringL = 0;   
			int stringH = 0;   
			//-------------------------------------------
			Graphics2D g2d = (Graphics2D) JLimage.getGraphics();
			
			switch(DISNO)
			{
		case 0 : 
			  g2d.drawImage((Image)GOBOARDimage.getImage(),dx,dy,null);
		break;
		case 1 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx + GOW / 2 - 2, dy + GOH / 2 - 2, dx + GOW - 1, dy + GOH / 2 - 2);//CR
              g2d.drawLine(dx + GOW / 2 - 2, dy + GOH / 2 - 2, dx + GOW / 2 - 2, dy + GOH - 1);//CB
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx + GOW - 1, dy + GOH / 2 - 1);//CR
              g2d.drawLine(dy + GOW / 2 - 1, dy + GOH / 2 - 1, dx + GOW / 2 - 1, dy + GOH - 1);//CB
			
				break;
		case 8 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx, dy + GOH / 2 - 2, dx + GOW - 1, dy + GOH / 2 - 2);//LR1
              g2d.drawLine(dx, dy + GOH / 2 - 1, dx + GOW - 1, dy + GOH / 2 - 1);//LR2
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx + GOW / 2 - 1, dy + GOH - 1);//CB
				break;
		case 7 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx + GOW / 2 - 1 + 1, dy + GOH / 2 - 1 - 1, dx, dy + GOH / 2 - 1 - 1);//CL2
              g2d.drawLine(dx + GOW / 2 - 1 + 1, dy + GOH / 2 - 1 - 1, dx + GOW / 2 - 1 + 1, dy + GOH - 1);//CB2
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx, dy + GOH / 2 - 1);//CL1
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx + GOW / 2 - 1, dy + GOH - 1);//CB1
				break;
		case 6 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx + GOW / 2 - 1, dy, dx + GOW / 2 - 1, dy + GOH - 1);//TB1
              g2d.drawLine(dx + GOW / 2 - 1 + 1, dy, dx + GOW / 2 - 1 + 1, dy + GOH - 1);//TB2
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx, dy + GOH / 2 - 1);//CL
				break;
		case 5 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx + GOW / 2 - 1 + 1, dy + GOH / 2 - 1 + 1, dx + GOW / 2 - 1 + 1, dy);//CT2
              g2d.drawLine(dx + GOW / 2 - 1 + 1, dy + GOH / 2 - 1 + 1, dx, dy + GOH / 2 - 1 + 1);//CL2
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx + GOW / 2 - 1, dy);//CT1
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx, dy + GOH / 2 - 1);//CL1
				break;
		case 4 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx, dy + GOH / 2 - 1, dx + GOW - 1, dy + GOH / 2 - 1);//LR1
              g2d.drawLine(dx, dy + GOH / 2 - 1 + 1, dx + GOW - 1, dy + GOH / 2 - 1 + 1);//LR2
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx + GOW / 2 - 1, dy);//CT
				break;
		case 3 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx + GOW / 2 - 1 - 1, dy + GOH / 2 - 1 + 1, dx + GOW / 2 - 1 - 1, dy);//CT2
              g2d.drawLine(dx + GOW / 2 - 1 - 1, dy + GOH / 2 - 1 + 1, dx + GOW - 1, dy + GOH / 2 - 1 + 1);//CR2
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx + GOW / 2 - 1, dy);//CT1
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx + GOW - 1, dy + GOH / 2 - 1);//CR1
				break;
		case 2 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx + GOW / 2 - 1, dy, dx + GOW / 2 - 1, dy + GOH - 1);//TB1
              g2d.drawLine(dx + GOW / 2 - 1 - 1, dy, dx + GOW / 2 - 1 - 1, dy + GOH - 1);//TB2
              g2d.drawLine(dx + GOW / 2 - 1, dy + GOH / 2 - 1, dx + GOW - 1, dy + GOH / 2 - 1);//CR
				break;
		case 9 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx, dy + GOH / 2 - 1, dx + GOW - 1, dy + GOH / 2 - 1);//LR
              g2d.drawLine(dx + GOW / 2 - 1, dy, dx + GOW / 2 - 1, dy + GOH - 1);//TB
				break;
		case 10 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.setColor(new Color(0,128,0));
              g2d.drawLine(dx, dy + GOH / 2 - 1, dx + GOW - 1, dy + GOH / 2 - 1);//LR
              g2d.drawLine(dx + GOW / 2 - 1, dy, dx + GOW / 2 - 1, dy + GOH - 1);//TB
			  g2d.fillRect(dx + 20, dy + 20, 9, 9);
				break;
		case 11 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.drawImage(GBI,dx,dy,null);
		break;
		case 12 : 
			  g2d.setColor(new Color(0,96,0));
			  g2d.fillRect(dx, dy, GOW, GOH);
			  g2d.drawImage(GWI,dx,dy,null);
		break;
		case 21 : 
			  g2d.drawImage(GBI,dx,dy,null);
			  g2d.setColor(Color.RED);
			  g2d.fillRect(dx+20, dy+20, 10, 10);
		break;
		case 22 : 
			  g2d.drawImage(GWI,dx,dy,null);
			  g2d.setColor(Color.RED);
			  g2d.fillRect(dx+20, dy+20, 10, 10);
			break;
		case 100 :
			g2d.setColor(Color.RED);
			g2d.setFont(new Font("Arial", Font.PLAIN, 20));
		    stringL = (int)g2d.getFontMetrics().getStringBounds(GOTEXT,g2d).getWidth();   
		    stringH = (int)g2d.getFontMetrics().getStringBounds(GOTEXT,g2d).getHeight();   
			g2d.drawString(GOTEXT,dx+GOW/2-stringL/2,dy+GOH/2+stringH/3);	
		break;
		case 101 :
			g2d.setColor(Color.WHITE);
		    stringL = (int)g2d.getFontMetrics().getStringBounds(GOTEXT,g2d).getWidth();   
		    stringH = (int)g2d.getFontMetrics().getStringBounds(GOTEXT,g2d).getHeight();   
			g2d.drawString(GOTEXT,dx+GOW/2-stringL/2,dy+GOH/2+stringH/3);	
		break;
		case 102 : 
			g2d.setColor(Color.BLACK);
		    stringL = (int)g2d.getFontMetrics().getStringBounds(GOTEXT,g2d).getWidth();   
		    stringH = (int)g2d.getFontMetrics().getStringBounds(GOTEXT,g2d).getHeight();   
			g2d.drawString(GOTEXT,dx+GOW/2-stringL/2,dy+GOH/2+stringH/3);	
		break;
		case 103 : 
			g2d.setColor(Color.CYAN);
		    stringL = (int)g2d.getFontMetrics().getStringBounds(GOTEXT,g2d).getWidth();   
		    stringH = (int)g2d.getFontMetrics().getStringBounds(GOTEXT,g2d).getHeight();   
			g2d.drawString(GOTEXT,dx+GOW/2-stringL/2,dy+GOH/2+stringH/3);	
		break;
		case 999 : 
		break;
		case 1000 : 
			g2d.setColor(Color.GREEN);
			for(a=1;a<=19;a++)
			{
				//TOP
				g2d.drawString(textTX[a],POSX[a]+23,17);	
				// BUTTOM
				g2d.drawString(textTX[a],POSX[a]+23,POSY[19]+67);	
				//LEFT
				g2d.drawString(textTY[a],5,POSY[a]+28);	
				//RIGHT
				g2d.drawString(textTY[a],POSX[19]+60,POSY[a]+28);	
			}
		break;
		default:
		break;
			}
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GBDIS()
{
		int x=0,y=0;
		srWrite.setText(Integer.toString(GODNO));
			if(GODNO == 1)
			{
				GODIS(0,0,0);
			}
			  for(x=1;x<=19;x++)
			  for(y=1;y<=19;y++)
			  {
			  if(BDBW[x][y]==1)
			  {
				  GODIS(POSX[x],POSY[y],11);
				  if(NUMONOFF==1){GOTEXT=Integer.toString(BDGN[x][y]);GODIS(POSX[x],POSY[y],101);}
				  if(NUMONOFF==2){GOTEXT=Integer.toString(BDSN[x][y]);GODIS(POSX[x],POSY[y],103);}
			  }   
			  if(BDBW[x][y]==2)
			  {
				  GODIS(POSX[x],POSY[y],12);
				  if(NUMONOFF==1){GOTEXT=Integer.toString(BDGN[x][y]);GODIS(POSX[x],POSY[y],102);}
				  if(NUMONOFF==2){GOTEXT=Integer.toString(BDSN[x][y]);GODIS(POSX[x],POSY[y],102);}
			  }
			  if(BDBW[x][y] == 0)
			  {
				  GODIS(POSX[x],POSY[y],SPTYPE[x][y]);
			  }
			  }
			  if(NUMONOFF==0 && GODNO>0)
			  {
				  if(BDBW[NEWX][NEWY]==1){GODIS(POSX[NEWX],POSY[NEWY],21);}
				  if(BDBW[NEWX][NEWY]==2){GODIS(POSX[NEWX],POSY[NEWY],22);}
			  }
			  if(NUMONOFF==1 && GODNO>0)
			  {
				  if(BDBW[NEWX][NEWY]==1)
				  {
					  GOTEXT=Integer.toString(BDGN[NEWX][NEWY]);
					  GODIS(POSX[NEWX],POSY[NEWY],11);GODIS(POSX[NEWX],POSY[NEWY],100);//GODIS(101);
				  }
				  if(BDBW[NEWX][NEWY]==2)
				  {
					  GOTEXT=Integer.toString(BDGN[NEWX][NEWY]);
					  GODIS(POSX[NEWX],POSY[NEWY],12);GODIS(POSX[NEWX],POSY[NEWY],100);//GODIS(101);
				  }
			  }
			  if(NUMONOFF==2 && GODNO>0)
			  {
				  if(BDBW[NEWX][NEWY]==1)
				  {
					  GOTEXT=Integer.toString(BDSN[NEWX][NEWY]);
					  GODIS(POSX[NEWX],POSY[NEWY],11);GODIS(POSX[NEWX],POSY[NEWY],100);//GODIS(101);
				  }
				  if(BDBW[NEWX][NEWY]==2)
				  {
					  GOTEXT=Integer.toString(BDSN[NEWX][NEWY]);
					  GODIS(POSX[NEWX],POSY[NEWY],12);GODIS(POSX[NEWX],POSY[NEWY],100);//GODIS(101);
				  }
			  }
			  if(XYONOFF==1){GODIS(0,0,1000);}
		 GBlabel.repaint();            	 
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GBINITDIS()
{
		int x=0,y=0,MFGGG=0;
				Graphics2D g2d = (Graphics2D) JLimage.getGraphics();
				g2d.drawImage((Image)GOBOARDimage.getImage(),0,0,null);
				for(x=1;x<=19;x++)
				for(y=1;y<=19;y++)
				{
					if(MFBI[x][y] == 0)
					{
						  GODIS(POSY[y],POSX[x],SPTYPE[y][x]);
					}
					if(MFBI[x][y] > 0)
					{
						Random MFGNO = new Random();
						MFGGG = (MFGNO.nextInt(100)+1)%2;
						if(MFGGG == 0){g2d.drawImage(GWI,POSY[y],POSX[x],GOW,GOH, null);}
						if(MFGGG == 1){g2d.drawImage(GBI,POSY[y],POSX[x],GOW,GOH, null);}   
					}   
				}
		       PLAYTYPE = -1; 
		       GBlabel.repaint();
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void DataRead()
{
	try
	{
		strContent = null;strContent = "NULL";
		byte[] inByte = new byte[1024];
    instream  = new DataInputStream (ClientSocket.getInputStream());
		instream.read(inByte);
		String response = new String(inByte, 0, inByte.length);
		if(response.length() < 0){return;}
		strContent = response; strRead = strContent;
		TEXTDIS("-->DataRead_strContent_"+strContent+"("+response+")");
	}
	catch( Exception ex )
	{
	}       
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void DataWrite()
{
	try
	{
	   byte[] outByte = new byte[1024];
	   outByte = strWrite.getBytes();
	   outstream = new DataOutputStream(ClientSocket.getOutputStream());
	   outstream.write(outByte,0,outByte.length);
     outstream.flush();
	   srWrite.setText("Write_"+strWrite);
 		 TEXTDIS("-->DataWrite_Write_"+strWrite);
		 strWriteOld = strWrite;
		 srOut.setText("Out_"+strWrite);
	}
	catch( Exception ex )
	{
	}       
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void DataProcess(String strProcess)//Data processing數據處理
{
		int x=0; DataProcessOK=0; String strProcessTrim="";

		if(strProcess.length() > 0)
		{
			TEXTDIS("-->DataProcess_strProcess_"+strProcess);

			char[] sourceChars = strProcess.toCharArray(); 
			for(x=1;x<sourceChars.length;x++)
			{	
				if(sourceChars[x] == '_') break;
				strProcessTrim += sourceChars[x];
			}
		  srRead.setText("Read_"+strProcessTrim);
			TEXTDIS("-->DataProcess_Read_"+strProcessTrim);
			int intRead = Integer.parseInt(strProcessTrim);
			int GDN = intRead/10000;
			int MX = (intRead%10000)/100;
			int MY = (intRead%10000)%100;
			GODNO=GDN;MDXcheck=MX;MDYcheck=MY;
			MDX = MDXcheck;MDY = MDYcheck;
			srIn.setText("In_"+Integer.toString(GDN)+"_"+Integer.toString(MX)+"_"+Integer.toString(MY));
			TEXTDIS("-->DataProcess_In_"+Integer.toString(GODNO)+"_"+Integer.toString(MDX)+"_"+Integer.toString(MDY));
			DataProcessOK = 1;
		}
}	
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void TBTorderdownMouseListener()
{
			TEXTDIS("Order Down");
			PLAYTYPE = 2;
			GODATA();

		    new OrderDownThread("OrderDown");//自動下子    
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void TBTpeoplecomputerMouseListener()
		{
			TEXTDIS("Computer VS People");
			XYONOFF=0;
			PLAYTYPE = 1;//電腦_人
			GODATA();
			GBDIS();
			
		    new SystemTimeThread("SystemTimeThread");//系統實時間    
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void GOcomputerdown()
		{
				PLAYTYPE=1;int z=0;

				if(GODNO < 361 && PLAYTYPE==1)			
				{
					IsGoDown=0;GoDowned=0;GoSelected=0;	
				//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
					GODownPositionSelect();//黑白子輪流順序下子
				//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
					if(GoSelected == 1 && PLAYTYPE==1)
					{
						GOcDOWN();
							if(GoDowned == 1 && PLAYTYPE==1)
							{
								GoCheckCancel();
								LinkString();

								for(z=1;z<=GODNO;z++){if(SRDT[0][z]==0){GoCancel(z);}}
								
								TimeCount++;
								BWTimeChange();

								GBDIS();
								
			TEXTDIS(Integer.toString(GODNO)+"_"+Integer.toString(MDX)+"_"+Integer.toString(MDY));
			GODOWNDATADIS(Integer.toString(GODNO)+"_"+Integer.toString(MDX)+"_"+Integer.toString(MDY));
			
								GODNO++;
								
				if(GODNO%2 != 0){WGO.setText("");BGO.setText(Integer.toString(GODNO));} //black
				if(GODNO%2 == 0){BGO.setText("");WGO.setText(Integer.toString(GODNO));} //white
							}
					}
				}
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void TBTopengoMouseListener()
		{
			TEXTDIS("Open GO ...");
			OpenGo();
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void OpenGo()
		{
			JFileChooser fcObj = new JFileChooser(DEFAULT_FILE_PATH);

				int result = -1;

				fcObj.setDialogTitle("開啟舊檔");
				//設定對話盒的標題

				JavaFilter jfClass =
					new JavaFilter("class", "Java位元組碼檔 (.class)");
				//宣告篩選位元組碼檔的檔案篩選物件

				fcObj.addChoosableFileFilter(jfClass);
				fcObj.addChoosableFileFilter(
					new JavaFilter("java", "Java原始檔 (.java)"));
				//新增檔案篩選物件

				fcObj.removeChoosableFileFilter(
					fcObj.getAcceptAllFileFilter());
				//移除篩選所有檔案的篩選物件

				fcObj.setFileFilter(jfClass);
				//設定起始選取篩選位元組碼檔的檔案篩選物件

				result = fcObj.showOpenDialog(GreenGOjv.this);
				//顯示檔案開啟對話盒

				if(result == JFileChooser.APPROVE_OPTION){
					File file = fcObj.getSelectedFile();
					//取得檔案選擇器選取的檔案

					TEXTDIS("選取檔案 : " + file.getName());
					//設定標籤顯示開啟檔案的名稱
				}
				else if(result == JFileChooser.CANCEL_OPTION){
					TEXTDIS("取消選取檔案");
					//設定標籤顯示取消檔案選取的訊息
				}
			
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void OpenGoBat()
		{
			OPENGOConnectIP="";
			OPENGOConnectPort="";

				OPENGOjdialog.setLayout(new BorderLayout());
				OPENGOjdialog.setModal(true);

        		  JPanel OPENGOjpanel = new JPanel();
				  OPENGOjpanel.setLayout(new SpringLayout());
				SpringLayout jpanelLayout = (SpringLayout)OPENGOjpanel.getLayout();

				JLabel OPENGOjlIP = new JLabel("IP:");
				OPENGOjlIP.setFont(new Font("Arial", Font.BOLD, 16));
				OPENGOjlIP.setHorizontalTextPosition(JLabel.LEFT);
				OPENGOjlIP.setVerticalTextPosition(JLabel.CENTER);
				OPENGOjpanel.add(OPENGOjlIP);//將元件加入容器
				SpringLayout.Constraints OPENGOjlIP_spConstraints = jpanelLayout.getConstraints(OPENGOjlIP);
				OPENGOjlIP_spConstraints.setX(Spring.constant(5));
				OPENGOjlIP_spConstraints.setY(Spring.constant(5));
				
				OPENGOjtfIP= new JTextField("58.86.237.21",20);
				OPENGOjtfIP.setPreferredSize(new Dimension(75, 25));
				OPENGOjpanel.add(OPENGOjtfIP);
				SpringLayout.Constraints OPENGOIPtext_spConstraints = jpanelLayout.getConstraints(OPENGOjtfIP);
				OPENGOIPtext_spConstraints.setX(Spring.constant(50));
				OPENGOIPtext_spConstraints.setY(Spring.constant(5));
				
				JLabel OPENGOjlPort= new JLabel("Port:");
				OPENGOjlPort.setFont(new Font("Arial", Font.BOLD, 16));
				OPENGOjlPort.setHorizontalTextPosition(JLabel.LEFT);
				OPENGOjlPort.setVerticalTextPosition(JLabel.CENTER);
				OPENGOjpanel.add(OPENGOjlPort);//將元件加入容器
				SpringLayout.Constraints OPENGOjlPort_spConstraints = jpanelLayout.getConstraints(OPENGOjlPort);
				OPENGOjlPort_spConstraints.setX(Spring.constant(5));
				OPENGOjlPort_spConstraints.setY(Spring.constant(35));

				OPENGOjtfPort= new JTextField("",20);
				OPENGOjtfPort.setPreferredSize(new Dimension(75, 25));
				OPENGOjpanel.add(OPENGOjtfPort);
				SpringLayout.Constraints OPENGOjtfPort_spConstraints = jpanelLayout.getConstraints(OPENGOjtfPort);
				OPENGOjtfPort_spConstraints.setX(Spring.constant(50));
				OPENGOjtfPort_spConstraints.setY(Spring.constant(35));

			  JButton OPENGOjbtnOK = new JButton("OK");
			  OPENGOjbtnOK.setPreferredSize(new Dimension(75, 25));
			  OPENGOjpanel.add(OPENGOjbtnOK);
				SpringLayout.Constraints OPENGOjbtnOK_spConstraints = jpanelLayout.getConstraints(OPENGOjbtnOK);
				OPENGOjbtnOK_spConstraints.setX(Spring.constant(50));
				OPENGOjbtnOK_spConstraints.setY(Spring.constant(65));
				OPENGOjbtnOK.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) 
			    {
		   	if((OPENGOjtfIP.getText().length() > 0) && (OPENGOjtfPort.getText().length() > 0))
		   	{
		   		OPENGOConnectIP = OPENGOjtfIP.getText();
		   		OPENGOConnectPort = OPENGOjtfPort.getText();
		   	   	//ConnectIP = "58.86.237.21";
		 		  OPENGOcheck = 10;
		   	}
		   	OPENGOjdialog.dispose();
			    }
			  });

			  JButton OPENGOjbtnCancel = new JButton("Cancel");
			  OPENGOjbtnCancel.setPreferredSize(new Dimension(75, 25));
			  OPENGOjpanel.add(OPENGOjbtnCancel);
				SpringLayout.Constraints OPENGOjbtnCancel_spConstraints = jpanelLayout.getConstraints(OPENGOjbtnCancel);
				OPENGOjbtnCancel_spConstraints.setX(Spring.constant(150));
				OPENGOjbtnCancel_spConstraints.setY(Spring.constant(65));
				OPENGOjbtnCancel.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	OPENGOjdialog.dispose();
			    }
			  });
			  
				OPENGOjdialog.add(OPENGOjpanel, BorderLayout.CENTER);
				OPENGOjdialog.setSize(new Dimension(400,130));
			  Dimension OPENGOdialogSize = OPENGOjdialog.getSize();
			  OPENGOjdialog.setLocation(this.getLocation().x+(this.getWidth() - OPENGOdialogSize.width) / 2, this.getLocation().y+(this.getHeight() - OPENGOdialogSize.height) / 2);	
			  OPENGOjdialog.setTitle("Open Go");
			  OPENGOjdialog.setResizable(false);
			  OPENGOjdialog.setVisible(true);
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void OpenGoBat0()
		{
		    JFileChooser fileopen = new JFileChooser();
		    FileFilter filter = new FileNameExtensionFilter("c files", "c");
		    fileopen.addChoosableFileFilter(filter);

		    int ret = fileopen.showDialog(null, "Open file");

		    if (ret == JFileChooser.APPROVE_OPTION) {
		      File file = fileopen.getSelectedFile();
		      System.out.println(file);
		    }
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void OpenGoBat1()
		{
				OPENGOjdialog.setLayout(new BorderLayout());
				OPENGOjdialog.setModal(true);

				  JPanel OPENGOjpanel = new JPanel();
				  OPENGOjpanel.setLayout(new SpringLayout());
				SpringLayout jpanelLayout = (SpringLayout)OPENGOjpanel.getLayout();

				JLabel OPENGOjlIP = new JLabel("IP:");
				OPENGOjlIP.setFont(new Font("Arial", Font.BOLD, 16));
				OPENGOjlIP.setHorizontalTextPosition(JLabel.LEFT);
				OPENGOjlIP.setVerticalTextPosition(JLabel.CENTER);
				OPENGOjpanel.add(OPENGOjlIP);
				SpringLayout.Constraints OPENGOjlIP_spConstraints = jpanelLayout.getConstraints(OPENGOjlIP);
				OPENGOjlIP_spConstraints.setX(Spring.constant(5));
				OPENGOjlIP_spConstraints.setY(Spring.constant(5));
				
				OPENGOjtfIP= new JTextField("58.86.237.21",20);
				OPENGOjtfIP.setPreferredSize(new Dimension(75, 25));
				OPENGOjpanel.add(OPENGOjtfIP);
				SpringLayout.Constraints OPENGOIPtext_spConstraints = jpanelLayout.getConstraints(OPENGOjtfIP);
				OPENGOIPtext_spConstraints.setX(Spring.constant(50));
				OPENGOIPtext_spConstraints.setY(Spring.constant(5));
				
				JLabel OPENGOjlPort= new JLabel("Port:");
				OPENGOjlPort.setFont(new Font("Arial", Font.BOLD, 16));
				OPENGOjlPort.setHorizontalTextPosition(JLabel.LEFT);
				OPENGOjlPort.setVerticalTextPosition(JLabel.CENTER);
				OPENGOjpanel.add(OPENGOjlPort);
				SpringLayout.Constraints OPENGOjlPort_spConstraints = jpanelLayout.getConstraints(OPENGOjlPort);
				OPENGOjlPort_spConstraints.setX(Spring.constant(5));
				OPENGOjlPort_spConstraints.setY(Spring.constant(35));

				OPENGOjtfPort= new JTextField("",20);
				OPENGOjtfPort.setPreferredSize(new Dimension(75, 25));
				OPENGOjpanel.add(OPENGOjtfPort);
				SpringLayout.Constraints OPENGOjtfPort_spConstraints = jpanelLayout.getConstraints(OPENGOjtfPort);
				OPENGOjtfPort_spConstraints.setX(Spring.constant(50));
				OPENGOjtfPort_spConstraints.setY(Spring.constant(35));

			  JButton OPENGOjbtnOK = new JButton("OK");
			  OPENGOjbtnOK.setPreferredSize(new Dimension(75, 25));
			  OPENGOjpanel.add(OPENGOjbtnOK);
				SpringLayout.Constraints OPENGOjbtnOK_spConstraints = jpanelLayout.getConstraints(OPENGOjbtnOK);
				OPENGOjbtnOK_spConstraints.setX(Spring.constant(50));
				OPENGOjbtnOK_spConstraints.setY(Spring.constant(65));
				OPENGOjbtnOK.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) 
			    {
		   	if((OPENGOjtfIP.getText().length() > 0) && (OPENGOjtfPort.getText().length() > 0))
		   	{
		   		OPENGOConnectIP = OPENGOjtfIP.getText();
		   		OPENGOConnectPort = OPENGOjtfPort.getText();
		   	   	//ConnectIP = "58.86.237.21";
		 		  OPENGOcheck = 10;
		   	}
		   	OPENGOjdialog.dispose();
			    }
			  });

			  JButton OPENGOjbtnCancel = new JButton("Cancel");
			  OPENGOjbtnCancel.setPreferredSize(new Dimension(75, 25));
			  OPENGOjpanel.add(OPENGOjbtnCancel);
				SpringLayout.Constraints OPENGOjbtnCancel_spConstraints = jpanelLayout.getConstraints(OPENGOjbtnCancel);
				OPENGOjbtnCancel_spConstraints.setX(Spring.constant(150));
				OPENGOjbtnCancel_spConstraints.setY(Spring.constant(65));
				OPENGOjbtnCancel.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	OPENGOjdialog.dispose();
			    }
			  });
			  
				OPENGOjdialog.add(OPENGOjpanel, BorderLayout.CENTER);
				OPENGOjdialog.setSize(new Dimension(500,500));
			  Dimension OPENGOdialogSize = OPENGOjdialog.getSize();
			  OPENGOjdialog.setLocation(this.getLocation().x+(this.getWidth() - OPENGOdialogSize.width) / 2, this.getLocation().y+(this.getHeight() - OPENGOdialogSize.height) / 2);	
			  OPENGOjdialog.setTitle("Open Go");
			  OPENGOjdialog.setResizable(false);
			  OPENGOjdialog.setVisible(true);
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void TBTsavegoMouseListener()
		{
			TEXTDIS("Save GO ...");
			SaveGo();
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void SaveGo()
		{
			JFileChooser fcObj = new JFileChooser(DEFAULT_FILE_PATH);
				//宣告檔案選擇器物件
				int result = -1;
				fcObj.setDialogTitle("儲存檔案");
				//設定對話盒的標題
				result = fcObj.showSaveDialog(GreenGOjv.this);
				//顯示檔案儲存對話盒			
				if(result == JFileChooser.APPROVE_OPTION){
					File file = fcObj.getSelectedFile();
					//取得檔案選擇器選取的檔案
					TEXTDIS("選取檔案 : " + file.getName());
					//設定標籤顯示開啟檔案的名稱
				}
				else if(result == JFileChooser.CANCEL_OPTION){
					TEXTDIS("取消選取檔案");
				}
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void GOPeopleComputerPlay()
		{
			try
		    {
			if(GODNO == 361)
			{ 
				GoPlayDataTextSave();
				TEXTDIS("<<< GOPeopleComputerPlay END");
				GODNO=1; 
				GOINIT();	
				GODATA();			
			}
			if(GODNO == 1)
			{
				TEXTDIS(">>> GOPeopleComputerPlay ...");
				PLAYTYPE=1;
				GOPLAYFILENO+=1;
				GODATA();
			}
		    }
		    catch( Exception ex )
		    {
		    //	MessageBox.Show("GOPeopleComputerPlay(): " + ex.Message );
		    }       
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void GONetConnectDownTimerTick()
		{
			try
			  {
				if(GODNOcheck == 361)
				{ 
					GoPlayDataTextSave();
					TEXTDIS("<<<GONetConnectDown END");
					GODNOcheck=1; 
					GOINIT();	
					GODATA();
				}
				if(GODNOcheck == 1)
				{
					TEXTDIS(">>>GONetConnectDown ...");
					PLAYTYPE=3;
					GOPLAYFILENO+=1;
					GODATA();
				}

						GONetConnectCycle();

			  }
			  catch( Exception ex )
			  {
			  }       
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void GONetConnectCycle()
		{
			GDNDATA=0;GODOWNcheck=0;
				TEXTDIS("-->GONetConnectCycle");

		        srRead.setForeground(Color.YELLOW);
		        srIn.setForeground(Color.YELLOW);
		        srWrite.setForeground(Color.YELLOW);
		        srOut.setForeground(Color.YELLOW);

			if((GODNOcheck > 1) && (GODNOcheck < 361) 
				&& (GODOWNcheck == 0) && (GODNOcheck%2 != BWplayer))//被動
			{//------------------------
				DataRead();//讀取
				if((strRead != null) && (strRead != "NULL") && (strRead.length() > 0))
				{
					TEXTDIS("-->GODNOcheck_"+Integer.toString(GODNOcheck)+" , BWplayer_"+Integer.toString(BWplayer));
					DataProcess(strRead);//解碼
					if(GODNOcheck == GODNO)//執行
					{
						GONetConnectDown();
						if(GODOWNcheck == 1)
						{
							TEXTDIS("-->BWplayer_"+Integer.toString(BWplayer)+"_"+Integer.toString(GODNOcheck)+"_"+Integer.toString(MDX)+"_"+Integer.toString(MDY));
							GODNOcheck++;GODOWNcheck=1;
							srRead.setForeground(Color.RED);srIn.setForeground(Color.RED);
						}
					}
				}	
			}
			if((GODNOcheck > 1) && (GODNOcheck < 361) 
					&& (GODOWNcheck == 0) && (GODNOcheck%2 == BWplayer))//主動
			{
				TEXTDIS("-->GODNOcheck_"+Integer.toString(GODNOcheck)+" , BWplayer_"+Integer.toString(BWplayer));
				IsGoDown=0;GoDowned=0;GoSelected=0;
				GODownPositionSelect();//選位//本機電腦自主選擇
				GONetConnectDown();//執行
				if(GODOWNcheck == 1)
				{
					GDNDATA=(GODNOcheck*10000)+(MDX*100)+MDY;//組碼
					strWrite = "J"+Integer.toString(GDNDATA)+"_";
					DataWrite();//寫出
					TEXTDIS("-->BWplayer_"+Integer.toString(BWplayer)+"_"+Integer.toString(GODNOcheck)+"_"+Integer.toString(MDX)+"_"+Integer.toString(MDY));
					GODNOcheck++;GODOWNcheck=1;
	        srWrite.setForeground(Color.RED);srOut.setForeground(Color.RED);
				}
			}
			if((GODNOcheck == 1) && (GODOWNcheck == 0) 
					&& (BWplayer == Wplayer))//被動
			{
				TEXTDIS("-->GODNOcheck_"+Integer.toString(GODNOcheck)+" , BWplayer_"+Integer.toString(BWplayer));
				DataRead();//讀取
				if((strRead != null) && (strRead != "NULL") && (strRead.length() > 0))
				{
					TEXTDIS("-->strReadProcess_"+strRead);
					DataProcess(strRead);//解碼
						GONetConnectDown();
						if(GODOWNcheck == 1)
						{
							GODOWNDATADIS(Integer.toString(GODNOcheck)+"_"+Integer.toString(MDX)+"_"+Integer.toString(MDY));
							TEXTDIS("-->BWplayer_"+Integer.toString(BWplayer)+"_"+Integer.toString(GODNO));
							GODNOcheck++;GODOWNcheck=1;
			        srRead.setForeground(Color.RED);srIn.setForeground(Color.RED);
						}
				}	
			}
			if((GODNOcheck == 1) && (GODOWNcheck == 0) 
			&& (BWplayer == Bplayer))//主動
			{
				TEXTDIS("-->GODNOcheck_"+Integer.toString(GODNOcheck)+" , BWplayer_"+Integer.toString(BWplayer));
				IsGoDown=0;GoDowned=0;GoSelected=0;
				GODownPositionSelect();//選位//本機電腦自主選擇
				GONetConnectDown();//執行
				if(GODOWNcheck == 1)
				{
					GDNDATA=(GODNOcheck*10000)+(MDX*100)+MDY;//組碼
					strWrite = "J"+Integer.toString(GDNDATA)+"_";
					DataWrite();//寫出
					TEXTDIS("-->BWplayer_"+Integer.toString(BWplayer)+"_"+Integer.toString(GODNOcheck)+"_"+Integer.toString(MDX)+"_"+Integer.toString(MDY));
					GODNOcheck++;GODOWNcheck=1;
			    srWrite.setForeground(Color.RED);srOut.setForeground(Color.RED);
				}
			}
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void GONetConnectDown()
		{
			PLAYTYPE = 3;//電腦連線電腦
			TEXTDIS(">>> GONetConnectDown");
			int z=0;
			if(GODNO < 361 && PLAYTYPE==3)			
			{
				GoSelected=1;

				if(GoSelected == 1 && PLAYTYPE==3)
				{
					GONetDown();
						if(GoDowned == 1 && PLAYTYPE==3)
						{
							GoCheckCancel();
							LinkString();
							
					for(z=1;z<=GODNO;z++){if(SRDT[0][z]==0){GoCancel(z);}}
					
							TimeCount++;
							BWTimeChange();

							GBDIS();
			if(GODNO%2 != 0){WGO.setText("");BGO.setText(Integer.toString(GODNO));} //黑子
			if(GODNO%2 == 0){BGO.setText("");WGO.setText(Integer.toString(GODNO));} //白子
						}
				}
			}
			GODOWNcheck = 1;
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void GONetDown()
		{
			TEXTDIS(">>> GONetDown");
			if(GODNO%2==1)
			{
				BDBW[MDX][MDY]=1;
				GOBW[GODNO]=1;
			}
			if(GODNO%2==0)
			{
				BDBW[MDX][MDY]=2;
				GOBW[GODNO]=2;
			}
			BDGN[MDX][MDY]=GODNO;
			GOX[GODNO]=MDX;
			GOY[GODNO]=MDY;
			NEWX=MDX;NEWY=MDY;
			GoDowned=1;TEXTDIS("<<< GoDowned=1 GoDowned!!!");
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GOORDERDOWNtimerTick()
{
			try
		  {
			if(GODNO == 361)
			{ 
				GoPlayDataTextSave();
				TEXTDIS("<<<GOorderdown END");
				GODNO=1; 
				GOINIT();	
				GODATA();
			}
			if(GODNO == 1)
			{
				TEXTDIS(">>>GOorderdown ...");
				PLAYTYPE=2;
				GOPLAYFILENO+=1;
				GODATA();
			}
		//------------------------
			GOorderdown();
		//------------------------
		  }
		  catch( Exception ex )
		  {
			  System.out.println("錯誤訊息:" + ex.getMessage());
		  }       
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GOorderdown()
{
	if(PLAYTYPE == 2)
	{
		GOengine();
	}
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GOengine()
{
	TEXTDIS("GOengine() >>>>>");
		int z=0;
		if(GODNO < 361)			
		{
			IsGoDown=0;GoDowned=0;GoSelected=0;	
			
			TimeCount++;
			BWTimeChange();
			
			GODownPositionSelect();

			if(GoSelected == 1)
			{
				GODOWN();
					if(GoDowned == 1)
					{
						GoCheckCancel();
						LinkString();

						for(z=1;z<=GODNO;z++){if(SRDT[0][z]==0){GoCancel(z);}}
						
						TimeCount++;
						BWDownTimeChange();
						
						GBDIS();
						
	TEXTDIS(Integer.toString(GODNO)+"_"+textTX[MDX]+"_"+Integer.toString(MDY));
	GODOWNDATADIS(Integer.toString(GODNO)+"_"+textTX[MDX]+"_"+Integer.toString(MDY));
	
						GODNO++;
						
		if(GODNO%2 != 0){WGO.setText("");BGO.setText(Integer.toString(GODNO));} //黑子
		if(GODNO%2 == 0){BGO.setText("");WGO.setText(Integer.toString(GODNO));} //白子
					}
			}
		}
		TEXTDIS("GOengine() <<<<<");
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public int GoLifeNumCount(int GDSX,int GDSY) //清除棋子
{	
			int x=0,y=0;
			int GLN=0;

			for(x=0;x<=20;x++)
			for(y=0;y<=20;y++)
			{BDCD[x][y]=0;}
			for(x=1;x<=19;x++)
			for(y=1;y<=19;y++)
			{
				if(BDSN[x][y]==BDSN[GDSX][GDSY])
				{
					if(BDBW[x-1][y]==0){BDCD[x-1][y]=1;}//左
					if(BDBW[x][y-1]==0){BDCD[x][y-1]=1;}//上
					if(BDBW[x+1][y]==0){BDCD[x+1][y]=1;}//右
					if(BDBW[x][y+1]==0){BDCD[x][y+1]=1;}//下
				}	
			}
		//統計氣數
			for(x=1;x<=19;x++)
			for(y=1;y<=19;y++)
			{
				if(BDCD[x][y]==1){GLN++;}
			}
				
			TEXTDIS("SRDT[0,BDSN[DSX,DSY]] = "+Integer.toString(SRDT[0][BDSN[GDSX][GDSY]]));
            TEXTDIS("GLN = "+Integer.toString(GLN));
			
			return GLN;
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void GoCancel(int CGSN)
{
			int x=0,y=0;//z=0;

		TEXTDIS(">>> GoCancel ...");
		for(x=1;x<=19;x++)
		for(y=1;y<=19;y++)
		{
			if(BDSN[x][y]==CGSN)
			{
		TEXTDIS("2. Change the string of child-related information pieces.");

		if(BDBW[x][y]==2){Bcapture.setText("");BWIN++;Bcapture.setText(String.format("%03d",BWIN));}
		if(BDBW[x][y]==1){Wcapture.setText("");WWIN++;Wcapture.setText(String.format("%03d",WWIN));}

		GOOUT[BDGN[x][y]]=GODNO;
		BDBW[x][y]=0;
		BDGN[x][y]=0;

		TEXTDIS("Clear sub-string should be mentioned.");
		TEXTDIS("1. Clear string go -> "+"X=" + textTX[x]+",Y=" + Integer.toString(y));
		TEXTDIS("  GOBoard Position -> "+"X=" + textTX[x]+",Y=" + textTY[y]);
			}
		}
			SRBW[CGSN]= -1;
			SRBW[CGSN]=0;SRDT[0][CGSN]= -1;SRDT[1][CGSN]=0;
			SRDT[2][CGSN]=0;SRDT[3][CGSN]=0;SRDT[4][CGSN]=0;

			TEXTDIS("<<< GoCanceled");
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void GoCheckCancel()
{
			TEXTDIS(">>> GoCheckCancel ...");
			int DSX=0,DSY=0,GLNum=0,CGDSN=0;//e=0;
		//上
			DSX=MDX;DSY=MDY-1;GLNum=0;CGDSN=BDSN[DSX][DSY];
			GLNum=GoLifeNumCount(DSX,DSY);
			if(GLNum==0 && BDBW[MDX][MDY]!=BDBW[DSX][DSY]){GoCancel(CGDSN);}
		//右
			DSX=MDX+1;DSY=MDY;GLNum=0;CGDSN=BDSN[DSX][DSY];
			GLNum=GoLifeNumCount(DSX,DSY);
			if(GLNum==0 && BDBW[MDX][MDY]!=BDBW[DSX][DSY]){GoCancel(CGDSN);}
		//下
			DSX=MDX;DSY=MDY+1;GLNum=0;CGDSN=BDSN[DSX][DSY];
			GLNum=GoLifeNumCount(DSX,DSY);
			if(GLNum==0 && BDBW[MDX][MDY]!=BDBW[DSX][DSY]){GoCancel(CGDSN);}
		//左
			DSX=MDX-1;DSY=MDY;GLNum=0;CGDSN=BDSN[DSX][DSY];
			GLNum=GoLifeNumCount(DSX,DSY);
			if(GLNum==0 && BDBW[MDX][MDY]!=BDBW[DSX][DSY]){GoCancel(CGDSN);}
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void LinkString() //計算棋子串號
{
			TEXTDIS(">>>LinkString...");
			int x=0,y=0,linked=0;
			int [] BDSNDT={0,0,0,0,0};

			linked=0;	
			for(x=0;x<=4;x++){BDSNDT[x]=0;}
			
			BDSNDT[0]=STRINGNO;
			TEXTDIS("BDSNDT[0]=" + Integer.toString(BDSNDT[0]));
			BDSN[MDX][MDY]=BDSNDT[0];
			if(BDBW[MDX-1][MDY] == BDBW[MDX][MDY]){BDSNDT[1] = BDSN[MDX-1][MDY];}//Lift
			if(BDBW[MDX][MDY-1] == BDBW[MDX][MDY]){BDSNDT[2] = BDSN[MDX][MDY-1];}//Top
			if(BDBW[MDX+1][MDY] == BDBW[MDX][MDY]){BDSNDT[3] = BDSN[MDX+1][MDY];}//Right
			if(BDBW[MDX][MDY+1] == BDBW[MDX][MDY]){BDSNDT[4] = BDSN[MDX][MDY+1];}//Under
			TEXTDIS("BDSNDT[1]=" + Integer.toString(BDSNDT[1]));
			TEXTDIS("BDSNDT[2]=" + Integer.toString(BDSNDT[2]));
			TEXTDIS("BDSNDT[3]=" + Integer.toString(BDSNDT[3]));
			TEXTDIS("BDSNDT[4]=" + Integer.toString(BDSNDT[4]));

			BDSN[MDX][MDY] = BDSNDT[0];linked=10;
			TEXTDIS("BDSN[MDX][MDY]=" + Integer.toString(BDSN[MDX][MDY]));
			TEXTDIS("linked=" + Integer.toString(linked));

			if(BDBW[MDX-1][MDY]==BDBW[MDX][MDY])//Left
			{
				for(y=1;y<=19;y++)
				for(x=1;x<=19;x++)
				{if(BDSN[x][y]==BDSNDT[1]){BDSN[x][y]=BDSN[MDX][MDY];}}
					linked=11;
			TEXTDIS("linked=" + Integer.toString(linked));
			}

			if(BDBW[MDX][MDY-1]==BDBW[MDX][MDY])//Top
			{
				for(y=1;y<=19;y++)
				for(x=1;x<=19;x++)
				{if(BDSN[x][y]==BDSNDT[2]){BDSN[x][y]=BDSNDT[0];}}
				linked=12;
			TEXTDIS("linked=" + Integer.toString(linked));
			}

			if(BDBW[MDX+1][MDY]==BDBW[MDX][MDY])//Right
			{
				for(y=1;y<=19;y++)
				for(x=1;x<=19;x++)
				{if(BDSN[x][y]==BDSNDT[3]){BDSN[x][y]=BDSNDT[0];}}
				linked=13;
			TEXTDIS("linked=" + Integer.toString(linked));
			}

			if(BDBW[MDX][MDY+1]==BDBW[MDX][MDY])//Under
			{
				for(y=1;y<=19;y++)
				for(x=1;x<=19;x++)
				{if(BDSN[x][y]==BDSNDT[4]){BDSN[x][y]=BDSNDT[0];}}
				linked=14;
			TEXTDIS("linked=" + Integer.toString(linked));
			}

			TEXTDIS("STRINGNO=" + Integer.toString(STRINGNO));
			STRINGNO++;
			TEXTDIS("STRINGNO ++ =" + Integer.toString(STRINGNO));
			TEXTDIS("<<< LinkString end!!!");
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void CalculationBoard()//計算氣數及盤面資料
{
			int x=0,y=0,z=0;
			TEXTDIS("CalculationBoard >>>>>");
			TEXTDIS("String array data return 0"); 
			
			for(y=0;y<=362;y++)	{SRBW[y]=0;SRNUM[y]=0;}
			for(y=0;y<=362;y++)
			{SRDT[0][y] = -1;SRDT[1][y]=0;SRDT[2][y]=0;SRDT[3][y]=0;SRDT[4][y]=0;
			SRDT[5][y]=0;SRDT[6][y] = 0;SRDT[7][y]=0;SRDT[8][y]=0;SRDT[9][y]=0;}

		//檢查串號如果存在.先將氣數歸0
				for(x=1;x<=19;x++)
					for(y=1;y<=19;y++)
						{if(BDSN[x][y] > 0){SRDT[0][BDSN[x][y]]=0;}}

			for(z=1;z<=GODNO;z++)
			{
				if(SRDT[0][z]==0)//確認氣數歸0.表示該串子存在且尚未經過計算搜索
				{
					for(x=0;x<=20;x++)//棋盤資料整理區規0
						for(y=0;y<=20;y++)
							{BDCD[x][y]=0;}
		//映射BDBW[,]資料至BDCD[,] TEXTDIS("映射BDBW[,]資料至BDCD[,]...");
				for(x=1;x<=19;x++)
				for(y=1;y<=19;y++)
				{
					if(BDSN[x][y]==z)
					{
						if(BDBW[x-1][y]==0){BDCD[x-1][y]=1;}//左
						if(BDBW[x][y-1]==0){BDCD[x][y-1]=1;}//上
						if(BDBW[x+1][y]==0){BDCD[x+1][y]=1;}//右
						if(BDBW[x][y+1]==0){BDCD[x][y+1]=1;}//下
						SRBW[z]=BDBW[x][y];//計錄該串子顏色
						SRNUM[z]++;////計錄該串子所屬棋子數量
					}	
				}
		//統計氣數 TEXTDIS("4.3.2.3 統計氣數...");
				for(x=1;x<=19;x++)
				for(y=1;y<=19;y++)
				{
					if(BDCD[x][y]==1)
					{
						SRDT[0][z]++;//計錄該串子氣數
						//假如該串子氣數<10氣.繼續追加登錄該串子氣數
						if(SRDT[0][z]<10){SRDT[SRDT[0][z]][z]=x+y*21;}
					}
				}
				}
			}
			TEXTDIS("<<< SRCD[] data to arrayed."); 		
			TEXTDIS("STRINGNO=" + Integer.toString(STRINGNO));
			TEXTDIS("CalculationBoard <<<<<");
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public int StringLinkCheck(int GMDX,int GMDY)
{
			TEXTDIS(">>>StringLinkCheck ...");
			int x=0,y=0;
			int SLCC=0,SLCL=0,SLCT=0,SLCR=0,SLCB=0;
			int SLCBW=0;

			for(x=0;x<=20;x++)for(y=0;y<=20;y++){BDSLC[x][y]= -1;}
			for(x=1;x<=19;x++)for(y=1;y<=19;y++){BDSLC[x][y]=0;}
			for(x=0;x<=20;x++)for(y=0;y<=20;y++){BDCD[x][y]=0;}

			if(GODNO%2 == 0){SLCBW=2;}
			if(GODNO%2 == 1){SLCBW=1;}
			TEXTDIS("SLCBW=" + Integer.toString(SLCBW));
			BDSLC[GMDX][GMDY]=GODNO+1000;
			SLCC=GODNO+1000;
			TEXTDIS("SLCC=" + Integer.toString(SLCC));
			if(BDBW[GMDX-1][GMDY]==BDBW[GMDX][GMDY]){SLCL=BDSN[GMDX-1][GMDY];}//Lift
			if(BDBW[GMDX][GMDY-1]==BDBW[GMDX][GMDY]){SLCT=BDSN[GMDX][GMDY-1];}//Top
			if(BDBW[GMDX+1][GMDY]==BDBW[GMDX][GMDY]){SLCR=BDSN[GMDX+1][GMDY];}//Right
			if(BDBW[GMDX][GMDY+1]==BDBW[GMDX][GMDY]){SLCB=BDSN[GMDX][GMDY+1];}//Under
			TEXTDIS("SLCL=" + Integer.toString(SLCL));
			TEXTDIS("SLCT=" + Integer.toString(SLCT));
			TEXTDIS("SLCR=" + Integer.toString(SLCR));
			TEXTDIS("SLCB=" + Integer.toString(SLCB));
			if(BDBW[GMDX-1][GMDY]==SLCBW)//Left
			{
				for(y=1;y<=19;y++)
				for(x=1;x<=19;x++)
				{if(BDSN[x][y]==BDSN[GMDX-1][GMDY]){BDSLC[x][y]=SLCC;}}
				TEXTDIS("Left linked.");
			}
			if(BDBW[GMDX][GMDY-1]==SLCBW)//Top
			{
				for(y=1;y<=19;y++)
				for(x=1;x<=19;x++)
				{if(BDSN[x][y]==BDSN[GMDX][GMDY-1]){BDSLC[x][y]=SLCC;}}
				TEXTDIS("Top linked.");	}
			if(BDBW[GMDX+1][GMDY]==SLCBW)//Right
			{
				for(y=1;y<=19;y++)
				for(x=1;x<=19;x++)
				{if(BDSN[x][y]==BDSN[GMDX+1][GMDY]){BDSLC[x][y]=SLCC;}}
				TEXTDIS("Right linked.");	}
			if(BDBW[GMDX][GMDY+1]==SLCBW)//Under
			{
				for(y=1;y<=19;y++)
				for(x=1;x<=19;x++)
				{if(BDSN[x][y]==BDSN[GMDX][GMDY+1]){BDSLC[x][y]=SLCC;}}
				TEXTDIS("Bottom linked.");	}
			TEXTDIS("BDSLC[GMDX,GMDY] STRINGNO = GODNO = " + Integer.toString(SLCC));

			int SLN=0;

			for(x=1;x<=19;x++)
			for(y=1;y<=19;y++)
			{
				if(BDSLC[x][y]>0)
				{
					if(BDBW[x-1][y]==0){BDCD[x-1][y]=1;}//左
					if(BDBW[x][y-1]==0){BDCD[x][y-1]=1;}//上
					if(BDBW[x+1][y]==0){BDCD[x+1][y]=1;}//右
					if(BDBW[x][y+1]==0){BDCD[x][y+1]=1;}//下
				}	
			}
		//統計氣數
			for(x=1;x<=19;x++)
			for(y=1;y<=19;y++)
			{
				if(BDCD[x][y]==1){SLN++;}
			}
			TEXTDIS("<<< StringLinkCheck end!!!");
			return SLN;
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
public void GODOWNYESNO(int MDXXX,int MDYYY)
{
		int LFN=0;

		TEXTDIS(">>>GODOWNYESNO");
		TEXTDIS("Analysis of the legality of the situation erupted");

		GOYESNO=0;

		LFN = StringLinkCheck(MDXXX,MDYYY);
		if(LFN > 0){GOYESNO=1;}

		if(GOYESNO == 1){MDX=MDXXX;MDY=MDYYY;GoSelected=1;}
		TEXTDIS("<<< GODOWNYESNO "+"GOYESNO="+Integer.toString(GOYESNO)+"GoSelected="+Integer.toString(GoSelected));
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GODownPositionSelect()
{
	TEXTDIS("GODownPositionSelect() >>>>>");

		int x=0,y=0,z=0;
		int ADX=0,ADY=0;
		int TESTGGG=0;
		int ListTotal=0;
		int ListPOS=0;
		int[] CheckList = new int[362];
		int CheckZ=0,CheckNum=0;
		int Lnum=0;
		int Zran=0;
		int SLISTCHECKED=0,lifenum=0;
		Random TESTGNO = new Random();
		Random ListPOSran = new Random();
		Random Zorder = new Random();
		Random Lifeorder = new Random();
		Random LifeRan = new Random();

		CalculationBoard(); //Calculate life count and board data

		if(GoSelected == 0)
		{
			
			if(GODNO > 7)
			{
			TEXTDIS("GODNO = "+Integer.toString(GODNO));
			TEXTDIS("GoSelected = "+Integer.toString(GoSelected));

				SLISTCHECKED=0;z=1;lifenum=1;
				Zran = Zorder.nextInt(200)+1; 
				
				do{

					z=Zran;
					
					do
					{
						if(SRDT[0][z]==lifenum && SRBW[z]!=(GODNO%2))
						{
			ListTotal=0;CheckZ=0;CheckNum=0;
			for(x=0;x<=361;x++){CheckList[x]=0;}//檢舉陣列歸0 ListTotal
			for(y=1;y<=361;y++)
			{
				if(SRDT[0][y]==lifenum)//假如氣數陣列0行值=檢驗氣數值
				{
					//記錄SRDT陣列中.與檢驗氣數相等的氣數所包含的棋子數
					ListTotal++;CheckList[ListTotal]=SRNUM[y];
					if(SRNUM[y]>CheckNum)//假如檢驗值>記錄值
					{
						CheckNum=SRNUM[y];//記錄值=檢驗值
						CheckZ=y;//記錄位置=y
					}
				}
			}
							Lnum = LifeRan.nextInt(lifenum)+1;//亂數決定使用哪1個氣數位置
							ADX=SRDT[Lnum][CheckZ]%21;
							ADY=SRDT[Lnum][CheckZ]/21;
							SLISTCHECKED=1;
						}
						if(SLISTCHECKED == 1)
						{					
							GODOWNYESNO(ADX,ADY);//檢查下子位置是否合格
						}
						z++;
						
					}while(z<360 && SLISTCHECKED==0);

					z=1;
					do
					{
						if(SRDT[0][z]==lifenum && SRBW[z]!=(GODNO%2))
						{

			ListTotal=0;CheckZ=0;CheckNum=0;
			for(x=0;x<=361;x++){CheckList[x]=0;}//檢舉陣列歸0 ListTotal
			for(y=1;y<=361;y++)
			{
				if(SRDT[0][y]==lifenum)
				{
					ListTotal++;CheckList[ListTotal]=SRNUM[y];
					if(SRNUM[y]>CheckNum){CheckNum=SRNUM[y];CheckZ=y;}
				}
			}

							Lnum = LifeRan.nextInt(lifenum)+1; 
							ADX=SRDT[Lnum][CheckZ]%21;
							ADY=SRDT[Lnum][CheckZ]/21;
							SLISTCHECKED=1;
						}
						if(SLISTCHECKED == 1)
						{					
							GODOWNYESNO(ADX,ADY);//檢查下子位置是否合格
						}
						z++;
						
					}while(z<Zran && SLISTCHECKED==0);

					if(SLISTCHECKED==0)
					{
						lifenum++;TEXTDIS("lifenum = "+Integer.toString(lifenum));
					}

				}while(lifenum<9 && SLISTCHECKED==0);
			}
					
		//使用亂數決定或使用定石資料決定
			if(GODNO < 8)
			{
				TESTGGG = TESTGNO.nextInt(440)+1; 
				x=TESTGGG/21;y=TESTGGG%21;
				
		if(x>0 && y>0 && x<20 && y<20)
		{
			TEXTDIS("***************");
			TEXTDIS("GODownPositionSelect"+"[ "+textTX[x]+" "+Integer.toString(y)+" ]");
		if(BDBW[x][y]==0)
		{
			GODOWNYESNO(x,y);//檢查下子位置是否合格
			if(GOYESNO == 1)
			{
			}
			
		}
		}

			}
			
		}


		//最後未能決定.則用亂數判定使用盤面上的哪個空格
		if(GoSelected == 0)
		{
			
			for(x=0;x<=361;x++){CheckList[x]=0;}
			
			ListTotal=0;
			for(y=1;y<=19;y++)
			for(x=1;x<=19;x++)
			{
				if(BDBW[x][y]==0)
				{
					ListTotal++;
					CheckList[ListTotal]=x+y*21;
				}
			}
			ListPOS = ListPOSran.nextInt(ListTotal)+1; 
			TEXTDIS("**CheckList[ListPOS]**");
			GODOWNYESNO(CheckList[ListPOS]%21,CheckList[ListPOS]/21);//檢查下子位置是否合格
			if(GOYESNO == 1)
			{
			}
		}

		TEXTDIS("GODownPositionSelect() <<<<<");
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GODOWN()
{
			TEXTDIS(">>> GODOWN 0");
			if(GODNO%2==1)
			{
				BDBW[MDX][MDY]=1;GOBW[GODNO]=1;
			}
			if(GODNO%2==0)
			{
				BDBW[MDX][MDY]=2;GOBW[GODNO]=2;
			}
			BDGN[MDX][MDY]=GODNO;
			GOX[GODNO]=MDX;
			GOY[GODNO]=MDY;
			NEWX=MDX;NEWY=MDY;
			GoDowned=1;TEXTDIS("<<< GoDowned=1 GoDowned!!!");
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void GOcDOWN()
{
			TEXTDIS(">>> GODOWN 0");
			if(GODNO%2==1)
			{
				BDBW[MDX][MDY]=1;GOBW[GODNO]=1;
			}
			if(GODNO%2==0)
			{
				BDBW[MDX][MDY]=2;GOBW[GODNO]=2;
			}
			BDGN[MDX][MDY]=GODNO;
			GOX[GODNO]=MDX;
			GOY[GODNO]=MDY;
			NEWX=MDX;NEWY=MDY;
			GoDowned=1;TEXTDIS("<<< GoDowned=1 GoDowned!!!");
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void GOINIT()
		{
				int x=0,y=0,aaa=0;
				for(x=0;x<=20;x++)
				for(y=0;y<=20;y++)
				{ BDBW[x][y] = -1;BDSN[x][y] = 0;}
				for(x=1;x<=19;x++)
				for(y=1;y<=19;y++)
				{ BDBW[x][y]=0;BDSN[x][y]=0;}
				for(x=0;x<=20;x++)
				for(y=0;y<=20;y++)
				{
					BDGN[x][y]=0;BDCD[x][y]=0;
				}
				for(aaa=0;aaa<=362;aaa++)
				{ 
					GOBW[aaa]=0;
					GOX[aaa]=0;
					GOY[aaa]=0;
					GOOUT[aaa]=0;
					SRBW[aaa]=0;
					SRNUM[aaa]=0;
					SRDT[0][aaa]=0;SRDT[1][aaa]=0;SRDT[2][aaa]=0;SRDT[3][aaa]=0;
					SRDT[4][aaa]=0;SRDT[5][aaa]=0;SRDT[6][aaa]=0;SRDT[7][aaa]=0;
					SRDT[8][aaa]=0;SRDT[9][aaa]=0;
				}

					GODNO=1;  //下子順序
					BSS=0; BMM=100; WSS=0; WMM=100;
					XXX1=1;YYY1=1;XXX=1;YYY=1;KKK=0;
					NEWX=1;NEWY=1;MDX=1;MDY=1;
					WhiteStringNo = 2; //白子串子序號
					BlackStringNo = 1; //黑子串子序號
					STRINGNO = 1; //目前串子序號

					BWIN=0;
					BWINTOTAL=0;
					WWIN=0;
					WWINTOTAL=0;
					NUMONOFF=0;
					XYONOFF=0;

				GBimg = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/pp10301030png.png"));
		        GOBOARDimage = GBimg;

		        GBIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/GOB5151png.png"));
		        GBI = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/GB5151png.png")).getImage();
				
		        GWIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/GOW5151png.png"));
		        GWI = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/GW5151png.png")).getImage();
	
		        GBRIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/gob3535TR99png.png"));
		        GBRI = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/gob3535TR99png.png")).getImage();
		        
		        GWRIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/gow3535TR99png.png"));
		        GWRI = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/gow3535TR99png.png")).getImage();
	
				pBOARD = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/pp10301030png.png"));
				pDATA = new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/pp7001030png_1.png"));
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void MainForm_Load()
		{
			WTime1=0;WTime2=0;WTime3=0;
			if(PLAYTYPE == -1)
			{
				GBINITDIS();
				BWIN=0;BWINTOTAL=0;
				WWIN=0;WWINTOTAL=0;
			}
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void SystemTimeChange()
		{
		    Date nDate = new Date();  
		    String TS = String.format("%tH",nDate)+":"+String.format("%tM",nDate)
		    	+":"+String.format("%tS",nDate);  
			SBTIME.setText(TS);
			SWTIME.setText(TS);
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void BWDownTimeChange()
{
		    Date nDate = new Date();  
		    String TS = String.format("%tH",nDate)+":"+String.format("%tM",nDate)
		    	+":"+String.format("%tS",nDate);  

		if(GODNO%2 == 1)
		{
			SBTIME.setText(TS);
		}
		if(GODNO%2 == 0)
		{
			SWTIME.setText(TS);
		}
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void BWTimeChange()
{
		if(GODNO%2 == 1)
		{
			BTIME.setText(Integer.toString(BTime1/10)+Integer.toString(BTime1%10) 
					+":"+Integer.toString(BTime2/10)+Integer.toString(BTime2%10)
					+":"+Integer.toString(BTime3/10)+Integer.toString(BTime3%10));	
			BTime3++;
			if(BTime3>59)
			{BTime3=0;BTime2++;
				if(BTime2>59)
				{BTime2=0;BTime1++;
					if(BTime1>23){BTime1=0;BTime2=0;BTime3=0;}	
				}	
			}
		}
		if(GODNO%2 == 0)
		{
			WTIME.setText(Integer.toString(WTime1/10)+Integer.toString(WTime1%10) 
					+":"+Integer.toString(WTime2/10)+Integer.toString(WTime2%10)
					+":"+Integer.toString(WTime3/10)+Integer.toString(WTime3%10));	
			WTime3++;
			if(WTime3>59)
			{WTime3=0;WTime2++;
				if(WTime2>59)
				{WTime2=0;WTime1++;
					if(WTime1>23)
					{WTime1=0;WTime2=0;WTime3=0;}	
				}	
			}
		}
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void TBTCordxyMouseListener()
		{
			if(XYONOFF==0)
			{XYONOFF=1;TEXTDIS(">>> GO CordXY On ...");}
			else
			{XYONOFF=0;TEXTDIS("<<< GO CordXY Off ...");	}
			GBDIS();
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		void TBTgonumberMouseListener()
		{
			NUMONOFF++;
			if(NUMONOFF > 2){NUMONOFF=0;}
			if(NUMONOFF == 0)
			{TEXTDIS(">>> Number Off ...");}
			if(NUMONOFF == 1)
			{TEXTDIS("<<< GO Number On ...");}
			if(NUMONOFF == 2)
			{TEXTDIS("<<< SN Number On ...");}
			GBDIS();
		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void NetConnection()
{
		    ConnectIP="";
		    ConnectPort="";

				jdialog.setLayout(new BorderLayout());
				jdialog.setModal(true);

				JPanel jpanel = new JPanel();
				jpanel.setLayout(new SpringLayout());
				SpringLayout jpanelLayout = (SpringLayout)jpanel.getLayout();
				
				JLabel jlIP = new JLabel("IP:");
				jlIP.setFont(new Font("Arial", Font.BOLD, 16));
				jlIP.setHorizontalTextPosition(JLabel.LEFT);
				jlIP.setVerticalTextPosition(JLabel.CENTER);
				jpanel.add(jlIP);
				SpringLayout.Constraints jlIP_spConstraints = jpanelLayout.getConstraints(jlIP);
				jlIP_spConstraints.setX(Spring.constant(5));
				jlIP_spConstraints.setY(Spring.constant(5));
				
				jtfIP= new JTextField("192.168.0.1",20);
				jtfIP.setPreferredSize(new Dimension(75, 25));
			    jpanel.add(jtfIP);
				SpringLayout.Constraints IPtext_spConstraints = jpanelLayout.getConstraints(jtfIP);
				IPtext_spConstraints.setX(Spring.constant(50));
				IPtext_spConstraints.setY(Spring.constant(5));
				
				JLabel jlPort= new JLabel("Port:");
				jlPort.setFont(new Font("Arial", Font.BOLD, 16));
				jlPort.setHorizontalTextPosition(JLabel.LEFT);
				jlPort.setVerticalTextPosition(JLabel.CENTER);
				jpanel.add(jlPort);
				SpringLayout.Constraints jlPort_spConstraints = jpanelLayout.getConstraints(jlPort);
				jlPort_spConstraints.setX(Spring.constant(5));
				jlPort_spConstraints.setY(Spring.constant(35));

				jtfPort= new JTextField("1234",20);
				jtfPort.setPreferredSize(new Dimension(75, 25));
			    jpanel.add(jtfPort);
				SpringLayout.Constraints jtfPort_spConstraints = jpanelLayout.getConstraints(jtfPort);
				jtfPort_spConstraints.setX(Spring.constant(50));
				jtfPort_spConstraints.setY(Spring.constant(35));

				JLabel jlICON = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/MilkyIcons6464_025.png")));
				jpanel.add(jlICON);
				SpringLayout.Constraints jlICON_spConstraints = jpanelLayout.getConstraints(jlICON);
				jlICON_spConstraints.setX(Spring.constant(300));
				jlICON_spConstraints.setY(Spring.constant(5));

			  JButton jbtnOK = new JButton("OK");
			  jbtnOK.setPreferredSize(new Dimension(75, 25));
			  jpanel.add(jbtnOK);
				SpringLayout.Constraints jbtnOK_spConstraints = jpanelLayout.getConstraints(jbtnOK);
				jbtnOK_spConstraints.setX(Spring.constant(50));
				jbtnOK_spConstraints.setY(Spring.constant(65));
			  jbtnOK.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) 
			    {
			    	
		   	if((jtfIP.getText().length() > 0) && (jtfPort.getText().length() > 0))
		   	{
		   	   	ConnectIP = jtfIP.getText();
		   	   	ConnectPort = jtfPort.getText();
		 		  NetConnectCheck = 1;
		   	}
			      jdialog.dispose();
			    }
			  });

			  JButton jbtnCancel = new JButton("Cancel");
			  jbtnCancel.setPreferredSize(new Dimension(75, 25));
			  jpanel.add(jbtnCancel);
				SpringLayout.Constraints jbtnCancel_spConstraints = jpanelLayout.getConstraints(jbtnCancel);
				jbtnCancel_spConstraints.setX(Spring.constant(150));
				jbtnCancel_spConstraints.setY(Spring.constant(65));
			  jbtnCancel.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			      jdialog.dispose();
			    }
			  });
			  
			  jdialog.add(jpanel, BorderLayout.CENTER);
			  jdialog.setSize(new Dimension(400,130));
			  Dimension dialogSize = jdialog.getSize();
			  jdialog.setLocation(this.getLocation().x+(this.getWidth() - dialogSize.width) / 2, this.getLocation().y+(this.getHeight() - dialogSize.height) / 2);	
			  jdialog.setTitle("Net Connect IP  _  Key in Connect Computer IP data");
			  jdialog.setResizable(false);
			  jdialog.setVisible(true);
}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
void TBTnetconnectdownMouseListener()
{
	PLAYTYPE = 3;
	NetConnection();

				if(NetConnectCheck == 1)
				{
			   	    String host;
			   	    int port;
			   	    host = ConnectIP;
			   	    port = Integer.parseInt(ConnectPort);

			   	    try 
			   	    {
			 	      ClientSocket = new Socket(InetAddress.getByName(host), port);
			 	      InetAddress addr = ClientSocket.getLocalAddress().getLocalHost() ;
			 	      // 取得用戶端Socket的IP位址、主機名稱等資訊
			 	      System.out.println("Client Information: ");
			 	      // 以Host Name/IP Address形式回傳主機名稱及IP位址資訊
			 	      System.out.println("  Local Host: " + ClientSocket.getLocalAddress().getLocalHost());
			 	      // 取得主機名稱
			 	      System.out.println("  Host Name : " + addr.getHostName());
			 	      // 取得IP位址
			 	      System.out.println("  IP address: " + addr.getHostAddress());
			 	      // 取得用戶端所使用的通訊埠
			 	      System.out.println("  Port      : " + ClientSocket.getLocalPort());
			 	      System.out.println();
			 	      // 取得伺服端Socket的IP位址、主機名稱等資訊
			 	      System.out.println("Connection to Remote: " + ClientSocket.getInetAddress().getHostAddress() + ":" + ClientSocket.getPort());
			 	      System.out.println();

			          TEXTDIS("主機:"+ InetAddress.getByName(host) + "  通訊埠:" + ConnectPort + " 連接成功 !!");
			          BPOWER = BPOWER+"_"+ ConnectIP +":"+ ConnectPort;
			          WPOWER = WPOWER+"_"+ addr.getHostAddress() +":"+ ClientSocket.getLocalPort();
			          ThisTextChange();

			     	    }
			     	    catch (UnknownHostException uhe) 
			     	    {
			     	      uhe.printStackTrace();
			     	    }
			     	    catch (IOException ioe) 
			     	    {
			     	      ioe.printStackTrace();
			     	    }
			   	    
				}
}	
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
		public void GoPlayDataTextSave()
		{

			int x=0;
			
			String GoPlayDataText="";
			
		    try {

		    	BufferedWriter writer = new BufferedWriter(
			         	  new FileWriter("D:/99999/" + GPDtxtName + "_" + Integer.toString(GOPLAYFILENO) + ".txt", true));
			      
			  	GoPlayDataText="";
			  	GoPlayDataText=
			  		"(;GN["+"GreenGO_V1_TestData" //GN[有意義的識別名稱.通常將相同GN的棋譜放在一起] 吳清源全集
			  		+"]DT["+GoStartTime //DT[對奕時間] 1962年
			  		+"]PC["+"TestPosition" //PC[對奕地點] 北京
			  		+"]PB["+"Computer" //PB[持黑棋者] 吳清源 
			  		+"]PW["+"Player" //PW[持白棋者] 汪雲峰
			  		+"]HA["+"PassNumber" //HA[讓子數] 吳受先
			  		+"]RE["+"Result" //RE[記錄最後對奕的結果] 共121手 黑中盤勝
			  		+"]US["+"GOjv.java" //US[記錄輸入棋譜的人或程式] 餘軍
			  		+"]SO["+"CHESS_GO"+"]" //SO[記錄此對奕資訊的來源] 飛揚圍棋網
			  		//+"AB"+"[pd]" //AB[pd][dp]增加黑子至盤面上(讓子)
			  		//+"AW"+"[dd]" //AW[dd][pp]增加白子至盤面上(讓子)
			  		+"AB"+"[NO]" //AB[pd][dp]增加黑子至盤面上(讓子)
			  		+"AW"+"[NO]" //AW[dd][pp]增加白子至盤面上(讓子)
			  		+";"
			  		;
			  	
			    writer.write(GoPlayDataText);
			    writer.newLine();
			
				for(x=1;x<=360;x++)
				{
				GoPlayDataText="";
				GoPlayDataText=
					";"+textBW[GOBW[x]]+"["+textXY[GOX[x]]+textXY[GOY[x]]+"]"
					+Integer.toString(x)+"_"
					+Integer.toString(GOBW[x])+","+
					Integer.toString(GOX[x])+","+
					Integer.toString(GOY[x])+","+
					Integer.toString(GOOUT[x]);

			        writer.write(GoPlayDataText);
			        writer.newLine();
				}
				
				GoPlayDataText="";
				GoPlayDataText=")";

			    writer.write(GoPlayDataText);
			    writer.newLine();
				writer.close();
			    } catch (IOException e) {
			    	  e.printStackTrace();
			    	  System.out.println(e);
			    }

		}
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
//888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
GreenGOjv() 
{
	super(JFrameString);
	Container cp = getContentPane();
	cp.setBackground(new Color(0,128,0));
	cp.setLayout(new BorderLayout());

	GOINIT();

	JPanel pMAIN = new JPanel();
	pMAIN.setPreferredSize(new Dimension(1830,1030));
	pMAIN.setLayout(new BorderLayout());
    pMAIN.setBackground(new Color(0,128,0));
	cp.add(pMAIN,BorderLayout.WEST);

	pBOARD pBOARD = new pBOARD();
	pBOARD.setPreferredSize(new Dimension(1030,1030));
	pBOARD.setLayout(new SpringLayout());
    SpringLayout pBOARDlayout = (SpringLayout)pBOARD.getLayout();
    pBOARD.setBackground(new Color(255,255,255,0));

	pDATA pDATA = new pDATA();
	pDATA.setPreferredSize(new Dimension(800,1030));
	pDATA.setLayout(new SpringLayout());
    SpringLayout pDATAlayout = (SpringLayout)pDATA.getLayout();
    pDATA.setBackground(new Color(0,0,0));     

    ClassLoader dcl = this.getClass().getClassLoader();
    Toolkit dtk = Toolkit.getDefaultToolkit();

	BGO = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/GB5151png.png")));
	BGO.setText("000");
	BGO.setForeground(Color.WHITE);
	BGO.setFont(new Font("Arial", Font.BOLD,24));
	BGO.setHorizontalTextPosition(JLabel.CENTER);
	BGO.setVerticalTextPosition(JLabel.CENTER);
	pDATA.add(BGO);
    SpringLayout.Constraints BWGOspConstraints = pDATAlayout.getConstraints(BGO);
    BWGOspConstraints.setX(Spring.constant(20));
    BWGOspConstraints.setY(Spring.constant(20));

	WGO = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/GW5151png.png")));
	WGO.setText("000");
	WGO.setForeground(Color.BLACK);
	WGO.setFont(new Font("Arial", Font.BOLD,24));
	WGO.setHorizontalTextPosition(JLabel.CENTER);
	WGO.setVerticalTextPosition(JLabel.CENTER);
	pDATA.add(WGO);
    SpringLayout.Constraints RspConstraints = pDATAlayout.getConstraints(WGO);
    RspConstraints = pDATAlayout.getConstraints(WGO);
    RspConstraints.setX(Spring.constant(20));
    RspConstraints.setY(Spring.constant(100));

    Bcapture = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/LBcaptureB2525pngG.png")));
    Boccupied = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/LBoccupied2525pngBG.png")));
    Wcapture = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/LBcaptureW2525pngG.png")));
    Woccupied = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/LBoccupied2525pngWG.png")));

	Bcapture.setText("000");Bcapture.setForeground(Color.YELLOW);
	Bcapture.setFont(new Font("Arial", Font.BOLD, 16));
	Bcapture.setHorizontalTextPosition(JLabel.CENTER);
	Bcapture.setVerticalTextPosition(JLabel.BOTTOM);
    pDATA.add(Bcapture);
    SpringLayout.Constraints Bcapture_spConstraints = pDATAlayout.getConstraints(Bcapture);
    Bcapture_spConstraints.setX(Spring.constant(220));
    Bcapture_spConstraints.setY(Spring.constant(20));
    
	Boccupied.setText("000");Boccupied.setForeground(Color.YELLOW);
	Boccupied.setFont(new Font("Arial", Font.BOLD, 16));
	Boccupied.setHorizontalTextPosition(JLabel.CENTER);
	Boccupied.setVerticalTextPosition(JLabel.BOTTOM);
    pDATA.add(Boccupied);
    SpringLayout.Constraints Boccupied_spConstraints = pDATAlayout.getConstraints(Boccupied);
    Boccupied_spConstraints.setX(Spring.constant(280));
    Boccupied_spConstraints.setY(Spring.constant(20));
    
	BTIME.setText("00:00:00");
	BTIME.setFont(new Font("Arial", Font.BOLD,16));
	BTIME.setHorizontalAlignment(JLabel.CENTER);
	BTIME.setVerticalAlignment(JLabel.CENTER);
	BTIME.setForeground(Color.GREEN);
	pDATA.add(BTIME);
    SpringLayout.Constraints BNspConstraints = pDATAlayout.getConstraints(BTIME);
    BNspConstraints.setX(Spring.constant(110));
    BNspConstraints.setY(Spring.constant(25));
	SBTIME.setText("00:00:00");
	SBTIME.setFont(new Font("Arial", Font.BOLD,16));
	SBTIME.setHorizontalAlignment(JLabel.CENTER);
	SBTIME.setVerticalAlignment(JLabel.CENTER);
	SBTIME.setForeground(Color.GREEN);
	pDATA.add(SBTIME);
    SpringLayout.Constraints SBNspConstraints = pDATAlayout.getConstraints(SBTIME);
    SBNspConstraints.setX(Spring.constant(110));
    SBNspConstraints.setY(Spring.constant(50));

	WTIME.setText("00:00:00");
	WTIME.setFont(new Font("Arial", Font.BOLD,16));
	WTIME.setHorizontalAlignment(JLabel.LEFT);
	WTIME.setVerticalAlignment(JLabel.CENTER);
	WTIME.setForeground(Color.GREEN);
	pDATA.add(WTIME);
    SpringLayout.Constraints WNspConstraints = pDATAlayout.getConstraints(WTIME);
    WNspConstraints.setX(Spring.constant(110));
    WNspConstraints.setY(Spring.constant(105));

	SWTIME.setText("00:00:00");
	SWTIME.setFont(new Font("Arial", Font.BOLD,16));
	SWTIME.setHorizontalAlignment(JLabel.LEFT);
	SWTIME.setVerticalAlignment(JLabel.CENTER);
	SWTIME.setForeground(Color.GREEN);
	pDATA.add(SWTIME);
    SpringLayout.Constraints SWNspConstraints = pDATAlayout.getConstraints(SWTIME);
    SWNspConstraints.setX(Spring.constant(110));
    SWNspConstraints.setY(Spring.constant(130));
    
	Wcapture.setText("000");Wcapture.setForeground(Color.YELLOW);
	Wcapture.setFont(new Font("Arial", Font.BOLD, 16));
	Wcapture.setHorizontalTextPosition(JLabel.CENTER);
	Wcapture.setVerticalTextPosition(JLabel.BOTTOM);
    pDATA.add(Wcapture);
    SpringLayout.Constraints Wcapture_spConstraints = pDATAlayout.getConstraints(Wcapture);
    Wcapture_spConstraints.setX(Spring.constant(220));
    Wcapture_spConstraints.setY(Spring.constant(100));
	Woccupied.setText("000");Woccupied.setForeground(Color.YELLOW);
	Woccupied.setFont(new Font("Arial", Font.BOLD, 16));
	Woccupied.setHorizontalTextPosition(JLabel.CENTER);
	Woccupied.setVerticalTextPosition(JLabel.BOTTOM);
    pDATA.add(Woccupied);
    SpringLayout.Constraints Woccupied_spConstraints = pDATAlayout.getConstraints(Woccupied);
    Woccupied_spConstraints.setX(Spring.constant(280));
    Woccupied_spConstraints.setY(Spring.constant(100));

    int GDDx=10; int GDDy=200;

    GODOWNDATA[0] = new JLabel();
    GODOWNDATA[0].setText("");
    GODOWNDATA[0].setForeground(Color.GREEN);
    GODOWNDATA[0].setFont(new Font("Arial", Font.PLAIN, 12));
    GODOWNDATA[0].setHorizontalAlignment(JLabel.LEFT);
    GODOWNDATA[0].setVerticalAlignment(JLabel.TOP);
    pDATA.add(GODOWNDATA[0]);
    SpringLayout.Constraints GODOWNDATA_spConstraints = pDATAlayout.getConstraints(GODOWNDATA[0]);
    GODOWNDATA_spConstraints.setX(Spring.constant(GDDx));GODOWNDATA_spConstraints.setY(Spring.constant(GDDy));
    for(int Mx=1;Mx<GDDnum;Mx++)//GDDnum = 50
    {
    	GODOWNDATA[Mx] = new JLabel();
    	GODOWNDATA[Mx].setText("");
    	GODOWNDATA[Mx].setForeground(Color.GREEN);
    	GODOWNDATA[Mx].setFont(new Font("Arial", Font.PLAIN, 12));
    	GODOWNDATA[Mx].setHorizontalAlignment(JLabel.LEFT); 
    	GODOWNDATA[Mx].setVerticalAlignment(JLabel.TOP);
    	pDATA.add(GODOWNDATA[Mx]);
    	GODOWNDATA_spConstraints = pDATAlayout.getConstraints(GODOWNDATA[Mx]);
    	GODOWNDATA_spConstraints.setX(Spring.constant(GDDx));
    	GODOWNDATA_spConstraints.setY(Spring.constant(GDDy+=15));
    }

    int TXTx=420; int TXTy=10;
    
    TEXTDATA[0] = new JLabel();
    TEXTDATA[0].setText("");
    TEXTDATA[0].setForeground(Color.GREEN);
    TEXTDATA[0].setFont(new Font("Arial", Font.PLAIN, 12));
    TEXTDATA[0].setHorizontalAlignment(JLabel.LEFT);
    TEXTDATA[0].setVerticalAlignment(JLabel.TOP);
    pDATA.add(TEXTDATA[0]);
    SpringLayout.Constraints TEXTDATA_spConstraints = pDATAlayout.getConstraints(TEXTDATA[0]);
    TEXTDATA_spConstraints.setX(Spring.constant(TXTx));TEXTDATA_spConstraints.setY(Spring.constant(TXTy));
    for(int Mx=1;Mx<TXTnum;Mx++)
    {
    	TEXTDATA[Mx] = new JLabel();
    	TEXTDATA[Mx].setText("");
    	TEXTDATA[Mx].setForeground(Color.GREEN);
    	TEXTDATA[Mx].setFont(new Font("Arial", Font.PLAIN, 12));
    	TEXTDATA[Mx].setHorizontalAlignment(JLabel.LEFT); 
    	TEXTDATA[Mx].setVerticalAlignment(JLabel.TOP);
    	pDATA.add(TEXTDATA[Mx]);
    	TEXTDATA_spConstraints = pDATAlayout.getConstraints(TEXTDATA[Mx]);
    	TEXTDATA_spConstraints.setX(Spring.constant(TXTx));
    	TEXTDATA_spConstraints.setY(Spring.constant(TXTy+=15));
    }

    srRead = new JLabel();
    srRead.setText("Read");
    srRead.setForeground(Color.YELLOW);
    srRead.setFont(new Font("Arial", Font.BOLD, 12));
    srRead.setHorizontalAlignment(JLabel.LEFT);
    srRead.setVerticalAlignment(JLabel.TOP);
    pDATA.add(srRead);
    SpringLayout.Constraints srRead_spConstraints = pDATAlayout.getConstraints(srRead);
    srRead_spConstraints.setX(Spring.constant(365));srRead_spConstraints.setY(Spring.constant(800));
    
    srIn = new JLabel();
    srIn.setText("In");
    srIn.setForeground(Color.YELLOW);
    srIn.setFont(new Font("Arial", Font.BOLD, 12));
    srIn.setHorizontalAlignment(JLabel.LEFT);
    srIn.setVerticalAlignment(JLabel.TOP);
    pDATA.add(srIn);
    SpringLayout.Constraints srIn_spConstraints = pDATAlayout.getConstraints(srIn);
    srIn_spConstraints.setX(Spring.constant(365));srIn_spConstraints.setY(Spring.constant(820));
    
    srWrite = new JLabel();
    srWrite.setText("Write");
    srWrite.setForeground(Color.YELLOW);
    srWrite.setFont(new Font("Arial", Font.BOLD, 12));
    srWrite.setHorizontalAlignment(JLabel.LEFT);
    srWrite.setVerticalAlignment(JLabel.TOP);
    pDATA.add(srWrite);
    SpringLayout.Constraints srWrite_spConstraints = pDATAlayout.getConstraints(srWrite);
    srWrite_spConstraints.setX(Spring.constant(365));srWrite_spConstraints.setY(Spring.constant(840));
    
    srOut = new JLabel();
    srOut.setText("Out");
    srOut.setForeground(Color.YELLOW);
    srOut.setFont(new Font("Arial", Font.BOLD, 12));
    srOut.setHorizontalAlignment(JLabel.LEFT);
    srOut.setVerticalAlignment(JLabel.TOP);
    pDATA.add(srOut);
    SpringLayout.Constraints srOut_spConstraints = pDATAlayout.getConstraints(srOut);
    srOut_spConstraints.setX(Spring.constant(365));srOut_spConstraints.setY(Spring.constant(860));

    GX=0; GY=0;
	GBlabel = new JLabel(new ImageIcon((Image)GOBOARD)) 
	{
        protected void paintComponent(Graphics g) 
        {
           super.paintComponent(g);
           Graphics2D g2d = (Graphics2D) g;
           if(PLAYTYPE == 0)
           {
        	   g2d.drawImage((Image)GOBOARDimage.getImage(),0,0,null);
           }
           else
           {
        	   g2d.drawImage((Image)JLimage,0,0, null);
           }
        }
     };
     GBlabel.addMouseListener ( new MouseAdapter ()
     {
         public void mousePressed ( MouseEvent e )
         {
        	 if(PLAYTYPE == 1)
        	 {
        	 if(GODNO%2 == 0)
        	 {
         		int GBMX = e.getX();int GBMY = e.getY();
        	 	int GBGDX = (GBMX-15)/GOW+1;
        	 	int GBGDY = (GBMY-15)/GOH+1;
        	 	if(BDBW[GBGDX][GBGDY] == 0)
        	 	{
        	 		BDBW[GBGDX][GBGDY]=2;//電腦下子
        	 		BDGN[GBGDX][GBGDY] = GODNO;
        	 		
            	 	GBDIS();
            	 	TEXTDIS("People -> "
                         +Integer.toString(GBMX)+"_"+Integer.toString(GBGDX)+" , "
                         +Integer.toString(GBMY)+"_"+Integer.toString(GBGDY)+" , "
                         +Integer.toString(GODNO));
        		 	GODNO++;
        	 	}
        	 }
        	 if(GODNO%2 == 1)
        	 {
        		 GOcomputerdown();
        	 }
        	 }
         }
     } );
     //-------------------------------------------------------------------------------------------------
   	pBOARD.add(GBlabel,BorderLayout.CENTER);
	pMAIN.add(pBOARD,BorderLayout.WEST);
	pDATA.setBackground(new Color(0,128,0));
	pMAIN.add(pDATA,BorderLayout.EAST);

	open = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/open4040png.png")));
	open.setBorder(null);pDATA.add(open);
	open.setBackground(new Color(255,255,255,0));     
	SpringLayout.Constraints TBCS = pDATAlayout.getConstraints(open);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(15)));
	open.setToolTipText("Open");
	open.setEnabled(true);
	open.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {System.out.println(evt.toString());if(evt.getSource().equals(open)){TBTopengoMouseListener();}	}
       				}
       		);	      

	save = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/save.png")));
	save.setBorder(null);pDATA.add(save);
	save.setBackground(new Color(255,255,255,0));     
	TBCS = pDATAlayout.getConstraints(save);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(60)));
	save.setToolTipText("Save");
	save.setEnabled(true);
	save.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {System.out.println(evt.toString());	if(evt.getSource().equals(save)){TBTsavegoMouseListener();}}
       				}
       		);	      

	gonumber = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/gonumber4040png.png")));
	gonumber.setBorder(null);pDATA.add(gonumber);
	gonumber.setBackground(new Color(255,255,255,0));     
	TBCS = pDATAlayout.getConstraints(gonumber);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(105)));
	gonumber.setToolTipText("GoNumber");
	gonumber.setEnabled(true);
	gonumber.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {
   	System.out.println(evt.toString());	if(evt.getSource().equals(gonumber)){TBTgonumberMouseListener();}	
  	          }
       				}
       		);	      

	cordxy = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/Cordxy4040png.png")));
	cordxy.setBorder(null);pDATA.add(cordxy);
	cordxy.setBackground(new Color(255,255,255,0));     
	TBCS = pDATAlayout.getConstraints(cordxy);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(150)));
	cordxy.setToolTipText("CordXY");
	cordxy.setEnabled(true);
	cordxy.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {
   	System.out.println(evt.toString());	if(evt.getSource().equals(cordxy)){TBTCordxyMouseListener();}	
  	          }
       				}
       		);	      

	option = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/option4040png.png")));
	option.setBorder(null);pDATA.add(option);
	option.setBackground(new Color(255,255,255,0));     
	TBCS = pDATAlayout.getConstraints(option);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(195)));
	option.setToolTipText("Opiton");
	option.setEnabled(true);
	option.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {
   	System.out.println(evt.toString());	if(evt.getSource().equals(option)){TBTopengoMouseListener();}	
  	          }
       				}
       		);	      

	help = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/help4040png.png")));
	help.setBorder(null);pDATA.add(help);
	help.setBackground(new Color(255,255,255,0));     
	TBCS = pDATAlayout.getConstraints(help);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(240)));
	help.setToolTipText("Help");
	help.setEnabled(true);
	help.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {
   	System.out.println(evt.toString());	if(evt.getSource().equals(help)){TBTopengoMouseListener();}	
  	          }
       				}
       		);	      

	exit = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/exit4040png.png")));
	exit.setBorder(null);pDATA.add(exit);
	exit.setBackground(new Color(255,255,255,0));     
	TBCS = pDATAlayout.getConstraints(exit);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(900)));
	exit.setToolTipText("Exit");
	exit.setEnabled(true);
	exit.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {
   	System.out.println(evt.toString());	if(evt.getSource().equals(exit)){TBTexitMouseListener();}	
  	          }
       				}
       		);	      

	netconnection = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/NetConnection4040png.png")));
	netconnection.setBorder(null);pDATA.add(netconnection);
	netconnection.setBackground(new Color(255,255,255,0));     
	TBCS = pDATAlayout.getConstraints(netconnection);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(330)));
	netconnection.setToolTipText("Net Connection");
	netconnection.setEnabled(true);
	netconnection.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {
   	System.out.println(evt.toString());	if(evt.getSource().equals(netconnection)){TBTnetconnectdownMouseListener();}	
  	          }
       				}
       		);	      

	orderdown = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/OrderDown4040png.png")));
	orderdown.setBorder(null);pDATA.add(orderdown);
	orderdown.setBackground(new Color(255,255,255,0));     
	TBCS = pDATAlayout.getConstraints(orderdown);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(375)));
	orderdown.setToolTipText("Order Down");
	orderdown.setEnabled(true);
	orderdown.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {
   	System.out.println(evt.toString());	if(evt.getSource().equals(orderdown)){TBTorderdownMouseListener();}	
  	          }
       				}
       		);	      

	peoplecomputer = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/step4040png.png")));
	peoplecomputer.setBorder(null);pDATA.add(peoplecomputer);
	peoplecomputer.setBackground(new Color(255,255,255,0));     
	TBCS = pDATAlayout.getConstraints(peoplecomputer);
	TBCS.setX(Spring.constant(Integer.valueOf(365)));
	TBCS.setY(Spring.constant(Integer.valueOf(420)));
	peoplecomputer.setToolTipText("People Computer");
	peoplecomputer.setEnabled(true);
	peoplecomputer.addMouseListener(
   				new java.awt.event.MouseAdapter() 
       				{
  	          public void mouseClicked(java.awt.event.MouseEvent evt) 
  	          {
   	System.out.println(evt.toString());	if(evt.getSource().equals(peoplecomputer)){TBTpeoplecomputerMouseListener();}	
  	          }
       				}
       		);	      

	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setSize(new Dimension(screenSize.width,1060));
	setIconImage(Toolkit.getDefaultToolkit().getImage("data\\GOicon3232.GIF"));
    setLocation(0,0);
    setResizable(false);         
	setVisible(true);
	
	PLAYTYPE = -1;
	MainForm_Load();		
}
//--------------------------------------------------------------------------------

	public static void main(String args[]) {
		//------------------------------------------------------------------------    
	    UIManager.put("swing.boldMetal", Boolean.FALSE);
	    JDialog.setDefaultLookAndFeelDecorated(true);
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    Toolkit.getDefaultToolkit().setDynamicLayout(true);
	    try {
		    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	//------------------------------------------------------------------------    
		//宣告視窗框架物件
		new GreenGOjv();
	}
}
//--------------------------------------------------------------------------------
