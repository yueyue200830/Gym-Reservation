/**
 * 
 */

$(document).ready(function() {
	getTable();
});

function getTable() {
	$.ajax({
		type : "POST",
		url : "OrderGetAll",
		dataType : "json",
		success : function(data) {
			var item;
			for (i in data) {
				if (i%9 == 0 || i%9 ==1) continue;
				item += "<td>"+data[i]+"</td>";
				if (i%9 == 8) {
					item += "<td><a href='OrderDelete?ordID="+data[i-8]+"'>删除</a></td>";
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