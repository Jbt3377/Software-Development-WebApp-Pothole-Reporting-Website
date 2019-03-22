package views;

import org.h2.mvstore.MVMap;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Categories;
import model.Profile;
import model.Report;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import utils.Validator;
import web.WebRequest;
import web.WebResponse;

public class IndexView extends DynamicWebPage{
	
	public int hitcounter = 0;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

	public IndexView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
	}
	
	public boolean process(WebRequest toProcess) {
		
		if(toProcess.path.equalsIgnoreCase("indexview") || toProcess.path.equalsIgnoreCase("index.html")) {
			
			System.out.println("\n\nRequest for Web Page: " + toProcess.path);
			String email = toProcess.cookies.get("email");
			System.out.println("User Email: " + email);
			
			MVMap<String, Profile> profiles = db.s.openMap("Profiles");
			
			String stringToSendToBrowser = "";
			stringToSendToBrowser += "<!DOCTYPE html>\r\n";
			stringToSendToBrowser += "<html>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "<head>\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.4.0/dist/leaflet.css\" />\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.4.0/dist/leaflet.css\" integrity=\"sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA==\" crossorigin=\"\"/>\r\n";
			stringToSendToBrowser += "  <script src=\"https://unpkg.com/leaflet@1.4.0/dist/leaflet.js\" integrity=\"sha512-QVftwZFqvtRNi0ZyCtsznlKSWOStnDORoefr1enyq5mVL4tmKB3S/EnC3rRJcxCPavG10IcrVGSmPh6Qw5lwrg==\" crossorigin=\"\"></script>";
			stringToSendToBrowser += "</head>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "<body class=\"text-left\">\r\n";
			stringToSendToBrowser += "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n";
			stringToSendToBrowser += "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\r\n";
			stringToSendToBrowser += "        <span class=\"navbar-toggler-icon\"></span>\r\n";
			stringToSendToBrowser += "      </button>\r\n";
			stringToSendToBrowser += "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"index.html\">\n";
			stringToSendToBrowser += "          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n";
			stringToSendToBrowser += "          <b>&nbsp;FILL MY HOLE</b>\n";
			stringToSendToBrowser += "        </a>\n";
			stringToSendToBrowser += "        <ul class=\"navbar-nav mx-auto\">\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#reportForm\">Report a Problem</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"Help.html\">FAQ</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"AboutUsView\">About Us</a> </li>\r\n";
			stringToSendToBrowser += "        </ul>\r\n";
			stringToSendToBrowser += "        <ul class=\"navbar-nav\">\r\n";
			
			// Account actions alter depending if user is signed in
			if(profiles.get(email)!=null)
			{
				stringToSendToBrowser += "  		   <li class=\"nav-item\"> <a class=\"nav-link disabled\" href=\"#\">Welcome "+ email +"</a> </li>\n";
				stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
				stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link btn-primary text-light\" href=\"accountview\">Account</a> </li>\n";
			}
			else
			{
				stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.html\">Login</a> </li>\n";
				stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
				stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link btn-primary text-light\" href=\"signupview\">Register</a> </li>\n";
			}
			
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
			
			// Map of Belfast
			stringToSendToBrowser += "        \r\n" + 
					"<div id=\"mapid\" style=\"width: 1200px; height: 500px;\"></div>\r\n" + 
					"<script>" +
					"  var tileLayer = new L.TileLayer('http://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}.png', {\r\n" + 
					"    'attribution': 'Map data © <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors'\r\n" + 
					"  });\r\n" + 
					"\r\n" + 
					"  var map = new L.Map('mapid', {\r\n" + 
					"    'layers': [tileLayer]\r\n" + 
					"  }).setView([54.5973, -5.9301], 13);\r\n" + 
					"\r\n" + 
					"  var marker;\r\n" + 
					"\r\n" +
					"  map.on('click', function (e) {\r\n" + 
					"    if (marker) {\r\n" + 
					"      map.removeLayer(marker);\r\n" + 
					"    }\r\n" + 
					"    marker = new L.Marker(e.latlng).addTo(map)\r\n" + 
					"      .bindPopup(\"Problem Location: \" + e.latlng.toString()).openPopup();\r\n" +
					"    document.getElementById('location').value = e.latlng.toString()" +
					"  });"+
					"</script>\r\n";
			
			
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
			stringToSendToBrowser += "                  <li class=\"text-left py-2\"><b>Tell us! - </b>Provide us with information on the problem and we'll pass it onto the local council. You can include images as well!</li>\r\n";
			stringToSendToBrowser += "                </ol>\r\n";
			stringToSendToBrowser += "              </div>\r\n";
			stringToSendToBrowser += "            </div>\r\n";
			stringToSendToBrowser += "            <div class=\"card text-white bg-dark my-3\">\r\n";
			stringToSendToBrowser += "              <div class=\"card-header text-center\">\r\n";
			stringToSendToBrowser += "                <b class=\"w-100 h-100\"><b><span style=\"font-weight: bold;\">Recently Reported Problems</span></b></b><b class=\"w-100 h-100\"></b></div>\r\n";
			stringToSendToBrowser += "              <div class=\"card-body\">\r\n";
			stringToSendToBrowser += "                <div class=\"card bg-dark\">\r\n";
			
			// Display 3 most recent reports
			MVMap<String, Report> allReports = db.s.openMap("NewReports");
			List<String> reportKeys = allReports.keyList();
			int keyIndex = reportKeys.size()-1;
			
			// Check at least one report exists
			if(reportKeys.size() != 0) {
				
				// Iterates through up to 3 reports and display their details under "Recently Reported Problems"
				while(keyIndex>=(reportKeys.size()-3) && keyIndex!=-1)
				{
					String currentReportKey = reportKeys.get(keyIndex);
					Report currentReport = allReports.get(currentReportKey);
					
					stringToSendToBrowser += "                  <div class=\"card-body bg-primary my-2\">\r\n";
					stringToSendToBrowser += "                    <div class=\"row\">\r\n";
					stringToSendToBrowser += "                      <div class=\"col-md-6\">\r\n";
					stringToSendToBrowser += "                        <h5 class=\"card-title my-2 text-dark\" style=\"font-weight: bold\" align=\"left\">" + currentReport.description +"</h5>\r\n";
					stringToSendToBrowser += "                        <p align=\"left\">"+ currentReport.category.description() +"</p>\r\n";
					stringToSendToBrowser += "                        <p align=\"left\">"+ currentReport.timeStamp +"</p>\r\n";
					stringToSendToBrowser += "                      </div>\r\n";
					stringToSendToBrowser += "                      <div class=\"col-md-6\"><img class=\"img-fluid d-block\" src=\"/"+ currentReport.filePathToImage +"\" height=\"120\" width=\"120\" align=\"right\" alt=\"Picture of Problem\"></div>\r\n";			
					stringToSendToBrowser += "                    </div>\r\n";
					stringToSendToBrowser += "                  </div>\r\n";
					
					keyIndex--;
				}
			}else {
				stringToSendToBrowser += "                  <p>No Reports on Record</p>";
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
			stringToSendToBrowser += "                  <form action=\"/Report\" method=\"POST\" enctype=\"multipart/form-data\">\r\n";
			stringToSendToBrowser += "                    <!--Location (Text Input)-->\r\n";
			stringToSendToBrowser += "                    <label for=\"location\" class=\"w-100 text-left pt-2\"><b>Location</b></label>\r\n";
			stringToSendToBrowser += "                    <input type=\"text\" class=\"form-control text-left text-white\" name=\"location\" id=\"location\" placeholder=\"Mark your location on the map or tell us the address\" required=\"required\">\r\n";
			stringToSendToBrowser += "                    <!--Description (Text Input)-->\r\n";
			stringToSendToBrowser += "                    <label for=\"description\" class=\"w-100 text-left pt-2\"><b>Description</b></label>\r\n";
			stringToSendToBrowser += "                    <input type=\"text\" class=\"form-control text-left text-white\" name=\"desc\" placeholder=\"Provide a short despription of the problem\" required=\"required\">\r\n";
			stringToSendToBrowser += "                    <!--Category (Dropdown)-->\r\n";
			stringToSendToBrowser += "                    <label for=\"category\" class=\"w-100 text-left pt-2\"><b>Category</b></label>\r\n";
			stringToSendToBrowser += "                    <select class=\"form-control text-left text-primary\" name=\"category\" required=\"required\">\r\n";
			stringToSendToBrowser += "                      <option value=\"\" disabled=\"disabled\" selected=\"selected\">Select a Suitable Category</option>\r\n";
			
			for(Categories c: Categories.values()) {
				stringToSendToBrowser += "                      <option value=\""+ c.description() +"\">"+ c.description() +"</option>\r\n";
			}
			
			stringToSendToBrowser += "                    </select>\r\n";
			stringToSendToBrowser += "                    <!--Details (TextArea)-->\r\n";
			stringToSendToBrowser += "                    <label for=\"details\" class=\"w-100 text-left pt-2\"><b>Details</b></label>\r\n";
			stringToSendToBrowser += "                    <textarea name=\"details\" rows=\"10\" required=\"required\" cols=\"70\" class=\"form-control text-left w-100 text-white\" maxlength=\"255\"></textarea>\r\n";
			stringToSendToBrowser += "                    <!--Media (File Input)-->\r\n";
			stringToSendToBrowser += "                    <label for=\"files\" class=\"w-100 text-left pt-2\"><b>Photos/Videos</b></label>\r\n";
			stringToSendToBrowser += "                    <input type=\"file\" id=\"fileupload\" name=\"fileupload\" value=\"fileupload\" class=\"text-left form-control-file\">\r\n";
			stringToSendToBrowser += "                    <input value=\"Submit\" type=\"submit\" onclick=\"return clicked();\" class=\"mt-4\">\r\n";
			stringToSendToBrowser += "       			  <script>\r\n";
			stringToSendToBrowser += "       			    function clicked('" + email + "'){\r\n";
			stringToSendToBrowser += "       			      return confirm('Make sure you are signed in! If you want to keep up to date with the problem, sign in before submitting.');\r\n";
			stringToSendToBrowser += "       			    }\r\n";
			stringToSendToBrowser += "       			  </script>\r\n";
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
			if(email!=null)
			{	
					Validator.validate(db);
					Profile user = profiles.get(email);
					String password = user.password;
					if((user==null)||(!user.password.contentEquals(password)))
					{
					String stringToSendToWebBrowser = "";
					stringToSendToWebBrowser += "<!DOCTYPE html>\n";
					stringToSendToWebBrowser += "<html>\n";
					stringToSendToWebBrowser += "  <head>\n";
					stringToSendToWebBrowser += "    <title>Session Error</title>\n";
					stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
					stringToSendToWebBrowser += "    <meta  name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
					stringToSendToWebBrowser += "    <link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"/css/font-awesome.min.css\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"/css/blocks.css\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
					stringToSendToWebBrowser += "      <script src=\"/js/html5shiv.js\"></script>\n";
					stringToSendToWebBrowser += "      <script src=\"/js/respond.min.js\"></script>\n";
					stringToSendToWebBrowser += "    <![endif]-->\n";
					stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\n";
					stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\n";
					stringToSendToWebBrowser += "  <script>\n";
					stringToSendToWebBrowser += "      function clearLoginCookie()\n";
					stringToSendToWebBrowser += "      {\n";
					stringToSendToWebBrowser += "          document.cookie='email=;expires=' + new Date(0).toGMTString();\n";
					stringToSendToWebBrowser += "          document.cookie='password=;expires=' + new Date(0).toGMTString();\n";
					stringToSendToWebBrowser += "      }\n";
					stringToSendToWebBrowser += "  </script>\n";
					stringToSendToWebBrowser += "  </head>\n";
					

					
					stringToSendToWebBrowser += "  <body onload=\"clearLoginCookie()\">\n";
					stringToSendToWebBrowser += "    <h1>Session Error<h1>\n";
					stringToSendToWebBrowser += "    <h1><a href='/Index.html'>Click here to continue</a><h1>\n";
					stringToSendToWebBrowser += "  </body>\n";
					stringToSendToWebBrowser += "</html>\n";
					toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
					return true;

				}
			}
			return true;

		}else if(toProcess.path.equalsIgnoreCase("Report")) {
			
			System.out.println("Request to submit a Report: " + toProcess.path);
			
			// New Report Created
			Report problemReport = new Report();
			
			// Get details of new report provided
			problemReport.reportID = "report_"+System.currentTimeMillis();
			problemReport.location = toProcess.params.get("location");
			problemReport.description = toProcess.params.get("desc");
			problemReport.category = getCategory(toProcess.params.get("category"));
			problemReport.details = toProcess.params.get("details");
			problemReport.filePathToImage = toProcess.params.get("fileupload");

			// File upload
			try {
				File uploaded = new File(problemReport.filePathToImage);
				int ind = problemReport.filePathToImage.lastIndexOf('.');
				String extension = problemReport.filePathToImage.substring(ind);
				uploaded.renameTo(new File("httpdocs/"+problemReport.reportID+extension));
				problemReport.filePathToImage = problemReport.reportID+extension;
			}catch( StringIndexOutOfBoundsException e ) {
				// If no image provided, a default one is chosen.
				problemReport.filePathToImage = decideDefaultImage(problemReport.category);
			}
		
			
			// Get email of user who submitted if logged in
			String emailOfUserWhoSubmitted = toProcess.cookies.get("email");
			problemReport.usernameOfUserWhoReported = emailOfUserWhoSubmitted;
			
			// Time Stamp
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			problemReport.timeStamp = sdf.format(timestamp);
			
			// Add report to database
			MVMap<String, Report> allReports = db.s.openMap("NewReports");
			allReports.put(problemReport.reportID, problemReport);
			db.commit();
			
			// Console feedback - this is the report being saved to database
			System.out.println();
			System.out.println("== Problem has been successfully reported ==");
			System.out.println("ID: " + problemReport.reportID);
			System.out.println("Location: " + problemReport.location);
			System.out.println("Description: " + problemReport.description);
			System.out.println("Category: " + problemReport.category);
			System.out.println("Details: " + problemReport.details);
			System.out.println("File path to image: " + problemReport.filePathToImage);
			System.out.println("--------------------------------------------------------------");
			System.out.println("Timestamp: " + problemReport.timeStamp);
			System.out.println("User Submitted: " + problemReport.usernameOfUserWhoReported);
			System.out.println("Status: " + problemReport.isSolved);
			System.out.println();
			
			// Redirect to new page once report complete			
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><body><script>window.location.href = \"/SubmitSuccessful.html\"</script></body></html>");
	
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
