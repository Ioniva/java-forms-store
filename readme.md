# LIMA - JavaFX Forms Store 
**LIMA** is a desktop program <ins>with modern user interface</ins>, designed to manage an online store.

This application can manage orders, items and customers. Each of these sections has the functionality to create, read, update and delete (CRUD) each entity.

## Getting Started
The installation and execution of this program is very simple.

### 1. Download the project
Always recommended to download from GitHub latest release for new features.

### 2. Configure the db connection
Once the project is opened, modify the properties file to be able to connect to the database.

**Database for testing**

This project contains a copy of the database for testing purposes, this is an exported SQL file.
File location `./src/main/resources/db/Dump20220419.sql`

### 3. Install the dependencies
For the correct operation of the project, you must install its dependencies.

Execute this Maven command:
```
$ mvn install 
```
### 4. Run the application
Finally, it only remains to execute the main method. This main is located in `./src/main/java/com/example/lima/HelloApplication.java`

**Display sample result:**

![Menu to display the items](/src/main/resources/assets/table-example.png "LIMA items table")

## License
LIMA is an open source project that is licensed under [GPL](https://opensource.org/licenses/GPL-2.0).
