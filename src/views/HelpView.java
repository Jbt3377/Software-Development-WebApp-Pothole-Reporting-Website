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
        if(toProcess.path.equalsIgnoreCase("HelpView"))
        {
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
        			"<html>\n" + 
        			"\n" + 
        			"<head>\n" + 
        			"  <meta charset=\"utf-8\">\n" + 
        			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
        			"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n" + 
        			"  <link rel=\"stylesheet\" href=\"a.css\">\n" + 
        			"  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\n" + 
        			"</head>\n" + 
        			"\n" + 
        			"<body>\n" + 
        			"  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\" style=\"\">\n" + 
        			"    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\n" + 
        			"        <span class=\"navbar-toggler-icon\"></span>\n" + 
        			"      </button>\n" + 
        			"      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"#\">\n" + 
        			"          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n" + 
        			"          <b contenteditable=\"true\">&nbsp;FILL MY HOLE</b>\n" + 
        			"        </a>\n" + 
        			"        <ul class=\"navbar-nav mx-auto\">\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Report a Problem</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"formPage.html\">FAQ</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"AboutUs.html\">About Us</a> </li>\n" + 
        			"        </ul>\n" + 
        			"        <ul class=\"navbar-nav\">\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.html\">Log in</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signup.html\">Register</a> </li>\n" + 
        			"        </ul>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </nav>\n" + 
        			"  <div class=\"py-5 text-center align-items-center d-flex\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, 0.75), rgba(44, 62, 80, 0.75)); background-size: 100%;\">\n" + 
        			"    <div class=\"container py-5\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"col-md-8 mx-auto bg-primary\" style=\"\"> <i class=\"fa d-inline fa-wrench fa-5x\"></i>\n" + 
        			"          <h1 class=\"display-3 mb-4\" style=\"\">How can we help?</h1>\n" + 
        			"          <form class=\"form-center\">\n" + 
        			"            <div class=\"input-group\">\n" + 
        			"              <input type=\"text\" class=\"form-control\" id=\"inlineFormInputGroup\" placeholder=\"Search\">\n" + 
        			"              <div class=\"input-group-append\"><button class=\"btn btn-primary\" type=\"button\"><i class=\"fa fa-search\"></i></button></div>\n" + 
        			"            </div>\n" + 
        			"          </form>\n" + 
        			"          <p class=\"mb-0\">&nbsp;</p>\n" + 
        			"          <h4 style=\"\">&nbsp;Other Issues?</h4><a class=\"btn btn-dark\" href=\"#\" contenteditable=\"true\">Contact Us</a>\n" + 
        			"          <h4 style=\"\">&nbsp;</h4>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <div class=\"py-5 text-center bg-dark\">\n" + 
        			"    <div class=\"container\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"mx-auto col-md-12\">\n" + 
        			"          <h1 class=\"mb-3\">Categories</h1>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-moon.svg\" width=\"200\" alt=\"Card image cap\">\n" + 
        			"          <h4> <b>Getting Started</b></h4>\n" + 
        			"          <p class=\"mb-3\">&nbsp;</p>\n" + 
        			"          <p class=\"mb-0\">How to use our site<br></p>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-bubble-light.svg\" width=\"200\" alt=\"Card image cap\">\n" + 
        			"          <h4>Account</h4>\n" + 
        			"          <p class=\"mb-3\">&nbsp;</p>\n" + 
        			"          <p class=\"mb-0\">Registering with us</p>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-bubble-dark.svg\" width=\"200\">\n" + 
        			"          <h4>Site Issues</h4>\n" + 
        			"          <p class=\"mb-3\">&nbsp;</p>\n" + 
        			"          <p class=\"mb-0\"> Problems with the site</p>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto\" src=\"https://static.pingendo.com/cover-moon.svg\" width=\"200\">\n" + 
        			"          <h4>Legal Information</h4>\n" + 
        			"          <p class=\"mb-3\">&nbsp;</p>\n" + 
        			"          <p class=\"mb-0\">Privacy</p>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\n" + 
        			"    <div class=\"container py-5\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"col-md-12\">\n" + 
        			"          <div class=\"card text-white bg-dark mb-3\">\n" + 
        			"            <div class=\"card-header text-left\">\n" + 
        			"              <h2 class=\"card-title text-primary text-center\"><b style=\"\">Getting Started&nbsp;</b></h2>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-info\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-dark border-secondary\"><u><b>How Do I Make A Report?</b></u></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-dark text-left\"><b><b>1. </b>Start at the homepage and type in your postcode or a place name. You can chose locate me automatically.&nbsp;<br><b>2. </b>Put the pin in the map to show exactly where the problem is, and type in a description of the issue. Then send.&nbsp;<br><b>3.</b> Check your email inbox for our confirmation mail, click on the link, and job done. </b></h5>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-dark\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-white\"><u>What Can I Report?</u></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-left text-white\" contenteditable=\"true\">FillMyHole is primarily for reporting things which are broken or dirty or damaged or dumped, and need fixing, cleaning or clearing, like graffiti, dog fouling, potholes or street lights that don't work.&nbsp;</h5>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-info\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-dark\"><u><b>Are My Reports Public?</b></u></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-dark text-left\"><b>Yes they are: when you submit your report, we send it to the council, and we also publish it on the website. Your council will respond directly to you, and from that point on, your correspondence is one-to-one. For that reason, we suggest that you don't include personal details such as addresses and phone numbers until you are in direct communication.&nbsp;</b></h5>\n" + 
        			"            </div>\n" + 
        			"          </div>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\n" + 
        			"    <div class=\"container py-5\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"col-md-12\">\n" + 
        			"          <div class=\"card text-white bg-dark mb-3\">\n" + 
        			"            <div class=\"card-header text-left\">\n" + 
        			"              <h2 class=\"card-title text-primary text-center\"><b style=\"\">Account</b></h2>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-info\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-dark border-secondary\"><b><u>Do I need to register with FillMyHole to use it?</u></b></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-dark text-left\"><b>No – you can send a report without registering. When you submit your report, we'll send you an email with a confirmation link. If you use FillMyHole a lot, you can avoid this step by creating an account. Once you've signed in, your reports will be sent as soon as you click 'submit'. You'll also be able to see all previous reports you've made on one page.&nbsp;</b></h5>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-dark\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-white\"><b><u>How do I register?</u></b></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-left text-white\">Visit our login page and register with your details.&nbsp;</h5>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-info\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-dark\"><b><u>How do you recover a password?</u></b></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-dark text-left\"><b>Visit our login page and choose ‘No, let me sign in by email' – then put a new password in the box. You'll receive an email to confirm the change. </b></h5>\n" + 
        			"            </div>\n" + 
        			"          </div>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\n" + 
        			"    <div class=\"container py-5\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"col-md-12\">\n" + 
        			"          <div class=\"card text-white bg-dark mb-3\">\n" + 
        			"            <div class=\"card-header text-left\">\n" + 
        			"              <h2 class=\"card-title text-primary text-center\"><b style=\"\">Site Issues</b></h2>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-info\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-dark border-secondary\"><b><u>Do I need to register with FillMyHole to use it?</u></b></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-dark text-left\"><b>No – you can send a report without registering. When you submit your report, we'll send you an email with a confirmation link. If you use FillMyHole a lot, you can avoid this step by creating an account. Once you've signed in, your reports will be sent as soon as you click 'submit'. You'll also be able to see all previous reports you've made on one page.&nbsp;</b></h5>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-dark\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-white\"><b><u>How do I register?</u></b></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-left text-white\">Visit our login page and register with your details.&nbsp;</h5>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-info\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-dark\"><b><u>How do you recover a password?</u></b></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-dark text-left\"><b>Visit our login page and choose ‘No, let me sign in by email' – then put a new password in the box. You'll receive an email to confirm the change. </b></h5>\n" + 
        			"            </div>\n" + 
        			"          </div>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\n" + 
        			"    <div class=\"container py-5\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"col-md-12\">\n" + 
        			"          <div class=\"card text-white bg-dark mb-3\">\n" + 
        			"            <div class=\"card-header text-left\">\n" + 
        			"              <h2 class=\"card-title text-primary text-center\"><b style=\"\">Legal Info</b></h2>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-info\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-dark border-secondary\"><b><u>Do I need to register with FillMyHole to use it?</u></b></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-dark text-left\"><b>No – you can send a report without registering. When you submit your report, we'll send you an email with a confirmation link. If you use FillMyHole a lot, you can avoid this step by creating an account. Once you've signed in, your reports will be sent as soon as you click 'submit'. You'll also be able to see all previous reports you've made on one page.&nbsp;</b></h5>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-dark\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-white\"><b><u>How do I register?</u></b></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-left text-white\">Visit our login page and register with your details.&nbsp;</h5>\n" + 
        			"            </div>\n" + 
        			"            <div class=\"card-body bg-info\" style=\"\">\n" + 
        			"              <h2 class=\"card-title text-left text-dark\"><b><u>How do you recover a password?</u></b></h2>\n" + 
        			"              <h5 style=\"\" class=\"card-text text-dark text-left\"><b>Visit our login page and choose ‘No, let me sign in by email' – then put a new password in the box. You'll receive an email to confirm the change. </b></h5>\n" + 
        			"            </div>\n" + 
        			"          </div>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <div class=\"py-5\" style=\"background-image: linear-gradient(to left bottom, rgba(189, 195, 199, .75), rgba(44, 62, 80, .75));	background-size: 100%;\">\n" + 
        			"    <div class=\"container\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"my-3 col-lg-8\">\n" + 
        			"          <h1 class=\"text-center text-lg-left text-white\" style=\"\">Help others by sharing</h1>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"text-center align-self-center col-lg-4\"> <a href=\"#\">\n" + 
        			"            <i class=\"fa fa-fw fa-facebook text-white mx-3 fa-3x\"></i>\n" + 
        			"          </a> <a href=\"#\">\n" + 
        			"            <i class=\"fa fa-fw fa-twitter fa-3x text-white mx-3\"></i>\n" + 
        			"          </a> <a href=\"#\">\n" + 
        			"            <i class=\"fa fa-fw fa-instagram fa-3x text-white mx-3\"></i>\n" + 
        			"          </a> </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" + 
        			"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n" + 
        			"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\n" + 
        			"  <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\n" + 
        			"</body>\n" + 
        			"\n" + 
        			"</html>";
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

        	return true;
        }
        return false;
	}

}
