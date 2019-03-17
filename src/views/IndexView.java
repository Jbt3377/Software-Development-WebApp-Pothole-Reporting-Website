package views;

import org.h2.mvstore.MVMap;

import java.io.File;
import java.util.List;

import model.Categories;
import model.Report;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class IndexView extends DynamicWebPage{

	public IndexView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
	}
	
	public boolean process(WebRequest toProcess) {
		
		if(toProcess.path.equalsIgnoreCase("indexview")) {
			
			System.out.println("\n\nRequest for Web Page: " + toProcess.path);
			
			// Account action will only ever be login or logout
			String accountAction = "Login";
			// Will default be Register if an account is not signed in yet
			String accountUsername = "Register";
			
			
			String stringToSendToBrowser = "";
			stringToSendToBrowser += "<!DOCTYPE html>\r\n";
			stringToSendToBrowser += "<html>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "<head>\r\n";
			stringToSendToBrowser += "  <meta charset=\"utf-8\">\r\n";
			stringToSendToBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "</head>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "<body class=\"text-left\">\r\n";
			stringToSendToBrowser += "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n";
			stringToSendToBrowser += "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\r\n";
			stringToSendToBrowser += "        <span class=\"navbar-toggler-icon\"></span>\r\n";
			stringToSendToBrowser += "      </button>\r\n";
			stringToSendToBrowser += "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"#\">\r\n";
			stringToSendToBrowser += "          </a><a href=\"indexview\"><i class=\"fa d-inline fa-lg fa-wrench\"></i></a>";
			stringToSendToBrowser += "          <a href=\"indexview\"><b>&nbsp; FILL MY HOLE</b></a>\r\n";
			stringToSendToBrowser += "        </a>\r\n";
			stringToSendToBrowser += "        <ul class=\"navbar-nav mx-auto\">\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Report a Problem</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"formPage.html\">FAQ</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"AboutUs.html\">About Us</a> </li>\r\n";
			stringToSendToBrowser += "        </ul>\r\n";
			stringToSendToBrowser += "        <ul class=\"navbar-nav\">\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"loginview.html\">"+ accountAction +"</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signupview\">"+ accountUsername +"</a> </li>\r\n";
			stringToSendToBrowser += "        </ul>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "    </div>\r\n";
			stringToSendToBrowser += "  </nav>\r\n";
			stringToSendToBrowser += "  <div class=\"text-center text-white\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\" >\r\n";
			stringToSendToBrowser += "    <div class=\"container\">\r\n";
			stringToSendToBrowser += "      <div class=\"row\">\r\n";
			stringToSendToBrowser += "        <div class=\"col-md-8 mx-auto\">\r\n";
			stringToSendToBrowser += "          <h1 class=\"mb-3 mt-3 p-2\">What's Bothering You?</h1>\r\n";
			stringToSendToBrowser += "          <p class=\"lead mb-0 p-2\">Fill My Hole is a website dedicated to informing local councils of problems they have the responsibility to fix.<br></p>\r\n";
			stringToSendToBrowser += "          <p class=\"lead text-center text-capitalize p-0 m-2\">Got a Problem?&nbsp; Report it!<br></p><a class=\"btn btn-primary m-2 my-3 mb-4\" href=\"#reportForm\"><b class=\"text-center\">Report an Issue</b></a>\r\n";
			stringToSendToBrowser += "        </div>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "      <div class=\"row\">\r\n";
			stringToSendToBrowser += "        <div class=\"col-md-12\"><iframe width=\"100%\" height=\"400\" src=\"https://maps.google.com/maps?q=New%20York&amp;z=14&amp;output=embed\" scrolling=\"no\" frameborder=\"0\"></iframe></div>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "    </div>\r\n";
			stringToSendToBrowser += "    <div class=\"container py-4\">\r\n";
			stringToSendToBrowser += "        <div class=\"row\">\r\n";
			stringToSendToBrowser += "          <div class=\"col-md-6\" style=\"\">\r\n";
			stringToSendToBrowser += "            <div class=\"card text-white bg-dark my-3\">\r\n";
			stringToSendToBrowser += "              <div class=\"card-header text-center\"><b class=\"w-100 h-100\">How to Report a Problem</b></div>\r\n";
			stringToSendToBrowser += "              <div class=\"card-body\">\r\n";
			stringToSendToBrowser += "                <ol class=\"\">\r\n";
			stringToSendToBrowser += "                  <li class=\"text-left py-2\"><b>Locate - </b>Use the map above to find the area of the problem</li>\r\n";
			stringToSendToBrowser += "                  <li class=\"text-left py-2\"><b>Mark - </b>Click on the precise location of the problem</li>\r\n";
			stringToSendToBrowser += "                  <li class=\"text-left py-2\"><b>Tell us! - </b>Provide us with information on the problem and we'll pass it onto the local council. You can include images as well!&nbsp;</li>\r\n";
			stringToSendToBrowser += "                </ol>\r\n";
			stringToSendToBrowser += "              </div>\r\n";
			stringToSendToBrowser += "            </div>\r\n";
			stringToSendToBrowser += "            <div class=\"card text-white bg-dark my-3\">\r\n";
			stringToSendToBrowser += "              <div class=\"card-header text-center\">\r\n";
			stringToSendToBrowser += "                <b class=\"w-100 h-100\"><b><span style=\"font-weight: normal;\">Recently Reported Problems</span></b></b><b class=\"w-100 h-100\"></b></div>\r\n";
			stringToSendToBrowser += "              <div class=\"card-body\">\r\n";
			stringToSendToBrowser += "                <div class=\"card bg-dark\">\r\n";
			
			
			// Display 3 most recent reports
			MVMap<String, Report> allReports = db.s.openMap("NewReports");
			List<String> reportKeys = allReports.keyList();

			for(int keyIndex=(reportKeys.size()-1); keyIndex>=(reportKeys.size()-3); keyIndex--)
			{
				String currentReportKey = reportKeys.get(keyIndex);
				Report currentReport = allReports.get(currentReportKey);
				
				
				stringToSendToBrowser += "                  <div class=\"card-body bg-primary my-2\">\r\n";
				stringToSendToBrowser += "                    <div class=\"row\">\r\n";
				stringToSendToBrowser += "                      <div class=\"col-md-6\">\r\n";
				stringToSendToBrowser += "                        <h5 class=\"card-title my-2 text-dark\" align=\"left\">" + currentReport.description +"</h5>\r\n";
				stringToSendToBrowser += "                        <p align=\"left\">"+ currentReport.category.description() +"</p>\r\n";
				stringToSendToBrowser += "                      </div>\r\n";
				
				
				// Decide if an image was provided in the report, or if a default image is required
//				if(currentReport.filePathToImage != null) {
//					stringToSendToBrowser += "                      <div class=\"col-md-6\"><img class=\"img-fluid d-block\" src=\"/"+ currentReport.filePathToImage +"\" height=\"120\" width=\"120\" align=\"right\" alt=\"Picture of Problem\"></div>\r\n";
//					
//				}else{
//					stringToSendToBrowser += "                      <div class=\"col-md-6\"><img class=\"img-fluid d-block\" src=\"/"+ decideDefaultImage(currentReport.category) +"\" height=\"120\" width=\"120\" align=\"right\" alt=\"Picture of Problem\"></div>\r\n";
//				}
				
				stringToSendToBrowser += "                    </div>\r\n";
				stringToSendToBrowser += "                  </div>\r\n";
				

			}
			
			
			stringToSendToBrowser += "                </div>\r\n";
			stringToSendToBrowser += "              </div>\r\n";
			stringToSendToBrowser += "            </div>\r\n";
			stringToSendToBrowser += "          </div>\r\n";
			stringToSendToBrowser += "          <div class=\"col-md-6\" style=\"\">\r\n";
			stringToSendToBrowser += "            <div class=\"card text-white bg-dark my-3 rounded\">\r\n";
			stringToSendToBrowser += "			   <a name=\"reportForm\"></a>";
			stringToSendToBrowser += "              <div class=\"card-header\">\r\n";
			stringToSendToBrowser += "                <h3 class=\"my-1 text-muted\"><span class=\"badge badge-pill badge-warning text-dark\">Report a Problem!</span></h3>\r\n";
			stringToSendToBrowser += "              </div>\r\n";
			stringToSendToBrowser += "              <div class=\"card-body\">\r\n";
			stringToSendToBrowser += "                <!--Report Card-->\r\n";
			stringToSendToBrowser += "                <p class=\"card-text\"><b>Ping the location of the problem on the map above and enter the required information. Afterwards, submit!</b><br></p>\r\n";
			stringToSendToBrowser += "                <!--Report Form-->\r\n";
			stringToSendToBrowser += "                <div class=\"Report-Form\">\r\n";
			stringToSendToBrowser += "                  <form action=\"/Report\" method=\"GET\">\r\n";
			stringToSendToBrowser += "                    <!--Description (Text Input)-->\r\n";
			stringToSendToBrowser += "                    <label for=\"description\" class=\"w-100 text-left pt-2\"><b>Description</b></label>\r\n";
			stringToSendToBrowser += "                    <input type=\"text\" class=\"form-control text-left text-white\" name=\"desc\" placeholder=\"Provide a short despription of the problem\" required=\"required\">\r\n";
			stringToSendToBrowser += "                    <!--Category (Dropdown)-->\r\n";
			stringToSendToBrowser += "                    <label for=\"category\" class=\"w-100 text-left pt-2\"><b>Category</b></label>\r\n";
			stringToSendToBrowser += "                    <select class=\"form-control text-left text-dark\" name=\"category\" required=\"required\">\r\n";
			stringToSendToBrowser += "                      <option value=\"\" disabled=\"disabled\" selected=\"selected\">Select a Suitable Category</option>\r\n";
			
			for(Categories c: Categories.values()) {
				stringToSendToBrowser += "                      <option value=\""+ c.description() +"\">"+ c.description() +"</option>\r\n";
			}
			
			stringToSendToBrowser += "                    </select>\r\n";
			stringToSendToBrowser += "                    <!--Details (TextArea)-->\r\n";
			stringToSendToBrowser += "                    <label for=\"details\" class=\"w-100 text-left pt-2\"><b>Details</b></label>\r\n";
			stringToSendToBrowser += "                    <textarea name=\"details\" rows=\"10\" required=\"required\" placeholder=\"Tell us some details about the problem\" cols=\"70\" maxlength=\"255\" class=\"form-control text-left w-100 text-white\"></textarea>\r\n";
			stringToSendToBrowser += "                    <!--Media (File Input)-->\r\n";
			stringToSendToBrowser += "                    <label for=\"files\" class=\"w-100 text-left pt-2\"><b>Photos/Videos</b></label>\r\n";
			stringToSendToBrowser += "                    <input type=\"file\" name=\"fileupload\" value=\"fileupload\" class=\"text-left form-control-file\">\r\n";
			stringToSendToBrowser += "                    <input value=\"Submit\" type=\"submit\" class=\"mt-4\">\r\n";
			stringToSendToBrowser += "                  </form>\r\n";
			stringToSendToBrowser += "                </div>\r\n";
			stringToSendToBrowser += "              </div>\r\n";
			stringToSendToBrowser += "            </div>\r\n";
			stringToSendToBrowser += "          </div>\r\n";
			stringToSendToBrowser += "        </div>\r\n";
			stringToSendToBrowser += "    </div>\r\n";
			stringToSendToBrowser += "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\" style=\"\"></script>\r\n";
			stringToSendToBrowser += "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\" style=\"\"></script>\r\n";
			stringToSendToBrowser += "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\r\n";
			stringToSendToBrowser += "  </div>\r\n";
			stringToSendToBrowser += "</body>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "</html>";
			
			// Pass out Web Response
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToBrowser);
			
			return true;
			
		}else if(toProcess.path.equalsIgnoreCase("Report")) {
			
			System.out.println("Request to submit a Report: " + toProcess.path);
			
			// New Report
			Report problemReport = new Report();
			
			// Get details of new report provided
			problemReport.reportID = "report_"+System.currentTimeMillis();
			problemReport.description = toProcess.params.get("desc");

			problemReport.category = getCategory(toProcess.params.get("category"));
			
			problemReport.details = toProcess.params.get("details");
			problemReport.filePathToImage = toProcess.params.get("fileupload");

			
			// File upload
			File uploaded = new File(problemReport.filePathToImage);
			int ind = problemReport.filePathToImage.lastIndexOf('.');
			String extension = problemReport.filePathToImage.substring(ind);
			uploaded.renameTo(new File("httpdocs/"+problemReport.reportID+extension));
			problemReport.filePathToImage = problemReport.reportID+extension;
			
			
			// Add report to database
			MVMap<String, Report> allReports = db.s.openMap("NewReports");
			allReports.put(problemReport.reportID, problemReport);
			
			// Console feedback - this is the report being saved to database
			System.out.println();
			System.out.println("== Problem has been successfully reported ==");
			System.out.println("ID: " + problemReport.reportID);
			System.out.println("Description: " + problemReport.description);
			System.out.println("Category: " + problemReport.category);
			System.out.println("Details: " + problemReport.details);
			System.out.println("File path to image: " + problemReport.filePathToImage);
			System.out.println();
			
			// Redirect to new page once report complete
			String stringToSendToBrowser = "<html><body><p>Report Recorded</p><a href=\"indexview\">Home</a></body></html>";
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToBrowser);
	
			
			return true;
		}
		
		return false;
	}
	
	
	
	/*
	 * Method is used to decide on the correct default image to display, in the case that an image
	 * was not provided in the report. Returns a String with the appropriate default image file path.
	 */
	public String decideDefaultImage(Categories currentReportCategory) {
		
		String imgsrc = "";
		
		switch(currentReportCategory) {
		case ABANDONED_VEHICLE: 	imgsrc += "./AbandonedCar.jpg";
									break;
		case DOG_FOULING: 			imgsrc += "./DogFouling.jpg";
									break;
		case DOWN_LAMP_POST: 		imgsrc += "./DownLampPost.jpg";
									break;
		case DOWN_TREE: 			imgsrc += "./DownTree.jpg";
									break;
		case FLY_TIPPING: 			imgsrc += "./Flytipping.jpg";
									break;
		case FLY_POSTING: 			imgsrc += "./Flyposting.jpg";
									break;
		case GRAFFITI: 				imgsrc += "./Graffiti.jpg";
									break;
		case POTHOLE: 				imgsrc += "./Pothole.jpg";
									break;
		case PUBLIC_TOILETS: 		imgsrc += "./PublicToilets.jpg";
									break;
		case ROAD_CONDITIONS: 		imgsrc += "./IcyRoad.jpg";
									break;
		case STREET_CLEANING: 		imgsrc += "./StreetCleaning.jpg";
									break;
		case STREET_LIGHTING: 		imgsrc += "./StreetLighting.jpg";
									break;
		case TRASH: 				imgsrc += "./Trash.jpg";
									break;
		default: 					imgsrc += "./NotFound.jpg";
									break;
		}
		
		return imgsrc;
		
	}
	
	
	/*
	 * Method used to decide on the enumeration value (category) to set in the report
	 * This is because when the information is pulled from the drop down menu, it is in type String, not Enum.
	 */
	public Categories getCategory(String categoryChosen) {
		
		Categories correctEnum;
		
		switch(categoryChosen) {
		case "Abandoned Vehicle": 	correctEnum = Categories.ABANDONED_VEHICLE;
									break;
		case "Dog Fouling": 		correctEnum = Categories.DOG_FOULING;
									break;
		case "Downed Lamp-Post": 	correctEnum = Categories.DOWN_LAMP_POST;
									break;
		case "Downed Tree": 		correctEnum = Categories.DOWN_TREE;
									break;
		case "Flytipping": 			correctEnum = Categories.FLY_TIPPING;
									break;
		case "Flyposting": 			correctEnum = Categories.FLY_POSTING;
									break;
		case "Graffiti": 			correctEnum = Categories.GRAFFITI;
									break;
		case "Pothole": 			correctEnum = Categories.POTHOLE;
									break;
		case "Public Toilets": 		correctEnum = Categories.PUBLIC_TOILETS;
									break;
		case "Dangerous Road Conditions": 	correctEnum = Categories.ROAD_CONDITIONS;
											break;
		case "Street Cleaning": 	correctEnum = Categories.STREET_CLEANING;
									break;
		case "Street Lighting": 	correctEnum = Categories.STREET_LIGHTING;
									break;
		case "Trash/Bins": 			correctEnum = Categories.TRASH;
									break;
		default: 					correctEnum = Categories.OTHER;
									break;
	}
		
	return correctEnum;
		
	}
	
}
