package agriDirect;

public class Main {
    public static void main(String[] args) {
	    	Farmer f = new Farmer(1, "Ravi");
	
	    	f.addProduct(new Product("Tomato", 20, 50));
	    	f.addProduct(new Product("Potato", 30, 20));
	    	
	    	System.out.println();
	    	
	    	f.showProducts();
    }
}
