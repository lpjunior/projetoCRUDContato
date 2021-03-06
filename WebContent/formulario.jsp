<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <title>C.R.U.D - Contato</title>
  </head>
  <body>
  	<div class="container-fluid col-6">
		<fieldset>
			<legend>Cadastro de Contato</legend>
	  		<form action="addcontato" method="post">
	  			<div>
	  				<label for="nome_id">Nome</label>
	  				<input type="text" class="form-control" name="txtNome" id="nome_id" placeholder="informe o nome" required>
	  			</div>
	  			<div>
	  				<label for="email_id">Email</label>
	  				<input type="email" class="form-control" name="txtEmail" id="email_id" placeholder="informe o email" required>
	  			</div>
	  			<div>
	  				<label for="telefone_id">Telefone</label>
	  				<input type="tel" class="form-control" name="txtTelefone" id="telefone_id" placeholder="informe o telefone" required>
	  			</div>
	  			<div class="d-grid gap-2 col-6 mx-auto my-2">
		  			<button type="submit" class="btn btn-dark">Gravar</button>
	  			</div>
	  		</form>    
		</fieldset>
  	</div>

    <!-- Optional JavaScript; choose one of the two! -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    -->
  </body>
</html>