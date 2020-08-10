function toggle_btn(x)	//on button click
{	
	var l="l"+x[1];
	var s="s"+x[1];
	var fb=ref.child("SWITCH").child("SWITCH"+x[1]);

	if(document.getElementById(x).classList.contains('active'))
	{		
		document.getElementById(s).classList.remove('active');
		document.getElementById(l).classList.remove('active');
		document.getElementById(l).innerHTML="OFF";
		fb.set("OFF");
	}
	else
	{
		document.getElementById(s).classList.add('active');
		document.getElementById(l).classList.add('active');
		document.getElementById(l).innerHTML="ON";
		fb.set("ON");
	}
}

function create_switch(s_val,s_status)
{
	var new_h3=document.createElement("h3");			//create h3
	new_h3.innerHTML=s_val+":";							

	var new_td1=document.createElement("td");			//create td
	new_td1.appendChild(new_h3);


	var new_cir=document.createElement("div");			//create div
	new_cir.className="circle";							//name the div "circle"

	var new_oval=document.createElement("div");			//create div
	new_oval.className="oval";							//name the div "oval"
	if(s_status=="ON")									//check for button's status
	{
		new_oval.classList.add("active");
	}
	new_oval.id="s"+s_val[6];							//give id to div(oval)
	new_oval.onclick = function() 						//onclick func to div(oval)
	{
		toggle_btn(this.id);						
	}
	new_oval.appendChild(new_cir);						//put div(oval) inside div(circle)

	var new_box=document.createElement("div");			//create div 
	new_box.className="box";							//name the div "box"
	new_box.appendChild(new_oval);						//put div(oval) in div(box)

	var new_td2=document.createElement("td");			//create td
	new_td2.appendChild(new_box);						//put div(box) in td


	var new_lab=document.createElement("label");		//create lable
	new_lab.className="status";							//name the label status
	if(s_status=="ON")								
	{
		new_lab.classList.add("active");				//add "active" to label's class list
	}
	new_lab.id="l"+s_val[6];
	new_lab.onclick = function() 						//onclick funciton for lable
	{
		toggle_btn(this.id);
	}
	new_lab.innerHTML=s_status							//label display s_status

	var new_td3=document.createElement("td");			//create td
	new_td3.appendChild(new_lab);


	var new_tr=document.createElement("tr");			//create tr
	new_tr.appendChild(new_td1);						
	new_tr.appendChild(new_td2);
	new_tr.appendChild(new_td3);

	document.getElementById("container").appendChild(new_tr);	//put tr in div(container)
}