package Customer.Sorting;

//Sorting all products by price in Ascending order
public class Ascending implements Comparable<Ascending>{
    private final String itemsID;
    private final String titles;
    private final int intPrice;
    private final String Category;


    public Ascending(String itemsID, String titles, String price, String Category) {
        this.itemsID = itemsID;
        this.titles = titles;
        intPrice = Integer.parseInt(price);
        this.Category = Category;
    }
    public String toString(){
        return itemsID + "," + titles + "," + intPrice + "," + Category;
    }

    @Override
    public int compareTo(Ascending otherPriceSort) {
        if (otherPriceSort == null){
            throw new NullPointerException("Try to compare" + this + "to null");
        }else if(!this.getClass().equals(otherPriceSort.getClass())){
            throw new ClassCastException("maybe Classloader Issue. Failed to compare" + this + "to"+otherPriceSort);
        }else if (this.intPrice < otherPriceSort.intPrice) {
            return -1;
        }else if (this.intPrice > otherPriceSort.intPrice)
            return 1;

        return 0;
    }
}

