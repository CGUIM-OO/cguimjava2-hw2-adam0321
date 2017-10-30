import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO:B0544119 蔡忠諺   
 * Try to write some comments for your codes
 *         (methods, 15 points)
 *         讓使用者輸入需要的牌數
 *         讀取輸入幾副牌
 *         把需要的幾副牌傳到下面的printDeck的方法裡
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on
		// your screen (10 points)
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/**
	 * This method is used for checking your result, not a part of your HW2
	 * 
	 * @param allCards
	 *           所有的牌
	 * @param nDeck
	 *            總共幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/**
 * Description: TODO: please add description here
 */
class Deck {
	private ArrayList<Card> cards;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end
		for (int n = 0; n < nDeck; n++) {
			//有nDeck副牌
			for (int x = 1; x < 5; x++) {
				//有4種花色
				for (int y = 1; y < 14; y++) {
					//有13張牌
					Card card = new Card(x, y);
					cards.add(card);
					//依序存在cards裡
				}
			}
		}
	}


	// TODO: Please implement the method to print all cards on screen (10
	// points)
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5
		// points)
		for(int i=0;cards.size()>i;i++) {
			Card card = new Card(cards.get(i).getSuit(), cards.get(i).getRank());
			card.printCard();
			//依序將幾副牌顯示在結果上
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * Description: TODO: please add description here
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
						// Spades=4
	private int rank; // 1~13

	/**
	 * @param s
	 *            suit
	 * @param r
	 *            rank
	 */
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit,
	// 10 for rank)
	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example:
		// print 1,1 as Clubs Ace
				if (suit == 1) {
					System.out.print("Clubs ");
					//如果suit是1則顯示Clubs
				} else if (suit == 2) {
					System.out.print("Diamonds ");
					//如果suit是2則顯示Diamonds
				} else if (suit == 3) {
					System.out.print("Hearts ");
					//如果suit是3則顯示Hearts
				} else
					System.out.print("Spades ");
				//如果suit是4則顯示Spades
				if (rank == 1) {
					System.out.print("Ace ");
					//如果rank是1則顯示Ace
				} else if (rank == 11) {
					System.out.print("J ");
					//如果rank是11則顯示J
				} else if (rank == 12) {
					System.out.print("Q ");
					//如果rank是12則顯示Q
				} else if (rank == 13) {
					System.out.print("K ");
					//如果rank是13則顯示K
				} else
					System.out.print(rank);
				//其他就顯示他的數字
				System.out.println("");
				//換行
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
