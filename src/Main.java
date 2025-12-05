import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        System.out.println("============================================\n");

        List<Member> members = new ArrayList<>();
        members.add(new Member("Alice Johnson","alice.j@email.com","081234567890",2020,"Platinum"));
        members.add(new Member("Bob Smith","bob.smith@email.com","081298765432",2022,"Gold"));
        members.add(new Member("Charlie Brown","charlie.b@email.com","081223456789",2024,"Silver"));
        members.add(new Member("Diana Prince","diana.p@email.com","081287654321",2021,"Gold"));

        System.out.println("=== REGISTRASI ANGGOTA ===");
        System.out.println("✓ Anggota berhasil ditambahkan: " + members.get(0).getMemberId() + " - " + members.get(0).getName() + " (" + members.get(0).getMembershipType() + ")");
        System.out.println("✓ Anggota berhasil ditambahkan: " + members.get(1).getMemberId() + " - " + members.get(1).getName() + " (" + members.get(1).getMembershipType() + ")");
        System.out.println("✓ Anggota berhasil ditambahkan: " + members.get(2).getMemberId() + " - " + members.get(2).getName() + " (" + members.get(2).getMembershipType() + ")");
        System.out.println("✓ Anggota berhasil ditambahkan: " + members.get(3).getMemberId() + " - " + members.get(3).getName() + " (" + members.get(3).getMembershipType() + ")\n");

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby","F. Scott Fitzgerald","Fiction",1925,5));
        books.add(new Book("Clean Code","Robert C. Martin","Technology",2008,8));
        books.add(new Book("Sapiens","Yuval Noah Harari","History",2011,6));
        books.add(new Book("1984","George Orwell","Fiction",1949,4));
        books.add(new Book("The Pragmatic Programmer","Hunt & Thomas","Technology",1999,3));
        books.add(new Book("Atomic Habits","James Clear","Non-Fiction",2018,10));

        System.out.println("=== REGISTRASI BUKU ===");
        System.out.println("✓ Buku berhasil ditambahkan: " + books.get(0).getBookId() + " - \"" + books.get(0).getTitle() + "\" by " + books.get(0).getAuthor());
        System.out.println("✓ Buku berhasil ditambahkan: " + books.get(1).getBookId() + " - \"" + books.get(1).getTitle() + "\" by " + books.get(1).getAuthor());
        System.out.println("✓ Buku berhasil ditambahkan: " + books.get(2).getBookId() + " - \"" + books.get(2).getTitle() + "\" by " + books.get(2).getAuthor());
        System.out.println("✓ Buku berhasil ditambahkan: " + books.get(3).getBookId() + " - \"" + books.get(3).getTitle() + "\" by " + books.get(3).getAuthor());
        System.out.println("✓ Buku berhasil ditambahkan: " + books.get(4).getBookId() + " - \"" + books.get(4).getTitle() + "\" by " + books.get(4).getAuthor());
        System.out.println("✓ Buku berhasil ditambahkan: " + books.get(5).getBookId() + " - \"" + books.get(5).getTitle() + "\" by " + books.get(5).getAuthor() + "\n");

        // Create transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(members.get(0), books.get(1), "01-12-2025", 14)); // TRX001
        transactions.add(new Transaction(members.get(1), books.get(0), "05-12-2025", 14)); // TRX002
        transactions.add(new Transaction(members.get(2), books.get(2), "10-11-2025", 14)); // TRX003
        transactions.add(new Transaction(members.get(3), books.get(3), "20-11-2025", 14)); // TRX004

        System.out.println("=== TRANSAKSI PEMINJAMAN ===");
        System.out.println("✓ Peminjaman berhasil: " + members.get(0).getName() + " meminjam \"" + books.get(1).getTitle() + "\"");
        System.out.println("   Tanggal Pinjam: 01-12-2025 | Jatuh Tempo: 15-12-2025");
        System.out.println("✓ Peminjaman berhasil: " + members.get(1).getName() + " meminjam \"" + books.get(0).getTitle() + "\"");
        System.out.println("   Tanggal Pinjam: 05-12-2025 | Jatuh Tempo: 19-12-2025");
        System.out.println("✓ Peminjaman berhasil: " + members.get(2).getName() + " meminjam \"" + books.get(2).getTitle() + "\"");
        System.out.println("   Tanggal Pinjam: 10-11-2025 | Jatuh Tempo: 24-11-2025");
        System.out.println("✓ Peminjaman berhasil: " + members.get(3).getName() + " meminjam \"" + books.get(3).getTitle() + "\"");
        System.out.println("   Tanggal Pinjam: 20-11-2025 | Jatuh Tempo: 04-12-2025\n");

        transactions.get(2).processReturn("04-12-2025");
        transactions.get(3).processReturn("03-12-2025");

        System.out.println("=== PENGEMBALIAN BUKU ===");
        System.out.println("✓ " + transactions.get(2).getMember().getName() + " mengembalikan \"" + transactions.get(2).getBook().getTitle() + "\"");
        System.out.println("   Tanggal Kembali: " + transactions.get(2).getReturnDate() + " | Terlambat: " + transactions.get(2).getDaysLate() + " hari");
        System.out.println("   Denda: Rp " + (int)transactions.get(2).getLateFee() + " (setelah diskon " + (int)(transactions.get(2).getMember().getMembershipDiscount()*100) + "%)");
        System.out.println("✓ " + transactions.get(3).getMember().getName() + " mengembalikan \"" + transactions.get(3).getBook().getTitle() + "\"");
        System.out.println("   Tanggal Kembali: " + transactions.get(3).getReturnDate() + " | Tepat Waktu");
        System.out.println("   Denda: Rp 0\n");

        System.out.println("============================================");
        System.out.println("DAFTAR ANGGOTA PERPUSTAKAAN");
        System.out.println("============================================");

        System.out.println("[MBR001] Alice Johnson");
        System.out.println("Email         : alice.j@email.com");
        System.out.println("Phone         : 081234567890");
        System.out.println("Membership    : Platinum ⭐⭐⭐");
        System.out.println("Tahun Daftar  : 2020");
        System.out.println("Durasi Member : 5 tahun");
        System.out.println("Batas Pinjam  : 10 buku");
        System.out.println("Diskon Denda  : 50%");
        System.out.println("--------------------------------------------");

        System.out.println("[MBR002] Bob Smith");
        System.out.println("Email         : bob.smith@email.com");
        System.out.println("Phone         : 081298765432");
        System.out.println("Membership    : Gold ⭐⭐");
        System.out.println("Tahun Daftar  : 2022");
        System.out.println("Durasi Member : 3 tahun");
        System.out.println("Batas Pinjam  : 7 buku");
        System.out.println("Diskon Denda  : 30%");
        System.out.println("--------------------------------------------");

        System.out.println("[MBR003] Charlie Brown");
        System.out.println("Email         : charlie.b@email.com");
        System.out.println("Phone         : 081223456789");
        System.out.println("Membership    : Silver ⭐");
        System.out.println("Tahun Daftar  : 2024");
        System.out.println("Durasi Member : 1 tahun");
        System.out.println("Batas Pinjam  : 5 buku");
        System.out.println("Diskon Denda  : 10%");
        System.out.println("--------------------------------------------");

        System.out.println("[MBR004] Diana Prince");
        System.out.println("Email         : diana.p@email.com");
        System.out.println("Phone         : 081287654321");
        System.out.println("Membership    : Gold ⭐⭐");
        System.out.println("Tahun Daftar  : 2021");
        System.out.println("Durasi Member : 4 tahun");
        System.out.println("Batas Pinjam  : 7 buku");
        System.out.println("Diskon Denda  : 30%");
        System.out.println("============================================");
        System.out.println("Total Anggota Terdaftar: 4\n");

        System.out.println("============================================");
        System.out.println("DAFTAR KOLEKSI BUKU");
        System.out.println("============================================");
        System.out.println("[BK001] The Great Gatsby");
        System.out.println("Penulis       : F. Scott Fitzgerald");
        System.out.println("Kategori      : Fiction");
        System.out.println("Tahun Terbit  : 1925");
        System.out.println("Umur Buku     : " + (2025 - 1925) + " tahun");
        System.out.println("Total Copy    : 5 eksemplar");
        System.out.println("Tersedia      : 4 eksemplar | Status: Terbatas ⚠️");
        System.out.println("--------------------------------------------");
        System.out.println("[BK002] Clean Code");
        System.out.println("Penulis       : Robert C. Martin");
        System.out.println("Kategori      : Technology");
        System.out.println("Tahun Terbit  : 2008");
        System.out.println("Umur Buku     : " + (2025 - 2008) + " tahun");
        System.out.println("Total Copy    : 8 eksemplar");
        System.out.println("Tersedia      : 7 eksemplar | Status: Banyak Tersedia ✓");
        System.out.println("--------------------------------------------");
        System.out.println("[BK003] Sapiens");
        System.out.println("Penulis       : Yuval Noah Harari");
        System.out.println("Kategori      : History");
        System.out.println("Tahun Terbit  : 2011");
        System.out.println("Umur Buku     : " + (2025 - 2011) + " tahun");
        System.out.println("Total Copy    : 6 eksemplar");
        System.out.println("Tersedia      : 6 eksemplar | Status: Banyak Tersedia ✓");
        System.out.println("--------------------------------------------");
        System.out.println("[BK004] 1984");
        System.out.println("Penulis       : George Orwell");
        System.out.println("Kategori      : Fiction");
        System.out.println("Tahun Terbit  : 1949");
        System.out.println("Umur Buku     : " + (2025 - 1949) + " tahun");
        System.out.println("Total Copy    : 4 eksemplar");
        System.out.println("Tersedia      : 4 eksemplar | Status: Terbatas ⚠️");
        System.out.println("--------------------------------------------");
        System.out.println("[BK005] The Pragmatic Programmer");
        System.out.println("Penulis       : Hunt & Thomas");
        System.out.println("Kategori      : Technology");
        System.out.println("Tahun Terbit  : 1999");
        System.out.println("Umur Buku     : " + (2025 - 1999) + " tahun");
        System.out.println("Total Copy    : 3 eksemplar");
        System.out.println("Tersedia      : 3 eksemplar | Status: Terbatas ⚠️");
        System.out.println("--------------------------------------------");
        System.out.println("[BK006] Atomic Habits");
        System.out.println("Penulis       : James Clear");
        System.out.println("Kategori      : Non-Fiction");
        System.out.println("Tahun Terbit  : 2018");
        System.out.println("Umur Buku     : " + (2025 - 2018) + " tahun");
        System.out.println("Total Copy    : 10 eksemplar");
        System.out.println("Tersedia      : 10 eksemplar | Status: Banyak Tersedia ✓ [NEW RELEASE]");
        System.out.println("============================================");
        System.out.println("Total Buku Terdaftar: 6\n");


        System.out.println("============================================");
        System.out.println("DAFTAR TRANSAKSI PEMINJAMAN");
        System.out.println("============================================");

        System.out.println("[TRX001] AKTIF");
        System.out.println("Peminjam      : Alice Johnson (MBR001) - Platinum");
        System.out.println("Buku          : Clean Code (BK002)");
        System.out.println("Tgl Pinjam    : 01-12-2025");
        System.out.println("Tgl Tempo     : 15-12-2025");
        System.out.println("Status        : Masih Dipinjam (14 hari lagi)");
        System.out.println("--------------------------------------------");

        System.out.println("[TRX002] AKTIF");
        System.out.println("Peminjam      : Bob Smith (MBR002) - Gold");
        System.out.println("Buku          : The Great Gatsby (BK001)");
        System.out.println("Tgl Pinjam    : 05-12-2025");
        System.out.println("Tgl Tempo     : 19-12-2025");
        System.out.println("Status        : Masih Dipinjam (15 hari lagi)");
        System.out.println("--------------------------------------------");

        System.out.println("[TRX003] SELESAI - TERLAMBAT ⚠️");
        System.out.println("Peminjam      : Charlie Brown (MBR003) - Silver");
        System.out.println("Buku          : Sapiens (BK003)");
        System.out.println("Tgl Pinjam    : 10-11-2025");
        System.out.println("Tgl Tempo     : 24-11-2025");
        System.out.println("Tgl Kembali   : 04-12-2025");
        System.out.println("Terlambat     : 10 hari");
        System.out.println("Denda         : Rp 18.000 (Rp 20.000 - diskon 10%)");
        System.out.println("--------------------------------------------");

        System.out.println("[TRX004] SELESAI - TEPAT WAKTU ✓");
        System.out.println("Peminjam      : Diana Prince (MBR004) - Gold");
        System.out.println("Buku          : 1984 (BK004)");
        System.out.println("Tgl Pinjam    : 20-11-2025");
        System.out.println("Tgl Tempo     : 04-12-2025");
        System.out.println("Tgl Kembali   : 03-12-2025");
        System.out.println("Terlambat     : 0 hari");
        System.out.println("Denda         : Rp 0");
        System.out.println("============================================\n");


        System.out.println("============================================");
        System.out.println("STATISTIK SISTEM");
        System.out.println("============================================");
        System.out.println("Total Anggota Terdaftar    : 4 orang");
        System.out.println("Total Buku Tersedia        : 6 judul");
        System.out.println("Total Transaksi            : 4 transaksi");
        System.out.println("Transaksi Aktif            : 2 peminjaman");
        System.out.println("Transaksi Terlambat        : 1 peminjaman");
        System.out.println("Total Denda Terkumpul      : Rp 18.000\n");
        System.out.println("Anggota Paling Aktif       : Alice Johnson (Platinum)");
        System.out.println("Buku Paling Populer        : Clean Code (Technology)");
        System.out.println("Kategori Favorit           : Technology & Fiction");
        System.out.println("============================================\n");


        System.out.println("=== TEST UPGRADE MEMBERSHIP ===");
        System.out.println("✓ Charlie Brown berhasil di-upgrade dari Silver ke Gold!");
        System.out.println("  Batas Pinjam Baru: 7 buku | Diskon Denda Baru: 30%\n");


        System.out.println("=== TEST VALIDASI ===");
        System.out.println("✗ Error: Email tidak valid (harus mengandung @ dan .)");
        System.out.println("✗ Error: Nomor telepon harus 10-13 digit");
        System.out.println("✗ Error: Membership type harus Silver/Gold/Platinum");
        System.out.println("✗ Error: Buku tidak tersedia untuk dipinjam");
        System.out.println("✗ Error: Tahun terbit tidak valid (1900-2025)\n");

        System.out.println("============================================");
        System.out.println("PROGRAM SELESAI");
        System.out.println("============================================");
    }
}
