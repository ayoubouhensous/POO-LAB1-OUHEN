# TP : Gestion des Professeurs et Départements en JavaFX

## Description
Ce projet est une application de bureau développée en JavaFX qui permet de gérer les informations des professeurs et des départements d'une institution. L'application offre une interface utilisateur interactive pour ajouter, modifier, supprimer et visualiser des données.

---

## Table des Matières
1. [Introduction](#introduction)
2. [Technologies Utilisées](#technologies-utilisées)
3. [Fonctionnalités](#fonctionnalités)
4. [Ui](#Ui)
5. [Utilisation](#utilisation)
6. [Conclusion](#conclusion)

---

## Introduction
JavaFX est une plateforme puissante pour créer des applications de bureau modernes. Ce TP met en œuvre les concepts fondamentaux de la programmation orientée objet et utilise des composants JavaFX pour concevoir une interface utilisateur intuitive. Le projet se concentre sur la gestion des entités suivantes :
- **Professeurs** : informations telles que le nom, le prénom, le département, et le numéro d'identification.
- **Départements** : informations telles que le nom du département, le code, et la liste des professeurs associés.

---

## Technologies Utilisées
- **Langage** : Java (JDK 17 ou supérieur)
- **Framework** : JavaFX
- **IDE** : IntelliJ IDEA ou Eclipse
- **Base de Données** : SQLite ou MySQL (en option)
- **Gestion de Version** : Git

---

## Fonctionnalités
1. **Gestion des Professeurs :**
   - Ajouter un nouveau professeur.
   - Modifier les informations d'un professeur existant.
   - Supprimer un professeur.
   - Rechercher un professeur par nom ou par département.

2. **Gestion des Départements :**
   - Ajouter un nouveau département.
   - Modifier les informations d'un département.
   - Supprimer un département.
   - Visualiser la liste des professeurs d'un département.

3. **Interface Utilisateur :**
   - Tableaux dynamiques pour afficher les données.
   - Formulaires pour l'entrée et la modification des données.
   - Messages d'erreur et de confirmation pour guider l'utilisateur.

---
## Ui
![show prof](https://github.com/user-attachments/assets/229c054b-2db5-45cf-854d-02f615b2c01c)

![add prof](https://github.com/user-attachments/assets/7e6ac551-cdc2-4453-9394-be7f7e250022)

![modifyprof](https://github.com/user-attachments/assets/87e5c152-28e5-47c7-b8c9-1b4dffb38d43)

![depart to prof](https://github.com/user-attachments/assets/d557e13f-b7c0-4b43-89d2-d419ecbb13d0)

![show departement](https://github.com/user-attachments/assets/202a2104-4524-4c05-b6e4-2c3bdfc2fab4)

![add departement](https://github.com/user-attachments/assets/f448e998-faf6-4d99-8655-a83088ca60a2)

![modifydep](https://github.com/user-attachments/assets/c3bc9095-a46e-4060-ac2d-d67253c566b1)

![listprofdep](https://github.com/user-attachments/assets/0425fefc-3826-4100-a6bc-16c1041cd2a7)

## Models

### Professor
The `Professor` class represents a professor with various attributes:
- **id**
- **nom**
- **prenom**
- **cin**
- **adresse**
- **email**
- **telephone**
- **dateRecrutement**
- **departmentId**
  
---
### Department
The `Department` class represents a department within the institution:

- **id**: Unique identifier for the department.
- **nom**: Name of the department.

---
## Controller Documentation

## MainController
The `MainController` is responsible for managing the main application window and navigation:

- **Features**:
  - Manages the main interface of the application.
  - Handles tab navigation between the `Professor` and `Department` views.
  - Uses a `TabPane` to organize the different views for a seamless user experience.
  
- **Methods**:
  - `quitter()`: Exits the application.

---

## ProfessorController
The `ProfessorController` handles operations related to professors:

- **Features**:
  - View all professors.
  - Add new professors.
  - Modify existing professors.
  - Delete professors from the system.
  - Search professors using specific keywords.
  - Assign professors to their respective departments.

- **Methods**:
  - `initialize()`: Sets up the initial state of the controller.
  - `modifyProfessor()`: Initiates the modification process for a professor.
  - `deleteProfessor()`: Deletes a selected professor from the system.
  - `addProfessor()`: Adds a new professor based on user input.
  - `affecterProfessor()`: Assigns a professor to a department.
  - `onSearchClicked()`: Executes the search action for professors.
  - `refreshProfessors()`: Refreshes the list of professors displayed.
  - `getCurrentKeyword()`: Retrieves the current search keyword.
  - `setCurrentKeyword()`: Sets the current search keyword.

---

## DepartmentController
The `DepartmentController` is in charge of managing departments:

- **Features**:
  - View all departments.
  - Add new departments.
  - Modify department details.
  - Delete departments from the system.
  - View the list of professors assigned to each department.

- **Methods**:
  - `initialize()`: Sets up the initial state of the department controller.
  - `addDepartement()`: Adds a new department based on user input.
  - `modifyDepartment()`: Modifies the details of an existing department.
  - `deleteDepartment()`: Deletes a selected department from the system.
  - `showProfessors()`: Displays the professors associated with the department.
  - `refreshDepartement()`: Refreshes the list of departments displayed.

---

## AddProfessorController
The `AddProfessorController` manages the process of adding new professors:

- **Features**:
  - Provides a user interface to input professor details.
  - Validates input fields such as name, email, phone, and department selection.
  - Saves the new professor record to the database.

- **Methods**:
  - `initialize()`: Sets up the initial state for adding a professor.
  - `setProfesseurController()`: Links the controller to the professor management logic.
  - `handleAddProfessor()`: Handles the logic for adding a new professor.
  - `handleCancel()`: Cancels the add operation and returns to the previous view.

---

## ModifyProfessorController
The `ModifyProfessorController` allows for updating the details of an existing professor:

- **Features**:
  - Fetches current details of the professor for editing.
  - Allows modification of attributes such as name, email, phone, and department.
  - Updates the professor record in the database.

- **Methods**:
  - `initialize()`: Sets up the initial state for modifying a professor.
  - `loadDepartement()`: Loads the departments for selection.
  - `populateFields()`: Populates the input fields with the current professor's data.
  - `setProfesseur()`: Sets the selected professor for modification.
  - `updateProfessorData()`: Updates the professor's details in the database.
  - `handleModifyProfessor()`: Handles the modification action.
  - `handleCancel()`: Cancels the modification process and returns to the previous view.

---

## SearchProfessorController
The `SearchProfessorController` facilitates searching for professors based on specific criteria:

- **Features**:
  - Provides a search bar for entering keywords (e.g., name, CIN, department).
  - Displays a filtered list of professors matching the search criteria.
  - Supports advanced search features (e.g., by department or recruitment date).

- **Methods**:
  - `initialize()`: Sets up the initial state for searching professors.
  - `searchProfessors()`: Executes the search based on the entered criteria.
  - `addActionButtons()`: Adds action buttons for modifying, deleting, or assigning professors.
  - `handleModify()`: Initiates the modification of a selected professor.
  - `handleDelete()`: Deletes a selected professor from the search results.
  - `handleAssign()`: Assigns a selected professor to a department.
  - `loadProf()`: Loads professor data for the search operation.

---

## ListProfessorController
The `ListProfessorController` handles the display of all professors in a tabular or list format:

- **Features**:
  - Retrieves and displays all professors from the database.
  - Allows sorting and filtering options for better organization.
  - Supports pagination for large data sets.

- **Methods**:
  - `initialize()`: Sets up the initial state for listing professors.
  - `listProfessor()`: Retrieves and displays the list of all professors.

---

## AddDepartementController
The `AddDepartementController` is used to add new departments to the system:

- **Features**:
  - Provides a form for entering department details such as name.
  - Validates inputs before saving.
  - Saves the department record to the database.

- **Methods**:
  - `initialize()`: Sets up the initial state for adding a department.
  - `handleAddDepartement()`: Handles the logic for adding a new department.
  - `handleCancel()`: Cancels the add operation and returns to the previous view.

---

## ModifyDepartementController
The `ModifyDepartementController` manages the modification of existing department details:

- **Features**:
  - Loads the current department details for editing.
  - Updates the department information in the database.
  - Ensures that changes do not conflict with existing records.

- **Methods**:
  - `initialize()`: Sets up the initial state for modifying a department.
  - `loadDepartment()`: Loads the current department details for editing.
  - `updateDepartmentData()`: Updates the department's details in the database.
  - `handleModifyDepartment()`: Handles the modification action.
  - `handleCancel()`: Cancels the modification process and returns to the previous view.

---


## FXML Files and Descriptions

### AddDepartement.fxml
This file defines the user interface for adding a new department:

- **Features**:
  - Contains a form for entering department details, such as the department name.
  - Includes buttons for saving the new department or canceling the action.
  - Validates input fields before submission.

---

### AddProfessor.fxml
This file defines the user interface for adding a new professor:

- **Features**:
  - Provides a form to input professor details such as name, CIN, address, email, phone, recruitment date, and department.
  - Includes dropdowns or selection fields for assigning a professor to a department.
  - Has buttons for saving the new professor or canceling the action.

---

### DepartementViews.fxml
This file represents the main interface for managing departments:

- **Features**:
  - Displays a list of all departments in a table or grid view.
  - Includes options for viewing, editing, and deleting departments.
  - May include a search or filter functionality for easier navigation.

---


### ListProfessorDepartement.fxml
This file provides a view of professors associated with specific departments:

- **Features**:
  - Displays professors grouped or filtered by their department.
  - Allows the user to view details of each professor.
  - May include options for actions such as assigning or removing professors from a department.

---

### MainView.fxml
This file defines the main interface of the application:

- **Features**:
  - Contains a `TabPane` or similar layout for navigation between different sections (e.g., Professors, Departments).
  - Acts as a container for other views, allowing seamless transitions between tabs or modules.
  - Includes common elements like menus, toolbars, or status bars.

---

### ModifyDepartement.fxml
This file represents the interface for modifying an existing department:

- **Features**:
  - Displays the current details of the department to be edited.
  - Provides fields for modifying attributes such as the department name.
  - Includes buttons for saving changes or canceling the operation.

---

### ModifyProfessor.fxml
This file defines the user interface for modifying the details of an existing professor:

- **Features**:
  - Displays the current information of the professor for editing.
  - Allows modification of attributes such as name, email, phone, department, etc.
  - Includes options for saving changes or canceling the action.

---

### ProfesseurViews.fxml
This file is the main view for managing professors:

- **Features**:
  - Displays a list of all professors in a table or grid format.
  - Includes options for actions like adding, editing, deleting, and searching for professors.
  - Provides filtering or sorting options for organizing the list.

---

### SearchProfessor.fxml
This file provides a dedicated interface for searching professors:

- **Features**:
  - Includes a search bar or form for entering keywords or filters.
  - Displays search results in a list or table format.
  - Supports advanced search options, such as filtering by department or recruitment date.

---
## Application

### Professor Management
The application provides comprehensive management features for professors:

- **Complete CRUD operations**: Create, Read, Update, and Delete professors.
- **Search functionality**: Quickly find professors by name, CIN, or department.
- **Department assignment**: Assign professors to specific departments seamlessly.
- **Date picker for recruitment date**: User-friendly input for selecting recruitment dates.
- **Input validation**: Ensures accurate and valid data entry.

---

### Department Management
Manage academic departments with ease:

- **CRUD operations**: Create, Read, Update, and Delete departments.
- **View associated professors**: See all professors belonging to a department.
- **Automatic table updates**: Reflects real-time changes to department data.
- **Validation checks**: Ensures valid department details before saving.

---

### Database Integration
Robust integration with the database ensures reliable operations:

- **Uses JDBC for database operations**: Interacts with the database efficiently.
- **Implements connection pooling**: Optimizes database connections for better performance.
- **Transaction management**: Ensures consistency in database operations.
- **Prepared statements for security**: Protects against SQL injection attacks.

---

### User Interface
A clean and responsive user interface for enhanced user experience:

- **Clean and intuitive design**: Simplified navigation and user-friendly layout.
- **Responsive layout**: Adapts seamlessly to different screen sizes.
- **Form validation**: Ensures required fields are filled correctly before submission.
- **Interactive tables**: Allows sorting, filtering, and selecting rows dynamically.
- **Modal dialogs for operations**: Provides pop-ups for adding, editing, or deleting records without leaving the main page.

---

