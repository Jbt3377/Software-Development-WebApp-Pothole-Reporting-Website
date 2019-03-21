package views;


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
		 
		String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"theme.css\" type=\"text/css\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n" + 
				"    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\">\r\n" + 
				"        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"      </button>\r\n" + 
				"      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"index.html\">\r\n" + 
				"          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\r\n" + 
				"          <b contenteditable=\"true\">&nbsp;FILL MY HOLE</b>\r\n" + 
				"        </a>\r\n" + 
				"        <ul class=\"navbar-nav mx-auto\">\r\n" + 
				"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"IndexView\">Report a Problem</a> </li>\r\n" + 
				"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\r\n" + 
				"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"help.html\">FAQ</a> </li>\r\n" + 
				"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"AboutUsView\">About Us</a> </li>\r\n" + 
				"        </ul>\r\n" + 
				"        <ul class=\"navbar-nav\">\r\n" + 
				"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"Login.html\">Log in</a> </li>\r\n" + 
				"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\r\n" + 
				"          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"SignUp.html\">Register</a> </li>\r\n" + 
				"        </ul>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </nav>\r\n" + 
				"  <div class=\"py-5 text-center text-white\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;\">\r\n" + 
				"    <div class=\"container\">\r\n" + 
				"      <div class=\"row\">\r\n" + 
				"        <div class=\"mx-auto col-md-12\">\r\n" + 
				"          <h1 class=\"mb-3\">Our team</h1>\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"      <div class=\"row\">\r\n" + 
				"        <div class=\"col-lg-4 col-md-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" alt=\"Card image cap\" width=\"200\">\r\n" + 
				"          <h4> <b>J. Beatty</b></h4>\r\n" + 
				"          <p class=\"mb-0\">Team 1 Member</p>\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"col-lg-4 col-md-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-2.svg\" alt=\"Card image cap\" width=\"200\">\r\n" + 
				"          <h4>D. Bell</h4>\r\n" + 
				"          <p class=\"mb-0\">Team 1 Member</p>\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"col-lg-4 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-3.svg\" width=\"200\">\r\n" + 
				"          <h4> <b>E. M. Atos</b></h4>\r\n" + 
				"          <p class=\"mb-0\">Team 1 Member&nbsp;</p>\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"  <div class=\"py-5 text-center\" style=\"background-image: url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-size: cover;\">\r\n" + 
				"    <div class=\"container\">\r\n" + 
				"      <div class=\"row bg-primary\" style=\"\">\r\n" + 
				"        <div class=\"bg-white p-5 mx-auto col-md-8 col-10 bg-dark\">\r\n" + 
				"          <h3 class=\"display-3 text-dark\" contenteditable=\"true\">Who we are</h3>\r\n" + 
				"          <p class=\"mb-3 lead text-primary\">&nbsp;</p>\r\n" + 
				"          <p class=\"mb-3 lead border text-dark border-secondary\" style=\"\">Fill My Hole is a website created by a group of students which wanted to help the Belfast community by making it easier to report any issues in the streets. We took inspiration for our name from a common street problem - pot holes&nbsp;</p>\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"  <div class=\"text-center text-white py-5\" style=\"background-image: url(&quot;https://static.pingendo.com/cover-moon.svg&quot;); background-size: cover; background-position: center top;\" >\r\n" + 
				"    <div class=\"container\">\r\n" + 
				"      <div class=\"row\" style=\"\">\r\n" + 
				"        <div class=\"mx-auto p-4 col-md-7\" style=\"\">\r\n" + 
				"          <h3 class=\"display-3\"><b>Support Us</b></h3>\r\n" + 
				"          <h1 contenteditable=\"true\"> Help us run this site </h1>\r\n" + 
				"          <h1>&nbsp;</h1>\r\n" + 
				"          <a class=\"btn btn-primary w-25 text-white\" href=\"SupportUs.html\">Donate</a>\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"  <div class=\"py-5 text-center align-items-center d-flex\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, 0.75), rgba(44, 62, 80, 0.75)); background-size: 100%;\">\r\n" + 
				"    <div class=\"container py-5\">\r\n" + 
				"      <div class=\"row\">\r\n" + 
				"        <div class=\"col-md-8 mx-auto bg-primary\"> <i class=\"d-block fa fa-stop-circle mb-3 text-muted fa-5x\"></i>\r\n" + 
				"          <h1 class=\"display-3 mb-4\">Fill My Hole</h1>\r\n" + 
				"          <p class=\"lead mb-5\">Have an issue with your street? We are here to help.&nbsp;<br>The mapped issue will be reported to the Belfast City Council<br></p> <a class=\"btn btn-lg mx-1 btn-outline-dark\" href=\"index.html\">Report A Problem</a>\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"  <div class=\"py-5\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, .75), rgba(44, 62, 80, .75));	background-size: 100%;\">\r\n" + 
				"    <div class=\"container\">\r\n" + 
				"      <div class=\"row\">\r\n" + 
				"        <div class=\"my-3 col-lg-8\">\r\n" + 
				"          <h1 class=\"text-center text-lg-left text-white\">Help others by sharing</h1>\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"text-center align-self-center col-lg-4\"> <a href=\"https://www.facebook.com/QUBelfast/\">\r\n" + 
				"            <i class=\"fa fa-fw fa-facebook text-white mx-3 fa-3x\"></i>\r\n" + 
				"          </a> <a href=\"https://twitter.com/QUBelfast\">\r\n" + 
				"            <i class=\"fa fa-fw fa-twitter fa-3x text-white mx-3\"></i>\r\n" + 
				"          </a> <a href=\"https://www.instagram.com/qubelfast/?hl=en\">\r\n" + 
				"            <i class=\"fa fa-fw fa-instagram fa-3x text-white mx-3\"></i>\r\n" + 
				"          </a> </div>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
				"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n" + 
				"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>"; 
		 
		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser ); 
		 
		return true; 
		} 
		return false; 
		} 
		 
		 

}