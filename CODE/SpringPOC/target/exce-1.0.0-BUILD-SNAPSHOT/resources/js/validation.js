jQuery(function($) {
	$('#regisration').submit(function(){

		var title = $("#title").val();
		var firstName = $("#first_name").val();
		var lastName = $("#last_name").val();
		var mobileNo = $("#mobile_number").val();
		var emailId = $("#email_id").val();
	
		firstName = firstName.trim();
		lastName = lastName.trim();
		mobileNo = mobileNo.trim();
		emailId = emailId.trim();
		
		var reg = /^[a-zA-Z\ \']+$/;
		var emailreg =/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
		var regex_malasia= /^((\+60(\s|-)?)|0)(((?!0)(?!2)(?!80)(?!81)\d{1,2})[1]?)(-)?\d{3,4}(-)?\d{3,5}$/;

		if(firstName == '')
		{	
			document.regisration.first_name.focus();
			$("#formsg").html('Please provide accurate information for:');
			$("#error_message").html('<p id=fname>First Name which is blank</p>');
			$("#imginvalid").html('<img src="resources/images/RegisterWrong.png" class="pull-right icon">');
			$("#errinvalid").show();
			
			return false;

		}else if(reg.test(firstName) == false)
		{
			document.regisration.first_name.focus();
			$("#formsg").html('Please provide accurate information for:');
			$("#error_message").html('<p id=fname>First Name which is invalid </p>');
			$("#imginvalid").html('<img src="resources/images/RegisterWrong.png" class="pull-right icon">');
			$("#errinvalid").show();
			return false;
		}else
		{
			$("#fname").remove();	
		}

		if(lastName  == '')
		{	
			document.regisration.last_name.focus();
			$("#formsg").html('Please provide accurate information for:');
			$("#error_message").html('<p id=lname>Last Name which is blank</p>');
			$("#imginvalid").html('<img src="resources/images/RegisterWrong.png" class="pull-right icon">');
			$("#errinvalid").show();
			return false;	 
		}else if(reg.test(lastName) == false)
		{

			document.regisration.last_name.focus();
			$("#formsg").html('Please provide accurate information for:');
			$("#error_message").html('<p id=lname>Last Name which is invalid</p>');
			$("#imginvalid").html('<img src="resources/images/RegisterWrong.png" class="pull-right icon">');
			$("#errinvalid").show();
			return false;
		}else
		{
			$("#lname").remove();	
		}

		if(mobileNo == '')
		{
			
			document.regisration.mobile_number.focus();
			$("#formsg").html('Please provide accurate information for:');
			$("#error_message").html('<p id=mnumber>Mobile Number which is blank</p>');
			$("#imginvalid").html('<img src="resources/images/RegisterWrong.png" class="pull-right icon">');
			$("#errinvalid").show();
			return false;

		}else if(regex_malasia.test(mobileNo) == false)
		{	
			document.regisration.mobile_number.focus();
			$("#formsg").html('Please provide accurate information for:');
			$("#error_message").html('<p id=mnumber>Mobile Number which is invalid</p>');
			$("#imginvalid").html('<img src="resources/images/RegisterWrong.png" class="pull-right icon">');
			$("#errinvalid").show();
			return false;	 
		}else
		{
			$("#mnumber").remove();	
		}


		if(emailId  == '')
		{	
			document.regisration.email_id.focus();
			$("#formsg").html('Please provide accurate information for:');
			$("#error_message").html('<p id=email>Email  which is invalid</p>');
			$("#imginvalid").html('<img src="images/RegisterWrong.png" class="pull-right icon">');
			$("#errinvalid").show();
			return false;	 
		}else if(emailreg.test(emailId) == false)
		{
			document.regisration.email_id.focus();
			$("#formsg").html('Please provide accurate information for:');
			$("#error_message").html('<p id=email>Email  which is invalid</p>');
			$("#imginvalid").html('<img src="resources/images/RegisterWrong.png" class="pull-right icon">');
			$("#errinvalid").show();
			return false;
		}else
		{
			$("#email").remove();	
		}
		$("#errinvalid").hide();
		
		$.ajax({
			error : function(jqXHR, textStatus, errorThrown) {
				$("#regisration").hide();
				$("#error").show();
			}
		});

	})
});