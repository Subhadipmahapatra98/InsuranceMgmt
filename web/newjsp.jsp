<html>
<head>
	<title>My Web Page</title>
	<style>
		.container {
			display: flex;
			flex-wrap: wrap;
			justify-content: space-between;
		}

             	.boxpost {
			width: 40%;
                        height: 190px;
			padding: 80px;
			margin-bottom: 20px;
			border: 1px solid #ccc;
			border-radius: 5px;
		}
		.box {
			width: 20%;
			padding: 20px;
			margin-bottom: 20px;
			border: 1px solid #ccc;
			border-radius: 5px;
		}
 
	</style>
</head>
<body>
	<div class="container">

		<div class="boxpost" id="box2">
			<h2>Box 2</h2>
			<p>This is the content of box 2.</p>
		</div>
		<div class="box" id="box3">
			<h2>Box 3</h2>
			<p>This is the content of box 3.</p>
		</div>
            <div class="box" id="box4">
			<h2>Box 4</h2>
			<p>This is the content of box 4.</p>
		</div>
	</div>
</body>
</html>