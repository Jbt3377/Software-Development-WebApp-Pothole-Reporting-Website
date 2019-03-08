package views;

import model.Report;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class IndexView extends DynamicWebPage{

	public IndexView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
	}
	
	public boolean process(WebRequest toProcess) {
		
		if(toProcess.path.equalsIgnoreCase("indexview")) {
			
			// Account Action will be default Login until cookie has an account and will change to logout
			String accountAction = "Login";
			// Account will default be register until an account has been logged in and a user name can be displayed
			String account = "Register";
			
			String stringToSendToBrowser = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"  <meta charset=\"utf-8\">\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body class=\"text-left\">\r\n" + 
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
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"loginview.html\">" + accountAction +"</a> </li>\r\n" + 
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\r\n" + 
					"          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signupview\">"+ account +"</a> </li>\r\n" + 
					"        </ul>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </nav>\r\n" + 
					"  <div class=\"text-center text-white\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-8 mx-auto\">\r\n" + 
					"          <h1 class=\"mb-3 mt-3 p-2\">What's Bothering You?</h1>\r\n" + 
					"          <p class=\"lead mb-0 p-2\">Fill My Hole is a website dedicated to informing local councils of problems they have the responsibility to fix.<br></p>\r\n" + 
					"          <p class=\"lead text-center text-capitalize p-0 m-2\">Got a Problem?&nbsp; Report it!<br></p><a class=\"btn btn-primary m-2 my-3 mb-4\" href=\"#report\"><b class=\"text-center\">Report an Issue</b></a>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-12\"><iframe width=\"100%\" height=\"400\" src=\"https://maps.google.com/maps?q=New%20York&amp;z=14&amp;output=embed\" scrolling=\"no\" frameborder=\"0\"></iframe></div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"	 <a name=\"report\"></a>"+
					"    <div class=\"container py-4\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"row\">\r\n" + 
					"          <div class=\"col-md-6\" style=\"\">\r\n" + 
					"            <div class=\"card text-white bg-dark my-3\">\r\n" + 
					"              <div class=\"card-header text-center\"><b class=\"w-100 h-100\">How to Report a Problem</b></div>\r\n" + 
					"              <div class=\"card-body\">\r\n" + 
					"                <ol class=\"\">\r\n" + 
					"                  <li class=\"text-left py-2\"><b>Locate - </b>Use the map above to find the area of the problem</li>\r\n" + 
					"                  <li class=\"text-left py-2\"><b>Mark - </b>Click on the precise location of the problem</li>\r\n" + 
					"                  <li class=\"text-left py-2\"><b>Tell us! - </b>Provide us with information on the problem and we'll pass it onto the local council. You can include images as well!&nbsp;</li>\r\n" + 
					"                </ol>\r\n" + 
					"              </div>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"card text-white bg-dark my-3\">\r\n" + 
					"              <div class=\"card-header text-center\">\r\n" + 
					"                <h3 class=\"text-center text-capitalize\"><span class=\"badge badge-light badge-pill\" style=\"\">Recently Reported Problems</span></h3><b class=\"w-100 h-100\"></b>\r\n" + 
					"              </div>\r\n" + 
					"              <div class=\"card-body\">\r\n" + 
					"                <div class=\"card\">\r\n" + 
					"                  <div class=\"card-body bg-primary\">\r\n" + 
					"                    <h4 class=\"card-title text-info\">Problem Description</h4>\r\n" + 
					"                    <h6 class=\"card-subtitle my-2 text-muted\">Problem Category</h6><img class=\"img-fluid d-block\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" height=\"120\" width=\"240\">\r\n" + 
					"                    <a href=\"#\" class=\"card-link\">Card link</a>\r\n" + 
					"                    <a href=\"#\" class=\"card-link\">Another link</a>\r\n" + 
					"                  </div>\r\n" + 
					"                </div>\r\n" + 
					"              </div>\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"          <div class=\"col-md-6\" style=\"\">\r\n" + 
					"            <div class=\"card text-white my-3 rounded bg-dark\">\r\n" + 
					"              <div class=\"card-header\">\r\n" + 
					"                <h3 class=\"my-1 text-muted\"><span class=\"badge badge-pill text-dark badge-primary\">Report a Problem!</span></h3>\r\n" + 
					"              </div>\r\n" + 
					"              <div class=\"card-body\">\r\n" + 
					"                <!--Report Card-->\r\n" + 
					"                <p class=\"card-text\"><b>Ping the location of the problem on the map above and enter the required information. Afterwards, submit!</b><br></p>\r\n" + 
					"                <!--Report Form-->\r\n" + 
					"                <div class=\"Report-Form\">\r\n" + 
					"                  <form action=\"/writereportprocess\" method=\"GET\">\r\n" + 
					"                    <!--Description (Text Input)-->\r\n" + 
					"                    <label for=\"description\" class=\"w-100 text-left pt-2\"><b>Description</b></label>\r\n" + 
					"                    <input type=\"text\" class=\"form-control text-left\" name=\"desc\" placeholder=\"Provide a short despription of the problem\" required=\"required\">\r\n" + 
					"                    <!--Location (Text Input)-->\r\n" + 
					"                    <label for=\"location\" class=\"w-100 text-left pt-2\"><b>Location</b></label>\r\n" + 
					"                    <input type=\"text\" class=\"form-control text-left\" name=\"location\" placeholder=\"Provide the address of the problem (alternative to pinging location)\" required=\"required\">" +
					"					 <!--Category (Dropdown)-->\r\n" + 
					"                    <label for=\"category\" class=\"w-100 text-left pt-2\"><b>Category</b></label>\r\n" + 
					"                    <select class=\"form-control text-left\" name=\"category\" required=\"required\">\r\n" + 
					"                      <option value=\"\" disabled=\"disabled\" selected=\"selected\" class=\"text-dark\">Select a Suitable Category</option>\r\n" + 
					"                      <option value=\"Graffiti\" class=\"text-dark\">Graffiti</option>\r\n" + 
					"                      <option value=\"Pothole\" class=\"text-dark\">Pothole</option>\r\n" + 
					"                      <option value=\"Street Lighting\" class=\"text-dark\">Street Lighting</option>\r\n" + 
					"                      <option value=\"Dog Fouling\" class=\"text-dark\">Dog Fouling</option>\r\n" + 
					"                    </select>\r\n" + 
					"                    <!--Details (Text Area)-->\r\n" + 
					"                    <label for=\"details\" class=\"w-100 text-left pt-2\"><b>Details</b></label>\r\n" + 
					"                    <textarea name=\"details\" rows=\"10\" required=\"required\" placeholder=\"Tell us some details about the problem\" cols=\"70\" maxlength=\"600\" class=\"form-control text-left w-100 h-25\" ></textarea>\r\n" + 
					"                    <!--Media (File Input)-->\r\n" + 
					"                    <label for=\"files\" class=\"w-100 text-left pt-2\"><b>Photos/Videos</b></label>\r\n" + 
					"                    <input type=\"file\" name=\"fileupload\" value=\"fileupload\" class=\"text-left form-control-file\">\r\n" + 
					"                    <input value=\"Submit\" type=\"submit\" class=\"mt-4\">\r\n" + 
					"                  </form>\r\n" + 
					"                </div>\r\n" + 
					"              </div>\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
					"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
					"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
					"  </div>\r\n" + 
					"</body>\r\n" + 
					"\r\n" + 
					"</html>";
			
			// Web Response
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToBrowser);
			
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
