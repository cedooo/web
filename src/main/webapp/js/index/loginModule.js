$(function() {
	$("#loginForm input").keydown(function(e) {
		if (e.keyCode == '13') {
			logon();
		}
	});
});
function showLogon(d) {
	if (!(userInfo.logon == "true")) {
		reset();
		$(".logonContainer").animate({
			left : logonPaddingLeftPercent + "%"
		});
	} else {
		alert('已经登陆，不能重复登陆。');
	}
}
function hideLogon() {
	$("#loginForm input").val('');
	$(".logonContainer").animate({
		left : "100%"
	});
}
/* 
  登入 登出 函数
*/
function logon() {
	var user = $("#user").val();
	var paswd = $("#password").val();
	$.ajax({
		url : basePath + "login.action",
		type : "POST",
		context : document.body,
		data : {
			"userName" : user,
			"passwd" : paswd
		},
		dataType : "json",
		error : function() {
			alert('无法登陆');
		},
		success : function(response) {
			if (response != 'null' && response.doResult.state == '1') {
				// window.history.go(0);
				/*
				 * $("#manageWindow").show(); $("#manageWindow
				 * .manaTag").addClass("dis");; showManage();
				 */
				var con = confirm(response.doResult.info);
				if (con) {
					window.location.reload();
				}
			} else {
				$(".logonContainer").animate({
					left : (logonPaddingLeftPercent + 1) + "%"
				}, 50).animate({
					left : (logonPaddingLeftPercent) + "%"
				}, 50).animate({
					left : (logonPaddingLeftPercent - 1) + "%"
				}, 50).animate({
					left : (logonPaddingLeftPercent) + "%"
				}, 50);
				hideOper();
				return false;
			}
		}
	});
}
// 登出
function logout() {
	$.ajax({
		url : basePath + "logout.action",
		type : "POST",
		context : document.body,
		data : {},
		dataType : "json",
		error : function() {
			alert('注销出错');
		},
		success : function(response) {
			if (response != 'null' && response.doResult.state == '1') {
				alert("注销成功");
				window.location.reload();
			} else {
				alert("注销失败");
			}
		}
	});
}