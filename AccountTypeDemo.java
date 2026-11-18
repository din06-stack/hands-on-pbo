enum AccountType {
    SAVINGS {
        @Override
        public String toString() {
            return "Akun Tabungan";
        }
    },
    CREDIT {
        @Override
        public String toString() {
            return "Akun Kredit";
        }
    },
    DEPOSIT {
        @Override
        public String toString() {
            return "Akun Deposito";
        }
    }
}

class Account {
    private AccountType type;

    public Account(AccountType type) {
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }
}

public class AccountTypeDemo {
    public static void main(String[] args) {

        System.out.println("Daftar Tipe Akun:");

        for (AccountType type : AccountType.values()) {
            System.out.println(type.name() + " : " + type);
        }

        Account account = new Account(AccountType.DEPOSIT);

        System.out.println("\nTipe akun yang dipilih: "
                + account.getType());
    }
}
