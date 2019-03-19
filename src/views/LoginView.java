package views;

import model.Profile;

import org.h2.mvstore.MVMap;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class LoginView extends DynamicWebPage
{

	public LoginView(DatabaseInterface db, FileStoreInterface fs) 
	{
		super(db,fs);
	}
	
	public boolean process(WebRequest toProcess) 
	{
		if(toProcess.path.equalsIgnoreCase("loginview.html"))
		{
			String username = toProcess.params.get("username");
			String password = toProcess.params.get("password");
		
			MVMap<String, Profile> profiles = db.s.openMap("Profiles");
			
			if(!profiles.containsKey(username))
			{
		String stringToSendToWebBrowser = "";
		stringToSendToWebBrowser += "<!DOCTYPE html>\n";
		stringToSendToWebBrowser += "<html>\n";
		stringToSendToWebBrowser += "\n";
		stringToSendToWebBrowser += "<head>\n";
		stringToSendToWebBrowser += "<title>FMH Login</title>\n";
		stringToSendToWebBrowser += "  <meta charset=\"utf-8\">\n";
		stringToSendToWebBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
		stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
		stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\">\n";
		stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
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
		stringToSendToWebBrowser += "          <h1 class=\"display-3 mb-4\">Unknown Username?<br></h1>\n";
		stringToSendToWebBrowser += "          <p class=\"lead mb-3\">Click the button try again.</p> <a class=\"btn btn-lg mx-1 btn-outline-primary\" href=\"login.html\">Log In</a>\n";
		stringToSendToWebBrowser += "        </div>\n";
		stringToSendToWebBrowser += "      </div>\n";
		stringToSendToWebBrowser += "    </div>\n";
		stringToSendToWebBrowser += "  </div>\n";
		stringToSendToWebBrowser += "  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n";
		stringToSendToWebBrowser += "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\" style=\"\"></script>\n";
		stringToSendToWebBrowser += "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n"; 
		stringToSendToWebBrowser += "</body>\n";
		stringToSendToWebBrowser += "\n";
		stringToSendToWebBrowser += "</html>\n";
		toProcess.r = new WebResponse( WebResponse.HTTP_OK,WebResponse.MIME_HTML, stringToSendToWebBrowser );
		return true;
			}
			
			Profile user = profiles.get(username);
			
			//if(user.password==password)
			if(!user.password.contentEquals(password))
			{
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "\n";
				stringToSendToWebBrowser += "<head>\n";
				stringToSendToWebBrowser += "<title>SignUpSubmit</title>\n";
				stringToSendToWebBrowser += "  <meta charset=\"utf-8\">\n";
				stringToSendToWebBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
				stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
				stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\">\n";
				stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
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
				stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"loginview.html\">Login</a> </li>\n";
				stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
				stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signupview\">Register</a> </li>\n";
				stringToSendToWebBrowser += "        </ul>\n";
				stringToSendToWebBrowser += "      </div>\n";
				stringToSendToWebBrowser += "    </div>\n";
				stringToSendToWebBrowser += "  </nav>\n";
				stringToSendToWebBrowser += "  <div class=\"bg text-center align-items-stretch d-flex flex-column h-100% w-100% pt-3 pb-5 mt-0 mb-auto\" style=\"background-image: linear-gradient(to bottom, rgba(13, 21, 25, .85), rgba(9, 14, 16, .90)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: auto, auto;  background-repeat: repeat, repeat;\">\n";
				stringToSendToWebBrowser += "    <div class=\"container py-5\">\n";
				stringToSendToWebBrowser += "      <div class=\"row\">\n";
				stringToSendToWebBrowser += "        <div class=\"mx-auto col-lg-8 col-md-10\">\n";
				stringToSendToWebBrowser += "          <h1 class=\"display-3 mb-4\">Password was Incorrect<br></h1>\n";
				stringToSendToWebBrowser += "          <p class=\"lead mb-3\">Click the button try again.</p> <a class=\"btn btn-lg mx-1 btn-outline-primary\" href=\"loginview.html\">Log In</a>\n";
				stringToSendToWebBrowser += "        </div>\n";
				stringToSendToWebBrowser += "      </div>\n";
				stringToSendToWebBrowser += "    </div>\n";
				stringToSendToWebBrowser += "  </div>\n";
				stringToSendToWebBrowser += "  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n";
				stringToSendToWebBrowser += "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\" style=\"\"></script>\n";
				stringToSendToWebBrowser += "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n"; 
				stringToSendToWebBrowser += "</body>\n";
				stringToSendToWebBrowser += "\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;
			}
			
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "  <head>\n";
			stringToSendToWebBrowser += "    <title>LoginSubmit</title>\n";
			stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
			stringToSendToWebBrowser += "    <meta  name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
			stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\">\n";
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
			stringToSendToWebBrowser += "      function setCookie(cname, cvalue, exdays)\n";
			stringToSendToWebBrowser += "      {\n";
			stringToSendToWebBrowser += "          var d = new Date();\n";
			stringToSendToWebBrowser += "          d.setTime(d.getTime() + (exdays*24*60*60*1000));\n";
			stringToSendToWebBrowser += "          var expires = 'expires='+d.toUTCString();\n";
			stringToSendToWebBrowser += "          document.cookie = cname + '=' + cvalue + ';' + expires + ';path=/';\n";
			stringToSendToWebBrowser += "      }\n";
			stringToSendToWebBrowser += "      function saveLoginCookie()\n";
			stringToSendToWebBrowser += "      {\n";
			stringToSendToWebBrowser += "          setCookie('username','"+username+"',365);\n";
			stringToSendToWebBrowser += "          setCookie('password','"+password+"',365);\n";
			stringToSendToWebBrowser += "      }\n";
			
			stringToSendToWebBrowser += "  </script>\n";

			stringToSendToWebBrowser += "  </head>\n";
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
			stringToSendToWebBrowser += "          <h1 class=\"display-3 mb-4\">You have successfully Logged In</h1>\n";
			stringToSendToWebBrowser += "          <p class=\"lead mb-3\">Click the button to go to the main page.</p> <a class=\"btn btn-lg mx-1 btn-outline-primary\" href=\"indexview\">Main Page</a>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "  </div>\n";
			stringToSendToWebBrowser += "  <div class=\"py-5 text-center text-white h-100 align-items-center d-flex\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;\" >\n";
			stringToSendToWebBrowser += "  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n";
			stringToSendToWebBrowser += "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n";
			stringToSendToWebBrowser += "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n";
			stringToSendToWebBrowser += "</body>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</html>\n";
			stringToSendToWebBrowser += "";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		return false;
	}

}