import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Transaction {
    private String transactionId;
    private Member member;
    private Book book;
    private String borrowDate;
    private String dueDate;
    private String returnDate;
    private int daysLate = 0;
    private double lateFee = 0.0;

    private static int trxCounter = 0;
    private static int totalTransactions = 0;
    public static final double LATE_FEE_PER_DAY = 2000.0;
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Transaction(Member member, Book book, String borrowDate, int borrowDurationDays) {
        if (member == null || book == null) throw new IllegalArgumentException("member dan book tidak boleh null");
        if (!book.borrowBook()) throw new IllegalStateException("Buku tidak tersedia untuk dipinjam");
        this.member = member;
        this.book = book;
        LocalDate b = LocalDate.parse(borrowDate, DF);
        this.borrowDate = b.format(DF);
        this.dueDate = b.plusDays(borrowDurationDays).format(DF);
        this.transactionId = String.format("TRX%03d", ++trxCounter);
        totalTransactions++;
    }

    public void processReturn(String returnDate) {
        LocalDate r = LocalDate.parse(returnDate, DF);
        LocalDate b = LocalDate.parse(this.borrowDate, DF);
        if (r.isBefore(b)) throw new IllegalArgumentException("returnDate tidak boleh sebelum borrowDate");
        this.returnDate = r.format(DF);
        LocalDate due = LocalDate.parse(this.dueDate, DF);
        if (r.isAfter(due)) {
            this.daysLate = (int) ChronoUnit.DAYS.between(due, r);
        } else {
            this.daysLate = 0;
        }
        calculateLateFee();
        book.returnBook();
    }

    public void calculateLateFee() {
        if (daysLate <= 0) { this.lateFee = 0.0; return; }
        double feeBefore = daysLate * LATE_FEE_PER_DAY;
        this.lateFee = feeBefore * (1 - member.getMembershipDiscount());
    }

    public String getTransactionId() { return transactionId; }
    public Member getMember() { return member; }
    public Book getBook() { return book; }
    public String getBorrowDate() { return borrowDate; }
    public String getDueDate() { return dueDate; }
    public String getReturnDate() { return returnDate; }
    public int getDaysLate() { return daysLate; }
    public double getLateFee() { return lateFee; }

    public static int getTotalTransactions() { return totalTransactions; }
}
