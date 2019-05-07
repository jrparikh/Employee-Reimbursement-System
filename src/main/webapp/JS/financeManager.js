/*
*
*/

window.onload = function(){
	getEmployeeFunc();
	updateTable();
	}

function getEmployeeFunc(){
	let xhttp = new XMLHttpRequest(); console.log("XMLHttpRequest Object made");
	
	xhttp.onreadystatechange = function(){ console.log("Accessed object ready state");
	if(xhttp.readyState == 4 && xhttp.status==200){ 
		let user = JSON.parse(xhttp.responseText);
		setValues(user);
	}
}
	
	xhttp.open("GET", 'http://localhost:8080/Expense_Reimbursement_System/HTML/FMSubmitT.do', true); console.log("xhttp object is OPEN");
	xhttp.send(); console.log("xhttp object sent request to server");
}
//
function updateTable(){
//	
let xhttp = new XMLHttpRequest(); console.log("XMLHttpRequest Object made");
	
	xhttp.onreadystatechange = function(){ console.log("Accessed object ready state");
	if(xhttp.readyState == 4 && xhttp.status==200){ 
		let RIListALL = JSON.parse(xhttp.responseText);
		PopTable(RIListALL);
	}
}
	
	xhttp.open("GET", 'http://localhost:8080/Expense_Reimbursement_System/HTML/GrabList.do', true); console.log("xhttp object is OPEN");
	xhttp.send(); console.log("xhttp object sent request to server");
}

function setValues(user){
	console.log(document.getElementById("Session-Info"));
	document.getElementById("User-Info").innerHTML = "Hello " + user.firstName + " " + user.lastName + "    ";
}

function aFunc(id){
	console.log("Approved");
	
}

function dFunc(id){
	console.log("Denied")
}

function PopTable(RIListALL){
	
	console.log("list start");
	console.log(RIListALL);
	console.log("list end");
	for(let x in RIListALL){
		//console.log(x[1]); console.log(x.amount);
		var table = document.getElementById("myTable");
		  var row = table.insertRow();
		  row.className = "table-primary";
		 //let d = new Date();
		  //let time = (d.getMonth()+1) +"/"+d.getDate()+"/"+d.getFullYear()+" "+d.getHours()%12+":"+d.getMinutes();


		  var cell1 = row.insertCell(0);
		  var cell2 = row.insertCell(1);
		  var cell3 = row.insertCell(2);
		  var cell4 = row.insertCell(3);
		  var cell5 = row.insertCell(4);
		  var cell6 = row.insertCell(5);
		  var cell7 = row.insertCell(6);
		  
//		  var cell8 = document.createElement("button");
//		  var cell8txt = document.createTextNode("Approve");
//		  cell8.appendChild(cell8txt);
//		  cell8.type = "button";
//		  cell8.className= "btn btn-info"; 
//		  cell8.id = RIListAll[x].reimburseId;
//		  cell8.onclick = aFunc(cell8.id);
//
//		  var cell9 = document.createElement("button");
//		  var cell9txt = document.createTextNode("Deny");
//		  cell9.appendChild(cell9txt); 
//		  cell9.type = "button";
//		  cell9.className= "btn btn-info"; 
//		  cell9.id = RIListAll[x].reimburseId;
//		  cell9.onclick = dFunc(cell9.id);

		  
		  cell1 = row.insertCell(0);
		  cell2 = row.insertCell(1);
		  cell3 = row.insertCell(2);
		  cell4 = row.insertCell(3);
		  cell5 = row.insertCell(4);
		  cell6 = row.insertCell(5);
		  cell7 = row.insertCell(6);
		  // cell8 = row.insertCell(7);
		  // cell9 = row.insertCell(8);
//		  row.insertCell(7).appendChild(cell8);
//		  row.insertCell(8).appendChild(cell9);
		  //var cell8 = row.insertCell(5);
		  //var cell9 = row.insertCell(6);

		  cell1.innerHTML = RIListALL[x].reimburseId;//document.getElementById("firstName").value;
		  cell2.innerHTML = RIListALL[x].ticketAuthor;//document.getElementById("lastName").value;
		  cell3.innerHTML = RIListALL[x].amount;
		  cell4.innerHTML = RIListALL[x].type;
		  cell5.innerHTML = RIListALL[x].description;
		  cell6.innerHTML = RIListALL[x].submitTime;
		  
		  if(RIListALL[x].status == 0){
			  cell7.innerHTML = "Pending";
		  }else if (RIListALL[x].status == 1){
			  cell7.innerHTML = "Approved";
		  }else{
			  cell7.innerHTML = "Denied";
		  }
		  //document.getElementById("status").value;
		/*  cell8.innerHTML = "Approve";
		  cell9.innerHTML = "Deny";*/
	}
}