
public class Tester {

	private static final String[]  manufacturerNames = {"BMW",
			"NISSAN","CHEVORLET",
			"HONDA","TOYOTA"};
	private static final String[] priceRanges = {"10,000 - 30,000",
			"30,000 - 40,000","40,000 - 50,000"};

	private Manufacturer[] manufacturers;

	public Tester() {
		manufacturers = new Manufacturer[manufacturerNames.length];
		addManufacturers();
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

	private String[] defaultResultDisplayed() {
		String[] cars = new String[manufacturers.length];
		for(int i =0; i< manufacturers.length; i++) {
			cars[i] = manufacturerNames[i] + ":" +
		manufacturers[i].getCars().get(0).toString();
		}
		return cars;
	}

	public Manufacturer[] getManufacturers() {
		return manufacturers;
	}

	public static void main(String[] args) {
		Tester test = new Tester();
		Administrator admin = new Administrator();
		admin.addCarsToManufacturersFromFile(test.getManufacturers());
		ContactEditorUI  ui =  new ContactEditorUI(test.getManufacturers(), priceRanges,
			test.defaultResultDisplayed());
	
		ui.launchUI();		

	}

}
