package views;

import model.ProblemType;
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
			
			Report problemReport = new Report();
			problemReport.description = "Description of Problem";
			problemReport.details = "Added details of problem";
			problemReport.filePathToImage = "https://www.telegraph.co.uk/content/dam/news/2018/06/11/TELEMMGLPICT000162928990_trans_NvBQzQNjv4BqpVlberWd9EgFPZtcLiMQfyf2A9a6I9YchsjMeADBa08.jpeg?imwidth=450";
			problemReport.type = ProblemType.SELECT;
			
			String accountUserName = "Log in";
			String stringToSendToBrowser = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"  <meta charset=\"utf-8\">\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"/now-ui-kit.css\" type=\"text/css\">\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body class=\"text-left\">\r\n" + 
					"  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n" + 
					"    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\">\r\n" + 
					"        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
					"      </button>\r\n" + 
					"      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"#\">\r\n" + 
					"          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\r\n" + 
					"          <b contenteditable=\"true\">&nbsp;FILL MY HOLE</b>\r\n" + 
					"        </a>\r\n" + 
					"        <ul class=\"navbar-nav mx-auto\">\r\n" + 
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Report a Problem</a> </li>\r\n" + 
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\r\n" + 
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"formPage.html\">FAQ</a> </li>\r\n" + 
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"AboutUs.html\">About Us</a> </li>\r\n" + 
					"        </ul>\r\n" + 
					"        <ul class=\"navbar-nav\">\r\n" + 
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.html\">Log in</a> </li>\r\n" + 
					"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\r\n" + 
					"          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signup.html\">Register</a> </li>\r\n" + 
					"        </ul>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </nav>\r\n" + 
					"  <div class=\"text-center text-white\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-8 mx-auto\">\r\n" + 
					"          <h1 class=\"mb-3\">What's Bothering You?</h1>\r\n" + 
					"          <p class=\"lead mb-0\">Fill My Hole is a website dedicated to informing local councils of problems they have the responsibility to fix.<br></p>\r\n" + 
					"          <p class=\"lead mb-0 text-center text-capitalize\" contenteditable=\"true\"><br>Got a Problem?&nbsp; Report it!<br></p><a class=\"btn btn-primary m-3\" href=\"#\" contenteditable=\"true\">Report an Issue</a>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-12\"><iframe width=\"100%\" height=\"400\" src=\"https://maps.google.com/maps?q=New%20York&amp;z=14&amp;output=embed\" scrolling=\"no\" frameborder=\"0\"></iframe></div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"container py-5\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-12\">\r\n" + 
					"          <div class=\"card text-white bg-dark mb-3\">\r\n" + 
					"          </div>\r\n" + 
					"          <div class=\"row\">\r\n" + 
					"            <div class=\"col-md-6\">\r\n" + 
					"              <div class=\"card text-white bg-dark mb-3\">\r\n" + 
					"                <div class=\"card-header text-center\"><b class=\"w-100 h-100\">How to Report a Problem</b></div>\r\n" + 
					"                <div class=\"card-body\">\r\n" + 
					"                  <ol class=\"\">\r\n" + 
					"                    <li class=\"text-left py-2\"><b>Locate - </b>Use the map above to find the area of the problem</li>\r\n" + 
					"                    <li class=\"text-left py-2\"><b>Mark - </b>Click on the precise location of the problem</li>\r\n" + 
					"                    <li class=\"text-left py-2\"><b>Tell us! - </b>Provide us with information on the problem and we'll pass it onto the local council. You can include images as well!&nbsp;</li>\r\n" + 
					"                  </ol>\r\n" + 
					"                </div>\r\n" + 
					"              </div>\r\n" + 
					"              <div class=\"card text-white bg-dark mb-3\">\r\n" + 
					"                <div class=\"card-header text-center pb-0\">\r\n" + 
					"                  <h3 class=\"text-center text-capitalize\"><span class=\"badge badge-pill badge-light\" style=\"\">Recently Reported Problems</span></h3><b class=\"w-100 h-100\"></b>\r\n" + 
					"                </div>\r\n" + 
					"                <div class=\"card-body\">\r\n" + 
					"                  <div class=\"card\">\r\n" + 
					"                    <div class=\"card-body bg-primary\">\r\n" + 
					"                      <h4 class=\"card-title text-info\" >"+ problemReport.description + "</h4>\r\n" + 
					"                      <h6 class=\"card-subtitle my-2 text-muted\">"+ problemReport.type +"</h6><img class=\"img-fluid d-block mx-auto\" src=\""+ problemReport.filePathToImage +"\">\r\n" + 
					"                      <a href=\"#\" class=\"card-link\">Card link</a>\r\n" + 
					"                      <a href=\"#\" class=\"card-link\">Another link</a>\r\n" + 
					"                    </div>\r\n" + 
					"                  </div>\r\n" + 
					"                </div>\r\n" + 
					"              </div>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"col-md-6\">\r\n" + 
					"              <div class=\"card text-white bg-secondary mb-3\">\r\n" + 
					"                <div class=\"card-header\">\r\n" + 
					"                  <h3 class=\"my-1\"><span class=\"badge badge-pill badge-warning\">Report a Problem!</span></h3>\r\n" + 
					"                </div>\r\n" + 
					"                <div class=\"card-body\">\r\n" + 
					"                  <p class=\"card-text m-2\"><b>Ping the location of the problem on the map above and enter the required information. Afterwards, submit!</b><br></p>\r\n" + 
					"                  <div class=\"form-group\"><label class=\"w-100 text-left\">Description</label><input type=\"text\" class=\"form-control text-left\" id=\"inlineFormInputGroup\" required=\"required\" name=\"problemType\" placeholder=\"Write a short description of the problem\"></div>\r\n" + 
					"                  <div class=\"form-group\"><label class=\"w-100 text-left\">Category</label><input type=\"search\" class=\"form-control text-left\" id=\"inlineFormInputGroup\" required=\"required\" name=\"problemType\" placeholder=\"Select the category of the problem\"></div>\r\n" + 
					"                  <div class=\"form-group\"><label class=\"w-100 text-left\">Details</label><input type=\"text\" class=\"form-control h-25 text-left\" id=\"inlineFormInputGroup\" required=\"required\" name=\"problemType\" placeholder=\"Provide any extra details you can for the issue\"></div>\r\n" + 
					"                  <div class=\"form-group\"><label class=\"w-100 text-left\" contenteditable=\"true\">Media (Photos /Videos)</label><input type=\"file\" class=\"text-center form-control-file\" id=\"inlineFormInputGroup\" name=\"problemType\" placeholder=\"Provide any extra details you can for the issue\"></div>\r\n" + 
					"                </div>\r\n" + 
					"              </div>\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
					"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n" + 
					"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
					"  <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\r\n" + 
					"</body>\r\n" + 
					"\r\n" + 
					"</html>";
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToBrowser);
			
			return true;
		}
		
		return false;
	}

}
