package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private static final String FEED_MONEY_OPTION_ONE = "$1";
	private static final String FEED_MONEY_OPTION_FIVE = "$5";
	private static final String FEED_MONEY_OPTION_TEN = "$10";
	private static final String[] FEED_MONEY_OPTIONS = {FEED_MONEY_OPTION_ONE, FEED_MONEY_OPTION_FIVE, FEED_MONEY_OPTION_TEN};

	private boolean running = true;
	private VendingMachine vendingMachine = new VendingMachine();
	private Logger logger = new Logger();
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vendingMachine.displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (!choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

					if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						String feedChoice = (String) menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
						if (feedChoice.equals(FEED_MONEY_OPTION_ONE)) {
							vendingMachine.feedMoney(BigDecimal.valueOf(1));
						} else if (feedChoice.equals(FEED_MONEY_OPTION_FIVE)) {
							vendingMachine.feedMoney(BigDecimal.valueOf(5));
						} else if (feedChoice.equals(FEED_MONEY_OPTION_TEN)) {
							vendingMachine.feedMoney(BigDecimal.valueOf(10));
						}
					}
					if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						vendingMachine.displayItems();
						Scanner userInput = new Scanner(System.in);
						System.out.println("Enter Item Slot: ");
						String slotChoice = userInput.nextLine().toUpperCase();

						if (vendingMachine.getInventoryItems().containsKey(slotChoice)) {
							System.out.println(vendingMachine.purchaseItem(slotChoice));
						} else {
							System.out.println("Product code doesn't exist");
						}
					}
					System.out.println("Current Money Provided: $" + vendingMachine.getCurrentMoney().setScale(2, RoundingMode.HALF_UP));
					choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				}
				System.out.println(vendingMachine.returnChange());
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)){
				running = false;
			} else if(choice.equals(MAIN_MENU_OPTION_SALES_REPORT)){
				System.out.println("Print sales report");
				logger.generateSalesReport(vendingMachine.getInventoryItems());
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		cli.run();
	}
}
