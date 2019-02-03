/**
 * 
 */

$(document).ready(function() {
	getTable();
});

function getTable() {
	$.ajax({
		type : "POST",
		url : "OrderUserGetAll",
		dataType : "json",
		success : function(data) {
			var item;
			for (i in data) {
				if (i%9 == 0 || i%9 ==1) continue;
				item += "<td>"+data[i]+"</td>";
				if (i%9 == 8) {
					$("#order-table").append("<tr>" + item + "<tr>");
					item = "";
				}
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
}