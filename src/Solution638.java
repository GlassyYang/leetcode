import java.util.*;
public class Solution638 {

    private int minCost;
    private int numberOfCommodities;
    private List<Integer> price;
    private List<List<Integer>> specials;
    private List<Integer> needs;
    boolean[] visited;
    public int getPrices(List<Integer> needs) {
        int cost = 0;
        final int numberOfCommodities = price.size();
        for(int i = 0; i < numberOfCommodities; i++) {
            cost += price.get(i) * needs.get(i);
        }
        return cost;
    }

    public void filterSpecial() {
        for(Iterator<List<Integer>> i = specials.iterator(); i.hasNext(); ) {
            List<Integer> special = i.next();
            boolean satisfy = isSatisfy(special, needs);
            if(special.get(numberOfCommodities) >= minCost) {
                satisfy = false;
            }
            if(!satisfy) {
                i.remove();
            }
        }
    }

    private boolean isSatisfy(List<Integer> special, List<Integer> needs) {
        for(int i = 0; i < numberOfCommodities; ++i) {
            if(special.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean updateNeeds(List<Integer> special, List<Integer> needs) {
        int countOfZero = 0;
        for(int i = 0; i < numberOfCommodities; ++i) {
            int newNumber = needs.get(i) - special.get(i);
            if(newNumber == 0) {
                countOfZero++;
            }
            needs.set(i, newNumber);
        }
        return countOfZero == numberOfCommodities;
    }

    public void revokeNeeds(List<Integer> special, List<Integer> needs) {
        for(int i = 0; i < numberOfCommodities; ++i) {
            needs.set(i, needs.get(i) + special.get(i));
        }
    }
    public void recursiveSearch(int curCost) {
        for(int i = 0; i < visited.length; ++i) {
            List<Integer> special = specials.get(i);
            if(!visited[i] && isSatisfy(special, needs)) {
                if(updateNeeds(special, needs)) {
                    minCost = Math.min(minCost, curCost + special.get(numberOfCommodities));
                } else {
                    recursiveSearch(curCost + special.get(numberOfCommodities));
                }
                revokeNeeds(special, needs);
            }
        }
        minCost = Math.min(minCost, getPrices(needs) + curCost);
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        this.needs = needs;
        this.specials = special;
        minCost = getPrices(needs);
        numberOfCommodities = needs.size();
        filterSpecial();
        visited = new boolean[special.size()];
        recursiveSearch(0);
        return minCost;
    }

}
