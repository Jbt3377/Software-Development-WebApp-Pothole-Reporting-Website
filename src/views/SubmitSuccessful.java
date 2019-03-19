package views;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class SubmitSuccessful extends DynamicWebPage
{
	public SubmitSuccessful(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
        if(toProcess.path.equalsIgnoreCase("SubmitSuccessful.html"))
        {
        	
        	System.out.println("\n\nRequest for Web Page: " + toProcess.path);
			String username = toProcess.cookies.get("username"); 
			String password = toProcess.cookies.get("password");
        	
        	String stringToSendToBrowser = "";
			stringToSendToBrowser += "<!DOCTYPE html>\r\n";
			stringToSendToBrowser += "<html>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "<head>\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.4.0/dist/leaflet.css\" />\r\n";
			stringToSendToBrowser += "</head>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "<body class=\"text-left\">\r\n";
			stringToSendToBrowser += "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n";
			stringToSendToBrowser += "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\r\n";
			stringToSendToBrowser += "        <span class=\"navbar-toggler-icon\"></span>\r\n";
			stringToSendToBrowser += "      </button>\r\n";
			stringToSendToBrowser += "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"index.html\">\n";
			stringToSendToBrowser += "          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n";
			stringToSendToBrowser += "          <b>&nbsp;FILL MY HOLE</b>\n";
			stringToSendToBrowser += "        </a>\n";
			stringToSendToBrowser += "        <ul class=\"navbar-nav mx-auto\">\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#reportForm\">Report a Problem</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"HelpView\">FAQ</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"AboutUsView\">About Us</a> </li>\r\n";
			stringToSendToBrowser += "        </ul>\r\n";
			stringToSendToBrowser += "        <ul class=\"navbar-nav\">\r\n";
			
			// Account actions alter depending if user is signed in
			if(username!=null)
			{
				stringToSendToBrowser += "  		   <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Welcome "+ username +"</a> </li>\n";
			}
			else
			{
				stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.html\">Login</a> </li>\n";
				stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
				stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signup.html\">Register</a> </li>\n";
			}
			
			stringToSendToBrowser += "        </ul>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "    </div>\r\n";
			stringToSendToBrowser += "  </nav>\r\n";
			stringToSendToBrowser += "  <div class=\"text-center text-white\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\" >\r\n";
			stringToSendToBrowser += "    <div class=\"container\">\r\n";
			stringToSendToBrowser += "      <div class=\"row\">\r\n";
			stringToSendToBrowser += "        <div class=\"col-md-8 mx-auto\">\r\n";
			stringToSendToBrowser += "          <h1 class=\"mb-3 mt-3 p-2\">What's Bothering You?</h1>\r\n";
			stringToSendToBrowser += "          <p class=\"lead mb-0 p-2\">Fill My Hole is a website dedicated to informing local councils of problems they have the responsibility to fix.<br></p>\r\n";
			stringToSendToBrowser += "          <p class=\"lead text-center text-capitalize p-0 m-2\">Got a Problem?&nbsp; Report it!<br></p><a class=\"btn btn-primary m-2 my-3 mb-4\" href=\"#reportForm\"><b class=\"text-center\">Report an Issue</b></a>\r\n";
			stringToSendToBrowser += "        </div>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "    <div class=\"container py-4\">\r\n";
			stringToSendToBrowser += "        <div class=\"row\">\r\n";
			stringToSendToBrowser += "          <div class=\"col-md-6\" style=\"\">\r\n";
			stringToSendToBrowser += "            <div class=\"card text-white bg-dark my-3\">\r\n";
			stringToSendToBrowser += "              <div class=\"card-header text-center\"><b class=\"w-100 h-100\">How to Report a Problem</b></div>\r\n";
			stringToSendToBrowser += "              <div class=\"card-body\">\r\n";
			stringToSendToBrowser += "                <ol class=\"\">\r\n";
			stringToSendToBrowser += "                  <li class=\"text-left py-2\"><b>Locate - </b>Use the map above to find the area of the problem</li>\r\n";
			stringToSendToBrowser += "                  <li class=\"text-left py-2\"><b>Mark - </b>Click on the precise location of the problem</li>\r\n";
			stringToSendToBrowser += "                  <li class=\"text-left py-2\"><b>Tell us! - </b>Provide us with information on the problem and we'll pass it onto the local council. You can include images as well!</li>\r\n";
			stringToSendToBrowser += "                </ol>\r\n";
			stringToSendToBrowser += "              </div>\r\n";
			stringToSendToBrowser += "            </div>\r\n";
			stringToSendToBrowser += "</body>\r\n";
			stringToSendToBrowser += "</html>\r\n";
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToBrowser );

        	return true;
        }
        return false;
	}

}
