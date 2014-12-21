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

		var all_err = Array();
		$("#error_message").html('<p id=fname>First Name which is Invalid</p><p id=lname>Last Name which is Invalid</p><p id=mnumber>Mobile Name which is Invalid</p><p id=email>Email Name which is Invalid</p>');
		//$("#error_message").html('<p id=fname>First Name which is Invalid</p>');

	
		var reg = /^[a-zA-Z\ \']+$/;
		var emailreg =/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
		var regex_malasia= /^((\+60(\s|-)?)|0)(((?!0)(?!2)(?!80)(?!81)\d{1,2})[1]?)(\s|-)?\d{3,4}(\s|-)?\d{3,5}$/;

		// if(typeof title == "undefined") 
		// {
		// 	titleval = '';
		// }else
		// {
		// 	titleval = title;
		// }

		// if(titleval  == '')
		// {	
		// 	 document.regisration.title.focus();
		// 	// $("#error_message").html('<p id=titlerr>Please select title </p>');
		// 	 all_err.push('1');
		// 	 return false;	 
		// }else
		// {
		// 	$("#titlerr").remove();	
		// }

		if(firstName == '')
		{	
			document.regisration.first_name.focus();
			//$("#error_message").html('<p id=fname>First Name which is Invalid</p>');
			all_err.push('2');
			return false;

		}else if(reg.test(firstName) == false)
		{
			$("#error_message").html('<p id=fname>First Name which is Invalid</p>');
			all_err.push('3');
			return false;
		}else
		{
			$("#fname").remove();	
		}

		if(lastName  == '')
		{	
			document.regisration.last_name.focus();
			$("#error_message").html('<p id=lname>Last Name which is Invalid</p>');
			all_err.push('4');
			return false;	 
		}else if(reg.test(lastName) == false)
		{
			$("#error_message").html('<p id=lname>Last Name which is Invalid</p>');
			return false;
		}else
		{
			$("#lname").remove();	
		}

		if(regex_malasia.test(mobileNo) == false)
		{	
			document.regisration.mobile_number.focus();
			$("#error_message").html('<p id=mnumber>Mobile Name which is Invalid</p>');
			all_err.push('5');
			return false;	 
		}else
		{
			$("#mnumber").remove();	
		}


		if(emailId  == '')
		{	
			document.regisration.email_id.focus();
			$("#error_message").html('<p id=email>Email Name which is Invalid</p>');
			all_err.push('6');
			return false;	 
		}else if(emailreg.test(emailId) == false)
		{
			$("#error_message").html('<p id=email>Email Name which is Invalid</p>');
			all_err.push('7');
			return false;
		}else
		{
			$("#email").remove();	
		}



		
	
	})
});

/*$('#first_name').val();
$('#last_name').val();
$('#mobile_number').val();
$('#email_id').val();*/
