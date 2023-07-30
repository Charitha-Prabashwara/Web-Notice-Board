<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" aria-label="Main navigation">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">SEUSL Notice Board</a>
    <button class="navbar-toggler p-0 border-0" type="button" id="navbarSideCollapse" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Dashboard</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Exam Results</a>
        </li>
       
       
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">Marks</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Assignments</a></li>
            <li><a class="dropdown-item" href="#">Assesments</a></li>
            
          </ul>
        </li>
      </ul>
      <form class="d-flex" role="search" style="visibility: hidden;">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<div class="nav-scroller bg-body shadow-sm">
  <nav class="nav" aria-label="Secondary navigation">
    
    <?php
     $dashboardPage='index.php';
     $newsPage= 'news.php';
     $noticePage = "notice.php";
      echo "<a class='nav-link active' aria-current='page' href='" . $dashboardPage ."'>Dashboard</a>";
      echo "<a class='nav-link' href='" . $newsPage ."'>News</a>";
      echo "<a class='nav-link' href='" . $noticePage . "'>Notices</a>";
    ?>
    
    
  </nav>