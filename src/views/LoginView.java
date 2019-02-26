package views;

import model.accountdata;
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
	if(toProcess.path.equalsIgnoreCase("loginview"))
	{
		accountdata mainuser = new accountdata();
		mainuser.username = "master";
		mainuser.password = "1234";
	
	String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"\r\n" + 
			"<head>\r\n" + 
			"  <meta charset=\"utf-8\">\r\n" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n" + 
			"  <link rel=\"stylesheet\" href=\"logincss.css\">\r\n" + 
			"</head>\r\n" + 
			"\r\n" + 
			"<body >\r\n" + 
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
			"  <div class=\"align-items-center h-100 text-center py-0 pt-0 pb-5 d-flex\" style=\"background-image: linear-gradient(rgba(255, 255, 255, 0.71), rgb(160, 160, 160)); background-size: 100%;\">\r\n" + 
			"    <div class=\"container\">\r\n" + 
			"      <div class=\"row px-5 text-center mx-auto\" style=\"\">\r\n" + 
			"        <div class=\"col-md-12\">\r\n" + 
			"          <div class=\"card-body text-center bg-primary shadow-sm w-100 px-4 mt-5\">\r\n" + 
			"            <h1 class=\"mb-4 text-center display-2\"><b>Log In</b></h1>\r\n" + 
			"            <form class=\"px-5 text-center w-100\">\r\n" + 
			"              <div class=\"form-group\"> <input type=\"email\" class=\"form-control\" placeholder=\"Enter email\" id=\"form9\"> </div>\r\n" + 
			"              <div class=\"form-group mb-2\"> <input type=\"password\" class=\"form-control\" placeholder=\"Password\" id=\"form10\"> <small class=\"form-text text-muted text-right w-100\">\r\n" + 
			"                  <small class=\"mb-1 w-100\" href=\"#\"> Recover password </small> </small></div><small class=\"form-text text-muted text-right\"> <button type=\"submit\" class=\"btn btn-light\">Submit</button>\r\n" + 
			"              </small>\r\n" + 
			"            </form>\r\n" + 
			"            <h3 class=\"\"><strike>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </strike>&nbsp;or&nbsp;<strike>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</strike></h3>\r\n" + 
			"            <div class=\"row text-center d-inline-flex\">\r\n" + 
			"              <div class=\"col-md-12\"><a class=\"btn text-white rounded\" href=\"#\" style=\"background:#dd4b39\" target=\"_blank\"><i class=\"fa fa-google-plus fa-2x fa-fw fa-1x py-1 pb-0\"></i></a></div>\r\n" + 
			"            </div>\r\n" + 
			"            <h3 class=\"pt-3\">Log In with Google</h3>\r\n" + 
			"          </div>\r\n" + 
			"        </div><small class=\"form-text text-muted text-right\">\r\n" + 
			"        </small>\r\n" + 
			"      </div><small class=\"form-text text-muted text-right\">\r\n" + 
			"      </small>\r\n" + 
			"    </div><small class=\"form-text text-muted text-right\">\r\n" + 
			"    </small>\r\n" + 
			"  </div><small class=\"form-text text-muted text-right\">\r\n" + 
			"    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
			"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\r\n" + 
			"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\r\n" + 
			"    <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\r\n" + 
			"  </small>\r\n" + 
			"</body>\r\n" + 
			"\r\n" + 
			"</html>\r\n" + 
			"\r\n" + 
			""; 
			
	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
	
	return true;
	}
	return false;
	}
}
