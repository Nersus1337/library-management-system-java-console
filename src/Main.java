import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Main {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Connection con;// Соединение с базой данных

		System.out.println("Hello, this is system of library management\n");
		List<Book> listBooks = new ArrayList<>();

		while (true) {
			System.out.println("1. View all books");
			System.out.println("2. Add book");
			System.out.println("3. Delete book");
			System.out.println("4. View all tickets");
			System.out.println("0. Exit");

			String action = in.nextLine();

			if (action.equals("1")) {// Вывод всех книг
				if (listBooks.isEmpty()) {
					System.out.println("Is empty!");
				}
				for (Book book : listBooks) {
					System.out.println(book.getTitle());
					System.out.println(book.getAuthor());
					System.out.println("//////////////");
				}
			}

			if (action.equals("2")) {// Добавление книги
				System.out.println("Enter title of the book:");
				String titleBook = in.nextLine();
				System.out.println("Enter author of the book:");
				String authorBook = in.nextLine();
				listBooks.add(new Book(titleBook, authorBook));
				
				//Добавление книги в базу данных
				String query = "INSERT INTO Books (title, author) VALUES ('" + titleBook + "' , '" + authorBook + "')";
				try {
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection(
							"jdbc:sqlite:C:\\Users\\User\\eclipse-workspace\\LibraryManageSystemConsole\\db\\nersus.db");
					Statement statement = con.createStatement();
					statement.executeUpdate(query);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (action.equals("3")) {// Удаление книги
				System.out.println("Enter number of the book for delete:");

				if (listBooks.isEmpty()) {
					System.out.println("Is empty!");
				}
				for (Book book : listBooks) {
					System.out.println(book.getTitle());
					System.out.println(book.getAuthor());
					System.out.println("//////////////");
				}
				int removeIndex = Integer.parseInt(in.nextLine());
				listBooks.remove(removeIndex);
			}

			if (action.equals("0")) {
				break;
			}

		}
		System.out.print("\n////////////////////////");
		System.out.print("\nProgram has been closed.");
	}
}
