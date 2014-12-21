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
        <title>
          Registration
        </title>
        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles  -->
        <link href="../css/annexure.css" rel="stylesheet">
        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]>
<script src="../../assets/js/ie8-responsive-file-warning.js">
</script>
<![endif]-->
  <script src="../js/ie-emulation-modes-warning.js">
  </script>
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js">
</script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js">
</script>
<![endif]-->
  <script src="../js/jquery-1.9.1.min.js">
  </script>
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="../js/ie10-viewport-bug-workaround.js">
  </script>
  <!-- For Validation of Form -->
  <script src="../js/validation.js">
  </script>
  </head>
  <body>
    <div class="annexure-form" >
      
      <!--Form Header  -->
      <div class="annexure-form-header">
        REGISTRATION INFORMATION 
        <img src="images/Register.png" class="pull-right icon" alt="">
        
      </div>
      <!--// Form Header  -->
      
      <!--Form -->
      <form:form method="Post" action="registrationform.html" id="regisration"
      commandName="registration" class="form-horizontal company form-regisration">
        <div class="form-group">
          <label for="name" class="col-sm-3 control-label">
            Title
          </label>
          <div class="col-sm-5">
            <select class="form-control">
              <option>
                Mr.
              </option>
              <option>
                Ms.
              </option>
              <option>
                Dr.
              </option>
              <option>
                Prof.
              </option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label for="first_name" class="col-sm-3 control-label">
            First Name 
            <span>
              *
            </span>
          </label>
          <div class="col-sm-9">
            <FONT color="red">
              <form:errors	path="userFName" />
            </FONT>
            <form:input path="userFName"/>
          </div>
        </div>
        <div class="form-group">
          <label for="last_name" class="col-sm-3 control-label">
            Last Name 
            <span>
              *
            </span>
          </label>
          <div class="col-sm-9">
            <FONT color="red">
              <form:errors	path="userLName" />
            </FONT>
            <form:input path="userLName"/>
          </div>
        </div>
        <div class="form-group">
          <label for="mobile_number" class="col-sm-3 control-label">
            Mobile Number 
            <span>
              *
            </span>
          </label>
          <div class="col-sm-9">
            <FONT color="red">
              <form:errors	path="mobileNo" />
            </FONT>
            <form:input path="mobileNo"/>
          </div>
        </div>
        <div class="form-group">
          <label for="email_id"  class="col-sm-3 control-label">
            Email ID 
            <span>
              *
            </span>
          </label>
          <div class="col-sm-9">
            <FONT color="red">
              <form:errors	path="email" />
            </FONT>
            <form:input path="email"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-3">
            &nbsp;
          </div>
          <div class="col-sm-9">
            <input type="submit" value="Submit" class="btn btn-default btn-sm"/>
          </div>
        </div>
      </form:form>
      <!--//form -->
      <div class="form-bottom" id="error_message">
        <p>
          All fields marked with 
          <span>
            * 
          </span>
          are mandatory
        </p>
      </div>
    </div>
    <!--//container -->
	
  </body>
  </html>