By: Karan Ahuja

B.Tech. 2nd Year

Bank_account
============

A Web based Java Banking application.

The bank.java file contains the java source code and the bank.mdb is the database file. 

The following java code acts as a bank server, with user account database, account information, transaction details, etc… .
You can do a variety of functions which you can clearly see on running it, as it has a GUI.
The default username is administrator and password is admin.

Now the folder also contains a war file, which is the JSP based application. Just import it to your eclipse workspace and run the index.jsp file. Now create account and perform whatever operations you want. Most of the classes used are an extension of the classes in the bank.java source code, but both the files are independent.

Note:

The database connected to the application is created in SQL. 

I have used JDBC-ODBC to connect to a database named Dem, so you can change that if you want. Since I have used windows authentication I did not need a username and password, but you can add one if you want. You will have to register the database if you are using windows in the 'Set up ODBC Data Source' option of the control panel. If you are using Java 8 you will have to use a MySQLConnector as the ODBC facility has been removed.

You also need to create three tables with the following enteries:

Table 1:

Name: user_details

Enteries:  username (varchar), passwd (varchar), question (varchar), answer (varchar), address (varchar), email (varchar), mobile (int)

Table 2:

Name: tx_details

Enteries: uname (varchar), accno (varchar), operation (varchar), amt (varchar), balance (varchar), time1 (varchar), isnew (varchar)

Table 3:

Name: acc_details

Enteries: accno (int), uname (varchar), acc_type (varchar), details (varchar)






