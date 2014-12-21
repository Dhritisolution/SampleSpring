jQuery(function($) {
	$("#error").hide();
    $('#regisration').submit(
	    function(e) {
	    	e.preventDefault();	
	        var title = $("#title").val();
	        var firstName = $("#first_name").val();
	        var lastName = $("#last_name").val();
	        var mobileNo = $("#mobile_number").val();
	        var emailId = $("#email_id").val();
	        /* trim all fields*/
	        firstName = firstName.trim();
	        lastName = lastName.trim();
	        mobileNo = mobileNo.trim();
	        emailId = emailId.trim();
	        /* regular expression*/
	        var reg = /^[a-zA-Z\ \']+$/;
	        var emailreg = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	        var regex_malasia = /\+60[-]\d{2,4}[-]?\d{6,9}\b/;
	
	        var formname = document.regisration;
	        valid = true;
	        /* CHECK FIELD VALIDATION ONE BY ONE */
	        if (firstName == null || firstName == "") {
	            $("#error1").html('First Name which is blank');
	            valid = false;
	
	        } else if (reg.test(firstName) == false) {
	            $("#error1").html('First Name which is invalid');
	            valid = false;
	        } else {
	
	            $("#error1").html('');
	        }
	
	        if (lastName == null || lastName == "") {
	            $("#error2").html('Last Name which is blank');
	            valid = false;
	
	        } else if (reg.test(lastName) == false) {
	            $("#error2").html('Last Name which is invalid');
	            valid = false;
	        } else {
	            $("#error2").html('');
	        }
	
	        if (mobileNo == null || mobileNo == "") {
	            $("#error3").html('Mobile Number which is blank');
	            valid = false;
	
	        } else if (regex_malasia.test(mobileNo) == false) {
	            $("#error3").html('Mobile Number which is invalid');
	            valid = false;
	        } else {
	            $("#error3").html('');
	        }
	
	        if (emailId == null || emailId == "") {
	            $("#error4").html('Email ID which is blank');
	            valid = false;
	
	        } else if (emailreg.test(emailId) == false) {
	            $("#error4").html('Email ID which is invalid');
	            valid = false;
	        } else {
	            $("#error4").html('');
	        }
	
	        /* CHECK  VALID OR INVALID LABLE OR IMAGE */
	        if (valid == false) {
	            $("#formsg").html('Please provide accurate information for:');
	            $("#imginvalid").html('<img src="resources/images/RegisterWrong.png" class="pull-right icon" alt="">');
	            $("#errinvalid").removeClass("hidden");
	            $("#errinvalid").show();
	        }
	
	        /* CHECK ERROR AND SET FOCUS */
	        var error1 = $("#error1").html();
	        if (error1 != '') {
	            formname.first_name.focus();
	            return false;
	        }
	        var error2 = $("#error2").html();
	        if (error2 != '') {
	            formname.last_name.focus();
	            return false;
	        }
	        var error3 = $("#error3").html();
	        if (error3 != '') {
	            formname.mobile_number.focus();
	            return false;
	        }
	        var error4 = $("#error4").html();
	        if (error4 != '') {
	            formname.email_id.focus();
	            return false;
	        }
	
	        /* CHECKING ERROER LIST IS NULL AND RETURN TRUE */
	        if (error1 == '' && error2 == '' && error3 == '' && error4 == '') {
			
	        } else {
	            return false;
	        }
	        
	        $("#regisration").hide()
	        $(".annexure-form").hide();
	        
	        $.ajax({
	        	url : "saveRegisteration",
				type : "POST",
				data: $('#regisration').serialize(),
				success : function(data) {
					
					$("#newDataDiv").show();
					$("#newDataDiv").html(data);
					$("#error").hide();
					
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$("#newDataDiv").hide();
					$("#error").show();
					
				}
			});
	
	
	    })
});