
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Carousel Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <script src="./js/ie-emulation-modes-warning.js"></script>

    <!-- Custom styles for this template -->
    <link href="carousel.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  <div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1>Infinity Cable</h1>
		</div>
		<div id="slogan">
			
		</div>
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Welcome Guest User!!</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="./index.html">Home</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    </div>


    <!-- Carousel
    ================================================== -->
       <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
      </ol>
      <div class="carousel-inner" role="listbox">

        <div class="item active">
          <center> <img class="first-slide" align="middle" style="height:500px" src="./images/img1.jpg" alt="First slide"> </center>
          <div class="container"> </div>
        </div>

        <div class="item">
          <center> <img class="second-slide" src="./images/img2.jpg" style="height:500px" alt="Second slide"> </center>
          <div class="container"> </div>
        </div>

        <div class="item">
          <center> <img class="third-slide" src="./images/img3.png" style="height:500px" alt="Third slide"> </center>
          <div class="container"> </div>
        </div>

        <div class="item">
          <center> <img class="second-slide" src="./images/img4.jpg" style="height:500px" alt="Fourth slide"> </center>
          <div class="container"> </div>
        </div>
<br></br>   
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="false"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->
   
    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- four columns of text below the carousel -->
      <table>
<tr>
<td><img class="img-circle center-block" src="./images/bg.jpg" alt="Generic placeholder image" width="80" height="80"></td>
<td><img class="img-circle center-block" src="./images/avatar.jpg" alt="Generic placeholder image" width="80" height="80"></td>
<td><img class="img-circle center-block" src="./images/bg.jpg" alt="Generic placeholder image" width="80" height="80"></td>
<td><img class="img-circle center-block" src="./images/avatar.jpg" width="80" height="80"></td>
</tr>
<tr>
<td><h2 style="text-align: center;">Premium</h2></td>
<td><h2 style="text-align: center;">Standard</h2></td>
<td><h2 style="text-align: center;">Sports</h2></td>
<td><h2 style="text-align: center;">Music</h2></td>
</tr>
<tr>
<td style="width:25%"><p style="text-align: center;">Includes all standard channels including HBO and star Movies HD Channels</p></td>
<td style="width:25%"><p style="text-align: center;">Includes 10 movie channels,4 sports channels and 2 music channels</p></td>
<td style="width:25%"><p style="text-align: center;">10 sport channels up to 40 mbps</p></td>
<td style="width:25%"><p style="text-align: center;">14 Music Channels speed up to 50 mbps</p></td>
</tr>
</table>

      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="./images/avatar.jpg" width="300" height="300" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="./images/avatar.jpg" width="300" height="300" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="./images/avatar.jpg" width="300" height="300" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Finally<span class="text-muted">Music</span></h2>
          <p class="lead">This is for hard core music fans , enjoy unlimited music from 14 music channels</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="./images/avatar.jpg" width="300" height="300" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <!-- /END THE FEATURETTES -->


      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2015 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="./js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>