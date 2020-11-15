document.getElementById("inicial").onclick = function () {	    	
    location.href = url + "/index.html";
};	    	    

window.onload = function() {
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
};

function consultaFuncDepto(){
	var valor = document.getElementById("comboDepartamento").value;
    
	let resp;
    let request = new XMLHttpRequest();
    request.open('GET', url + "/funcionarioDepartamento/pesquisar?departamentoId=" + valor, true);
    
    request.onload = function() {
        if (request.readyState == 4 && (request.status >= 200 && request.status < 400)) {
            // Success!
            resp = request.responseText;	                
            
            var retorno = request.responseText;
            var obj = JSON.parse(retorno);
            var size = obj.length;
			
			var table = document.getElementById('listaFuncionario'); 
			table.innerHTML = "";
			var cabecalho = table.insertRow(0);
			cabecalho.innerHTML = "<tr><td>Nome</td><td>Documento</td><td>Idade</td><td>Data Nascimento</td><td>Cargo</td></tr>";
			
			for(var i= 0; i< size; i++){
				var row = table.insertRow(i+1);
                row.innerHTML = "<td>"+obj[i].funcionarioId.funcionarioName+"</td> <td>"+
                					obj[i].funcionarioId.funcionarioDocument+"</td><td>"+
                					obj[i].funcionarioId.funcionarioAge+"</td><td>"+
                					obj[i].funcionarioId.funcionarioBirthday+"</td><td>"+
                					obj[i].funcionarioId.cargoId.cargoName+"</td>";	
			}
            //document.getElementById(id).innerText=resp;
        } else {
        	console.log("erro");
        }
    };
    
    request.onerror = function() {
    // There was a connection error of some sort
        console.log("Erro:"+request);
    };

    request.send();
	
};