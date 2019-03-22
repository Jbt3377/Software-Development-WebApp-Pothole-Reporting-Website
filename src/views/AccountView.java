package views;


import java.io.File;

import org.h2.mvstore.MVMap;
import java.io.*;
import java.util.*;
import model.Profile;
import model.Report;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class AccountView extends DynamicWebPage{

	public AccountView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
	}
	
	public boolean process(WebRequest toProcess) {
	
		// Get email of user currently logged in
		String email = toProcess.cookies.get("email");
		
		// Use email as unique identifier (key) to get user profile object
		MVMap<String, Profile> profiles = db.s.openMap("Profiles");
		Profile currentUser = profiles.get(email);
		
		// User Details
		String name = currentUser.name;
		String password = currentUser.password;
		String address = currentUser.address;
			
		if(toProcess.path.equalsIgnoreCase("accountview") || toProcess.path.equalsIgnoreCase("account.html")) {
			
			System.out.println("\n\nRequest for Web Page: " + toProcess.path);
			String currentFilePathToProfilePic = currentUser.filePathToProfilePicture;
			System.out.println("Profile Picture File Path: " + currentFilePathToProfilePic);
			
			String stringToSendToBrowser = "";
			stringToSendToBrowser += "<!DOCTYPE html>\r\n";
			stringToSendToBrowser += "<html>\r\n";
			stringToSendToBrowser += "  <head>\r\n";
			stringToSendToBrowser += "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "    <link rel=\"stylesheet\" href=\"now-ui-kit.css\" type=\"text/css\">\r\n";
			stringToSendToBrowser += "    <!--[if lt IE 9]>\" +\r\n";
			stringToSendToBrowser += "      <script src=\"/js/html5shiv.js\"></script>\" +\r\n" ;
			stringToSendToBrowser += "      <script src=\"/js/respond.min.js\"></script>\" +\r\n"; 
			stringToSendToBrowser += "    <![endif]-->\" +\r\n";
			stringToSendToBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\" +\r\n";
			stringToSendToBrowser += "    <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\" +\r\n";
			stringToSendToBrowser += "  </head>\r\n";
			stringToSendToBrowser += "\r\n";
			stringToSendToBrowser += "  <body onload=\"ProfileLoadFunction('" + name + "', '" + password + "', '" + address + "')\" class=\"text-left\">\r\n";
			stringToSendToBrowser += "    <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n";
			stringToSendToBrowser += "      <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\r\n";
			stringToSendToBrowser += "        <span class=\"navbar-toggler-icon\"></span>\r\n";
			stringToSendToBrowser += "        </button>\r\n";
			stringToSendToBrowser += "        <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"index.html\">\n";
			stringToSendToBrowser += "          <i class=\"fa d-inline fa-lg fa-wrench\"></i>\n";
			stringToSendToBrowser += "          <b>&nbsp;FILL MY HOLE</b>\n";
			stringToSendToBrowser += "          </a>\n";
			stringToSendToBrowser += "          <ul class=\"navbar-nav mx-auto\">\r\n";
			stringToSendToBrowser += "            <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#reportForm\">Report a Problem</a> </li>\r\n";
			stringToSendToBrowser += "            <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Your Area</a> </li>\r\n";
			stringToSendToBrowser += "            <li class=\"nav-item\"> <a class=\"nav-link\" href=\"HelpView\">FAQ</a> </li>\r\n";
			stringToSendToBrowser += "            <li class=\"nav-item\"> <a class=\"nav-link\" href=\"AboutUsView\">About Us</a> </li>\r\n";
			stringToSendToBrowser += "          </ul>\r\n";
			stringToSendToBrowser += "          <ul class=\"navbar-nav\">\r\n";
			stringToSendToBrowser += "            <li class=\"nav-item\"> <a class=\"nav-link disabled\" href=\"#\">Welcome " + email + "</a> </li>\r\n";
			stringToSendToBrowser += "            <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">|</a> </li>\n";
			stringToSendToBrowser += "            <li class=\"nav-item\"> <a class=\"nav-link btn-primary text-light\" href=\"accountview\">Account</a> </li>\n";
			stringToSendToBrowser += "          </ul>\r\n";
			stringToSendToBrowser += "        </div>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "    </nav>\r\n"; 
//			stringToSendToBrowser += "  <div class=\"d-flex h-100 w-100 pt-3 pb-5 mt-0 mb-5 text-center flex-column align-items-stretch\" style=\"background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;\" >\n";
			stringToSendToBrowser += "  <div class=\"text-center text-white pt-3\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url(&quot;https://static.pingendo.com/cover-bubble-dark.svg&quot;); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;\" >\r\n";
			stringToSendToBrowser += "    <div class=\"py-0 px-5 container rounded w-100\">\n";
			stringToSendToBrowser += "      <div class=\"card bg-dark\">\n";
			stringToSendToBrowser += "        <div class=\"card-body w-100 px-0 text-center\">\n";
			stringToSendToBrowser += "          <h5 class=\"mb-0 display-1 text-left pl-5\">Your Account</h5>\n";
			stringToSendToBrowser += "          <div class=\"card-body text-center\">\n";
			stringToSendToBrowser += "            <div class=\"row mt-1\">\n";
			stringToSendToBrowser += "              <div class=\"col-md-12\">\n";
			stringToSendToBrowser += "                <h5 class=\"mb-2 text-left\"><b class=\"pl-4\">&nbsp;Your Info</b></h5>\n";
			stringToSendToBrowser += "              </div>\n";
			stringToSendToBrowser += "            </div>\n";
			stringToSendToBrowser += "            <div class=\"row\">\n";
			stringToSendToBrowser += "              <div class=\"col-md-6\">\n";
			stringToSendToBrowser += "                <div class=\"row mt-3 pl-5 pt-1\">\n";
			stringToSendToBrowser += "                  <form class=\"text-left\" action=\"/SubmitNewDetails\" method=\"POST\" enctype=\"multipart/form-data\">\n";
			stringToSendToBrowser += "                    <div class=\"form-group\">\r\n";
			stringToSendToBrowser += "                      <label for=\"newName\">Your Name</label>\r\n";
			stringToSendToBrowser += "                      <input type=\"text\" class=\"form-control\" name=\"newName\" id=\"newName\" placeholder=\"Name...\">\r\n";
			stringToSendToBrowser += "                    </div>\r\n";
			stringToSendToBrowser += "                    <div class=\"form-group\">\r\n";
			stringToSendToBrowser += "                      <label for=\"newAddress\" class=\"w-100 text-left pt-2\"><b>Address</b></label>\r\n";
			stringToSendToBrowser += "                      <textarea rows=\"5\" cols=\"30\" class=\"form-control text-left w-70 text-white\" maxlength=\"255\" name=\"newAddress\" id=\"newAddress\" placeholder=\"Address...\"> </textarea>\r\n";
			stringToSendToBrowser += "                    </div>\r\n";
			stringToSendToBrowser += "                    <br><p>You must confirm your password to us before changing details</p><br>\r\n";
			stringToSendToBrowser += "                    <div class=\"form-row\">\n";
			stringToSendToBrowser += "                      <div class=\"form-group col-md-6\"> <label for=\"newPassword\">Password</label> <input type=\"password\" class=\"form-control\" name=\"newPassword\" id=\"newPassword\" placeholder=\"Password\"> </div>\n";
			stringToSendToBrowser += "                      <div class=\"form-group col-md-6\"> <label for=\"newPasswordConfirm\">Confirm Password</label> <input type=\"password\" class=\"form-control\" name=\"newPasswordConfirm\" id=\"newPasswordConfirm\" placeholder=\"Password\"> </div>\n";
			stringToSendToBrowser += "                    </div>";
			stringToSendToBrowser += "                    <input value=\"Save Changes\" type=\"submit\"  onclick=\"return confirmDetailsChange();\" class=\"mt-4\">\r\n";
			stringToSendToBrowser += "       	          <script>\r\n";
			stringToSendToBrowser += "       	            function confirmDetailsChange(){\r\n";
			stringToSendToBrowser += "  					  return confirm('Are you sure you want to change these details?');\r\n";  
			stringToSendToBrowser += "       	            }\r\n";
			stringToSendToBrowser += "       	          </script>\r\n";
			stringToSendToBrowser += "                  </form>\n";
			stringToSendToBrowser += "                </div>\n";
			stringToSendToBrowser += "              </div>\n";
			stringToSendToBrowser += "              <form class=\"col-md-6 text-left\" action=\"/SubmitNewProfilePicture\" method=\"POST\" enctype=\"multipart/form-data\">\r\n";
			System.out.println("HEYYYYYY: " + currentFilePathToProfilePic);
			stringToSendToBrowser += "                <img class=\"d-block rounded-circle img-fluid w-75 mx-auto\" src=\"" + currentFilePathToProfilePic + "\">\n";
			stringToSendToBrowser += "                <label for=\"pictures\">Profile Picture</label>\r\n";
			stringToSendToBrowser += "                <input type=\"file\" id=\"fileupload\" name=\"fileupload\" value=\"fileupload\" class=\"text-left form-control-file\">\r\n";
			stringToSendToBrowser += "                <input value=\"Apply new Profile Picture\" type=\"submit\" onclick=\"return confirmPictureChange();\" class=\"mt-4\">\r\n";
			stringToSendToBrowser += "       	      <script>\r\n";
			stringToSendToBrowser += "       	        function confirmPictureChange(){\r\n";
			stringToSendToBrowser += "     		          return confirm('Are you sure you want to change your profile picture?')";
			stringToSendToBrowser += "       	        }\r\n";
			stringToSendToBrowser += "       	      </script>\r\n";
			stringToSendToBrowser += "              </form>\n";
			stringToSendToBrowser += "            </div>\n";
			stringToSendToBrowser += "          </div>\n";
			stringToSendToBrowser += "        </div>\n";
			stringToSendToBrowser += "      </div>\n";
			stringToSendToBrowser += "    <div class=\"container py-4\" style=\"width: 1200px; height: 700px;>\r\n";
			stringToSendToBrowser += "      <div class=\"row\">\r\n";
			stringToSendToBrowser += "        <div class=\"card py-0 px-5 container rounded w-100 text-white bg-dark my-3 align-center\">\r\n";
			stringToSendToBrowser += "          <div class=\"card-header text-center\"><b class=\"w-100 h-100\">New profile picture added!</b></div>\r\n";
			stringToSendToBrowser += "            <div class=\"card-body\">\r\n";
			stringToSendToBrowser += "              <p>Profile picture couldn't be saved - image not valid!</p><br>\r\n";
			stringToSendToBrowser += "              <a class=\"btn btn-primary my-3\" href=\"accountview\"><b class=\"text-center\">Back</b></a>\r\n";
			stringToSendToBrowser += "            </div>\r\n";
			stringToSendToBrowser += "          </div>\r\n";
			stringToSendToBrowser += "        </div>\r\n";
			stringToSendToBrowser += "      </div>\r\n";
			stringToSendToBrowser += "    </div>\r\n";
			stringToSendToBrowser += "  </div>\n";
			stringToSendToBrowser += "  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n";
			stringToSendToBrowser += "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\" style=\"\"></script>\n";
			stringToSendToBrowser += "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n";
			stringToSendToBrowser += "  <script src=\"/js/ProfileLoadFunction.js\"></script>";
			stringToSendToBrowser += "  <script src=\"/js/reload.js\"></script>";
			stringToSendToBrowser += "  </body>\n";
			stringToSendToBrowser += "</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToBrowser);
			return true;
			
		}else if(toProcess.path.equalsIgnoreCase("SubmitNewDetails")) {
			System.out.println("Changing Details");
			System.out.println(toProcess.params.get("newName"));
			System.out.println(toProcess.params.get("newAddress"));
			System.out.println(toProcess.params.get("newPassword"));
			System.out.println(toProcess.params.get("newPasswordConfirm"));
			
			if(toProcess.params.get("newPassword").equals(toProcess.params.get("newPasswordConfirm")) && toProcess.params.get("newPasswordConfirm")!=null) {
				currentUser.name = toProcess.params.get("newName");
				currentUser.address = toProcess.params.get("newAddress");
				currentUser.password = toProcess.params.get("newPassword");
				db.commit();
				
				toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><body><script>window.location.href = \"/ChangeDetailsSuccessful.html\"</script></body></html>");
				
			}else {
				toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><body><script>window.location.href = \"/ChangeDetailsFailed.html\"</script></body></html>");
			}
			
			return true;
			

		}else if(toProcess.path.equalsIgnoreCase("SubmitNewProfilePicture")) {
			System.out.println("Changing Profile Picture");
			System.out.println(toProcess.params.get("fileupload"));
			
			if(toProcess.params.get("fileupload") !=null) {
				try {
					String uniqueString = "profilepic_"+System.currentTimeMillis();
					String newfilepath = toProcess.params.get("fileupload");
					File uploaded = new File(newfilepath);
					int ind = newfilepath.lastIndexOf('.');
					String extension = newfilepath.substring(ind);
					uploaded.renameTo(new File("httpdocs/"+uniqueString+extension));
					newfilepath = uniqueString + extension;
					currentUser.filePathToProfilePicture = newfilepath;
					db.commit();
					toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><body><script>window.location.href = \"/ChangePictureSuccess.html\"</script></body></html>");
				}catch( StringIndexOutOfBoundsException e ) {
					toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><body><script>window.location.href = \"/ChangePictureFailed.html\"</script></body></html>");
				}
			}else {
				toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><body><script>window.location.href = \"/ChangePictureFailedNoPicture.html\"</script></body></html>");
			}
			
			return true;
		}
	return false; 
	}
}
