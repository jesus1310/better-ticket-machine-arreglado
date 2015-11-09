/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //Variable que guarda el precio con descuento.
    private int priceWithDiscount;
    // Atributo de tipo booleano que indica si hace descuentos o no.
    private boolean discount;
    
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost,boolean newDiscount)
    {
        price = cost;
        discount = newDiscount;
        priceWithDiscount = cost - (cost * 10) / 100;
        balance = 0;
        total = 0;
    }
    
    /**
     * M�todo que permite seleccionar si har� descuentos.
     */
    public void printTicketWithDiscount()
    {
        if (discount == true){
            if(balance >= priceWithDiscount) {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + priceWithDiscount + " cents.");
                System.out.println("##################");
                System.out.println();

                // Update the total collected with the price.
                total = total + priceWithDiscount;
                // Reduce the balance by the prince.
                balance = balance - priceWithDiscount;
            }
            else {
                System.out.println("You must insert at least: " +
                               (priceWithDiscount - balance) + " more cents.");
                    
            }
        }
        else{
            System.out.println("This machine haven't got discount");
        }
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        int amountLeftToPay = price - balance;
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " +
                               (amountLeftToPay) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    /**
     * Vaciar todas las monedas de la m�quina.
     */
    public int emptyMachine()
    {
        int totalMoney = -1;
        if (balance == 0){
            totalMoney = total;
            total = 0;
        }
        return totalMoney;
    }
}
