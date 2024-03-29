package views;

import java.util.List;
import org.h2.mvstore.MVMap;
import model.Donation;
import model.Profile;
import model.Report;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class SupportUsView extends DynamicWebPage {
	
	public SupportUsView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
		// TODO Auto-generated constructor stub
	}

	public boolean process(WebRequest toProcess) { 
		
		if(toProcess.path.equalsIgnoreCase("supportus.html")) 
		{ 
			
			MVMap<String, Profile> profiles = db.s.openMap("Profiles");
			String email = toProcess.cookies.get("email");
			
			Donation donation = new Donation();
			
			donation.donatorID = "donation_" +System.currentTimeMillis();
			donation.name = toProcess.params.get("Name");
			donation.amount = toProcess.params.get("Amount");		 
				
		String stringToSendToWebBrowser = "";		
		stringToSendToWebBrowser +="<html>\n";
		stringToSendToWebBrowser +="\n";
		stringToSendToWebBrowser +="<head>\n";
		stringToSendToWebBrowser +="  <meta charset=\"utf-8\">\n";
		stringToSendToWebBrowser +="  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
		stringToSendToWebBrowser +="  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
		stringToSendToWebBrowser +="  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\n";
		stringToSendToWebBrowser +="</head>\n";
		stringToSendToWebBrowser +="\n";
		stringToSendToWebBrowser +="<body class=\"text-left\">\n";
		stringToSendToWebBrowser += "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n";
		stringToSendToWebBrowser += "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\r\n";
		stringToSendToWebBrowser += "        <span class=\"navbar-toggler-icon\"></span>\r\n";
		stringToSendToWebBrowser += "      </button>\r\n";
		stringToSendToWebBrowser += "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"index.html\">\n";
		stringToSendToWebBrowser += "          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n";
		stringToSendToWebBrowser += "          <b>&nbsp;FILL MY HOLE</b>\n";
		stringToSendToWebBrowser += "        </a>\n";
		stringToSendToWebBrowser += "        <ul class=\"navbar-nav mx-auto\">\r\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"index.html#reportForm\">Report a Problem</a> </li>\r\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\r\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"Help.html\">FAQ</a> </li>\r\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"AboutUsView\">About Us</a> </li>\r\n";
		stringToSendToWebBrowser += "        </ul>\r\n";
		stringToSendToWebBrowser += "        <ul class=\"navbar-nav\">\r\n";
		
		// Nav bar welcomes the user
		if(profiles.get(email)!=null)
		{
			stringToSendToWebBrowser += "  		   <li class=\"nav-item\"> <a class=\"nav-link disabled\" href=\"#\">Welcome "+ email +"</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link btn-primary text-light\" href=\"accountview\">Account</a> </li>\n";
		}
		else
		{
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.html\">Login</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link btn-primary text-light\" href=\"signupview\">Register</a> </li>\n";
		}
		
		stringToSendToWebBrowser += "        </ul>\r\n";
		stringToSendToWebBrowser += "      </div>\r\n";
		stringToSendToWebBrowser += "    </div>\r\n";
		stringToSendToWebBrowser += "  </nav>\r\n";
		stringToSendToWebBrowser +="  <div class=\"py-5 text-center align-items-center d-flex\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\r\n";
		stringToSendToWebBrowser +="    <div class=\"container py-5\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"col-md-8 mx-auto bg-primary\"> <i class=\"d-block fa fa-stop-circle mb-3 text-muted fa-5x\"></i>\r\n";
		stringToSendToWebBrowser +="          <h1 class=\"display-3 mb-4\">Support Us</h1>\r\n";
		stringToSendToWebBrowser +="          <p class=\"lead mb-5 text-white\" style=\"\"> Help us run this page by donating below</p>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";
		stringToSendToWebBrowser +="  <div class=\"pb-5 bg-dark\" style=\"\">\r\n";
		stringToSendToWebBrowser +="    <div class=\"container\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"mx-auto p-4 col-md-6\">\r\n";
		stringToSendToWebBrowser +="          <h2 class=\"mb-4\">What donating does to us&nbsp;</h2>\r\n";
		stringToSendToWebBrowser +="          <p class=\"mb-0 lead text-white\">We are a team of University students and donating will allow us to improve our site and also pay for our loans!&nbsp;</p>\r\n";
		stringToSendToWebBrowser +="          <p class=\"text-primary\">To donate, enter your first name and enter an amount you wish to donate! &nbsp;<br></p>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="        <div class=\"mx-auto p-4 col-md-6\">\r\n";

		stringToSendToWebBrowser +="          <h2 class=\"mb-4\">Donate here!</h2>\r\n"; 
//Donate form
		stringToSendToWebBrowser +="          <form action=\"/Donation\" method=\"GET\" class=\"\"> Name:<br class=\"\">\r\n";
		stringToSendToWebBrowser +="            <input type=\"text\" name=\"Name\" placeholder=\"Enter your name here\" class=\"text-dark\"><br> Amount:<br>\r\n";
		stringToSendToWebBrowser +="            <input type=\"text\" name=\"Amount\" placeholder=\"Enter the amount here\"class=\"text-dark\">\r\n";
		stringToSendToWebBrowser +="            <p contenteditable=\"true\">&nbsp;</p><br>\r\n";
		stringToSendToWebBrowser +="            <input type=\"submit\" value=\"Donate\" class=\"btn btn-primary\">\r\n"; 
		stringToSendToWebBrowser +="          </form>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n"; 
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";
//End of Donate form
		
//Recent Donations
		stringToSendToWebBrowser +="  <div class=\"text-center text-black align-items-center d-flex py-2 h-100\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\r\n"; 
		stringToSendToWebBrowser +="    <div class=\"container py-5\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"col-md-6\">\r\n"; 
		stringToSendToWebBrowser +="          <div class=\"card text-white bg-primary mb-3\">\r\n";
		stringToSendToWebBrowser +="            <div class=\"card-header h-25\" style=\"\">Recent Donators</div>\r\n";
		stringToSendToWebBrowser +="            <div class=\"card-body my-5 h-25\">\r\n";
		stringToSendToWebBrowser +="              <h5 class=\"card-title\">These are the top 4 people who have recently donated</h5>\r\n";
		stringToSendToWebBrowser +="            </div>\r\n";
		stringToSendToWebBrowser +="          </div>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		
		stringToSendToWebBrowser +="        <div class=\"col-md-6\">\r\n";
		stringToSendToWebBrowser +="          <div class=\"list-group\">\r\n";

		
		/*
		  	Test if no donations are there
		  
		    if(newDonatorKeys.size()==0) {
			Donation adonation = new Donation();
			adonation.donatorID = "" + System.currentTimeMillis();
			adonation.name = "a name";
			adonation.amount = "an amount";
			Donation.put(adonation.donatorID, adonation);
			db.commit();
			newDonatorKeys = Donation.keyList();
		} 
		*/

			MVMap<String, Donation> Donation = db.s.openMap("Donation");
			List<String> newDonatorKeys = Donation.keyList();
			int index = newDonatorKeys.size()-1;
			
			if(newDonatorKeys.size() != 0) {
				
				while(index>=(newDonatorKeys.size()-4) && index!=-1)
				{
					String newDonationKeys = newDonatorKeys.get(index);
					Donation adonation = Donation.get(newDonationKeys);

			stringToSendToWebBrowser +="            <a href=\"#\" class=\"list-group-item list-group-item-action flex-column align-items-start active\">\r\n";
			stringToSendToWebBrowser +="              <div class=\"d-flex w-100 justify-content-between\">\r\n";	
		stringToSendToWebBrowser +="                <h5 class=\"mb-1 \">"+ adonation.name+"&nbsp;</h5> <small>"+adonation.donatorID+"</small>\r\n";
		stringToSendToWebBrowser +="              </div>\r\n";
		stringToSendToWebBrowser +="              <p class=\"mb-1 text-dark\"> "+adonation.amount+" </p><small><br>&nbsp;<br></small> <small></small>\r\n";
		stringToSendToWebBrowser +="            </a>\r\n";
		
		index--;
				} 
			}else  {
					stringToSendToWebBrowser += "                  <p>No donators yet!</p>";
				}

//End of recent Donations		
		

		stringToSendToWebBrowser +="          </div>\r\n"; 
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";

		//Footer
		stringToSendToWebBrowser +="  <div class=\"py-3 bg-dark\">\r\n";
		stringToSendToWebBrowser +="    <div class=\"container\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"my-3 col-lg-8\">\r\n";
		stringToSendToWebBrowser +="          <h2 class=\"text-center text-lg-left text-white\" style=\"\">Help others by sharing</h2>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="        <div class=\"text-center align-self-center col-lg-4\"> <a href=\"https://www.facebook.com/FMH-308708959763566/\">\r\n";
		stringToSendToWebBrowser +="            <i class=\"fa fa-fw fa-facebook text-white mx-3 fa-3x\"></i>\r\n";
		stringToSendToWebBrowser +="          </a> <a href=\"https://twitter.com/QUBelfast\">\r\n";
		stringToSendToWebBrowser +="            <i class=\"fa fa-fw fa-twitter fa-3x text-white mx-3\"></i>\r\n";
		stringToSendToWebBrowser +="          </a> <a href=\"https://www.instagram.com/fmhwebpage/\">\r\n";
		stringToSendToWebBrowser +="            <i class=\"fa fa-fw fa-instagram fa-3x text-white mx-3\"></i>\r\n";
		stringToSendToWebBrowser +="          </a> </div>\r\n";
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";
		stringToSendToWebBrowser +="  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\" style=\"\"></script>\r\n";
		stringToSendToWebBrowser +="  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\" style=\"\"></script>\r\n";
		stringToSendToWebBrowser +="  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\r\n"; 
		stringToSendToWebBrowser +="</body>\r\n";
		stringToSendToWebBrowser +="\r\n";
		stringToSendToWebBrowser +="</html>"; 
		
			
		 
		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser ); 
		 
		return true; 
		}  else if(toProcess.path.equalsIgnoreCase("donation")) { 
			Donation newdonation = new Donation();
			
			newdonation.donatorID = "donation_" +System.currentTimeMillis();
			newdonation.name = toProcess.params.get("Name");
			newdonation.amount = toProcess.params.get("Amount");
			
			MVMap<String, Donation> newDonation = db.s.openMap("Donation");
			newDonation.put(newdonation.donatorID, newdonation);
			db.commit();

			
			String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"  <meta charset=\"utf-8\">\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"https://static.pingendo.com/bootstrap/bootstrap-4.2.1.css\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					"  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;\" >\r\n" + 
					"    <div class=\"container py-5\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-8 mx-auto bg-primary\"> <i class=\"d-block fa fa-stop-circle mb-3 text-muted fa-5x\"></i>\r\n" + 
					"          <h1 class=\"display-3 mb-4\">Thank You!</h1>\r\n" + 
					"          <p class=\"lead mb-5 text-white\" style=\"\">You have successfully donated! Click the button to return to the Support Page!<br></p><a class=\"btn btn-dark\" href=\"supportus.html\">Support Us Page</a>\r\n" + 
					"<h4 style=\"\" >&nbsp;</h4>\r\n"+
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"py-5\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, .75), rgba(44, 62, 80, .75));	background-size: 100%;\" >\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"my-3 col-lg-8\">\r\n" + 
					"          <h1 class=\"text-center text-lg-left text-white\">Help others by sharing</h1>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"text-center align-self-center col-lg-4\"> <a href=\"https://www.facebook.com/FMH-308708959763566/\">\r\n" + 
					"            <i class=\"fa fa-fw fa-facebook text-white mx-3 fa-3x\"></i>\r\n" + 
					"          </a> <a href=\"https://twitter.com/QUBelfast\">\r\n" + 
					"            <i class=\"fa fa-fw fa-twitter fa-3x text-white mx-3\"></i>\r\n" + 
					"          </a> <a href=\"https://www.instagram.com/fmhwebpage/\">\r\\n" +
					"            <i class=\"fa fa-fw fa-instagram fa-3x text-white mx-3\"></i>\r\n" + 
					"          </a> </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					//Footer
					"  <div class=\"py-3 bg-dark\">\r\n"+
					"    <div class=\"container\">\r\n"+
					"      <div class=\"row\">\r\n"+
					"        <div class=\"my-3 col-lg-8\">\r\n"+
					"          <h2 class=\"text-center text-lg-left text-white\" style=\"\">Help others by sharing</h2>\r\n"+
					"        </div>\r\n"+
					"        <div class=\"text-center align-self-center col-lg-4\"> <a href=\"https://www.facebook.com/FMH-308708959763566/\">\r\n"+
					"            <i class=\"fa fa-fw fa-facebook text-white mx-3 fa-3x\"></i>\r\n"+
					"          </a> <a href=\"https://twitter.com/QUBelfast\">\r\n"+
					"            <i class=\"fa fa-fw fa-twitter fa-3x text-white mx-3\"></i>\r\n"+
					"          </a> <a href=\"https://www.instagram.com/fmhwebpage/\">\r\n"+
					"            <i class=\"fa fa-fw fa-instagram fa-3x text-white mx-3\"></i>\r\n"+
					"          </a> </div>\r\n"+
					"      </div>\r\n"+
					"    </div>\r\n"+
					"  </div>\r\n"+
					"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
					"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\r\n" + 
					"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\r\n" + 
					"</body>\r\n" + 
					"\r\n" + 
					"</html>";
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser); 
			

		}
			
			
		
			
		return false; 
		 
	
	}
}