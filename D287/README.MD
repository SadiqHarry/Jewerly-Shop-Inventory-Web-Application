Assignment Progression


Part C:

- Substitute Shop name in "mainscreen.html" Line 19
- Substitute Parts and products name in "mainscreen.html" (Lines 21 & 53)

Part D:
- Added about.html page and added description
- Added about button to link about.html in mainscreen.html: (Line 20)
- Added method for routing in "MainScreenControllerr" (Lines 55-58)

Part E:
- Added method to check if productRepository and partRepository are empty in "BootStrapData.java" (Line:41)
- Then added sample data for ProductRepository in BootStrapData.java file(Lines: 43-48)
- Then saved products to productRepository in BootStrapData.java file (Line: 50-55)
- Then added sample data for PartRepository in BootStrapData.java file & saved data to outsourcedPartRepository(Lines: 57-91)

Part F:
- Added "Buy Now" button to product table in "mainscreen.html" (Line: 90)
- Added method to handle decremented inventory after button is clicked in "mainscreenControllerr" (Lines: 64-99)
- Added flash attribute and display Success/Failure messages using Thymeleaf expressions in "mainscreen.html" (Lines: 17-19)
- The method maps the current inventory of the product to the "currentInventory" variable then it decrements the inventory by 1.
- The method also utilizes the "ProductService.java" function: "save" to save the decremented inventory to the database.
- The method also has exception handling to check if the inventory is null. If the inventory is null, it will throw an exception and display an error message.
- The method also prints to console the current inventory of the product when the button is clicked and after the decrement happens.

Part G:
- Added two additional fields to "Part.java" file (Lines: 32-35) & (Lines: 45-50)
- Added the getters and setters for new fields in "Part.java" file (Lines: 37-44)
- Updated Sample data in "BootStrapData.java" file to add new values to min and max inv (Lines: 58-101)
- Updated "InhousePartForm.html" file to add new fields (Lines: 24-28)
- Updated "OutsourcedPartForm.html" file to add new fields (Lines: 25-29)
- Renamed the file the persistent storage file is saved to in "application.properties" file (Line: 6)
- Created a method (validateAndSetInv) in "Parts.java" to validate and set data for sample data. (Line 115-120)
- Adjusted sample data in "bootStrapData.java" to use new method (Line 58-101)

Part H:
- Updated AddInhousePartController to Display Error message on user side if inv is less than mininv or more than maxinv (Lines: 42-60)
- Updated AddInhousePartForm.html to display error message (Lines: 23)
- Updated AddOutsourcedPartController to Display Error message on user side if inv is less than mininv or more than maxinv (Lines: 44-63)
- Updated AddOutsourcedPartForm.html to display error message (Lines: 24)
- For Products table there is an error message that displays if negative.

Part I:
- Added 4 tests to PartTest.java file (Lines: 160-186)
- Test Passed

Part J:
- All of my created classes files are being implemented in the application.
