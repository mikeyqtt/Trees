import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing a file or folder
class File {
    String item; // Name of the file or folder
    List<File> subFiles; // List of sub-files or folders

    File(String item) {
        this.item = item;
        this.subFiles = new ArrayList<>();
    }

    void addSubFile(File subFile) {
        subFiles.add(subFile);
    }

    boolean isLeaf() {
        return subFiles.isEmpty();
    }
}

public class FileOrganizerTree {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Root node (representing all files)
        File root = new File("All Files!");

        System.out.println("Welcome to the File Organizer!");

        // Main loop
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add File");
            System.out.println("2. View Files");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addFile(root);
                    break;
                case 2:
                    viewFiles(root, 0);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a file or folder
    private static void addFile(File root) {
        System.out.println("\nCurrent Files:");
        viewFiles(root, 0);

        System.out.print("\nEnter the name of the new file or folder: ");
        String newFileName = scanner.nextLine();

        System.out.print("Enter the name of the parent file or folder (or leave blank for root): ");
        String parentName = scanner.nextLine();

        if (parentName.isEmpty()) {
            root.addSubFile(new File(newFileName));
            System.out.println("File or folder added under root.");
        } else {
            File parent = findFile(root, parentName);
            if (parent != null) {
                parent.addSubFile(new File(newFileName));
                System.out.println("File or folder added under " + parentName + ".");
            } else {
                System.out.println("Parent file or folder not found.");
            }
        }
    }

    // Method to view files and folders in a tree structure
    private static void viewFiles(File file, int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("  "); // Indentation
        System.out.println("- " + file.item);

        for (File subFile : file.subFiles) {
            viewFiles(subFile, depth + 1); // Recursively view the children
        }
    }

    // Method to find a file or folder by name
    private static File findFile(File file, String item) {
        if (file.item.equalsIgnoreCase(item)) {
            return file;
        }

        for (File subFile : file.subFiles) {
            File found = findFile(subFile, item); // Corrected: should be `subFile` instead of `file`
            if (found != null) {
                return found;
            }
        }

        return null;
    }
}
