alert("I'm active");

var request = new XMLHttpRequest();

request.open('GET', 'http://localhost:8080/restaurant', true);
request.onload = function () {

 var data = JSON.parse(this.response);

  if (request.status >= 200 && request.status < 400) {
    data.forEach(rest => {
// console.log(user);// Alternatively manipulate DOM with record
    });
// $("#spec").html(data);
    var body = document.body,
    tbl  = document.createElement('table');
	tbl.style.width  = '100px';
	tbl.style.border = '1px solid black';
	
	for(var i = 0; i < data.length; i++){
		var rest = data[i];
		var rfm = rest.foodmenu;
		
		var tr = tbl.insertRow();
		
		var td = tr.insertCell();
		td.appendChild(document.createTextNode(rest.name+" "));
		td.style.border = '1px solid black';
		
		var td2 = tr.insertCell();
		td2.appendChild(document.createTextNode(rest.place+" "));
		td2.style.border = '1px solid black';
		
		var td3 = tr.insertCell();
		td3.appendChild(document.createTextNode(rfm[i].name+" "));
		td3.style.border = '1px solid black';
		
		var td4 = tr.insertCell();
		td4.appendChild(document.createTextNode(rfm[i].price+" "));
		td4.style.border = '1px solid black';
		
//		for(var j = 0; j < rfm.length; j++){
//			var fm = rfm[j];
//			var tr = tbl.insertRow();
//			var td = tr.insertCell();
//			td.appendChild(document.createTextNode(rest.name+" "));
//			td.style.border = '1px solid black';
//			td.appendChild(document.createTextNode(rest.place+" "));
//			td.style.border = '1px solid black';
//			td.appendChild(document.createTextNode(fm.name+" "));
//			td.style.border = '1px solid black';
//			td.appendChild(document.createTextNode(fm.price+" "));
//			td.style.border = '1px solid black';
//		}
	}
	
//	for(var i = 0; i < 3; i++){
//	    var tr = tbl.insertRow();
//	    for(var j = 0; j < 2; j++){
//	        if(i == 2 && j == 1){
//	            break;
//	        } else {
//	            var td = tr.insertCell();
//	            td.appendChild(document.createTextNode('Cell'));
//	            td.style.border = '1px solid black';
//	            if(i == 1 && j == 1){
//	                td.setAttribute('rowSpan', '2');
//	            }
//	        }
//	    }
//	}
	body.appendChild(tbl);
    tableCreate();
  } else {
    console.log('error occurred. Please try again');
  }
}

request.send();
