/*
 * Represents some general accessories offered by car
 * manufacturers.Each manufacturer can set price of 
 * these accessories.
 */
public class Accessory {
	
    private SEAT_COVERS covers;
    private SPEAKERS speaker;
    private GPS gps;
 
    
    public Accessory(SEAT_COVERS seatCover, SPEAKERS carSpeaker, GPS carGps) {
    	covers = seatCover;
    	speaker = carSpeaker;
    	gps = carGps;
    
    }

	public enum SEAT_COVERS{
		LEATHER,CANVAS,CAMO,MESH,NEOPRENE;
	}
	
	public enum SPEAKERS {
		TWEETERS, SUPER_TWEETERS, MIDRANGE, WOOFERS, SUB_WOOFERS;
	}

	public enum GPS {
		GARMIN_NUVI_SERIES,TOM_TOM_GO_SERIES,MAGELLAN_ROAD_MATE_SERIES,IN_DASH_GPS_UNIT;
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
}
