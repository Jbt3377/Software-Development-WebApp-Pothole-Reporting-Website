package views;


import java.io.File;

import org.h2.mvstore.MVMap;

import model.Profile;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class AccountView extends DynamicWebPage{

	public AccountView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
	}
	
	public boolean process(WebRequest toProcess) {
	
		MVMap<String, Profile> profiles = db.s.openMap("Profiles");

		String email = toProcess.cookies.get("email");
		Profile currentUser = profiles.get(email);
		
		String name = currentUser.name;
		String password = currentUser.password;
		String address = currentUser.address;
		String filepath = currentUser.filePathToProfilePicture;
		
		
		if(toProcess.path.equalsIgnoreCase("accountview") || toProcess.path.equalsIgnoreCase("account.html")) {
			
			System.out.println("\n\nRequest for Web Page: " + toProcess.path);
			
			String stringToSendToBrowser = "";
			stringToSendToBrowser += "<!DOCTYPE html>\r\n";
			stringToSendToBrowser += "<html>\r\n";
			stringToSendToBrowser += "<head>\r\n";
			stringToSendToBrowser += "  <meta charset=\"utf-8\">  \r\n";
			stringToSendToBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">  \r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "  <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "    <!--[if lt IE 9]>\" +\r\n";
			stringToSendToBrowser += "      <script src=\"/js/html5shiv.js\"></script>\" +\r\n" ;
			stringToSendToBrowser += "      <script src=\"/js/respond.min.js\"></script>\" +\r\n"; 
			stringToSendToBrowser += "    <![endif]-->\" +\r\n";
			stringToSendToBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\" +\r\n";
			stringToSendToBrowser += "   <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\" +\r\n";
			stringToSendToBrowser += "</head>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "<body onload=\"ProfileLoadFunction('" + name + "', '" + email + "', '" + password + "', '" + address + "', '" + filepath + "')\" class=\"text-left\">\r\n";
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
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link disabled\" href=\"#\">Welcome " + email + "</a> </li>\r\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
			stringToSendToBrowser += "          <li class=\"nav-item\"> <a class=\"nav-link btn-primary text-light\" href=\"accountview\">Account</a> </li>\n";
			stringToSendToBrowser += "        </ul>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "    </div>\r\n";
			stringToSendToBrowser += "  </nav>\r\n"; 
			stringToSendToBrowser += "  <div class=\"d-flex h-100 w-100 pt-3 pb-5 mt-0 mb-5 text-center flex-column align-items-stretch\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: auto, auto;  background-repeat: repeat, repeat;\" >\n";
			stringToSendToBrowser += "    <div class=\"py-0 px-5 container rounded w-100\">\n";
			stringToSendToBrowser += "      <div class=\"card bg-dark\">\n";
			stringToSendToBrowser += "        <div class=\"card-body w-100 px-0 text-center\">\n";
			stringToSendToBrowser += "          <h5 class=\"mb-0 display-1 text-left pl-5\">Your Account</h5>\n";
			stringToSendToBrowser += 	"          <div class=\"card-body text-center\">\n";
			stringToSendToBrowser += "            <div class=\"row mt-1\">\n";
			stringToSendToBrowser += 	"              <div class=\"col-md-12\">\n";
			stringToSendToBrowser += "                <h5 class=\"mb-2 text-left\"><b class=\"pl-4\">&nbsp;Your Info</b></h5>\n";
			stringToSendToBrowser += "              </div>\n";
			stringToSendToBrowser += "            </div>\n";
			stringToSendToBrowser += "            <div class=\"row\">\n";
			stringToSendToBrowser += "              <div class=\"col-md-6\">\n";
			stringToSendToBrowser += "                <div class=\"row mt-3 pl-5 pt-1\">\n";
			stringToSendToBrowser += "                  <form class=\"text-left\" action=\"/Submit\" method=\"POST\" enctype=\"multipart/form-data\">\n";
			stringToSendToBrowser += "                    <div class=\"form-group\"> <label for=\"form16\">Your Name</label> <input type=\"text\" class=\"form-control\" id=\"form16\" value=\"Name...\"></div>\n";
			stringToSendToBrowser += "                    <div class=\"form-group\"> <label for=\"form18\">Your Email</label> <input type=\"email\" class=\"form-control\" id=\"form17\" placeholder=\"Email...\"> </div>\n";
			stringToSendToBrowser += "                    <textarea name=\"Address\" rows=\"5\" cols=\"30\" class=\"form-control text-left w-70 text-white\" maxlength=\"255\" id=\"form18\"> </textarea>\r\n";
			stringToSendToBrowser += "                    <div class=\"form-row\">\n";
			stringToSendToBrowser += "                      <div class=\"form-group col-md-6\"> <label for=\"form19\">Password</label> <input type=\"password\" class=\"form-control\" id=\"form19\" placeholder=\"Password\"> </div>\n";
			stringToSendToBrowser += "                      <div class=\"form-group col-md-6\"> <label for=\"form20\">Confirm Password</label> <input type=\"password\" class=\"form-control\" id=\"form19\" placeholder=\"Password\"> </div>\n";
			stringToSendToBrowser += "                    </div><a class=\"btn btn-primary mt-3\" href=\"#\"><i class=\"fa fa-download fa-fw\"></i>&nbsp;Save Changes</a>\n";
			stringToSendToBrowser += "                  </form>\n";
			stringToSendToBrowser += "                </div>\n";
			stringToSendToBrowser += "              </div>\n";
			stringToSendToBrowser += "              <form class=\"col-md-6 text-left\" action=\"/Submit\" method=\"POST\" enctype=\"multipart/form-data\"><a href=\"index.html\"><img class=\"d-block rounded-circle img-fluid w-75 mx-auto\" src=\"" + filepath + "\">\n";
			stringToSendToBrowser += "				<div><h5 class=\"mt-2\">Click the image above to upload your profile picture.</h5>\n";
			stringToSendToBrowser += "                  </form>\n";
			stringToSendToBrowser += "                </div>\n";
			stringToSendToBrowser += "              </div>\n";
			stringToSendToBrowser += "            </div>\n";
			stringToSendToBrowser += "          </div>\n";
			stringToSendToBrowser += "        </div>\n";
			stringToSendToBrowser += "      </div>\n";
			stringToSendToBrowser += "    </div>\n";
			stringToSendToBrowser += "  </div>\n";
			stringToSendToBrowser += "  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n";
			stringToSendToBrowser += "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\" style=\"\"></script>\n";
			stringToSendToBrowser += "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n";
			stringToSendToBrowser += "  <script src=\"/js/ProfileLoadFunction.js\"></script>";
			stringToSendToBrowser += "  <script src=\"/js/alert.js\"></script>";
			stringToSendToBrowser += "</body>\n";
			stringToSendToBrowser += "\n";
			stringToSendToBrowser += "</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToBrowser );
			return true;
			
		}else if(toProcess.path.equalsIgnoreCase("Submit")) {
			try {
				File uploaded = new File(currentUser.filePathToProfilePicture);
				int ind = currentUser.filePathToProfilePicture.lastIndexOf('.');
				String extension = currentUser.filePathToProfilePicture.substring(ind);
				uploaded.renameTo(new File("httpdocs/"+currentUser.username+extension));
				currentUser.filePathToProfilePicture = currentUser.username+extension;
			}catch( StringIndexOutOfBoundsException e ) {
				System.out.println("You did an oopsie");
			}
			
		}
	return false; 
	}
}
