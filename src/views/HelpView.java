package views;

import java.util.List;

import org.h2.mvstore.MVMap;


import model.FAQ;
import model.Profile;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class HelpView extends DynamicWebPage
{
	public HelpView(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
        if(toProcess.path.equalsIgnoreCase("Help.html"))
        {
			MVMap<String, Profile> profiles = db.s.openMap("Profiles");
			String email = toProcess.cookies.get("email");
        	
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n";
        	stringToSendToWebBrowser +="<html>\n";
        	stringToSendToWebBrowser +="\n";
        	stringToSendToWebBrowser +="<head>\n";
        	stringToSendToWebBrowser +="  <meta charset=\"utf-8\">\n";
        	stringToSendToWebBrowser +="  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" ;
        	stringToSendToWebBrowser +="  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n" ;
        	stringToSendToWebBrowser +="  <link rel=\"stylesheet\" href=\"a.css\">\n" ;
        	stringToSendToWebBrowser +="  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\n" ;
        	stringToSendToWebBrowser +="</head>\n" ;
        	stringToSendToWebBrowser +="\n" ;
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
    		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#reportForm\">Report a Problem</a> </li>\r\n";
    		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\r\n";
    		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"HelpView\">FAQ</a> </li>\r\n";
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
        	



        	
        	//Start of form
        	stringToSendToWebBrowser +="<div class=\"py-5 text-center text-white\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;\" >\n";
        	stringToSendToWebBrowser +="<div class=\"container\">";
        	stringToSendToWebBrowser +="<div class=\"row\">";
        	stringToSendToWebBrowser +="<div class=\"mx-auto col-md-12\">";
        	stringToSendToWebBrowser +="<h1 class=\"mb-5 text-primary\">Ask A Question!</h1>\n";
        	stringToSendToWebBrowser +="</div>\n";
        	stringToSendToWebBrowser +="</div>";
        	stringToSendToWebBrowser +="<div class=\"row\">";
        	stringToSendToWebBrowser +="<div class=\"col-md-9  ml-5 pl-5  offset-md-5\">";
        	stringToSendToWebBrowser +="<form action=\"/FAQ\" method=\"GET\" class=\"\">";
        	stringToSendToWebBrowser +="<div class=\"form-group row\"> <label for=\"title\" class=\"col-2 col-form-label text-primary\"><b class=\"ml-5\">Title</b></label>";
        	stringToSendToWebBrowser +=" <div class=\"col-10 \">";
        	stringToSendToWebBrowser +=" <input type=\"text\" class=\"form-control bg-light text-dark\" id=\"title\" name=\"title\" placeholder=\"Question title e.g. Login Issue\"> </div>";
        	stringToSendToWebBrowser +="</div>";
        	stringToSendToWebBrowser +="<div class=\"form-group row\"> <label for=\"description\" class=\"col-2 col-form-label text-primary\"><b>Description</b></label>";
        	stringToSendToWebBrowser +=" <div class=\"col-10\">";
        	stringToSendToWebBrowser +=" <input type=\"text\" class=\"form-control bg-light text-dark\" id=\"description\" name=\"description\" placeholder=\"Question description e.g. Can't Login\"> </div>";
        	stringToSendToWebBrowser +="</div>";
        	stringToSendToWebBrowser +="<div class=\"form-group row\"> <label for=\"category\" class=\"col-2 col-form-label text-primary\"><b>Category</b></label>";
        	stringToSendToWebBrowser +=" <div class=\"col-10\">";
        	stringToSendToWebBrowser +=" <input type=\"text\" class=\"form-control bg-light text-dark\" id=\"category\" name=\"category\" placeholder=\"Question category e.g. Account\"> </div>";
        	stringToSendToWebBrowser +="</div>";
        	stringToSendToWebBrowser +=" <button type=\"submit\" class=\"btn btn-primary\">Submit</button>";
        	stringToSendToWebBrowser +="</form>";
        	stringToSendToWebBrowser +="</div>";
        	stringToSendToWebBrowser +=" </div>";
        	stringToSendToWebBrowser +=" </div>";
        	stringToSendToWebBrowser +=" </div>";
        	//End of Form
        	//Categories        	
        	stringToSendToWebBrowser +="  <div class=\"py-5 text-center bg-dark  \">\n";
        	stringToSendToWebBrowser +="    <div class=\"container\">\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"mx-auto col-md-12 offset-md-2\">\n";
        	stringToSendToWebBrowser +="          <h1 class=\"mb-3\">Categories</h1>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="      </div>\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-moon.svg\" width=\"200\" alt=\"Card image cap\">\n";
        	stringToSendToWebBrowser +="          <h4><a class=\"btn btn-primary m-2 my-3 mb-4\" href=\"#start\"> <b>Getting Started</b></a></h4>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-3\">&nbsp;</p>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-0 text-white\">How to use our site<br></p>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-bubble-light.svg\" width=\"200\" alt=\"Card image cap\">\n";
        	stringToSendToWebBrowser +="          <h4><a class=\"btn btn-primary m-2 my-3 mb-4\" href=\"#account\">Account</a></h4>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-3\">&nbsp;</p>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-0 text-white\">Registering with us</p>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-bubble-dark.svg\" width=\"200\">\n";
        	stringToSendToWebBrowser +="          <h4><a class=\"btn btn-primary m-2 my-3 mb-4\" href=\"#siteIssues\">Site Issues</a></h4>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-3\">&nbsp;</p>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-0 text-white\"> Problems with the site</p>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-moon.svg\" width=\"200\">\n";
        	stringToSendToWebBrowser +="          <h4><a class=\"btn btn-primary m-2 my-3 mb-4\" href=\"#legal\">Legal Information</a></h4>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-3\">&nbsp;</p>\n"; 
        	stringToSendToWebBrowser +="          <p class=\"mb-0 text-white\">Privacy</p>\n"; 
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="      </div>\n";
        	stringToSendToWebBrowser +="    </div>\n";
        	stringToSendToWebBrowser +="  </div>\n";
        	
        	
//Getting started
        	stringToSendToWebBrowser += "			   <a name=\"start\"></a>\n";
        	stringToSendToWebBrowser +="  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\n";
        	stringToSendToWebBrowser +="    <div class=\"container py-5\">\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"col-md-12\">\n";
        	stringToSendToWebBrowser +="          <div class=\"card text-white bg-dark mb-3\">\n";
        	stringToSendToWebBrowser +="            <div class=\"card-header text-left\">\n";
        	stringToSendToWebBrowser +="              <h2 class=\"card-title text-primary text-center\"><b style=\"\">Getting Started&nbsp;</b></h2>\n";
        	stringToSendToWebBrowser +="            </div>\n";
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-light\" style=\"\">\n";
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-dark border-secondary\"><u><b>How Do I Make A Report?</b></u></h5>\n";
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-dark text-left\"><b>1. </b>Start at the homepage use the map to locate you automatically. You can also type in your postcode or a place name.&nbsp;<br><b>2. </b>Put the pin in the map to show exactly where the problem is, and type in a description of the issue. Then send.&nbsp;<br><b>3.</b> You have reported the issue!.</h6>\n";
        	stringToSendToWebBrowser +="            </div>\n"; 
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-dark\" style=\"\">\n";
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-white\"><u><b>What Can I Report?</b></u></h5>\n";
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-left text-white\" contenteditable=\"true\">FillMyHole is primarily for reporting things which are broken or dirty or damaged or dumped, and need fixing, cleaning or clearing, like graffiti, dog fouling, potholes or street lights that don't work.&nbsp;</h6>\n";
        	stringToSendToWebBrowser +="            </div>\n";
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-light\" style=\"\">\n";
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-dark\"><u><b>Are My Reports Public?</b></u></h5>\n" ;
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-dark text-left\"><b>Yes they are: when you submit your report, we send it to the council, and we also publish it on the website. Your council will respond directly to you, and from that point on, your correspondence is one-to-one.&nbsp;</b></h6>\n";
        	stringToSendToWebBrowser +="            </div>\n";
        	stringToSendToWebBrowser +="          </div>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="      </div>\n";
        	stringToSendToWebBrowser +="    </div>\n";
        	stringToSendToWebBrowser +="  </div>\n";
//End of GS        	
        	stringToSendToWebBrowser += "			   <a name=\"account\"></a>\n";
        	stringToSendToWebBrowser +="  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\n" ;
        	stringToSendToWebBrowser +="    <div class=\"container py-5\">\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"col-md-12\">\n";
        	stringToSendToWebBrowser +="          <div class=\"card text-white bg-dark mb-3\">\n";
        	stringToSendToWebBrowser +="            <div class=\"card-header text-left\">\n";
        	stringToSendToWebBrowser +="              <h2 class=\"card-title text-primary text-center\"><b style=\"\">Account</b></h2>\n"; 
        	stringToSendToWebBrowser +="            </div>\n";
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-light\" style=\"\">\n";
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-dark border-secondary\"><b><u>Do I need to register with FillMyHole to use it?</u></b></h5>\n";
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-dark text-left\"><b>No – you can send a report without registering. However, we recommend creating an account as you'll also be able to see all previous reports you've made on one page.&nbsp;</b></h6>\n";
        	stringToSendToWebBrowser +="            </div>\n";
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-dark\" style=\"\">\n"; 
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-white\"><b><u>How do I register?</u></b></h5>\n";
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-left text-white\">Visit our login page and register with your details. &nbsp; Click the 'Register' down below to register&nbsp;<a class=\"nav-link text-primary\" href=\"signup.html\">Register</a></h6>\n" ;
        	stringToSendToWebBrowser +="            </div>\n" ;
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-light\" style=\"\">\n";
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-dark\"><b><u>How do you recover a password?</u></b></h5>\n";
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-dark text-left\"><b>Contact our team and we will send you an email with your password on it!</b></h6>\n" ;
        	stringToSendToWebBrowser +="            </div>\n";
        	stringToSendToWebBrowser +="          </div>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="      </div>\n";
        	stringToSendToWebBrowser +="    </div>\n";
        	stringToSendToWebBrowser +="  </div>\n"; 
//End of Account   
              	
        	
        	
        	//Site Issues  
        	stringToSendToWebBrowser += "			   <a name=\"siteIssues\"></a>\n";
        	stringToSendToWebBrowser +="  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\n";
        	stringToSendToWebBrowser +="    <div class=\"container py-5\">\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"col-md-12\">\n";
        	stringToSendToWebBrowser +="          <div class=\"card text-white bg-dark mb-3\">\n" ;
        	stringToSendToWebBrowser +="            <div class=\"card-header text-left\">\n" ;
        	stringToSendToWebBrowser +="              <h2 class=\"card-title text-primary text-center\"><b style=\"\">Site Issues</b></h2>\n" ;
        	stringToSendToWebBrowser +="            </div>\n" ;
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-light\" style=\"\">\n";
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-dark border-secondary\"><b><u>The site isn't working</u></b></h5>\n" ;
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-dark text-left\"><b>Make sure that you are connected to the internet first. Once connected, refresh the page and it should be working.<br><br>If the site still does not work, email our team. We will contact you once we havve fixed the site</b></h6>\n";
        	stringToSendToWebBrowser +="            </div>\n";
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-dark\" style=\"\">\n";
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-white\"><b><u>No catagory for my issue</u></b></h5>\n";
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-left text-white\">The problems listed in the report form are the most common reported issues to the council.&nbsp;<br>To report the issue - click 'Other' and fill in the details as detailed as possible.</h6>\n";
        	stringToSendToWebBrowser +="            </div>\n";
        	stringToSendToWebBrowser +="          </div>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="      </div>\n";
        	stringToSendToWebBrowser +="    </div>\n";
        	stringToSendToWebBrowser +="  </div>\n";
//End of SI        			
        	stringToSendToWebBrowser += "			   <a name=\"legal\"></a>\n";
        	stringToSendToWebBrowser +="  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\n";
        	stringToSendToWebBrowser +="    <div class=\"container py-5\">\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"col-md-12\">\n" ;
        	stringToSendToWebBrowser +="          <div class=\"card text-white bg-dark mb-3\">\n";
        	stringToSendToWebBrowser +="            <div class=\"card-header text-left\">\n";
        	stringToSendToWebBrowser +="              <h2 class=\"card-title text-primary text-center\"><b style=\"\">Legal Info</b></h2>\n" ;
        	stringToSendToWebBrowser +="            </div>\n" ;
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-light\" style=\"\">\n" ;
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-dark border-secondary\"><b><u>What we do with your info</u></b></h5>\n" ;
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-dark text-left\"><b>We keep your details saved on our database. We pass on the details of reports you have made and some of your personal details to the council.</b></h6>\n";
        	stringToSendToWebBrowser +="            </div>\n" ;
        	stringToSendToWebBrowser +="            <div class=\"card-body bg-dark\" style=\"\">\n";
        	stringToSendToWebBrowser +="              <h5 class=\"card-title text-left text-white\"><b><u>I don't want my details shared</u></b></h5>\n";
        	stringToSendToWebBrowser +="              <h6 style=\"\" class=\"card-text text-left text-white\">Contact our team and we will remove it from our database immediately!</h6>\n" ;
        	stringToSendToWebBrowser +="            </div>\n" ;
        	stringToSendToWebBrowser +="          </div>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="      </div>\n" ;
        	stringToSendToWebBrowser +="    </div>\n";
        	stringToSendToWebBrowser +="  </div>\n";
//End of LI        			
        			
        	stringToSendToWebBrowser +="  <div class=\"py-5\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, .75), rgba(44, 62, 80, .75));	background-size: 100%;\">\n";
        	stringToSendToWebBrowser +="    <div class=\"container\">\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"my-3 col-lg-8\">\n";
        	stringToSendToWebBrowser +="          <h1 class=\"text-center text-lg-left text-white\" style=\"\">Help others by sharing</h1>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="        <div class=\"text-center align-self-center col-lg-4\"> <a href=\"https://www.facebook.com/QUBelfast\">\n";
        	stringToSendToWebBrowser +="            <i class=\"fa fa-fw fa-facebook text-white mx-3 fa-3x\"></i>\n";
        	stringToSendToWebBrowser +="          </a> <a href=\"https://twitter.com/QUBelfast\">\n";
        	stringToSendToWebBrowser +="            <i class=\"fa fa-fw fa-twitter fa-3x text-white mx-3\"></i>\n";
        	stringToSendToWebBrowser +="          </a> <a href=\"https://www.instagram.com/qubelfast/?hl=en\">\n"; 
        	stringToSendToWebBrowser +="            <i class=\"fa fa-fw fa-instagram fa-3x text-white mx-3\"></i>\n";
        	stringToSendToWebBrowser +="          </a> </div>\n";
        	stringToSendToWebBrowser +="      </div>\n";
        	stringToSendToWebBrowser +="    </div>\n";
        	stringToSendToWebBrowser +="  </div>\n";
        	
        	stringToSendToWebBrowser +="";
        	stringToSendToWebBrowser +="";
        	stringToSendToWebBrowser +="";
        	stringToSendToWebBrowser +="";
        	stringToSendToWebBrowser +="";
        	stringToSendToWebBrowser +="";
        	
        	stringToSendToWebBrowser +="  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" ;
        			stringToSendToWebBrowser +="  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n";
        					stringToSendToWebBrowser +="  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\n" ;
        							stringToSendToWebBrowser +="  <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\n"; 
        									stringToSendToWebBrowser +="</body>\n";
        											stringToSendToWebBrowser +="\n"; 
        													stringToSendToWebBrowser +="</html>";
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

        	return true;
        }else if(toProcess.path.equalsIgnoreCase("FAQ")) { 
			FAQ newFAQ = new FAQ();
			
			newFAQ.questionID = "FAQ_" +System.currentTimeMillis();
			newFAQ.title = toProcess.params.get("title");
			newFAQ.description = toProcess.params.get("description");
			newFAQ.category = toProcess.params.get("category");
			
			MVMap<String, FAQ> newQuestion = db.s.openMap("FAQ");
			//newQuestion.put(newQuestion.questionID, newQuestion);
			List<String> newQuestionKeys = newQuestion.keyList();
			
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
					"<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n" +
					"    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\n"+
					"        <span class=\"navbar-toggler-icon\"></span>\n" +
					"      </button>\n"+
					"      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"index.html\">\n" +
					"          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n"+
					"          <b>&nbsp;FILL MY HOLE</b>\n"+
					"        </a>\n"+
					"        <ul class=\"navbar-nav mx-auto\">\n"+
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"indexview\">Report a Problem</a> </li>\n"+
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\n"+
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"help.html\">FAQ</a> </li>\n"+
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"aboutusview\">About Us</a> </li>\n"+
					"        </ul>\n"+
					"        <ul class=\"navbar-nav\">\n"+
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.html\">Login</a> </li>\n"+
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n"+
					"          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signup.html\">Register</a> </li>\n"+
					"        </ul>\n"+
					"      </div>\n"+
					"    </div>\n"+
					"  </nav>\n"+
					"  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;\" >\r\n" + 
					"    <div class=\"container py-5\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-8 mx-auto bg-primary\"> <i class=\"d-block fa fa-stop-circle mb-3 text-muted fa-5x\"></i>\r\n" + 
					"          <h1 class=\"display-3 mb-4\">Thank You!</h1>\r\n" + 
					"          <p class=\"lead mb-5 text-white\" style=\"\">You have successfully submitted! Click the button to return to the Help Page!<br></p><a class=\"btn btn-dark\" href=\"help.html\">Help Page</a>\r\n" + 
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