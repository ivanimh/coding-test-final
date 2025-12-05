import java.time.LocalDate;

public class Member {
    private String memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private int registrationYear;
    private String membershipType;

    private static int idCounter = 0;
    private static int totalMembers = 0;

    public Member(String name, String email, String phoneNumber, int registrationYear, String membershipType) {
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setRegistrationYear(registrationYear);
        setMembershipType(membershipType);
        this.memberId = String.format("MBR%03d", ++idCounter);
        totalMembers++;
    }

    public void displayInfoCompact() {
        System.out.println("[" + memberId + "] " + name);
        System.out.println("Email         : " + email);
        System.out.println("Phone         : " + phoneNumber);
        System.out.println("Membership    : " + membershipType + membershipStars());
        System.out.println("Tahun Daftar  : " + registrationYear);
        System.out.println("Durasi Member : " + getMembershipDuration() + " tahun");
        System.out.println("Batas Pinjam  : " + getMaxBorrowLimit() + " buku");
        System.out.println("Diskon Denda  : " + (int) (getMembershipDiscount() * 100) + "%");
        System.out.println("--------------------------------------------");
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getRegistrationYear() { return registrationYear; }
    public String getMembershipType() { return membershipType; }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) throw new IllegalArgumentException("Nomor telepon harus 10-13 digit");
        String digits = phoneNumber.replaceAll("\\D", "");
        if (digits.length() < 10 || digits.length() > 13) throw new IllegalArgumentException("Nomor telepon harus 10-13 digit");
        this.phoneNumber = digits;
    }

    public void upgradeMembership(String newType) {
        if (newType == null) throw new IllegalArgumentException("Membership type harus Silver/Gold/Platinum");
        newType = capitalize(newType);
        if (!isValidMembership(newType)) throw new IllegalArgumentException("Membership type harus Silver/Gold/Platinum");
        if (this.membershipType.equals(newType)) return;
        if (this.membershipType.equals("Silver") && (newType.equals("Gold") || newType.equals("Platinum"))) this.membershipType = newType;
        else if (this.membershipType.equals("Gold") && newType.equals("Platinum")) this.membershipType = newType;
    }

    public int getMaxBorrowLimit() {
        switch (membershipType) {
            case "Platinum": return 10;
            case "Gold": return 7;
            default: return 5;
        }
    }

    public int getMembershipDuration() {
        return LocalDate.now().getYear() - registrationYear;
    }

    public double getMembershipDiscount() {
        switch (membershipType) {
            case "Platinum": return 0.50;
            case "Gold": return 0.30;
            default: return 0.10;
        }
    }

    public static int getTotalMembers() { return totalMembers; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("nama tidak boleh kosong");
        this.name = name.trim();
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) throw new IllegalArgumentException("Email tidak valid (harus mengandung @ dan .)");
        this.email = email.trim();
    }

    public void setRegistrationYear(int registrationYear) {
        if (registrationYear < 2015 || registrationYear > 2025) throw new IllegalArgumentException("registrationYear harus antara 2015 - 2025");
        this.registrationYear = registrationYear;
    }

    public void setMembershipType(String membershipType) {
        if (membershipType == null) throw new IllegalArgumentException("Membership type harus Silver/Gold/Platinum");
        membershipType = capitalize(membershipType);
        if (!isValidMembership(membershipType)) throw new IllegalArgumentException("Membership type harus Silver/Gold/Platinum");
        this.membershipType = membershipType;
    }

    private static boolean isValidMembership(String t) {
        return "Silver".equals(t) || "Gold".equals(t) || "Platinum".equals(t);
    }

    private static String capitalize(String s) {
        if (s == null) return null;
        s = s.trim();
        if (s.length() == 0) return s;
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }

    private String membershipStars() {
        if ("Platinum".equals(membershipType)) return " ⭐⭐⭐";
        if ("Gold".equals(membershipType)) return " ⭐⭐";
        return " ⭐";
    }
}
