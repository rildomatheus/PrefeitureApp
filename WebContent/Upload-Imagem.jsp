<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta charset="utf-8">
		<style media="screen">
			body {
				background: url('img/FundoUpload.png');
				background-repeat: no-repeat;
				display: flex;
				min-height: 100vh;
				width: 100%;
				paddin: 0;
				margin: 0;
				align-items: center;
				justify-content: center;
				flex-direction: column;
			}

			#formUpdateDenuncia {
				display: flex;
				min-height: 100vh;
				width: 100%;
				paddin: 0;
				margin: 0;
				align-items: center;
				justify-content: center;
				flex-direction: column;
			}

			#uploader {
				-webkit-appearance: none;
				appearance: none;
				width: 50%;
				margin-bottom: 10px;
			}
			#botaoEnviar{
			visibility: hidden;
			}
		</style>
	</head>

	<body>

		<%int idDenuncia = Integer.parseInt(request.getParameter("idDenuncia"));%>
			<form id="formUpdateDenuncia" name="formImagem" method="post" action="uploadImagem">
				<progress value="0" max="100" id="uploader"> 0%</progress>
				<input type="file" value="upload" id="fileButton" />
				<input type="hidden" id="idDenuncia" name="idDenuncia" value="<%=idDenuncia%>" />
				
				<input type="hidden" id="downloadUrl" name="downloadUrl">
				<div id="bttEnviar"><input type="submit" id="botaoEnviar"/></div>
			</form>



			<script src="http://code.jquery.com/jquery-latest.min.js"></script>
			<script src="https://www.gstatic.com/firebasejs/4.1.3/firebase.js"></script>
			<script>
  				// Initialize Firebase
 				var config = {
   					apiKey: "AIzaSyCMsAKA_rJ8HkDEMl0XBK1efXhExesQQZc",
    				authDomain: "prefeitureapp-5d189.firebaseapp.com",
    				databaseURL: "https://prefeitureapp-5d189.firebaseio.com",
   					projectId: "prefeitureapp-5d189",
    				storageBucket: "prefeitureapp-5d189.appspot.com",
    				messagingSenderId: "1005362197337"
  				};
  				firebase.initializeApp(config);

				//Pegar elementos
				var uploader = document.getElementById('uploader');
				var fileButton = document.getElementById('fileButton');
				var hidden = document.getElementById("downloadUrl");
				var bttEnviar = document.getElementById("botaoEnviar");			
					// Listen for file selection
				fileButton.addEventListener('change', function (e) {
					//pega o arquivo
					var file = e.target.files[0];
					// cria referencia ao storage
					var storageRef = firebase.storage().ref('Foto/' + <%=idDenuncia %>);
					
			
					//upload file
					var uploadTask = storageRef.put(file);

					//Update progress bar
					uploadTask.on('state_changed',
						function progress(snapshot) {
							var percentage = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
							uploader.value = percentage;
						},
						function error(err) {

						},
						function complete() {
							var downloadURL = uploadTask.snapshot.downloadURL;
							hidden.value = downloadURL;
							hidden.innerHTML;
							console.log(downloadURL);
							console.log(hidden);
							bttEnviar.style.visibility = "visible";

						}
					);
				});

			</script>
	</body>

	</html>