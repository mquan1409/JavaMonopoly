# JavaMonopoly
Creating Monopoly with Java
COP3252 Project

***Group Members***
Quan Pham, Kevin Foughty, Lloyd Smith, Tierra Fisher

***How to run the game***
You can download the files and run the game with the command "java Start"
The main() methos is inside Start.java

***Monopoly Basics***
Monopoly is a game where four players take turns rolling two dice to move a game piece around a board. 
The objective is to make the most money by buying, renting and selling properties around the board.
The board itself has squares, and different events occur depending on what type of square the player lands on.
There are properties, chance, community chest, tax, jail, free parking, and go.

***Features of the game coded***
The game features buttons to roll, buy and sell houses. 
The player rolls the dice, lands on a new square and is presented with an option relevant to the square they land on.
Some examples are landing on unowned property shows a prompt to buy that space, 
rolling a double dice result three times in a row results in the player going to jail and an extra rule that landing on free parking allows the player to choose anywhere to buy.
While there are the usual win case of forcing the other players into bankruptcy, 
there is also an alternate win condition of being the first player to reach $2500 (this is another extra feature). 

***Features of java used***
Control Structures, for example handling the chest cards that the player sees.
Methods, for example Many fields are static to make it easier for other objects to access them.
Arrays, for example the player positions and lands are all tracked in arrays.
Classes, for example there are classes for the board, deed, lands, and property to name a few.
Class inheritance, specifically via the use of super calls in Swing components.
