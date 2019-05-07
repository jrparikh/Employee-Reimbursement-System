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
	
	xhttp.open("GET", 'http://localhost:8080/Expense_Reimbursement_System/HTML/SubmitT.do', true); console.log("xhttp object is OPEN");
	xhttp.send(); console.log("xhttp object sent request to server");
}
//
function updateTable(){
//	
let xhttp = new XMLHttpRequest(); console.log("XMLHttpRequest Object made");
	
	xhttp.onreadystatechange = function(){ console.log("Accessed object ready state");
	if(xhttp.readyState == 4 && xhttp.status==200){ 
		let RIList = JSON.parse(xhttp.responseText);
		PopTable(RIList);
	}
}
	
	xhttp.open("GET", 'http://localhost:8080/Expense_Reimbursement_System/HTML/PopulateTable.do', true); console.log("xhttp object is OPEN");
	xhttp.send(); console.log("xhttp object sent request to server");
}

function setValues(user){
	console.log(document.getElementById("Session-Info"));
	document.getElementById("User-Info").innerHTML = "Hello " + user.firstName + " " + user.lastName + "    ";
}

function PopTable(RIList){
	console.log(RIList);
	for(let x in RIList){
		//console.log(x[1]); console.log(x.amount);
		var table = document.getElementById("myTable");
		  var row = table.insertRow();
		  row.className = "table-primary";
		 //let d = new Date();
		  //let time = (d.getMonth()+1) +"/"+d.getDate()+"/"+d.getFullYear()+" "+d.getHours()%12+":"+d.getMinutes();


		/*  var cell1 = row.insertCell(0);
		  var cell2 = row.insertCell(1);*/
		  var cell3 = row.insertCell(0);
		  var cell4 = row.insertCell(1);
		  var cell5 = row.insertCell(2);
		  var cell6 = row.insertCell(3);
		  var cell7 = row.insertCell(4);
		  //var cell8 = row.insertCell(5);
		  //var cell9 = row.insertCell(6);

		 /* cell1.innerHTML = document.getElementById("firstName").value;
		  cell2.innerHTML = document.getElementById("lastName").value;*/
		  cell3.innerHTML = RIList[x].amount;
		  cell4.innerHTML = RIList[x].type;
		  cell5.innerHTML = RIList[x].description;
		  cell6.innerHTML = RIList[x].submitTime;
		  if(RIList[x].status == 0){
			  cell7.innerHTML = "Pending";
		  }else if(RIList[x].status == 1){
			  cell7.innerHTML = "Approved";
		  }else{
			  cell7.innerHTML = "Denied";
		  }
		  //document.getElementById("status").value;
		/*  cell8.innerHTML = "Approve";
		  cell9.innerHTML = "Deny";*/
	}
}