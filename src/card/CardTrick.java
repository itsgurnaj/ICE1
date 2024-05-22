import java.util.Random;
import java.util.Scanner;

/**
 * CardTrick class models a hand of seven cards
 * Author: Gurnaj kaur
 * Student Number: 991716527
 */

public class CardTrick {
    public static void main(String[] args) {
        // Array to hold a hand of 7 cards
        Card[] hand = new Card[7];
        Random random = new Random();

        // Array of possible suits
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        // Filling the hand with random cards
        for (int i = 0; i < hand.length; i++) {
            int value = random.nextInt(13) + 1; // Values 1-13
            String suit = suits[random.nextInt(4)];
            hand[i] = new Card(value, suit);
        }

        // Display the generated hand (for debugging)
        System.out.println("Magic Hand:");
        for (Card card : hand) {
            System.out.println(card);
        }

        // Asking the user to pick a card
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick a card number (1-13): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Pick a suit (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = scanner.nextLine();
        Card userCard = new Card(userValue, userSuit);

        // Searching for the user's card in the hand
        boolean found = false;
        for (Card card : hand) {
            if (card.equals(userCard)) {
                found = true;
                break;
            }
        }

        // Reporting the result
        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }
    }
}

// Card class to represent a card
class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Card card = (Card) obj;

        if (value != card.value) return false;
        return suit != null ? suit.equals(card.suit) : card.suit == null;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
