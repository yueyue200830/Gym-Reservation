/**
 * 
 */

$(document).ready(function() {
	addDate();
	getTable();
});
function addDate() {
	var d = new Date();
	for (var i = 0; i < 4; i++) {
		var changeID = "day" + (i + 1);
		d = d.setDate(d.getDate() + 1);
		d = new Date(d);
		var changeday = d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate();
		// document.getElementById(changeID).innerHTML = changeday;
		$("#days").append(
				"<a type='button' class='btn btn-secondary' id='" + changeID
						+ "'>" + changeday + "</a>");
	}
}
function getTable() {
	var t = new Date();
	var today = t.getFullYear() + "-" + (t.getMonth()+1) + "-" + t.getDate();
	var year = t.getFullYear();
	var month = t.getMonth()+1;
	var day = t.getDate();
	
	var tt = new Date();
	//var rvnid = <%= request.getParameter("rnvid") %>;
	$.ajax({
		type : "POST",
		url : "OrderAvailable",
		data : {
			rvnID : rvnid,
			rvnDate : today
		},
		dataType : "json",
		success : function(data) {
			for (var j = 0; j < 8; j++) {
				var item = "<td>" + (j + 12) + ":00 - " + (j + 13) + ":00</td>";
				for (var i = 0; i < 4; i++) {
					if (data[i][j] != 0) {
						item += "<td><a href='orderadd.jsp?rvnRoom="+(i+1)+"&rvnTime="+(j+1)+"&rvnId="+rvnid+"&rvnPrice="+data[i][j]+"&year="+ year+"&month="+month+"&day="+day+"'>可预约</a></td>";
					} else {
						item += "<td><a>已预约</a></td>";
					}
				}
				$("#reservation-table").append("<tr>" + item + "<tr>");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
}