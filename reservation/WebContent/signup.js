/**
 * 
 */

var code; 
var oldColor;
function createCode() {    
	code = "";   
	var codeLength = 6;   
	var checkCode = document.getElementById("checkCode");   
	var selectChar = new Array (
        'abcdefghijklmnopqrstuvwxyz',
        'ABCDEFGHIJKLMNOPQRSTUVWXYZ',
        '0123456789'
	);
	for (i=0; i<codeLength; i++) {
		idx = Math.floor(Math.random()*3);
		code += selectChar[idx].substr(Math.floor(Math.random()*(selectChar[idx].length)), 1);
	}
	if (checkCode) {   
		checkCode.value = code;
		checkCode.blur();
	}        
} 

function validate () {   
	//alert("uu");
	var inputCode = document.getElementById("vcode").value;
	var name = document.getElementById("usrName").value;
	var email = document.getElementById("usrEmail").value;
	var password = document.getElementById("usrKey").value;
	var cfmKey = document.getElementById("cfmKey").value;
	//alert("nn");
	
	if (inputCode.length <=0) {   
		alert("请输入验证码！");   
	} else if (inputCode.toUpperCase() != code.toUpperCase()) {   
		alert("验证码输入错误！");   
		createCode();
	} else {   
		if (name == "") {
			alert("请输入用户名");
			createCode();
		} else if (email == "") {
			alert("请输入邮箱")
			createCode();
		} else {
			var ok = 0;
			for (i = 1; i < email.length-1; i++) {
				if (email[i] == '@') {
					ok = 1;
					break;
				}
			}
			if (ok == 0) {
				alert("请输入正确的邮箱");
				createCode();
			} else if (password == "") {
				alert("请输入密码");
				createCode();
			} else if (password != cfmKey) {
				alert("两次输入的密码不一致");
				createCode();
			} else {
			
				$.ajax({
					type: "POST",
					url: "UserRegister",
					data: $('#Signup-form').serialize(),
					dataType: "text",
					async:false, 
					success: function(message){
						if(message == "failure"){
							alert("注册失败，请更改用户名");
						}else{
							alert("注册成功！请登录");
							window.location.href="login.jsp";
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown){
						alert(XMLHttpRequest.status);
						alert(XMLHttpRequest.readyState);
						alert(textStatus);
					}
				});
			}
		}
	}   
	
}
