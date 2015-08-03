	var counter = 0;
	var numBoxes = 4;
	function addAnswer(showHideDiv) {
		var ele = document.getElementById(showHideDiv + counter);
		if (ele.style.display == "block") {
			ele.style.display = "none";
		} else {
			ele.style.display = "block";
		}
		if (counter == numBoxes) {
			document.getElementById("addAnswerButton").style.display = "none";
		}
	}