document.getElementById("inicial").onclick = function () {	    	
    location.href = url + "/index.html";
};

window.onload = function() {
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

function consultaFuncDepto(){
	var valor = document.getElementById("comboFuncionario").value;
    
	let resp;
    let request = new XMLHttpRequest();
    request.open('GET', url + "/histFuncDepto/pesquisar?funcionarioId=" + valor, true);
    
    request.onload = function() {
        if (request.readyState == 4 && (request.status >= 200 && request.status < 400)) {
            // Success!
            resp = request.responseText;	                
            
            var retorno = request.responseText;
            var obj = JSON.parse(retorno);
            var size = obj.length;
			
			var table = document.getElementById('listaDepartamento'); 
			table.innerHTML = "";
			var cabecalho = table.insertRow(0);
			cabecalho.innerHTML = "<tr><td>Departamento</td><td>Data Entrada</td></tr>";
			
			for(var i= 0; i< size; i++){
				var row = table.insertRow(i+1);
                row.innerHTML = "<td>"+obj[i].departamentoId.departamentoName+"</td> <td>"+
                					obj[i].histFuncDeptoData+"</td>";	
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