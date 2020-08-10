window.onload = function()
{
	var ch_switch=ref.child("SWITCH");
	ch_switch.once("value").then(function(snapshot) 
	{
    	snapshot.forEach(function(childSnapshot) 
    	{
    		//TODO div for no switch
    		create_switch(childSnapshot.key,childSnapshot.val());	//creates the switch
  		});
	});
}