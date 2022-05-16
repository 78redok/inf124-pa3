// popcornA.js
//  Ajax JavaScript code for the popcornA.html document

/********************************************************/
// function getPlace
//  parameter: zip code
//  action: create the XMLHttpRequest object, register the
//          handler for onreadystatechange, prepare to send
//          the request (with open), and send the request,
//          along with the zip code, to the server
//  includes: the anonymous handler for onreadystatechange, 
//            which is the receiver function, which gets the 
//            response text, splits it into city and state,
//            and puts them in the document

   
function getPlace (zip)
{
  if (window.XMLHttpRequest)
  {  // IE7+, Firefox, Chrome, Opera, Safari
     var xhr = new XMLHttpRequest();
  }
  else
  {  // IE5, IE6
     var xhr = new ActiveXObject ("Microsoft.XMLHTTP");
  }

  // Register the embedded handler function
  // This function will be called when the server returns
  // (the "callback" function)
  xhr.onreadystatechange = function ()
  { // 4 means finished, and 200 means okay.
    if (xhr.readyState == 4 && xhr.status == 200)
    { // Data should look like "Fairfax, Virginia"
      var result = xhr.responseText;
      var place = result.split (', ');
      //if (document.getElementById ("city").value == "")
        document.getElementById ("shipper_city").value = place[0];
      //if (document.getElementById ("state").value == "")
        document.getElementById ("shipper_state").value = place[1];
    } 
  } 
  // Call the response software component
  //xhr.open ("GET", "getCityState?zip=" + zip, true);
  //xhr.send ();
  xhr.open ("POST", "getCityState", true);
  xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
  xhr.send ("zipcode="+zip);  
}
