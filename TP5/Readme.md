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

### MainController
The `MainController` is responsible for managing the main application window and navigation:

- **Features**:
  - Manages the main interface of the application.
  - Handles tab navigation between the `Professor` and `Department` views.
  - Uses a `TabPane` to organize the different views for a seamless user experience.

---

### ProfessorController
The `ProfessorController` handles operations related to professors:

- **Features**:
  - View all professors.
  - Add new professors.
  - Modify existing professors.
  - Delete professors from the system.
  - Search professors using specific keywords.
  - Assign professors to their respective departments.

---

### DepartmentController
The `DepartmentController` is in charge of managing departments:

- **Features**:
  - View all departments.
  - Add new departments.
  - Modify department details.
  - Delete departments from the system.
  - View the list of professors assigned to each department.

---

### AddProfessorController
The `AddProfessorController` manages the process of adding new professors:

- **Features**:
  - Provides a user interface to input professor details.
  - Validates input fields such as name, email, phone, and department selection.
  - Saves the new professor record to the database.

---

### ModifyProfessorController
The `ModifyProfessorController` allows for updating the details of an existing professor:

- **Features**:
  - Fetches current details of the professor for editing.
  - Allows modification of attributes such as name, email, phone, and department.
  - Updates the professor record in the database.

---

### SearchProfessorController
The `SearchProfessorController` facilitates searching for professors based on specific criteria:

- **Features**:
  - Provides a search bar for entering keywords (e.g., name, CIN, department).
  - Displays a filtered list of professors matching the search criteria.
  - Supports advanced search features (e.g., by department or recruitment date).

---

### ListProfessorController
The `ListProfessorController` handles the display of all professors in a tabular or list format:

- **Features**:
  - Retrieves and displays all professors from the database.
  - Allows sorting and filtering options for better organization.
  - Supports pagination for large data sets.

---

### AddDepartementController
The `AddDepartementController` is used to add new departments to the system:

- **Features**:
  - Provides a form for entering department details such as name.
  - Validates inputs before saving.
  - Saves the department record to the database.

---

### ModifyDepartementController
The `ModifyDepartementController` manages the modification of existing department details:

- **Features**:
  - Loads the current department details for editing.
  - Updates the department information in the database.
  - Ensures that changes do not conflict with existing records.

---
