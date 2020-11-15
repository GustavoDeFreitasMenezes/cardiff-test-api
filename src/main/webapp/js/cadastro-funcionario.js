document.getElementById("inicial").onclick = function () {	    	
    location.href = url + "/index.html";
};

window.onload = function() {
	let resp;
    let request = new XMLHttpRequest();
    request.open('GET', url + "/cargo", true);
    request.onload = function() {
        if (request.readyState == 4 && (request.status >= 200 && request.status < 400)) {
            // Success!
            resp = request.responseText;	                
            
            var retorno = request.responseText;
            var obj = JSON.parse(retorno);
            var size = obj.length;
			
            var comboDepto = document.getElementById("comboCargo");
            var opt0 = document.createElement("option");
            opt0.value = "0";
            opt0.text = "";
            comboDepto.add(opt0, 0);
            
			for(var i= 0; i< size; i++){
				var opt = document.createElement("option");
                opt.value = obj[i].cargoId;
                opt.text = obj[i].cargoName;
                comboDepto.add(opt, i+1);        					
			}
            	                
        } else {
        	console.log("erro");
        }
    };
    
    request.onerror = function() {            
        console.log("Erro:"+request);
    };

    request.send();
};

function salvar(){
	var http = new XMLHttpRequest();  			
	http.open('POST', url + "/funcionario", true);

	//Send the proper header information along with the request
	http.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	
	var data = {
	    funcionarioName : document.getElementById("funcionarioName").value,
	    funcionarioAge : document.getElementById("funcionarioAge").value,
	    funcionarioBirthday : document.getElementById("funcionarioBirthday").value,
	    funcionarioDocument : document.getElementById("funcionarioDocument").value,
	    cargoId : {
	        cargoId : document.getElementById("comboCargo").value
	    }
	};   				  				

	http.onreadystatechange = function() {//Call a function when the state changes.
	    if(http.readyState == 4 && (http.status >= 200 && http.status < 400)) {
	        alert("Registro salvo com sucesso");
	    } else {
	    	console.log(http.responseText);
	    }
	}
	http.send(JSON.stringify(data));

};  	