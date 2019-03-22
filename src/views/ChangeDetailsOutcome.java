package views;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class ChangeDetailsOutcome extends DynamicWebPage
{
	public ChangeDetailsOutcome(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		String outcomeMessage = "", suspectedIssue="";
		boolean toBeProcessed = false;
		if(toProcess.path.equalsIgnoreCase("ChangeDetailsSuccessful.html")){
			toBeProcessed = true;
			outcomeMessage += "          <div class=\"card-header text-center\"><b class=\"w-100 h-100\">Changes have been Saved!</b></div>\r\n";
        }else if(toProcess.path.equalsIgnoreCase("ChangeDetailsFailed.html")) {
        	toBeProcessed = true;
        	outcomeMessage += "          <div class=\"card-header text-center\"><b class=\"w-100 h-100\">Something went wrong!</b></div>\r\n";
        	suspectedIssue += "            <p>Make sure your password is correct - it's required for making changes!</p><br>\r\n";
        }else if(toProcess.path.equalsIgnoreCase("ChangePictureSuccess.html")) {
        	toBeProcessed = true;
        	outcomeMessage += "          <div class=\"card-header text-center\"><b class=\"w-100 h-100\">New profile picture added!</b></div>\r\n";
        }else if(toProcess.path.equalsIgnoreCase("ChangePictureFailed.html")) {
        	toBeProcessed = true;
        	outcomeMessage += "          <div class=\"card-header text-center\"><b class=\"w-100 h-100\">Something went wrong!</b></div>\r\n";
        	suspectedIssue += "            <p>Profile picture couldn't be saved - image not valid!</p><br>\r\n";
        }else if(toProcess.path.equalsIgnoreCase("ChangePictureFailedNoPicture.html")) {
        	toBeProcessed = true;
        	outcomeMessage += "          <div class=\"card-header text-center\"><b class=\"w-100 h-100\">Something went wrong!</b></div>\r\n";
        	suspectedIssue += "            <p>Profile picture couldn't be saved - no image was provided!</p><br>\r\n";
        }
		
        if(toBeProcessed)
        {
        	
        	System.out.println("\n\nRequest for Web Page: " + toProcess.path);
			String username = toProcess.cookies.get("username");
			
        	String stringToSendToBrowser = "";
			stringToSendToBrowser += "<!DOCTYPE html>\r\n";
			stringToSendToBrowser += "<html>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "<head>\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "</head>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "<body class=\"text-left\">\r\n";
			stringToSendToBrowser += "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n";
			stringToSendToBrowser += "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\r\n";
			stringToSendToBrowser += "        <span class=\"navbar-toggler-icon\"></span>\r\n";
			stringToSendToBrowser += "      </button>\r\n";
			stringToSendToBrowser += "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"index.html\">\n";
			stringToSendToBrowser += "          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n";
			stringToSendToBrowser += "          <b>FILL MY HOLE</b>\n";
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
				stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"signupview\">Register</a> </li>\n";
			}
			
			stringToSendToBrowser += "        </ul>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "    </div>\r\n";
			stringToSendToBrowser += "  </nav>\r\n";
			stringToSendToBrowser += "  <div class=\"text-center text-white\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\" >\r\n";
			stringToSendToBrowser += "    <div class=\"container py-4\" style=\"width: 1200px; height: 700px;>\r\n";
			stringToSendToBrowser += "      <div class=\"row\">\r\n";
			stringToSendToBrowser += "        <div class=\"card text-white bg-dark my-3 align-center\">\r\n";
			stringToSendToBrowser += outcomeMessage;
			stringToSendToBrowser += "            <div class=\"card-body\">\r\n";
			stringToSendToBrowser += suspectedIssue;
			stringToSendToBrowser += "              <a class=\"btn btn-primary my-3\" href=\"accountview\"><b class=\"text-center\">Back</b></a>\r\n";
			stringToSendToBrowser += "            </div>\r\n";
			stringToSendToBrowser += "          </div>\r\n";
			stringToSendToBrowser += "        </div>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "    </div>\r\n";
			stringToSendToBrowser += "  </div>\r\n";
			//Footer
			stringToSendToBrowser +="  <div class=\"py-3 bg-dark\">\r\n";
			stringToSendToBrowser +="    <div class=\"container\">\r\n";
			stringToSendToBrowser +="      <div class=\"row\">\r\n";
			stringToSendToBrowser +="        <div class=\"my-3 col-lg-8\">\r\n";
			stringToSendToBrowser +="          <h2 class=\"text-center text-lg-left text-white\" style=\"\">Help others by sharing</h2>\r\n";
			stringToSendToBrowser +="        </div>\r\n";
			stringToSendToBrowser +="        <div class=\"text-center align-self-center col-lg-4\"> <a href=\"https://www.facebook.com/FMH-308708959763566/\">\r\n";
			stringToSendToBrowser +="            <i class=\"fa fa-fw fa-facebook text-white mx-3 fa-3x\"></i>\r\n";
			stringToSendToBrowser +="          </a> <a href=\"https://twitter.com/QUBelfast\">\r\n";
			stringToSendToBrowser +="            <i class=\"fa fa-fw fa-twitter fa-3x text-white mx-3\"></i>\r\n";
			stringToSendToBrowser +="          </a> <a href=\"https://www.instagram.com/fmhwebpage/\">\r\n";
			stringToSendToBrowser +="            <i class=\"fa fa-fw fa-instagram fa-3x text-white mx-3\"></i>\r\n";
			stringToSendToBrowser +="          </a> </div>\r\n";
			stringToSendToBrowser +="      </div>\r\n";
			stringToSendToBrowser +="    </div>\r\n";
			stringToSendToBrowser +="  </div>\r\n";
			stringToSendToBrowser += "</body>\r\n";
			stringToSendToBrowser += "</html>\r\n";
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToBrowser );

        	return true;
        }
        return false;
	}

}