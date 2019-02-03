/**
 * 
 */

$(document).ready(function() {
	getMessage();
});

function getMessage() {
	$.ajax({
		type : "POST",
		url : "MessageGetAll",
		dataType : "json",
		success : function(data) {
			var item;
			for (i in data) {
				item="<tr><td>"+data[i].msgAuthor+"</td><td>"+data[i].msgContent+"</td>";
				
				if (data[i].msgIsVisible == 0){
					item += "<td><a href='MessagePublish?msgID="+data[i].msgID+"'>通过</a></td></tr>";
				} else {
					item += "<td><a>已通过</a></td></tr>";
				}
				$("#message-table").append(item);
				//$("#message-table").append();
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
}
