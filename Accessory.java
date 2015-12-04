import java.util.ArrayList;

/*
 * Represents some general accessories offered by car
 * manufacturers.Each manufacturer can set price of 
 * these accessories.
 */
public class Accessory {
	
    private SEAT_COVERS covers;
    private SPEAKERS speaker;
    private GPS gps;
    private ArrayList<Accessory> accessories;
 
    
    public Accessory(SEAT_COVERS seatCover, SPEAKERS carSpeaker, GPS carGps) {
    	covers = seatCover;
    	speaker = carSpeaker;
    	gps = carGps;   
    	accessories = new ArrayList<Accessory>();
    }

	
	public enum SEAT_COVERS{
		LEATHER(200),CANVAS(200),CAMO(150),MESH(80),NEOPRENE(200);
		private int price;
		SEAT_COVERS(int price) {
			this.price = price;
		}
		public int getSeatCoverPrice() {
			return price;
		}
	}
	
	public enum SPEAKERS {
		TWEETERS(300), SUPER_TWEETERS(500), MIDRANGE(250), WOOFERS(500), SUB_WOOFERS(400);
		private int price;
		SPEAKERS(int price) {
			this.price = price;
		}
		public int getSeatCoverPrice() {
			return price;
		}
	}

	public enum GPS {
		GARMIN_NUVI_SERIES(500),TOM_TOM_GO_SERIES(450),MAGELLAN_ROAD_MATE_SERIES(600),IN_DASH_GPS_UNIT(350);
		private int price;
		GPS(int price) {
			this.price = price;
		}
		public int getSeatCoverPrice() {
			return price;
		}
	}

	public SEAT_COVERS getCovers() {
		return covers;
	}

	public SPEAKERS getSpeaker() {
		return speaker;
	}

	public GPS getGps() {
		return gps;
	}
	
	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}

	public ArrayList<Accessory> getAccessories(){
			return accessories;
		
	}
	
	@Override
	public String toString() {
		return null;
		
	}
}
