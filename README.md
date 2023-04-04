# Book Tracker

## What will the application do?  
Track reading progress in books

## Who will use it?
People who:
- read lots of books
- want to track their reading progress

## Why is this project of interest to you?
I read lots of books **and** keep forgetting 
where I was at.

## User Stories
As a user, I want to be able to:
- add a book to my reading list
- view the list of books in my list
- remove a book from my list
- see the number of chapter I've read
- edit the number of chapters
- edit the title of books
- have the option to save my book list to a file
- have the option to load my book list from a file

## Instructions for Grader

- To edit books, click on the "Edit" button to enable editing, the double click on the field the user wish to edit. 
- To add books, click the "Add" button to add new rows. Once that is done, click on the "Edit" button to enable editing, then enter the titles and chapters for the new books in the new rows.
- To remove books, first select the rows by dragging the mouse. Then click the "Remove" button.
- The visual component is in the folder images, and are icons for pop up messages. They appear when saving or loading is successful.
- The user can save the state of the application by clicking the  "Save" button.
- The user can load the state of the application by clicking the "Load" button.

## Phase 4: Task 2
Wed Mar 29 21:36:05 PDT 2023  
The book list is loaded from file.  
Wed Mar 29 21:36:05 PDT 2023  
A book is added.  
Wed Mar 29 21:36:05 PDT 2023  
A book is added.  
Wed Mar 29 21:36:05 PDT 2023  
A book is added.  
Wed Mar 29 21:36:06 PDT 2023  
A book is added.  
Wed Mar 29 21:36:07 PDT 2023  
A book is added.  
Wed Mar 29 21:36:07 PDT 2023  
A book is added.  
Wed Mar 29 21:36:11 PDT 2023  
A book chapter is changed.  
Wed Mar 29 21:36:38 PDT 2023  
A book title is changed.  
Wed Mar 29 21:36:41 PDT 2023  
A book is removed.  
Wed Mar 29 21:36:43 PDT 2023  
The book list is saved to file.  

## Phase 4: Task 3
I could extract the JFrame with the buttons to its own class out of MainFrame.   
Advantage: Less coupling. I could modify that JFrame all by itself without touching anything else. I could handle the button events all within the JFrame class. The MainFrame class will also be shorter and more towards single purposed.   
Disadvantage: It became really messy to try to coordinate date flow back and forth between the JTable and the button events. I need to edit and refresh the JTable when button events happen, and initializing new JTable models. I had a lot of trouble trying to track what happens when and which one is the current object. I also had to pass around more parameters, which made the whole thing more complicated.