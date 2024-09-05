<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>

    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        background-image: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), url('path-to-your-car-image.jpg');
        background-size: cover;
        background-position: center;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    
  
    form {
        background-color: rgba(255, 255, 255, 0.9); /* Transparent white background */
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.4);
        width: 400px;
        max-width: 100%;
        text-align: center;
    }

    h1 {
        color: #007bff; /* A vibrant blue color */
        margin-bottom: 20px;
        font-size: 28px;
    }


    label {
        display: block;
        color: #333;
        font-size: 14px;
        margin: 10px 0 5px;
        text-align: left;
    }

 
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 12px;
        margin-bottom: 15px;
        border-radius: 8px;
        border: 1px solid #ccc;
        font-size: 14px;
        box-sizing: border-box;
    }


    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

 
    input[type="submit"]:hover {
        background-color: #0056b3;
    }

   
    @media (max-width: 600px) {
        form {
            width: 90%;
        }

        h1 {
            font-size: 24px;
        }
    }
</style>
</head>
<body>
    <form method="get" action="LoginValidation">
        <h1>Login Page</h1>
        
        <label for="uname">Username:</label>
        <input type="text" id="uname" name="uname" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <input type="submit" name="submit" value="Login">
    </form>
</body>
</html>
