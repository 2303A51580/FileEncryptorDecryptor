import java.io.*;
import java.util.Scanner;

public class FileEncryptorDecryptor {

    // Encrypt or Decrypt using XOR with a key
    public static void processFile(String inputPath, String outputPath, int key) throws IOException {
        FileInputStream fis = new FileInputStream(inputPath);
        FileOutputStream fos = new FileOutputStream(outputPath);

        int ch;
        while ((ch = fis.read()) != -1) {
            fos.write(ch ^ key);  // XOR logic
        }

        fis.close();
        fos.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File Encryption/Decryption Tool");
        System.out.println("1. Encrypt a File");
        System.out.println("2. Decrypt a File");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter input file path: ");
        String inputPath = scanner.nextLine();

        System.out.print("Enter output file path: ");
        String outputPath = scanner.nextLine();

        System.out.print("Enter encryption key (number): ");
        int key = scanner.nextInt();

        try {
            processFile(inputPath, outputPath, key);
            System.out.println((choice == 1 ? "Encryption" : "Decryption") + " completed successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}