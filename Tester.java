public class Tester {

	private static final String[]  manufacturerNames = {"BMW",
			"NISSAN","CHEVORLET",
			"HONDA","TOYOTA"};
	private static final String[] carPriceRange = {"10000-30000",
			"30000-40000","40000-50000","All Ranges"};
	private static final String[] accessorPriceRange = {"100-200","200-300","300-400",
	"All Ranges"};


	private static Manufacturer[] manufacturers;
	private static Accessory[] accessories;
	private static String[] accessoriesTypes = {"Seat Covers", "gps", "Speaker"};

	public Tester() {
		manufacturers = new Manufacturer[manufacturerNames.length];
		accessories = new Accessory[accessoriesTypes.length];
		addManufacturers();
		addAccessories();
	}


	public static void addAccessories() {
		
	 	accessories[0]= new Accessory(ACCESSORY_NAME.SEAT_COVERS);
	 	accessories[0].addAccessories("CANVAS",200);
		accessories[0].addAccessories("CAMO",150);
		accessories[0].addAccessories("MESH",80);
		accessories[0].addAccessories("CAMO",150);
		accessories[0].addAccessories("NEOPRENE",200);
		
		
		accessories[1]=new Accessory(ACCESSORY_NAME.SPEAKER);
		accessories[1].addAccessories("TWEETERS",300);
		accessories[1].addAccessories( "SUPER_TWEETERS",500);
		accessories[1].addAccessories("MIDRANGE",250);
		accessories[1].addAccessories( "WOOFERS",500);
		accessories[1].addAccessories( "SUB_WOOFERS",400);
		
		accessories[2] = new Accessory(ACCESSORY_NAME.GPS);
		accessories[2].addAccessories("GARMIN_NUVI_SERIES",500);
		accessories[2].addAccessories("TOM_TOM_GO_SERIES",450);
		accessories[2].addAccessories("MAGELLAN_ROAD_MATE_SERIES",600);
		accessories[2].addAccessories("IN_DASH_GPS_UNIT",350);
		

	}
	
	public static Accessory[] getAccessories() {
		return accessories;
	}

	public static Accessory getAccessories(int i) {
		return accessories[i];
	}

	public static String[] getAccessoriesTypes() {
		return accessoriesTypes;
	}

	public static String[] getAccessoriesPriceRange() {
		return accessorPriceRange;
	}

	private void addManufacturers() {
		System.out.println("Added manufacturer BMW");
		Manufacturer bmw = new BMW();
		bmw.setManufacturerName("BMW");
		manufacturers[0] = bmw;

		System.out.println("Added manufacturer Nissan");
		Manufacturer nissan = new Nissan();
		nissan.setManufacturerName("Nissan");
		manufacturers[1] = nissan;

		System.out.println("Added manufacturer Chevorlet");
		Manufacturer chevorlet = new Chevrolet();
		chevorlet.setManufacturerName("Chevorlet");
		manufacturers[2] = chevorlet;

		System.out.println("Added manufacturer Honda");
		Manufacturer honda = new Honda();
		honda.setManufacturerName("Honda");
		manufacturers[3] = honda;

		System.out.println("Added manufacturer Toyota");
		Manufacturer toyota = new Toyota();
		toyota.setManufacturerName("Toyota");
		manufacturers[4] = toyota;		
	}

	public static String[] defaultManufacturersToBeDiplayed() {
		return manufacturers[0].getCarsDetails();

	}

	public static String[] defaultAccessoriesToBeDisplayed() {
		return accessories[0].getAccessoriesDetails();
	}

	public Manufacturer[] getManufacturers() {
		return manufacturers;
	}

	public static void main(String[] args) {
		Tester test = new Tester();
		Administrator admin = new Administrator();
		admin.addCarsToManufacturersFromFile(test.getManufacturers());
		HomePage  ui =  new HomePage(test.getManufacturers(), carPriceRange);	
		ui.launchUI();		


	}

}
