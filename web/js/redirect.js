/**
 * Created by Siren Chen on 2017/1/12.
 */

function startCount() {
    interval = window.setInterval("doCount()", 1000);
}

function doCount() {
    var countEle = document.getElementById("count");
    var countVal = countEle.innerHTML;

    countVal = countVal - 1;

    if (countVal == 0) {
        window.clearInterval(interval);
        location.href = "/SirenStore/index";
        return;
    }

    countEle.innerHTML = countVal;
}
