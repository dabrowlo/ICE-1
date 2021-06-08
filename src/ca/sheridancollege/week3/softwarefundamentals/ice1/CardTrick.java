/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 *
 * @author Sivagama
 * @author Logan Dabrowski - 991614318 - Modified June 7, 2021
 */

import java.util.Scanner;

public class CardTrick
{

   public static void main (String[] args)
   {
      Card[] magicHand = new Card[7];
      Scanner k = new Scanner(System.in);
      Card luckyCard = new Card();
	   luckyCard.setSuit(Card.SUITS[2]);
      luckyCard.setValue(1);

      for (int i = 0; i < magicHand.length; i++) {
         int cValue = (int) Math.floor(Math.random() * 13) + 1;
         int cSuit = (int) Math.round(Math.random() * 3);
         //send the card info to object Array magicHand
         magicHand[i] = new Card();
         magicHand[i].setSuit(Card.SUITS[cSuit]);
         magicHand[i].setValue(cValue);
      }

      //insert code to ask the user for Card value and suit, create their card
      System.out.println("Select the suit of the card. 0= Hearts 1= Diamonds "
          + "2= Spades 3= Clubs");
      int suit = k.nextInt();

      //Error check for invalid suit entry
      while (suit > 3 || suit < 0) {
         System.out.println("Error invalid input please re-enter the suit. "
             + "0= Hearts 1= Diamonds 2= Spades 3= Clubs");
         suit = k.nextInt();
      }

      //Ask for card number and the input
      System.out.println("Select the number of the card. numbers 1-13, "
          + "1 = Ace, 11 = Jack, 12 = Queen, 13 = King");
      int value = k.nextInt();

      //Error check
      while (value < 1 || value > 13) {
         System.out.println("Error, invalid card number please re-enter the card"
             + "1 = Ace, 11 = Jack, 12 = Queen, 13 = King");
         value = k.nextInt();
      }

      //Sends the card info to the object userCard
      Card userCard = new Card();
      userCard.setSuit(Card.SUITS[suit]);
      userCard.setValue(value);

      // and search magicHand here
      int check = 0;
      for (int i = 0; i < magicHand.length; i++) {
         System.out.println(magicHand[i].getValue() + " of " + magicHand[i].getSuit());
         if (userCard.getSuit() == magicHand[i].getSuit() && userCard.getValue() == magicHand[i].getValue()) {
            check = 1;
            break;
         }
      }
      //Then report the result here
      if (check == 1) {
         System.out.println("The card you selected is in the hand");
      }
      else {
         System.out.println("No match was found");
      }
   }

}
