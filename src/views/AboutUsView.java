package views;


import org.h2.mvstore.MVMap;

import model.Profile;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class AboutUsView extends DynamicWebPage {

	public AboutUsView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
		// TODO Auto-generated constructor stub
	}
	public boolean process(WebRequest toProcess) { 
		if(toProcess.path.equalsIgnoreCase("aboutusview")) 
		{ 
			MVMap<String, Profile> profiles = db.s.openMap("Profiles");
			String email = toProcess.cookies.get("email");
			
		String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n";
		stringToSendToWebBrowser +="<html>\r\n"; 
		stringToSendToWebBrowser +="\r\n";
		stringToSendToWebBrowser +="<head>\r\n";
		stringToSendToWebBrowser +="  <meta charset=\"utf-8\">\r\n";
		stringToSendToWebBrowser +="  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n";
		stringToSendToWebBrowser +="  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
		stringToSendToWebBrowser +="  <link rel=\"stylesheet\" href=\"theme.css\" type=\"text/css\">\r\n";
		stringToSendToWebBrowser +="  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n";
		stringToSendToWebBrowser +="</head>\r\n";
		stringToSendToWebBrowser +="\r\n";
		stringToSendToWebBrowser +="<body>\r\n";
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
		
		// Account actions alter depending if user is signed in
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
		stringToSendToWebBrowser +="  <div class=\"py-5 text-center text-white\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;\">\r\n"; 
		stringToSendToWebBrowser +="    <div class=\"container\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"mx-auto col-md-12\">\r\n";
		stringToSendToWebBrowser +="          <h1 class=\"mb-3\">Our team</h1>\r\n"; 
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n" ;
		stringToSendToWebBrowser +="        <div class=\"col-lg-4 col-md-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"josh.jpg\" alt=\"Card image cap\" width=\"200\">\r\n";
		stringToSendToWebBrowser +="          <h4> <b>J. Beatty</b></h4>\r\n";
		stringToSendToWebBrowser +="          <p class=\"mb-0\">Project Manager</p>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="        <div class=\"col-lg-4 col-md-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"daniel.jpg\" alt=\"Card image cap\" width=\"200\">\r\n";
		stringToSendToWebBrowser +="          <h4>D. Bell</h4>\r\n";
		stringToSendToWebBrowser +="          <p class=\"mb-0\">Boiler Boy</p>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n" ;
		stringToSendToWebBrowser +="        <div class=\"col-lg-4 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"ericka.jpg\" width=\"200\">\r\n";
		stringToSendToWebBrowser +="          <h4> <b>E. M. Atos</b></h4>\r\n";
		stringToSendToWebBrowser +="          <p class=\"mb-0\">Meme Queen&nbsp;</p>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";
		stringToSendToWebBrowser +="  <div class=\"py-5 text-center\" style=\"background-image: url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-size: cover;\">\r\n";
		stringToSendToWebBrowser +="    <div class=\"container\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row bg-white border-primary\" style=\"\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"bg-white p-5 mx-auto col-md-8 col-10 bg-dark\">\r\n";
		stringToSendToWebBrowser +="          <h3 class=\"display-3 text-dark\" contenteditable=\"true\">Who we are</h3>\r\n";
		stringToSendToWebBrowser +="          <p class=\"mb-3 lead text-primary\">&nbsp;</p>\r\n";
		stringToSendToWebBrowser +="          <p class=\"mb-3 lead text-dark \" style=\"\">Fill My Hole is a website created by a group of students which wanted to help the Belfast community by making it easier to report any issues in the streets. We took inspiration for our name from a common street problem - pot holes&nbsp;</p>\r\n"; 
		stringToSendToWebBrowser +="        </div>\r\n"; 
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";
		stringToSendToWebBrowser +="  <div class=\" text-center align-items-center d-flex text-center text-white py-5\" style=\"background-image: url(&quot;https://static.pingendo.com/cover-moon.svg&quot;); background-size: cover; background-position: center top;\" >\r\n";
		stringToSendToWebBrowser +="    <div class=\"container\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\" style=\"\">\r\n"; 
		stringToSendToWebBrowser +="        <div class=\"mx-auto p-4 col-md-7\" style=\"\">\r\n"; 
		stringToSendToWebBrowser +="          <h3 class=\"display-3\"><b>Support Us</b></h3>\r\n"; 
		stringToSendToWebBrowser +="          <h1 contenteditable=\"true\"> Help us run this site </h1>\r\n";
		stringToSendToWebBrowser +="          <h1>&nbsp;</h1>\r\n";
		stringToSendToWebBrowser +="          <a class=\"btn btn-primary w-25 text-white\" href=\"SupportUs.html\">Donate</a>\r\n";
		stringToSendToWebBrowser +="        </div>\r\n";
		stringToSendToWebBrowser +="      </div>\r\n";
		stringToSendToWebBrowser +="    </div>\r\n";
		stringToSendToWebBrowser +="  </div>\r\n";
		stringToSendToWebBrowser +="  <div class=\"py-5 text-center align-items-center d-flex\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, 0.75), rgba(44, 62, 80, 0.75)); background-size: 100%;\">\r\n";
		stringToSendToWebBrowser +="    <div class=\"container py-5\">\r\n";
		stringToSendToWebBrowser +="      <div class=\"row\">\r\n";
		stringToSendToWebBrowser +="        <div class=\"col-md-8 mx-auto bg-primary\"> <i class=\"d-block fa fa-stop-circle mb-3 text-muted fa-5x\"></i>\r\n";
		stringToSendToWebBrowser +="          <h1 class=\"display-3 mb-4\">Fill My Hole</h1>\r\n";
		stringToSendToWebBrowser +="          <p class=\"lead mb-5\">Have an issue with your street? We are here to help.&nbsp;<br>The mapped issue will be reported to the Belfast City Council<br></p> <a class=\"btn btn-lg mx-1 mb-2 btn-outline-dark\" href=\"index.html\">Report A Problem</a>\r\n";
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
		//End of Footer
				stringToSendToWebBrowser +="  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\" style=\"\"></script>\r\n";
				stringToSendToWebBrowser +="  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\" style=\"\"></script>\r\n";
				stringToSendToWebBrowser +="  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\r\n"; 
				stringToSendToWebBrowser +="</body>\r\n";
				stringToSendToWebBrowser +="\r\n";
				stringToSendToWebBrowser +="</html>"; 
		 
		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser ); 
		 
		return true; 
		} 
		return false; 
		} 
		 
		 

}