<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles  -->
        <link href="resources/css/annexure.css" rel="stylesheet">
        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]>
<script src="../../assets/js/ie8-responsive-file-warning.js">
</script>
<![endif]-->
  <script src="resources/js/ie-emulation-modes-warning.js">
  </script>
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js">
</script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js">
</script>
<![endif]-->
  
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="resources/js/ie10-viewport-bug-workaround.js">
  </script>
  </head>
  
  <body>
    <div class="annexure-form" >
      <div class="annexure-form-header">
        REGISTRATION SUCCESSFUL 
        <img src="resources/images/RegisterRight.png" class="pull-right icon" alt="">
        
      </div>
      <div class="form-horizontal company form-regisration">
        <div class="col-sm-12 success">
          <div class="division">
          </div>
          <p>
            Thank you for signing up. Your Login and Password has been mailed to your email ID
            ${register.emailId} 
          </p>
          <br>
        </div>
        <table class="table">
          <tbody>
            <tr>
              <td>
                Title
              </td>
              <td>
                : ${register.title}
              </td>
            </tr>
            <tr>
              <td>
                First Name
              </td>
              <%-- 
              <td>
                <core:out value="${registration.firstName}" />
              </td>
              --%>
              <td>
                :  ${register.firstName}
              </td>
            </tr>
            <tr>
              <td>
                Last Name
              </td>
              <%-- 
              <td>
                <core:out value="${registration.lastName}" />
              </td>
              --%>
              <td>
                :  ${register.lastName}
              </td>
            </tr>
            <tr>
              <td colspan="2" class="division">
              </td>
            </tr>
            <tr>
              <td>
                Mobile Number
              </td>
              <%-- 
              <td>
                <core:out value="${registration.mobileNumber}" />
              </td>
              --%>
              <td>
                : ${register.mobileNumber}
              </td>
            </tr>
            <tr>
              <td>
                Email ID
              </td>
              <%-- 
              <td>
                <core:out value="${registration.emailId}" />
              </td>
              --%>
              <td>
                :  ${register.emailId}
              </td>
            </tr>
            <tr>
              <td colspan="2" class="division-2">
              </td>
            </tr>
            <tr>
              <td class="td-1">
              </td>
              <td>
                <form action="backToRegistration">
                  <button type="submit" class="btn btn-default btn-sm">
                    
                    <
                    < BACK 
                  </button>
                    </form>
                  </td>
                </tbody>
              </table>
            
          </div>
      </div>
    </body>
    
  </html>
  