import java.awt.Graphics;
import java.awt.Color;
import java.lang.Object;

import javax.swing.JComponent;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class Board extends JComponent
{
    public static Coord coord_houses [] = new Coord [22];
    public Board(){
        
    }

    public void paintComponent( Graphics g )
    {

        super.paintComponent( g );
        g.setColor( new Color( 204, 213, 255 ) );
        g.fillRect( 15, 25, 640, 640 );
        g.setColor( new Color( 0, 0, 0 ) );

        //Draw Row 1 property boxes
        for(int i=0; i<11; i++)
            g.drawRect( 15, i*58+25 , 45+13, 45+13 );
        //Draw Row 2 property boxes
        for(int i=0; i<11; i++)
            g.drawRect( i*58+15, 605, 45+13, 45+13 );
        //Draw Row 3 property boxes
        for(int i=0; i<11; i++)
            g.drawRect( i*58+15, 25, 45+13, 45+13 );            
        //Draw Row 4 property boxes
        for(int i=0; i<11; i++)
            g.drawRect( 595, i*58+25 , 45+13, 45+13 );





        g.setColor( new Color( 237, 27, 36 ) );
        g.fillRect( 45+13+16, 55+13 , 57, 15 );
        g.fillRect( 45+13+16+58*2, 55+13 , 57, 15 );
        g.fillRect( 45+13+16+58*3, 55+13 , 57, 15 );
        

        g.setColor( new Color( 254, 242, 0 ) );
        g.fillRect( 45+13+16+58*5, 55+13 , 57, 15 );
        g.fillRect( 45+13+16+58*8, 55+13 , 57, 15 );
        g.fillRect( 45+13+16+58*6, 55+13 , 57, 15 );


        g.setColor( new Color( 31, 178, 90 ) );
        g.fillRect( 45+13+16+58*9, 84 , 15, 57 );
        g.fillRect( 45+13+16+58*9, 84+58*1 , 15, 57 );
        g.fillRect( 45+13+16+58*9, 84+58*3 , 15, 57 );

        g.setColor( new Color( 0, 114, 187 ) );
        g.fillRect( 45+13+16+58*9, 84+58*8 , 15, 57 );
        g.fillRect( 45+13+16+58*9, 84+58*6 , 15, 57 );



        
        g.setColor( new Color( 149, 84, 54 ) );
        g.fillRect( 45+13+16+58*6, 84+58*9 , 57, 15 );
        g.fillRect( 45+13+16+58*8, 84+58*9 , 57, 15 );



        
        
        g.setColor( new Color( 170, 250, 250 ) );
        g.fillRect( 45+13+16+58*3, 84+58*9 , 57, 15 );
        g.fillRect( 45+13+16+58, 84+58*9 , 57, 15 );
        g.fillRect( 45+13+16, 84+58*9, 57, 15 );





        
        g.setColor( new Color( 217, 58, 150 ) );
        g.fillRect( 58, 84+58*8 , 15, 57 );
        g.fillRect( 58, 84+58*5 , 15, 57 );
        g.fillRect( 58, 84+58*6 , 15, 57 );




        
        g.setColor( new Color( 247, 148, 29 ) );
        g.fillRect( 58, 84 , 15, 57 );
        g.fillRect( 58, 84+58*1 , 15, 57 );
        g.fillRect( 58, 84+58*3 , 15, 57 );



        //first row

        coord_houses[0]=new Coord(540, 610);


        coord_houses[1]=new Coord(540-116, 610);

       
        coord_houses[2]=new Coord(540-116-116-58, 610);
        

        coord_houses[3]=new Coord(540-116-116-58-116, 610);
        

        coord_houses[4]=new Coord(540-116-116-58-116-58, 610);
       

        //second row
        coord_houses[5]=new Coord(60, 550);
        

        coord_houses[6]=new Coord(60, 550-116);
        

        coord_houses[7]=new Coord(60, 550-116-58);
        

        coord_houses[8]=new Coord(60, 550-116-58-116);
        

        coord_houses[9]=new Coord(60, 550-116-58-116-116);
        

        coord_houses[10]=new Coord(60, 550-116-58-116-116-58);
        



        //third row

        coord_houses[11]=new Coord(75, 70);
        

        coord_houses[12]=new Coord( 75+116, 70);
       

        coord_houses[13]=new Coord( 75+58+116, 70);
       


        coord_houses[14]=new Coord( 75+58+116+116, 70);
       

        coord_houses[15]=new Coord( 75+58+116+116+58, 70);
     

        coord_houses[16]=new Coord( 75+58+116+116+58+116, 70);



        //fourth row

        coord_houses[17]=new Coord( 598, 86);
  


        coord_houses[18]=new Coord( 598, 86+58);
 


        coord_houses[19]=new Coord( 598, 86+58+116);



        coord_houses[20]=new Coord( 598, 86+58+116+116+58);



        coord_houses[21]=new Coord( 598, 86+58+116+116+58+116);


        g.setColor( new Color( 0, 250, 0 ) );
        for(int i=0; i<22; i++)
        {
        g.drawRect(coord_houses[i].x,coord_houses[i].y,8,8);
        g.fillRect(coord_houses[i].x,coord_houses[i].y,8,8);
        }


        g.setColor( new Color( 0, 0, 0 ) );
        g.setFont(new Font("Arial", Font.BOLD, 10));

        //third row
        g.drawString("Free P", 22, 65);
        g.drawString(  "Train" ,13+16+58*5, 65 );
        g.drawString(  "$200" ,13+16+58*5, 75 );
        g.drawString(  "?" ,13+16+58*2, 65 );
        g.drawString(  "Kentucky" ,55+16+10, 45 );
        g.drawString(  "Avenue" ,55+16+10, 55 );
        g.drawString(  "$220" ,55+16+10, 65 );

        g.drawString(  "Indiana" ,55+16+10+58+58, 45 );
        g.drawString(  "Avenue" ,55+16+10+58+58, 55 );
        g.drawString(  "$220" ,55+16+10+58+58, 65 );


        g.drawString(  "Illinoise" ,55+16+10+58+58+58, 45 );
        g.drawString(  "Avenue" ,55+16+10+58+58+58, 55 );
        g.drawString(  "$240" ,55+16+10+58+58+58, 65 );

        g.drawString(  "Atlantic" ,55+16+10+58+58+58+58+58, 45 );
        g.drawString(  "Avenue" ,55+16+10+58+58+58+58+58, 55 );
        g.drawString(  "$260" ,55+16+10+58+58+58+58+58, 65 );

        g.drawString(  "Ventnor" ,55+16+10+58+58+58+58+58+58, 45 );
        g.drawString(  "Avenue" ,55+16+10+58+58+58+58+58+58, 55 );
        g.drawString(  "$260" ,55+16+10+58+58+58+58+58+58, 65 );

        g.drawString(  "Marvin" ,55+16+10+58+58+58+58+58+58+58+58, 45 );
        g.drawString(  "Avenue" ,55+16+10+58+58+58+58+58+58+58+58, 55 );
        g.drawString(  "$280" ,55+16+10+58+58+58+58+58+58+58+58, 65 );


        g.drawString(  "Water" ,13+16+58*8, 65 );
        g.drawString(  "$150" ,13+16+58*8, 75 );
        g.drawString(  "To Jail" ,13+16+58*10, 65 );



        //first row
        g.drawString(  "<-GO" ,13+16+58*10, 65+58*10 );
        g.drawString(  "chest" ,13+16+58*8, 65+58*10 );
        g.drawString(  "tax" ,13+16+58*6, 65+58*10 );
        g.drawString(  "$200" ,13+16+58*6, 75+58*10 );
        g.drawString(  "Train" ,13+16+58*5, 65+58*10 );
        g.drawString(  "$200" ,13+16+58*5, 75+58*10 );
        g.drawString(  "?" ,13+16+58*3, 65+58*10 );
        g.drawString(  "Jail" ,13+16, 65+58*10 );

        g.drawString(  "Mediter-" ,20+58*9, 50+58*10 );
        g.drawString(  "ranean" ,20+58*9, 60+58*10 );
        g.drawString(  "Avenue" ,20+58*9, 70+58*10 );
        g.drawString(  "$60" ,20+58*9, 80+58*10 );

        g.drawString(  "Baltic" ,20+58*7, 60+58*10 );
        g.drawString(  "Avenue" ,20+58*7, 70+58*10 );
        g.drawString(  "$60" ,20+58*7, 80+58*10 );

        g.drawString(  "Oriental" ,20+58*4, 60+58*10 );
        g.drawString(  "Avenue" ,20+58*4, 70+58*10 );
        g.drawString(  "$100" ,20+58*4, 80+58*10 );

        g.drawString(  "Vermont" ,20+58*2, 60+58*10 );
        g.drawString(  "Avenue" ,20+58*2, 70+58*10 );
        g.drawString(  "$100" ,20+58*2, 80+58*10 );

        g.drawString(  "Connecti-" ,20+58*1, 50+58*10 );
        g.drawString(  "cut" ,20+58*1, 60+58*10 );
        g.drawString(  "Avenue" ,20+58*1, 70+58*10 );
        g.drawString(  "$120" ,20+58*1, 80+58*10 );


        //second row
        g.drawString("Chest", 22, 65+58*3);
        g.drawString("Train", 22, 65+58*5);
        g.drawString("$200", 22, 75+58*5);

        g.drawString("Eletric", 22, 65+58*8);
        g.drawString("$150", 22, 75+58*8);


        g.drawString("St.", 22, 65+58*9-20);
        g.drawString("Charles", 22, 65+58*9-10);
        g.drawString("Place", 22, 65+58*9);
        g.drawString("$140", 22, 65+58*9+10);


        g.drawString("States", 22, 65+58*7-10);
        g.drawString("Avenue", 22, 65+58*7);
        g.drawString("$140", 22, 65+58*7+10);


        g.drawString("Virginia", 22, 65+58*6-10);
        g.drawString("Avenue", 22, 65+58*6);
        g.drawString("$160", 22, 65+58*6+10);

        g.drawString("St.James", 22, 65+58*4-10);
        g.drawString("Place", 22, 65+58*4);
        g.drawString("$180", 22, 65+58*4+10);

        g.drawString("Tenne-", 22, 65+58*2-20);
        g.drawString("ssee", 22, 65+58*2-10);
        g.drawString("Avenue", 22, 65+58*2);
        g.drawString("$180", 22, 65+58*2+10);

        g.drawString("New", 22, 65+58*1-20);
        g.drawString("York", 22, 65+58*1-10);
        g.drawString("Avenue", 22, 65+58*1);
        g.drawString("$200", 22, 65+58*1+10);


        //fourth row
        g.drawString(  "Chest" ,13+16+58*10, 65+58*3 );
        g.drawString(  "Train" ,13+16+58*10, 65+58*5 );
        g.drawString(  "$200" ,13+16+58*10, 75+58*5 );
        g.drawString(  "?" ,13+16+58*10, 65+58*6 );
        g.drawString(  "Tax" ,13+16+58*10, 65+58*8 );
        g.drawString(  "$100" ,13+16+58*10, 75+58*8 );

        g.drawString(  "Pacific" ,13+16+58*10+5, 65+58*1-10 );
        g.drawString(  "Avenue" ,13+16+58*10+5, 65+58*1 );
        g.drawString(  "$300" ,13+16+58*10+5, 65+58*1+10 );

        g.drawString(  "North" ,13+16+58*10+5, 65+58*2-20 );
        g.drawString(  "Carolina" ,13+16+58*10+5, 65+58*2-10 );
        g.drawString(  "Avenue" ,13+16+58*10+5, 65+58*2 );
        g.drawString(  "$300" ,13+16+58*10+5, 65+58*2+10 );

        g.drawString(  "Penssyl-" ,13+16+58*10+2, 65+58*4-20 );
        g.drawString(  "vania" ,13+16+58*10+5, 65+58*4-10 );
        g.drawString(  "Avenue" ,13+16+58*10+5, 65+58*4 );
        g.drawString(  "$320" ,13+16+58*10+5, 65+58*4+10 );

        g.drawString(  "Park" ,13+16+58*10+5, 65+58*7-10 );
        g.drawString(  "Place" ,13+16+58*10+5, 65+58*7 );
        g.drawString(  "$350" ,13+16+58*10+5, 65+58*7+10 );

        g.drawString(  "Board-" ,13+16+58*10+5, 65+58*9-10 );
        g.drawString(  "walk" ,13+16+58*10+5, 65+58*9 );
        g.drawString(  "$400" ,13+16+58*10+5, 65+58*9+10 );
 






        
    }


}
