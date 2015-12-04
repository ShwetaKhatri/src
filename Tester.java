import java.util.ArrayList;

public class Tester {

	private static final String[]  manufacturerNames = {"BMW",
			"NISSAN","CHEVORLET",
			"HONDA","TOYOTA"};
	private static final String[] carPriceRange = {"10000-30000",
			"30000-40000","40000-50000","All Ranges"};
	private static final String[] accessorPriceRange = {"100-200","200-300","300-400",
	"All Ranges"};


	private static Manufacturer[] manufacturers;
	private static ArrayList<Accessory> accessories;

	private static String[] accessoriesTypes = {"Seat Covers", "gps", "Speaker"};

	public Tester() {
		manufacturers = new Manufacturer[manufacturerNames.length];
		accessories = new ArrayList<Accessory>();
		addManufacturers();
		addAccessories();
	}


	public static void addAccessories() {
	 	accessories.add(new Accessory(ACCESSORY_TYPE.SEAT_COVERS, "Leather",200));
		accessories.add(new Accessory(ACCESSORY_TYPE.SEAT_COVERS,"CANVAS",200));
		accessories.add(new Accessory(ACCESSORY_TYPE.SEAT_COVERS,"CAMO",150));
		accessories.add(new Accessory(ACCESSORY_TYPE.SEAT_COVERS,"MESH",80));
		accessories.add(new Accessory(ACCESSORY_TYPE.SEAT_COVERS,"CAMO",150));
		accessories.add(new Accessory(ACCESSORY_TYPE.SEAT_COVERS,"NEOPRENE",200));

		accessories.add(new Accessory(ACCESSORY_TYPE.SPEAKER,"TWEETERS",300));
		accessories.add(new Accessory(ACCESSORY_TYPE.SPEAKER, "SUPER_TWEETERS",500));
		accessories.add(new Accessory(ACCESSORY_TYPE.SPEAKER,"MIDRANGE",250));
		accessories.add(new Accessory(ACCESSORY_TYPE.SPEAKER, "WOOFERS",500));
		accessories.add(new Accessory(ACCESSORY_TYPE.SPEAKER, "SUB_WOOFERS",400));

		accessories.add(new Accessory(ACCESSORY_TYPE.GPS,"GARMIN_NUVI_SERIES",500));
		accessories.add(new Accessory(ACCESSORY_TYPE.GPS,"TOM_TOM_GO_SERIES",450));
		accessories.add(new Accessory(ACCESSORY_TYPE.GPS,"MAGELLAN_ROAD_MATE_SERIES",600));
		accessories.add(new Accessory(ACCESSORY_TYPE.GPS,"IN_DASH_GPS_UNIT",350));

	}
	public static ArrayList<Accessory> getAccessories() {
		return accessories;
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
		String[] seatCovers = accessories.get(0).getCurrentSelectedList();
		System.out.println(seatCovers.toString());
		return seatCovers;
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
