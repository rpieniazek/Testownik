/**
 * Do używania w quizQuestion.html
 */

function addAnswer(){
	var container = document.getElementById("answers");
	for(i=0;i<4;i++){
		var answerDiv = document.createElement("div");
		var answerInput = document.createElement("input");
		answerInput.type = "text";
		answerInput.placeholder = "Wpisz tu odpowiedź";
		var answerCheck = document.createElement("input");
		answerCheck.type = "checkbox";
		answerCheck.placeholder = "Wpisz tu odpowiedź";
		answerDiv.appendChild(answerInput);
		answerDiv.appendChild(answerCheck);
		container.appendChild(answerDiv);
	}
}

function getInputs(){
	var container = document.getElementById("answers");
	var inputs = container.getElementsByTagName("input");
	var separator = "[^$&]";
	var result = "";
 	for(i = 0; i<inputs.length; i+=2){
 		result += inputs[i].value + separator + inputs[i+1].checked + separator;
 	}
 	document.getElementsByName("answer_data")[0].value = result;
}
