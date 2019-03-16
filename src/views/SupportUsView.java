package views;

import java.util.List;

import org.h2.mvstore.MVMap;

import model.Donation;
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
			//Donation test = new Donation();
			//test.name = "examplename";
			//test.amount = "exampleamount";
		 
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
		stringToSendToWebBrowser +="  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n";
		stringToSendToWebBrowser +="    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\n";
		stringToSendToWebBrowser +="        <span class=\"navbar-toggler-icon\"></span>\n";
		stringToSendToWebBrowser +="      </button>\n";
		stringToSendToWebBrowser +="      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"#\">\n";
		stringToSendToWebBrowser +="          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n";
		stringToSendToWebBrowser +="          <b>&nbsp;FILL MY HOLE</b>\n";
		stringToSendToWebBrowser +="        </a>\n";
		stringToSendToWebBrowser +="        <ul class=\"navbar-nav mx-auto\">\n";
		stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#report\">Report a Problem</a> </li>\n";
		stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\n";
		stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"help.html\">FAQ</a> </li>\n";
		stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"aboutusview\">About Us</a> </li>\n";
		stringToSendToWebBrowser +="        </ul>\n";
		stringToSendToWebBrowser +="        <ul class=\"navbar-nav\">\n";
		stringToSendToWebBrowser +="  <div class=\"py-5 text-center align-items-center d-flex\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, .75), rgba(44, 62, 80, .75)); background-size: 100%;\">\r\n";
		stringToSendToWebBrowser +="    <div class=\"container py-5\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"col-md-8 mx-auto bg-primary\"> <i class=\"d-block fa fa-stop-circle mb-3 text-muted fa-5x\"></i>\r\n";
		stringToSendToWebBrowser +="          <h1 class=\"display-3 mb-4\">Support Us</h1>\r\n";
		stringToSendToWebBrowser +="          <p class=\"lead mb-5\" style=\"\"> Help dus run this page by donating below</p>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";
		stringToSendToWebBrowser +="  <div class=\"pb-5 bg-dark\" style=\"\">\r\n";
		stringToSendToWebBrowser +="    <div class=\"container\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"mx-auto p-4 col-md-6\">\r\n";
		stringToSendToWebBrowser +="          <h2 class=\"mb-4\">What donating does to us&nbsp;</h2>\r\n";
		stringToSendToWebBrowser +="          <p>We are all university students and helps us pay our student loans! &nbsp;<br></p>\r\n";
		stringToSendToWebBrowser +="          <p class=\"mb-0 lead\">Thanks from the FillMyHole team!&nbsp;</p>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="        <div class=\"mx-auto p-4 col-md-6\">\r\n";
		stringToSendToWebBrowser +="          <h2 class=\"mb-4\">Donate here!</h2>\r\n"; 
//Donate form
		stringToSendToWebBrowser +="          <form action=\"/Donation\" method=\"GET\" class=\"\"> Name:<br class=\"\">\r\n";
		stringToSendToWebBrowser +="            <input type=\"text\" name=\"Name\" placeholder=\"Enter your name here\" class=\"\"><br> Amount:<br>\r\n";
		stringToSendToWebBrowser +="            <input type=\"text\" name=\"Amount\" placeholder=\"Enter the amount here\">\r\n";
		stringToSendToWebBrowser +="            <p contenteditable=\"true\">&nbsp;</p><br>\r\n";
		stringToSendToWebBrowser +="            <input type=\"submit\" value=\"Donate\" class=\"btn btn-primary\">\r\n"; 
		stringToSendToWebBrowser +="          </form>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n"; 
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";
//End of Donate form
		
//Recent Donations
		stringToSendToWebBrowser +="  <div class=\"text-center text-black align-items-center d-flex py-2 h-50\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\r\n"; 
		stringToSendToWebBrowser +="    <div class=\"container py-5\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"col-md-6\">\r\n"; 
		stringToSendToWebBrowser +="          <div class=\"card text-white bg-primary mb-3\">\r\n";
		stringToSendToWebBrowser +="            <div class=\"card-header h-25\" style=\"\">Recent Donators</div>\r\n";
		stringToSendToWebBrowser +="            <div class=\"card-body my-5 h-25\">\r\n";
		stringToSendToWebBrowser +="              <h5 class=\"card-title\">These are the names of people who recently donated</h5>\r\n";
		stringToSendToWebBrowser +="            </div>\r\n";
		stringToSendToWebBrowser +="          </div>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="        <div class=\"col-md-6\">\r\n";
		stringToSendToWebBrowser +="          <div class=\"list-group\">\r\n";
		stringToSendToWebBrowser +="            <a href=\"#\" class=\"list-group-item list-group-item-action flex-column align-items-start active\">\r\n";
		stringToSendToWebBrowser +="              <div class=\"d-flex w-100 justify-content-between\">\r\n";
		stringToSendToWebBrowser +="                <h5 class=\"mb-1\"> donate &nbsp;</h5> <small>Date</small>\r\n";
		stringToSendToWebBrowser +="              </div>\r\n";
		stringToSendToWebBrowser +="              <p class=\"mb-1\"> owo </p><small><br>&nbsp;<br></small> <small></small>\r\n";
		stringToSendToWebBrowser +="            </a>\r\n";
		stringToSendToWebBrowser +="            <a href=\"#\" class=\"list-group-item list-group-item-action flex-column align-items-start\">\r\n";
		stringToSendToWebBrowser +="              <div class=\"d-flex w-100 justify-content-between\">\r\n";
		stringToSendToWebBrowser +="                <h5 class=\"mb-1\">Donator 2</h5> <small class=\"text-muted\">Date</small>\r\n";
		stringToSendToWebBrowser +="              </div>\r\n";
		stringToSendToWebBrowser +="              <p class=\"mb-1\">Amount Donated</p> <small class=\"text-muted\">&nbsp;</small>\r\n";
		stringToSendToWebBrowser +="            </a><a href=\"#\" class=\"list-group-item list-group-item-action flex-column align-items-start active\">\r\n";
		stringToSendToWebBrowser +="              <div class=\"d-flex w-100 justify-content-between\">\r\n";
		stringToSendToWebBrowser +="                <h5 class=\"mb-1\">Donator 3</h5> <small>Date</small>\r\n";
		stringToSendToWebBrowser +="              </div>\r\n";
		stringToSendToWebBrowser +="              <p class=\"mb-1\">Amount Donate</p><small><br></small>\r\n";
		stringToSendToWebBrowser +="            </a>\r\n";
		stringToSendToWebBrowser +="          </div>\r\n"; 
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";
//End of recent Donations		

		stringToSendToWebBrowser +="  <div class=\"py-5\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, .75), rgba(44, 62, 80, .75));	background-size: 100%;\">\r\n";
		stringToSendToWebBrowser +="    <div class=\"container\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"my-3 col-lg-8\">\r\n";
		stringToSendToWebBrowser +="          <h1 class=\"text-center text-lg-left text-white\" style=\"\">Help others by sharing</h1>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="        <div class=\"text-center align-self-center col-lg-4\"> <a href=\"https://www.facebook.com/QUBelfast/\">\r\n";
		stringToSendToWebBrowser +="            <i class=\"fa fa-fw fa-facebook text-white mx-3 fa-3x\"></i>\r\n";
		stringToSendToWebBrowser +="          </a> <a href=\"https://twitter.com/QUBelfast\">\r\n";
		stringToSendToWebBrowser +="            <i class=\"fa fa-fw fa-twitter fa-3x text-white mx-3\"></i>\r\n";
		stringToSendToWebBrowser +="          </a> <a href=\"https://www.instagram.com/qubelfast/?hl=en\">\r\n";
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
			List<String> newDonatorKeys = newDonation.keyList();
			
			String stringToSendToWebBrowser = "<html><body><p>You have Successfully Donated!</p> <a href=\"IndexView\">Click this button to return to the homepage!</a></body></html>"; 
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser); 
			
			if(newDonatorKeys.size()==0) {
				Donation adonation = new Donation();
				adonation.donatorID = "" + System.currentTimeMillis();
				adonation.name = "a name";
				adonation.amount = "an amount";
				newDonation.put(adonation.donatorID, adonation);
				db.commit();
				newDonatorKeys = newDonation.keyList();
				
			}
			
			for (int index = 0; index < newDonatorKeys.size(); index++) {
				
				String newDonationUniqueID = newDonatorKeys.get(index);
				Donation adonation = newDonation.get(newDonationUniqueID);
				stringToSendToWebBrowser += "<div class=\"col-md-6\">\r\n" + 
						"          <div class=\"list-group\">\r\n" + 
						"            <a href=\"#\" class=\"list-group-item list-group-item-action flex-column align-items-start active\">\r\n" + 
						"              <div class=\"d-flex w-100 justify-content-between\">\r\n" + 
						"                <h5 class=\"mb-1\">Donator 1&nbsp;</h5> <small>Date</small>\r\n" + 
						"              </div>\r\n" + 
						"              <p class=\"mb-1\">Amount Donated</p><small><br>&nbsp;<br></small> <small></small>\r\n" + 
						"            </a>\r\n" + 
						"            <a href=\"#\" class=\"list-group-item list-group-item-action flex-column align-items-start\">\r\n" + 
						"              <div class=\"d-flex w-100 justify-content-between\">\r\n" + 
						"                <h5 class=\"mb-1\">"+adonation.name+"</h5> <small class=\"text-muted\">"+adonation.donatorID+"</small>\r\n" + 
						"              </div>\r\n" + 
						"              <p class=\"mb-1\">"+adonation.amount+"</p> <small class=\"text-muted\">&nbsp;</small>\r\n" + 
						"            </a><a href=\"#\" class=\"list-group-item list-group-item-action flex-column align-items-start active\">\r\n" + 
						"              <div class=\"d-flex w-100 justify-content-between\">\r\n" + 
						"                <h5 class=\"mb-1\">Donator 3</h5> <small>Date</small>\r\n" + 
						"              </div>\r\n" + 
						"              <p class=\"mb-1\">Amount Donate</p><small><br></small>\r\n" + 
						"            </a>\r\n" + 
						"          </div>\r\n" + 
						"        </div>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"  </div>";
			}
		}
			
			else
				if(toProcess.path.equalsIgnoreCase("AboutUsView/Submit/Donation"))
				{
					Donation donation = new Donation();
					donation.donatorID = "donation_"+System.currentTimeMillis();
					donation.name = toProcess.params.get("Name");
					donation.amount = toProcess.params.get("Amount");
					//donation.journalists.add(toProcess.params.get("journalist"));
					
					//At this point you would normally add the newsstory to the database
					MVMap<String, Donation> DS = db.s.openMap("Donation");
					DS.put(donation.donatorID, donation);
					
					//MVMap<String, NewsStory> newsStories = db.s.openMap("NewsStories");
					//newsStories.put(newsstory.uniqueid, newsstory);

					//The code is now updated to get the newsevent from the database
					MVMap<String, Donation> DE = db.s.openMap("Donation");
					Donation donations = DE.get(toProcess.params.get("donatedakanewsEvents"));
					
					//The code is now updated to get the newsevent from the database
					//MVMap<String, NewsEvent> newsEvents = db.s.openMap("NewsEvents");
					//NewsEvent newsevent = newsEvents.get(toProcess.params.get("newsEvent"));

					//By adding the newsstory to the newsevent it should appear on the main page
					donations.donator.add(donations.donatorID);

					//put the news event back in the database after it has been changed
					DE.put(donations.donatorID, donations);

					//Commit the changes to save to disk
					db.commit();


					//This code will get the website that this submit was made from it is part of the information sent by a web browser to the webserver
		    		String url = toProcess.header.get("referer");
					toProcess.r = new WebResponse( WebResponse.HTTP_REDIRECT, WebResponse.MIME_HTML,
											   "<html><body>Redirected: <a href=\"" + url + "\">" +
											   url + "</a></body></html>");
					toProcess.r.addHeader( "Location", url );
					return true;
				}
		
			
		return false; 
		 
	}
}
