package views;

import org.h2.mvstore.MVMap;

import model.Profile;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class LoginView extends DynamicWebPage{

	public LoginView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
		// TODO Auto-generated constructor stub
	}
	public boolean process(WebRequest toProcess)
	{
	if(toProcess.path.equalsIgnoreCase("loginview.html"))
	{
		String username = toProcess.params.get("username");
		String password = toProcess.params.get("password");
		
		MVMap<String, Profile> profiles = db.s.openMap("Profiles");
		
		if (!profiles.containsKey(username))
		{
		String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += "    <title>LoginSubmit</title>\n";
				stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
				stringToSendToWebBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n";
				stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
				stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\">\r\n";
				stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"/css/blocks.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
				stringToSendToWebBrowser += "      <script src=\"/js/html5shiv.js\"></script>\n";
				stringToSendToWebBrowser += "      <script src=\"/js/respond.min.js\"></script>\n";
				stringToSendToWebBrowser += "    <![endif]-->\n";
				stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\n";
				stringToSendToWebBrowser += "  </head>\n";
				stringToSendToWebBrowser += "  <body>\n";
				stringToSendToWebBrowser += "    <h1>Unknown Username<h1>\n";
				stringToSendToWebBrowser += "    <h1><a href='/Login.html'>Click here to try again</a><h1>\n";
				stringToSendToWebBrowser += "  </body>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;

			}
			
			Profile user = profiles.get(username);
			
			
			if(!user.password.contentEquals(password))
			{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "  <head>\n";
			stringToSendToWebBrowser += "    <title>LoginSubmit</title>\n";
			stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
			stringToSendToWebBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n";
			stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
			stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\">\r\n";
			stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700\" rel=\"stylesheet\">\n";
			stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic\" rel=\"stylesheet\">\n";
			stringToSendToWebBrowser += "    <link href=\"/css/blocks.css\" rel=\"stylesheet\">\n";
			stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
			stringToSendToWebBrowser += "      <script src=\"/js/html5shiv.js\"></script>\n";
			stringToSendToWebBrowser += "      <script src=\"/js/respond.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <![endif]-->\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\n";
			stringToSendToWebBrowser += "  </head>\n";
			stringToSendToWebBrowser += "  <body>\n";
			stringToSendToWebBrowser += "    <h1>Password Incorrect<h1>\n";
			stringToSendToWebBrowser += "    <h1><a href='/Login.html'>Click here to try again</a><h1>\n";
			stringToSendToWebBrowser += "  </body>\n";
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
		stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
		stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\">\r\n";
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
		
		
		
		
		stringToSendToWebBrowser += "  <body onload='saveLoginCookie()'>\n";
		stringToSendToWebBrowser += "  <body>\n";
		stringToSendToWebBrowser += "    <h1>Login Complete<h1>\n";
		stringToSendToWebBrowser += "    <h1><a href='Index.html'>Click here to go to the Front Page</a><h1>\n";
		stringToSendToWebBrowser += "  </body>\n";
		stringToSendToWebBrowser += "</html>\n";
		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
		return true;
		}
	
			
			
			
			
			
			
			
			/*String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"\r\n" + 
			"<head>\r\n" + 
			"  <meta charset=\"utf-8\">\r\n" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n" + 
			"  <link rel=\"stylesheet\" href=\"now-ui-kit.css\">\r\n" + 
			"</head>\r\n" + 
			"\r\n" + 
			"<body>\r\n" + 
			"  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n" + 
			"    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\r\n" + 
			"        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
			"      </button>\r\n" + 
			"      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"#\">\r\n" + 
			"          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\r\n" + 
			"          <b>&nbsp;FILL MY HOLE</b>\r\n" + 
			"        </a>\r\n" + 
			"        <ul class=\"navbar-nav mx-auto\">\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#report\">Report a Problem</a> </li>\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"formPage.html\">FAQ</a> </li>\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"aboutusview\">About Us</a> </li>\r\n" + 
			"        </ul>\r\n" + 
			"        <ul class=\"navbar-nav\">\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"loginview.html\">Login</a> </li>\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signupview\">Register</a> </li>\r\n" + 
			"        </ul>\r\n" + 
			"      </div>\r\n" + 
			"    </div>\r\n" + 
			"  </nav>\r\n" + 
			"  <small class=\"form-text text-muted text-right\">\r\n" + 
			"    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
			"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\r\n" + 
			"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\r\n" + 
			"    <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\r\n" + 
			"  </small>\r\n" + 
			"  <div class=\"text-center align-items-stretch d-flex flex-column h-100 w-100 pt-3 pb-5 mt-0 mb-5\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: auto, auto;  background-repeat: repeat, repeat;\" >\r\n" + 
			"    <div class=\"container py-0 px-5 w-50\">\r\n" + 
			"      <div class=\"card bg-primary\">\r\n" + 
			"        <div class=\"card-body text-center w-100 px-0\">\r\n" + 
			"          <h5 class=\"mb-0 display-1\">Log In</h5>\r\n" + 
			"          <div class=\"card-body text-center\">\r\n" + 
			"            <div class=\"row mt-1\">\r\n" + 
			"              <div class=\"col-md-12\">\r\n" + 
			"                <h5 class=\"mb-2\">\r\n" + 
			"                  <b>Share the Love</b></h5>\r\n" + 
			"                <button class=\"btn btn-icon rounded btn-light mx-1 btn-facebook shadow\" type=\"button\">\r\n" + 
			"                  <i class=\"fa fa-fw fa-lg fa-facebook-square\"></i>\r\n" + 
			"                </button>\r\n" + 
			"                <button class=\"btn btn-icon rounded btn-lg btn-light mx-1 btn-google shadow\" type=\"button\">\r\n" + 
			"                  <i class=\"fa fa-fw fa-2x fa-google-plus\"></i>\r\n" + 
			"                </button>\r\n" + 
			"                <button class=\"btn btn-icon rounded btn-light mx-1 btn-twitter shadow\" type=\"button\">\r\n" + 
			"                  <i class=\"fa fa-fw fa-twitter fa-lg\"></i>\r\n" + 
			"                </button>\r\n" + 
			"              </div>\r\n" + 
			"            </div>\r\n" + 
			"            <div class=\"row mt-3 pt-1\">\r\n" + 
			"              <div class=\"col\">\r\n" + 
			"                <form class=\"w-50 mx-auto px-1\">\r\n" + 
			"                  <div class=\"form-group mb-2\">\r\n" + 
			"                    <div class=\"input-group border-0\">\r\n" + 
			"                      <div class=\"input-group-prepend\">\r\n" + 
			"                        <span class=\"input-group-text\" id=\"basic-addon1\">\r\n" + 
			"                          <i class=\"now-ui-icons users_circle-08 lg\"></i>\r\n" + 
			"                        </span>\r\n" + 
			"                      </div>\r\n" + 
			"                      <input type=\"text\" class=\"form-control\" id=\"inlineFormInputGroup\" placeholder=\"Username ...\">\r\n" + 
			"                    </div>\r\n" + 
			"                  </div>\r\n" + 
			"                  <div class=\"form-group mb-2\">\r\n" + 
			"                    <div class=\"input-group border-0\">\r\n" + 
			"                      <div class=\"input-group-prepend \">\r\n" + 
			"                        <span class=\"input-group-text\" id=\"basic-addon1\">\r\n" + 
			"                          <i class=\"now-ui-icons text_caps-small lg\"></i>\r\n" + 
			"                        </span>\r\n" + 
			"                      </div>\r\n" + 
			"                      <input type=\"text\" class=\"form-control\" id=\"inlineFormInputGroup\" placeholder=\"Password...\">\r\n" + 
			"                    </div>\r\n" + 
			"                  </div>\r\n" + 
			"                </form>\r\n" + 
			"              </div>\r\n" + 
			"            </div>\r\n" + 
			"          </div>\r\n" + 
			"          <a class=\"btn btn-lg btn-light btn-lg text-primary mx-1 rounded\" href=\"login.html\">Log In</a>\r\n" + 
			"        </div>\r\n" + 
			"      </div>\r\n" + 
			"    </div>\r\n" + 
			"  </div>\r\n" + 
			"</body>\r\n" + 
			"\r\n" + 
			"</html>";
			
	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
	
	return true;
	} */
	{}

	return false;
	}
}
