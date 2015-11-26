/*
 * @author Shweta 
 * This class is responsible for displaying results when
 * user selects an option from drop down list in homepage
 * and click Search button
 */
public class PopulateResults {

	private String manufacturerClicked;
	private String resultClicked;
	
	public void setManufacturerClicked(String manufacturerClicked) {
		this.manufacturerClicked = manufacturerClicked;
	}
	public void setResultClicked(String resultClicked) {
		this.resultClicked = resultClicked;
	}
	public String getManufacturerClicked() {
		return manufacturerClicked;
	}
	public String getResultClicked() {
		return resultClicked;
	}
	
	
}
