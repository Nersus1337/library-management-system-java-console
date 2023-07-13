import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Main {
	public static void main(String[] args)

			throws IOException {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection co = DriverManager.getConnection("jdbc:sqlite:nersus.db");
			System.out.println("Connected to database!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hello, this is system of library management\n");
		List<Book> listBooks = new ArrayList<>();
		while (true) {

			System.out.println("1. View all books");
			System.out.println("2. Add book");
			System.out.println("3. Delete book");
			System.out.println("4. View all tickets");
			System.out.println("0. Exit");

			String input = reader.readLine();

			if (input.equals("1")) {// Вывод всех книг
				if (listBooks.isEmpty()) {
					System.out.println("Is empty!");
				}
				for (Book book : listBooks) {
					System.out.println(book.getTitle());
					System.out.println(book.getAuthor());
					System.out.println("//////////////");
				}
			}
			if (input.equals("2")) {// Добавление книги
				System.out.println("Enter title of the book:");
				String titleBook = reader.readLine();
				System.out.println("Enter author of the book:");
				String authorBook = reader.readLine();
				listBooks.add(new Book(titleBook, authorBook));
				
				String query = "INSERT INTO users (name, phone) "
						+ "VALUES ('first var', 'second var')";
				//Statement statement = co.createStatement();
			}
			if (input.equals("3")) {// Удаление книги
				System.out.println("Enter number of the book for delete:");

				if (listBooks.isEmpty()) {
					System.out.println("Is empty!");
				}
				for (Book book : listBooks) {
					System.out.println(book.getTitle());
					System.out.println(book.getAuthor());
					System.out.println("//////////////");
				}

				int removeIndex = Integer.parseInt(reader.readLine());
				listBooks.remove(removeIndex);
			}

			if (input.equals("0")) {
				break;
			}
			// System.out.println("\n\n\n\n");
		}
	}
}
