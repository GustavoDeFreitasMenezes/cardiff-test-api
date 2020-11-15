document.getElementById("inicial").onclick = function () {	    	
    location.href = url + "/index.html";
};

document.getElementById("adicionar").onclick = function () {	    	
    location.href = url + "/cadastro-funcionario-departamento.html";
};

window.onload = function() {
	let resp;
    let request = new XMLHttpRequest();
    request.open('GET', url + "/funcionarioDepartamento", true);
    request.onload = function() {
        if (request.readyState == 4 && (request.status >= 200 && request.status < 400)) {
            // Success!
            resp = request.responseText;
            	                
            var retorno = request.responseText;
            var obj = JSON.parse(retorno);
            var size = obj.length;
			
			var table = document.getElementById('listaFuncionarioDepartamento');        			        			
			        			
			for(var i= 0; i< size; i++){
				var row = table.insertRow(i+1);
                row.innerHTML = '<td>'+obj[i].funcionarioDepartamentoId+'</td> <td>'+ 
                						obj[i].funcionarioId.funcionarioName+'</td> <td>'+
                						obj[i].funcionarioId.funcionarioDocument+'</td> <td>'+
                						obj[i].funcionarioId.funcionarioAge+'</td> <td>'+
                						obj[i].funcionarioId.funcionarioBirthday+'</td> <td>'+
                						obj[i].funcionarioId.cargoId.cargoName+'</td> <td>'+
                						obj[i].departamentoId.departamentoName+'</td> <td>'+
                						obj[i].departamentoId.funcionarioId.funcionarioName+'</td> <td>'+
                						'<input type="button" value="Excluir" onclick="excluirLinha(this)" </td>';	
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

function excluirLinha(btn) {
  var row = btn.parentNode.parentNode;
  var data = row.cells[0].firstChild.data;
  
  var http = new XMLHttpRequest();  			
  http.open('DELETE', url + "/funcionarioDepartamento/" + data, true);
  
  http.onload = function () {			
	if (http.readyState == 4 && (http.status >= 200 && http.status < 400)) {
		row.parentNode.removeChild(row);
		alert("Registro removido com sucesso");
	} else {
		console.log(http.responseText);
	}
  }
  
  http.send();    	  
  
};