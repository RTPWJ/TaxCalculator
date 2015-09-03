/*
Name: Alexander Georgiadis (RezTech)
Date Started: 9/2/2015
Date Last Edited: 9/2/2015
Description: A simple tax calculator at the Ontario tax rate (13%)
*/

import java.awt.*;
import hsa.Console;

public class TaxCalculator_Educational
{
    static Console c;

    //Variables
    static int itemCount;

    //Array
    static double itemArray[];

    public static void main (String[] args)
    {
        c = new Console ();
        getItemCount ();
        getItemprice ();
        printTaxes ();
    }


    public static void getItemCount ()
    {
        //Prompt
        c.println ("Welcome! Please enter how many items you will be purchasing today, then press the <Enter> key to continue.");
        itemCount = c.readInt ();

        //Create aray
        itemArray = new double [itemCount];

        //Clear Console
        c.clear ();
    }


    public static void getItemprice ()
    {
        //Initial Prompt
        c.println ("Okay, how much does your first item cost? (Use the following format: 1.20)");
        itemArray [0] = c.readDouble (); //Remember, arrays always start at the number 0, and are always one less then what you declare them to be. This can be solved by adding 1 to the array, if you wish

        c.clear ();

        //Repeted Prompt
        for (int i = 1 ; i <= (itemCount - 2) ; i++) //Subtract two, as one spot is for the first item, and one spot is for the last
        {
            c.println ("Okay, now how much does the next item cost?");
            itemArray [i] = c.readDouble ();
            c.clear ();
        }

        //Final Prompt
        if (itemCount != 1) //If the item count is equal to one, there is only one item will be entered, therefor, the first item is the last, and having it repeated a seccond time will cause an array overflow
        {
            c.println ("Okay, now how much does the last item cost?");
            itemArray [itemCount - 1] = c.readDouble (); //Subreating one at this point is required to prevent an array overflow, because the itemCount as a int != itemCount array size
        }
    }


    public static void printTaxes ()
    {
        //Variables
        double total = 0;
        
        //Multiply Item Total By 1.13
        for (int i = 0; i <= (itemCount - 1); i++)
        {
        total = total + itemArray [i];
        }
        
        //Muliplication
        total = total * 1.13;
        
        c.print("Your total is $"); //c.print is better to use here, as it allows the next line to be printed on the same line as this String
        c.print(total, 0, 2);
        c.println(".");
    }
}
