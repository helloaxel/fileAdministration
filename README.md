# Authors Registry 

This is a console-based project developed to practice file management and data persistence in Java. 
The main goal was to learn how to handle read and write streams efficiently in a local environment.

## Key Implementations:
Buffered Streams: I used BufferedWriter and BufferedReader to ensure faster file communication and avoid system overhead.

Automatic Resource Management: Implemented try-with-resources blocks to guarantee that all files are closed correctly, preventing potential memory leaks.

Data Organization: Data is stored in a structured .txt file within a directory created dynamically by the program.

## Tech Stack:
Language: Java (JDK 24)

Libraries: java.io (File handling)

Input: Scanner API for CLI interaction
