import java.time.LocalDate;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category; // Fiction/Non-Fiction/Science/Technology/History
    private int publicationYear;
    private int totalCopies;
    private int availableCopies;
    private int borrowCount = 0;

    private static int bookCounter = 0;
    private static int totalBooks = 0;

    public Book(String title, String author, String category, int publicationYear, int totalCopies) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("title tidak boleh kosong");
        if (author == null || author.trim().isEmpty()) throw new IllegalArgumentException("author tidak boleh kosong");
        category = capitalize(category);
        if (!isValidCategory(category)) throw new IllegalArgumentException("category harus salah satu dari: Fiction/Non-Fiction/Science/Technology/History");
        if (publicationYear < 1900 || publicationYear > 2025) throw new IllegalArgumentException("publicationYear harus antara 1900 - 2025");
        if (totalCopies < 0) throw new IllegalArgumentException("totalCopies harus >= 0");

        this.title = title.trim();
        this.author = author.trim();
        this.category = category;
        this.publicationYear = publicationYear;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.bookId = String.format("BK%03d", ++bookCounter);
        totalBooks++;
    }

    public void displayBookInfoCompact() {
        System.out.println("[" + bookId + "] " + title);
        System.out.println("Penulis       : " + author);
        System.out.println("Kategori      : " + category);
        System.out.println("Tahun Terbit  : " + publicationYear);
        System.out.println("Umur Buku     : " + getBookAge() + " tahun");
        System.out.println("Total Copy    : " + totalCopies + " eksemplar");
        System.out.println("Tersedia      : " + availableCopies + " eksemplar | Status: " + getAvailabilityStatus() + (isNewRelease() ? " [NEW RELEASE]" : ""));
        System.out.println("--------------------------------------------");
    }

    public boolean borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            borrowCount++;
            return true;
        }
        return false;
    }

    public void returnBook() {
        if (availableCopies < totalCopies) availableCopies++;
    }

    public int getBookAge() {
        return LocalDate.now().getYear() - publicationYear;
    }

    public boolean isNewRelease() {
        return getBookAge() <= 2;
    }

    public String getAvailabilityStatus() {
        if (availableCopies == 0) return "Tidak Tersedia";
        if (availableCopies <= 5) return "Terbatas";
        return "Banyak Tersedia";
    }

    public static int getTotalBooks() { return totalBooks; }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public int getPublicationYear() { return publicationYear; }
    public int getAvailableCopies() { return availableCopies; }
    public int getTotalCopies() { return totalCopies; }
    public int getBorrowCount() { return borrowCount; }

    private static boolean isValidCategory(String c) {
        return "Fiction".equals(c) || "Non-Fiction".equals(c) || "Science".equals(c) || "Technology".equals(c) || "History".equals(c);
    }

    private static String capitalize(String s) {
        if (s == null) return null;
        s = s.trim();
        if (s.length() == 0) return s;
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
