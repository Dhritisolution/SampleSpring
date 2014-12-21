<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Registration</title>
<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles  -->
<link href="resources/css/annexure.css" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="resources/js/ie-emulation-modes-warning.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="resources/js/jquery-1.9.1.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>
<!-- For Validation of Form -->
<script src="resources/js/validation.js"></script>
</head>
<body>
<div class="annexure-form" > 
  <!--Form Header  -->
  <div class="annexure-form-header"><span id="errinvalid" style="display:none;">INVALID</span> REGISTRATION INFORMATION 
  <span id="imginvalid"><img src="resources/images/Register.png" class="pull-right icon"></span> </div>
  <!--// Form Header  --> 
  <!--Form -->
  <form action="saveRegisteration" class="form-horizontal company form-regisration" method="post" role="form" name="regisration"  id="regisration" >
    <div class="form-group">
      <label for="name" class="col-sm-3 control-label">Title</label>
      <div class="col-sm-5">
      <form:select cssClass="form-control" path="titlesMap" name ="titleId" items="${titlesMap}" />
      </div>
    </div>
   <div class="form-group">
      <label for="first_name" class="col-sm-3 control-label">First Name <span>*</span></label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="first_name" name="firstName" placeholder="" maxlength="25">
      </div>
    </div>
    <div class="form-group">
      <label for="last_name" class="col-sm-3 control-label">Last Name <span>*</span></label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="last_name" name="lastName" placeholder="" maxlength="25">
      </div>
    </div>
    <div class="division"></div>
    <div class="form-group">
      <label for="mobile_number" class="col-sm-3 control-label">Mobile Number <span>*</span></label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="mobile_number" name="mobileNumber" placeholder=""  maxlength="20"> 
     

      </div>
    </div>
    <div class="form-group">
      <label for="email_id"  class="col-sm-3 control-label">Email ID <span>*</span></label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="email_id" name="emailId" placeholder="" >
      </div>
    </div>
    <div class="division"></div>
    <div class="form-group">
      <div class="col-sm-3">&nbsp;</div>
      <div class="col-sm-9">
        <button type="submit" class="btn btn-default btn-sm">SUBMIT</button>
      </div>
    </div>
  </form>
  <!--//form -->
   <div class="form-bottom">
  	 <p id="formsg">All fields marked with <span>* </span> are mandatory</p>
     <p id="error1"></p>
   	 <p id="error2"></p>
   	 <p id="error3"></p>
     <p id="error4"></p>
  </div>
</div>

<div class="annexure-form hidden" id="error" >
  <div class="annexure-form-header"> REGISTRATION ERROR <img src="images/ErrorInfoIcon.png" class="pull-right icon" alt=""> </div>
  <div class="form-horizontal company form-regisration">
    <div class="col-sm-12 error">
       <div class="division"></div>
      <p>ERROR No. 404</p>
         <div class="division"></div>
     <p>
        The following error was encountered:<br>
        You're not connected to a network<br>
        &bull; Check that all network cables are plugged in.<br>
        &bull; Verify that airplane mode is turned off.<br>
        &bull; Make sure your wireless switch is turned on.<br>
        &bull; See if you can connect to mobile broadband.<br>
        &bull; Restart your router. </p>
      <br>
    </div>
    <div class="clearfix"></div>
    <div class="form-group">
      <div class="col-sm-9">
        <button type="button" class="btn btn-default btn-sm"><< BACK</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
