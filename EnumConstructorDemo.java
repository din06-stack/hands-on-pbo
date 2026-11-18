enum AccountType {
    SAVINGS("SA", 0.025),
    CREDIT("CR", 0.0),
    DEPOSIT("DP", 0.045);

    private String code;
    private double interestRate;

    AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() {
        return code;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

public class EnumConstructorDemo {
    public static void main(String[] args) {

        System.out.println("Daftar Tipe Akun Bank");

        for (AccountType type : AccountType.values()) {
            System.out.println("Nama: " + type.name());
            System.out.println("Kode: " + type.getCode());
            System.out.println("Suku Bunga: "
                    + (type.getInterestRate() * 100) + "%");
            System.out.println("----------------------");
        }
    }
}
