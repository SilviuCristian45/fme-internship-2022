/*______________________________________________________________________________________________________
 * 
 * Write a Java program that reads a file containing on each line a geometric shape and its properties
 * in the following format:
 * 
 * Name : property1=value, property2=value, …
 * 
 * Shapes are limited to Circle, Square, Rectangle, Triangle.
 * 
 * Create 2 files area.out and perimeter.out, respectively, and write all the shapes
 * 
 *  - In area.out: in descending order by their area, in the format:
 *      Name: { property1=value, property2=value, ... , area = value }
 *      
 *  - In perimeter.out: in ascending order by their perimeter/circumference, in the format:
 *      Name: { property1=value, property2=value, ... , area = value }
 * 
 * Formulas:
 * 
 *  |===========|===============================|=======================|
 *  |Shape      |Area                           |Perimeter/Circumference|
 *  |===========|===============================|=======================|
 *  |Circle     |PI*r^2                         |2*PI*r                 |
 *  |===========|===============================|=======================|
 *  |Square     |length^2                       |4*length               |
 *  |===========|===============================|=======================|
 *  |Rectangle  |length*width                   |2*(length+width)       |         
 *  |===========|===============================|=======================|
 *  |Triangle   |sqrt(s*(s-a)*(s-b)*s(s-c))     |a+b+c                  |
 *  |           |   where s = (a+b+c)/2         |                       |
 *  |===========|===============================|=======================|
 * _____________________________________________________________________________________________________
 * 
 * 
 * Example:
 * 
 *______________________________________________________________________________________________________
 *
 *  Input: 
 *  
 *  shapes.in
 *      
 *      Circle : r=2
 *      Square : length=4
 *      Rectangle : length=3, width=4
 *      Circle : r=3
 *      Square : length=5
 *      Square : length=3
 *      Triangle: a=3, b=4, c=5
 *       
 *  Output:
 *  
 *  area.out
 *      
 *      Circle: { r=3, area=28.27 }
 *      Square: { length=5, area=25 }
 *      Square: { length=4, area=16 }
 *      Circle: { r=2, area=12.56 }
 *      Rectangle: { length=3, width=4, area=12 }
 *      Square: { length=3, area=9 }
 *      Triangle: { a=3, b=4, c=5, area=6 }
 *      
 *  perimeter.out
 *  
 *      Square: { length=3, perimeter=12 }
 *      Triangle: { a=3, b=4, c=5, perimeter=12 }
 *      Circle: { r=2, perimeter=12.56 }
 *      Rectangle: { length=3, width=4, perimeter=14 }
 *      Square: { length=4, perimeter=16 }
 *      Circle: { r=3, perimeter=18.84 }
 *      Square: { length=4, perimeter=20 }   
 *       
 *______________________________________________________________________________________________________
 *
 *______________________________________________________________________________________________________ 
 */

package fme.internship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author <full name>
 * @email <email address>
 * 
 */


public class Test3 {
    abstract  class Shape{
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    class  Square extends Shape{
        float length;

    }

    class Rectangle extends Shape{
        float length,width;
    }

    class Circle extends Shape{
        float r;
    }

    class Triangle extends Shape{
        float a,b,c;
    }
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            File file=new File("fme/internship/shapes.in");    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
            }
            fr.close();    //closes the stream and release the resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}