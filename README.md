TDD Evolution Steps:
-------------------

Step 1: Basic validator with 8 characters, uppercase and digit requirement.

Step 2: Handled null input by throwing an exception with the message "Password cannot be null".

Step 3: Added special character requirement.

Step 4: Changed minimum length requirement from 8 to 10 characters.

Step 6: Integrated the external blacklist service (with Mockito-based tests).

You can check out each step using the corresponding git tag (e.g., git checkout step-3).
