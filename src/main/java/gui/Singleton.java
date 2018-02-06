package gui;


public class Singleton {
	
	private static Singleton instance = new Singleton();
	private SearchHome searchHome;
	
	public static Singleton getInstance() {
		return instance;
	}

	public SearchHome getSearchHome() {
		return searchHome;
	}

	public void setSearchHome(SearchHome searchHome) {
		this.searchHome = searchHome;
	}

}
