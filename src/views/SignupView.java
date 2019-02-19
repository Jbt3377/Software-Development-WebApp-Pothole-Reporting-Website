package views;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class SignupView extends DynamicWebPage{

	public SignupView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
		// TODO Auto-generated constructor stub
	}
	public boolean process(WebRequest toProcess)
	{
	if(toProcess.path.equalsIgnoreCase("signupview"))
	{
	String stringToSendToWebBrowser = "\r\n" + 
			"<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"\r\n" + 
			"<head>\r\n" + 
			"  <meta charset=\"utf-8\">\r\n" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n" + 
			"  <link rel=\"stylesheet\" href=\"/now-ui-kit.css\">\r\n" + 
			"</head>\r\n" + 
			"\r\n" + 
			"<body>\r\n" + 
			"  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n" + 
			"    <div class=\"container\"> <a class=\"navbar-brand\" href=\"#\">\r\n" + 
			"        <i class=\"fa d-inline fa-lg fa-stop-circle\"></i>\r\n" + 
			"        <b></b>\r\n" + 
			"      </a> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar10\">\r\n" + 
			"        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
			"      </button>\r\n" + 
			"      <div class=\"collapse navbar-collapse\" id=\"navbar10\">\r\n" + 
			"        <ul class=\"navbar-nav ml-auto\">\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">About</a> </li>\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">FAQ</a> </li>\r\n" + 
			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Report a Problem</a> </li>\r\n" + 
			"        </ul> <a class=\"btn navbar-btn ml-md-2 btn-primary text-light\">Contact us</a>\r\n" + 
			"      </div>\r\n" + 
			"    </div>\r\n" + 
			"  </nav>\r\n" + 
			"  <div class=\"text-center align-items-center d-flex py-5\" style=\"background-image: linear-gradient(rgba(255, 255, 255, 0.71), rgb(160, 160, 160)); background-size: 100%;\">\r\n" + 
			"    <div class=\"container py-0 px-5 w-50\">\r\n" + 
			"      <div class=\"card bg-primary\">\r\n" + 
			"        <div class=\"card-body text-center w-100 px-2\">\r\n" + 
			"          <h5 class=\"display-2 mb-0\" contenteditable=\"true\"><b>Sign Up</b></h5>\r\n" + 
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
			"                      <input type=\"text\" class=\"form-control\" id=\"inlineFormInputGroup\" placeholder=\"First Name...\">\r\n" + 
			"                    </div>\r\n" + 
			"                  </div>\r\n" + 
			"                  <div class=\"form-group mb-2\">\r\n" + 
			"                    <div class=\"input-group border-0\">\r\n" + 
			"                      <div class=\"input-group-prepend \">\r\n" + 
			"                        <span class=\"input-group-text\" id=\"basic-addon1\">\r\n" + 
			"                          <i class=\"now-ui-icons text_caps-small lg\"></i>\r\n" + 
			"                        </span>\r\n" + 
			"                      </div>\r\n" + 
			"                      <input type=\"text\" class=\"form-control\" id=\"inlineFormInputGroup\" placeholder=\"Last Name...\">\r\n" + 
			"                    </div>\r\n" + 
			"                  </div>\r\n" + 
			"                  <div class=\"form-group mb-3\">\r\n" + 
			"                    <div class=\"input-group border-0\">\r\n" + 
			"                      <div class=\"input-group-prepend \">\r\n" + 
			"                        <span class=\"input-group-text\" id=\"basic-addon1\">\r\n" + 
			"                          <i class=\"now-ui-icons ui-1_email-85 lg\"></i>\r\n" + 
			"                        </span>\r\n" + 
			"                      </div>\r\n" + 
			"                      <input type=\"text\" class=\"form-control\" id=\"inlineFormInputGroup\" placeholder=\"Email...\">\r\n" + 
			"                    </div>\r\n" + 
			"                  </div>\r\n" + 
			"                  <button type=\"submit\" class=\"btn btn-lg btn-dark mx-1 rounded\">Sign Up</button>\r\n" + 
			"                </form>\r\n" + 
			"              </div>\r\n" + 
			"            </div>\r\n" + 
			"          </div>\r\n" + 
			"          <h2 class=\"lead mb-3\" contenteditable=\"true\">Already have an account with us?&nbsp;<br>Click the Log In button below to get started.</h2> <a href=\"#\" class=\"btn btn-lg btn-light btn-lg text-primary mx-1 rounded\">Log In</a>\r\n" + 
			"        </div>\r\n" + 
			"      </div>\r\n" + 
			"    </div>\r\n" + 
			"  </div>\r\n" + 
			"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
			"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
			"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\r\n" + 
			"  <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\r\n" + 
			"</body>\r\n" + 
			"\r\n" + 
			"</html>";
	toProcess.r = new WebResponse( WebResponse.HTTP_OK,WebResponse.MIME_HTML, stringToSendToWebBrowser );
	
	return true;
	}
	return false;
	}
}
