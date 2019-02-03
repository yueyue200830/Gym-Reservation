/**
 * 
 */

$(document).ready(function() {
	getMessage();
});

function getMessage() {
	$.ajax({
		type : "POST",
		url : "NewsGetAll",
		dataType : "json",
		success : function(data) {
			var card="";
			for (i in data) {
				card+="<div class='center_tbl col-md-12'><div class='card flex-md-row mb-4 box-shadow h-md-250'><div class='card-body d-flex flex-column align-items-start'> <h3 class='mb-0'>";
				card+=data[i].newTitle+"</h3>"+"<div class='mb-1 text-muted'>"+data[i].newTime+"</div><p class='card-text mb-auto'>"+data[i].newContent+"</p>";
				card+="</div><img class='card-img-right flex-auto d-none d-md-block' data-src='holder.js/200x250?theme=thumb' alt='Thumbnail [200x250]' style='width: auto; height: 250px;' src='images/";
				card+=data[i].newPhoto+"' data-holder-rendered='true'></div></div>";
		        $("#ns").append(card);
		        card="";
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
}