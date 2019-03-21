package views;

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
        	stringToSendToWebBrowser +="<body>\n";
        	stringToSendToWebBrowser +="  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\" style=\"\">\n" ;
        	stringToSendToWebBrowser +="    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\n";
        	stringToSendToWebBrowser +="        <span class=\"navbar-toggler-icon\"></span>\n" ;
        	stringToSendToWebBrowser +="      </button>\n" ;
        	stringToSendToWebBrowser +="      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"#\">\n" ;
        	stringToSendToWebBrowser +="          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n" ;
        	stringToSendToWebBrowser +="          <b contenteditable=\"true\">&nbsp;FILL MY HOLE</b>\n" ;
        	stringToSendToWebBrowser +="        </a>\n" ;
        	stringToSendToWebBrowser +="        <ul class=\"navbar-nav mx-auto\">\n" ;
        	stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"index.html\">Report a Problem</a> </li>\n" ;
        	stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\n" ;
        	stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"help.html\">FAQ</a> </li>\n"; 
        	stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"AboutUsView\">About Us</a> </li>\n";
        	stringToSendToWebBrowser +="        </ul>\n";
        	stringToSendToWebBrowser +="        <ul class=\"navbar-nav\">\n";
        	stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.html\">Log in</a> </li>\n";
        	stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
        	stringToSendToWebBrowser +="          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signup.html\">Register</a> </li>\n";
        	stringToSendToWebBrowser +="        </ul>\n" ;
        	stringToSendToWebBrowser +="      </div>\n" ;
        	stringToSendToWebBrowser +="    </div>\n" ;
        	stringToSendToWebBrowser +="  </nav>\n" ;
        	stringToSendToWebBrowser +="  <div class=\"py-5 text-center align-items-center d-flex\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, 0.75), rgba(44, 62, 80, 0.75)); background-size: 100%;\">\n";
        	stringToSendToWebBrowser +="    <div class=\"container py-5\">\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"col-md-8 mx-auto bg-primary\" style=\"\"> <i class=\"fa d-inline fa-wrench fa-5x\"></i>\n";
        	stringToSendToWebBrowser +="          <h1 class=\"display-3 mb-4\" style=\"\">How can we help?</h1>\n";
        	stringToSendToWebBrowser +="          <form class=\"form-center\">\n";
        	stringToSendToWebBrowser +="            <div class=\"input-group\">\n"; 
        	stringToSendToWebBrowser +="              <input type=\"search\" class=\"form-control form-control-sm\" id=\"inlineFormInputGroup\" placeholder=\"Search\" name=\"Search\" >\n";
        	stringToSendToWebBrowser +="              <div class=\"input-group-append\"><button class=\"btn btn-primary\" type=\"button\"><i class=\"fa fa-search\"></i></button></div>\n";
        	stringToSendToWebBrowser +="            </div>\n";
        	stringToSendToWebBrowser +="          </form>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-0\">&nbsp;</p>\n";
        	stringToSendToWebBrowser +="          <h4 style=\"\">&nbsp;Other Issues?</h4><a class=\"btn btn-dark\" href=\"#\" contenteditable=\"true\">Contact Us</a>\n" ;
        	stringToSendToWebBrowser +="          <h4 style=\"\">&nbsp;</h4>\n"; 
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="      </div>\n";
        	stringToSendToWebBrowser +="    </div>\n";
        	stringToSendToWebBrowser +="  </div>\n";
        	stringToSendToWebBrowser +="  <div class=\"py-5 text-center bg-dark  \">\n";
        	stringToSendToWebBrowser +="    <div class=\"container\">\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"mx-auto col-md-12 offset-md-2\">\n";
        	stringToSendToWebBrowser +="          <h1 class=\"mb-3\">Categories</h1>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="      </div>\n";
        	stringToSendToWebBrowser +="      <div class=\"row\">\n";
        	stringToSendToWebBrowser +="        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-moon.svg\" width=\"200\" alt=\"Card image cap\">\n";
        	stringToSendToWebBrowser +="          <h4> <b>Getting Started</b></h4>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-3\">&nbsp;</p>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-0 text-white\">How to use our site<br></p>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-bubble-light.svg\" width=\"200\" alt=\"Card image cap\">\n";
        	stringToSendToWebBrowser +="          <h4>Account</h4>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-3\">&nbsp;</p>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-0 text-white\">Registering with us</p>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-bubble-dark.svg\" width=\"200\">\n";
        	stringToSendToWebBrowser +="          <h4>Site Issues</h4>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-3\">&nbsp;</p>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-0 text-white\"> Problems with the site</p>\n";
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-moon.svg\" width=\"200\">\n";
        	stringToSendToWebBrowser +="          <h4>Legal Information</h4>\n";
        	stringToSendToWebBrowser +="          <p class=\"mb-3\">&nbsp;</p>\n"; 
        	stringToSendToWebBrowser +="          <p class=\"mb-0 text-white\">Privacy</p>\n"; 
        	stringToSendToWebBrowser +="        </div>\n";
        	stringToSendToWebBrowser +="      </div>\n";
        	stringToSendToWebBrowser +="    </div>\n";
        	stringToSendToWebBrowser +="  </div>\n";
        	
//Getting started
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
        	stringToSendToWebBrowser +="  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" ;
        			stringToSendToWebBrowser +="  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n";
        					stringToSendToWebBrowser +="  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\n" ;
        							stringToSendToWebBrowser +="  <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\n"; 
        									stringToSendToWebBrowser +="</body>\n";
        											stringToSendToWebBrowser +="\n"; 
        													stringToSendToWebBrowser +="</html>";
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

        	return true;
        }
        return false;
	}

}
