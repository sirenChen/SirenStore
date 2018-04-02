/**
 * Created by sirenchen on 2017/1/23.
 */

function getXMLHttpRequest() {
    var xhttp;

    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return xhttp;
}
