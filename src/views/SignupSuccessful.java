package views;

import org.h2.mvstore.MVMap;

import model.Profile;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class SignupSuccessful extends DynamicWebPage{

	public SignupSuccessful(DatabaseInterface db, FileStoreInterface fs){
		super(db, fs);
	}
	public boolean process(WebRequest toProcess)
	{
		// 
		if(toProcess.path.equalsIgnoreCase("signupsuccessful"))
		{
			Profile user = new Profile();
			user.name = toProcess.params.get("name");
			user.username = toProcess.params.get("username");
			user.password = toProcess.params.get("password");
		
			MVMap<String, Profile> profiles = db.s.openMap("Profiles");
		
			// Check for existing username
			if (profiles.containsKey(user.username))
			{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "<title>FMH Sign Up</title>\n";
			stringToSendToWebBrowser += "  <meta charset=\"utf-8\">\n";
			stringToSendToWebBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\">\n";
			stringToSendToWebBrowser += "    <!--[if lt IE 9]-->\n";
			stringToSendToWebBrowser += "      <script src=\"/js/html5shiv.js\"></script>\n";
			stringToSendToWebBrowser += "      <script src=\"/js/respond.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <![endif]-->\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\n";
			stringToSendToWebBrowser += "</head>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<body >\n";
			stringToSendToWebBrowser += "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n";
			stringToSendToWebBrowser += "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\n";
			stringToSendToWebBrowser += "        <span class=\"navbar-toggler-icon\"></span>\n";
			stringToSendToWebBrowser += "      </button>\n";
			stringToSendToWebBrowser += "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"indexview\">\n";
			stringToSendToWebBrowser += "          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n";
			stringToSendToWebBrowser += "          <b>&nbsp;FILL MY HOLE</b>\n";
			stringToSendToWebBrowser += "        </a>\n";
			stringToSendToWebBrowser += "        <ul class=\"navbar-nav mx-auto\">\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#report\">Report a Problem</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"formPage.html\">FAQ</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"aboutusview\">About Us</a> </li>\n";
			stringToSendToWebBrowser += "        </ul>\n";
			stringToSendToWebBrowser += "        <ul class=\"navbar-nav\">\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.html\">Login</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signup.html\">Register</a> </li>\n";
			stringToSendToWebBrowser += "        </ul>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "  </nav>\n";
			stringToSendToWebBrowser += "  <div class=\"bg text-center align-items-stretch d-flex flex-column h-100% w-100% pt-3 pb-5 mt-0 mb-auto\" style=\"background-image: linear-gradient(to bottom, rgba(13, 21, 25, .85), rgba(9, 14, 16, .90)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: auto, auto;  background-repeat: repeat, repeat;\">\n";
			stringToSendToWebBrowser += "    <div class=\"container py-5\">\n";
			stringToSendToWebBrowser += "      <div class=\"row\">\n";
			stringToSendToWebBrowser += "        <div class=\"mx-auto col-lg-8 col-md-10\">\n";
			stringToSendToWebBrowser += "          <h1 class=\"display-3 mb-4\">That Username is taken.<br></h1>\n";
			stringToSendToWebBrowser += "          <p class=\"lead mb-3\">Click the button to choose another.</p> <a class=\"btn btn-lg mx-1 btn-outline-primary\" href=\"signup.html\">Create an Account</a>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "  </div>\n";
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
			stringToSendToWebBrowser += "  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n";
			stringToSendToWebBrowser += "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\" style=\"\"></script>\n";
			stringToSendToWebBrowser += "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n"; 
			stringToSendToWebBrowser += "</body>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK,WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		profiles.put(user.username, user);
		db.commit();
		
		String stringToSendToWebBrowser = "";
		stringToSendToWebBrowser += "<!DOCTYPE html>\n";
		stringToSendToWebBrowser += "<html>\n";
		stringToSendToWebBrowser += "\n";
		stringToSendToWebBrowser += "<head>\n";
		stringToSendToWebBrowser += "  <meta charset=\"utf-8\">\n";
		stringToSendToWebBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
		stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
		stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css\">\n";
		stringToSendToWebBrowser += "</head>\n";
		stringToSendToWebBrowser += "\n";
		stringToSendToWebBrowser += "<body>\n";
		stringToSendToWebBrowser += "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n";
		stringToSendToWebBrowser += "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\n";
		stringToSendToWebBrowser += "        <span class=\"navbar-toggler-icon\"></span>\n";
		stringToSendToWebBrowser += "      </button>\n";
		stringToSendToWebBrowser += "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"#\">\n";
		stringToSendToWebBrowser += "          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n";
		stringToSendToWebBrowser += "          <b>&nbsp;FILL MY HOLE</b>\n";
		stringToSendToWebBrowser += "        </a>\n";
		stringToSendToWebBrowser += "        <ul class=\"navbar-nav mx-auto\">\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#report\">Report a Problem</a> </li>\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"formPage.html\">FAQ</a> </li>\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"aboutusview\">About Us</a> </li>\n";
		stringToSendToWebBrowser += "        </ul>\n";
		stringToSendToWebBrowser += "        <ul class=\"navbar-nav\">\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"loginview.html\">Login</a> </li>\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
		stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signupview\">Register</a> </li>\n";
		stringToSendToWebBrowser += "        </ul>\n";
		stringToSendToWebBrowser += "      </div>\n";
		stringToSendToWebBrowser += "    </div>\n";
		stringToSendToWebBrowser += "  </nav>\n";
		stringToSendToWebBrowser += "  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;\" >\n";
		stringToSendToWebBrowser += "    <div class=\"container py-5\">\n";
		stringToSendToWebBrowser += "      <div class=\"row\">\n";
		stringToSendToWebBrowser += "        <div class=\"mx-auto col-lg-8 col-md-10\">\n";
		stringToSendToWebBrowser += "          <h1 class=\"display-3 mb-4\">Thanks for Signing Up</h1>\n";
		stringToSendToWebBrowser += "          <p class=\"lead mb-3\">Just click the Log In button to log into your new account.</p> <a class=\"btn btn-lg mx-1 btn-outline-primary\" href=\"login.html\">Log In</a>\n";
		stringToSendToWebBrowser += "        </div>\n";
		stringToSendToWebBrowser += "      </div>\n";
		stringToSendToWebBrowser += "    </div>\n";
		stringToSendToWebBrowser += "  </div>\n";
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
		stringToSendToWebBrowser += "  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;\" >\n";
		stringToSendToWebBrowser += "  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n";
		stringToSendToWebBrowser += "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n";
		stringToSendToWebBrowser += "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n";
		stringToSendToWebBrowser += "</body>\n";
		stringToSendToWebBrowser += "\n";
		stringToSendToWebBrowser += "</html>\n";
		stringToSendToWebBrowser += "";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK,WebResponse.MIME_HTML, stringToSendToWebBrowser);
		return true;
		}
		return false;
	}

}
