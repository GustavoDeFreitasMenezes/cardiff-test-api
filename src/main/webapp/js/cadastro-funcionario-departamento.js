document.getElementById("inicial").onclick = function () {	    	
    location.href = url + "/index.html";
};

window.onload = function() {	    	
	populaFuncionario();
	populaDepartamento();	    		  		
};

function populaFuncionario(){
	let resp;
    let request = new XMLHttpRequest();
    request.open('GET', url + "/funcionario", true);
    request.onload = function() {
        if (request.readyState == 4 && (request.status >= 200 && request.status < 400)) {
            // Success!
            resp = request.responseText;	                
            
            var retorno = request.responseText;
            var obj = JSON.parse(retorno);
            var size = obj.length;
			
            var comboDepto = document.getElementById("comboFuncionario");
            var opt0 = document.createElement("option");
            opt0.value = "0";
            opt0.text = "";
            comboDepto.add(opt0, 0);
            
			for(var i= 0; i< size; i++){
				var opt = document.createElement("option");
                opt.value = obj[i].funcionarioId;
                opt.text = obj[i].funcionarioName;
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

function populaDepartamento(){
	let resp;
    let request = new XMLHttpRequest();
    request.open('GET', url + "/departamento", true);
    request.onload = function() {
        if (request.readyState == 4 && (request.status >= 200 && request.status < 400)) {
            // Success!
            resp = request.responseText;	                
            
            var retorno = request.responseText;
            var obj = JSON.parse(retorno);
            var size = obj.length;
			
            var comboDepto = document.getElementById("comboDepartamento");
            var opt0 = document.createElement("option");
            opt0.value = "0";
            opt0.text = "";
            comboDepto.add(opt0, 0);
            
			for(var i= 0; i< size; i++){
				var opt = document.createElement("option");
                opt.value = obj[i].departamentoId;
                opt.text = obj[i].departamentoName;
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
}

function salvar(){
	var http = new XMLHttpRequest();  			
	http.open('POST', url + "/funcionarioDepartamento", true);

	//Send the proper header information along with the request
	http.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	  			  			
	var data = {    
	    funcionarioDepartamentoData : document.getElementById("funcDeptoData").value,
	    funcionarioId : {
	        funcionarioId : document.getElementById("comboFuncionario").value
	    },
	    departamentoId : {
	        departamentoId : document.getElementById("comboDepartamento").value
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
