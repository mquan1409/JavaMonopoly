import java.awt.Graphics;
import java.awt.Color;
import java.lang.Object;

import javax.swing.JComponent;
import javax.swing.border.CompoundBorder;

public class Board extends JComponent
{
    public Board(){
        
    }

    public void paintComponent( Graphics g )
    {

        super.paintComponent( g );
        g.setColor( new Color( 204, 213, 255 ) );
        g.fillRect( 15, 25, 495, 495 );
        g.setColor( new Color( 0, 0, 0 ) );

        //Draw Row 1 property boxes
        for(int i=0; i<11; i++)
            g.drawRect( 15, i*45+25 , 45, 45 );
        //Draw Row 2 property boxes
        for(int i=0; i<11; i++)
            g.drawRect( i*45+15, 475, 45, 45 );
        //Draw Row 3 property boxes
        for(int i=0; i<11; i++)
            g.drawRect( i*45+15, 25, 45, 45 );            
        //Draw Row 4 property boxes
        for(int i=0; i<11; i++)
            g.drawRect( 465, i*45+25 , 45, 45 );

        g.drawString("Free P", 22, 65);
        g.drawString(  "Train" ,55+16+45*4, 65 );
        g.drawString(  "?" ,55+16+45*1, 65 );
        g.drawString(  "Water" ,55+16+45*7, 65 );
        g.drawString(  "To Jail" ,55+10+45*9, 65 );
        g.drawString(  "<-GO" ,55+10+45*9, 515 );
        g.drawString(  "chest" ,70+45*7, 515 );
        g.drawString(  "tax" ,70+45*5, 515 );
        g.drawString(  "Train" ,70+45*4, 515 );
        g.drawString(  "?" ,70+45*2, 515 );
        g.drawString(  "Jail" ,25, 515 );
        g.drawString("Chest", 22, 65+45*3);
        g.drawString("Train", 22, 65+45*5);
        g.drawString("Eletric", 22, 65+45*8);
        g.drawString(  "Chest" ,55+10+45*9, 65+45*3 );
        g.drawString(  "Train" ,55+10+45*9, 65+45*5 );
        g.drawString(  "?" ,55+10+45*9, 65+45*6 );
        g.drawString(  "Tax" ,55+10+45*9, 65+45*8 );





        g.setColor( new Color( 237, 27, 36 ) );
        g.fillRect( 45+16, 55 , 44, 15 );
        g.fillRect( 45+16+45*2, 55 , 44, 15 );
        g.fillRect( 45+16+45*3, 55 , 44, 15 );

        g.setColor( new Color( 0, 250, 0 ) );
        g.fillRect( 45+20, 57 , 7, 9 );
        g.fillRect( 45+20+10, 57 , 7, 9 );
        g.fillRect( 45+20+20, 57 , 7, 9 );
        g.fillRect( 45+20+30, 57 , 7, 9 );
        

        g.setColor( new Color( 254, 242, 0 ) );
        g.fillRect( 45+16+45*5, 55 , 44, 15 );
        g.fillRect( 45+16+45*8, 55 , 44, 15 );
        g.fillRect( 45+16+45*6, 55 , 44, 15 );


        g.setColor( new Color( 31, 178, 90 ) );
        g.fillRect( 45+16+45*9, 71 , 15, 44 );
        g.fillRect( 45+16+45*9, 71+45*1 , 15, 44 );
        g.fillRect( 45+16+45*9, 71+45*3 , 15, 44 );

        g.setColor( new Color( 0, 114, 187 ) );
        g.fillRect( 45+16+45*9, 71+45*8 , 15, 44 );
        g.fillRect( 45+16+45*9, 71+45*6 , 15, 44 );



        
        g.setColor( new Color( 149, 84, 54 ) );
        g.fillRect( 45+16+45*6, 476 , 44, 15 );
        g.fillRect( 45+16+45*8, 476 , 44, 15 );



        
        
        g.setColor( new Color( 170, 224, 250 ) );
        g.fillRect( 45+16+45*3, 476 , 44, 15 );
        g.fillRect( 45+16+45*1, 476 , 44, 15 );
        g.fillRect( 45+16, 476 , 44, 15 );





        
        g.setColor( new Color( 217, 58, 150 ) );
        g.fillRect( 45, 71+45*8 , 15, 44 );
        g.fillRect( 45, 71+45*5 , 15, 44 );
        g.fillRect( 45, 71+45*6 , 15, 44 );




        
        g.setColor( new Color( 247, 148, 29 ) );
        g.fillRect( 45, 71 , 15, 44 );
        g.fillRect( 45, 71+45*1 , 15, 44 );
        g.fillRect( 45, 71+45*3 , 15, 44 );





        g.setColor( new Color( 0, 0, 0 ) );
        int x=24;
        int y=30;

        Coord player_positions = new Coord(1, 2);
        System.out.println(player_positions);
        //Player Positions Row 1
        for(int i=1; i<11; i++)
            g.fillOval(x+45*i+5, y+10+450, 10, 10 );
        for(int i=1; i<11; i++)
            g.fillOval(x+45*i+5, y+450+15+10, 10, 10 );
        for(int i=1; i<11; i++)
            g.fillOval(x+45*i+15+5, y+450+10, 10, 10 );
        for(int i=1; i<11; i++)
            g.fillOval(x+45*i+15+5, y+450+15+10, 10, 10 );

        //Player Positions Row 2
        for(int i=1; i<11; i++)
            g.fillOval(x-5, y+45*i, 10, 10 );
        for(int i=1; i<11; i++)
            g.fillOval(x+10, y+45*i, 10, 10 );
        for(int i=1; i<11; i++)
            g.fillOval(x-5, y+45*i+15, 10, 10 );
        for(int i=1; i<11; i++)
            g.fillOval(x+10, y+45*i+15, 10, 10 );

        //Player Positions Row 3
        for(int i=0; i<11; i++)
            g.fillOval(x+45*i, y, 10, 10 );
        for(int i=0; i<11; i++)
            g.fillOval(x+45*i+15, y, 10, 10 );
        for(int i=0; i<11; i++)
            g.fillOval(x+45*i, y+15, 10, 10 );
        for(int i=0; i<11; i++)
            g.fillOval(x+45*i+15, y+15, 10, 10 );
        
        //Player Positions Row 4
        for(int i=1; i<10; i++)
            g.fillOval(x+455, y+45*i, 10, 10 );
        for(int i=1; i<10; i++)
            g.fillOval(x+455+15, y+45*i, 10, 10 );
        for(int i=1; i<10; i++)
            g.fillOval(x+455, y+45*i+15, 10, 10 );
        for(int i=1; i<10; i++)
            g.fillOval(x+455+15, y+45*i+15, 10, 10 );
    }


}
