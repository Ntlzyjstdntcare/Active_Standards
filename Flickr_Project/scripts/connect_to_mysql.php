<?php
//This is the script that is used throughout the site to connect to the mysql databse
$db_host="localhost";

$db_username="root";

$db_pass="";

$db_name="products";

@mysql_connect("$db_host", "$db_username", "$db_pass") or die("could not connect to mysql");
mysql_select_db("$db_name") or die ("no database");
?>