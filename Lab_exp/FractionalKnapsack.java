import java.util.*;

class Item {
    int weight, profit;
    double ratio;

    // Constructor to initialize item with weight and profit
    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight; // Calculate profit-to-weight ratio
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        // Hardcoded test case (3 items)
        Item[] items = {
            new Item(20, 100),
            new Item(10, 60),
            new Item(50, 100),
            new Item(50, 200)
        };

        int capacity = 90; // Maximum capacity of the knapsack

        // Sort items in descending order of profit-to-weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;          // Final profit to be calculated
        int remainingCapacity = capacity;

        System.out.println("Weight\tProfit");

        // Classic for loop to go through all items
        for (int i = 0; i < items.length; i++) {
            if (remainingCapacity == 0)
                break; // Stop if knapsack is full

            Item item = items[i]; // Get the current item

            if (item.weight <= remainingCapacity) {
                // Take the full item
                totalProfit += item.profit;
                remainingCapacity -= item.weight;
                System.out.println(item.weight + "\t" + item.profit);
            } else {
                // Take fraction of the item that fits
                double fraction = (double) remainingCapacity / item.weight;
                totalProfit += item.profit * fraction;
                System.out.println(remainingCapacity + "\t" + String.format("%.2f", item.profit * fraction));
                remainingCapacity = 0; // Knapsack is now full
            }
        }

        System.out.println("\nMaximum Profit: " + String.format("%.2f", totalProfit));
    }
}
