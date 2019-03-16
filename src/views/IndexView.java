package views;

import org.h2.mvstore.MVMap;
import model.Profile;
import model.Report;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import utils.Validator;
import web.WebRequest;
import web.WebResponse;

public class IndexView extends DynamicWebPage{

	public IndexView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
	}
	
	public boolean process(WebRequest toProcess) {
		
		if(toProcess.path.equalsIgnoreCase("indexview")) {
			
			String username = toProcess.cookies.get("username"); 
			String password = toProcess.cookies.get("password");
			
			if(username!=null)
			{
				MVMap<String, Profile> profiles = db.s.openMap("Profiles");
				Validator.validate(db);
				Profile user = profiles.get(username);
				if((user==null)||(!user.password.contentEquals(password))) 
				{
					String stringToSendToWebBrowser = "";
					stringToSendToWebBrowser += "<!DOCTYPE html>\n";
					stringToSendToWebBrowser += "<html>\n";
					stringToSendToWebBrowser += "  <head>\n";
					stringToSendToWebBrowser += "    <title>Session Error</title>\n";
					stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
					stringToSendToWebBrowser += "    <meta  name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
					stringToSendToWebBrowser += "    <link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n";
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
					stringToSendToWebBrowser += "      function clearLoginCookie()\n";
					stringToSendToWebBrowser += "      {\n";
					stringToSendToWebBrowser += "          document.cookie='username=;expires=' + new Date(0).toGMTString();\n";
					stringToSendToWebBrowser += "          document.cookie='password=;expires=' + new Date(0).toGMTString();\n";
					stringToSendToWebBrowser += "      }\n";
					stringToSendToWebBrowser += "  </script>\n";
					stringToSendToWebBrowser += "  </head>\n";
					

					
					stringToSendToWebBrowser += "  <body onload=\"clearLoginCookie()\">\n";
					stringToSendToWebBrowser += "    <h1>Session Error<h1>\n";
					stringToSendToWebBrowser += "    <h1><a href='/Index.html'>Click here to continue</a><h1>\n";
					stringToSendToWebBrowser += "  </body>\n";
					stringToSendToWebBrowser += "</html>\n";
					toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
					return true;

				}
			}
			
			String stringToSendToWebBrowser = "";		
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "  <meta charset=\"utf-8\">\n";
			stringToSendToWebBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "</head>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<body class=\"text-left\">\n";
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
			if(username!=null)
			{
			stringToSendToWebBrowser += "  		   <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Welcome + username +</a> </li>\n";
			}
			else
			{
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.html\">Login</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
			stringToSendToWebBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signup.html\">Register</a> </li>\n";
			}
			stringToSendToWebBrowser += "        </ul>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "  </nav>\n";
			stringToSendToWebBrowser += "  <div class=\"text-center text-white\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\n";
			stringToSendToWebBrowser += "    <div class=\"container\">\n";
			stringToSendToWebBrowser += "      <div class=\"row\">\n";
			stringToSendToWebBrowser += "        <div class=\"col-md-8 mx-auto\">\n";
			stringToSendToWebBrowser += "          <h1 class=\"mb-3 mt-3 p-2\">What's Bothering You?</h1>\n";
			stringToSendToWebBrowser += "          <p class=\"lead mb-0 p-2\">Fill My Hole is a website dedicated to informing local councils of problems they have the responsibility to fix.<br></p>\n";
			stringToSendToWebBrowser += "          <p class=\"lead text-center text-capitalize p-0 m-2\">Got a Problem?&nbsp; Report it!<br></p><a class=\"btn btn-primary m-2 my-3 mb-4\" href=\"#report\"><b class=\"text-center\">Report an Issue</b></a>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "      <div class=\"row\">\n";
			stringToSendToWebBrowser += "        <div class=\"col-md-12\"><iframe width=\"100%\" height=\"400\" src=\"https://maps.google.com/maps?q=Belfast&amp;z=14&amp;output=embed\" scrolling=\"no\" frameborder=\"0\"></iframe></div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "    <div class=\"container py-4\">\n";
			stringToSendToWebBrowser += "      <div class=\"row\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-6\" style=\"\">\n";
			stringToSendToWebBrowser += "            <div class=\"card text-white bg-dark my-3\">\n";
			stringToSendToWebBrowser += "              <div class=\"card-header text-center\"><b class=\"w-100 h-100\">How to Report a Problem</b></div>\n";
			stringToSendToWebBrowser += "              <div class=\"card-body\">\n";
			stringToSendToWebBrowser += "                <ol class=\"\">\n";
			stringToSendToWebBrowser += "                  <li class=\"text-left py-2\"><b>Locate - </b>Use the map above to find the area of the problem</li>\n";
			stringToSendToWebBrowser += "                  <li class=\"text-left py-2\"><b>Mark - </b>Click on the precise location of the problem</li>\n";
			stringToSendToWebBrowser += "                  <li class=\"text-left py-2\"><b>Tell us! - </b>Provide us with information on the problem and we'll pass it onto the local council. You can include images as well!&nbsp;</li>\n";
			stringToSendToWebBrowser += "                </ol>\n";
			stringToSendToWebBrowser += "              </div>\n";
			stringToSendToWebBrowser += "            </div>\n";
			stringToSendToWebBrowser += "            <div class=\"card text-white bg-dark my-3\">\n";
			stringToSendToWebBrowser += "              <div class=\"card-header text-center\">\n";
			stringToSendToWebBrowser += "                <h3 class=\"text-center text-capitalize\"><span class=\"badge badge-light badge-pill\" style=\"\">Recently Reported Problems</span></h3><b class=\"w-100 h-100\"></b>\n";
			stringToSendToWebBrowser += "              </div>\n";
			stringToSendToWebBrowser += "              <div class=\"card-body\">\n";
			stringToSendToWebBrowser += "                <div class=\"card\">\n";
			stringToSendToWebBrowser += "                  <div class=\"card-body bg-primary\">\n";
			stringToSendToWebBrowser += "                    <h4 class=\"card-title text-info\">Problem Description</h4>\n";
			stringToSendToWebBrowser += "                    <h6 class=\"card-subtitle my-2 text-muted\">Problem Category</h6><img class=\"img-fluid d-block\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" height=\"120\" width=\"240\">\n";
			stringToSendToWebBrowser += "                    <a href=\"#\" class=\"card-link\">Card link</a>\n";
			stringToSendToWebBrowser += "                    <a href=\"#\" class=\"card-link\">Another link</a>\n";
			stringToSendToWebBrowser += "                  </div>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </div>\n";
			stringToSendToWebBrowser += "            </div>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-6\" style=\"\">\n";
			stringToSendToWebBrowser += "            <div class=\"card text-white my-3 rounded bg-dark\">\n";
			stringToSendToWebBrowser += "              <div class=\"card-header\">\n";
			stringToSendToWebBrowser += "                <h3 class=\"my-1 text-muted\"><span class=\"badge badge-pill text-dark badge-primary\">Report a Problem!</span></h3>\n";
			stringToSendToWebBrowser += "              </div>\n";
			stringToSendToWebBrowser += "              <div class=\"card-body\">\n";
			stringToSendToWebBrowser += "                <!--Report Card-->\n";
			stringToSendToWebBrowser += "                <p class=\"card-text\"><b>Ping the location of the problem on the map above and enter the required information. Afterwards, submit!</b><br></p>\n";
			stringToSendToWebBrowser += "                <!--Report Form-->\n";
			stringToSendToWebBrowser += "				 <a name=\"report\"></a>\n";		
			stringToSendToWebBrowser += "                <div class=\"Report-Form\">\n";
			stringToSendToWebBrowser += "                  <form action=\"/writereportprocess\" method=\"GET\">\n";
			stringToSendToWebBrowser += "                    <!--Description (Text Input)-->\n";
			stringToSendToWebBrowser += "                    <label for=\"description\" class=\"w-100 text-left pt-2\"><b>Description</b></label>\n";
			stringToSendToWebBrowser += "                    <input type=\"text\" class=\"form-control text-left\" name=\"desc\" placeholder=\"Provide a short despription of the problem\" required=\"required\">\n";
			stringToSendToWebBrowser += "                    <!--Location (Text Input)-->\n";
			stringToSendToWebBrowser += "                    <label for=\"location\" class=\"w-100 text-left pt-2\"><b>Location</b></label>\n";
			stringToSendToWebBrowser += "                    <input type=\"text\" class=\"form-control text-left\" name=\"location\" placeholder=\"Provide the address of the problem (alternative to pinging location)\" required=\"required\">\n";
			stringToSendToWebBrowser += "					 <!--Category (Dropdown)-->\n";
			stringToSendToWebBrowser += "                    <label for=\"category\" class=\"w-100 text-left pt-2\"><b>Category</b></label>\n";
			stringToSendToWebBrowser += "                    <select class=\"form-control text-left\" name=\"category\" required=\"required\">\n";
			stringToSendToWebBrowser += "                      <option value=\"\" disabled=\"disabled\" selected=\"selected\" class=\"text-dark\">Select a Suitable Category</option>\n";
			stringToSendToWebBrowser += "                      <option value=\"Graffiti\" class=\"text-dark\">Graffiti</option>\n";
			stringToSendToWebBrowser += "                      <option value=\"Pothole\" class=\"text-dark\">Pothole</option>\n";
			stringToSendToWebBrowser += "                      <option value=\"Street Lighting\" class=\"text-dark\">Street Lighting</option>\n";
			stringToSendToWebBrowser += "                      <option value=\"Dog Fouling\" class=\"text-dark\">Dog Fouling</option>\n";
			stringToSendToWebBrowser += "                    </select>\n";
			stringToSendToWebBrowser += "                    <label for=\"details\" class=\"w-100 text-left pt-2\"><b>Details</b></label>\n";
			stringToSendToWebBrowser += "                    <textarea name=\"details\" rows=\"10\" required=\"required\" placeholder=\"Tell us some details about the problem\" cols=\"70\" maxlength=\"600\" class=\"form-control text-left w-100 h-25\" ></textarea>\n";
			stringToSendToWebBrowser += "                    <!--Media (File Input)-->\n";
			stringToSendToWebBrowser += "                    <label for=\"files\" class=\"w-100 text-left pt-2\"><b>Photos/Videos</b></label>\n";
			stringToSendToWebBrowser += "                    <input type=\"file\" name=\"fileupload\" value=\"fileupload\" class=\"text-left form-control-file\">\n";
			stringToSendToWebBrowser += "                    <input value=\"Submit\" type=\"submit\" class=\"mt-4\">\n";
			stringToSendToWebBrowser += "                  </form>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </div>\n";
			stringToSendToWebBrowser += "            </div>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\" style=\"\"></script>\n";
			stringToSendToWebBrowser += "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\" style=\"\"></script>\n";
			stringToSendToWebBrowser += "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\n";
			stringToSendToWebBrowser += "  </div>\n";
			stringToSendToWebBrowser += "</body>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser);
			return true; 
		}else if(toProcess.path.equalsIgnoreCase("writereportprocess")) {
			
			Report problemReport = new Report();
			
			problemReport.reportID = "report_"+System.currentTimeMillis();
			problemReport.description = toProcess.params.get("desc");
			problemReport.category = toProcess.params.get("category");
			problemReport.details = toProcess.params.get("details");
			problemReport.filePathToImage = "https://www.telegraph.co.uk/content/dam/news/2018/06/11/TELEMMGLPICT000162928990_trans_NvBQzQNjv4BqpVlberWd9EgFPZtcLiMQfyf2A9a6I9YchsjMeADBa08.jpeg?imwidth=450";
			System.out.println("== Problem has been reported ==");
		}
		
		return false;
	}
	}


//Account Action will be default Login until cookie has an account and will change to logout
			//String accountAction = "Login";
			// Account will default be register until an account has been logged in and a user name can be displayed
			//String account = "Register";
