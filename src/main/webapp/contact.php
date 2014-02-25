<?php


if(isset($_REQUEST["isvalid"])){
    
    $youremail = "info@domainname.com"; // ENTER YOUR EMAIL ADDRESS WHERE IT STATES info@domainname.com
    $usersemail = $_POST["usersemail"];
    $usersname = $_POST["usersname"];
    $userscomment = $_POST["userscomment"];
    $usersubject = 'Contact From Your Site';
    
    
    $to      = $youremail;
    $subject = 'Contact From Your Website';
    $message = $usersname . " has contacted you through your website: " . "\r\n" . "\r\n" . $userscomment;
    $headers = 'From: ' . $usersemail . "\r\n" . 'Reply-To: ' . $usersemail . "\r\n";
    
    if(mail($to, $subject, $message, $headers)){
        echo "success";
    } else {
        echo "serverdown";
    }
    
} else {
    
    echo "failed";
    
}